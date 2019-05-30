package com.example.happyhour.Games.Adri;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.happyhour.Estructura.Games;
import com.example.happyhour.R;

public class ShapeGame extends AppCompatActivity {

    public int id_game = 2;

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


    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Games.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
