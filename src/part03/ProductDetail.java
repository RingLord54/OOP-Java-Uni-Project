package part03;

import javax.swing.ImageIcon;
import part01.Department;
import part01.Product;

/**
 * 
 * This class defines the creation and alteration of ProductDetail Objects
 * 
 * @author Andrew Moneypenny
 *
 */

public class ProductDetail extends Product {
	
	private String description;
	private ImageIcon image;
	
	/**
	 * This is one of two constructor methods that's used to create ProductDetail Object Instances
	 * using the product manufacturer, model, price, associated department, description and
	 * image.
	 * 
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @param price - the product price in £
	 * @param dept - associated product department
	 * @param description - the description of the Product
	 * @param image - The Image of the Product
	 */
	public ProductDetail(String make, String model, double price, Department dept, String description, ImageIcon image) {
		super(make, model, price, dept);
		this.description = description;
		this.image = image;
	}
	
	
	/**
	 * 
	 * This is one of two constructor methods that's used to create ProductDetail Object Instances
	 * using the product manufacturer, model, price, associated department, quantity, description 
	 * and image.
	 * 
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @param price - the product price in £
	 * @param dept - associated product department
	 * @param quantity - defines amount of a product available
	 * @param description - the description of the Product
	 * @param image - The Image of the Product
	 */
	public ProductDetail(String make, String model, double price, Department dept, int quantity, String description, ImageIcon image) {
		super(make, model, price, dept, quantity);
		this.description = description;
		this.image = image;
	}
	
	
	/**
	 * This accessor method is designed to return the description of the Product
	 * 
	 * @return description - The textual description of the Product
	 */
	public String getDescription() {
		return this.description;
	}
	
	
	/**
	 * This accessor method is designed to return the Product's image
	 * 
	 * @return image - The Image of the Product
	 */
	public ImageIcon getImage() {
		return this.image;
	}
	
	
	/**
	 * This method is designed to return the details of the Product by utilising the
	 * Product superclass toString() method and this classes' toString() method
	 * 
	 * @return details - the details of the Product
	 */
	public String toString() {
		String details = "";
		details += super.toString();
		details += "\nDescription: " + getDescription() + "\t";
		return details;
	}

}
