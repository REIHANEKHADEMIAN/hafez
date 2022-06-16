package com.example.falhafezz.network;
import com.example.falhafezz.model.Sher;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface bio {

    String BASE_URL = "https://ganjgah.ir/api/ganjoor/";

    @GET("shers")
    Call<List<Sher>> getShers();
}