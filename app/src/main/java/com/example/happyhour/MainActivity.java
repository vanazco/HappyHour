package com.example.happyhour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.happyhour.Estructura.Game_mode;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //random
        final int wallpaperRandom = (int) (Math.random() * 5 + 1);
        //Initialize wallpaper to load all the R.drawable
        final WallPaper wallPaper = new WallPaper();

        ImageView imageView = findViewById(R.id.fondoPantalla);
        //Get the resource ID
        imageView.setImageResource(wallPaper.getWallpaper().get(wallpaperRandom));

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Game_mode.class);
                intent.putExtra("wallpaper", wallPaper.getWallpaper().get(wallpaperRandom));
                startActivity(intent);
            }
        });

    }
}
