import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Pitterboxing extends PApplet {


float boxingIncrement = 0.01f; // adjusts according to number of participants. TODO: make it f(N)

float letterboxing = 0;  // 0 to 1. 0: no letterbox. 1: screen entirely letterboxed
float pillarboxing = 0;    // 0 to 1. Similar

public void setup() {
    
}

public void draw() {
    background(255);
        
    float lb = boxing(letterboxing);
    float pb = boxing(pillarboxing);
        
    noStroke();
    fill(0);
    rect(0, 0, width, lb * height/2);      // top
    rect(0, height, width, -lb * height/2);  // bottom
    rect(0, 0, pb * width/2, height);     // left
    rect(width, 0, -pb * width/2, height);  // right
    
    textSize(32);
    fill(0);
    text("Press a to letterbox", 0, 50);
    text("Press z to pillarbox", 0, 100);
    text("Press e to reset", 0, 150);
}

public void keyTyped() {
    if (key == 'a')
        letterboxing += boxingIncrement;
    else if (key == 'z')
        pillarboxing += boxingIncrement;
    else if (key == 'e') {
        letterboxing = 0;
        pillarboxing = 0 ;
    }    
}

public float boxing(float b) {
  return 2*b/(b+1);
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--hide-stop", "Pitterboxing" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
