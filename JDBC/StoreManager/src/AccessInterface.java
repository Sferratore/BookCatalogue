import java.util.Scanner;

public class AccessInterface {

	//--------------CONSTRUCTORS-----------
	
	//Only constructor
	public AccessInterface() {
		
		this.isAdmin = false;  //user access as default
		this.utilityScanner = new Scanner(System.in); //scanner for interactions with user
		this.strManager = new StoreManager(); //StoreManager to interact with DB
		
		this.strManager.connectToDb();  //Starts connection with db
	}
	
	
	//------------METHODS---------------
	
	//Access method. Asks if user is admin or not. If he is, asks for password. In all other cases, logs as user.
	public boolean doAccess() {
		
		String choice;
		
		try {
			
			System.out.println("Are you admin? (Y/N):");
			choice = utilityScanner.next();
			
			if(!choice.equals("Y") && !choice.equals("N")) {
				System.out.println("WRONG INPUT");
				throw new Exception();
			}
			else if(choice.equals("Y")) {
				System.out.print("Insert password: ");
				if(utilityScanner.next().equals(password)) {
					this.isAdmin = true;
					System.out.println("Login successful.");
					return true;
				}
				else {
					System.out.println("Login unsuccessful. You will be logged as a normal user.");
				}
			}
			return false;
		}
		catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}	
	}
	
	//Fundamental interaction method. Differenciates between admin interaction ad user interaction.
	public void interact() {
		if(isAdmin)
			interactAdmin();
		else
			interactUser();
	}
	
	//User interaction flow
	private void interactUser() {
		
		int choice;
		
		System.out.println("1)See products available\n0)Exit");
		choice = utilityScanner.nextInt();
		
		if(choice == 1) {
			System.out.println(this.strManager.getAllProducts());
		}
		else {
			System.exit(0);
		}
		
	}
	
	//Admin interaction flow
	private void interactAdmin() {
		
		int choice;
		
		System.out.println("1)See products available\n2)See clients memorized\n3)See orders\n4)Create new product\n5)Create new client\n6)Create new order\n7)Delete product\n8)Delete client\n9)Delete order\n0)Exit");
		choice = utilityScanner.nextInt();
		
		if(choice == 1) {
			System.out.println(this.strManager.getAllProducts());
		}
		else if(choice == 2) {
			System.out.println(this.strManager.getAllClients());
		}
		else if(choice == 3) {
			System.out.println(this.strManager.getAllOrders());
		}
		else if(choice == 4) {
			createProduct();
		}
		else if(choice == 5) {
			createClient();
		}
		else if(choice == 6) {
			createOrder();
		}
		else if(choice == 7) {
			deleteProduct();
		}
		else if(choice == 8) {
			deleteClient();
		}
		else if(choice == 9) {
			deleteOrder();
		}
		else {
			System.exit(0);
		}
		
	}
	
	
	
	//----------------------PRIVATE METHODS TO INTERFACE BETWEEN USER INPUT AND STOREMANAGER METHODS-------------------
	
	private void createProduct() {
		Product p = new Product();
		
		System.out.print("Product id:");
		p.setId(utilityScanner.nextInt());
		
		System.out.print("Brand:");
		p.setBrand(utilityScanner.next());
		
		System.out.print("Model:");
		p.setModel(utilityScanner.next());
		
		System.out.print("Description:");
		p.setDescription(utilityScanner.next());
		
		System.out.print("Price:");
		p.setPrice(utilityScanner.nextDouble());
		
		strManager.insertProduct(p);
	}
	
	
	private void createOrder() {
	    Order o = new Order();
	    
	    System.out.print("Order ID:");
	    o.setOrderId(utilityScanner.nextInt());
	    
	    System.out.print("Client Email:");
	    o.setClientEmail(utilityScanner.next());
	    
	    System.out.print("Order Date (format YYYY-MM-DD):");
	    o.setOrderDate(utilityScanner.next());
	    
	    System.out.print("Total Cost:");
	    o.setTotalCost(utilityScanner.nextDouble());
	    
	    strManager.insertOrder(o);
	}

	
	private void createClient() {
	    Client c = new Client();
	    
	    System.out.print("Email:");
	    c.setEmail(utilityScanner.next());
	    
	    System.out.print("Username:");
	    c.setUsername(utilityScanner.next());
	    
	    System.out.print("Name:");
	    c.setName(utilityScanner.next());
	    
	    System.out.print("Surname:");
	    c.setSurname(utilityScanner.next());
	    
	    System.out.print("Address:");
	    c.setAddress(utilityScanner.next());  
	    
	    strManager.insertClient(c);
	}

	
	private void deleteProduct() {
		System.out.print("id for DELETION:");
		strManager.deleteProduct(utilityScanner.nextInt());
	}
	
	
	private void deleteClient() {
		System.out.print("email for DELETION:");
		strManager.deleteClient(utilityScanner.next());
	}
	
	
	private void deleteOrder() {
		System.out.print("id for DELETION:");
		strManager.deleteOrder(utilityScanner.nextInt());
	}
	
	
	//----------------FIELDS--------------
	
	private boolean isAdmin;
	private Scanner utilityScanner;
	private StoreManager strManager;
	
	
	//------------STATIC FIELDS--------------
	private static String password = "password";
}
