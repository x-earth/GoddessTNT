package com.thirdgoddess.tnt.dialog;

/**
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-12-11 17:20
 */
public class DialogUtils {
    private static String backgroundColor = null;
    private static String progressBarColor = null;
    private static String dialogTextColor = null;
    private static boolean dialogTextStyle = false;
    private static boolean dialogCance = false;
    private static float textSize = 0f;
    private static String progressText = null;
    private static boolean isTextGone = false;

    public static String getBackgroundColor() {
        return backgroundColor;
    }

    public static String getDialogTextColor() {
        return dialogTextColor;
    }

    public static boolean isDialogTextStyle() {
            return dialogTextStyle;
    }

    public static boolean isDialogCance() {
        return dialogCance;
    }

    public static float getTextSize() {
        return textSize;
    }

    public static String getText() {
        return progressText;
    }

    public static boolean isTextGone() {
        return isTextGone;
    }

    public static class DialogSetting {

        public DialogSetting setBackgroundColor(String color) {
            backgroundColor = color;
            return this;
        }

        public DialogSetting setDialogTextColor(String color) {
            dialogTextColor = color;
            return this;
        }

        public DialogSetting setDialogTextStyle(boolean isBlod) {
            dialogTextStyle = isBlod;
            return this;
        }

        public DialogSetting setCancelable(boolean isCance) {
            dialogCance = isCance;
            return this;
        }

        public DialogSetting setTextSize(float size) {
            textSize = size;
            return this;
        }

        public DialogSetting setText(String text) {
            progressText = text;
            return this;
        }

        public DialogSetting setTextGone(boolean gone) {
            isTextGone = gone;
            return this;
        }

        public DialogUtils over() {
            return null;
        }

    }
}
