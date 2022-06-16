package com.example.falhafezz.network;

import com.example.falhafezz.model.Fall;

import retrofit2.Call;
import retrofit2.http.GET;

public interface fallapi {

    String BASE_URL = "https://ganjgah.ir/api/ganjoor/hafez/";

    @GET("fall")
    Call<Fall> getFall();
}
