package part01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the Application class for the Retail Department Management
 * System. It will provide an IDE-Console based interface to do things
 * such as add Products, delete Products, view all Products, create Sales
 * reports etc.
 * 
 * @author Andrew Moneypenny
 *
 */

public class WarehouseApp {
	
	// Will allow input to be taken from the User anywhere in the Application
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse("Andrew");
		// Will add 2 Object Instances of each Department to the warehouse
		addBaseProducts(warehouse);
		String options[] = { "Add new Product", 
				"Delete a Product", 
				"List all Products for a Department",
				"List all Products",
				"Add stock for a Product",
				"Sales Report",
				"Record Purchase",
				"Exit"
		};
		Menu sysMenu = new Menu("Retail Management System", options);
		int choice;
		do {
			choice = sysMenu.getUserChoice();
			if (choice == options.length) {
				break;
			}
			processChoice(choice, warehouse);
		} while (true);

		System.out.println("\nRetail Management App Terminated.");

	}
	
	
	
	/**
	 * This method is designed to take in the value of the selection made by the User
	 * on the Menu, and then select the correct function based on that
	 * 
	 * @param choice - The selection made by the User
	 * @param warehouse - The Warehouse object instance being used
	 */
	private static void processChoice(int choice, Warehouse warehouse) {
		switch (choice) {
		case 1: addProduct(warehouse); break;
		case 2: deleteProduct(warehouse); break;
		case 3: listAllProductsDept(warehouse); break;
		case 4: listAllProducts(warehouse); break;
		case 5: addProductStock(warehouse); break;
		case 6: createSalesReport(warehouse); break;
		case 7: recordPurchase(warehouse); break;
		default: System.out.println("\nError - Invalid Option.\n"); break;
		}
	}
	
	
	
	/**
	 * This method is designed to allow Product object instances to be added
	 * to the Warehouse object instance by getting input from the user.
	 * The Product is then added after a check is done to ensure that there's
	 * no Product with the same model and manufacturer. Then it's validated 
	 * through the methods included in the Product object's constructor method.
	 * 
	 * @param warehouse - The Warehouse object instance being used
	 */
	private static void addProduct(Warehouse warehouse) {
		System.out.println("\nAdding New Product to the Warehouse...");
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.print("---> Please enter the Product's Manufacturer: ");
		String make = input.nextLine();
		System.out.print("---> Please enter the Product's Model: ");
		String model = input.nextLine();
		System.out.print("---> Please enter the Price of the Product (in £s): ");
		double price = input.nextDouble();
		input.nextLine();
		System.out.print("---> Please enter the associated Product Department: ");
		String temp = input.nextLine();
		Department dept = Utility.getDepartmentType(temp);
		System.out.print("---> Please enter the quantity of the Product (Enter 0 if you don't know): ");
		int quantity = input.nextInt();
		input.nextLine();
		String res;
		if (quantity > 0) {
			res = warehouse.addProduct(make, model, price, dept, quantity);
		}
		else {
			res = warehouse.addProduct(make, model, price, dept);
		}
		if (res.equals("Ok")) {
			System.out.println("Product successfully added!\n");
		}
		else {
			System.out.println(res + "\n");
		}
	}
	
	
	
	/**
	 * This method is designed to allow the user to select a Product object instance from 
	 * the provided list to delete. Then after being asked again if they're sure they want 
	 * to delete it, if they say yes it's deleted. Any other response results in the Product 
	 * not being deleted from the Warehouse
	 * 
	 * @param warehouse - The Warehouse object instance being used
	 */
	private static void deleteProduct(Warehouse warehouse) {
		Product[] pros = warehouse.getAllProducts();
		if (pros != null) {
			System.out.println("\nSelect a Product to delete");
			System.out.println("++++++++++++++++++++++++++");
			Product[] products = warehouse.getAllProducts();
			int count = 1;
			System.out.println("0) Exit");
			for (Product pro : products) {
				System.out.println(count + ") " + pro);
				count++;
			}
			int value = Utility.validateValue();
			if (value != 0) {
				System.out.print("---> Are you sure you wish to delete this product? Yes or No: ");
				String response = input.nextLine();
				if (response.equals("Yes") || response.equals("yes")) {
					warehouse.deleteProduct(products[value-1].getCode());
					System.out.println("Product Successfully Deleted!\n");
				}
				else if (response.equals("No") || response.equals("no")) {
					System.out.println("Product not Deleted!\n");
				}
				else {
					System.out.println("Invalid Entry. Product not Deleted.\n");
				}
			}
			else {
				System.out.println("Returning to the Main Menu...\n");
			}
		}
		else {
			System.out.println("There are no Products to delete.\n");
		}
	}
	
	
	
	/**
	 * This method is designed to list all of the Product object instances that are 
	 * associated with the Department that the User chooses. If there are no current 
	 * Products within that selected Department, then a message saying that there are 
	 * no Products is displayed to the User
	 * 
	 * @param warehouse - The Warehouse object instance being used
	 */
	private static void listAllProductsDept(Warehouse warehouse) {
		System.out.println("\nListing All the Products in a given Department...");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("---> What department do you want to see the products of: ");
		String temp = input.nextLine();
		Department dept2 = Utility.getDepartmentType(temp);
		ArrayList<Product> departments = warehouse.search(dept2);
		System.out.println(dept2);
		System.out.println("==========================");
		if (departments.size() != 0 && departments != null) {
			for (Product pro : departments) {
				System.out.println(pro);
			}
			System.out.println();
		}
		else {
			System.out.println("No Products to be displayed\n");
		}
	}
	
	
	
	/**
	 * This method is designed to list all of the Product object instances in the 
	 * Warehouse object instance categorised by their associated Department, but 
	 * only if the Warehouse doesn't equal null. (The Warehouse's toString() method 
	 * is used for this)
	 * 
	 * @param warehouse - The Warehouse object instance being used
	 */
	private static void listAllProducts(Warehouse warehouse) {
		System.out.println("\nListing all Products...");
		System.out.println("+++++++++++++++++++++++");
		if (warehouse != null) {
			System.out.println(warehouse);
			System.out.println();
		}
		else {
			System.out.println("No Products to be displayed\n");
		}
	}
	
	
	
	/**
	 * This method is designed to allow the User to add stock to the Product object
	 * instance they choose from the list that's provided to them. They then enter a
	 * value for the quantity, and it's ensured that the value for the quantity is correct
	 * and suitable. Then the stock for the selected Product object instance is updated.
	 * 
	 * @param warehouse - The Warehouse object instance being used
	 */
	private static void addProductStock(Warehouse warehouse) {
		Product[] pros = warehouse.getAllProducts();
		if (pros != null) {
			System.out.println("\nSelect a Product to Add Stock to");
			System.out.println("++++++++++++++++++++++++++++++++");
			Product[] products = warehouse.getAllProducts();
			int count = 1;
			System.out.println("0) Exit");
			for (Product pro : products) {
				System.out.println(count + ") " + pro);
				count++;
			}
			int value = Utility.validateValue();
			if (value != 0) {
				int stock = 0;
				do {
					System.out.print("\n---> How much Stock are you adding to this Product: ");
					stock = input.nextInt();
					input.nextLine();
				} while(stock < 0);
				System.out.println("Adding Stock...");
				warehouse.restock(products[value-1].getCode(), stock);
				System.out.println("Stock successfully added!\n");
			}
			else {
				System.out.println("Returning to the Main Menu...\n");
			}
		}
		else {
			System.out.println("There are no Products to add Stock to.\n");
		}
		
		
	}
	
	
	
	/**
	 * This method is designed to create Sales reports for all of the Product object
	 * instances within the Warehouse object instance. This is done by sorting the
	 * Products into a decreasing order in purchases using an insert algorithm and an
	 * empty array equal in length to the Products one. The profit for each product is then
	 * calculated and displayed alongside some other Product information
	 * 
	 * @param warehouse - The Warehouse object instance being used
	 */
	private static void createSalesReport(Warehouse warehouse) {
		Product[] pros = warehouse.getAllProducts();
		if (pros != null) {
			System.out.println("\nCreating Sales Report...");
			System.out.println("++++++++++++++++++++++++");
			Product[] products = warehouse.getAllProducts();
			Product[] sorted = new Product[products.length];
			for (int i = 0; i < products.length; i++) {
				Utility.InsertSort(products[i], sorted, i);
			}
			int count = 1;
			for (Product pro: sorted) {
				double profit = pro.getPurchases() * pro.getPrice();
				String res = "";
				res += count + ")";
				res += " Make: " + pro.getMake();
				res += ", Model: " + pro.getModel();
				res += ", Purchases: " + pro.getPurchases();
				res += ", Price: " + String.format("£%.2f", pro.getPrice());
				res += ", Total Profit: " + String.format("£%.2f", profit);
				count++;
				System.out.println(res);
			}
			System.out.println();
		}
		else {
			System.out.println("There are no Products to create Sales Reports for.\n");
		}
	}
	
	
	
	/**
	 * This method is designed to allow the User to record purchases for the Product
	 * object instance that they choose. Once a selection is made, they are prompted to
	 * enter the amount of purchases to be recorded, and as long as that amount is less
	 * than or equal to that Product's current quantity, the purchases will be recorded
	 * 
	 * @param warehouse - The Warehouse object instance being used
	 */
	private static void recordPurchase(Warehouse warehouse) {
		Product[] pros = warehouse.getAllProducts();
		if (pros != null) {
			System.out.println("\nSelect a Product to record Purchases for");
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			Product[] products = warehouse.getAllProducts();
			int count = 1;
			System.out.println("0) Exit");
			for (Product pro : products) {
				System.out.println(count + ") " + pro);
				count++;
			}
			int value = Utility.validateValue();
			if (value != 0) {
				int purchases = 0;
				do {
					System.out.print("How many purchses of this item do you wish to record: ");
					purchases = input.nextInt();
					input.nextLine();
				}while(purchases > products[value-1].getQuantity());
				System.out.println("Recording Purchases...");
				for (int i = 0; i < purchases; i++) {
					products[value-1].recordPurchase();
				}
				System.out.println("Purchases successfully recorded\n");
			}
			else {
				System.out.println("Returning to the Main Menu...\n");
			}
		}
		else {
			System.out.println("There are no Products to record purchases for.\n");
		}
	}
	
	
	
	/**
	 * This method is designed to add 14 Product Object Instances to the warehouse, 2 per
	 * Department
	 * 
	 * @param warehouse - The Warehouse Object Instance
	 */
	private static void addBaseProducts(Warehouse warehouse) {
		warehouse.addProduct("B&Q", "Black 25m Multi-core Cable", 27.99, Department.ELECTRICAL);
		warehouse.addProduct("B&Q", "Black Electrical Tape", 0.80, Department.ELECTRICAL);
		warehouse.addProduct("Canon", "Camera Tripod", 76.00, Department.PHOTOGRAPHIC, 30);
		warehouse.addProduct("Canon", "Canon PowerShot SX430", 159.99, Department.PHOTOGRAPHIC, 25);
		warehouse.addProduct("Microsoft", "Xbox Series X", 449.99, Department.COMPUTING, 45);
		warehouse.addProduct("Sony", "Playstation 5", 449.99, Department.COMPUTING, 5);
		warehouse.addProduct("Waterstones", "The Hobbit", 9.99, Department.BOOKS, 19);
		warehouse.addProduct("Waterstones", "The Lord of the Rings: The Two Towers", 9.99, Department.BOOKS, 20);
		warehouse.addProduct("Sabaton", "The Last Stand Vinyl", 29.99, Department.MUSIC, 50);
		warehouse.addProduct("Gorillaz", "Gorillaz Vinyl", 29.99, Department.MUSIC, 50);
		warehouse.addProduct("Adidas", "Adicolor Hoodie", 55.00, Department.FASHION);
		warehouse.addProduct("Coldplay", "Rush of Blood to the Head T-Shirt", 25.99, Department.FASHION);
		warehouse.addProduct("Lego", "Lego Millennium Falcon", 139.99, Department.OTHER);
		warehouse.addProduct("Copic", "Copic Markers 72 Colours B", 439.00, Department.OTHER);
	}
	
	
	
}
