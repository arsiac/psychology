package top.arsiac.psychology.utils.common;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * <p>工具类</p>
 *
 * @author arsiac
 * @version 1.0
 * @since  2021/2/21
 */
public class CommonTool {

    private CommonTool() {}
    /**
     * 字符集合
     * */
    private static final String CHARACTER_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*():;',<.>/?-_=+[{]}|`~";

    /**
     * 随机数
     * */
    private static final Random RANDOM = new Random();

    /**
     * <p>生成随机字符串</p>
     *
     * @param length 长度 > 0
     * @return 随机字符串
     */
    public static String randomString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = RANDOM.nextInt(CHARACTER_SET.length());
            stringBuilder.append(CHARACTER_SET.charAt(number));
        }
        return stringBuilder.toString();

    }


    /**
     * <p>加密</p>
     *
     * @param source 源
     * @param salt   盐
     * @return 加密结果
     */
    public static String encrypt(String source, String salt) {
        byte[] digest;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest((source + salt).getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            return "";
        }

        return new BigInteger(1, digest).toString(16);
    }
}
