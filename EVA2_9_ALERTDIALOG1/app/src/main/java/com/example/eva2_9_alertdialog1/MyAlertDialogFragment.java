package com.example.eva2_9_alertdialog1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Date;

public class MyAlertDialogFragment extends android.app.DialogFragment {
    public static MyAlertDialogFragment newInstance(int titulo){
        MyAlertDialogFragment frag = new MyAlertDialogFragment();
        Bundle args = new Bundle();
        args.putInt("titulo",titulo);
        args.putString("mensaje", "Linea 1 del mensaje\nLinea 2 del mensaje");

        frag.setArguments(args);
        return frag;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        int titulo = getArguments().getInt("titulo");
        String mensaje = getArguments().getString("mensaje");

        return new AlertDialog.Builder(getActivity())
                .setTitle(titulo)
                .setMessage(mensaje)

                .setPositiveButton("Positivo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        ((MainActivity) getActivity()).doPositiveClick(new Date());
                    }
                })

                .setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        ((MainActivity) getActivity()).doNegativeClick(new Date());
                    }
                })

                .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        ((MainActivity) getActivity()).doNeutralClick(new Date());
                    }
                })
                .create();
    };
}
