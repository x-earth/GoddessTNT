package com.thirdgoddess.goddesstnt;

import android.os.Bundle;
import android.os.Handler;

import com.thirdgoddess.tnt.dialog.DialogTool;
import com.thirdgoddess.tnt.dialog.LoadDialog;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DialogTool dialogTool = new DialogTool.DialogSetting()
                .setDialogTextColor("#000000")//设置加载框字体颜色
                .setBackgroundColor(null)//设置背景颜色，默认是白色
                .setDialogTextStyle(true)//字体是否加粗
                .setTextSize(15f)//字体大小
                .setCancelable(false)//点击空白处是否停止加载
                .setText("加载中...")//加载提示文字
                .setTextGone(false)//是否隐藏文字
                .over();


        //创建Dialog
        final LoadDialog loadDialog = new LoadDialog(this);

        //点击空白处是否停止加载,这里的优先级最高
        loadDialog.setCancelable(true);

        //加载提示文字,这里的优先级最高
        loadDialog.setText("加载中...");

        //是否隐藏文字,这里的优先级最高
        loadDialog.setTextGone(true);

        //显示加载框
        loadDialog.show();

        //模拟6s后加载完成
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //关闭加载框
                loadDialog.dismiss();
            }
        }, 6000);
    }

}
