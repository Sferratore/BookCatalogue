//Need to do the following import to use connector
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		
		try{  
			/*Taking the driver.
			The Class.forName() method is used to dynamically load a class given its fully qualified name. 
			In the context of JDBC, it loads the driver class into the JVM.*/
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			//Here "world" is database name, "root" is username and "password" is password 
			Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/world","root","password");  
			 
			//Creation of a statement object which can execute queries.
			Statement stmt=con.createStatement();  
			
			//Executing the query using the statement and memorizing the result (which is always ResultSet class) into rs
			ResultSet rs=stmt.executeQuery("select * from city");  
			
			//Iterating into the ResultSet to use them all. rs.next() gives a null (false) value where there's nothing more to elaborate
			while(rs.next())  
				System.out.println(rs.getString(2));  
			
			//Closing the connection
			con.close();  
		}
		//Exception handling
		catch(Exception e){ System.out.println(e);  
			
		}  


	}

}
