package com.example.hometutoring;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class  MainActivity extends AppCompatActivity {
    private Button login, reg;
    private EditText editText1, editText2;
    private String username, userpwd;
    private final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (Button) findViewById(R.id.btnLogin);
        reg = (Button) findViewById(R.id.btnReg);
        editText1 = (EditText) findViewById(R.id.editName);
        editText2 = (EditText) findViewById(R.id.editPwd);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, successActivity.class);
                String name = editText1.getText().toString();
                String pwd = editText2.getText().toString();
                if (name.equals(username) && pwd.equals(userpwd)) {
                    intent.putExtra("name", name);
                    intent.putExtra("pwd", pwd);
                    startActivity(intent);
                }
                if (!name.equals(username)) {
                    Toast.makeText(MainActivity.this, "抱歉，用户名不对", Toast.LENGTH_LONG).show();
                }
                if (!pwd.equals(userpwd)) {
                    Toast.makeText(MainActivity.this, "抱歉，密码不对", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==REQUEST_CODE){
            String name=data.getStringExtra("name");
            String pwd=data.getStringExtra("pwd");
            editText1.setText("您的用户名是："+name);
            editText2.setText("您的密  码是 ："+pwd);
            username=editText1.getText().toString();
            userpwd=editText2.getText().toString();
        }
    }

}
