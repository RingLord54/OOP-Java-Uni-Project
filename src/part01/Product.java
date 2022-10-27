package part01;

/**
 * This class defines the creation and alteration of Product Object Instances
 * 
 * @author Andrew Moneypenny
 *
 */

public class Product implements iPro {
	
	private String code;
	private static int nextCode = 1;
	private String make;
	private String model;
	private double price;
	private int quantity;
	private int purchases;
	private Department dept;
	
	
	
	/**
	 * This is one of two constructor methods that's used to create Product Object Instances
	 * using the Product manufacturer, model, price and associated department.
	 * 
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @param price - the product price in £
	 * @param dept - associated product department
	 */
	public Product(String make, String model, double price, Department dept) {
		this.make = Utility.validateMake(make);       // validates the manufacturer
		this.model = Utility.validateModel(model);    // validates the model
		this.price = Utility.validatePrice(price);    // validates the price
		this.dept = Utility.validateDepartment(dept); // validates the Department
		this.code = nextCode();
		this.quantity = 0;
		this.purchases = 0;
	}
	
	
	
	/**
	 * This is one of two constructor methods that's used to create Product Object Instances
	 * using the Product manufacturer, model, price, associated department and quantity.
	 * 
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @param price - the product price in £
	 * @param dept - associated product department
	 * @param quantity - defines amount of a product available
	 */
	public Product(String make, String model, double price, Department dept, int quantity) {
		this.make = Utility.validateMake(make);       // validates the manufacturer
		this.model = Utility.validateModel(model);    // validates the model
		this.price = Utility.validatePrice(price);    // validates the price
		this.dept = Utility.validateDepartment(dept); // validates the Department
		this.code = nextCode();
		this.quantity = Utility.validateQuantity(quantity); // validates the Quantity
		this.purchases = 0;
	}
	
	
	
	/**
	 * This method is designed to allow each Product to have a unique code
	 * 
	 * @return ID - an incremented code
	 */
	private String nextCode() {
		String dept = getDepartment().toString();
		String ID = "";
		switch(dept) {
		case "Electrical": ID += "E"; break;
		case "Photographic": ID += "P"; break;
		case "Computing": ID += "C"; break;
		case "Books": ID += "B"; break;
		case "Music": ID += "M"; break;
		case "Fashion": ID += "F"; break;
		case "Other": ID += "O"; break;
		}
		ID += String.format("%04d", nextCode++);
		ID = ID.toString();
		return ID;
	}
	
	
	
	/**
	 * This accessor method is designed to return the Product's unique code
	 * 
	 * @return code - the Product's unique code
	 */
	public String getCode() {
		return this.code;
	}
	
	
	
	/**
	 * This accessor method is designed to return the Product's manufacturer
	 * 
	 * @return make - the Product manufacturer
	 */
	public String getMake() {
		return this.make;
	}
	
	
	
	/**
	 * This accessor method is designed to return the Product's model
	 * 
	 * @return model - the Product model
	 */
	public String getModel() {
		return this.model;
	}
	
	
	
	/**
	 * This accessor method is designed to return the price of the Product
	 * 
	 * @return price - the Product price in £
	 */
	public double getPrice() {
		return this.price;
	}
	
	
	
	/**
	 * This accessor method is designed to return the amount of the Product that is available
	 * 
	 * @return quantity - the amount of a Product available
	 */
	public int getQuantity() {
		return this.quantity;
	}

	
	
	/**
	 * This method is designed in order to increase the quantity of a Product
	 * 
	 * @param qty - the amount of Stock to be added to the current quantity
	 */
	public void addToQuantity(int qty) {
		if (qty >= 0) {
			this.quantity += qty;
		}
		else {
			System.out.println("Invalid quantity amount");
			this.quantity += 0;
		}
	}
	
	
	
	/**
	 * This accessor method is designed to return the amount of times a Product has been purchased
	 * 
	 * @return purchases - the number of purchases for a Product
	 */
	public int getPurchases() {
		return this.purchases;
	}
	
	
	
	/**
	 * This method is designed to allow purchases to occur if the quanity of the Product is
	 * greater than 0, this is to prevent any negative quantities
	 * 
	 * @return true - if the purchase can be made
	 * @return false - if the purchase cannot be made
	 */
	public boolean recordPurchase() {
		if (this.quantity > 0) {
			this.purchases += 1; // increments the total purchases by 1.
			this.quantity -= 1;  // decrements the total quantity by 1;
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * This accessor method is designed to return the Product's associated Department type
	 * 
	 * @return dept - the associated Product department
	 */
	public Department getDepartment() {
		return this.dept;
	}
	

	
	/**
	 * This method is designed to return the details of the Product by utilising the
	 * toString() method
	 * 
	 * @return details - the details of the Product
	 */
	public String toString() {
		String details = "";
		details += "Code: " + this.getCode() + " - ";
		details += "Manufacturer: " + this.getMake() + " - ";
		details += "Model: " + this.getModel() + " - ";
		details += "Price: " + String.format("£%.2f", this.getPrice()) + " - ";
		details += "Quantity: " + this.getQuantity() + " - ";
		details += "Purchases: " + this.getPurchases() + " - ";
		details += "Department: " + this.getDepartment();
		return details;
	}
}
