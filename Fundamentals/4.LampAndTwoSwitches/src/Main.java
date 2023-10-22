/**
 * Using Main class to execute the main flow of the program, which consists in "Lamp" class tests.
 */
public class Main {

	public static void main(String[] args) {
		
		Lamp l = new Lamp(); //Creating obj using empty constructor.
		
		l.toggleFirstSwitch(); //Toggling switch. Lamp should be now ON because empty constructor starts with everything OFF.
		System.out.println(l.getLampState()); //As per upper comment, checking lamp state
		
		l.toggleSecondSwitch(); //Changing lamp state again using second switch.
		System.out.println(l.getLampState()); //As per upper comment, checking lamp state
		

	}

}
