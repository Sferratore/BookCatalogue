/**
 * Class that represents basic fields and methods of a videogame.
 */
public class Videogame {

	//-------------------CONSTRUCTORS--------------------
	
	/**
	 * 
	 * @param argName is the name of the videogame
	 * @param argGenre is the genre of the videogame
	 */
	public Videogame(String parName, String parGenre) {
		this.name = parName;
		this.genre = parGenre;
	}
	
	
	//-------------------METHODS-------------------------
	
	/**
	 * Method that simulates playing with a videogame. Prints to system out.
	 */
	public void play() {
		System.out.println("You are playing to " + this.name);
	}
	
	 /**
	  *  Getter for name
	  */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Setter for genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
	
	
	/**
	 * Method that defines String representation of a videogame object. Overrides toString of "Object" class.
	 */
	@Override
	public String toString() {
		return "Videogame name: " + this.name + "   Videogame genre: " + this.genre;
	}
	
	//-------------------FIELDS--------------------------
	
	private String name;
	private String genre;
	
}
