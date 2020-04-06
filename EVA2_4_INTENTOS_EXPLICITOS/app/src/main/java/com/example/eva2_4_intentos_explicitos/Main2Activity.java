package com.example.eva2_4_intentos_explicitos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    Intent inMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //inMain = new Intent(this, MainActivity.class);

    }

    public void onClick(View v){
        finish();
        //startActivity(inMain);
    }
}
