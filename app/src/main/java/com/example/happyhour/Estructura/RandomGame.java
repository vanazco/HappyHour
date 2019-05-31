package com.example.happyhour.Estructura;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.happyhour.Games.Adri.NumGame;
import com.example.happyhour.Games.Adri.ShapeGame;
import com.example.happyhour.Games.Sebas.Pintar.ChooseDraw;
import com.example.happyhour.Games.Sebas.Puzzle.ChoosePuzzle;
import com.example.happyhour.Games.Victor.CardGame1;
import com.example.happyhour.Games.Victor.CardGame2;
import com.example.happyhour.Games.Victor.LetterGame;
import com.example.happyhour.R;

public class RandomGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        int level = (int )(Math.random() * 2 + 1);
        int random = (int )(Math.random() * 6 + 1);

        Intent intent;

        if(random == 1){
            intent = new Intent(RandomGame.this, NumGame.class);
            startActivity(intent);
        }else if(random == 2){
                intent = new Intent(RandomGame.this, ShapeGame.class);
                startActivity(intent);
        }else if(random == 3){
                intent = new Intent(RandomGame.this, LetterGame.class);
                startActivity(intent);
        }else if(random == 4){
            if(level == 1){
                intent = new Intent(RandomGame.this, CardGame1.class);
                startActivity(intent);
            }else{
                intent = new Intent(RandomGame.this, CardGame2.class);
                startActivity(intent);
            }
        }else if(random == 5){
            intent = new Intent(RandomGame.this, ChoosePuzzle.class);
            startActivity(intent);
        }else if(random == 6){
            intent = new Intent(RandomGame.this, ChooseDraw.class);
            startActivity(intent);
        }
    }
}
