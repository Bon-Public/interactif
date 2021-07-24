
float boxingIncrement = 0.01; // adjusts according to number of participants. TODO: make it f(N)

float letterboxing = 0;  // 0 to 1. 0: no letterbox. 1: screen entirely letterboxed
float pillarboxing = 0;    // 0 to 1. Similar

void setup() {
    fullScreen();
}

void draw() {
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

void keyTyped() {
    if (key == 'a')
        letterboxing += boxingIncrement;
    else if (key == 'z')
        pillarboxing += boxingIncrement;
    else if (key == 'e') {
        letterboxing = 0;
        pillarboxing = 0 ;
    }    
}

float boxing(float b) {
  return 2*b/(b+1);
}
