package com.example.happyhour.Estructura;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.happyhour.Games.Adri.Game1_1;
import com.example.happyhour.Games.Adri.Game1_2;
import com.example.happyhour.Games.Adri.Game2_1;
import com.example.happyhour.Games.Adri.Game2_2;
import com.example.happyhour.Games.Sebas.Game5_1;
import com.example.happyhour.Games.Sebas.Game5_2;
import com.example.happyhour.Games.Sebas.Game6_1;
import com.example.happyhour.Games.Sebas.Game6_2;
import com.example.happyhour.Games.Victor.Game3_1;
import com.example.happyhour.Games.Victor.Game3_2;
import com.example.happyhour.Games.Victor.Game4_1;
import com.example.happyhour.Games.Victor.Game4_2;


class Juego extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Intent intent2;

        int random = intent.getIntExtra("random",1);
        final int level = (int )(Math.random() * 2 + 1);

        if(random == 1){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game1_1.class);
                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game1_2.class);
                startActivity(intent2);
            }
        }else if(random == 2){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game2_1.class);
                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game2_2.class);
                startActivity(intent2);
            }
        }else if(random == 3){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game3_1.class);
                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game3_2.class);
                startActivity(intent2);
            }
        }else if(random == 4){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game4_1.class);
                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game4_2.class);
                startActivity(intent2);
            }
        }else if(random == 5){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game5_1.class);
                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game5_2.class);
                startActivity(intent2);
            }
        }else if(random == 6){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game6_1.class);
                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game6_2.class);
                startActivity(intent2);
            }
        }
    }
}
