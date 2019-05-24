package com.example.happyhour.Games.Victor;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.media.MediaPlayer;
import android.widget.ImageButton;

import com.example.happyhour.R;

public class Card {

    ImageButton btn;
    boolean flip;
    MediaPlayer mp;

    public Card(Context context){
        flip = false;
        mp = MediaPlayer.create(context,R.raw.error_sound);
    }

    public void flipCard(final int p) {
        ObjectAnimator flip = ObjectAnimator.ofFloat(btn, "rotationY", 0f, 90f);
        final ObjectAnimator flip2 = ObjectAnimator.ofFloat(btn, "rotationY", 90f, 180f);
        flip.setDuration(1000);
        flip2.setDuration(1000);
        flip.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                btn.setBackgroundResource(p);
                flip2.start();
            }
        });
        flip.start();
    }
    public void checkCards(boolean card2,Card flipped){
        if(flip && !card2){
            flipCard(R.drawable.fondo_carta);
            flipped.flipCard(R.drawable.fondo_carta);
            mp.start();
        }
    }
}
