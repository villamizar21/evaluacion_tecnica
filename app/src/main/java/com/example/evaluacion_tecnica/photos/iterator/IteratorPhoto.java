package com.example.evaluacion_tecnica.photos.iterator;

import android.util.Log;

import com.example.evaluacion_tecnica.photos.model.PhotosModel;
import com.example.evaluacion_tecnica.photos.interfaces.InterfacePhoto;
import com.example.evaluacion_tecnica.remote.ApiService;
import com.example.evaluacion_tecnica.utils.Global;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IteratorPhoto implements InterfacePhoto.iterator {

    InterfacePhoto.presenter presenter;

    public IteratorPhoto(InterfacePhoto.presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getPhotos(int id) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Global.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService myApi = retrofit.create(ApiService.class);
        Call<ArrayList<PhotosModel>> call = myApi.getPhotos(id);
        call.enqueue(new Callback<ArrayList<PhotosModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PhotosModel>> call, Response<ArrayList<PhotosModel>> response) {
                if (response.isSuccessful())
                    presenter.responsePhoto(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<PhotosModel>> call, Throwable t) {
                Log.e("","error "+ t.getMessage());
            }
        });
    }
}
