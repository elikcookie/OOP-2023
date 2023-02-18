package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class StarMap extends PApplet
{

	ArrayList<Star> stars = new ArrayList<Star>();

	public void settings()
	{
		size(1000, 1000);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		
		smooth();

		loadStars();
		printStars();
		
	}	

	void printStars(){
		for (Star s : stars){
			System.out.println(s);
		}
	}

	void displayStars(){
		for (Star s : stars){
			s.render(this);
		}
	}

	public void loadStars(){
		Table table = loadTable("HabHYG15ly.csv","header");
		for (TableRow row : table.rows()){
			Star s = new Star(row);
			stars.add(s);
		}
	}

	public void draw()
	{	
		strokeWeight(1);
		drawGrid();	
		displayStars();
	}

	public void drawGrid()
	{
		stroke(127, 255, 212);
		float border = width * 0.1f;
	
		for (int i = -5 ; i <= 5 ; i++){
			float x = map(i, -5, 5, border, width - border);
			line(x, border, x, height - border);
			line(border, x, width - border, x );
			
			textAlign(CENTER, CENTER);
			text(i, x, border *0.5f);
			text(i, border *0.5f, x);
		}

			
	}


}

