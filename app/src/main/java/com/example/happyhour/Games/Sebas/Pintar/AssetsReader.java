package com.example.happyhour.Games.Sebas.Pintar;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

class AssetsReader {

    static Drawable getDrawableFromAssets(Context context, String uri) {
        Drawable drawable = null;

        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(uri);
            drawable = Drawable.createFromStream(inputStream, null);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return drawable;
    }
}
