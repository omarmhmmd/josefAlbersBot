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

public class albersReply extends PApplet {

float x;
float y;

int xR;
int yR;

int c1;
int c2;
int c3;
int c4;

public void setup() {
  PImage myImage = loadImage("media.jpeg");
  
  image(myImage, 0, 0, width, height);
  getRandom();
  c1 = get(xR, yR);
  fill(c1);
  noStroke();
  rect(275, 190, 50, 50);
  getRandom();
  c2 = get(xR, yR);
  fill(c2);
  noStroke();
  rect(305, 200, 50, 50);
  getRandom();
  c3 = get(xR, yR);
  fill(c3);
  noStroke();
  rect(325, 210, 50, 50);
  getRandom();
  c4 = get(xR, yR);
  fill(c4);
  noStroke();
  rect(345, 220, 50, 50);
}

public void draw () {
  background(255);
  noStroke();
  // RECT 004
  fill(c1);
  rect(0, 0, 625, 625); 
  
  // RECT 003
  fill(c2);  
  rect(67, 95, 495, 495); 
  
  // RECT 002
  fill(c3);  
  rect(130, 188, 375, 375); 
  
  // RECT 001
  fill(c4);   
  rect(189, 278, 250, 250); 
  save("./albers.png");
  exit();
}

public void getRandom() {
  x = random(width);
  y = random(height);
  xR = round(x); 
  yR = round(y);
}
  public void settings() {  size(625, 625); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "albersReply" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
