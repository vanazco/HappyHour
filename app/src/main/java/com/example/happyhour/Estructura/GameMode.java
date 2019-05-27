package com.example.happyhour.Estructura;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.happyhour.HelpActivity;
import com.example.happyhour.Information;
import com.example.happyhour.R;

public class GameMode extends AppCompatActivity {
    private static Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);

        findViewById(R.id.btn_games).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GameMode.this, Games.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_random).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GameMode.this, Random.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_help).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GameMode.this, HelpActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_bbdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(GameMode.this, Information.class);
                startActivity(intent);
            }
        });

    }

}
