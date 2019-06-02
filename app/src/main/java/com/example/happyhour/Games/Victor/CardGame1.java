package com.example.happyhour.Games.Victor;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
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

public class CardGame1 extends AppCompatActivity {

    Card bee1, bee2, bewear1, bewear2, panda1, panda2;
    int cartas;
    Card flipped;
    Handler handler;
    MediaPlayer mp;
    int contar_win, numCartas;
    public int id_game = 5;
    private LocalDateTime fi;
    public Game game;
    private DatabaseReference mRef;
    String uid,s_inicio,s_fi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_game);

        //Coje el tiempo cuando se inicia y lo formatea
        LocalDateTime inicio = LocalDateTime.now();
        s_inicio = inicio.getDayOfMonth()+ " " + inicio.getHour() +":"+ inicio.getMinute();

        //Instancia de Firebase database y usuario
        mRef = FirebaseDatabase.getInstance().getReference();
        uid = FirebaseAuth.getInstance().getUid();

        //Botón de marcha atras guarda datos en el firebase y finaliza la activity
        findViewById(R.id.goBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = UUID.randomUUID().toString();
                fi = LocalDateTime.now();
                s_fi = fi.getDayOfMonth()+ "  " +fi.getHour()+ ":" + fi.getMinute();
                game = new Game(id,s_inicio,s_fi,id_game);
                mRef.child("Games").child(uid).child(id).setValue(game);
                Intent intent = new Intent(CardGame1.this, Games.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        //Sonido al ganar
        mp = MediaPlayer.create(CardGame1.this,R.raw.win_effect);

        cartas = 0;
        contar_win = 0;
        numCartas = 3;

        //Iniciamos las cartas
        bee1 = new Card(getApplicationContext());
        bee2 = new Card(getApplicationContext());
        bewear1 = new Card(getApplicationContext());
        bewear2 = new Card(getApplicationContext());
        panda1 = new Card(getApplicationContext());
        panda2 = new Card(getApplicationContext());

        handler = new Handler();

        bee1.btn = findViewById(R.id.bee_1);
        bee2.btn = findViewById(R.id.bee_2);
        bewear1.btn = findViewById(R.id.bewear_1);
        bewear2.btn = findViewById(R.id.bewear_2);
        panda1.btn = findViewById(R.id.panda_1);
        panda2.btn = findViewById(R.id.panda_2);

        //Cuenta atras al principio
        new CountDownTimer(3000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                //Se giran las cartas
                bee1.flipCard(R.drawable.fondo_carta);
                bee2.flipCard(R.drawable.fondo_carta);
                bewear1.flipCard(R.drawable.fondo_carta);
                bewear2.flipCard(R.drawable.fondo_carta);
                panda1.flipCard(R.drawable.fondo_carta);
                panda2.flipCard(R.drawable.fondo_carta);

                bee1.btn.setMaxWidth(120);
                bee2.btn.setMaxWidth(120);

                //Definicion de los listeners de cada carta
                bee1.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!bee1.flip && cartas < 2){
                            //Gira la carta
                            bee1.flipCard(R.drawable.bee);
                            cartas++;
                            bee1.flip = true;
                            if(flipped == null){
                                flipped = bee1;
                            }
                            if(cartas == 2){
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //Comprueba si hay dos cartas giradas y comprueba si son pareja.
                                        checkCards2(bee1,bee2.flip,flipped);
                                        flipped.flip = false;
                                        flipped = null;
                                        bee1.flip = false;
                                        cartas = 0;
                                    }
                                },2000);
                            }
                            //Deshabilita los botones si la pareja esta girada
                        }else if(bee1.flip && bee2.flip){
                            bee1.btn.setClickable(false);
                            bee2.btn.setClickable(false);
                        }
                    }
                });

                bee2.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!bee2.flip && cartas < 2){
                            bee2.flipCard(R.drawable.bee);
                            cartas++;
                            bee2.flip = true;
                            if(flipped == null){
                                flipped = bee2;
                            }
                            if(cartas == 2){
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        checkCards2(bee2,bee1.flip,flipped);
                                        flipped.flip = false;
                                        flipped = null;
                                        bee2.flip = false;
                                        cartas = 0;
                                    }
                                },2000);
                            }
                        }else if (bee2.flip && bee1.flip){
                            bee1.btn.setClickable(false);
                            bee2.btn.setClickable(false);
                        }
                    }
                });

                bewear1.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!bewear1.flip && cartas < 2){
                            bewear1.flipCard(R.drawable.bewear);
                            cartas++;
                            bewear1.flip = true;
                            if(flipped == null){
                                flipped = bewear1;
                            }
                            if(cartas == 2) {
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        checkCards2(bewear1, bewear2.flip, flipped);
                                        flipped.flip = false;
                                        flipped = null;
                                        bewear1.flip = false;
                                        cartas = 0;
                                    }
                                }, 2000);
                            }
                        }else if (bewear1.flip && bewear2.flip){
                            bewear1.btn.setClickable(false);
                            bewear2.btn.setClickable(false);
                        }
                    }
                });

                bewear2.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!bewear2.flip && cartas < 2){
                            bewear2.flipCard(R.drawable.bewear);
                            cartas++;
                            bewear2.flip = true;
                            if(flipped == null){
                                flipped = bewear2;
                            }
                            if(cartas == 2) {
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        checkCards2(bewear2, bewear1.flip, flipped);
                                        flipped.flip = false;
                                        flipped = null;
                                        bewear2.flip = false;
                                        cartas = 0;
                                    }
                                }, 2000);
                            }
                        }else if (bewear2.flip && bewear1.flip){
                            bewear1.btn.setClickable(false);
                            bewear2.btn.setClickable(false);
                        }
                    }
                });
                panda1.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!panda1.flip && cartas < 2){
                            panda1.flipCard(R.drawable.lion);
                            cartas++;
                            panda1.flip = true;
                            if(flipped == null){
                                flipped = panda1;
                            }
                            if(cartas == 2) {
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        checkCards2(panda1, panda2.flip, flipped);
                                        flipped.flip = false;
                                        flipped = null;
                                        panda1.flip = false;
                                        cartas = 0;
                                    }
                                }, 2000);
                            }
                        }else if (panda1.flip && panda2.flip){
                            panda1.btn.setClickable(false);
                            panda2.btn.setClickable(false);
                        }
                    }
                });
                panda2.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!panda2.flip && cartas < 2){
                            panda2.flipCard(R.drawable.lion);
                            cartas++;
                            panda2.flip = true;
                            if(flipped == null){
                                flipped = panda2;
                            }
                            if(cartas == 2) {
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        checkCards2(panda2, panda1.flip, flipped);
                                        flipped.flip = false;
                                        flipped = null;
                                        panda2.flip = false;
                                        cartas = 0;
                                    }
                                }, 2000);
                            }
                        }else if (panda2.flip && panda1.flip){
                            panda2.btn.setClickable(false);
                            panda1.btn.setClickable(false);
                        }
                    }
                });
            }
        }.start();
    }

    //Al volver atras guarda datos en firebase y finaliza la activity
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

    //Comprueba las cartas si son parejas
    public void checkCards2(Card card,Boolean flipped,Card card_flip){
        if (card.checkCards(flipped,card_flip)) {
            contar_win++;
            GameOver();
        }
    }

    //Finaliza la activity , win effect y inicia los globos.
    public void GameOver() {
        if (contar_win == numCartas) {
            MediaPlayer mp = MediaPlayer.create(CardGame1.this,R.raw.win_effect);
            mp.start();
            Intent intent = new Intent(this, BallonActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }
}
