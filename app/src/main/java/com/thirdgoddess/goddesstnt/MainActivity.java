package com.thirdgoddess.goddesstnt;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.thirdgoddess.tnt.image.ImageUtils;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @SuppressLint("SdCardPath")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //模拟数据源
        imageView.setImageResource(R.mipmap.xm);

        //模拟Bitmap
        Bitmap bitmap = ((BitmapDrawable) ((ImageView) imageView).getDrawable()).getBitmap();

        //上下文, bitmap
        boolean b = ImageUtils.saveBitmap(this, bitmap);

        //上下文, bitmap, 路径和文件名
        boolean b1 = ImageUtils.saveBitmap(this, bitmap, "/sdcard/pic/helloworld.jpg");

        //上下文, bitmap, 路径和文件名, 返回状态码(动态申请权限时返回的状态码，默认返回690,可用于回调 onRequestPermissionsResult 方法 )
        boolean b2 = ImageUtils.saveBitmap(this, bitmap, "/sdcard/pic/helloworld.jpg", 123);

        /*以上都是返回布尔类型，返回true代表保存成功，false代表保存失败*/

        if (b) {
            Toast.makeText(this, "保存成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "保存失败", Toast.LENGTH_SHORT).show();
        }

    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.imageView);
    }

}
