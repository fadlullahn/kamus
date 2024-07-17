package com.example.kamus.Api;

import com.example.kamus.Model.Kamus.GetKamus;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("kamus.php")
    Call<GetKamus> getHeros();
}

