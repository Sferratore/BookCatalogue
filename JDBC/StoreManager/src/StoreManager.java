import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * StoreManager class is an interface with the DB that uses the Store object. Through it you can manage directly clients, products and orders.
 */
public class StoreManager {

	//--------------CONSTRUCTORS--------------
	
	//Default constructor
	public StoreManager() {
		this.connectToDb();  //Connects to the DB at initialization
	}
	
	
	//-----------------METHODS--------------
	
	//Creates connection with DB. Also syncs with it's data
	public String connectToDb(){
		
		String connectionString = String.format("jdbc:mysql://localhost:3306/%s", dbName);
		
		try {
			
			Class.forName(JConnectionClass); //Getting driver's class inside the program. Important to let the driver work.
			
			this.connection = DriverManager.getConnection(connectionString, dbUsername, dbPassword); //Creating connection
			
			if(!syncWithDb().equals("Operation successful")) {  //Syncing with DB data
				throw new SQLException();
			}
		}
		catch(ClassNotFoundException e) {
			return "The class " + JConnectionClass + " has not been found by the program.";
		}
		catch (SQLException e) {
			return "SQLException happened: " + e.toString();
		}
		catch(Exception e) {
			return "Connection not extabilished with the database." + e.toString();
		}
		
		return "Connection estabilished with database: \"" + dbName + "\"";

	}
	
	
	//Fills data of StoreManager's dbStore using database data
	public String syncWithDb() {
		
		//Table data to add to the store
		List<Order> ordersToAdd = new ArrayList<Order>();
		List<Product> productsToAdd = new ArrayList<Product>();
		List<Client> clientsToAdd = new ArrayList<Client>();
		
		//Utilities
		PreparedStatement prpSt;
		ResultSet rs;
		
		//Connection check
		if(this.connection == null) {
			return "You are not connected to any Db!";
		}
		
		
		try {
			
			//Adding clients
			prpSt = this.connection.prepareStatement("SELECT * FROM client");
			rs = prpSt.executeQuery();
			
			while(rs.next()) {
				Client c = new Client();
				c.setEmail(rs.getString("email"));
				c.setUsername(rs.getString("username"));
				c.setAddress(rs.getString("address"));
				c.setName(rs.getString("name"));
				c.setSurname(rs.getString("surname"));
				clientsToAdd.add(c);
			}
			
			//Adding Orders
			prpSt = this.connection.prepareStatement("SELECT * FROM orders");
			rs = prpSt.executeQuery();
			while(rs.next()) {
				Order o = new Order();
				o.setOrderId(rs.getInt("orderId"));
				o.setClientEmail(rs.getString("clientEmail"));
				o.setOrderDate(rs.getString("orderDate"));
				o.setTotalCost(rs.getDouble("totalCost"));
				ordersToAdd.add(o);
			}
			
			//Adding Products
			prpSt = this.connection.prepareStatement("SELECT * FROM product");
			rs = prpSt.executeQuery();
			
			while(rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setBrand(rs.getString("brand"));
				p.setModel(rs.getString("model"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getDouble("price"));
				productsToAdd.add(p);
			}
				
			//Build store object
			this.dbStore = new Store(productsToAdd, clientsToAdd, ordersToAdd);
			return "Operation successful.";
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			return "Something went wrong with SQL operations: " + e.toString();
		}
		catch(Exception e) {
			return "Something went wrong with the operation: " + e.toString();
		}

	}
	
	
	//Returns a string with all the product data contained into db
	public String getAllProducts() {
		syncWithDb(); //sync to have updated info
		return this.dbStore.productsToString(); //returns toString of products
	}
	
	//Returns a string with all the order data contained into db
	public String getAllOrders() {
		syncWithDb(); //sync to have updated info
		return this.dbStore.ordersToString(); //returns toString of orders
	}
		
	//Returns a string with all the client data contained into db
	public String getAllClients() {
		syncWithDb(); //sync to have updated info
		return this.dbStore.clientsToString(); //returns toString of clients
	}
	
	//Inserts a product object into the db.
	public String insertProduct(Product p) {
		
		String insertString = "INSERT INTO product (id, brand, model, description, price) VALUES (?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement prpSt = this.connection.prepareStatement(insertString);
			
			prpSt.setInt(1, p.getId());
			prpSt.setString(2, p.getBrand());
			prpSt.setString(3, p.getModel());
			prpSt.setString(4, p.getDescription());
            prpSt.setDouble(5, p.getPrice());
            
            prpSt.executeUpdate();
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			return "Something went wrong with the SQL operation: " + e.toString();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			return "Something went wrong with the operation: " + e.toString();
		}
		
		syncWithDb(); //resyncing
		
		return "Operation successful.";
	}
	
	
	// Inserts an order object into the db.
	public String insertOrder(Order o) {
	    
	    String insertString = "INSERT INTO orders (orderId, clientEmail, orderDate, totalCost) VALUES (?, ?, ?, ?)";
	    
	    try {
	        PreparedStatement prpSt = this.connection.prepareStatement(insertString);
	        
	        prpSt.setInt(1, o.getOrderId());
	        prpSt.setString(2, o.getClientEmail());
	        prpSt.setString(3, o.getOrderDate());
	        prpSt.setDouble(4, o.getTotalCost());
	        
	        prpSt.executeUpdate();
	    } 
	    catch (SQLException e) {
	        // TODO Auto-generated catch block
	        return "Something went wrong with the SQL operation: " + e.toString();
	    }
	    catch (Exception e) {
	        // TODO Auto-generated catch block
	        return "Something went wrong with the operation: " + e.toString();
	    }
	    
	    syncWithDb(); //resyncing
	    
	    return "Operation successful.";
	}
	
	
	// Inserts a client object into the db.
	public String insertClient(Client c) {
	    
	    String insertString = "INSERT INTO client (email, username, name, surname, address) VALUES (?, ?, ?, ?, ?)";
	    
	    try {
	        PreparedStatement prpSt = this.connection.prepareStatement(insertString);
	        
	        prpSt.setString(1, c.getEmail());
	        prpSt.setString(2, c.getUsername());
	        prpSt.setString(3, c.getName());
	        prpSt.setString(4, c.getSurname());
	        prpSt.setString(5, c.getAddress());
	        
	        prpSt.executeUpdate();
	    } 
	    catch (SQLException e) {
	        // TODO Auto-generated catch block
	        return "Something went wrong with the SQL operation: " + e.toString();
	    }
	    catch (Exception e) {
	        // TODO Auto-generated catch block
	        return "Something went wrong with the operation: " + e.toString();
	    }
	    
	    syncWithDb(); //resyncing
	    
	    return "Operation successful.";
	}
	
	
	//Deletes a product inside the db
	public String deleteProduct(int id) {
	    
		String deletionString = "DELETE FROM product WHERE id = ?";
		
		try {
	        PreparedStatement prpSt = this.connection.prepareStatement(deletionString);
	        prpSt.setInt(1, id);
	        prpSt.executeUpdate();
	    } 
	    catch (SQLException e) {
	        // TODO Auto-generated catch block
	        return "Something went wrong with the SQL operation: " + e.toString();
	    }
	    catch (Exception e) {
	        // TODO Auto-generated catch block
	        return "Something went wrong with the operation: " + e.toString();
	    }
	    
	    syncWithDb(); //resyncing
	    
	    return "Operation successful.";
	}
	
