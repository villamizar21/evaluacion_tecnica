package com.example.evaluacion_tecnica.comments.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evaluacion_tecnica.R;
import com.example.evaluacion_tecnica.comments.adapter.AdapterComment;
import com.example.evaluacion_tecnica.comments.interfaces.InterfaceComments;
import com.example.evaluacion_tecnica.comments.presenter.PresenterComment;
import com.example.evaluacion_tecnica.comments.model.Comments;

import java.util.List;


public class CommentsFragment extends Fragment implements InterfaceComments.view {

    InterfaceComments.presenter presenter;
    ProgressDialog dialog;
    RecyclerView recycler;
    AdapterComment adapter;

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
    }

    private void dialog(Context context) {
        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Obteniendo Comentarios...");
        dialog.setCancelable(false);
        dialog.show();
    }
}