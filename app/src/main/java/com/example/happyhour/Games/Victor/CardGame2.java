package com.example.happyhour.Games.Victor;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.happyhour.Estructura.Games;
import com.example.happyhour.R;

public class CardGame2 extends AppCompatActivity {

    static int wallpaper;

    Card bee1, bee2, bewear1, bewear2, panda1, panda2,rowlet1,rowlet2;
    int cartas;
    Card flipped;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_game2);

        wallpaper = getIntent().getIntExtra("wallpaper", 1);

        ImageView imageView = findViewById(R.id.fondoPantalla);
        //Get the resource ID
//        imageView.setImageResource(wallpaper);

        findViewById(R.id.goBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardGame2.this, Games.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("wallpaper", wallpaper);
                startActivity(intent);
            }
        });

        cartas = 0;

        bee1 = new Card(getApplicationContext());
        bee2 = new Card(getApplicationContext());
        bewear1 = new Card(getApplicationContext());
        bewear2 = new Card(getApplicationContext());
        panda1 = new Card(getApplicationContext());
        panda2 = new Card(getApplicationContext());
        rowlet1 = new Card(getApplicationContext());
        rowlet2 = new Card(getApplicationContext());

        handler = new Handler();

        bee1.btn = findViewById(R.id.bee_1_2);
        bee2.btn = findViewById(R.id.bee_2_2);
        bewear1.btn = findViewById(R.id.bewear_1_2);
        bewear2.btn = findViewById(R.id.bewear_2_2);
        panda1.btn = findViewById(R.id.panda_1_2);
        panda2.btn = findViewById(R.id.panda_2_2);
        rowlet1.btn = findViewById(R.id.rowlet_1);
        rowlet2.btn = findViewById(R.id.rowlet_2);

        new CountDownTimer(3000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                bee1.flipCard(R.drawable.fondo_carta);
                bee2.flipCard(R.drawable.fondo_carta);
                bewear1.flipCard(R.drawable.fondo_carta);
                bewear2.flipCard(R.drawable.fondo_carta);
                panda1.flipCard(R.drawable.fondo_carta);
                panda2.flipCard(R.drawable.fondo_carta);
                rowlet1.flipCard(R.drawable.fondo_carta);
                rowlet2.flipCard(R.drawable.fondo_carta);

                bee1.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!bee1.flip && cartas < 2){
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
                                        checkCards2(bee1,bee2.flip,flipped);
                                        flipped.flip = false;
                                        flipped = null;
                                        bee1.flip = false;
                                        cartas = 0;
                                    }
                                },2000);
                            }
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
                            panda1.flipCard(R.drawable.panda);
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
                            panda2.flipCard(R.drawable.panda);
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

                rowlet1.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!rowlet1.flip && cartas < 2){
                            rowlet1.flipCard(R.drawable.rowlet);
                            cartas++;
                            rowlet1.flip = true;
                            if(flipped == null){
                                flipped = rowlet1;
                            }
                            if(cartas == 2){
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        checkCards2(rowlet1,rowlet2.flip,flipped);
                                        flipped.flip = false;
                                        flipped = null;
                                        rowlet1.flip = false;
                                        cartas = 0;
                                    }
                                },2000);
                            }
                        }else if(rowlet1.flip && rowlet2.flip){
                            rowlet1.btn.setClickable(false);
                            rowlet2.btn.setClickable(false);
                        }
                    }
                });

                rowlet2.btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!rowlet2.flip && cartas < 2){
                            rowlet2.flipCard(R.drawable.rowlet);
                            cartas++;
                            rowlet2.flip = true;
                            if(flipped == null){
                                flipped = rowlet2;
                            }
                            if(cartas == 2){
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        checkCards2(rowlet2,rowlet1.flip,flipped);
                                        flipped.flip = false;
                                        flipped = null;
                                        rowlet2.flip = false;
                                        cartas = 0;
                                    }
                                },2000);
                            }
                        }else if(rowlet2.flip && rowlet1.flip){
                            rowlet2.btn.setClickable(false);
                            rowlet1.btn.setClickable(false);
                        }
                    }
                });
            }
        }.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Games.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("wallpaper", wallpaper);
        startActivity(intent);
    }

    public void checkCards2(Card card,Boolean flipped,Card card_flip){
        card.checkCards(flipped,card_flip);
    }
}
