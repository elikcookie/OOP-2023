package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

    public void settings()
    {
        size(500, 500);
    }

    public void setup() {
        background(255,0,0);
    }

    public void draw()
    {
        fill(255,255,0);
        circle(250, 250, 400); // (cx, cy, d)
        fill(0,255,255);
        triangle(250, 10, 50, 400, 450, 400);
        //rect(10, 10, 10, 100); // tlx, tly, w, h
        fill(255);
        ellipse(mouseX, mouseY, 200, 100);
        fill(0);
        circle(mouseX, mouseY, 100); // (cx, cy, d)

        if (mousePressed) {
            fill(0);
            ellipse(250, 230, 200, 100);
            fill(255,150,0);
            line(200, 260, 55, 55);
        }
    }
}