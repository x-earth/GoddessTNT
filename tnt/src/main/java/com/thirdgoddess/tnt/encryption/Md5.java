package com.thirdgoddess.tnt.encryption;

import java.security.MessageDigest;

/**
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-11-22 18:55
 */
public class Md5 {

    /**
     * @param clearText 明文
     * @return String:Ciphered 密文
     */
    public static String toMd5(String clearText) {
        char[] hexadecimalArr = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        try {
            byte[] btInput = clearText.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(btInput);
            byte[] digest = messageDigest.digest();
            int j = digest.length;
            char[] chars = new char[j * 2];
            int k = 0;
            for (byte byte0 : digest) {
                chars[k++] = hexadecimalArr[byte0 >>> 4 & 0xf];
                chars[k++] = hexadecimalArr[byte0 & 0xf];
            }
            return new String(chars);
        } catch (Exception e) {
            return null;
        }
    }
}
