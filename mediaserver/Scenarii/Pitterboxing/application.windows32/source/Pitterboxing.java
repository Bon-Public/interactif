import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import http.requests.*; 

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

float pb, lb;

float target_lb, target_pb;

int passes = 0;
float T = 1;
float seconds = 0;

float anim_duration = 2.0f;
float anim_t0 = 0;

public void setup() {
  
}

public void draw() {
  background(255);
  
  seconds = millis() / 1000.0f;
  if (seconds > T*passes) {
    passes += 1;
    update_pitter();
    
    target_lb = boxing(letterboxing);
    target_pb = boxing(pillarboxing);
    
    anim_t0 = seconds;
  }
    
  lb = lerp(lb, target_lb, pow((seconds-anim_t0)/anim_duration, 0.7f));
  pb = lerp(pb, target_pb, pow((seconds-anim_t0)/anim_duration, 0.7f));

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

public void update_pitter() {
  GetRequest get = new GetRequest("http://64.227.113.170:5000/api/effects/mask/pitterboxing");
  get.send();
  println("Request...");
  println(get.getContent());
  JSONObject test = parseJSONObject(get.getContent());
  println(test.get("var1"));
  println(test.get("var2"));

  letterboxing = test.getInt("var1") * boxingIncrement;
  pillarboxing = test.getInt("var2") * boxingIncrement;
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
