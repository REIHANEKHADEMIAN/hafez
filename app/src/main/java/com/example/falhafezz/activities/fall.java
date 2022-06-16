package com.example.falhafezz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.falhafezz.R;
import com.example.falhafezz.model.Fall;
import com.example.falhafezz.network.fallapi;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fall extends AppCompatActivity {

    TextView poetry, number;
     ImageView back;
    String random_string = "";
    TextView textView;

    ImageView again;





    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fall);

        poetry = findViewById(R.id.Poetry);
        number = findViewById(R.id.number_ghazal);


        back=findViewById(R.id.imageView2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fall.this, MainActivity.class);
                startActivity(intent);
            }
        });


        textView=findViewById(R.id.textView7);
        again = findViewById(R.id.imageView);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFaal();

            }
        });




        getFaal();

        int random_string_length = 5;
        String[] all_characters = {
                "همه چیز درست خواهد شد نگران نباش \n"
        };
        int all_characters_length = all_characters.length;

        int min = 0;
        int max = all_characters_length-1;



        Random r = new Random();
        int random_number = r.nextInt(max - min + 1) + min;
        String random_character = all_characters[random_number];
        random_string = random_string + random_character;












    }


    private void getFaal() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(fallapi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        fallapi falApi = retrofit.create(fallapi.class);
        Call<Fall> call = falApi.getFall();
        call.enqueue(new Callback<Fall>() {
            @Override
            public void onResponse(Call<Fall> call, Response<Fall> response) {
                if (response.isSuccessful()) {
                    Fall fall = response.body();
                    number.setText(fall.getTitle());
                    poetry.setText(fall.getPlainText());
                    textView.setText(random_string);








                }
            }

            @Override
            public void onFailure(Call<Fall> call, Throwable t) {
                Toast.makeText(fall.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });
    }
}