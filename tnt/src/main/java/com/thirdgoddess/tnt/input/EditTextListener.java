package com.thirdgoddess.tnt.input;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * 监听EditText输入变化
 *
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-12-18 16:46
 */
public class EditTextListener {

    private EditText editText;

    public EditTextListener(EditText editText) {
        this.editText = editText;
    }

    public void change(final Change change) {
        if (editText != null) {
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    change.change(s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        }


    }

    public interface Change {
        void change(String text);
    }
}
