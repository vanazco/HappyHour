package com.example.happyhour;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.happyhour.Controls.TouchScreenEvents;
import com.example.happyhour.Estructura.Game_mode;
import com.example.happyhour.Sparkles.ParticalView;
import com.example.happyhour.Sparkles.Particle;

public class MainActivity extends AppCompatActivity {

    ParticalView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentView = new ParticalView(this);

        //random
        final int wallpaperRandom = (int) (Math.random() * 5 + 1);
        //Initialize wallpaper to load all the R.drawable
        final WallPaper wallPaper = new WallPaper();

        ImageView imageView = findViewById(R.id.fondoPantalla);
        //Get the resource ID
        imageView.setImageResource(wallPaper.getWallpaper().get(wallpaperRandom));

        ImageView click = findViewById(R.id.onclickAnimation);
        findViewById(R.id.onclickPantalla).setOnTouchListener(TouchScreenEvents.touchListener());
        findViewById(R.id.onclickPantalla).setOnClickListener(TouchScreenEvents.onClick(click));

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Game_mode.class);
                intent.putExtra("wallpaper", wallPaper.getWallpaper().get(wallpaperRandom));
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Toast.makeText(this, "Aqui", Toast.LENGTH_LONG).show();
        contentView.dispatchTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
