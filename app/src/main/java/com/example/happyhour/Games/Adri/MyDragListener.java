package com.example.happyhour.Games.Adri;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.happyhour.R;

public class MyDragListener implements View.OnDragListener {
    private Drawable enterShape;
    private Drawable normalShape;

    MyDragListener(Context context, String figuras) {

        switch (figuras){

            case "triangulo":
                enterShape = context.getResources().getDrawable(R.drawable.triangulo1);
                normalShape = context.getResources().getDrawable(R.drawable.triangulo1);
                break;


            case "rombo":
                enterShape = context.getResources().getDrawable(R.drawable.rombo2);
                normalShape = context.getResources().getDrawable(R.drawable.rombo2);
                break;


            case "trapezi":
                enterShape = context.getResources().getDrawable(R.drawable.pentagon);
                normalShape = context.getResources().getDrawable(R.drawable.pentagon);
                break;

            case "circulo":
                enterShape = context.getResources().getDrawable(R.drawable.circulo1);
                normalShape = context.getResources().getDrawable(R.drawable.circulo1);
                break;

            case "cuadrado":
                enterShape = context.getResources().getDrawable(R.drawable.cuadrado);
                normalShape = context.getResources().getDrawable(R.drawable.cuadrado);
                break;

            case "rectangulo":
                enterShape = context.getResources().getDrawable(R.drawable.rectan);
                normalShape = context.getResources().getDrawable(R.drawable.rectan);
                break;
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                // do nothing
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                v.setBackgroundDrawable(enterShape);
                break;

            case DragEvent.ACTION_DRAG_EXITED:
                break;
            case DragEvent.ACTION_DROP:
                View view = (View) event.getLocalState();
                ViewGroup owner = (ViewGroup) view.getParent();
                owner.removeView(view);
                //LinearLayout container = (LinearLayout) v;
               // container.addView(view);
                view.setVisibility(View.VISIBLE);
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                default:
                break;
        }
        return true;
    }
}