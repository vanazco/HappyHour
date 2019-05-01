package com.example.happyhour;

import android.util.SparseIntArray;

class WallPaper {
    private SparseIntArray wallpaper = new SparseIntArray();

    WallPaper() {
        wallpaper.put(1, R.drawable.wallpaper1);
        wallpaper.put(2, R.drawable.wallpaper2);
        wallpaper.put(3, R.drawable.wallpaper3);
        wallpaper.put(4, R.drawable.wallpaper4);
        wallpaper.put(5, R.drawable.wallpaper5);
    }

    SparseIntArray getWallpaper() {
        return wallpaper;
    }
}
