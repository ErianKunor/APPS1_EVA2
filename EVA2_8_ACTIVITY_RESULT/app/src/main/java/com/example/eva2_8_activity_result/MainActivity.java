package com.example.eva2_8_activity_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSelRest, btnCont, btnImg, btnAud, btnVid;
    Intent inSelRest, inSelCont, inSelImg, inSelAud, inSelVid;

    final int restaurante = 1000;
    final int contactos = 2000;
    final int imagenes = 3000;
    final int audio = 4000;
    final int video = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSelRest = findViewById(R.id.btnSelRest);
        inSelRest = new Intent(this, MyDataActivity.class);

        btnCont = findViewById(R.id.btnCont);
        inSelCont = new Intent(Intent.ACTION_PICK, android.provider.ContactsContract.Contacts.CONTENT_URI);

        btnImg = findViewById(R.id.btnImg);
        inSelImg = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        btnAud = findViewById(R.id.btnAud);
        inSelAud = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);

        btnVid = findViewById(R.id.btnVid);
        inSelVid = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);

        btnSelRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inSelRest,restaurante);
            }
        });

        btnCont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inSelCont, contactos);
            }
        });

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inSelImg, imagenes);
            }
        });

        btnAud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inSelAud, audio);
            }
        });

        btnImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(inSelVid, video);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case restaurante://actividad que devolvio datos
                if(resultCode == Activity.RESULT_OK){//respuesta
                    //ACCION A EJECUTAR
                    data.getStringExtra("DATOS");
                    Toast.makeText(this,data.getStringExtra("DATOS"),Toast.LENGTH_LONG).show();}
                else{
                    Toast.makeText(this, "CANCELADO", Toast.LENGTH_SHORT).show();
                }
                break;

            case contactos:
                if(resultCode == Activity.RESULT_OK){
                    String sContact = data.getDataString();
                    Toast.makeText(this,sContact,Toast.LENGTH_LONG).show();
                    Log.wtf("CONTACTO", sContact);
                }else{
                    Toast.makeText(this, "CANCELADO", Toast.LENGTH_SHORT).show();
                }
                break;

            case video:
                if(resultCode == Activity.RESULT_OK){
                    String sVid = data.getDataString();
                    Log.wtf("VIDEO", sVid);
                    Toast.makeText(this, sVid, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "CANCELADO", Toast.LENGTH_SHORT).show();
                }
                break;

            case audio:
                if(resultCode == Activity.RESULT_OK){
                    String sAud = data.getDataString();
                    Log.wtf("AUDIO", sAud);
                    Toast.makeText(this, sAud, Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "CANCELADO", Toast.LENGTH_SHORT).show();
                }
                break;

        }
    }
}
