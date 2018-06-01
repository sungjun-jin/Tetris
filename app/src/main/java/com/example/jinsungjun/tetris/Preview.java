package com.example.jinsungjun.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Preview extends View {

    Paints paints;
    float widthUnit;

    public Preview(Context context, float widthUnit) {
        super(context);
        paints = new Paints();
        this.widthUnit = widthUnit;
    }

    int previewMap[][] = {

            {9, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 9},
            {9, 0, 0, 0, 0, 9},
            {9, 9, 9, 9, 9, 9},

    };

    public void setBlock(int[][] block) {

        for (int y = 0; y < block.length; y++) {

            for (int x = 0; x < block[0].length; x++) {

                previewMap[y][x] = block[y][x];
            }
        }
    }

    public void drawBlock(Canvas canvas) {

        Paint tempPaint;

        for (int y = 0; y < previewMap.length; y++) {

            for (int x = 0; x < previewMap[0].length; x++) {


                if (previewMap[y][x] == 1) {

                    tempPaint = paints.blockPaint;

                    canvas.drawRect(
                            (x + Const.STAGE_WIDTH) * widthUnit, //x + Stage의 가로 = preview의 자리에 넣어준다
                            y * widthUnit,
                            (x + Const.STAGE_WIDTH) * widthUnit + widthUnit, //preview의 자리에 넣어준다
                            y * widthUnit + widthUnit,
                            tempPaint
                    );
                }
            }
        }
    }
}
