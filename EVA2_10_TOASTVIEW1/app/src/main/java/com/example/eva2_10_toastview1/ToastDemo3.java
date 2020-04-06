package com.example.eva2_10_toastview1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ToastDemo3 extends AppCompatActivity {
EditText txtCoordX, txtCoordY;
TextView txtCap;
Button btnShowToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCap = findViewById(R.id.txtCaption);
        txtCoordX = findViewById(R.id.txtCoordX);
        txtCoordY = findViewById(R.id.txtCoordY);
        btnShowToast = findViewById(R.id.btnShowToast);

        int dpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        txtCap.append("\nScreen size= "+ width + "x" + height + "Densidad = " + dpi + "dpi");
        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast toast = Toast.makeText(getApplicationContext(),
                "Aquí",Toast.LENGTH_LONG);

                    toast.setGravity(
                            Gravity.CENTER,
                            Integer.valueOf(txtCoordX.getText().toString()),
                            Integer.valueOf(txtCoordY.getText().toString()));
                            toast.show();
                            
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
