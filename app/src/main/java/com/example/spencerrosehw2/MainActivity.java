package com.example.spencerrosehw2;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * @author Spencer Rose
 *@version Spring 2019 (2/19/2019)
 * This is the MainActivity class
 */
public class MainActivity extends AppCompatActivity  {

   TextView redText = null;
   TextView greenText = null;
   TextView blueText = null;
   TextView currentText = null;
   SeekBar redBar = null;
   SeekBar greenBar = null;
   SeekBar blueBar = null;
   SurfaceView currentView;
   ControlSV control;
   ListenerSV listener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //This block finds and sets all of the TextViews
        redText =  findViewById(R.id.redTextView);
        greenText = findViewById(R.id.greenTextView);
        blueText = findViewById(R.id.blueTextView);
        currentText = findViewById(R.id.currentImageTextView);

        //this block finds and sets the seekBars
        redBar = findViewById(R.id.redSeekBar);
        greenBar = findViewById(R.id.greenSeekBar);
        blueBar = findViewById(R.id.blueSeekBar);

       //this finds the surfaceview
       currentView = findViewById(R.id.pictureSurfaceView);
       //I instatiate the ControlSV and pass in the current context
       control = new ControlSV(this);
       //instantiate a ListenerSV by passing in all of my views and bars
       listener = new ListenerSV(control, redBar, greenBar, blueBar, redText,
               greenText, blueText, currentText, currentView);





    }







}
