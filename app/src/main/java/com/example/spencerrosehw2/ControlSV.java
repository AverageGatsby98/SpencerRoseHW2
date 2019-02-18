/**
 * @author Spencer Rose
 * This class is the control for my surface view (maybe?)
 */

package com.example.spencerrosehw2;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceView;

public class ControlSV extends SurfaceView {
    public ControlSV(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    @Override
    protected void onDraw(Canvas canvas){

        canvas.drawColor(0xFFFFFFFF);
        CustomRect testRec = new CustomRect("test", 0xFF102289, 10, 10, 50, 50);
        testRec.drawMe(canvas);
        testRec.drawHighlight(canvas);
    }

}
