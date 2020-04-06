package com.example.eva2_9_alertdialog1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView txtMsg;
    Button btnAlertDialog, btnCustomDialog, btnDialogFragment;
    String msg = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = findViewById(R.id.txtMsg);
        btnAlertDialog= findViewById(R.id.btnAlertDialog);
        btnCustomDialog = findViewById(R.id.btnCustomDialog);
        btnDialogFragment = findViewById(R.id.btnDialogFragment);

        btnAlertDialog.setOnClickListener(this);
        btnCustomDialog.setOnClickListener(this);
        btnDialogFragment.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == btnAlertDialog.getId()){
            showMyAlertDialog(this);
        }
        if (v.getId() == btnCustomDialog.getId()){
            showCustomDialog(R.layout.custom_dialog_layout);
        }
        if (v.getId() == btnDialogFragment.getId()){
            showMyAlertDialogFragment(this);
        }
    }

    private void showMyAlertDialog(MainActivity mainActivity) {
        new AlertDialog.Builder(this)
                .setTitle("Terminator")
                .setMessage("¿Estás seguro de que quieres salir?")
                .setPositiveButton("Sí", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        msg = "Sí" + Integer.toString(whichButton);
                        txtMsg.setText(msg);
                    }
                })
                .setNeutralButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int whichButton) {
                                msg = "Cancelar " + Integer.toString(whichButton);
                                txtMsg.setText(msg);
                            }
                        })
                .setNeutralButton("No",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int whichButton) {
                                msg = "No" + Integer.toString(whichButton);
                                txtMsg.setText(msg);
                            }
                        })
                        .create()
                        .show();
    }

    private void showCustomDialog(int custom_dialog_layout) {
        final Dialog customDialog = new Dialog(this);
        customDialog.setTitle("Custom Dialog Title");
        customDialog.setContentView(R.layout.custom_dialog_layout);
        ((TextView) customDialog.findViewById(R.id.sd_txtVw1)).setText("\nLinea del mensaje 1\nLinea del mensaje 2\n"+"Descartar: Botón de retroseso, Cerrar, o toca fuera");
        final EditText sd_txtInputData = (EditText) customDialog.findViewById(R.id.sd_edtTxt1);
        ((Button) customDialog.findViewById(R.id.sd_btnClose)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtMsg.setText(sd_txtInputData.getText().toString());
                customDialog.dismiss();
            }
        });
        customDialog.show();
    }

    private void showMyAlertDialogFragment(MainActivity mainActivity) {
        DialogFragment dialogFragment = MyAlertDialogFragment.newInstance(R.string.titulo);

        dialogFragment.show(getFragmentManager(), "TAG_MYDIALOGFRAGMENT1");
    }

    public void doPositiveClick(Date time){
        txtMsg.setText("Positivo - DialogFragment elegido el:" + time);
    }
    public void doNegativeClick(Date time){
        txtMsg.setText("Negativo - DialogFragment elegido el: "+time);
    }
    public void doNeutralClick(Date time){
        txtMsg.setText("Neutral - DialogFragment elegido el: "+time);
    }
}
