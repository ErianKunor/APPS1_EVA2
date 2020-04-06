package com.example.eva2_5_contactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Intent intCont;
    Button btnCont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCont = findViewById(R.id.btnCont);
        btnCont.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String misContactos = "content://contacts/people";
                        Intent intCont = new Intent(Intent.ACTION_VIEW, Uri.parse(misContactos));
                        startActivity(intCont);
                    }
                }
        );

    }


}
