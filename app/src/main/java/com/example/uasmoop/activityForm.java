package com.example.uasmoop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class activityForm extends AppCompatActivity {
    Button lihat;
    Spinner spinnerJenisRoda, spinnerJenisKendaraan;
    ArrayList<String> arrayList_jenisRoda;
    ArrayAdapter<String> arrayAdapter_jenisRoda;

    ArrayList<String> arrayList_RodaDua, arrayList_RodaEmpat;
    ArrayAdapter<String> arrayAdapter_jenisKendaraan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        spinnerJenisRoda = (Spinner)findViewById(R.id.spinJenisRoda);
        spinnerJenisKendaraan = (Spinner)findViewById(R.id.spinJenisKendaraan);

        arrayList_jenisRoda = new ArrayList<>();
        arrayList_jenisRoda.add("Roda Dua");
        arrayList_jenisRoda.add("Roda Empat");

        arrayAdapter_jenisRoda = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_jenisRoda);
        spinnerJenisRoda.setAdapter(arrayAdapter_jenisRoda);

        arrayList_RodaDua = new ArrayList<>();
        arrayList_RodaDua.add("Moped");
        arrayList_RodaDua.add("Sport Bike");

        arrayList_RodaEmpat = new ArrayList<>();
        arrayList_RodaEmpat.add("SUV");
        arrayList_RodaEmpat.add("Sedan");

        spinnerJenisRoda.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    arrayAdapter_jenisKendaraan = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_RodaDua);
                }
                if(position == 1){
                    arrayAdapter_jenisKendaraan = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_item, arrayList_RodaEmpat);
                }
                spinnerJenisKendaraan.setAdapter(arrayAdapter_jenisKendaraan);

                lihat = (Button)findViewById(R.id.lihat_btn);
                lihat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String jenisRoda = spinnerJenisRoda.getSelectedItem().toString();
                        String jenisKendaraan = spinnerJenisKendaraan.getSelectedItem().toString();

                        Intent intentLihat = new Intent(activityForm.this, activityLihat.class);
                        intentLihat.putExtra("Roda", jenisRoda);
                        intentLihat.putExtra("Jenis", jenisKendaraan);
                        startActivity(intentLihat);
                        finish();
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }


}