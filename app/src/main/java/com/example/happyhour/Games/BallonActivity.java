package com.example.happyhour.Games;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.happyhour.Balloons.Balloon;
import com.example.happyhour.Balloons.utils.SoundHelper;
import com.example.happyhour.Estructura.Games;
import com.example.happyhour.Estructura.Juego;
import com.example.happyhour.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallonActivity extends AppCompatActivity implements Balloon.BalloonListener {

    private static final int MIN_ANIMATION_DELAY = 500;
    private static final int MAX_ANIMATION_DELAY = 1500;
    private static final int MIN_ANIMATION_DURATION = 1000;
    private static final int MAX_ANIMATION_DURATION = 8000;
    private static final int BALLOONS = 10;

    private ViewGroup mContentView;
    private int[] mBalloonColors = new int[3];
    private int mNextColor, mScreenWidth, mScreenHeight;
    private List<Balloon> mBalloons = new ArrayList<>();

    private boolean mPlaying;
    private int mLevel;
    private int mBalloonsPopped, mNumBallons;

    private SoundHelper mSoundHelper;

    private ImageView finalizado;
    private ImageButton seguir, volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ballon);

        mBalloonColors[0] = Color.argb(255, 255, 0, 0);
        mBalloonColors[1] = Color.argb(255, 0, 255, 0);
        mBalloonColors[2] = Color.argb(255, 0, 0, 255);

        mContentView = (ViewGroup) findViewById(R.id.balloon_activity);

        finalizado = findViewById(R.id.finished);
        seguir = findViewById(R.id.seguirJugando);
        volver = findViewById(R.id.volverMenuJuegos);

        ViewTreeObserver viewTreeObserver = mContentView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    mContentView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    mScreenHeight = mContentView.getHeight();
                    mScreenWidth = mContentView.getWidth();
                }
            });
        }

        mSoundHelper = new SoundHelper(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startGame();
            }
        }, 2000);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    private void startGame() {
        mLevel = 0;
        startLevel();
    }

    private void startLevel() {
        mLevel++;
        BalloonLauncher balloonLauncher = new BalloonLauncher();
        balloonLauncher.execute(mLevel);
        mPlaying = true;
        mBalloonsPopped = 0;
    }

    private void finishLevel() {
        mPlaying = false;
        finalizado.setVisibility(View.VISIBLE);
        seguir.setVisibility(View.VISIBLE);
        volver.setVisibility(View.VISIBLE);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BallonActivity.this, Games.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        seguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BallonActivity.this, Juego.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    @Override
    public void popBalloon(Balloon balloon, boolean userTouch) {
        mSoundHelper.playSound();
        mBalloonsPopped++;
        mContentView.removeView(balloon);
        mBalloons.remove(balloon);

        if (mBalloonsPopped == BALLOONS || mNumBallons == BALLOONS) {
            finishLevel();
        }
    }

    private void gameOver() {
        for (Balloon balloon : mBalloons) {
            mContentView.removeView(balloon);
            balloon.setPopped(true);
        }

        mBalloons.clear();
        mPlaying = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        gameOver();
    }

    @SuppressLint("StaticFieldLeak")
    private class BalloonLauncher extends AsyncTask<Integer, Integer, Void> {

        @Override
        protected Void doInBackground(Integer... params) {

            if (params.length != 1) {
                throw new AssertionError(
                        "Expected 1 param for current level");
            }

            int level = params[0];
            int maxDelay = Math.max(MIN_ANIMATION_DELAY,
                    (MAX_ANIMATION_DELAY - ((level - 1) * 500)));
            int minDelay = maxDelay / 2;

            int balloonsLaunched = 0;
            while (mPlaying && balloonsLaunched < BALLOONS) {

//              Get a random horizontal position for the next balloon
                Random random = new Random();
                int xPosition = random.nextInt(mScreenWidth - 200);
                publishProgress(xPosition);
                balloonsLaunched++;

//              Wait a random number of milliseconds before looping
                int delay = random.nextInt(minDelay) + minDelay;
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int xPosition = values[0];
            launchBalloon(xPosition);
        }

    }

    private void launchBalloon(int x) {

        Balloon balloon = new Balloon(this, mBalloonColors[mNextColor], 150);
        mBalloons.add(balloon);

        if (mNextColor + 1 == mBalloonColors.length) {
            mNextColor = 0;
        } else {
            mNextColor++;
        }

        mNumBallons++;

        // Set balloon vertical position and dimensions, add to container
        balloon.setX(x);
        balloon.setY(mScreenHeight + balloon.getHeight());
        mContentView.addView(balloon);

        // Let 'er fly
        int duration = Math.max(MIN_ANIMATION_DURATION, MAX_ANIMATION_DURATION - (mLevel * 1000));
        balloon.releaseBalloon(mScreenHeight, duration);

    }
}
