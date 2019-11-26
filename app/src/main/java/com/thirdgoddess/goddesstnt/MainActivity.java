package com.thirdgoddess.goddesstnt;

import android.os.Bundle;
import android.util.Log;

import com.thirdgoddess.tnt.encryption.Md5;
import com.thirdgoddess.tnt.encryption.SHA;
import com.thirdgoddess.tnt.view.DipPx;
import com.thirdgoddess.tnt.viewpager_adapter.ViewPagerFragmentAdapter;
import com.thirdgoddess.tnt.viewpager_adapter.ViewPagerFragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //Sha常用加密
        String sha1 = SHA.toSHA1("#");
        String sha224 = SHA.toSHA224("#");
        String sha256 = SHA.toSHA256("#");
        String sha384 = SHA.toSHA384("#");
        String sha512 = SHA.toSHA512("#");

    }

    private void initView() {

    }
}
