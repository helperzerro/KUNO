package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText user, pass,confirmpass;
    private TextView gagalR,textLogin;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        user=findViewById(R.id.emailRegister);
        pass=findViewById(R.id.passwordRegister);
        confirmpass=findViewById(R.id.confirmPasswordRegister);
        btnRegister=findViewById(R.id.buttonRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey = user.getText().toString();
                String passwordKey = pass.getText().toString();
                String confirmpasswordKey = confirmpass.getText().toString();
                gagalR=findViewById(R.id.gagalRegister);
                if (passwordKey.equals(confirmpasswordKey)&&!usernameKey.equals("")&&!passwordKey.equals("")&&!confirmpasswordKey.equals("")){
                    gagalR.setTextColor(Color.parseColor("#00FF00"));
                    gagalR.setText("Registrasi Berhasil");
                }else{
                    gagalR.setTextColor(Color.parseColor("#ff0000"));
                    gagalR.setText("Registrasi Gagal");
                }
            }
        });
        textLogin=findViewById(R.id.textViewLogin);
        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
