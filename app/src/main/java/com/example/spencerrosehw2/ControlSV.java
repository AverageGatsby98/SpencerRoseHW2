package com.example.spencerrosehw2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

/**
 * @author Spencer Rose
 * @version Spring 2019 (2/19/2019)
 * This class is the control for my surface view and handles the onDraw method
 */

public class ControlSV extends SurfaceView{

    //Here I instatiate each of the 6 elements that are drawn on the SurfaceView
    CustomRect house = new CustomRect("house", 0xFF8B4513, 50,
            300, 650, 700);
    CustomRect trunk = new CustomRect("trunk", 0xFF8B4513, 1000,
            400, 1050, 700);
    CustomCircle treeTop = new CustomCircle("tree top",0xFF005F00,
            1025, 300, 100 );
    CustomRect door = new CustomRect("door", 0xFF000000, 250,
            400, 450, 700);
    CustomRect ground = new CustomRect("ground", 0xFF00AF00, 0,
            700, 1250, 950);
    CustomTriangle roof = new CustomTriangle("roof", 0xFFFF0000,
            50, 300, 350, 150, 650, 300);

    //These are the three required constructors
    public ControlSV(Context context) {
        super(context);
        init();
    }

    public ControlSV(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    public ControlSV (Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init();
    }

    //an initialize method that makes sure you can actually draw on the
    //SurfaceView
    private void init(){
        setWillNotDraw(false);

    }


    @Override
    protected void onDraw(Canvas canvas){

        //I set the canvas to white and then draw each of the elements on it
        canvas.drawColor(0xFFFFFFFF);
        roof.drawMe(canvas);
        house.drawMe(canvas);
        door.drawMe(canvas);
        ground.drawMe(canvas);
        trunk.drawMe(canvas);
        treeTop.drawMe(canvas);



    }


}
