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
import java.net.URL;
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
    private static final int IMAGE_WIDTH = 120;
    private static final int IMAGE_HEIGHT = 40;
    private static final int IMAGE_PADDING = 20;

    /**
     * 验证码长度
     * */
    private static final int CAPTCHA_LENGTH = 4;

    /**
     * 干扰横线数量
     * */
    private  static final int MIN_LINE_NUMBER = 4;
    private static final int MAX_LINE_NUMBER = 10;

    /**
     * 色彩范围, 255为白色，颜色太浅
     */
    private static final int COLOR_RANGE = 225;

    /**
     * 字体路径
     */
    private static final String[] FONTS_PATH = {
            "/fonts/JetBrainsMono-Regular.ttf",
            "/fonts/Pineapple-Grass.ttf",
            "fonts/Rhetoric-Book.ttf"
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

    public CaptchaServiceImpl() {
        initialize();
    }

    /**
     * 加载字体
     * */
    private static void initialize() {
        // 内部字体
        FONT_LIST.add(new Font(Font.DIALOG, Font.PLAIN, 1));
        FONT_LIST.add(new Font(Font.SANS_SERIF, Font.PLAIN, 1));
        FONT_LIST.add(new Font(Font.SERIF, Font.PLAIN, 1));
        FONT_LIST.add(new Font(Font.MONOSPACED, Font.PLAIN, 1));

        // 自定义字体
        LOGGER.info("根路径: {}", System.class.getResource("/"));
        for (String path : FONTS_PATH) {
            URL url = System.class.getResource(path);
            LOGGER.info("字体路径: {} -> {}", path, url);
            if (url != null) {
                try {
                    FONT_LIST.add(loadFont(url.getPath()));
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
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, IMAGE_WIDTH, IMAGE_HEIGHT);

        // 生成验证码
        byte[] captcha = new byte[CAPTCHA_LENGTH];
        for (int i=0; i < CAPTCHA_LENGTH; i++) {
            captcha[i] = randomCharacter();
        }

        // 缓存验证码
        String captchaString = new String(captcha);
        CAPTCHA_CACHE.put(uuid, captchaString);
        LOGGER.info("生成验证码: {} -> {}", uuid, captchaString);

        // 绘制验证码
        for (int i=0; i < CAPTCHA_LENGTH; i++) {
            // 随机字体及颜色
            graphics.setColor(randomColor());
            graphics.setFont(randomFont());
            graphics.drawBytes(captcha, i, 1,
                    i * (IMAGE_WIDTH - IMAGE_PADDING) / CAPTCHA_LENGTH + IMAGE_PADDING / 2,
                    IMAGE_HEIGHT - RANDOM.nextInt(10) - 5);
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
