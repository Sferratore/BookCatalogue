/**
 * Class that represents basic fields and methods of an Action videogame.
 */
public class ActionVideogame extends Videogame{

	//-------------------CONSTRUCTORS--------------------
	
	/**
	 * Constructor calls the constructor of Videogame, passing the parameter name and "Action" as genre.
	 * @param argName is the name of the videogame
	 */
	public ActionVideogame(String parName) {
		
		super(parName, "Action"); //Calls superclass constructor
		
	}
	
	//-------------------METHODS-------------------------
	
	/**
	 * Method that simulates fighting inside the videogame. Prints to system out.
	 */
	public void fight() {
		
		System.out.println("Fighting in progress...");
		
	}
	
	//-------------------FIELDS--------------------------
	
}
