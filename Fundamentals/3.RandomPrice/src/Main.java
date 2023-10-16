import java.util.Random; //Importing library to use its classes

//Program that randomizes a casual price between 10$ and 19.99$
public class Main {

	public static void main(String[] args) {
		
		Random randomizer = new Random(); //Creation of an object of class "Random"
		double price = 10; //Let the price start from the low end
		double randomizednumber; //number between 0 and 9.99 which will be randomized
		
		randomizednumber = randomizer.nextDouble(); //Gives a number between 0.0 and 1.0
		randomizednumber = randomizednumber * 10; //Now the number is between 0.0 and 10.0 (it is never 10.0, not included)
		randomizednumber = Math.round(randomizednumber * 100.0) / 100.0; //Rounding the number
		
		price = price + randomizednumber; //adding to the price the randomized part
		
		System.out.println(price); //printing the price (auto casting from double to String)

	}

}
