/**
 * Represents Product table from the database.
 */
public class Product {
	
	
	//----------CONSTRUCTORS-------------
	
	
	//Default constructor
	public Product() {}
	
	//Full build constructor
	public Product(int argid, String argbrand, String argmodel, String argdescription, double argprice) {
		this.id = argid;
		this.brand = argbrand;
		this.model = argmodel;
		this.description = argdescription;
		this.price = argprice;	
	}
	
	
	//-------------METHODS----------------
	
	//Getters
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

    
    //Setters
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

    
    //ToString override to print the object if needed
    @Override
    public String toString() {
        return "Product{" +
               "id=" + id +
               ", brand='" + brand + '\'' +
               ", model='" + model + '\'' +
               ", description='" + description + '\'' +
               ", price=" + price +
               '}';
    }
	
    
    
	//-------------FIELDS------------------
	private int id;
	private String brand;
	private String model;
	private String description;
	private double price;
}
