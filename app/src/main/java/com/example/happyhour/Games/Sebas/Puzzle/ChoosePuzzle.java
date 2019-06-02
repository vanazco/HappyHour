package com.example.happyhour.Games.Sebas.Puzzle;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.happyhour.Estructura.Games;
import com.example.happyhour.Games.Sebas.ImageAdapter;
import com.example.happyhour.R;

import java.io.IOException;

public class ChoosePuzzle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_sebas_choose_puzzle);

        AssetManager am = getAssets();
        try {
            // List all files in "Assets/puzzle"
            final String[] files  = am.list("puzzle");

            GridView grid = findViewById(R.id.grid);
            // Create adapter for the grid
            grid.setAdapter(new ImageAdapter(this, "puzzle"));
            grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(getApplicationContext(), PuzzleActivity.class);
                    // Here it's needed to do a SUBSTRING to get the name of the file
                    intent.putExtra("assetName", files[i % files.length]);
                    startActivity(intent);
                }
            });
        } catch (IOException e) {
            Toast.makeText(this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
        }

        findViewById(R.id.goBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChoosePuzzle.this, Games.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, Games.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
