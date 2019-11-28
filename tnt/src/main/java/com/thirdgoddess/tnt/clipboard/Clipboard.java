package com.thirdgoddess.tnt.clipboard;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;

/**
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-11-28 16:18
 */
public class Clipboard {

    /**
     * 剪贴板赋值
     * Clipboard assignment
     *
     * @param context
     * @param text
     */
    public static void putClipboard(Context context, String text) {
        ClipboardManager systemService = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (systemService != null) {
            systemService.setPrimaryClip(ClipData.newPlainText("lable", text));
        } else {
            throw new NullPointerException("ClipboardManager = null");
        }
    }

    /**
     * 剪贴板赋值
     * Clipboard assignment
     *
     * @param context
     * @param lable
     * @param text
     */
    public static void putClipboard(Context context, String lable, String text) {
        ClipboardManager systemService = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (systemService != null) {
            systemService.setPrimaryClip(ClipData.newPlainText(lable, text));
        } else {
            throw new NullPointerException("ClipboardManager = null");
        }
    }

    /**
     * 获取贴板内容
     * Get board content
     *
     * @param context
     * @return
     */
    public static String getClipboard(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        assert clipboardManager != null;
        if (!clipboardManager.hasPrimaryClip())
            return null;
        ClipData clipData = clipboardManager.getPrimaryClip();
        ClipDescription clipDescription = clipboardManager.getPrimaryClipDescription();
        assert clipDescription != null;
        assert clipData != null;
        return clipData.getItemAt(0).getText().toString();
    }

}
