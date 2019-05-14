package com.example.happyhour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.happyhour.Estructura.GameMode;

public class HelpActivity extends AppCompatActivity {

    private static int wallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        wallpaper = getIntent().getIntExtra("wallpaper", 1);

        ImageView imageView = findViewById(R.id.fondoPantalla);
        //Get the resource ID
        imageView.setImageResource(wallpaper);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, GameMode.class);
        intent.putExtra("wallpaper", wallpaper);
        startActivity(intent);
    }
}
