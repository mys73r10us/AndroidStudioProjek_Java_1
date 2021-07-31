package com.example.uasmoop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activityLogin extends AppCompatActivity {
    DatabaseHelper db;
    Button login, register;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        username = (EditText)findViewById(R.id.username_txt);
        password = (EditText)findViewById(R.id.password_txt);
        login = (Button)findViewById(R.id.login_btn);
        register = (Button)findViewById(R.id.register_btn);

        //register
        register.setOnClickListener(v -> {
            Intent intentRegister = new Intent(activityLogin.this, activityRegister.class);
            startActivity(intentRegister);
            finish();
        });
        //login
        login.setOnClickListener(v -> {
            String strUsername = username.getText().toString();
            String strPassword = password.getText().toString();
            Boolean dahlogin = db.checklogin(strUsername, strPassword);
            if(dahlogin == true){
                Boolean updateSession = db.SessionUpgrade("ada", 1);
                if(updateSession == true){
                    Toast.makeText(getApplicationContext(), "Login Succes!", Toast.LENGTH_SHORT).show();
                    Intent mainIntent = new Intent(activityLogin.this, MainActivity.class);
                    mainIntent.putExtra("Username", strUsername);
                    startActivity(mainIntent);
                    finish();
                }
            }
            else{
                Toast.makeText(getApplicationContext(), "Login Failed!", Toast.LENGTH_SHORT).show();
            }

        });


    }
}