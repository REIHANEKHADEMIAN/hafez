package com.example.falhafezz.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.falhafezz.R;

public class MainActivity extends AppCompatActivity {
                                     ImageView fall,bio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fall = findViewById(R.id.imageView7);
        bio = findViewById(R.id.imageView5);

        fall.setOnClickListener(v->  {
            Intent intent = new Intent(MainActivity.this, fall.class);
            startActivity(intent);

        });

        bio.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, bio.class);
            startActivity(i);

        });

    }
}