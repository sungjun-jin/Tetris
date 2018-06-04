package com.example.jinsungjun.tetris;



import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;


public class AllMap extends View {

    //전체 맵

    Paints paints;
    Stage stage;
    Preview preview;


    public AllMap(Context context, Stage stage, Preview preview) {
        super(context);
        paints = new Paints();
        this.stage = stage;
        this.preview = preview;
    }




    @SuppressLint("WrongCall")
    @Override
    protected void onDraw(Canvas canvas) {
        stage.onDraw(canvas);
        preview.onDraw(canvas);
    }
}
