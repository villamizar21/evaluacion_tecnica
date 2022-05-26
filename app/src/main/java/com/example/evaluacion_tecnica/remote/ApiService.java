package com.example.evaluacion_tecnica.remote;

import com.example.evaluacion_tecnica.model.Users;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {

    @GET("/posts")
    @Headers("Content-Type:application/json;charset=UTF-8")
    Call<ArrayList<Users>> getUsers();
}
