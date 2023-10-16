
public class Client {
	
	//------------------CONSTRUCTORS--------------
	public Client(String argemail, String argusername, String argname, String argsurname, String argaddress) {
		this.email = argemail;
		this.username = argusername;
		this.name = argname;
		this.surname = argsurname;
		this.address = argaddress;
	}
	//---------------METHOD-----------------------

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
    
	//----------------FIELDS----------------------
	private String email;
	private String username;
	private String name;
	private String surname;
	private String address;
}
