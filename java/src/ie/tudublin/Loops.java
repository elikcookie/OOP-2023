package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    int mode = 0;

    public void settings() {
        size(1000, 1000);
    }

    public void setup() {
        background(255, 0, 0);
    }

    public void keyPressed() {

        mode = key - '0';
        println(mode);
    }

    public void draw() {
        if (mouseX < 500) {
            background(0);
            fill(255);
            rect(500, 100, 300, 750);
        }
        else{
            background(0);
            fill(255);
            rect(200, 100, 300, 750);
        }

    }
}
