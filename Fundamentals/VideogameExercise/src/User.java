/**
 * Represents an user.
 */
public class User {

	
	//-------------------CONSTRUCTORS--------------------
	/**
	 * Void constructor to allow post-definition
	 */
	public User() {}
	
	/**
	 * Full build constructor to create a full user on instance.
	 * @param parUsername is user's username
	 * @param parPassword is user's password
	 * @param parIsAdmin defines if user is admin or not.
	 */
	public User(String parUsername, String parPassword, boolean parIsAdmin) {
			
		this.username = parUsername;
		this.password = parPassword;
		this.isAdmin = parIsAdmin;
			
	}
		
	//-------------------METHODS-------------------------
		
	//Username get and set
    public String getUsername() {
        return this.username;
    }

    
    public void setUsername(String username) {
        this.username = username;
    }

    //Password get and set
    public String getPassword() {
        return this.password;
    }

    
    public void setPassword(String password) {
        this.password = password;
    }

    //Admin get and set
    public boolean isAdmin() {
        return isAdmin;
    }

    
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
		
	//-------------------FIELDS--------------------------
	private String username;
	private String password;
	private boolean isAdmin;
}
