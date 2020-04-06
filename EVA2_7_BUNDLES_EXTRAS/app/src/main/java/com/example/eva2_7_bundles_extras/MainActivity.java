package com.example.eva2_7_bundles_extras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {
    Button btnLanzar;
    EditText edtTxtDatos;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLanzar = findViewById(R.id.btnLanzar);
        edtTxtDatos = findViewById(R.id.edtTxtDatos);
        btnLanzar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String cade = edtTxtDatos.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("EL_BUNDLE", cade);
        bundle.putInt("EL_ENTERO", 10);

        intent = new Intent(this,SecondaryActivity.class);
        intent.putExtra("DATOS",cade);
        intent.putExtra("DATILLOS",11.5);
        intent.putExtras(bundle);

        startActivity(intent);
    }

}
