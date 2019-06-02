package com.example.happyhour.Games.Adri;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.DragEvent;
import android.view.View;

import com.example.happyhour.R;

public class MyDragListener implements View.OnDragListener {
    private Drawable enterShape;
    private Drawable normalShape;
    private int background;

    MyDragListener(Context context, String figuras) {

        switch (figuras){

            case "triangulo":
                enterShape = context.getResources().getDrawable(R.drawable.triangulo1);
                normalShape = context.getResources().getDrawable(R.drawable.trianguloshade);
                background = R.drawable.triangulo1;
                break;
            case "rombo":
                enterShape = context.getResources().getDrawable(R.drawable.rombo2);
                normalShape = context.getResources().getDrawable(R.drawable.romboshade);
                background = R.drawable.rombo2;
                break;
            case "trapezi":
                enterShape = context.getResources().getDrawable(R.drawable.pentagon);
                normalShape = context.getResources().getDrawable(R.drawable.pentagonshade);
                background = R.drawable.pentagon;
                break;
            case "circulo":
                enterShape = context.getResources().getDrawable(R.drawable.circulo1);
                normalShape = context.getResources().getDrawable(R.drawable.circuloshade);
                background = R.drawable.circulo1;
                break;
            case "cuadrado":
                enterShape = context.getResources().getDrawable(R.drawable.cuadrado);
                normalShape = context.getResources().getDrawable(R.drawable.cuadrado2);
                background = R.drawable.cuadrado;
                break;
            case "rectangulo":
                enterShape = context.getResources().getDrawable(R.drawable.rectan);
                normalShape = context.getResources().getDrawable(R.drawable.rectan2);
                background = R.drawable.rectan;
                break;
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        View view = (View) event.getLocalState();

        switch (event.getAction()) {
            case DragEvent.ACTION_DRAG_STARTED:
                // do nothing
                break;
            case DragEvent.ACTION_DRAG_ENTERED:
                if (view.getBackground().getCurrent().getConstantState() == enterShape.getCurrent().getConstantState()) {
                    v.setBackgroundDrawable(enterShape);
                }
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                if (view.getBackground().getCurrent().getConstantState() == enterShape.getCurrent().getConstantState()) {
                    v.setBackground(normalShape);
                }
                break;
            case DragEvent.ACTION_DROP:
                if (view.getBackground().getCurrent().getConstantState() == enterShape.getCurrent().getConstantState()) {
                    view.setVisibility(View.INVISIBLE);
                }
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                default:
                break;
        }
        return true;
    }
}