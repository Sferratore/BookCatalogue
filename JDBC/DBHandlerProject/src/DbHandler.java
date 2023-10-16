import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

/**
 * Represents a database handler object.
 * Its goal is to be an interface to the database.
 */
public class DbHandler {
	
	//----------CONSTRUCTORS------------
	/**
	 * Empty, default constructor
	 */
	public DbHandler() {}
	
	/**
	 * Constructor with connection variables defined. Creates the connection on instance.
	 * @param username The username used to log into the database system.
	 * @param password The password used to log into the database system.
	 * @param username The username used to log into the database system.
	 */
	public DbHandler(String username, String password, String dbname) {   //Constructor that initializes connection
		connectToDb(username, password, dbname);
	}
	
	
	//---------------METHODS----------------
	/**
	 * Creates connection to use for the database object.
	 * @param username The username used to log into the database system.
	 * @param password The password used to log into the database system.
	 * @param username The username used to log into the database system.
	 * 
	 * @throws ClassNotFoundException in case the static field JConnectionClass contains a wrong connector class.
	 * @throws SQLException in case an error with operation on DB happens.
	 * 
	 * @return Returns a string that describes the result of the operation.
	 */
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
	
	/**
	 * Queries the db with a query defined by the user.
	 * @param query contains the query which is user-defined.
	 * @throws SQLException in case an error with operation on DB happens.
	 * 
	 * @return Returns a ResultSet object with the result.
	 */
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
	
	/**
	 * Prints all the records into a ResultSet object.
	 * @param rs the ResultSet object with the values to print.
	 * @throws SQLException in case an error with operation on DB happens.
	 */
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
	
	/**
	 * Queries the DB and prints the result.
	 * @param query is the query defined by the user.
	 */
	public void queryDbAndPrintRs(String query) {
		printResultSet(queryDb(query));
	}
	
	/**
	 * Closes current DB connection.
	 * @throws SQLException in case an error with operation on DB happens.
	 */
	public void closeConnection() {
		try {
			this.connection.close();
			this.connection = null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @return true if DbHandler object has an open connection, false otherwise.
	 */
	public boolean isConnectionOpen() {
		if(this.connection == null)
			return false;
		return true;
	}
	
	
	
	//--------------------FIELDS-------------------
	/** Field containing the connection object to the database. */
	 private Connection connection;
	 
	 //STATIC FIELDS
	 /** Static field defining the connection driver class used in the program. */
	 public static String JConnectionClass = "com.mysql.cj.jdbc.Driver";
}
