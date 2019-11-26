package com.thirdgoddess.tnt.encryption;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA 加密
 * SHA encryption
 *
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-11-26 08:55
 */
public class SHA {

    private static MessageDigest messageDigest;
    private static char[] hexadecimalArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f'};

    public static String toSHA1(String clearText) {
        try {
            messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(clearText.getBytes(Charset.forName("UTF-8")));
            return toPassword();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }

    }

    public static String toSHA224(String clearText) {
        try {
            messageDigest = MessageDigest.getInstance("SHA224");
            messageDigest.update(clearText.getBytes(Charset.forName("UTF-8")));
            return toPassword();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String toSHA256(String clearText) {
        try {
            messageDigest = MessageDigest.getInstance("SHA256");
            messageDigest.update(clearText.getBytes(Charset.forName("UTF-8")));
            return toPassword();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String toSHA384(String clearText) {
        try {
            messageDigest = MessageDigest.getInstance("SHA384");
            messageDigest.update(clearText.getBytes(Charset.forName("UTF-8")));
            return toPassword();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static String toSHA512(String clearText) {
        try {
            messageDigest = MessageDigest.getInstance("SHA512");
            messageDigest.update(clearText.getBytes(Charset.forName("UTF-8")));
            return toPassword();
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }


    private static String toPassword() {
        byte[] md = messageDigest.digest();
        int j = md.length;
        char[] buf = new char[j * 2];
        int k = 0;
        for (byte byte0 : md) {
            buf[k++] = hexadecimalArr[byte0 >>> 4 & 0xf];
            buf[k++] = hexadecimalArr[byte0 & 0xf];
        }
        return new String(buf);
    }

}