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

    //stageMap과 previewMap 합치기
    int[][] allMap = new int[Const.heightGridCount][Const.widthGridCount];


    public void setAllmap() {

        //stageMap 먼저 AllMap에 옮겨준다
        for (int y = 0; y < stageMap.length; y++) {

            for (int x = 0; x < stageMap[0].length; x++) {

                allMap[y][x] = stageMap[y][x];
            }
        }
        //previewMap 옮기기
        for (int y = 0; y < previewMap.length; y++) {
            //stageMap이 끝난 x좌표부터 옮겨준다, y축은 그대로 0
            for (int x = stageMap[0].length; x < allMap[0].length; x++) {

                allMap[y][x] = previewMap[y][x - stageMap[0].length];
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //Stage와 Preview를 전체 맵에 옮겨주는 함수
        setAllmap();

        Paint wallPaint = new Paint();
        Paint gridPaint = new Paint();
        Paint wallGrid = new Paint();
        Paint tempPaint;

        //벽돌 페인트
        wallPaint.setColor(Color.rgb(139, 69, 19));
        //벽돌 그리드
        wallGrid.setStyle(Paint.Style.STROKE);
        wallGrid.setColor(Color.WHITE);
        wallGrid.setStrokeWidth(3);

        //일반 그리드
        gridPaint.setColor(Color.GRAY);
        gridPaint.setStyle(Paint.Style.STROKE);
        gridPaint.setStrokeWidth(1);

        //스테이지맵과 프리뷰 맵을 화면에 그린다
        for (int y = 0; y < allMap.length; y++) {

            for (int x = 0; x < allMap[0].length; x++) {

                if (allMap[y][x] == 9) {
                    //벽돌 그려주기
                    tempPaint = wallPaint;
                    canvas.drawRect(
                            x * widthUnit,
                            y * widthUnit,
                            x * widthUnit + widthUnit,
                            y * widthUnit + widthUnit,
                            tempPaint
                    );
                    //그 자리 그대로, 벽돌 그리드 그려주기
                    tempPaint = wallGrid;
                    canvas.drawRect(
                            x * widthUnit,
                            y * widthUnit,
                            x * widthUnit + widthUnit,
                            y * widthUnit + widthUnit,
                            tempPaint
                    );

                } else if (allMap[y][x] == 0) {
                    //일반 그리드

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
