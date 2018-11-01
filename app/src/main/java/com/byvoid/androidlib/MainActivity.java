package com.byvoid.androidlib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.byvoid.lib.AndroidLib;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidLib.init(this);
    }
}
