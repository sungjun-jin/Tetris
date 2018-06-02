package com.example.jinsungjun.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class Preview extends View {

    Paints paints;
    float widthUnit;
    Block block;
    BlockFactory blockFactory;

    public Preview(Context context, float widthUnit) {
        super(context);
        paints = new Paints();
        this.widthUnit = widthUnit;
        blockFactory = new BlockFactory();
    }
    //맨 처음 상태의 preview
    int previewMap[][] = {

            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {9, 9, 9, 9, 9, 9},

    };

    //임의의 테트리스 블럭을 가져오는 함수
    public void setNewBlock() {

        Block block = blockFactory.newBlock();
        this.block = block;
    }
    //테트리스 블럭을 preview에 배열로 넣어준다
    public void setBlockToPrev() {

        //옮기는 작업만 잘하면 된다.
        for (int y = 0; y < 4; y++) {

            for (int x = 0; x < 4; x++) {

                previewMap[y][x+1] = block.block[block.rotation][y][x];
            }
        }
    }

    //테트리스 블럭을 preview에 그려준다
    public void drawBlockOnPrev(Canvas canvas) {

        Paint tempPaint;

        for (int y = 0; y < previewMap.length; y++) {

            for (int x = 0; x < previewMap[0].length; x++) {

                if (previewMap[y][x] > 0 && previewMap[y][x] < 8) {

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

    public void initPrevBlock() {
        //임의의 블럭을 가져온 다음
        setNewBlock();
        //블럭을 프리뷰로 옮긴다
        setBlockToPrev();

    }

}
