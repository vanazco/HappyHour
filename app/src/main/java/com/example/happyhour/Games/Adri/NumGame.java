package com.example.happyhour.Games.Adri;

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

import com.example.happyhour.Estructura.Game;
import com.example.happyhour.Estructura.Games;
import com.example.happyhour.Games.BallonActivity;
import com.example.happyhour.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.LocalDateTime;
import java.util.UUID;

public class NumGame extends AppCompatActivity {

    Num uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,empty,empty2;
    Handler handler;
    boolean animation_started = true;
    boolean firstNum = false;
    MediaPlayer[] mp;
    static int wallpaper;
    public int id_game = 1;
    boolean win;
    private LocalDateTime inicio,fi;
    public Game game;
    public DatabaseReference mRef;
    String uid,s_inicio,s_fi;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final int random = (int) (Math.random() * 6 + 1);

        inicio = LocalDateTime.now();
        s_inicio = inicio.getDayOfMonth()+ " " + inicio.getHour() +":"+ inicio.getMinute();

        mRef = FirebaseDatabase.getInstance().getReference();
        uid = FirebaseAuth.getInstance().getUid();

        empty = new Num();
        handler = new Handler();
        empty2 = new Num();
        uno = new Num();
        dos = new Num();
        tres = new Num();
        cuatro = new Num();
        cinco = new Num();
        seis = new Num();
        siete = new Num();
        ocho = new Num();
        nueve = new Num();
        mp = new MediaPlayer[3];

        mp[1] = MediaPlayer.create(NumGame.this,R.raw.error_sound);
        mp[2] = MediaPlayer.create(NumGame.this,R.raw.win_effect);

        if(random == 1){
            setContentView(R.layout.numgame1);
            empty.img = findViewById(R.id.guessnum);
        }else if( random == 2){
            setContentView(R.layout.numgame2);
            empty.img = findViewById(R.id.guessnum);
        }else if( random == 3){
            setContentView(R.layout.numgame3);
            empty.img = findViewById(R.id.guessnum);
        }else if( random == 4){
            setContentView(R.layout.numgame4);
            empty.img = findViewById(R.id.guessnum);
        }else if( random == 5){
            setContentView(R.layout.numgame5);
            empty.img = findViewById(R.id.guessnum);
        }else{
            setContentView(R.layout.numgame6);
            empty.img = findViewById(R.id.guessnum);
        }

