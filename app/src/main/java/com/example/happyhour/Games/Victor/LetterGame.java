package com.example.happyhour.Games.Victor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.happyhour.Estructura.Game;
import com.example.happyhour.Estructura.Games;
import com.example.happyhour.Games.BallonActivity;
import com.example.happyhour.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDateTime;
import java.util.UUID;

public class LetterGame extends AppCompatActivity {

    Letter a,e,i,o,u,empty,empty2;
    Handler handler;
    boolean animation_started = true;
    boolean firstLetter = false;
    ImageView image,fondo;
    MediaPlayer[] mp;
    int random;
    private LocalDateTime inicio,fi;
    public Game game;
    private DatabaseReference mRef;
    public int id_game = 6;
    private int numLetras, letrasCorrectas;
    String uid;
    private boolean segundaLetra = false;
    String s_inicio,s_fi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Coje el tiempo cuando se inicia y lo formatea
        inicio = LocalDateTime.now();
        s_inicio = inicio.getDayOfMonth()+ " " + inicio.getHour() +":"+ inicio.getMinute();

        //Instancia de Firebase database y usuario
        mRef = FirebaseDatabase.getInstance().getReference();
        uid = FirebaseAuth.getInstance().getUid();

        //random para elegir el layout que saldrá
        random = (int) (Math.random() * 3 + 1);
        //Inicializamos algunas variables
        empty = new Letter();
        handler = new Handler();
        empty2 = new Letter();
        a = new Letter();
        e = new Letter();
        i = new Letter();
        o = new Letter();
        u = new Letter();
        mp = new MediaPlayer[3];

        //Sonido de error y win
        mp[1] = MediaPlayer.create(LetterGame.this,R.raw.error_sound);
        mp[2] = MediaPlayer.create(LetterGame.this,R.raw.win_effect);

        //Cargamos layout en función del random
        if(random == 1){
            setContentView(R.layout.letter_game1);
            empty.img = findViewById(R.id.emptyLetter2);
            numLetras = 2;
        }else if(random == 2){
            setContentView(R.layout.letter_game2);
            empty.img = findViewById(R.id.emptyLetter);
            numLetras = 1;
        }else{
            setContentView(R.layout.letter_game3);
            empty.img = findViewById(R.id.emptyLetter2);
            empty2.img = findViewById(R.id.emptyLetter3);
            numLetras = 1;
        }

        //Asignamos las vocales
        a.img = findViewById(R.id.letterA);
        e.img = findViewById(R.id.letterE);
        i.img = findViewById(R.id.letterI);
        o.img = findViewById(R.id.letterO);
        u.img = findViewById(R.id.letterU);
        image = findViewById(R.id.imageView);
        fondo = findViewById(R.id.fondoPantalla);

