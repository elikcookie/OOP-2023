package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio2 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    public void settings()
    {
        size(1024, 1000, P3D);
    }

    public void setup()
    {
        minim = new Minim(this);
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        
    }


    public void draw()
    {
        background(0);
        stroke(255);

        float half = height/2;

        for(int i = 0 ; i < ab.size() ; i ++)
        {
            line(i, half, i, half + ab.get(i) * half);
        }
    }        
}
