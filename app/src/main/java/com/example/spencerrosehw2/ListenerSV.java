package com.example.spencerrosehw2;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author Spencer Rose
 *@version Spring 2019
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

    //The constructor for my ListenerSV: it takes in all my views and a
    // ControlSV
    public ListenerSV(ControlSV controller, SeekBar redBar, SeekBar greenBar,
                      SeekBar blueBar, TextView redText, TextView greenText,
                      TextView blueText, TextView currentImage,
                      SurfaceView view){
        //I set the onChangeListener for all the seekbars to this listener class
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
        //I set the OnTouchListener for the Surface View to this class
        theView.setOnTouchListener(this);
    }

    //The onTouch method used to find out what Element i am touching
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //Set X and Y values based on the MotionEvent to be checked by each
        //elements "contains" method
      int xPos = (int) event.getX();
      int yPos = (int) event.getY();
      int redVal =0;
      int greenVal =0;
      int blueVal =0;
      int currentColor =0;

      //All of these if statements check which element is being touched based
        // on the location of the touch and then change the top textview to
        // display the name of the Element, then get the RGB values from that
        //element and change the seekbars to match
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
          //determine RGB values
          redVal = (currentColor >> 16) & 0xFF;
          greenVal = (currentColor >> 8) & 0xFF;
          blueVal = (currentColor >> 0) & 0xFF;
          //make seekbars match those values
          redBar.setProgress(redVal);
          greenBar.setProgress(greenVal);
          blueBar.setProgress(blueVal);
          currentElement = control.door;
          //call invalidate to redraw the surfaceView
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
        //As the user changes the seekbars I change the text views above the
        //bars to show the user what the integer value is from 0 to 255
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

        //when the user lets go of a seekbar i create a color based off of the
        //values of the seekbars, set that color to the current element's color
        //and then call invalidate to redraw the surface view
        //NOTE: I know this does not work because it will not actually redraw
        //the surface with the new color, but I know that it does save the
        //"new color" of the element because its RGB seekbars will change to
        //reflect the new color, even if you click on another element and go
        //back to the previous element whose color you changed
        int redVal = redBar.getProgress();
        int greenVal = greenBar.getProgress();
        int blueVal = blueBar.getProgress();
        int color = Color.rgb(redVal, greenVal, blueVal);
        currentElement.setColor(color);

        theView.invalidate();
    }
}
