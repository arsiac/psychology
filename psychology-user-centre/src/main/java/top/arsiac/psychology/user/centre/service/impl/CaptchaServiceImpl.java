package top.arsiac.psychology.user.centre.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import top.arsiac.psychology.user.centre.service.CaptchaService;
import top.arsiac.psychology.utils.exception.PsychologyErrorCode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * <p>验证码服务实现</p>
 *
 * @author arsiac
 * @version 1.0
 * @since 2021/2/11
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {
    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(CaptchaServiceImpl.class);

    /**
     * 验证缓存
     * */
    private static final Map<Long, String> CAPTCHA_CACHE = new HashMap<>(64);

    /**
     * 图片大小
     */
    private static final int IMAGE_WIDTH = 100;
    private static final int IMAGE_HEIGHT = 40;

    /**
     * 验证码长度
     * */
    private static final int CAPTCHA_LENGTH = 4;

    /**
     * 干扰横线数量
     * */
    private  static final int MIN_LINE_NUMBER = 2;
    private static final int MAX_LINE_NUMBER = 5;

    /**
     * 色彩范围, 255为白色，颜色太浅
     */
    private static final int COLOR_RANGE = 225;

    /**
     * 白色
     */
    private static final Color WHITE = new Color(255, 255, 255);

    /**
     * 字体路径
     */
    private static final String[] FONTS_PATH = {
            "fonts/JetBrainsMono-Regular.ttf",
            "fonts/Pineapple-Grass.ttf",
            "fonts/HAPPY-DONUTS.ttf"
    };

    /**
     * 字体集
     */
    private static final List<Font> FONT_LIST = new ArrayList<>();

    /**
     * 随机数
     */
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    /**
     * 字符集, 去除 1 和 l
     */
    private static final byte[] CHARACTER_SET = {
            'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z',

            'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z',

            '0',      '2', '3', '4', '5',
            '6', '7', '8', '9'
    };

    /*
     * 加载字体
     * */
    static {
        // 内部字体
        FONT_LIST.add(new Font(Font.DIALOG, Font.PLAIN, 1));
        FONT_LIST.add(new Font(Font.SANS_SERIF, Font.PLAIN, 1));
        FONT_LIST.add(new Font(Font.SERIF, Font.PLAIN, 1));
        FONT_LIST.add(new Font(Font.MONOSPACED, Font.PLAIN, 1));

        // 自定义字体
        for (String path : FONTS_PATH) {
            String absolutePath = System.class.getResource(path).getPath();
            LOGGER.info("字体路径: {} -> {}", path, absolutePath);
            if (absolutePath != null) {
                try {
                    FONT_LIST.add(loadFont(absolutePath));
                } catch (Exception e) {
                    LOGGER.error("加载字体失败", e);
                }
            }
        }
    }

    /**
     * <p>加载字体</p>
     *
     * @param path 字体路径
     * @return 字体
     */
    private static Font loadFont(String path) {
        File file = new File(path);
        // 只加载存在的字体
        if (file.exists() && file.isFile() && file.canRead()) {
            try {
                return Font.createFont(Font.TRUETYPE_FONT, file);
            } catch (FontFormatException | IOException e) {
                throw PsychologyErrorCode.LOAD_FONT_ERROR.createException(e);
            }
        } else {
            throw PsychologyErrorCode.LOAD_FONT_ERROR.createException("文件不存在 或 不是文件 或 不可读");
        }
    }

    /**
     * <p>获取随机颜色</p>
     *
     * @return 颜色
     */
    private Color randomColor() {
        return new Color(
                RANDOM.nextInt(COLOR_RANGE),
                RANDOM.nextInt(COLOR_RANGE),
                RANDOM.nextInt(COLOR_RANGE)
        );
    }

    /**
     * <p>获取随机字体</p>
     *
     * @return 字体
     */
    private Font randomFont() {
        Font font = FONT_LIST.get(RANDOM.nextInt(FONT_LIST.size()));
        return font.deriveFont(
                // 0 normal; 1 粗体; 2 斜体; 3 粗斜
                RANDOM.nextInt(4),

                // 字体大小 [20,30)
                (float) (RANDOM.nextInt(10) + 20)
        );
    }

    /**
     * <p>获取随机字符</p>
     *
     * @return 字符
     */
    private byte randomCharacter() {
        return CHARACTER_SET[RANDOM.nextInt(CHARACTER_SET.length)];
    }

    @Override
    public BufferedImage generateCaptcha(long uuid) {
        // 创建图片缓冲区
        BufferedImage imageBuffer = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) imageBuffer.getGraphics();
        // 白色背景
        graphics.setColor(WHITE);
        graphics.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

        // 生成验证码
        byte[] captcha = new byte[CAPTCHA_LENGTH];
        for (int i=0; i < CAPTCHA_LENGTH; i++) {
            captcha[i] = randomCharacter();
        }

        // 缓存验证码
        CAPTCHA_CACHE.put(uuid, new String(captcha));

        // 绘制验证码
        for (int i=0; i < CAPTCHA_LENGTH; i++) {
            // 随机字体及颜色
            graphics.setColor(randomColor());
            graphics.setFont(randomFont());
            graphics.drawBytes(captcha, i, 1,
                    i * IMAGE_WIDTH / CAPTCHA_LENGTH + 3,
                    RANDOM.nextInt(7) + 3);
        }

        // 绘制横线
        final int lineNumber = RANDOM.nextInt(MAX_LINE_NUMBER - MIN_LINE_NUMBER) + MIN_LINE_NUMBER;
        for (int i=0; i<lineNumber; i++) {
            graphics.setColor(randomColor());
            graphics.drawLine(RANDOM.nextInt(IMAGE_WIDTH),
                    RANDOM.nextInt(IMAGE_HEIGHT),
                    RANDOM.nextInt(IMAGE_WIDTH),
                    RANDOM.nextInt(IMAGE_HEIGHT));
        }

        return imageBuffer;
    }

    @Override
    public boolean validate(long uuid, String code) {
        String captcha = CAPTCHA_CACHE.get(uuid);

        // 不存在该验证码
        if (captcha == null) {
            return false;
        }

        // 删除缓存
        CAPTCHA_CACHE.remove(uuid);

        return captcha.equals(code);
    }
}
