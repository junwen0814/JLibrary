package com.junwen.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.junwen.utils.junmaster.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onItemClick(View view) {
//        Log.e("onItemClick", "编码后0:" + );
//        Log.e("onItemClick", "编码后1:" + new String(Base64.decode(strBase64, Base64.DEFAULT)));
    }
}
