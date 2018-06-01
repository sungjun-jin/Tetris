package com.example.jinsungjun.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Stage extends View {

    float widthUnit;
    float heightUnit;
    Preview preview;
    Paints paints;

    public Stage(Context context, float widthUnit, float heightUnit) {
        super(context);
        this.widthUnit = widthUnit;
        this.heightUnit = heightUnit;
        preview = new Preview(context,widthUnit);
        paints = new Paints();
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

    //stageMap과 previewMap 합치기
    int[][] allMap = new int[Const.HEIGHT_GRID_COUNT][Const.WIDTH_GRID_COUNT];


    public void setAllmap() {

        //stageMap 먼저 AllMap에 옮겨준다
        for (int y = 0; y < stageMap.length; y++) {

            for (int x = 0; x < stageMap[0].length; x++) {

                allMap[y][x] = stageMap[y][x];
            }
        }
        //previewMap 옮기기
        for (int y = 0; y < preview.previewMap.length; y++) {
            //stageMap이 끝난 x좌표부터 옮겨준다, y축은 그대로 0
            for (int x = Const.STAGE_WIDTH; x < allMap[0].length; x++) {

                allMap[y][x] = preview.previewMap[y][x - Const.STAGE_WIDTH];
            }
        }
    }

    public void drawAllMap(Canvas canvas) {

        //Stage와 Preview를 전체 맵에 옮겨주는 함수
       setAllmap();

       Paint tempPaint;

        //스테이지맵과 프리뷰 맵을 화면에 그린다
        for (int y = 0; y < allMap.length; y++) {

            for (int x = 0; x < allMap[0].length; x++) {

                if (allMap[y][x] == 9) {
                    //벽돌 그려주기
                    tempPaint = paints.wallPaint;
                    canvas.drawRect(
                            x * widthUnit,
                            y * widthUnit,
                            x * widthUnit + widthUnit,
                            y * widthUnit + widthUnit,
                            tempPaint
                    );
                    //그 자리 그대로, 벽돌 그리드 그려주기
                    tempPaint = paints.wallGrid;
                    canvas.drawRect(
                            x * widthUnit,
                            y * widthUnit,
                            x * widthUnit + widthUnit,
                            y * widthUnit + widthUnit,
                            tempPaint
                    );

                } else if (allMap[y][x] == 0) {
                    //일반 그리드

                    tempPaint = paints.gridPaint;

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

        preview.drawBlock(canvas);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawAllMap(canvas);
    }
}
