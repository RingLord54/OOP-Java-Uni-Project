package part01;

import java.util.ArrayList;

/**
 * This class defines the creation and alteration of Warehouse Object Instances
 * This class also makes use of the Product Class
 * 
 * @author Andrew Moneypenny
 *
 */

public class Warehouse implements iWare {

	private String name;
	protected ArrayList<Product> data; //An ArrayList containing all product references 
	
	
	/**
	 * This is the constructor used to create Warehouse Object Instances
	 * 
	 * @param name - The Warehouse Owner
	 */
	public Warehouse(String name) {
		this.name = Utility.validateName(name); // Validates the Warehouse Owner Name
		data = new ArrayList<Product>();
	}
	
	
	
	/**
	 * This accessor method is designed to return the name of the Warehouse Owner
	 * 
	 * @return the Warehouse Owner's name
	 */
	public String getName() {
		return this.name;
	}
	
	
	
	/**
	 * returns an array of all Product Object references, or null if there are no Products in the Warehouse
	 * 
	 * @return Array of Product Object Instances
	 */
	public Product[] getAllProducts() {
		if (data.size() > 0 && data != null) {
			Product[] Products = data.toArray(new Product[0]);
			return Products;
		}
		return null;
	}
	
	
	
	/**
	 * Overloaded to allow for addition of Product Objects without specifying the initial quantity available. 
	 * Parameters (in order) are: make, model, price, Department
	 * Returns a String – “OK” for success or an error message (reason for failure) 
	 * Must ensure that there are no 2 products with same make and model.
	 * 
	 * @param make - the Product manufacturer
	 * @param model - the Product model
	 * @param price - the Product price in £
	 * @param dept - the associated Product department
	 * @return String value to either confirm or deny the Products addition to the warehouse
	 */
	public String addProduct(String make, String model, double price, Department dept) {
		Product product = new Product(make, model, price, dept);
		Product product2 = search(make, model);
		if (product2 == null) {
			data.add(product);
			return "Ok";
		} else {
			return "The product could not be added to the Warehouse as a product with the same manufacturer and model already exists";
		}
		
	}
	
	
	
	/**
	 * Overloaded to allow for addition of Product Objects with specifying the initial quantity available.  
	 * Parameters (in order) are: make, model, price, Department and quantity
	 * Returns a String – “OK” for success or an error message (reason for failure) 
	 *  Must ensure that there are no 2 products with same make and model.
	 * 
	 * @param make - the Product manufacturer
	 * @param model - the Product model
	 * @param price - the Product price in £
	 * @param dept - the associated Product department
	 * @param quantity - defines amount of a Product available
	 * @return String value to either confirm or deny the Products addition to the warehouse
	 */
	public String addProduct(String make, String model, double price, Department dept, int quantity) {
		Product product = new Product(make, model, price, dept, quantity);
		Product product2 = search(make, model);
		if (product2 == null) {
			data.add(product);
			return "Ok";
		} else {
			return "The product could not be added to the Warehouse as a product with the same manufacturer and model already exists";
		}
	}
	
	
	
	/**
	 * This method is designed to return the Product contained within the ArrayList that matches
	 * the given Product Manufacturer and Model
	 * 
	 * @param make - the product manufacturer
	 * @param model - the product model
	 * @return Product that matches the Product Manufacturer and Model
	 * @return null if there are no matches
	 */
	public Product search(String make, String model) {
		for (Product pro : data) {
			if (pro.getMake().toUpperCase().equals(make.toUpperCase()) && pro.getModel().toUpperCase().equals(model.toUpperCase())) {
				return pro;
			}
		}
		return null;
	}
	
	
	
	/**
	 * This method is designed to return the Product contained within the ArrayList that matches
	 * the given Product Code
	 * 
	 * @param code - The unique identifying code of the product
	 * @return Product that matches the Product Code
	 * @return null if there are no matches
	 */
	public Product search(String code) {
		for (Product pro : data) {
			String ID = pro.getCode();
			if (ID.equals(code)) {
				return pro;
			}
		}
		return null;
	}
	
	
	
	/**
	 * This method is designed to return an ArrayList of Products that's contained within the Warehouse 
	 * that matches the given Product department
	 * 
	 * @param dept - the associated product department
	 * @return ArrayList of Product Object Instances that match the given Department value
	 * @return null ArrayList if there are no matches
	 */
	public ArrayList<Product> search(Department dept) {
		ArrayList<Product> department = new ArrayList<Product>();
		for (Product pro : data) {
			if (pro.getDepartment().toString() == Utility.validateDepartment(dept).getDepartment()) {
				department.add(pro);
			}
		}
		return department;
	}


	
	/**
	 * This method is designed to search the Warehouse Instance to check to see if
	 * the Product you're trying to remove actually exists, based on the given Product
	 * code. Then, if it's present within the Warehouse Instance, it's removed
	 * 
	 * @param pCode - The unique identifying code of the Product
	 * @return true - If the Product was found and deleted successfully
	 * @return false - If the Product doesn't exist and so can't be removed
	 */
	public boolean deleteProduct(String pCode) {
		Product pro1 = search(pCode);
		if (pro1 != null) {
			data.remove(pro1);
			return true;
		}
		else {
			System.out.println("Sorry, the product you're trying to delete doesn't exist");
			return false;
		}
	}


	
	/**
	 * This method is designed to search the warehouse Instance for the Product, based
	 * on the given Product code, to ensure that it exists. Then, if the Product does
	 * exist, its current quantity/stock level is increased by the amount given by the
	 * parameter "quantity"
	 * 
	 * @param pCode - The unique identifying code of the Product
	 * @param quantity - defines amount of a Product available
	 * @return true - if the Product was found and was able to be restocked successfully
	 * @return false - If the Product doesn't exist and wasn't able to be restocked.
	 */
	public boolean restock(String pCode, int quantity) {
		Product pro1 = search(pCode);
		if (pro1 != null) {
			for (Product pro : data) {
				if (pro1.getCode() == pro.getCode()) {
					pro.addToQuantity(quantity);
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	/**
	 * This toString method is designed to return the details of all the Product Object Instances
	 * in the Warehouse categorised by their associated department. Also, if a department
	 * has no Product Object Instances associated with it, then it's skipped.
	 * 
	 * @return all of the details of all the Product Object Instances currently within the Warehouse
	 */
	public String toString() {
		Department departments[] = {Department.ELECTRICAL, Department.PHOTOGRAPHIC, Department.COMPUTING,
				                    Department.BOOKS, Department.MUSIC, Department.FASHION, Department.OTHER};
		String res = "";
		for (int i = 0; i < departments.length; i++) {
			ArrayList<Product> department = search(departments[i]);
			if (department.size() != 0) {
				res += "\n\n" + departments[i];
				res += "\n===============";
				for (int j = 0; j < department.size(); j++) {
					res += "\n" + department.get(j);
				}
			}
		}
		if (res == "") {
			res += "There are no products in the warehouse to display";
		}
		return res;
	}
	

	
}
