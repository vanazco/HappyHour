package com.example.happyhour.Estructura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.happyhour.R;

public class Game_mode extends AppCompatActivity {
    Button btn_random,btn_games;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        final int random = (int )(Math.random() * 6 + 1);

        btn_games = findViewById(R.id.btn_games);
        btn_random = findViewById(R.id.btn_random);

        btn_games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Game_mode.this, Games.class);
                startActivity(intent);
            }
        });

        btn_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Game_mode.this, Juego.class);
                intent2.putExtra("random",random);
                startActivity(intent2);
            }
        });
    }
}
