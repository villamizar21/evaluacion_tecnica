package com.example.evaluacion_tecnica.comments.view;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evaluacion_tecnica.R;
import com.example.evaluacion_tecnica.comments.adapter.AdapterComment;
import com.example.evaluacion_tecnica.comments.interfaces.InterfaceComments;
import com.example.evaluacion_tecnica.comments.presenter.PresenterComment;
import com.example.evaluacion_tecnica.comments.model.Comments;
import com.example.evaluacion_tecnica.users.model.Users;
import com.example.evaluacion_tecnica.utils.dialogoError.DialogoError;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;


public class CommentsFragment extends Fragment implements InterfaceComments.view {

    InterfaceComments.presenter presenter;
    ProgressDialog dialog;
    RecyclerView recycler;
    AdapterComment adapter;
    TextInputEditText buscar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_comments, container, false);
        mapearElementos(view);
        return view;
    }

    private void mapearElementos(View view) {
        recycler = view.findViewById(R.id.recycler);
        buscar = view.findViewById(R.id.buscar);
        presenter = new PresenterComment(this);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int id = bundle.getInt("id");
            dialog(getContext());
            presenter.getComments(id);
        }
    }

    @Override
    public void responseComment(List<Comments> comments) {
        dialog.dismiss();
        LinearLayoutManager linear = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(linear);
        recycler.setHasFixedSize(true);
        adapter = new AdapterComment(comments);
        recycler.setAdapter(adapter);
        buscar(comments);
    }

    @Override
    public void respuestaErronea(String message) {
        DialogoError dialog = new DialogoError(message);
        dialog.show(getActivity().getSupportFragmentManager(), "DialogoError");
    }

    private void dialog(Context context) {
        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Obteniendo Comentarios...");
        dialog.setCancelable(false);
        dialog.show();
    }
    private void buscar(List<Comments> comments) {
        buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filtrar(s.toString(), comments);
            }
        });
    }

    private void filtrar(String s, List<Comments> comments) {
        ArrayList<Comments> filtrar = new ArrayList<>();
        for (Comments u : comments) {
            if (u.getBody().toLowerCase().contains(s.toLowerCase())) {
                filtrar.add(u);
            }
        }
        adapter.filtar(filtrar);
    }
}