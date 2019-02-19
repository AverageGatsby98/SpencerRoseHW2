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

        redText =  findViewById(R.id.redTextView);
        greenText = findViewById(R.id.greenTextView);
        blueText = findViewById(R.id.blueTextView);
        currentText = findViewById(R.id.currentImageTextView);

        redBar = findViewById(R.id.redSeekBar);

        greenBar = findViewById(R.id.greenSeekBar);

        blueBar = findViewById(R.id.blueSeekBar);


       currentView = findViewById(R.id.pictureSurfaceView);

       control = new ControlSV(this);
       listener = new ListenerSV(control, redBar, greenBar, blueBar, redText, greenText, blueText, currentText, currentView);
       currentView.setOnTouchListener(listener);



    }







}
