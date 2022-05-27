package com.example.evaluacion_tecnica.users.iterator;

import android.util.Log;

import com.example.evaluacion_tecnica.users.interfaces.InterfacesUser;
import com.example.evaluacion_tecnica.users.model.Users;
import com.example.evaluacion_tecnica.users.presenter.PresenterUser;
import com.example.evaluacion_tecnica.remote.ApiService;
import com.example.evaluacion_tecnica.utils.Global;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class IteratorUser implements InterfacesUser.iterator {

    InterfacesUser.presenter presenter;

    public IteratorUser(PresenterUser presenterUser) {
        this.presenter = presenterUser;
    }

    @Override
    public void getDatos() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Global.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService myApi = retrofit.create(ApiService.class);
        Call<ArrayList<Users>> call = myApi.getUsers();

        call.enqueue(new Callback<ArrayList<Users>>() {
            @Override
            public void onResponse(Call<ArrayList<Users>> call, Response<ArrayList<Users>> response) {
                if (response.isSuccessful())
                    presenter.respuesta(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Users>> call, Throwable t) {
                Log.e("", "error " + t.getMessage());
                presenter.respuestaErronea(t.getMessage());
            }
        });


    }
}
