/**
 * Represents Client table from the database.
 */
public class Client {
	
	//------------------CONSTRUCTORS--------------
	
	
	//Default constructor
	public Client() {}
	
	//Full build constructor
	public Client(String argemail, String argusername, String argname, String argsurname, String argaddress) {
		this.email = argemail;
		this.username = argusername;
		this.name = argname;
		this.surname = argsurname;
		this.address = argaddress;
	}
	
	
	
	//---------------METHODS-----------------------

	//Getters
	public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    //Setters
    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //ToString override to print the object if needed
    @Override
    public String toString() {
        return "Client{" +
               "email='" + email + '\'' +
               ", username='" + username + '\'' +
               ", name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", address='" + address + '\'' +
               '}';
    }
    
    
    
    
	//----------------FIELDS----------------------
	private String email;
	private String username;
	private String name;
	private String surname;
	private String address;
}
