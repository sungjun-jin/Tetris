package com.example.jinsungjun.tetris;

import android.graphics.Color;
import android.graphics.Paint;

public class Paints {

    Paint wallPaint = new Paint();
    Paint gridPaint = new Paint();
    Paint wallGrid = new Paint();
    Paint blockPaint = new Paint();

    public Paints() {

        //벽돌 페인트
        wallPaint.setColor(Color.rgb(139, 69, 19));
        //벽돌 그리드
        wallGrid.setStyle(android.graphics.Paint.Style.STROKE);
        wallGrid.setColor(Color.WHITE);
        wallGrid.setStrokeWidth(3);

        //일반 그리드
        gridPaint.setColor(Color.GRAY);
        gridPaint.setStyle(android.graphics.Paint.Style.STROKE);
        gridPaint.setStrokeWidth(1);

        //블록 페인트
        blockPaint.setColor(Color.GREEN);

    }

}
