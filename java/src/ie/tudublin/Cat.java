package ie.tudublin;


public class Cat extends Animal
{
    private int numLives;

    public Cat(String name)
    {
        super(name);
        this.numLives = 9;
    }

    public int getNumLives() {
        return this.numLives;
    }

    public void setNumLives(int numLives) {
        this.numLives = numLives;
    }

    void kill()
    {
        this.numLives --;
        if (this.numLives > 0)
        {
            System.out.println("Ouch!");
        }
        else
        {
            System.out.println("I am dead!");
        }
    }
}