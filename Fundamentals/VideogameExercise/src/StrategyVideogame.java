/**
 * Class that represents basic fields and methods of a Strategic videogame.
 */
public class StrategyVideogame extends Videogame{

	//-------------------CONSTRUCTORS--------------------
	
	/**
	 * Constructor calls the constructor of Videogame, passing the parameter name and "Strategy" as genre.
	 * @param argName is the name of the videogame
	 */
	public StrategyVideogame(String parName) {
		
		super(parName, "Strategy"); //Calls superclass constructor
		
	}
	
	//-------------------METHODS-------------------------
	
	/**
	 * Method that simulates planning a strategy inside the videogame. Prints to system out.
	 */
	public void plan() {
		
		System.out.println("Planning a strategy...");
		
	}
	
	//-------------------FIELDS--------------------------
	
}