        //Imagen al clickar sonido
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(random == 1){
                    mp[0] = MediaPlayer.create(LetterGame.this,R.raw.cat_sound);
                    mp[0].start();
                }else if(random == 2){
                    mp[0] = MediaPlayer.create(LetterGame.this,R.raw.bear_sound);
                    mp[0].start();
                }else{
                    mp[0] = MediaPlayer.create(LetterGame.this,R.raw.koala_sound);
                    mp[0].start();
                }
            }
        });

        //Botón de marcha atras guarda datos en el firebase y finaliza la activity
        findViewById(R.id.goBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = UUID.randomUUID().toString();
                fi = LocalDateTime.now();
                s_fi = fi.getDayOfMonth()+ "  " +fi.getHour()+ ":" + fi.getMinute();
                game = new Game(id,s_inicio,s_fi,id_game);
                mRef.child("Games").child(uid).child(id).setValue(game);
                Intent intent = new Intent(LetterGame.this, Games.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        //Definimos los Listeners
        a.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Asignamos el valor de X y Y de las vocales ocultas
                empty.x = empty.img.getLeft();
                empty.y = empty.img.getTop();
                if(random > 2){
                    empty2.x = empty2.img.getLeft();
                    empty2.y = empty2.img.getTop();
                    if(animation_started && !firstLetter){
                        moveLetter(a,empty.x,empty.y);
                        animation_started = false;
                    }else if(animation_started){
                        moveLetter(a,empty2.x,empty2.y);
                        animation_started = false;
                    }else if(!animation_started && firstLetter){
                        moveLetter(a,empty2.x,empty2.y);
                        animation_started = false;
                    }
                }else if(animation_started){
                    moveLetter(a,empty.x,empty.y);
                    animation_started = false;
                }
                a.x = a.img.getLeft();
                a.y = a.img.getTop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(firstLetter){
                            mp[2].start();
                            segundaLetra = true;
                            GameOver();
                        }
                        if(!a.correct && !firstLetter)
                            restorePosition(a, a.x, a.y);
                    }
                },1500);
            }
        });

        e.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty.x = empty.img.getLeft();
                empty.y = empty.img.getTop();
                if(random > 2){
                    empty2.x = empty2.img.getLeft();
                    empty2.y = empty2.img.getTop();
                    if(animation_started && !firstLetter){
                        moveLetter(e,empty.x,empty.y);
                        animation_started = false;
                    }else if(animation_started){
                        moveLetter(e,empty2.x,empty2.y);
                        animation_started = false;
                    }
                }else if(animation_started){
                    moveLetter(e,empty.x,empty.y);
                    animation_started = false;
                }
                e.x = e.img.getLeft();
                e.y = e.img.getTop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!e.correct)
                            restorePosition(e,e.x,e.y);
                    }
                },1500);
            }
        });

        i.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty.x = empty.img.getLeft();
                empty.y = empty.img.getTop();
                if(random > 2){
                    empty2.x = empty2.img.getLeft();
                    empty2.y = empty2.img.getTop();
                    if(animation_started && !firstLetter){
                        moveLetter(i,empty.x,empty.y);
                        animation_started = false;
                    }else if(animation_started){
                        moveLetter(i,empty2.x,empty2.y);
                        animation_started = false;
                    }
                }else if(animation_started){
                    moveLetter(i,empty.x,empty.y);
                    animation_started =false;
                }
                i.x = i.img.getLeft();
                i.y = i.img.getTop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!i.correct)
                            restorePosition(i,i.x,i.y);
                    }
                },1500);
            }
        });

        o.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty.x = empty.img.getLeft();
                empty.y = empty.img.getTop();
                if(random > 2){
                    empty2.x = empty2.img.getLeft();
                    empty2.y = empty2.img.getTop();
                    if(animation_started && !firstLetter){
                        moveLetter(o,empty.x,empty.y);
                        animation_started = false;
                    }else if(animation_started){
                        moveLetter(o,empty2.x,empty2.y);
                        animation_started = false;
                    }
                }else if(animation_started){
                    moveLetter(o,empty.x,empty.y);
                    animation_started =false;
                }
                o.x = o.img.getLeft();
                o.y = o.img.getTop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!o.correct)
                            restorePosition(o,o.x,o.y);
                    }
                },1500);
            }
        });

        u.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty.x = empty.img.getLeft();
                empty.y = empty.img.getTop();
                if(random > 2){
                    empty2.x = empty2.img.getLeft();
                    empty2.y = empty2.img.getTop();
                    if(animation_started && !firstLetter){
                        moveLetter(u,empty.x,empty.y);
                        animation_started = false;
                    }else if(animation_started){
                        moveLetter(u,empty2.x,empty2.y);
                        animation_started = false;
                    }
                }else if(animation_started){
                    moveLetter(u,empty.x,empty.y);
                    animation_started= false;
                }
                u.x = u.img.getLeft();
                u.y = u.img.getTop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!u.correct)
                            restorePosition(u,u.x,u.y);
                    }
                },1500);
            }
        });
    }

    //Metodo que mueve la letra y comprueba si es la correcta
    public void moveLetter(final Letter letter, Integer x, Integer y) {
        //Creamos las animaciones
        ObjectAnimator moveX = ObjectAnimator.ofFloat(letter.img,"x", x);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(letter.img,"y",y);
        //Los juntamos en un AnimatorSet
        AnimatorSet as = new AnimatorSet();
        as.playTogether(moveX,moveY);
        as.setDuration(1500);
        as.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                //Comprobamos si la imagen de la letra es igual a la oculta
                if(letter.img.getBackground().getConstantState() == empty.img.getBackground().getConstantState() && random <= 2){
                    letter.correct = true;
                    firstLetter = true;
                    mp[2].start();
                    letrasCorrectas++;
                }else if(letter.img.getBackground().getConstantState() == empty.img.getBackground().getConstantState() && random > 2){
                    letter.correct = true;
                    firstLetter = true;
                }else{
                    letter.correct = false;
                }

                if (letrasCorrectas == numLetras) {
                    GameOver();
                }
            }
        });
        as.start();
    }

    //Animacion de vuelta
    public void restorePosition(final Letter letter, Integer x, Integer y){
        ObjectAnimator moveX = ObjectAnimator.ofFloat(letter.img,"x", x);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(letter.img,"y",y);
        AnimatorSet as = new AnimatorSet();
        as.playTogether(moveX,moveY);
        as.setDuration(1500);
        as.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mp[1].start();
                animation_started = true;
            }

            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                letter.correct = false;
            }
        });
        as.start();
    }


    //Termina el juego y sale la activity de los globos
    public void GameOver() {
        Intent intent = new Intent(this, BallonActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    //Al ir hacia atras finaliza la activity y guarda datos en firebase
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String id = UUID.randomUUID().toString();
        fi = LocalDateTime.now();
        s_fi = fi.getDayOfMonth()+ "  " +fi.getHour()+ ":" + fi.getMinute();
        game = new Game(id,s_inicio,s_fi,id_game);
        mRef.child("Games").child(uid).child(id).setValue(game);
        Intent intent = new Intent(this, Games.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
