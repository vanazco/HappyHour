package com.example.happyhour.Games.Sebas.Pintar;

import android.util.SparseIntArray;

import com.example.happyhour.R;

public class Imagenes {
    private SparseIntArray wallpaper = new SparseIntArray();

    Imagenes() {
        wallpaper.put(1, R.drawable.owl);
        wallpaper.put(2, R.drawable.gato);
        wallpaper.put(3, R.drawable.mono);
        wallpaper.put(4, R.drawable.oso);
    }

    public SparseIntArray getWallpaper() {
        return wallpaper;
    }
}
