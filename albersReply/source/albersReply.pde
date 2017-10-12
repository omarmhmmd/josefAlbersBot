float x;
float y;

int xR;
int yR;

color c1;
color c2;
color c3;
color c4;

void setup() {
  PImage myImage = loadImage("media.jpeg");
  size(625, 625);
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

void draw () {
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

void getRandom() {
  x = random(width);
  y = random(height);
  xR = round(x); 
  yR = round(y);
}