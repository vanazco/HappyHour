package com.example.happyhour;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class TouchScreenEvents {
    // class member variable to save the X,Y coordinates
    private static float[] lastTouchDownXY = new float[2];

    public static View.OnTouchListener touchListener() {
        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // save the X,Y coordinates
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    lastTouchDownXY[0] = event.getX();
                    lastTouchDownXY[1] = event.getY();
                }
                // let the touch event pass on to whoever needs it
                return false;
            }
        };
    }

    public static View.OnClickListener onClick (final ImageView imageView) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // retrieve the stored coordinates
                float x = lastTouchDownXY[0];
                float y = lastTouchDownXY[1];

                // use the coordinates for whatever
                Toast.makeText(v.getContext(), "x = " + x + ", y = " + y, Toast.LENGTH_LONG).show();

                imageView.setX(x);
                imageView.setY(y);
                imageView.setImageResource(R.drawable.gear);
                imageView.setVisibility(View.VISIBLE);
            }
        };
    }
}
