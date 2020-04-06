package com.example.eva2_8_activity_result;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MyDataActivity extends AppCompatActivity implements ListView.OnItemClickListener, View.OnClickListener{

    ListView lstVwRestaurantes;
    String[] aRestaurantes= {
            "Tacos Espino",
            "SHUGU",
            "Gorditas Lily",
            "Senor Camaron",
            "Taco-ntento",
            "Pizza Hut",
            "El Cabus",
            "SUBWAY",
            "Domino's Pizza",
            "Wendys"
    };

    Button btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_data);
        lstVwRestaurantes= findViewById(R.id.lstVwRestaurantes);
        lstVwRestaurantes.setOnItemClickListener(this);
        lstVwRestaurantes.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, aRestaurantes));
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Toast.makeText(this, aRestaurantes[position], Toast.LENGTH_SHORT).show();
        Intent inDatos = new Intent();
        inDatos.putExtra("DATOS", aRestaurantes[position]);
        setResult(Activity.RESULT_OK,inDatos);
        finish();
    }


    @Override
    public void onClick(View v) {
        setResult(Activity.RESULT_CANCELED);
        finish();
    }
}
