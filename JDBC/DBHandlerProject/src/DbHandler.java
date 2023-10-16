import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class DbHandler {
	
	//Constructors
	public DbHandler() {
		
	}
	
	public DbHandler(String username, String password, String dbname) {   //Constructor that initializes connection
		connectToDb(username, password, dbname);
	}
	
	
	//Methods
	public String connectToDb(String username, String password, String dbname){
		try {
			
			Class.forName(JConnectionClass);
		}
		catch(ClassNotFoundException e) {
			return "The class " + JConnectionClass + " has not been found by the program.";
		}
		
		String connectionString = String.format("jdbc:mysql://localhost:3306/%s", dbname);
		try {
			this.connection = DriverManager.getConnection(connectionString, username, password);
		} catch (SQLException e) {
			return "SQLException happened: " + e.toString();
		}
		
		if(this.connection != null) {
			return "Connection estabilished with database: \"" + dbname + "\"";
		}
		else {
			return "Connection not estabilished.";
		}
		
	}
	
	public ResultSet queryDb(String query) {
		PreparedStatement prpSt;
		try {
			prpSt = this.connection.prepareStatement(query);
			return prpSt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}			
	}
	
	
	public void printResultSet(ResultSet rs) {
		
		String recordString = "";
		
		try {
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
	        int columnCount = rsmd.getColumnCount();
	        
			while(rs.next()) {
				for(int i = 1; i <= columnCount; i++) {
					recordString += rs.getString(i) + "  "; 
				}
				System.out.println(recordString);
				recordString = "";
			}
			
		 } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void queryDbAndPrintRs(String query) {
		printResultSet(queryDb(query));
	}
	
	//Fields
	 Connection connection;
	 
	 //Finals
	 static String JConnectionClass = "com.mysql.cj.jdbc.Driver";
}
