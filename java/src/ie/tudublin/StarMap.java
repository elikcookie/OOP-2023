package ie.tudublin;

import processing.core.PApplet;
// Elitsa Koleva Lab test 2016 practice

public class StarMap extends PApplet
{
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		
		smooth();
		


	}	

	public void draw()
	{	
		strokeWeight(2);
		drawGrid();	
	}

	public void drawGrid()
	{
		float border = 50.0f;

		for (int i = -4 ; i <= 5 ; i++){
			stroke(255);
			line(border, height/2 + i * 50, width - border, height/2 + i * 50);
			line(width/2 + i * 50, border, width/2 + i * 50, height - border);
		}

			
	}


}

