package com.example.uasmoop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    Button logout, form;
    TextView welcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        logout = (Button)findViewById(R.id.logout_btn);

        Boolean checkSession = db.SessionCheck("ada");
        if(checkSession == false){
            Intent loginIntent = new Intent(MainActivity.this, activityLogin.class);
            startActivity(loginIntent);
            finish();
        }

        welcome = (TextView)findViewById(R.id.textView);
        String nama = getIntent().getExtras().getString("Username");
        welcome.setText("Met Datang di UAS MOOP, "+nama);

        form = (Button)findViewById(R.id.form_btn);
        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent formIntent = new Intent(MainActivity.this, activityForm.class);
                startActivity(formIntent);
                finish();
            }
        });

        //logut
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updtSession = db.SessionUpgrade("kosong", 1);
                if(updtSession == true){
                    Toast.makeText(getApplicationContext(),"Logout Succes!", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(MainActivity.this, activityLogin.class);
                    startActivity(loginIntent);
                    finish();
                }
            }
        });
    }
}