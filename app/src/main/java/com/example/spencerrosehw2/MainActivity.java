package com.example.spencerrosehw2;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

   TextView redText = null;
   TextView greenText = null;
   TextView blueText = null;
   SeekBar redBar = null;
   SeekBar greenBar = null;
   SeekBar blueBar = null;
   SurfaceView currentView = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redText =  findViewById(R.id.redTextView);
        greenText = findViewById(R.id.greenTextView);
        blueText = findViewById(R.id.blueTextView);

        redBar = findViewById(R.id.redSeekBar);
        redBar.setOnSeekBarChangeListener(this);
        greenBar = findViewById(R.id.greenSeekBar);
        greenBar.setOnSeekBarChangeListener(this);
        blueBar = findViewById(R.id.blueSeekBar);
        blueBar.setOnSeekBarChangeListener(this);

        currentView = findViewById(R.id.pictureSurfaceView);



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
