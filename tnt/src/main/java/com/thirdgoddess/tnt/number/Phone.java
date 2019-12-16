package com.thirdgoddess.tnt.number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-12-16 16:13
 */
public class Phone {

    /**
     * 判断手机号是否正确
     *
     * @param phoneNumber
     * @return
     */
    public static boolean isCorrectness(String phoneNumber) {
        if (phoneNumber.length() != 11) {
            return false;
        } else {
            /**
             * 移动号段正则表达式
             */
            String pat1 = "^((13[4-9])|(147)|(15[0-2,7-9])|(178)|(18[2-4,7-8]))\\d{8}|(1705)\\d{7}$";
            /**
             * 联通号段正则表达式
             */
            String pat2 = "^((13[0-2])|(145)|(15[5-6])|(176)|(18[5,6]))\\d{8}|(1709)\\d{7}$";
            /**
             * 电信号段正则表达式
             */
            String pat3 = "^((133)|(153)|(177)|(18[0,1,9])|(149))\\d{8}$";
            /**
             * 虚拟运营商正则表达式
             */
            String pat4 = "^((170))\\d{8}|(1718)|(1719)\\d{7}$";

            Pattern pattern1 = Pattern.compile(pat1);
            Matcher match1 = pattern1.matcher(phoneNumber);
            boolean isMatch1 = match1.matches();
            if (isMatch1) {
                return true;
            }

            Pattern pattern2 = Pattern.compile(pat2);
            Matcher match2 = pattern2.matcher(phoneNumber);
            boolean isMatch2 = match2.matches();
            if (isMatch2) {
                return true;
            }

            Pattern pattern3 = Pattern.compile(pat3);
            Matcher match3 = pattern3.matcher(phoneNumber);
            boolean isMatch3 = match3.matches();
            if (isMatch3) {
                return true;
            }

            Pattern pattern4 = Pattern.compile(pat4);
            Matcher match4 = pattern4.matcher(phoneNumber);
            return match4.matches();
        }
    }

}
