package com.example.evaluacion_tecnica.utils.dialogoError;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.evaluacion_tecnica.R;

public class DialogoError extends DialogFragment {

    TextView informacion;
    Button aceptar;
    String mensaje;

    public DialogoError(String mensaje) {
        this.mensaje = mensaje;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return crearDialogoFragmentoconfiguracion();
    }

    @Override
    public void onStart() {
        super.onStart();

        if (getDialog() == null)
            return;

        int dialogWidth = getResources().getDimensionPixelSize(R.dimen.tamaño_dialogo_Width_dialogoC);
        int dialogHeight = getResources().getDimensionPixelSize(R.dimen.tamaño_dialogo_Height_diaslogoC);
        getDialog().getWindow().setLayout(dialogWidth, dialogHeight);
    }

    private AlertDialog crearDialogoFragmentoconfiguracion() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.dialogo_error, null);
        builder.setView(v);

        mapearElemento(v);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });

        return builder.create();
    }

    private void mapearElemento(View view) {
        informacion = view.findViewById(R.id.txtInformation);
        aceptar = view.findViewById(R.id.btn_aceptar);
        escribirDialogo(mensaje);
    }

    private void escribirDialogo(String mensaje) {
        informacion.setText(mensaje);
    }

}
