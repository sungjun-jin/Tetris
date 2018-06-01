package com.example.jinsungjun.tetris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    float widthPixels = 0;
    float heightPixels = 0;

    float widthUnit;
    float heightUnit;

    FrameLayout frameLayout;
    Stage stage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayout);

        DisplayMetrics metrics = getResources().getDisplayMetrics();

        widthPixels = metrics.widthPixels;
        heightPixels = metrics.heightPixels;

        widthUnit = widthPixels / Const.WIDTH_GRID_COUNT;
        heightUnit = heightPixels / Const.HEIGHT_GRID_COUNT;

        stage = new Stage(this,widthUnit,heightUnit);

        frameLayout.addView(stage);
    }
}
