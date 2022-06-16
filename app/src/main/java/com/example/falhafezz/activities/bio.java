package com.example.falhafezz.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

;


import com.example.falhafezz.Adapter.SherAdapter;
import com.example.falhafezz.R;
import com.example.falhafezz.model.Sher;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class bio extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    SherAdapter adapter;
    List<Sher> shers;
ImageView backward;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bio);


        backward=findViewById(R.id.imageView3);
        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(bio.this, MainActivity.class);
                startActivity(intent);
            }
        });














        recyclerView = findViewById(R.id.BioRV);
        shers = new ArrayList<>();


        adapter = new SherAdapter(getApplicationContext(), shers);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(com.example.falhafezz.network.bio.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        com.example.falhafezz.network.bio bioApi = retrofit.create(com.example.falhafezz.network.bio.class);
        Call<List<Sher>> call = bioApi.getShers();
        call.enqueue(new Callback<List<Sher>>() {
            @Override
            public void onResponse(Call<List<Sher>> call, Response<List<Sher>> response) {
                if (response.isSuccessful()) {
                    shers.clear();
                    shers.addAll(response.body());
                    //Toast.makeText(Biography_of_poets.this, "" + poets.get(0).getName(), Toast.LENGTH_SHORT).show();
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Sher>> call, Throwable t) {
                Toast.makeText(bio.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });

    }
}