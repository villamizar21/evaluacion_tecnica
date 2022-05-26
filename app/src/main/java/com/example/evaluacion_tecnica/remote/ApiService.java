package com.example.evaluacion_tecnica.remote;

import com.example.evaluacion_tecnica.comments.model.Comments;
import com.example.evaluacion_tecnica.users.model.Users;
import com.example.evaluacion_tecnica.photos.model.PhotosModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/posts")
    @Headers("Content-Type:application/json;charset=UTF-8")
    Call<ArrayList<Users>> getUsers();

    @GET("/posts/{id}/comments")
    Call<ArrayList<Comments>> getComments(@Path("id") int id);

    @GET("/posts/{id}/photos")
    Call<ArrayList<PhotosModel>> getPhotos(@Path("id") int id);
}