	// Deletes an order inside the db
	public String deleteOrder(int orderId) {
	    
	    String deletionString = "DELETE FROM orders WHERE orderId = ?";
	    
	    try {
	        PreparedStatement prpSt = this.connection.prepareStatement(deletionString);
	        prpSt.setInt(1, orderId);
	        prpSt.executeUpdate();
	    } 
	    catch (SQLException e) {
	        // TODO Auto-generated catch block
	        return "Something went wrong with the SQL operation: " + e.toString();
	    }
	    catch (Exception e) {
	        // TODO Auto-generated catch block
	        return "Something went wrong with the operation: " + e.toString();
	    }
	    
	    syncWithDb(); //resyncing
	    
	    return "Operation successful.";
	}
	
	
	// Deletes a client inside the db
	public String deleteClient(String email) {
	    
	    String deletionString = "DELETE FROM client WHERE email = ?";
	    
	    try {
	        PreparedStatement prpSt = this.connection.prepareStatement(deletionString);
	        prpSt.setString(1, email);
	        prpSt.executeUpdate();
	    } 
	    catch (SQLException e) {
	        // TODO Auto-generated catch block
	        return "Something went wrong with the SQL operation: " + e.toString();
	    }
	    catch (Exception e) {
	        // TODO Auto-generated catch block
	        return "Something went wrong with the operation: " + e.toString();
	    }
	    
	    syncWithDb(); //resyncing
	    
	    return "Operation successful.";
	}
	
	
	//-------------------FIELDS-------------------
	/** Field containing the connection object to the database. */
	 private Connection connection;
	 private Store dbStore;
	
	 
	//STATIC FIELDS
	/** Static field defining the connection driver class used in the program. */
	public static String JConnectionClass = "com.mysql.cj.jdbc.Driver";
	public static String dbUsername ="root";
	public static String dbPassword = "password";
	public static String dbName = "temporarydb";
}
