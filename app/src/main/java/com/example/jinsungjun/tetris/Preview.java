package com.example.jinsungjun.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Preview extends View {

    Paints paints;
    float unit;
    Block currentblock;
    BlockFactory blockFactory;

    public Preview(Context context, float unit) {
        super(context);
        paints = new Paints();
        this.unit = unit;
        blockFactory = new BlockFactory();
    }

    //맨 처음 상태의 preview
    int previewMap[][] = {

            {0, 0, 0, 0, 0, 9},
            {0, 0, 0, 0, 0, 9},
            {0, 0, 0, 0, 0, 9},
            {0, 0, 0, 0, 0, 9},
            {9, 9, 9, 9, 9, 9},

    };

    //임의의 테트리스 블럭을 가져오는 함수
    public void getNewBlock() {

        currentblock = blockFactory.newBlock();
    }

    public Block sendBlockToStage() {

        return this.currentblock;
    }

    public void initPrevBlock() {

        getNewBlock();
        setBlockToPrev();
        invalidate();
    }


    //테트리스 블럭을 preview에 배열로 넣어준다
    public void setBlockToPrev() {

        //옮기는 작업만 잘하면 된다.
        for (int y = 0; y < 4; y++) {

            for (int x = 0; x < 4; x++) {

                previewMap[y][x + 1] = currentblock.block[currentblock.rotation][y][x];
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Paint tempPaint;

        for (int y = 0; y < previewMap.length; y++) {

            for (int x = 0; x < previewMap[0].length; x++) {

                if (previewMap[y][x] > 0 && previewMap[y][x] < 8) {

                    tempPaint = paints.blockPaint;

                    canvas.drawRect(
                            (x + Const.STAGE_WIDTH) * unit, //x + Stage의 가로 = preview의 자리에 넣어준다
                            y * unit,
                            (x + Const.STAGE_WIDTH) * unit + unit, //preview의 자리에 넣어준다
                            y * unit + unit,
                            tempPaint
                    );
                } else if (previewMap[y][x] == 9) {

                    tempPaint = paints.wallPaint;
                    canvas.drawRect(
                            (x + Const.STAGE_WIDTH) * unit,
                            y * unit,
                            (x + Const.STAGE_WIDTH) * unit + unit,
                            y * unit + unit,
                            tempPaint
                    );
                    //그 자리 그대로, 벽돌 그리드 그려주기
                    tempPaint = paints.wallGrid;
                    canvas.drawRect(
                            (x + Const.STAGE_WIDTH) * unit,
                            y * unit,
                            (x + Const.STAGE_WIDTH) * unit + unit,
                            y * unit + unit,
                            tempPaint
                    );
                } else if (previewMap[y][x] == 0) {
                    //일반 그리드

                    tempPaint = paints.gridPaint;

                    canvas.drawRect(
                            (x + Const.STAGE_WIDTH) * unit,
                            y * unit,
                            (x + Const.STAGE_WIDTH) * unit + unit,
                            y * unit + unit,
                            tempPaint
                    );
                }
            }
        }

    }



}
