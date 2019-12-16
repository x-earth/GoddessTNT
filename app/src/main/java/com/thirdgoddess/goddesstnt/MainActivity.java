package com.thirdgoddess.goddesstnt;

import android.os.Bundle;
import android.util.Log;

import com.thirdgoddess.tnt.number.Phone;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean correctness = Phone.isCorrectness("12001679430");
        Log.d("mylog-number", correctness + "");


    }


}
