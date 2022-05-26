package com.example.evaluacion_tecnica.users.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evaluacion_tecnica.R;
import com.example.evaluacion_tecnica.users.adapterUser.AdapterUser;
import com.example.evaluacion_tecnica.users.interfaces.InterfacesUser;
import com.example.evaluacion_tecnica.users.model.Users;
import com.example.evaluacion_tecnica.users.presenter.PresenterUser;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class UsersFragment extends Fragment implements InterfacesUser.view {

    InterfacesUser.presenter presenter;
    ProgressDialog pDialog;
    AdapterUser adapterUser;
    RecyclerView recycler;
    TextInputEditText buscar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);

        mapearElementos(view);

        return view;
    }

    private void mapearElementos(View view) {
        presenter = new PresenterUser(this);
        dialog(getContext());
        recycler = view.findViewById(R.id.recycler);
        buscar = view.findViewById(R.id.buscar);
        presenter.getDatos();
    }

    @Override
    public void respuesta(List<Users> users) {
        pDialog.dismiss();
        adapterUser = new AdapterUser(users, getActivity());
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recycler.setAdapter(adapterUser);
        buscar(users);
    }

    private void dialog(Context context) {
        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Obteniendo Usuarios...");
        pDialog.setCancelable(false);
        pDialog.show();
    }

    private void buscar(List<Users> users) {
        buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filtrar(s.toString(), users);
            }
        });
    }

    private void filtrar(String s, List<Users> users) {
        ArrayList<Users> filtrar = new ArrayList<>();
        for (Users u : users) {
            if (u.getTitle().toLowerCase().contains(s.toLowerCase())) {
                filtrar.add(u);
            }
        }
        adapterUser.filtar(filtrar);
    }
}