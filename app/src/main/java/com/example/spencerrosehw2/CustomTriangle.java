package com.example.spencerrosehw2;

import android.graphics.Canvas;
import android.graphics.Rect;

public class CustomTriangle extends CustomElement {

    /** the position and size of the Triangle is stored here */


    /** the Triangle's dimensions must be defined at construction */
    public CustomTriangle(String name, int color,
                      int p1x, int p1y, int p2x, int p2y, int p3x, int p4y)
    {
        super(name, color);


    }
    @Override
    public void drawMe(Canvas canvas) {

    }

    @Override
    public boolean containsPoint(int x, int y) {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void drawHighlight(Canvas canvas) {

    }
}
