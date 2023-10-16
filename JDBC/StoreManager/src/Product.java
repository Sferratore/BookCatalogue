
public class Product {
	//----------CONSTRUCTORS-------------
	public Product(int argid, String argbrand, String argmodel, String argdescription, double argprice) {
		this.id = argid;
		this.brand = argbrand;
		this.model = argmodel;
		this.description = argdescription;
		this.price = argprice;	
	}
	//-------------METHODS----------------
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

	
	//-------------FIELDS------------------
	private int id;
	private String brand;
	private String model;
	private String description;
	private double price;
}
