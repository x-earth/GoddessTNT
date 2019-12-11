package com.thirdgoddess.tnt.image;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import androidx.core.app.ActivityCompat;

/**
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-12-11 21:05
 */
public class ImageUtils {

    @SuppressLint("InlinedApi")
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};

    /**
     * @param context 上下文
     * @param bitmap  bitmap图片
     * @return
     */
    public static boolean saveBitmap(Context context, Bitmap bitmap) {
        getPermission(context);
        return save(bitmap, null, context);
    }

    /**
     * @param context 上下文
     * @param bitmap  bitmap图片
     * @param path    存储路径
     * @return
     */
    public static boolean saveBitmap(Context context, Bitmap bitmap, String path) {
        getPermission(context);
        return save(bitmap, path, context);
    }

    /**
     * @param context     上下文
     * @param bitmap      bitmap图片
     * @param path        存储路径
     * @param requestCode 返回状态码，动态申请权限回调
     * @return
     */
    public static boolean saveBitmap(Context context, Bitmap bitmap, String path, int requestCode) {
        getPermission(context, requestCode);
        return save(bitmap, path, context);
    }

    @SuppressLint("SdCardPath")
    private static boolean save(Bitmap bitmap, String path, Context context) {
        try {
            File filePic;
            if (path == null) {
                filePic = new File("/sdcard/photo/" + System.currentTimeMillis() + ".jpg");
            } else {
                filePic = new File(path);
            }

            if (!filePic.exists()) {
                filePic.getParentFile().mkdirs();
                filePic.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(filePic);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + path)));

            return ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        } catch (IOException ignored) {
            return false;
        }
    }

    private static void getPermission(Context context) {
        //申请读写权限
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) context, PERMISSIONS_STORAGE, 690);
            }
        }
    }

    private static void getPermission(Context context, int requestCode) {
        //申请读写权限
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions((Activity) context, PERMISSIONS_STORAGE, requestCode);
            }
        }
    }


}
