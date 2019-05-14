package com.example.happyhour.Games.Victor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.happyhour.Estructura.Games;
import com.example.happyhour.R;

public class Game3_1 extends AppCompatActivity {

    static int wallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3_1);

        wallpaper = getIntent().getIntExtra("wallpaper", 1);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Games.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("wallpaper", wallpaper);
        startActivity(intent);
    }
}
