package com.example.eva2_3_sms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Intent inSMS;
    Button btn1;
    EditText edttxttel;
    EditText edttxtmsj;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        edttxttel = findViewById(R.id.edttxttel);
        edttxtmsj = findViewById(R.id.edttxtmsj);

        btn1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String stTel = "smsto:"+edttxttel.getText().toString();
                        String sms = edttxtmsj.getText().toString();
                        inSMS = new Intent(Intent.ACTION_SENDTO, Uri.parse(stTel));
                        inSMS.putExtra("sms_body", sms);
                        startActivity(inSMS);
                    }
                }
        );
    }
}
