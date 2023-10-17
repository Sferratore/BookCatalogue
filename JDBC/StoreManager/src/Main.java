
public class Main {

	public static void main(String[] args) {
		
		AccessInterface accInt = new AccessInterface();
		
		accInt.doAccess();
		
		while(true) {
			accInt.interact();
		}

	}

}
