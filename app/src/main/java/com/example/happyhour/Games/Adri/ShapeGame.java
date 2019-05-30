package com.example.happyhour.Games.Adri;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.happyhour.Estructura.Game;
import com.example.happyhour.Estructura.GameMode;
import com.example.happyhour.Games.Sebas.Pintar.ChooseDraw;
import com.example.happyhour.R;
import com.google.firebase.database.DatabaseReference;

import java.time.LocalDateTime;
import java.util.UUID;

public class ShapeGame extends AppCompatActivity {

    public int id_game = 2;
    private LocalDateTime inicio,fi;
    public Game game;
    private DatabaseReference mRef;
    String uid,s_inicio,s_fi;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int random = (int) (Math.random() * 2 + 1);


        if(random == 1){
            setContentView(R.layout.activity_drag_drop);
            findViewById(R.id.triangulo2).setOnTouchListener(new MyTouchListener());
            findViewById(R.id.rombo2).setOnTouchListener(new MyTouchListener());
            findViewById(R.id.trapezi2).setOnTouchListener(new MyTouchListener());
            findViewById(R.id.circulo2).setOnTouchListener(new MyTouchListener());

            findViewById(R.id.circulo).setOnDragListener(new MyDragListener(this,"circulo"));
            findViewById(R.id.triangle).setOnDragListener(new MyDragListener(this,"triangle"));
            findViewById(R.id.trapezi).setOnDragListener(new MyDragListener(this,"trapezi"));
            findViewById(R.id.rombo).setOnDragListener(new MyDragListener(this,"rombo"));



        } else if( random == 2){
            setContentView(R.layout.activity_drag_drop2);
            findViewById(R.id.rombo2).setOnTouchListener(new MyTouchListener());
            findViewById(R.id.trapezi2).setOnTouchListener(new MyTouchListener());
            findViewById(R.id.cuadrado2).setOnTouchListener(new MyTouchListener());
            findViewById(R.id.rectangulo2).setOnTouchListener(new MyTouchListener());

            findViewById(R.id.rombo).setOnDragListener(new MyDragListener(this,"rombo"));
            findViewById(R.id.trapezi).setOnDragListener(new MyDragListener(this,"trapezi"));
            findViewById(R.id.cuadrado).setOnDragListener(new MyDragListener(this,"cuadrado"));
            findViewById(R.id.rectangulo).setOnDragListener(new MyDragListener(this,"rectangulo"));
        }

        findViewById(R.id.goBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = UUID.randomUUID().toString();
                fi = LocalDateTime.now();
                s_fi = fi.getDayOfMonth()+ "  " +fi.getHour()+ ":" + fi.getMinute();
                game = new Game(id,s_inicio,s_fi,id_game);
                mRef.child("Games").child(uid).child(id).setValue(game);
                Intent intent = new Intent(ShapeGame.this, GameMode.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String id = UUID.randomUUID().toString();
        fi = LocalDateTime.now();
        s_fi = fi.getDayOfMonth()+ "  " +fi.getHour()+ ":" + fi.getMinute();
        game = new Game(id,s_inicio,s_fi,id_game);
        mRef.child("Games").child(uid).child(id).setValue(game);
        Intent intent = new Intent(this, ChooseDraw.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
