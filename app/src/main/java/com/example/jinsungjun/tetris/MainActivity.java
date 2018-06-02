package com.example.jinsungjun.tetris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    float widthPixels = 0;
    float unit;

    FrameLayout frameLayout;

    AllMap allMap;
    Stage stage;
    Preview preview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayout);

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        widthPixels = metrics.widthPixels;
        unit = widthPixels / Const.WIDTH_GRID_COUNT;

        allMap = new AllMap(this,unit);
        stage = new Stage(this,unit);
        preview = new Preview(this,unit);

        frameLayout.addView(allMap);

        init();

    }

    //처음 테트리스 맵 초기화
    public void init() {

        allMap.initMap();
    }
}
