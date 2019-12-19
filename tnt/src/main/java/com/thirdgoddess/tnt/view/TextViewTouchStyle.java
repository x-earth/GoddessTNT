package com.thirdgoddess.tnt.view;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

/**
 * 设置TextView按下监听变换颜色
 *
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-12-19 10:14
 */
public class TextViewTouchStyle {

    /**
     * DrawableStyle
     *
     * @param textView
     * @param touchDrawable
     * @param canceDrawable
     */
    @SuppressLint("ClickableViewAccessibility")
    public void setTouchStyle(final TextView textView, final int touchDrawable, final int canceDrawable) {

        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                if (action == 2) {
                    textView.setBackgroundResource(touchDrawable);
                } else if (action == 1) {
                    textView.setBackgroundResource(canceDrawable);
                }
                return false;
            }
        });
    }
}
