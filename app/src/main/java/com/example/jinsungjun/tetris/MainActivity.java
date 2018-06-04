package com.example.jinsungjun.tetris;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    float widthPixels = 0;
    float unit;

    FrameLayout frameLayout;

    AllMap allMap;
    Stage stage;
    Preview preview;

    Button btnDown,btnLeft,btnRight,btnRotate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = findViewById(R.id.frameLayout);


        DisplayMetrics metrics = getResources().getDisplayMetrics();
        widthPixels = metrics.widthPixels;
        unit = widthPixels / Const.WIDTH_GRID_COUNT;


        preview = new Preview(this,unit);
        stage = new Stage(this,unit,preview);
        allMap = new AllMap(this,stage,preview);


        btnDown = findViewById(R.id.btnDown);
        btnLeft = findViewById(R.id.btnLeft);
        btnRight = findViewById(R.id.btnRight);
        btnRotate = findViewById(R.id.btnRotate);

        btnDown.setOnClickListener(listener);
        btnRight.setOnClickListener(listener);
        btnLeft.setOnClickListener(listener);
        btnRotate.setOnClickListener(listener);


        frameLayout.addView(allMap);

        preview.initPrevBlock();
        stage.initStageBlock();



    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            switch (view.getId()) {

                case R.id.btnDown :
                    stage.currentblock.down();
                    stage.setBlockToStage();
                    stage.down();
                    break;
                case R.id.btnLeft :
                    stage.currentblock.left();
                    stage.setBlockToStage();
                    stage.left();
                    break;
                case R.id.btnRight:
                    stage.currentblock.right();
                    stage.setBlockToStage();
                    stage.right();
                    break;
                case R.id.btnRotate :
                    stage.rotate();
                    stage.setBlockToStage();
                    break;
            }
            allMap.invalidate();
        }
    };


}
