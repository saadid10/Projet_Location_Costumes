package com.example.costumerental.network;

import com.example.costumerental.models.AuthResponse; // Need to create this model
import com.example.costumerental.models.LoginRequest; // Need to create this model
import com.example.costumerental.models.RegisterRequest; // Need to create this
import com.example.costumerental.models.Costume;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @POST("login")
    Call<AuthResponse> login(@Body LoginRequest request);

    @POST("register")
    Call<AuthResponse> register(@Body RegisterRequest request);

    @GET("costumes")
    Call<List<Costume>> getCostumes();

    @GET("costumes/{id}")
    Call<Costume> getCostumeDetail(@Path("id") int id);
}
