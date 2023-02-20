package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{

    Minim minim;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

	public void settings()
	{
		size(500, 500);
	}

	int frameSize = 1024;

	public void setup() {
		colorMode(HSB);
		background(0);

		minim = new Minim(this);

		ai = minim.getLineIn(Minim.MONO, frameSize, 44100,16); // type,buffersize, samplerate, bitdepth/4410 = input frequency, 16 bit sample
		ab = ai.mix; //mix of left and right channels
		

		smooth();
		
	}

	
	
	public void draw()
	{	
		//plot the samples in the buffer
		background(0);
		stroke(255);
		float halfScreen = height /2 ;

		float cgap = 255/ (float)ab.size();

		for(int i = 0 ; i < ab.size() ; i ++)
		{
			stroke(cgap*i,255,255);
			line(i, halfScreen, i, halfScreen + ab.get(i)*1000);
		}
	}
}
