package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet {
	Minim minim;
	AudioPlayer ap;
	AudioInput ai;
	AudioBuffer ab;

	int mode = 0;

	float y = 0;
	float smoothedY = 0;
	float smoothedAmplitude = 0;
	float lerpedAvrg = 0;

	public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
			if (ap.isPlaying()) {
				ap.pause();
			} else {
				ap.rewind();
				ap.play();
			}
		}
	}

	public void settings() {
		size(1024, 1000, P3D);
		// fullScreen(P3D, SPAN);
	}

	public void setup() {
		minim = new Minim(this);
		// Uncomment this to use the microphone
		// ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
		// ab = ai.mix;

		// And comment the next two lines out
		ap = minim.loadFile("heroplanet.mp3", 1024);
		ap.play();
		ab = ap.mix;

		colorMode(HSB);

		y = height / 2;
		smoothedY = y;

	}

	float off = 0;

	public void draw() {
		// background(0);
		float halfH = height / 2;
		float average = 0;
		float sum = 0;
		off += 1;

		// Calculate sum and average of the samples
		// Also lerp each element of buffer;
		for (int i = 0; i < ab.size(); i++) {
			sum += abs(ab.get(i));
		}
		average = sum / (float) ab.size();

		smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);

		float cx = width / 2;
		float cy = height / 2;

		switch (mode) {
			case 0:
				background(0);
				for (int i = 0; i < ab.size(); i++) {
					// float c = map(ab.get(i), -1, 1, 0, 255);
					float c = map(i, 0, ab.size(), 0, 255);
					stroke(c, 255, 255);
					float f = ab.get(i) * halfH;
					line(i, halfH + f, halfH - f, i);
				}
				break;
			case 1:
				background(0);
				for (int i = 0; i < ab.size(); i++) {
					float c = map(i, 0, ab.size(), 0, 255);
					stroke(c, 255, 255);
					float f = ab.get(i) * halfH;
					line(i, halfH + f, i, halfH - f);
				}
				break;
			case 2:
				background(0);
				for (int i = 0; i < ab.size(); i++) {
					float c = map(i, 0, ab.size(), 0, 255);
					stroke(c, 255, 255);
					float f = ab.get(i) * halfH;
					line(i, halfH + f, halfH - f, i);
				}
				break;
			case 3:
				background(0);
				for (int i = 0; i < ab.size(); i++) {
					float sample = ab.get(i) * halfH;
					stroke(map(i, 0, ab.size(), 0, 255), 255, 255);

					sample = ab.get(i) * width * 2;
					stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
					line(0, i, sample, i);
					line(width, i, width - sample, i);
					line(i, 0, i, sample);
					line(i, height, i, height - sample);
				}
				break;
			case 4:
				background(0);

				average = sum / ab.size();

				// Smoothly interpolate between the previous average and the new average
				lerpedAvrg = lerp(lerpedAvrg, average, 0.1f);

				// Draw an ellipse with a size based on the lerped average
				noFill();

				strokeWeight(2);
				stroke(map(lerpedAvrg, 0, 1, 0, 255), 255, 255);
				float ellipseWidth = lerpedAvrg * width * 2;
				ellipse(width / 2, halfH, ellipseWidth, ellipseWidth);
				break;

			case 5:
				background(0);

				lerpedAvrg = lerp(lerpedAvrg, average, 0.1f);
				noFill();
				strokeWeight(2);
				stroke(map(lerpedAvrg, 0, 1, 0, 255), 255, 255);
				float squareWidth = lerpedAvrg * width * 2;
				rectMode(CENTER);
				rect(width / 2, halfH, squareWidth, squareWidth);
				break;
			case 6:
			background(0);
			fill(255);
			lerpedAvrg = lerp(lerpedAvrg, average, 0.1f);
			strokeWeight(2);
			stroke(map(lerpedAvrg, 0, 1, 0, 255), 255, 255);
			ellipseWidth = lerpedAvrg * width * 2;
			ellipse((float) (width / 5.2), halfH, ellipseWidth, ellipseWidth);
			ellipse((float) (width /1.2), halfH, ellipseWidth, ellipseWidth);

			fill(0);
			noStroke();
			ellipseWidth = lerpedAvrg * width;
			ellipse((float) (width / 5.2), halfH, ellipseWidth, ellipseWidth);
			ellipse((float) (width /1.2), halfH, ellipseWidth, ellipseWidth);

			fill(255);
			arc(width/2, height/2 + 200, 200, 150, radians(0), radians(180));  
			
			break;

		}
		// Other examples we made in the class
		/*
		 * stroke(255);
		 * fill(100, 255, 255);
		 * 
		 * circle(width / 2, halfH, lerpedA * 100);
		 * 
		 * circle(100, y, 50);
		 * y += random(-10, 10);
		 * smoothedY = lerp(smoothedY, y, 0.1f);
		 * circle(200, smoothedY, 50);
		 */

	}
}