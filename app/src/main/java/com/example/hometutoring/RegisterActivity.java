package com.example.hometutoring;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private Button zcan;
    private EditText zceditext1, zcedittext2, zcedittext3;
    private static final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        zcan = (Button) findViewById(R.id.zcbtnReg);
        zceditext1 = (EditText) findViewById(R.id.zcedtName);
        zcedittext2 = (EditText) findViewById(R.id.zcedtPwd);
        zcedittext3 = (EditText) findViewById(R.id.zcedtRepwd);

        zcan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String name = zceditext1.getText().toString();
                String pwd = zcedittext2.getText().toString();
                String repwd = zcedittext3.getText().toString();
                if (!"".equals(pwd) && pwd.equals(repwd)) {
                    intent.putExtra("name", name);
                    intent.putExtra("pwd", pwd);
                    setResult(REQUEST_CODE, intent);
                    RegisterActivity.this.finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "密码输入不一致", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}

