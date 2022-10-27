package part03;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import console.Console;
import part01.Department;
import part01.Product;
import part01.Utility;

/**
 * This is the Application class for the Retail Department Management
 * System. It will provide an Console Window based interface to do things
 * such as add Products, delete Products, view all Products, create Sales
 * reports etc.
 * 
 * @author Andrew Moneypenny
 *
 */

public class WarehouseApp {
	
	public static void main(String[] args) {
		WarehouseDetail warehouse = new WarehouseDetail("Andrew");
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
		ConsoleMenu sysMenu = new ConsoleMenu("Retail Management System", options);
		// Allows the WarehouseApp to use the same console as the Menu
		Console console = sysMenu.getConsole();
		int choice;
		do {
			choice = sysMenu.getUserChoice();
			if (choice == options.length) {
				break;
			}
			processChoice(choice, warehouse, console);
		} while (true);

		console.println("\nRetail Management App Terminated.");

	}
	
	
	
	/**
	 * This method is designed to take in the value of the selection made by the User
	 * on the Menu, and then select the correct function based on that
	 * 
	 * @param choice - The selection made by the User
	 * @param warehouse - The Warehouse object instance being used
	 */
	private static void processChoice(int choice, WarehouseDetail warehouse, Console console) {
		switch (choice) {
		case 1: addProduct(warehouse, console); break;
		case 2: deleteProduct(warehouse, console); break;
		case 3: listAllProductsDept(warehouse, console); break;
		case 4: listAllProducts(warehouse, console); break;
		case 5: addProductStock(warehouse, console); break;
		case 6: createSalesReport(warehouse, console); break;
		case 7: recordPurchase(warehouse, console); break;
		default: console.println("\nError - Invalid Option.\n"); break;
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
	private static void addProduct(WarehouseDetail warehouse, Console console) {
		console.println("\nAdding New Product to the Warehouse...");
		console.println("++++++++++++++++++++++++++++++++++++++");
		console.print("---> Please enter the Product's Manufacturer: ");
		String make = console.readLn();
		console.print("---> Please enter the Product's Model: ");
		String model = console.readLn();
		console.print("---> Please enter the Price of the Product (in £s): ");
		String priceTemp = console.readLn();
		double price = 0;
		if (priceTemp != null && priceTemp.length() != 0) {
			price = Double.parseDouble(priceTemp);
		}
		console.print("---> Please enter the associated Product Department: ");
		String temp = console.readLn();
		Department dept = Utility.getDepartmentType(temp);
		console.print("---> Please enter the quantity of the Product (Enter 0 if you don't know): ");
		String quantityTemp = console.readLn();
		int quantity = 0;
		if (quantityTemp != null && quantityTemp.length() != 0) {
			quantity = Integer.parseInt(quantityTemp);
		}
		console.print("---> Please enter the Product Description: ");
		String description = console.readLn();
		console.print("---> Please enter the Product Image's pathway: ");
		String imageTemp = console.readLn();
		ImageIcon image = new ImageIcon(imageTemp);
		String res = warehouse.addProduct(make, model, price, dept, quantity, description, image);
		if (res.equals("Ok")) {
			console.println("Product successfully added!\n");
		}
		else {
			console.println(res + "\n");
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
	private static void deleteProduct(WarehouseDetail warehouse, Console console) {
		Product[] pros = warehouse.getAllProducts();
		if (pros != null) {
			console.println("\nSelect a Product to delete");
			console.println("++++++++++++++++++++++++++");
			Product[] products = warehouse.getAllProducts();
			int count = 1;
			console.println("0) Exit\n");
			for (Product pro : products) {
				console.println(count + ") " + pro + "\n");
				count++;
			}
			String temp;
			do {
				console.print("Enter Selection (Enter \"0\" to Exit): ");
				temp = console.readLn();
			} while (Integer.parseInt(temp) < 0 && Integer.parseInt(temp) > products.length);
			int value = Integer.parseInt(temp);
			if (value != 0) {
				console.print("---> Are you sure you wish to delete this product? Yes or No: ");
				String response = console.readLn();
				if (response.equals("Yes") || response.equals("yes")) {
					warehouse.deleteProduct(products[value-1].getCode());
					console.println("Product Successfully Deleted!\n");
				}
				else if (response.equals("No") || response.equals("no")) {
					console.println("Product not Deleted!\n");
				}
				else {
					console.println("Invalid Entry. Product not Deleted.\n");
				}
			}
			else {
				console.println("Returning to the Main Menu...\n");
			}
		}
		else {
			console.println("There are no Products to delete.\n");
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
	private static void listAllProductsDept(WarehouseDetail warehouse, Console console) {
		console.println("\nListing All the Products in a given Department...");
		console.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
		console.print("---> What department do you want to see the products of: ");
		String temp = console.readLn();
		Department dept2 = Utility.getDepartmentType(temp);
		ArrayList<Product> departments = warehouse.search(dept2);
		ArrayList<ProductDetail> depts = UtilityDetail.convertToProductDetail(departments);
		console.println(dept2);
		console.println("==========================");
		if (depts.size() != 0 && depts != null) {
			for (ProductDetail pro : depts) {
				console.println(pro);
				console.println(pro.getImage());
			}
			console.println();
		}
		else {
			console.println("No Products to be displayed\n");
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
	private static void listAllProducts(WarehouseDetail warehouse, Console console) {
		console.println("\nListing all Products...");
		console.println("+++++++++++++++++++++++");
		if (warehouse != null) {
			console.println(warehouse.toString(console));
			console.println();
		}
		else {
			console.println("No Products to be displayed\n");
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
	private static void addProductStock(WarehouseDetail warehouse, Console console) {
		Product[] pros = warehouse.getAllProducts();
		if (pros != null) {
			console.println("\nSelect a Product to Add Stock to");
			console.println("++++++++++++++++++++++++++++++++");
			Product[] products = warehouse.getAllProducts();
			int count = 1;
			console.println("0) Exit\n");
			for (Product pro : products) {
				console.println(count + ") " + pro + "\n");
				count++;
			}
			String temp;
			do {
				console.print("Enter Selection (Enter \"0\" to Exit): ");
				temp = console.readLn();
			} while (Integer.parseInt(temp) < 0 && Integer.parseInt(temp) > products.length);
			int value = Integer.parseInt(temp);
			if (value != 0) {
				String temp2;
				do {
					console.print("\n---> How much Stock are you adding to this Product: ");
					temp2 = console.readLn();
				} while(Integer.parseInt(temp2) < 0);
				int stock = Integer.parseInt(temp2);
				console.println("Adding Stock...");
				warehouse.restock(products[value-1].getCode(), stock);
				console.println("Stock successfully added!\n");
			}
			else {
				console.println("Returning to the Main Menu...\n");
			}
		}
		else {
			console.println("There are no Products to add Stock to.\n");
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
	private static void createSalesReport(WarehouseDetail warehouse, Console console) {
		Product[] pros = warehouse.getAllProducts();
		if (pros != null) {
			console.println("\nCreating Sales Report...");
			console.println("++++++++++++++++++++++++");
			Product[] products = warehouse.getAllProducts();
			Product[] sorted = new Product[products.length];
			for (int i = 0; i < products.length; i++) {
				UtilityDetail.InsertSort(products[i], sorted, i, console);
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
				console.println(res);
				count++;
			}
			console.println();
		}
		else {
			console.println("There are no Products to create Sales Reports for.\n");
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
	private static void recordPurchase(WarehouseDetail warehouse, Console console) {
		Product[] pros = warehouse.getAllProducts();
		if (pros != null) {
			console.println("\nSelect a Product to record Purchases for");
			console.println("++++++++++++++++++++++++++++++++++++++++");
			Product[] products = warehouse.getAllProducts();
			int count = 1;
			console.println("0) Exit\n");
			for (Product pro : products) {
				console.println(count + ") " + pro + "\n");
				count++;
			}
			String temp;
			do {
				console.print("Enter Selection (Enter \"0\" to Exit): ");
				temp = console.readLn();
			} while (Integer.parseInt(temp) < 0 && Integer.parseInt(temp) > products.length);
			int value = Integer.parseInt(temp);
			if (value != 0) {
				String temp2;
				do {
					console.print("How many purchses of this item do you wish to record: ");
					temp2 = console.readLn();
				}while(Integer.parseInt(temp2) > products[value-1].getQuantity());
				int purchases = Integer.parseInt(temp2);
				console.println("Recording Purchases...");
				for (int i = 0; i < purchases; i++) {
					products[value-1].recordPurchase();
				}
				console.println("Purchases successfully recorded\n");
			}
			else {
				console.println("Returning to the Main Menu...\n");
			}
		}
		else {
			console.println("There are no Products to record purchases for.\n");
		}
	}
	
	
	
	/**
	 * This method is designed to add 14 Product Object Instances to the warehouse, 2 per
	 * Department
	 * 
	 * @param warehouse - The Warehouse Object Instance
	 */
	private static void addBaseProducts(WarehouseDetail warehouse) {
		ImageIcon img1 = new ImageIcon("Images\\BlackMulticoreCable.jpeg");
		warehouse.addProduct("B&Q", "Black 25m Multi-core Cable", 27.99, Department.ELECTRICAL, "25 metres of Black 3 core Multi Core cables", img1);
		ImageIcon img2 = new ImageIcon("Images\\BlackElectricalTape.jpeg");
		warehouse.addProduct("B&Q", "Black Electrical Tape", 0.80, Department.ELECTRICAL, "Black Electrical Tape that costs £0.80 per metre", img2);
		
		ImageIcon img3 = new ImageIcon("Images\\CanonTripod.jpeg");
		warehouse.addProduct("Canon", "Camera Tripod", 76.00, Department.PHOTOGRAPHIC, 30, "A Camera Tripod by Canon, for extra stability", img3);
		ImageIcon img4= new ImageIcon("Images\\CanonCamera.jpeg");
		warehouse.addProduct("Canon", "Canon PowerShot SX430 IS", 159.99, Department.PHOTOGRAPHIC, 25, "The Powershot SX430 IS by Canon, has a 20 Megapixel camera and can have a 45x zoom", img4);
		
		ImageIcon img5 = new ImageIcon("Images\\XboxSeriesX.jpeg");
		warehouse.addProduct("Microsoft", "Xbox Series X", 449.99, Department.COMPUTING, 45, "The Next Generation Gaming Console produced by Microsoft", img5);
		ImageIcon img6 = new ImageIcon("Images\\Playstation5.jpeg");
		warehouse.addProduct("Sony", "Playstation 5", 449.99, Department.COMPUTING, 5, "The Next Generation Gaming Console produced by Sony", img6);
		
		ImageIcon img7 = new ImageIcon("Images\\TheHobbit.jpeg");
		warehouse.addProduct("Waterstones", "The Hobbit", 9.99, Department.BOOKS, 19, "The Hobbit is a fantasy/adventure novel by J.R.R Tolkien", img7);
		ImageIcon img8 = new ImageIcon("Images\\TheTwoTowers.jpeg");
		warehouse.addProduct("Waterstones", "The Lord of the Rings: The Two Towers", 9.99, Department.BOOKS, 20, "The Two Towers is the second book in the Lord of the Rings Trilogy by J.R.R Tolkien, and is a fantasy/adventure novel", img8);
		
		ImageIcon img9 = new ImageIcon("Images\\SabatonVinyl.jpeg");
		warehouse.addProduct("Sabaton", "The Last Stand Vinyl", 29.99, Department.MUSIC, 50, "The Vinyl Record of \"The Last Stand\", Sabaton's 8th studio album", img9);
		ImageIcon img10 = new ImageIcon("Images\\GorillazVinyl.jpeg");
		warehouse.addProduct("Gorillaz", "Gorillaz Vinyl", 29.99, Department.MUSIC, 50, "The Vinyl Record of \"Gorillaz\", the first studio album by the Gorillaz", img10);
		
		ImageIcon img11 = new ImageIcon("Images\\AdidasHoodie.jpeg");
		warehouse.addProduct("Adidas", "Adicolor Hoodie", 55.00, Department.FASHION, "The Adidas Adicolor Trefoil Hoodie that comes in a range of sizes", img11);
		ImageIcon img12 = new ImageIcon("Images\\ColdplayTShirt.jpeg");
		warehouse.addProduct("Coldplay", "Rush of Blood to the Head T-Shirt", 25.99, Department.FASHION, "A T-Shirt depicting Coldplay's second studio album \"A Rush of Blood to the Head\"", img12);
		
		ImageIcon img13 = new ImageIcon("Images\\LegoMillenniumFalcon.jpeg");
		warehouse.addProduct("Lego", "Lego Millennium Falcon", 139.99, Department.OTHER, "The 1351 piece Lego Millennium Falcon set", img13);
		ImageIcon img14 = new ImageIcon("Images\\CopicMarkers.jpeg");
		warehouse.addProduct("Copic", "Copic Markers 72 Colours Set B", 439.00, Department.OTHER, "A set of 72 alcohol based coloured markers", img14);
	}
}
