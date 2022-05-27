package com.example.evaluacion_tecnica.comments.iterator;

import android.util.Log;

import com.example.evaluacion_tecnica.comments.interfaces.InterfaceComments;
import com.example.evaluacion_tecnica.comments.model.Comments;
import com.example.evaluacion_tecnica.remote.ApiService;
import com.example.evaluacion_tecnica.utils.Global;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IteratorComment implements InterfaceComments.iterator {

    InterfaceComments.presenter presenter;

    public IteratorComment(InterfaceComments.presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getComments(int id) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Global.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService myApi = retrofit.create(ApiService.class);
        Call<ArrayList<Comments>> call = myApi.getComments(id);
        call.enqueue(new Callback<ArrayList<Comments>>() {
            @Override
            public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                if (response.isSuccessful())
                    presenter.responseComment(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {
                Log.e("","error " + t.getMessage());
                presenter.respuestaErronea(t.getMessage());
            }
        });

    }
}
