package com.example.jinsungjun.tetris;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class AllMap extends View {

    //전체 맵
    int[][] allMap = new int[Const.HEIGHT_GRID_COUNT][Const.WIDTH_GRID_COUNT];
    float unit;
    Paints paints;
    Stage stage;
    Preview preview;


    public AllMap(Context context, float unit) {
        super(context);
        this.unit =  unit;
        paints = new Paints();
        stage = new Stage(context,unit);
        preview = new Preview(context,unit);
    }

    public void setAllmap() {

        //stageMap 먼저 AllMap에 옮겨준다
        for (int y = 0; y < stage.stageMap.length; y++) {

            for (int x = 0; x < stage.stageMap[0].length; x++) {

                allMap[y][x] = stage.stageMap[y][x];
            }
        }
        //previewMap 옮기기
        for (int y = 0; y < preview.previewMap.length; y++) {
            //stageMap이 끝난 x좌표부터 옮겨준다, y축은 그대로 0
            for (int x = 0; x < preview.previewMap[0].length; x++) {
                allMap[y][x+Const.STAGE_WIDTH] = preview.previewMap[y][x];
            }
        }
    }

    public void drawAllMap(Canvas canvas) {

        //Stage와 Preview를 전체 맵에 옮겨주는 함수
        Paint tempPaint;

        //전체 맵을 화면에 그린다
        for (int y = 0; y < allMap.length; y++) {

            for (int x = 0; x < allMap[0].length; x++) {

                if (allMap[y][x] == 9) {
                    //벽돌 그려주기
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

                } else if (allMap[y][x] == 0) {
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

    public void initMap() {
        setAllmap();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawAllMap(canvas);
        //동일한 캔버스를 사용해야하므로 여기 캔버스를 공유해두자
        preview.initPrevBlock();
        preview.drawBlockOnPrev(canvas);
    }
}
