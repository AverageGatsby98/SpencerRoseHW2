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

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

   TextView redText = null;
   TextView greenText = null;
   TextView blueText = null;
   TextView currentText = null;
   SeekBar redBar = null;
   SeekBar greenBar = null;
   SeekBar blueBar = null;
   SurfaceView currentView;
   ControlSV control;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redText =  findViewById(R.id.redTextView);
        greenText = findViewById(R.id.greenTextView);
        blueText = findViewById(R.id.blueTextView);
        currentText = findViewById(R.id.currentImageTextView);

        redBar = findViewById(R.id.redSeekBar);
        redBar.setOnSeekBarChangeListener(this);
        greenBar = findViewById(R.id.greenSeekBar);
        greenBar.setOnSeekBarChangeListener(this);
        blueBar = findViewById(R.id.blueSeekBar);
        blueBar.setOnSeekBarChangeListener(this);

       currentView = findViewById(R.id.pictureSurfaceView);

       control = new ControlSV(this);
       currentView.setOnTouchListener(control);


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
       if(seekBar == redBar){
            redText.setText("Red: " + progress);
        }
        else if(seekBar == greenBar){
            greenText.setText("Green: " + progress);
        }
        else if(seekBar == blueBar){
            blueText.setText("Blue: " + progress);
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }



}
