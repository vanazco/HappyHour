package com.example.happyhour.Estructura;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.happyhour.Games.Adri.Game1_1;
import com.example.happyhour.Games.Adri.Game1_2;
import com.example.happyhour.Games.Adri.Game2_1;
import com.example.happyhour.Games.Adri.Game2_2;
import com.example.happyhour.Games.Sebas.Pintar.Pintar;
import com.example.happyhour.Games.Sebas.Puzzle.ChoosePuzzle;
import com.example.happyhour.Games.Victor.CardGame1;
import com.example.happyhour.Games.Victor.CardGame2;
import com.example.happyhour.Games.Victor.LetterGame;
import com.example.happyhour.R;

public class Random extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        final int wallpaper = getIntent().getIntExtra("wallpaper", 1);

        int level = (int )(Math.random() * 2 + 1);
        int random = (int )(Math.random() * 6 + 1);

        Intent intent;

        if(random == 1){
            if(level == 1){
                intent = new Intent(Random.this, Game1_1.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }else{
                intent = new Intent(Random.this, Game1_2.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }
        }else if(random == 2){
            if(level == 1){
                intent = new Intent(Random.this, Game2_1.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }else{
                intent = new Intent(Random.this, Game2_2.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }
        }else if(random == 3){
                intent = new Intent(Random.this, LetterGame.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
        }else if(random == 4){
            if(level == 1){
                intent = new Intent(Random.this, CardGame1.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }else{
                intent = new Intent(Random.this, CardGame2.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }
        }else if(random == 5){
            intent = new Intent(Random.this, ChoosePuzzle.class);
            intent.putExtra("wallpaper", wallpaper);
            startActivity(intent);
        }else if(random == 6){
            intent = new Intent(Random.this, Pintar.class);
            intent.putExtra("wallpaper", wallpaper);
            startActivity(intent);
        }
    }
}
