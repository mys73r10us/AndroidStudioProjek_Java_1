package com.example.uasmoop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activityRegister extends AppCompatActivity {
    DatabaseHelper db;
    Button login, register;
    EditText username, password, confpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        username = (EditText)findViewById(R.id.usernameReg_txt);
        password = (EditText)findViewById(R.id.passwordReg_txt);
        confpassword = (EditText)findViewById(R.id.passwordConfReg_txt);
        login = (Button)findViewById(R.id.loginReg_btn);
        register = (Button)findViewById(R.id.registerReg_btn);

        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(activityRegister.this, activityLogin.class);
                startActivity(intentLogin);
                finish();
            }
        });

        //register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                String strConfPassword = confpassword.getText().toString();
                if(strPassword.equals(strConfPassword)){
                    Boolean daftar = db.insertUser(strUsername, strPassword);
                    if(daftar == true){
                        Toast.makeText(getApplicationContext(), "Register Succes!", Toast.LENGTH_SHORT).show();
                        Intent intentLogin = new Intent(activityRegister.this, activityLogin.class);
                        startActivity(intentLogin);
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Register Failed!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Password does not match!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}