
public class Main {

	public static void main(String[] args) {

		GameSessionHandler gsa = new GameSessionHandler();
		
		gsa.authenticationStart();
		
		while(gsa.checkUserLogged()) {
			gsa.Interact();
		}
		
		
	}

}
