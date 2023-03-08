package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{

	LifeBoard board;

	public void settings()
	{
		size(1000, 1000);
	}

	boolean paused = false;
	public void keyPressed()
	{
		if (key == '1')
		{
			board.randomise();
		}
		if (key == '2')
		{
			board.clear();
		}
		if (key == '3')
		{
			board.crossSpawn();
		}
		if (key == ' ')
		{
			paused = !paused;
		}
		
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		board = new LifeBoard(200, this);
		board.randomise();
	}

	public void draw()
	{	
		background(0);
		board.render();
		if (!paused){
			board.applyRules();
		}
	}

}
