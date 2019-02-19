package com.example.spencerrosehw2;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author Spencer Rose
 *
 * This class acts as the listener for the seekBars and the SurfaceView OnTouch
 */
public class ListenerSV implements View.OnTouchListener,
        SeekBar.OnSeekBarChangeListener{

//These are global variables I will need in this class
    private TextView redText;
    private TextView greenText;
    private TextView blueText;
    private TextView currentText;
    private SeekBar redBar;
    private SeekBar greenBar;
    private SeekBar blueBar;
    private ControlSV control;
    private SurfaceView theView;
    private  CustomElement currentElement;
    
    //The constructor for my ListenerSV
    public ListenerSV(ControlSV controller, SeekBar redBar, SeekBar greenBar,
                      SeekBar blueBar, TextView redText, TextView greenText,
                      TextView blueText, TextView currentImage,
                      SurfaceView view){
        this.redBar = redBar;
        redBar.setOnSeekBarChangeListener(this);
        this.blueBar = blueBar;
        blueBar.setOnSeekBarChangeListener(this);
        this.greenBar = greenBar;
        greenBar.setOnSeekBarChangeListener(this);

        this.redText = redText;
        this.greenText = greenText;
        this.blueText = blueText;

        this.currentText = currentImage;

        this.control = controller;
        this.theView = view;
        theView.setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
      int xPos = (int) event.getX();
      int yPos = (int) event.getY();
      int redVal =0;
      int greenVal =0;
      int blueVal =0;
      int currentColor =0;

      if(control.door.containsPoint(xPos, yPos)) {
          currentText.setText(""+control.door.getName());
          /**
           * External Citation
           * Date:     18 February 2019
           * Problem:  How to extract RGB values from a color
           * Resource: https://stackoverflow.com/questions/7427141/how-to-get-
           *           rgb-value-from-hexadecimal-color-code-in-java
           * Solution:  the equations you see below (color >> 16) & 0xFF
           */
          currentColor = control.door.getColor();
          redVal = (currentColor >> 16) & 0xFF;
          greenVal = (currentColor >> 8) & 0xFF;
          blueVal = (currentColor >> 0) & 0xFF;
          redBar.setProgress(redVal);
          greenBar.setProgress(greenVal);
          blueBar.setProgress(blueVal);
          currentElement = control.door;
          theView.invalidate();
          return true;
      }
      else if( control.house.containsPoint(xPos, yPos)){
          currentText.setText((""+control.house.getName()));
          currentColor = control.house.getColor();
          redVal = (currentColor >> 16) & 0xFF;
          greenVal = (currentColor >> 8) & 0xFF;
          blueVal = (currentColor >> 0) & 0xFF;
          redBar.setProgress(redVal);
          greenBar.setProgress(greenVal);
          blueBar.setProgress(blueVal);
          currentElement = control.house;
          theView.invalidate();
          return true;
      }
      else if( control.roof.containsPoint(xPos, yPos)){
          currentText.setText(""+ control.roof.getName());
          currentColor = control.roof.getColor();
          redVal = (currentColor >> 16) & 0xFF;
          greenVal = (currentColor >> 8) & 0xFF;
          blueVal = (currentColor >> 0) & 0xFF;
          redBar.setProgress(redVal);
          greenBar.setProgress(greenVal);
          blueBar.setProgress(blueVal);
          currentElement = control.roof;
          theView.invalidate();
          return true;
      }
      else if(control.trunk.containsPoint(xPos, yPos)){
          currentText.setText("" + control.trunk.getName());
          currentColor = control.trunk.getColor();
          redVal = (currentColor >> 16) & 0xFF;
          greenVal = (currentColor >> 8) & 0xFF;
          blueVal = (currentColor >> 0) & 0xFF;
          redBar.setProgress(redVal);
          greenBar.setProgress(greenVal);
          blueBar.setProgress(blueVal);
          currentElement = control.trunk;
          theView.invalidate();
          return true;
      }
      else if(control.treeTop.containsPoint(xPos, yPos)){
          currentText.setText("" + control.treeTop.getName());
          currentColor = control.treeTop.getColor();
          redVal = (currentColor >> 16) & 0xFF;
          greenVal = (currentColor >> 8) & 0xFF;
          blueVal = (currentColor >> 0) & 0xFF;
          redBar.setProgress(redVal);
          greenBar.setProgress(greenVal);
          blueBar.setProgress(blueVal);
          currentElement = control.treeTop;
          theView.invalidate();
          return true;
      }
      else if(control.ground.containsPoint(xPos, yPos)){
          currentText.setText("" + control.ground.getName());
          currentColor = control.ground.getColor();
          redVal = (currentColor >> 16) & 0xFF;
          greenVal = (currentColor >> 8) & 0xFF;
          blueVal = (currentColor >> 0) & 0xFF;
          redBar.setProgress(redVal);
          greenBar.setProgress(greenVal);
          blueBar.setProgress(blueVal);
          currentElement = control.ground;
          theView.invalidate();
          return true;
      }
      else{
          return true;
      }


    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
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

        int redVal = redBar.getProgress();
        int greenVal = greenBar.getProgress();
        int blueVal = blueBar.getProgress();
        int color = Color.rgb(redVal, greenVal, blueVal);
        currentElement.setColor(color);

        theView.invalidate();
    }
}
