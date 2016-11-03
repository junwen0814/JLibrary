package com.junwen.utils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.junwen.jlibrary.JCheckPasswordUtils;
import com.junwen.utils.junmaster.R;

public class MainActivity extends AppCompatActivity {

    private EditText password;
    private ImageView img;
    private ImageView imgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        password = (EditText) findViewById(R.id.activity_main);
        img = (ImageView) findViewById(R.id.activity_main_img);
        imgs = (ImageView) findViewById(R.id.activity_main_imgs);
    }

    public void onCheckPass(View view) {
        JCheckPasswordUtils.LEVEL passwordLevel = JCheckPasswordUtils.getPasswordLevel(password.getText().toString().trim());
        if (passwordLevel == JCheckPasswordUtils.LEVEL.EASY) {
            Toast.makeText(getApplicationContext(), "简单", Toast.LENGTH_SHORT).show();
        } else if (passwordLevel == JCheckPasswordUtils.LEVEL.MIDIUM) {
            Toast.makeText(getApplicationContext(), "中级", Toast.LENGTH_SHORT).show();
        } else if (passwordLevel == JCheckPasswordUtils.LEVEL.STRONG) {
            Toast.makeText(getApplicationContext(), "安全高", Toast.LENGTH_SHORT).show();
        } else if (passwordLevel == JCheckPasswordUtils.LEVEL.VERY_STRONG) {
            Toast.makeText(getApplicationContext(), "非常高", Toast.LENGTH_SHORT).show();
        } else if (passwordLevel == JCheckPasswordUtils.LEVEL.EXTREMELY_STRONG) {
            Toast.makeText(getApplicationContext(), "极高", Toast.LENGTH_SHORT).show();
        }
    }

}
