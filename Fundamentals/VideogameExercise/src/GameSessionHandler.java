import java.util.ArrayList;
import java.util.Scanner;

/**
 * GameSessionHandler is a class that handles interaction with user authentication and videogames usage.
 */
public class GameSessionHandler {

	//-------------CONSTRUCTORS---------------------
	
	/**
	 * Default constructor of the class
	 */
	public GameSessionHandler() {
		this.userHandler = new UserMemory();
		this.inputScanner = new Scanner(System.in);
		this.isAnyUserLogged = false;
		
		this.initializeBasicGames(); //Initializer of basic games in absence of db on file
	}
	
	//-------------METHODS--------------------------
	
	/**
	 * Starts authentication process
	 */
	public void authenticationStart() {
		int choice;
		
		System.out.println("Welcome.\n1)Login\n2)Register\n3)Admin Login0)Exit program");
		choice = this.inputScanner.nextInt();
		
		if(choice == 1) {
			this.logIn();
		}
		else if(choice == 2) {
			this.register();
		}
		else if(choice == 3) {
			this.adminLogIn();
		}
		else {
			System.exit(0);
		}
	}
	
	
	/**
	 * Handles all the interaction with the program. Differentiates between admin interaction and user interaction.
	 */
	public void Interact() {
		
		int choice;
		String gametitle;
		
		try {
			
			if(!isAnyUserLogged) {
				throw new Exception("No user is logged.");
			}
			
			
			if(!userLogged.isAdmin()) {
				System.out.println("1)View videogames\n2)Play a videogame\n3)Log out\n 0)Exit program\n");
				choice = inputScanner.nextInt();
				
				if(choice == 1) {
					for(int i = 0; i < this.videogames.size(); i++) {
						System.out.println(this.videogames.get(i));
					}	
				}
				else if(choice == 2) {
					System.out.println("Game that you want to play: ");
					gametitle = inputScanner.next();
					
					for(int i = 0; i < this.videogames.size(); i++) {
						if(this.videogames.get(i).getName().equals(gametitle)) {
							this.videogames.get(i).play();
							return;
						}
					}	
					System.out.println("The game was not found!");
				}
				else if(choice == 3) {
					this.userLogged = null;
					this.isAnyUserLogged = false;
				}
				else {
					System.exit(0);
				}
			}
			else {
				System.out.println("1)View videogames\n2)Play a videogame\n3)Log out\n4)Add game\n5)Remove game\n0)Exit program\n");
				choice = inputScanner.nextInt();
				
				if(choice == 1) {
					for(int i = 0; i < this.videogames.size(); i++) {
						System.out.println(this.videogames.get(i));
					}	
				}
				else if(choice == 2) {
					System.out.println("Game that you want to play: ");
					gametitle = inputScanner.next();
					
					for(int i = 0; i < this.videogames.size(); i++) {
						if(this.videogames.get(i).getName().equals(gametitle)) {
							this.videogames.get(i).play();
							return;
						}
					}	
					System.out.println("The game was not found!");
				}
				else if(choice == 3) {
					this.userLogged = null;
					this.isAnyUserLogged = false;
				}
				else if(choice == 4) {
					System.out.println("Write the name and the genre of the game you want to add.");
					this.videogames.add(new Videogame(inputScanner.next(), inputScanner.next()));
				}
				else if(choice == 5) {
					System.out.println("Write the name of the game you want to remove.");
					gametitle = inputScanner.next();
					for(int i = 0; i < this.videogames.size(); i++) {
						if(this.videogames.get(i).getName().equals(gametitle)) {
							this.videogames.remove(i);
						}
					}	
				}
				else {
					System.exit(0);
				}
			}
			
		}
		catch(Exception e) {
			System.out.println("Something wrong happened: " + e.toString());
		}
	}
	
	/**
	 * Gives feedback about log in situation.
	 * @return true if anyone is logged, false otherwise.
	 */
	public boolean checkUserLogged() {
		return this.isAnyUserLogged;
	}
	
	
	//-------------PRIVATE UTILITY METHODS----------
	
	/**
	 * Initializes basic games
	 */
	private void initializeBasicGames() {
		this.videogames = new ArrayList<Videogame>();
		this.videogames.add(new Videogame("Donkey_Kong", "Platform"));
		this.videogames.add(new Videogame("Super_Mario_World", "Platform"));
		this.videogames.add(new Videogame("Sonic_2", "Platform"));
		this.videogames.add(new ActionVideogame("Super_Smash_Bros_Brawl"));
		this.videogames.add(new StrategyVideogame("Fire_Emblem"));
		
	}
	
	/**
	 * Allows registration. Is accessed by the user using authenticationStart()
	 * @return true if operation has completed successfully, false otherwise.
	 */
	private boolean register() {
		
		try {
			this.userLogged = new User();
			
			System.out.println("Your username: ");
			this.userLogged.setUsername(inputScanner.next());
			
			System.out.println("Your password: ");
			this.userLogged.setPassword(inputScanner.next());
			
			this.userLogged.setAdmin(false);
			
			this.userHandler.registerUser(userLogged);
			this.isAnyUserLogged = true;
			
			return true;
		}
		catch(Exception e) {
			System.out.println("SOMETHING WENT WRONG WITH THE OPERATION." + e.toString());
			System.exit(0);
			return false;
		}
				
	}
	
	/**
	 * Allows admin login. Is accessed by the user using authenticationStart()
	 * @return true if operation has completed successfully, false otherwise.
	 */
	private boolean adminLogIn() {
		
		try {
			this.userLogged = new User();
			
			System.out.println("Your username: ");
			this.userLogged.setUsername(inputScanner.next());
			
			System.out.println("Your password: ");
			this.userLogged.setPassword(inputScanner.next());
			
			this.userLogged.setAdmin(true);
			
			if(this.userHandler.logUserIn(userLogged)) {
				this.isAnyUserLogged = true;
				System.out.println("Logged in successfully.");
				return true;
			}
			else {
				this.userLogged = null;
				System.out.println("Login failed.");
			}
		}
		catch(Exception e) {
			System.out.println("SOMETHING WENT WRONG WITH THE OPERATION." + e.toString());
			
		}
		return false;
	}
	
	
	/** Allows user login. Is accessed by the user using authenticationStart()
	 * @return true if operation has completed successfully, false otherwise.
	 */
	private boolean logIn() {
		
		try {
			this.userLogged = new User();
			
			System.out.println("Your username: ");
			this.userLogged.setUsername(inputScanner.next());
			
			System.out.println("Your password: ");
			this.userLogged.setPassword(inputScanner.next());
			
			this.userLogged.setAdmin(false);
			
			if(this.userHandler.logUserIn(userLogged)) {
				this.isAnyUserLogged = true;
				System.out.println("Logged in successfully.");
				return true;
			}
			else {
				this.userLogged = null;
				System.out.println("Login failed.");
			}
		}
		catch(Exception e) {
			System.out.println("SOMETHING WENT WRONG WITH THE OPERATION." + e.toString());
			
		}
		return false;
	}
	
	
	
	//-------------FIELDS---------------------------
	
	private UserMemory userHandler;
	private User userLogged;
	private boolean isAnyUserLogged;
	private Scanner inputScanner;
	private ArrayList<Videogame> videogames;
	
}
