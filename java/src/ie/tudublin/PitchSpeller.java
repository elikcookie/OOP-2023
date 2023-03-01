package ie.tudublin;

import ddf.minim.AudioBuffer;
// import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;
public class PitchSpeller {
    float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f
        , 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f};
    String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"};

}

public void spell(float frequency) {
    //find the closest frequency
    int index = 0;
    float min = Float.MAX_VALUE;
    for (int i = 0; i < frequencies.length; i++) {
        float diff = abs(frequencies[i] - frequency);
        if (diff < min) {
            min = diff;
            index = i;
        }
    }
    //print the spelling
    PitchSpeller ps = new PitchSpeller();
    System.out.println(ps.spell(330));
    System.out.println(ps.spell(420));
    System.out.println(ps.spell(1980));
}