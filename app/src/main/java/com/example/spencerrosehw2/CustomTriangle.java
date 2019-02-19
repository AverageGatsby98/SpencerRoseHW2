package com.example.spencerrosehw2;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;

/**
 * @author Spencer Rose
 *
 * This class defines a custom element that is a Triangle
 */
public class CustomTriangle extends CustomElement {

    /** the position and size of the Triangle is stored here */
    int x1;
    int x2;
    int x3;
    int y1;
    int y2;
    int y3;

    int base;
    int height;
    int ROOF_OFFSET =150;
    /** the Triangle's dimensions must be defined at construction */
    public CustomTriangle(String name, int color,
                      int p1x, int p1y, int p2x, int p2y, int p3x, int p3y)
    {
        super(name, color);
        this.x1 = p1x;
        this.x2 = p2x;
        this.x3 = p3x;
        this.y1 = p1y;
        this.y2 = p2y;
        this.y3 = p3y;
        this.base = x1-x3;
        this.height = y1-y2;
    }
    @Override
    public void drawMe(Canvas canvas) {
        /**
         * External Citation
         * Date:     18 February 2019
         * Problem:  How to draw a triangle in android studio
         * Resource: https://stackoverflow.com/questions/25511277/drawing-a-
         * triangle-shape
         * Solution:  Using the "path" object
         */
        Path trianglePath = new Path();
        trianglePath.moveTo(x1, y1);
        trianglePath.lineTo(x2,y2);
        trianglePath.lineTo(x3,y3);
        trianglePath.close();
        canvas.drawPath(trianglePath, myPaint);

    }

    @Override
    public boolean containsPoint(int x, int y) {
        int left = x1;
        int top =y1-ROOF_OFFSET ;
        int right = x3;
        int bottom = y3;
        Rect r = new Rect(left, top, right, bottom);

        return r.contains(x, y);
    }

    @Override
    public int getSize() {
        return (int).5*base*height;
    }

    @Override
    public void drawHighlight(Canvas canvas) {

        Path trianglePath = new Path();
        trianglePath.moveTo(x1, y1);
        trianglePath.lineTo(x2,y2);
        trianglePath.lineTo(x3,y3);
        trianglePath.close();
        canvas.drawPath(trianglePath, highlightPaint);
    }
}
