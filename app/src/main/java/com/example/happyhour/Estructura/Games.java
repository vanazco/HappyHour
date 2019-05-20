package com.example.happyhour.Estructura;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.happyhour.Games.Adri.Game1_1;
import com.example.happyhour.Games.Adri.Game1_2;
import com.example.happyhour.Games.Adri.Game2_1;
import com.example.happyhour.Games.Adri.Game2_2;
import com.example.happyhour.Games.Sebas.Pintar.Pintar;
import com.example.happyhour.Games.Sebas.Puzzle.ChoosePuzzle;
import com.example.happyhour.Games.Victor.CardGame1;
import com.example.happyhour.Games.Victor.CardGame2;
import com.example.happyhour.Games.Victor.Game3_1;
import com.example.happyhour.Games.Victor.Game3_2;
import com.example.happyhour.R;

public class Games extends AppCompatActivity {

    ImageButton btn1,btn2,btn3,btn4,btn5,btn6;
    private Intent intent;
    private static int wallpaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        wallpaper = getIntent().getIntExtra("wallpaper", 1);

        ImageView imageView = findViewById(R.id.fondoPantalla);
        //Get the resource ID
        imageView.setImageResource(wallpaper);

        final int level = (int )(Math.random() * 2 + 1);

        btn1 = findViewById(R.id.game1);
        btn2 = findViewById(R.id.game2);
        btn3 = findViewById(R.id.game3);
        btn4 = findViewById(R.id.game4);
        btn5 = findViewById(R.id.game5);
        btn6 = findViewById(R.id.game6);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level == 1){
                    intent = new Intent(Games.this, Game1_1.class);
                    intent.putExtra("wallpaper", wallpaper);
                    startActivity(intent);
                }else{
                    intent = new Intent(Games.this, Game1_2.class);
                    intent.putExtra("wallpaper", wallpaper);
                    startActivity(intent);
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level == 1){
                    intent = new Intent(Games.this, Game2_1.class);
                    intent.putExtra("wallpaper", wallpaper);
                    startActivity(intent);
                }else{
                    intent = new Intent(Games.this, Game2_2.class);
                    intent.putExtra("wallpaper", wallpaper);
                    startActivity(intent);
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level == 1){
                    intent = new Intent(Games.this, Game3_1.class);
                    intent.putExtra("wallpaper", wallpaper);
                    startActivity(intent);
                }else{
                    intent = new Intent(Games.this, Game3_2.class);
                    intent.putExtra("wallpaper", wallpaper);
                    startActivity(intent);
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level == 1){
                    intent = new Intent(Games.this, CardGame1.class);
                    intent.putExtra("wallpaper", wallpaper);
                    startActivity(intent);
                }else{
                    intent = new Intent(Games.this, CardGame2.class);
                    intent.putExtra("wallpaper", wallpaper);
                    startActivity(intent);
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Games.this, ChoosePuzzle.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Games.this, Pintar.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, GameMode.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("wallpaper", wallpaper);
        startActivity(intent);
    }
}
