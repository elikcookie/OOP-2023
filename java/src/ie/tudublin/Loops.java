package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet {

    int mode = 0;
	float offset = 0;

    public void settings() {
        size(1000, 1000);
    }

    public void setup() {
        colorMode(HSB);
    }

    public void keyPressed() {

        mode = key - '0';
        println(mode);
    }

    public void draw() {
        // if (mouseX < 500) {
        //     background(0);
        //     fill(255);
        //     rect(500, 100, 300, 750);
        // }
        // else{
        //     background(0);
        //     fill(255);
        //     rect(200, 100, 300, 750);
        // }

        // if (mouseX > 500 && mouseY < 500) {
        //     background(0);
        //     fill(255);
        //     square(500, 200, 350);
        // }
        // if (mouseX > 500 && mouseY > 500){
        //     background(0);
        //     fill(255);
        //     square(500, 500, 350);
        // }
        // if (mouseX < 500 && mouseY > 500){
        //     square(200, 500, 350);
        // }
        // if(mouseX < 500 && mouseY < 500){
        //     background(0);
        //     fill(255);
        //     square(200, 200, 350);
        // }

        // background(0);
        // fill(255);
        // rect(300, 500, 400, 200);
        // if(mouseX<300 && mouseX >700 && mouseY > 500 && mouseY < 700){
        //     fill(0,255,0);
        //     rect(300, 500, 400, 200);
        // }
        background(255);
        fill(255);
        noStroke();
        int numCircles = 32;
        offset += (mouseY / 100.0f);
        float d = width / (float) numCircles;

        for(int i = 0 ; i < numCircles; i++)
        { 
            for(int j = 0; j < numCircles; j++){
                noStroke();
                float c = map((i + j + offset), 0, numCircles * 2, 0, 255) % 256;
                fill(c, 255, 255);
                float x = map(i, 0, numCircles - 1, d / 2.0f, width - (d / 2.0f)); 
                float y = map(j, 0, numCircles - 1, d / 2.0f, width - (d / 2.0f)); 
                circle(x, y, d);

            }
        }
    }
    
}
