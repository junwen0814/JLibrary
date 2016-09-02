package com.junwen.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.junwen.jlibrary.JBitmapUtils;
import com.junwen.utils.junmaster.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView viewById = (ImageView) findViewById(R.id.activity_img);
        if (viewById != null) {
            viewById.setImageDrawable(JBitmapUtils.getFilletDrawable(getApplicationContext(), R.drawable.ic_chat_voice_rcd_cancel));
        }
    }
}
