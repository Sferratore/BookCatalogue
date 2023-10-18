import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Class that represents a User database interface.
 */
public class UserMemory {

	//-------------------CONSTRUCTORS--------------------
	
	/**
	 * Void constructor to start the UserMemory instance with the syncronization.
	 */
	public UserMemory() {
		this.sync();
	}
	
	//-------------------METHODS-------------------------
	
	/**
	 * Registers a user inside the database and then resyncs.
	 * @param u user to be registered
	 * @return true if the operation is successful, false otherwhise.
	 */
	public boolean registerUser(User u) {
		
		 try (FileWriter file = new FileWriter("users.txt")) {
			 
			 //Checking for username duplication
			 for(int i = 0; i < this.users.size(); i++) {
				 if(this.users.get(i).getUsername().equals(u.getUsername())) {
					 throw new Exception("Username already exists");
				 }
			 }
			 
			 //Adding the user
			 file.append("Username: " + u.getUsername() + "\n");
	         file.append("Password: " + u.getPassword() + "\n");
	         file.append("isAdmin: false\n");
	         file.append("---\n"); 
	            
	     } catch (IOException e) {
	         e.printStackTrace();
	         return false;
	     }
		 catch(Exception e) {
			 e.printStackTrace();
	         return false;
		 }
		 
		 this.sync();
		 
		 return true;
	}
	
	/**
	 * Searches for the user inside the database to see if credentials are valid.
	 * @param u user to be checked.
	 * @return result of the logIn.
	 */
	public boolean logUserIn(User u){
		
		this.sync();
		for(int i = 0; i < this.users.size(); i++) {
			if(this.users.get(i).getUsername().equals(u.getUsername()) && this.users.get(i).getPassword().equals(u.getPassword()) && this.users.get(i).isAdmin() == u.isAdmin()) {
				return true;
			}
		}
		return false;
		
	}
	
	/**
	 * Adds all the rows of the database inside the "users" field of UserMemory.
	 */
	
	private void sync() {
		
		List<String> lines;
		
		try {
			this.users = new ArrayList<User>();
			lines = Files.readAllLines(Paths.get("users.txt"));
			User user = null;
	        
	        for (String line : lines) {
	            if (line.startsWith("Username: ")) {
	                user = new User();
	                user.setUsername(line.split(": ")[1]);
	            } else if (line.startsWith("Password: ")) {
	                user.setPassword(line.split(": ")[1]);
	            } else if (line.startsWith("isAdmin: ")) {
	                user.setAdmin(Boolean.parseBoolean(line.split(": ")[1]));
	            } else if (line.startsWith("---")) {
	                users.add(user);
	            }
	        }
	            
	        // Add the last user if not added yet
	        if (user != null && !users.contains(user)) {
	            users.add(user);
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        
        
	}
	
	
	//-------------------FIELDS--------------------------
	private ArrayList<User> users;
}
