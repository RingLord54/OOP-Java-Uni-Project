package part02;

import java.util.ArrayList;
import part01.Department;
import part01.Product;
import part01.Utility;
import part01.Warehouse;

/**
 * This class is to be used to perform unit and integration testing on the
 * Warehouse class in order to ensure its functionality works across a broad
 * spectrum of potential input data.
 * 
 * @author Andrew Moneypenny
 *
 */

public class WarehouseTesting {

	public static void main(String[] args) {
		
		TestCase_25();
		TestCase_26();
		TestCase_27();
		TestCase_28();
		TestCase_29();
		TestCase_30();
		TestCase_31();
		TestCase_32();
		TestCase_33();
		TestCase_34();
		TestCase_35();
		TestCase_36();
		TestCase_37();
		TestCase_38();
		TestCase_39();
		TestCase_40();
		TestCase_41();
		TestCase_42();
		TestCase_43();
		TestCase_44();
		TestCase_45();
		TestCase_46();
		TestCase_47();
		TestCase_48();
		TestCase_49();
		TestCase_50();
		TestCase_51();
		TestCase_52();

	}
	
	
	public static void TestCase_25() {
		// Name Validation -- Best Case Scenario -- Good Data
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 25 - Warehouse Name Validation - Best Case Scenario ===============");
		System.out.println("===== Good Data is entered for the Warehouse Name =================================\n");
		String name = "Warehouse One";
		System.out.println("Warehouse Name to be tested: " + name);
		String nameVal = Utility.validateName(name);
		System.out.println("Warehouse Name after Validation: " + nameVal);
		if (name.equals(nameVal)) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("Th test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_26() {
		// Name Validation -- Worst Case Scenario -- Bad Data
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 26 - Warehouse Name Validation - Worst Case Scenario ==============");
		System.out.println("===== Bad Data is entered for the Warehouse Name ==================================\n");
		String name = null;
		System.out.println("Warehouse Name to be tested: " + name);
		String nameVal = Utility.validateName(name);
		System.out.println("Warehouse Name after Validation: " + nameVal);
		if (nameVal.equals("Unknown")) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("Th test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_27() {
		// Name Validation -- Odd Scenario -- Data with no size
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 27 - Warehouse Name Validation - Odd Scenario =====================");
		System.out.println("===== The Data entered for the Warehouse Name is valid but has no size ============\n");
		String name = "";
		System.out.println("Warehouse Name to be tested: |" + name + "|");
		String nameVal = Utility.validateName(name);
		System.out.println("Warehouse Name after Validation: |" + nameVal + "|");
		if (nameVal.equals("Unknown")) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_28() {
		// Name Validation -- Odd Scenario -- Data with white spaces only
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 28 - Warehouse Name Validation - Odd Scenario =====================");
		System.out.println("===== The Data entered for the Warehouse Name only contains white spaces ==========\n");
		String name = "    ";
		System.out.println("Warehouse Name to be tested: |" + name + "|");
		String nameVal = Utility.validateName(name);
		System.out.println("Warehouse Name after Validation: |" + nameVal + "|");
		if (nameVal.equals("Unknown")) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("Th test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_29() {
		// Warehouse Constructor -- Best Case Scenario -- Good Data
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 29 - Warehouse Constructor Test - Best Case Scenario ==============");
		System.out.println("===== Good Data is entered into the Constructor parameter =========================\n");
		String name = "Warehouse Two";
		System.out.println("Warehouse Name to be used: " + name);
		Warehouse test = new Warehouse(name);
		String val = test.toString();
		String expectedResult = "There are no products in the warehouse to display";
		if (val.equals(expectedResult)) {
			System.out.println("Empty Warehouse was created. Warehouse Name: " + test.getName());
			System.out.println("The test was a success");
		}
		else {
			System.out.println("Empty Warehouse wasn't created. Warehouse Name: " + test.getName());
			System.out.println("The test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_30() {
		// Warehouse Constructor -- Worst Case Scenario -- Bad Data
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 30 - Warehouse Constructor Test - Worst Case Scenario =============");
		System.out.println("===== Bad Data is entered into the Constructor paramater ==========================\n");
		String name = null;
		System.out.println("Warehouse Name to be used: " + name);
		Warehouse test = new Warehouse(name);
		String val = test.toString();
		String expectedResult = "There are no products in the warehouse to display";
		if (val.equals(expectedResult)) {
			System.out.println("Empty Warehouse was created. Warehouse Name: " + test.getName());
			System.out.println("The test was a success");
		}
		else {
			System.out.println("Empty Warehouse wasn't created. Warehouse Name: " + test.getName());
			System.out.println("The test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_31() {
		// Warehouse Constructor -- Odd Scenario -- Data containing white Spaces
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 31 - Warehouse Constructor Test - Odd Scenario ====================");
		System.out.println("===== The Data entered into the Constructor paramater contains only white spaces ==\n");
		String name = "    ";
		System.out.println("Warehouse Name to be used: |" + name + "|"); // Lines added to show that the name only contains white spaces
		Warehouse test = new Warehouse(name);
		String val = test.toString();
		String expectedResult = "There are no products in the warehouse to display";
		if (val.equals(expectedResult)) {
			System.out.println("Empty Warehouse was created. Warehouse Name: " + test.getName());
			System.out.println("The test was a success");
		}
		else {
			System.out.println("Empty Warehouse wasn't created. Warehouse Name: " + test.getName());
			System.out.println("The test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_32() {
		// Adding Products Test -- Best Case Scenario -- Product doesn't exist
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 32 - Adding Products Test - Best Case Scenario ====================");
		System.out.println("===== The Product being added to the Warehouse doesn't already exist ==============\n");
		Warehouse test = new Warehouse("Tester");
		String expectedResult = "Ok";
		String actualResult = test.addProduct("Microsoft", "Xbox One", 449.99, Department.COMPUTING);
		Product pro = new Product("Microsoft", "Xbox One", 449.99, Department.COMPUTING);
		System.out.println("Product to be added -- " + pro);
		if (expectedResult.equals(actualResult)) {
			System.out.println("The Product was added successfully. Therefore, the test was a success");
		}
		else {
			System.out.println("The Product wasn't added. Therefore, the test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_33() {
		// Adding Products Test -- Odd Case Scenario -- Product does exist
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 33 - Adding Products Test - Odd Case Scenario =====================");
		System.out.println("===== The Product being added to the Warehouse already exists =====================\n");
		Warehouse test2 = new Warehouse("Tester");
		String notExpectedResult = "Ok";
		
		// First Product
		test2.addProduct("Sony", "Playstation 4", 449.99, Department.COMPUTING);
		Product pro1 = new Product("Sony", "Playstation 4", 449.99, Department.COMPUTING);
		System.out.println("First Product to be added -- " + pro1);
	
		// Second Product
		String actualResult = test2.addProduct("Sony", "Playstation 4", 449.99, Department.COMPUTING);
		Product pro2 = new Product("Sony", "Playstation 4", 449.99, Department.COMPUTING);
		System.out.println("Second Product to be added -- " + pro2);
		if (!notExpectedResult.equals(actualResult)) {
			System.out.println("The duplicate Product was not added. The test was a success");
		}
		else {
			System.out.println("The duplicate Product was added. The test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_34() {
		// Adding Products Test -- Worst Case Scenario -- Product does exist but capitalisation of new data is different
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 34 - Adding Products Test - Worst Case Scenario ===================");
		System.out.println("===== The Product exists but the capitalisation of the new data is different ======\n");
		Warehouse test3 = new Warehouse("Tester");
		String notExpectedResult = "Ok";
		
		// First Product
		test3.addProduct("Microsoft", "Xbox One", 449.99, Department.COMPUTING);
		Product pro1 = new Product("Microsoft", "Xbox One", 449.99, Department.COMPUTING);
		System.out.println("First Product to be added -- " + pro1);
		
		// Second Product
		String actualResult = test3.addProduct("microsoft", "Xbox One", 449.99, Department.COMPUTING);
		Product pro2 = new Product("microsoft", "Xbox One", 449.99, Department.COMPUTING);
		System.out.println("Second Product to be added -- " + pro2);
		if (!notExpectedResult.equals(actualResult)) {
			System.out.println("The duplicate Product was not added. The test was a success");
		}
		else {
			System.out.println("The duplicate Product was added. The test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_35() {
		// Search (Make & Model) Test -- Best Case Scenario -- Product exists & Good Data is entered
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 35 - Search (Make & Model) Test - Best Case Scenario ==============");
		System.out.println("===== Good Data is entered for the search data and the Product exists =============\n");
		Warehouse test4 = new Warehouse("Tester");
		test4.addProduct("Nintendo", "Nintendo Switch", 299.99, Department.COMPUTING);
		System.out.println("Data to be searched -- Make: \"Nintendo\", Model: \"Nintendo Switch\"");
		Product pro = test4.search("Nintendo", "Nintendo Switch");
		System.out.println("Product located in Warehouse -- " +pro);
		if (pro != null) {
			System.out.println("The test was a success, as the correct Product was returned");
		}
		else {
			System.out.println("The test was a failure, as null was returned, meaning the Product doesn't exist which it does");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_36() {
		// Search (Make & Model) Test -- Odd Case Scenario -- Product doesn't exist & Good Data is entered
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 36 - Search (Make & Model) Test - Odd Case Scenario ===============");
		System.out.println("===== Good Data is entered for the search data, but the Product doesn't exist =====\n");
		Warehouse test5 = new Warehouse("Tester");
		test5.addProduct("Nintendo", "Nintendo Switch", 299.99, Department.COMPUTING);
		System.out.println("Data to be searched -- Make: \"Nintendo\", Model: \"Wii U\"");
		Product pro = test5.search("Nintendo", "Wii U");
		System.out.println(pro);
		if (pro == null) {
			System.out.println("The test was a success, as null was returned because the searched Product doesn't exist");
		}
		else {
			System.out.println("The test was a failure, as null wasn't returned, meaning the searched Product exists which it doesn't");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_37() {
		// Search (Make & Model) Test -- Worst Case Scenario -- Product exists, but data entered is valid but bad
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 37 - Search (Make & Model) Test - Worst Case Scenario =============");
		System.out.println("===== Valid but Bad Data is entered for the search data & the Product exists ======\n");
		Warehouse test6 = new Warehouse("Tester");
		test6.addProduct("Nintendo", "Nintendo Switch", 299.99, Department.COMPUTING);
		System.out.println("Data to be searched -- Make: \"nintendo\", Model: \"Nintendo Switch\"");
		Product pro = test6.search("nintendo", "Nintendo Switch"); // The Make value used doesn't have a capital 'N'
		System.out.println(pro);
		if (pro != null) {
			System.out.println("The test was a success, as the correct Product was returned");
		}
		else {
			System.out.println("The test was a failure, as null was returned. This means that the Product doesn't exist even though it does");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_38() {
		// Getting an Array of all the Warehouse Products -- Best Case Scenario -- Warehouse isn't empty
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 38 - getAllProducts Test - Best Case Scenario =====================");
		System.out.println("===== The Warehouse Object Instance isn't null and isn't empty ====================\n");
		Warehouse test7 = new Warehouse("Tester");
		test7.addProduct("Microsoft", "Xbox One", 449.99, Department.COMPUTING);
		test7.addProduct("Sony", "Playstation 4", 449.99, Department.COMPUTING);
		Product[] pros = test7.getAllProducts();
		if (pros.length != 0) {
			System.out.println("The test was a success, as the Array of Product Object Instances has a size gereater than 0, and contain these Products:");
			for (Product pro : pros) {
				System.out.println(pro);
			}
		}
		else {
			System.out.println("The test was a failure, as the Array of Product Object Instances has a size of 0, which it shouldn't");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_39() {
		// Getting an Array of all the Warehouse Products -- Worst Case Scenario - The Warehouse is empty
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 39 - getAllProducts Test - Worst Case Scenario ====================");
		System.out.println("===== The Warehouse Object Instance isn't null but is empty =======================\n");
		Warehouse test8 = new Warehouse("Tester");
		Product[] pros = test8.getAllProducts();
		if (pros == null) {
			System.out.println("The test was a success, as the returned Array is null because there were no Products in the Warehouse");
		}
		else {
			System.out.println("The test was a failure, as the returned Array isn't null when it should be");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_40() {
		// Search (Code) Test -- Best Case Scenario -- Good Data Entered & Product exists
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 40 - Search (Code) Test - Best Case Scenario ======================");
		System.out.println("===== Good Data is entered into the search, but the Product exists ================\n");
		Warehouse test9 = new Warehouse("Tester");
		test9.addProduct("Microsoft", "Xbox Series X", 449.99, Department.COMPUTING);
		Product pro = test9.search("C0016");
		System.out.println("Code Searched: C0016");
		System.out.println("Product Returned: " + pro);
		if (pro != null) {
			System.out.println("The test was a success, as the correct Product was returned and wasn't null");
		}
		else {
			System.out.println("The test was a failure, as the returned value was null, which it shouldn't be");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_41() {
		// Search (Code) Test -- Odd Case Scenario -- valid but bad data is entered & Product exists
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 41 - Search (Code) Test - Odd Case Scenario =======================");
		System.out.println("===== Valid but Bad Data is entered into the search, but the Product exists =======\n");
		Warehouse test10 = new Warehouse("Tester");
		test10.addProduct("Nintendo", "Wii", 189.99, Department.COMPUTING);
		Product pro = test10.search("c0017");
		System.out.println("Code Searched: c0017");
		System.out.println("Product Returned: " + pro);
		if (pro == null) {
			System.out.println("The test was a success, as a null value was returned");
			System.out.println("This means that the Code entered into the search parameter, must be specifc and have the upper case letter at the start");
		}
		else {
			System.out.println("The test was a failure, as a null value wasn't returned but instead a Product Object Instance");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_42() {
		// Search (Code) Test -- Worst Case Scenario -- Bad Data is entered
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 42 - Search (Code) Test - Worst Case Scenario =====================");
		System.out.println("===== Bad Data is entered into the search =========================================\n");
		Warehouse test11 = new Warehouse("Tester");
		test11.addProduct("Sabaton", "Great Tour Vinyl", 29.99, Department.MUSIC);
		Product pro = test11.search((String)null);
		System.out.println("Code Searched: null");
		System.out.println("Product Returned: " + pro);
		if (pro == null) {
			System.out.println("The test was a success, as a null value was returned");
			System.out.println("This means that even if a null value is entered, the method still functions normally");
		}
		else {
			System.out.println("The test was a failure, as a null value wasn't returned, but instead a Product Object Instance");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_43() {
		// Search (Department) Test -- Best Case Scenario -- Good Data is entered & Products exist
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 43 - Search (Department) Test - Best Case Scenario ================");
		System.out.println("===== Good Data is entered into the search, and some Products exist ===============\n");
		Warehouse test12 = new Warehouse("Tester");
		test12.addProduct("Sabaton", "The Last Stand Vinyl", 29.99, Department.MUSIC);
		test12.addProduct("Coldplay", "Rush of Blood to the Head Vinyl", 29.99, Department.MUSIC);
		ArrayList<Product> pros = test12.search(Department.MUSIC);
		System.out.println("Search Data: Department.MUSIC");
		if (pros.size() > 0) {
			System.out.println("The test was a success, as the returned ArrayList didn't have a size of 0");
			System.out.println("It also contains the following Products:");
			for (Product pro : pros) {
				System.out.println(pro);
			}
		}
		else {
			System.out.println("The test was a failure, as the returned ArrayList had a size of 0 when it shouldn't");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_44() {
		// Search (Department) Test -- Worst Case Scenario -- Bad Data is entered
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 44 - Search (Department) Test - Worst Case Scenario ===============");
		System.out.println("===== Bad Data is entered into the search =========================================\n");
		Warehouse test13 = new Warehouse("Tester");
		test13.addProduct("SEGA", "Sega Genesis", 300, Department.OTHER);
		ArrayList<Product> pros = test13.search((Department)null);
		System.out.println("Search Data: null");
		if (pros.size() > 0) {
			System.out.println("The test was a success, as the returned ArrayList had a size greater than 0");
			System.out.println("It also contains the following Products:");
			for (Product pro : pros) {
				System.out.println(pro);
			}
		}
		else {
			System.out.println("The test was a failure, as the returned ArrayList had a size of 0 when it shouldn't");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_45() {
		// Restocking Products Test -- Best Case Scenario -- Good Data entered & Product exists
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 45 - Restocking Products Test - Best Case Scenario ================");
		System.out.println("===== Good Data is entered into the parameters and the Product exists =============\n");
		Warehouse test14 = new Warehouse("Tester");
		test14.addProduct("Gorillaz", "Plastic Beach Vinyl", 29.99, Department.MUSIC);
		Product[] pros = test14.getAllProducts();
		System.out.println("Product Details before restock: " + pros[0]);
		boolean result = test14.restock("M0022", 10);
		System.out.println("Product to be Restocked: M0022");
		System.out.println("Product Details before restock: " + pros[0]);
		if (result == true) {
			System.out.println("The test was a success, as the Quantity of Product was successfully added");
		}
		else {
			System.out.println("The test was a failure, as the Quantity of Product wasn't successfully added");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_46() {
		// Restocking Products Test -- Odd Case Scenario -- Valid but Bad Data entered & Product exists
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 46 - Restocking Products Test - Odd Case Scenario =================");
		System.out.println("===== valid but Bad Data is entered into the parameters and the Product exists ====\n");
		Warehouse test15 = new Warehouse("Tester");
		test15.addProduct("Gorillaz", "Demon Days Vinyl", 29.99, Department.MUSIC);
		Product[] pros = test15.getAllProducts();
		System.out.println("Product Details before restock: " + pros[0]);
		boolean result = test15.restock("m0023", 10);
		System.out.println("Product to be Restocked: m0023");
		System.out.println("Product Details before restock: " + pros[0]);
		if (result == false) {
			System.out.println("The test was a success, as the Quantity of Product wasn't added");
		}
		else {
			System.out.println("The test was a failure, as the Quantity of Product was added");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_47() {
		// Restocking Products Test -- Worst Case Scenario -- Bad Data entered & Product exists
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 47 - Restocking Products Test - Worst Case Scenario ===============");
		System.out.println("===== Bad Data is entered into the parameters and the Product exists ==============\n");
		Warehouse test16 = new Warehouse("Tester");
		test16.addProduct("Gorillaz", "Gorillaz Vinyl", 29.99, Department.MUSIC, 20);
		Product[] pros = test16.getAllProducts();
		System.out.println("Product Details before restock: " + pros[0]);
		boolean result = test16.restock("M0024", -10);
		System.out.println("Product to be Restocked: M0024");
		System.out.println("Product Details before restock: " + pros[0]);
		if (result == false || pros[0].getQuantity() == 20) {
			System.out.println("The test was a success, as the Quantity of Product wasn't added");
		}
		else {
			System.out.println("The test was a failure, as the Quantity of Product was added");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_48() {
		// Deleting Products -- Best Case Scenario -- The Product exists & Good Data entered
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 48 - Deleting Products Test - Best Case Scenario ==================");
		System.out.println("===== Good Data is entered into the parameter and the Product exists ==============\n");
		Warehouse test17 = new Warehouse("Tester");
		test17.addProduct("Jeff Wayne", "War of The Worlds Vinyl", 29.99, Department.MUSIC);
		Product[] pros1 = test17.getAllProducts();
		System.out.println("Product 1 -- " + pros1[0]);
		System.out.println("Product to be Deleted: M0025");
		boolean result = test17.deleteProduct("M0025");
		if (result == true) {
			System.out.println("The test was a success, as the new boolean result was true, meaning the Product was deleted");
		}
		else {
			System.out.println("The test was a failure, as the new boolean result was false, meaning the Product wasn't deleted");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_49() {
		// Deleting Products -- Odd Case Scenario -- Valid but Bad Data is entered, and the Product exists
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 49 - Deleting Products Test - Odd Case Scenario ===================");
		System.out.println("===== Valid but Bad Data is entered into the parameter and the Product exists =====\n");
		Warehouse test18 = new Warehouse("Tester");
		test18.addProduct("Daft Punk", "Discovery Vinyl", 29.99, Department.MUSIC);
		Product[] pros1 = test18.getAllProducts();
		System.out.println("Product 1 -- " + pros1[0]);
		System.out.println("Product to be Deleted: m0026");
		boolean result = test18.deleteProduct("m0026");
		if (result == false) {
			System.out.println("The test was a success, as the boolean result was false, meaning the Product wasn't deleted");
		}
		else {
			System.out.println("The test was a failure, as the boolean result was true, meaning the Product was deleted");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_50() {
		// Deleting Products -- Worst Case Scenario -- Bad Data is entered & a Product exists
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 50 - Deleting Products Test - Worst Case Scenario =================");
		System.out.println("===== Bad Data is entered into the parameter and the Product exists ===============\n");
		Warehouse test19 = new Warehouse("Tester");
		test19.addProduct("Daft Punk", "Homework Vinyl", 29.99, Department.MUSIC);
		Product[] pros1 = test19.getAllProducts();
		System.out.println("Product 1 -- " + pros1[0]);
		System.out.println("Product to be Deleted: null");
		boolean result = test19.deleteProduct(null);
		if (result == false) {
			System.out.println("The test was a success, as the boolean result was false, meaning a Product wasn't deleted");
		}
		else {
			System.out.println("The test was a failure, as the boolean result was true, meaning a Product was deleted");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_51() {
		// toString() Test -- Best Case Scenario -- The Warehouse contains Products
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 51 - Warehouse toString() Test - Best Case Scenario ===============");
		System.out.println("===== The Warehouse Object Instance isn't empty, but contains some Products =======");
		Warehouse test20 = new Warehouse("Tester");
		test20.addProduct("Microsoft", "Xbox Series X", 449.99, Department.COMPUTING);
		test20.addProduct("Sony", "Playstation 5", 449.99, Department.COMPUTING);
		test20.addProduct("JRR Tolkien", "The Hobbit", 9.99, Department.BOOKS);
		test20.addProduct("I Don't Know How But They Found Me", "Razzmatazz vinyl", 29.99, Department.MUSIC);
		System.out.println(test20);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_52() {
		// toString() Test -- Worst Case Scenario -- The Warehouse contains no Products
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 52 - Warehouse toString() Test - Worst Case Scenario ==============");
		System.out.println("===== The Warehouse Object Instance is empty ======================================\n");
		Warehouse test21 = new Warehouse("Tester");
		System.out.println(test21);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
}
