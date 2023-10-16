
public class Order {

	//------------------CONSTRUCTORS---------------
	public Order(int argorderId, String argclientEmail, String argorderDate, double argtotalCost) {
		this.orderId = argorderId;
		this.clientEmail = argclientEmail;
		this.orderDate = argorderDate;
		this.totalCost = argtotalCost;
	}
	
	//------------------METHODS--------------------
    public int getOrderId() {
        return orderId;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
	
	
	//---------------------FIELDS--------------------
	private int orderId;
	private String clientEmail;
	private String orderDate;
	private double totalCost;
}
