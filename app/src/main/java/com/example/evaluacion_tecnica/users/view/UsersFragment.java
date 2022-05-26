package com.example.evaluacion_tecnica.users.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evaluacion_tecnica.R;
import com.example.evaluacion_tecnica.users.adapterUser.AdapterUser;
import com.example.evaluacion_tecnica.users.interfaces.InterfacesUser;
import com.example.evaluacion_tecnica.users.model.Users;
import com.example.evaluacion_tecnica.users.presenter.PresenterUser;

import java.util.List;

public class UsersFragment extends Fragment implements InterfacesUser.view {

    InterfacesUser.presenter presenter;
    ProgressDialog pDialog;
    AdapterUser adapterUser;
    RecyclerView recycler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_users, container, false);
        presenter = new PresenterUser(this);
        dialog(getContext());
        recycler = view.findViewById(R.id.recycler);
        presenter.getDatos();
        return view;
    }

    @Override
    public void respuesta(List<Users> users) {
        pDialog.dismiss();
        adapterUser = new AdapterUser(users,getActivity());
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recycler.setAdapter(adapterUser);
    }

    private void dialog(Context context) {
        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Obteniendo Usuarios...");
        pDialog.setCancelable(false);
        pDialog.show();
    }
}