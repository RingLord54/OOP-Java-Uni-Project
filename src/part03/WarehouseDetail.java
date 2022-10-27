package part03;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import console.Console;
import part01.Department;
import part01.Product;
import part01.Warehouse;

public class WarehouseDetail extends Warehouse {
	
	
	public WarehouseDetail(String name) {
		super(name);
	}
	
	/**
	 * Overloaded to allow for addition of products without specifying the initial quantity available. 
	 * Parameters (in order) are: make, model, price, department, description and image
	 * Returns a String – “OK” for success or an error message (reason for failure) 
	 * Must ensure that there are no 2 products with same make and model.
	 * 
	 * @param make - the Product manufacturer
	 * @param model - the Product model
	 * @param price - the Product price in £
	 * @param dept - the associated Product department
	 * @param description - the description of the Product
	 * @param image - The Image of the Product
	 * @return String value to either confirm or deny the Products addition to the warehouse
	 */
	public String addProduct(String make, String model, double price, Department dept, String description, ImageIcon image) {
		ProductDetail product = new ProductDetail(make, model, price, dept, description, image);
		Product product2 = search(make, model);
		if (product2 == null) {
			data.add(product);
			return "Ok";
		} else {
			return "The product could not be added to the Warehouse as a product with the same manufacturer and model already exists";
		}
		
	}
	
	/**
	 * overloaded to allow for addition of products with specifying the initial quantity available.  
	 * Parameters (in order) are: make, model, price, department, quantity, description and image
	 * Returns a String – “OK” for success or an error message (reason for failure) 
	 *  Must ensure that there are no 2 products with same make and model.
	 * 
	 * @param make - the Product manufacturer
	 * @param model - the Product model
	 * @param price - the Product price in £
	 * @param dept - the associated Product department
	 * @param quantity - defines amount of a Product available
	 * @param description - the description of the Product
	 * @param image - The Image of the Product
	 * @return String value to either confirm or deny the Products addition to the warehouse
	 */
	public String addProduct(String make, String model, double price, Department dept, int quantity, String description, ImageIcon image) {
		ProductDetail product = new ProductDetail(make, model, price, dept, quantity, description, image);
		Product product2 = search(make, model);
		if (product2 == null) {
			data.add(product);
			return "Ok";
		} else {
			return "The product could not be added to the Warehouse as a product with the same manufacturer and model already exists";
		}
	}
	
	/**
	 * This toString method is designed to return the details of all the Product Object Instances
	 * in the Warehouse categorised by their associated department. Also, if a department
	 * has no Product Object Instances associated with it, then it's skipped.
	 * 
	 * @return all of the details of all the Product Object Instances currently within the Warehouse
	 */
	public String toString(Console console) {
		Department departments[] = {Department.ELECTRICAL, Department.PHOTOGRAPHIC, Department.COMPUTING,
				                    Department.BOOKS, Department.MUSIC, Department.FASHION, Department.OTHER};
		String res = "";
		for (int i = 0; i < departments.length; i++) {
			ArrayList<Product> department = search(departments[i]);
			ArrayList<ProductDetail> department2 = UtilityDetail.convertToProductDetail(department);
			if (department2.size() != 0) {
				console.println(departments[i]);
				console.println("===============");
				for (int j = 0; j < department2.size(); j++) {
					console.println(department2.get(j));
					if (department2.get(j).getImage() != null) {
						console.println(department2.get(j).getImage());
					}
					else {
						console.println("There was no image found");
					}
				}
				res += " ";
			}
		}
		if (res == "") {
			console.println("There are no products in the warehouse to display");
		}
		return res;
	}

}
