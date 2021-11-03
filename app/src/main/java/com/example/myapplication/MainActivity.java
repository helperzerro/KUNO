package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.example.myapplication.helper.Helper;

public class MainActivity extends AppCompatActivity{
    private Helper db = new Helper(this);

    private EditText inputPassword;
    private CheckBox ShowPass;
    private EditText user, pass;
    private TextView gagalL,textRegister;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user=findViewById(R.id.emailLogin);
        pass=findViewById(R.id.passwordLogin);
        btnLogin=findViewById(R.id.buttonLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey = user.getText().toString();
                String passwordKey = pass.getText().toString();
                if (usernameKey.equals("w")&&passwordKey.equals("w")){
                    Intent intent = new Intent(MainActivity.this,LandingPageActivity.class);
                    startActivity(intent);
                }else{
                    gagalL=findViewById(R.id.gagalLogin);
                    gagalL.setText("Email / Password Salah");
                }
            }
        });

        textRegister=findViewById(R.id.textViewRegister);
        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });


        inputPassword = findViewById(R.id.passwordLogin);
        ShowPass = findViewById(R.id.showPass);
        //Set onClickListener, untuk menangani kejadian saat Checkbox diklik
        ShowPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ShowPass.isChecked()){
                    //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan
                    inputPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else {
                    //Jika tidak, maka password akan di sembuyikan
                    inputPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }

}