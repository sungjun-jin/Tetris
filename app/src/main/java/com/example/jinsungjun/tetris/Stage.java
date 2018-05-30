package com.example.jinsungjun.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Stage extends View {

    float widthUnit;
    float heightUnit;

    public Stage(Context context, float widthUnit, float heightUnit) {
        super(context);
        this.widthUnit = widthUnit;
        this.heightUnit = heightUnit;
    }

    int stageMap[][] = {

            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
            {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9}

    };

    int previewMap[][] = {

            {0, 0, 0, 0, 0, 9},
            {0, 0, 0, 0, 0, 9},
            {0, 0, 0, 0, 0, 9},
            {0, 0, 0, 0, 0, 9},
            {9, 9, 9, 9, 9, 9},

    };

    int[][] allMap = new int[20][18];


    public void setAllmap() {


        for (int y = 0; y < stageMap.length; y++) {

            for (int x = 0; x < stageMap[0].length; x++) {

                allMap[y][x] = stageMap[y][x];
            }
        }

        for (int y = 0; y < previewMap.length; y++) {

            for (int x = stageMap[0].length; x < allMap[0].length; x++) {

                allMap[y][x] = previewMap[y][x - stageMap[0].length];
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        setAllmap();

        Paint wallPaint = new Paint();
        Paint gridPaint = new Paint();
        Paint tempPaint;

        wallPaint.setColor(Color.rgb(255, 222, 173));
        gridPaint.setColor(Color.GRAY);
        gridPaint.setStyle(Paint.Style.STROKE);
        gridPaint.setStrokeWidth(1);

        //스테이지맵과 프리뷰 맵을 화면에 그린다
        for (int y = 0; y < allMap.length; y++) {

            for (int x = 0; x < allMap[0].length; x++) {

                if (allMap[y][x] == 9) {

                    tempPaint = wallPaint;
                    canvas.drawRect(
                            x * widthUnit,
                            y * widthUnit,
                            x * widthUnit + widthUnit,
                            y * widthUnit + widthUnit,
                            tempPaint
                    );


                } else if (allMap[y][x] == 0) {

                    tempPaint = gridPaint;

                    canvas.drawRect(
                            x * widthUnit,
                            y * widthUnit,
                            x * widthUnit + widthUnit,
                            y * widthUnit + widthUnit,
                            tempPaint
                    );
                }
            }
        }

    }
}
