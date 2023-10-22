/**
 * Class that represents a Lamp connected to two switches. Every switch toggle changes the state of the lamp.
 */
public class Lamp {

	//---------CONSTRUCTORS-----------
	
	/**
	 * First constructor initializes Lamp class with all the fields on "False"
	 */
	public Lamp() {
		this.firstSwitch = false;
		this.secondSwitch = false;
		this.lampState = false;
	}
	
	
	//---------METHODS---------------
	
	//Getter methods
	public boolean getFirstSwitchState() {
		return this.firstSwitch;
	}
	
	public boolean getSecondSwitchState() {
		return this.secondSwitch;
	}
	
	public boolean getLampState() {
		return this.lampState;
	}
	
	/**
	 * Toggles first switch.
	 */
	public void toggleFirstSwitch() {
		this.firstSwitch = !this.firstSwitch; //Inversion of bool value using negation
		this.lampState = !this.lampState;
	}
	
	/**
	 * Toggles second switch.
	 */
	public void toggleSecondSwitch() {
		this.firstSwitch = !this.firstSwitch; //Inversion of bool value using negation
		this.lampState = !this.lampState;
	}
	
	
	
	//----------FIELDS---------------
	private boolean firstSwitch;  //Field that represents the first switch connected to the Lamp. True = UP, False = DOWN
	private boolean secondSwitch; //Field that represents the second switch connected to the Lamp. True = UP, False = DOWN
	private boolean lampState; //Field that represents the lamp state. True = ON, False = OFF. True = ON, False = OFF
}
