package com.example.happyhour.Estructura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

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
import com.example.happyhour.R;

public class Juego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);

        Intent intent2;

        int level = (int )(Math.random() * 2 + 1);
        int random = (int )(Math.random() * 6 + 1);

        if(random == 1){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game1_1.class);
                Toast.makeText(this,"game1_1",Toast.LENGTH_SHORT).show();
                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game1_2.class);
                Toast.makeText(this,"game1_2",Toast.LENGTH_SHORT).show();

                startActivity(intent2);
            }
        }else if(random == 2){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game2_1.class);
                Toast.makeText(this,"game2_1",Toast.LENGTH_SHORT).show();

                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game2_2.class);
                Toast.makeText(this,"game2_2",Toast.LENGTH_SHORT).show();

                startActivity(intent2);
            }
        }else if(random == 3){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game3_1.class);
                Toast.makeText(this,"game3_1",Toast.LENGTH_SHORT).show();

                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game3_2.class);
                Toast.makeText(this,"game3_2",Toast.LENGTH_SHORT).show();

                startActivity(intent2);
            }
        }else if(random == 4){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game4_1.class);
                Toast.makeText(this,"game4_1",Toast.LENGTH_SHORT).show();

                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game4_2.class);
                Toast.makeText(this,"game4_2",Toast.LENGTH_SHORT).show();

                startActivity(intent2);
            }
        }else if(random == 5){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game5_1.class);
                Toast.makeText(this,"game5_1",Toast.LENGTH_SHORT).show();

                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game5_2.class);
                Toast.makeText(this,"game5_2",Toast.LENGTH_SHORT).show();

                startActivity(intent2);
            }
        }else if(random == 6){
            if(level == 1){
                intent2 = new Intent(Juego.this, Game6_1.class);
                Toast.makeText(this,"game6_1",Toast.LENGTH_SHORT).show();

                startActivity(intent2);
            }else{
                intent2 = new Intent(Juego.this, Game6_2.class);
                Toast.makeText(this,"game6_2",Toast.LENGTH_SHORT).show();
                startActivity(intent2);
            }
        }
    }
}