        findViewById(R.id.goBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = UUID.randomUUID().toString();
                fi = LocalDateTime.now();
                s_fi = fi.getDayOfMonth()+ "  " +fi.getHour()+ ":" + fi.getMinute();
                game = new Game(id,s_inicio,s_fi,id_game);
                mRef.child("Games").child(uid).child(id).setValue(game);
                Intent intent = new Intent(NumGame.this, Games.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        uno.img = findViewById(R.id.num1);
        dos.img = findViewById(R.id.num2);
        tres.img = findViewById(R.id.num3);
        cuatro.img = findViewById(R.id.num4);
        cinco.img = findViewById(R.id.num5);
        seis.img = findViewById(R.id.num6n);
        siete.img = findViewById(R.id.num7n);
        nueve.img = findViewById(R.id.num9n);


        uno.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty.x = empty.img.getLeft();
                empty.y = empty.img.getTop();
                if(random > 2){
//                    empty2.x = empty2.img.getLeft();
//                    empty2.y = empty2.img.getTop();
                    if(animation_started && !firstNum){
                        moveNum(uno,empty.x,empty.y);
                        animation_started = false;
                    }else if(animation_started){
//                        moveNum(uno,empty2.x,empty2.y);
                        animation_started = false;
                    }
                }else if(animation_started){
                    moveNum(uno,empty.x,empty.y);
                    animation_started = false;
                }

                uno.x = uno.img.getLeft();
                uno.y = uno.img.getTop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!uno.correct)
                            restorePosition(uno, uno.x, uno.y);
                    }
                },2000);
            }
        });

        dos.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty.x = empty.img.getLeft();
                empty.y = empty.img.getTop();
                if(random > 2){
//                    empty2.x = empty2.img.getLeft();
//                    empty2.y = empty2.img.getTop();
                    if(animation_started && !firstNum){
                        moveNum(dos,empty.x,empty.y);
                        animation_started = false;
                    }else if(animation_started){
//                        moveNum(dos,empty2.x,empty2.y);
                        animation_started = false;
                    }
                }else if(animation_started){
                    moveNum(dos,empty.x,empty.y);
                    animation_started = false;
                }
                dos.x = dos.img.getLeft();
                dos.y = dos.img.getTop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!dos.correct)
                            restorePosition(dos, dos.x, dos.y);
                    }
                },2000);
            }
        });

        tres.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty.x = empty.img.getLeft();
                empty.y = empty.img.getTop();
                if(random > 2){
//                    empty2.x = empty2.img.getLeft();
//                    empty2.y = empty2.img.getTop();
                    if(animation_started && !firstNum){
                        moveNum(tres,empty.x,empty.y);
                        animation_started = false;
                    }else if(animation_started){
//                        moveNum(tres,empty2.x,empty2.y);
                        animation_started = false;
                    }
                }else if(animation_started){
                    moveNum(tres,empty.x,empty.y);
                    animation_started =false;
                }
                tres.x = tres.img.getLeft();
                tres.y = tres.img.getTop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!tres.correct)
                            restorePosition(tres, tres.x, tres.y);
                    }
                },2000);
            }
        });

        cuatro.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty.x = empty.img.getLeft();
                empty.y = empty.img.getTop();
                if(random > 2){
//                    empty2.x = empty2.img.getLeft();
//                    empty2.y = empty2.img.getTop();
                    if(animation_started && !firstNum){
                        moveNum(cuatro,empty.x,empty.y);
                        animation_started = false;
                    }else if(animation_started){
//                        moveNum(cuatro,empty2.x,empty2.y);
                        animation_started = false;
                    }
                }else if(animation_started){
                    moveNum(cuatro,empty.x,empty.y);
                    animation_started =false;
                }
                cuatro.x = cuatro.img.getLeft();
                cuatro.y = cuatro.img.getTop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!cuatro.correct)
                            restorePosition(cuatro, cuatro.x, cuatro.y);
                    }
                },2000);
            }
        });

        cinco.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                empty.x = empty.img.getLeft();
                empty.y = empty.img.getTop();
                if(random > 2){
//                    empty2.x = empty2.img.getLeft();
//                    empty2.y = empty2.img.getTop();
                    if(animation_started && !firstNum){
                        moveNum(cinco,empty.x,empty.y);
                        animation_started = false;
                    }else if(animation_started){
//                        moveNum(cinco,empty2.x,empty2.y);
                        animation_started = false;
                    }
                }else if(animation_started){
                    moveNum(cinco,empty.x,empty.y);
                    animation_started= false;
                }
                cinco.x = cinco.img.getLeft();
                cinco.y = cinco.img.getTop();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(!cinco.correct)
                            restorePosition(cinco, cinco.x, cinco.y);
                    }
                },2000);
            }
        });

    }

    public void moveNum(final Num num, Integer x, Integer y) {
        ObjectAnimator moveX = ObjectAnimator.ofFloat(num.img,"x", x);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(num.img,"y",y);
        AnimatorSet as = new AnimatorSet();
        as.playTogether(moveX,moveY);
        as.setDuration(2000);
        as.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                if(num.img.getBackground().getConstantState() == empty.img.getBackground().getConstantState()){
                    num.correct = true;
                    firstNum = true;
                    mp[2].start();
                    GameOver();
                }else{
                    num.correct = false;
                }
            }
        });
        as.start();
    }


    //Animacion de vuelta
    public void restorePosition(final Num num, Integer x, Integer y){
        ObjectAnimator moveX = ObjectAnimator.ofFloat(num.img,"x", x);
        ObjectAnimator moveY = ObjectAnimator.ofFloat(num.img,"y",y);
        AnimatorSet as = new AnimatorSet();
        as.playTogether(moveX,moveY);
        as.setDuration(2000);
        as.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                mp[1].start();
                animation_started = true;
            }

            @Override
            public void onAnimationEnd(Animator animation, boolean isReverse) {
                num.correct = false;
            }
        });
        as.start();
    }

    public void GameOver() {
        Intent intent = new Intent(this, BallonActivity.class);
        startActivity(intent);
    }


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
        intent.putExtra("wallpaper", wallpaper);
        startActivity(intent);
    }
}
