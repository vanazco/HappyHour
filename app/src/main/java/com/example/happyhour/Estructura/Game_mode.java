package com.example.happyhour.Estructura;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.happyhour.HelpActivity;
import com.example.happyhour.R;
import com.example.happyhour.Controls.TouchScreenEvents;
import com.example.happyhour.Sparkles.ParticalView;
import com.example.happyhour.Sparkles.ParticleActivity;

public class Game_mode extends AppCompatActivity {
    private static Intent intent;
    private ParticalView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView = new ParticalView(this);
        setContentView(contentView);
        setContentView(R.layout.activity_game_mode);

        final int wallpaper = getIntent().getIntExtra("wallpaper", 1);

        ImageView imageView = findViewById(R.id.fondoPantalla);
        //Get the resource ID
        imageView.setImageResource(wallpaper);

        ImageView click = findViewById(R.id.onclickAnimation);
        findViewById(R.id.onclickPantalla).setOnTouchListener(TouchScreenEvents.touchListener());
        findViewById(R.id.onclickPantalla).setOnClickListener(TouchScreenEvents.onClick(click));

        findViewById(R.id.btn_games).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Game_mode.this, Games.class);
                //intent = new Intent(Game_mode.this, ParticleActivity.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_random).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Game_mode.this, Juego.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_help).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Game_mode.this, HelpActivity.class);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        contentView.dispatchTouchEvent(event);
        return super.onTouchEvent(event);
    }

}
