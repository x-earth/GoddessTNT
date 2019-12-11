package com.thirdgoddess.tnt.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.thirdgoddess.tnt.R;

/**
 * @author ThirdGoddess
 * @email ofmyhub@gmail.com
 * @Github https://github.com/ThirdGoddess
 * @date :2019-12-11 16:32
 */
public class LoadDialog {

    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    private ProgressBar progressBar;
    private TextView viewText;
    private LinearLayout root;
    private LinearLayout viewRoot;

    private boolean isCance;

    private boolean canceStatus = false;

    public LoadDialog(Context context) {
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
            View inflate = LayoutInflater.from(context).inflate(R.layout.load_dialog, null, false);
            viewRoot = inflate.findViewById(R.id.viewRoot);
            root = inflate.findViewById(R.id.root);
            progressBar = inflate.findViewById(R.id.progressBar);
            viewText = inflate.findViewById(R.id.text);

            if (DialogTool.getBackgroundColor() != null) {
                root.setBackgroundColor(Color.parseColor(DialogTool.getBackgroundColor()));
            }

            if (DialogTool.isTextGone()) {
                viewText.setVisibility(View.GONE);
            } else {
                if (DialogTool.isDialogTextStyle()) {
                    viewText.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                }

                if (DialogTool.getDialogTextColor() != null) {
                    viewText.setTextColor(Color.parseColor(DialogTool.getDialogTextColor()));
                }

                if (DialogTool.getTextSize() != 0f) {
                    viewText.setTextSize(DialogTool.getTextSize());
                }

                if (DialogTool.getText() != null) {
                    viewText.setText(DialogTool.getText());
                }
            }

            if (DialogTool.isDialogCance()) {
                viewRoot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!canceStatus) {
                            alertDialog.dismiss();
                        }

                    }
                });
            }

            builder.setView(inflate);
            builder.setCancelable(DialogTool.isDialogCance());

        }
    }

    public void setCancelable(boolean isCance) {
        canceStatus = true;
        this.isCance = isCance;
        builder.setCancelable(isCance);
        if (isCance) {
            viewRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alertDialog.dismiss();
                }
            });
        }
    }


    public void dismiss() {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }

    }

    public void show() {
        if (builder != null) {
            alertDialog = builder.show();
            alertDialog.getWindow().setBackgroundDrawableResource(R.color.transparent);
        }
    }

    public void setText(String text) {
        viewText.setText(text);
    }

    public void setTextGone(boolean gone) {
        if (gone) {
            viewText.setVisibility(View.GONE);
        } else {
            viewText.setVisibility(View.VISIBLE);
        }

    }
}
