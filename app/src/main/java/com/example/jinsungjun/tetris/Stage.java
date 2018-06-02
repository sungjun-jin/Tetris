package com.example.jinsungjun.tetris;

import android.content.Context;
import android.view.View;

public class Stage extends View {

    Preview preview;
    Paints paints;

    float widthUnit;

    public Stage(Context context,float widthUnit) {
        super(context);
        this.widthUnit = widthUnit;
        preview = new Preview(context, widthUnit);
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


}
