import java.util.List;

/**
 * Represents a Store object which manages clients, products and orders.
 */
public class Store {

	//------------CONSTRUCTORS------------
	
	//Default constructor
	public Store() {}
	
	//Full build constructor
	public Store(List<Product> argproducts, List<Client> argclients, List<Order> argorders) {
		this.products = argproducts;
		this.clients = argclients;
		this.orders = argorders;
	}
	
	
	//-------------METHODS----------------
	
	//Getters
	public List<Product> getProducts() {
        return products;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Order> getOrders() {
        return orders;
    }
    
    //Setters
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
    
    //Adders
    public void addProduct(Product product) {
        products.add(product);
    }

    public void addClient(Client client) {
        clients.add(client);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }
    
    //toStrings
    public String productsToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Products List:\n");
        for(Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        return sb.toString();
    }

    public String clientsToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clients List:\n");
        for(Client client : clients) {
            sb.append(client.toString()).append("\n");
        }
        return sb.toString();
    }

    public String ordersToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Orders List:\n");
        for(Order order : orders) {
            sb.append(order.toString()).append("\n");
        }
        return sb.toString();
    }
    
	//-------------FIELDS-----------
	List<Product> products;
	List<Client> clients;
	List<Order> orders;
	
}
