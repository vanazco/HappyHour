package com.example.happyhour.Sparkles;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class ParticleActivity extends Activity {

    private ParticalView contentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        contentView = new ParticalView(this);
        setContentView(contentView);
        super.onCreate(savedInstanceState);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        contentView.dispatchTouchEvent(event);
        return super.onTouchEvent(event);
    }

}