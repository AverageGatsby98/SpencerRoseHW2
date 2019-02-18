/**
 * @author Spencer Rose
 * This class is the control for my surface view (maybe?)
 */

package com.example.spencerrosehw2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;


public class ControlSV extends SurfaceView implements View.OnTouchListener{
    CustomRect testRec;
    CustomRect house;
    CustomRect trunk;
    CustomCircle treeTop;
    CustomRect door;
    CustomRect ground;
    CustomTriangle roof;
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

    private void init(){
        setWillNotDraw(false);
        this.setOnTouchListener(this);
    }


    @Override
    protected void onDraw(Canvas canvas){

        canvas.drawColor(0xFFFFFFFF);
        testRec = new CustomRect("test", 0xFF102289, 10, 10, 50, 50);
        testRec.drawMe(canvas);
        testRec.drawHighlight(canvas);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

            if(testRec.containsPoint((int)event.getX(), (int)event.getY())){
               // currentText.setText(""+testRec.getName());//how do I set the text view??
            }



        return false;
    }
}
