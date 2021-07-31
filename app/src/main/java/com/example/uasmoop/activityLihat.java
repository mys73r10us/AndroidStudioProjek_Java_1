package com.example.uasmoop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activityLihat extends AppCompatActivity {
    TextView jenisRoda, engine, gear;
    String roda, jenis, Enginetxt, Geartxt;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        jenisRoda = (TextView)findViewById(R.id.RodaJenis);
        engine = (TextView)findViewById(R.id.Engine);
        gear = (TextView)findViewById(R.id.Gear);

        back = (Button)findViewById(R.id.back_btn);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(activityLihat.this, activityForm.class);
                startActivity(intentBack);
                finish();
            }
        });

        Intent JR = getIntent();
        roda = JR.getStringExtra("Roda");
        jenis = JR.getStringExtra("Jenis");
        jenisRoda.setText(roda+"\n"+jenis);

        if(roda.equals("Roda Dua")){
            Enginetxt = "  Buka penutup mesin. Cek kondisi mesin. Ganti oli mesin.";
            engine.setText(Enginetxt);
        }
        else if(roda.equals("Roda Empat")){
            Enginetxt = "  Buka kompartemen mesin. Cek kondisi mesin. Ganti oli mesin. Cek pendingin";
            engine.setText(Enginetxt);
        }else{engine.setText("Error Input!");}


        if(jenis.equals("Sport Bike")){
            Geartxt = "  Cek kabel kopling. Cek mekanisme gear change.";
            gear.setText(Geartxt);
        }
        else if(jenis.equals("Moped")){
            Geartxt = "  Cek sistem CVT.";
            gear.setText(Geartxt);
        }
        else if(jenis.equals("SUV")){
            Geartxt = "  Cek mekanisme 4WD. Cek kabel kopling. Cek mekanisme gear change.";
            gear.setText(Geartxt);
        }
        else if(jenis.equals("Sedan")){
            Geartxt = "  Cek sistem gear change.";
            gear.setText(Geartxt);
        }


    }
}