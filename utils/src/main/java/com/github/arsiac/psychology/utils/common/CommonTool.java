package com.github.arsiac.psychology.utils.common;

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
 * @since 2021/2/21
 */
public class CommonTool {

    private CommonTool() {
    }

    /**
     * 字符集合
     */
    private static final char[] CHARACTER_SET = {
            'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l',
            'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', 'A', 'B', 'C', 'D',
            'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', '0', '1',
            '2', '3', '4', '5', '6', '7',
            '8', '9', '!', '@', '#', '$',
            '%', '^', '&', '*', '(', ')',
            ':', ';', ',', '<', '.', '>',
            '/', '?', '-', '_', '=', '+',
            '[', '{', ']', '}', '|', '`',
            '~'
    };
    /**
     * 随机数
     */
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
            stringBuilder.append(CHARACTER_SET[RANDOM.nextInt(CHARACTER_SET.length)]);
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

    /**
     * <p>字符串是否为null/空白</p>
     *
     * @param value 字符串
     * @return 是否为空白
     */
    public static boolean isBlank(String value) {
        // 不为null
        if (value != null) {
            // 是否全为空白字符
            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) != ' ' &&
                        value.charAt(i) != '\n' &&
                        value.charAt(i) != '\t') {
                    return false;
                }
            }
        }

        return true;
    }
    /**
     * <p>字符串是否不为null/空白</p>
     *
     * @param value 字符串
     * @return 是否不为空白
     */
    public static boolean isNotBlank(String value) {
        return !isBlank(value);
    }
}
