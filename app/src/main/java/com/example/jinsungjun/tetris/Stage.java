package com.example.jinsungjun.tetris;

import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class Stage extends View {


    Paints paints;

    float unit;

    Block currentblock;
    Preview preview;

    public Stage(Context context, float unit, Preview preview) {
        super(context);
        this.unit = unit;
        this.preview = preview;
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

    public void getBlockFromPrev() {

        currentblock = preview.sendBlockToStage();
    }

    //테트리스 블럭을 preview에 배열로 넣어준다
    public void setBlockToStage() {

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {

                stageMap[y + currentblock.y][x + currentblock.x] = currentblock.currentBlock()[y][x];
            }
        }
    }

    public void down() {

        for (int x = 0; x < 4; x++) {

            stageMap[currentblock.y - 1][x + currentblock.x] = 0;
        }
    }

    public void left() {

        for (int y = 0; y < 4; y++) {

            for (int x = 0; x < 4; x++) {

                if (stageMap[y + currentblock.y][x + currentblock.x] > 0 && stageMap[y + currentblock.y][x + currentblock.x + 1] == 0) {

                    stageMap[y + currentblock.y][x + currentblock.x + 1] = 0;

                } else if (x == 3 && stageMap[y + currentblock.y][x + currentblock.x] > 0) {

                    stageMap[y + currentblock.y][x + currentblock.x + 1] = 0;
                }

            }
        }
    }

    public void right() {

        for (int y = 0; y < 4; y++) {

            for (int x = 0; x < 4; x++) {

                if (stageMap[y + currentblock.y][currentblock.x] > 0 && stageMap[y + currentblock.y][currentblock.x - 1] == 0) {

                    stageMap[y + currentblock.y][currentblock.x - 1] = 0;

                } else if (x == 0 && stageMap[y + currentblock.y][ currentblock.x] > 0) {

                    stageMap[y + currentblock.y][currentblock.x - 1] = 0;
                }
            }
        }
    }

    public void rotate() {

        currentblock.rotate();

    }

    public boolean collisionCheck() {



        return true;
    }


    public void initStageBlock() {

        getBlockFromPrev();
        setBlockToStage();
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        Paint tempPaint;

        for (int y = 0; y < stageMap.length; y++) {

            for (int x = 0; x < stageMap[0].length; x++) {

                if (stageMap[y][x] > 0 && stageMap[y][x] < 8) {

                    tempPaint = paints.blockPaint;

                    canvas.drawRect
                            (x * unit, //x + Stage의 가로 = preview의 자리에 넣어준다
                                    y * unit,
                                    x * unit + unit, //preview의 자리에 넣어준다
                                    y * unit + unit,
                                    tempPaint
                            );
                } else if (stageMap[y][x] == 9) {

                    tempPaint = paints.wallPaint;
                    canvas.drawRect(
                            x * unit,
                            y * unit,
                            x * unit + unit,
                            y * unit + unit,
                            tempPaint
                    );
                    //그 자리 그대로, 벽돌 그리드 그려주기
                    tempPaint = paints.wallGrid;
                    canvas.drawRect(
                            x * unit,
                            y * unit,
                            x * unit + unit,
                            y * unit + unit,
                            tempPaint
                    );

                } else if (stageMap[y][x] == 0) {
                    //일반 그리드

                    tempPaint = paints.gridPaint;

                    canvas.drawRect(
                            x * unit,
                            y * unit,
                            x * unit + unit,
                            y * unit + unit,
                            tempPaint
                    );
                }
            }
        }
    }

}
