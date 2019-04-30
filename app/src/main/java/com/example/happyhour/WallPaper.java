package com.example.happyhour;

import java.util.HashMap;
import java.util.Map;

class WallPaper {
    private Map<Integer, Integer> wallpaper = new HashMap<>();

    WallPaper() {
        wallpaper.put(1, R.drawable.wallpaper1);
        wallpaper.put(2, R.drawable.wallpaper2);
        wallpaper.put(3, R.drawable.wallpaper3);
        wallpaper.put(4, R.drawable.wallpaper4);
        wallpaper.put(5, R.drawable.wallpaper5);
    }

    Map<Integer, Integer> getWallpaper() {
        return wallpaper;
    }
}
