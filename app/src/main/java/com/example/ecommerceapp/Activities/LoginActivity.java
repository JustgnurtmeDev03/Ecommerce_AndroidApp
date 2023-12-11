package com.example.ecommerceapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecommerceapp.R;

public class LoginActivity extends AppCompatActivity {
    private EditText userEdt, passEdt;
    private Button loginBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
    }

    private void initView() {
        userEdt= findViewById(R.id.editTextText);
        passEdt = findViewById(R.id.editTextPassword);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> {
                if(userEdt.getText().toString().isEmpty() || passEdt.getText().toString().isEmpty()){
                    Toast.makeText(LoginActivity.this, "Làm ơn hãy điền vào tài khoản và mật khẩu của bạn", Toast.LENGTH_SHORT).show();
                }else if(userEdt.getText().toString().equals("trungthpt") && passEdt.getText().toString().equals("trung123")){
                    startActivities(new Intent[]{new Intent(LoginActivity.this, MainActivity.class)});
                }else{
                    Toast.makeText(LoginActivity.this, "Tài khoản hoặc mật khẩu của bạn không đúng", Toast.LENGTH_SHORT).show();
                }
        });
    }
}