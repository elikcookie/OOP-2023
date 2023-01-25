package ie.tudublin;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Hello world");
		
		Dog penny = new Dog();
		penny.setName("Penny");
		penny.speak();

		Cat pancake = new Cat("Pancake");
		pancake.getNumLives();
		pancake.kill();
	}
	
}