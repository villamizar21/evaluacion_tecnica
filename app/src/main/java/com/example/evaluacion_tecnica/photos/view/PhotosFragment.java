package com.example.evaluacion_tecnica.photos.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.evaluacion_tecnica.R;
import com.example.evaluacion_tecnica.photos.adapter.AdapterPhotos;
import com.example.evaluacion_tecnica.photos.interfaces.InterfacePhoto;
import com.example.evaluacion_tecnica.photos.model.PhotosModel;
import com.example.evaluacion_tecnica.photos.presenter.PresenterPhoto;

import java.util.List;


public class PhotosFragment extends Fragment implements InterfacePhoto.view {

    InterfacePhoto.presenter presenter;
    RecyclerView recycler;
    ProgressDialog dialog;
    AdapterPhotos adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_photos, container, false);

        mapearElementos(view);

        return view;
    }

    private void mapearElementos(View view) {
        recycler = view.findViewById(R.id.recycler);
        presenter = new PresenterPhoto(this);
        Bundle bundle = getArguments();
        if (bundle != null) {
            int id = bundle.getInt("id");
            dialog(getContext());
            presenter.getPhotos(id);
        }
    }

    @Override
    public void responsePhoto(List<PhotosModel> photos) {
        dialog.dismiss();
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 1));
        recycler.setHasFixedSize(true);
        adapter = new AdapterPhotos(photos, getContext());
        recycler.setAdapter(adapter);
    }

    private void dialog(Context context) {
        dialog = new ProgressDialog(getContext());
        dialog.setMessage("Obteniendo Photos...");
        dialog.setCancelable(false);
        dialog.show();
    }
}
