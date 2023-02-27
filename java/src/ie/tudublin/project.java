package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class project extends PApplet {
  Minim minim;
  AudioPlayer ap;
  AudioInput ai;
  AudioBuffer ab;

  int headWidth;
  int headHeight;
  int eyeWidth;
  int eyeHeight;
  int pupilWidth;
  int pupilHeight;
  int mouthWidth;
  int mouthHeight;
  int toothHeight;
  int antennaLength;

  public void settings() {
    size(600, 600);
    headWidth = width / 2;
    headHeight = height / 2;
    eyeWidth = width / 12;
    eyeHeight = height / 6;
    pupilWidth = eyeWidth / 2;
    pupilHeight = eyeHeight / 2;
    mouthWidth = width / 4;
    mouthHeight = height / 8;
    toothHeight = mouthHeight / 2;
    antennaLength = height / 6;
  }

  public void setup() {
    background(255); // set the background color to white
    noFill(); // remove the fill from all shapes
    stroke(0); // set the stroke color to black
    strokeWeight(4); // set the stroke weight to 4 pixels
  }

  public void draw() {
    // Draw the alien's head
    fill(100, 100, 100); // set the head color to grey
    ellipse(headWidth, headHeight, headWidth, headHeight);

    // Draw the alien's eyes
    fill(0); // set the eye color to black
    ellipse(headWidth - width / 5, headHeight - height / 6, eyeWidth, eyeHeight);
    ellipse(headWidth + width / 5, headHeight - height / 6, eyeWidth, eyeHeight);

    // Draw the alien's pupils
    fill(255); // set the pupil color to white
    ellipse(headWidth - width / 5, headHeight - height / 6, pupilWidth, pupilHeight);
    ellipse(headWidth + width / 5, headHeight - height / 6, pupilWidth, pupilHeight);

    // Draw the alien's mouth with teeth
    noFill(); // remove the fill from the mouth
    arc(headWidth, headHeight + height / 6, mouthWidth, mouthHeight, 0, PI, CHORD);
    fill(255); // set the fill color to white for the teeth
    triangle(headWidth - width / 20, headHeight + height / 6 - toothHeight, headWidth - width / 60,
        headHeight + height / 6, headWidth + width / 60, headHeight + height / 6 - toothHeight);
    triangle(headWidth + width / 20, headHeight + height / 6 - toothHeight, headWidth + width / 60,
        headHeight + height / 6, headWidth - width / 60, headHeight + height / 6 - toothHeight);

    // Draw the alien's antennas
    line(headWidth - width / 10, headHeight - headWidth / 4, headWidth - width / 10,
        headHeight - antennaLength - headWidth / 4);
    line(headWidth + width / 10, headHeight - headWidth / 4, headWidth + width / 10,
        headHeight - antennaLength - headWidth / 4);
  }
}
