package part02;

import part01.Department;
import part01.Product;
import part01.Utility;

/**
 * This application is to be used to perform unit testing on the
 * Product class in order to ensure its functionality works across 
 * a broad spectrum of potential input data.
 * 
 * @author Andrew Moneypenny
 *
 */

public class ProductTesting {

	public static void main(String[] args) {
		
		TestCase_1();
		TestCase_2();
		TestCase_3();
		TestCase_4();
		TestCase_5();
		TestCase_6();
		TestCase_7();
		TestCase_8();
		TestCase_9();
		TestCase_10();
		TestCase_11();
		TestCase_12();
		TestCase_13();
		TestCase_14();
		TestCase_15();
		TestCase_16();
		TestCase_17();
		TestCase_18();
		TestCase_19();
		TestCase_20();
		TestCase_21();
		TestCase_22();
		TestCase_23();
		TestCase_24();
		
	}

	
	public static void TestCase_1() {
		// Make Validation -- Best Case Scenario -- Good Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 1 - Product Make Validation - Best Case Scenario =================");
		System.out.println("===== Good Data is entered for the Product Manufacturer ==========================\n");
		String make = "Microsoft";
		System.out.println("Manufacturer Name to be tested: " + make);
		String makeVal = Utility.validateMake(make);
		System.out.println("Manufacturer Name after Validation: " + makeVal);
		if (make.equals(makeVal)) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_2() {
		// Make Validation -- Worst Case Scenario -- Bad Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 2 - Product Make Validation - Worst Case Scenario ================");
		System.out.println("===== The data entered for the Product Manufacturer is null ======================\n");
		String make = null;
		System.out.println("Manufacturer Name to be tested: " + make);
		String makeVal = Utility.validateMake(make);
		System.out.println("Manufacturer Name after Validation: " + makeVal);
		if (makeVal.equals("Unknown")) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_3() {
		// Make Validation -- Odd Scenario -- Data with no size
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 3 - Product Make Validation - Odd Scenario =======================");
		System.out.println("===== The data entered for the Product Manufacturer isn't null but has no size ===\n");
		String make = "";
		System.out.println("Manufacturer Name to be tested: |" + make + "|");  // Lines added either side to show its size is 0.
		String makeVal = Utility.validateMake(make);
		System.out.println("Manufacturer Name after Validation: |" + makeVal + "|");
		if (makeVal.equals("Unknown")) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_4() {
		// Make Validation -- Odd Scenario -- Data with white spaces only
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 4 - Product Make Validation - Odd Scenario =======================");
		System.out.println("===== The data entered for the Product Manufacturer is just White Space ==========\n");
		String make = "     ";
		System.out.println("Manufacturer Name to be tested: |" + make + "|");  // Lines added either side to show the white spaces.
		String makeVal = Utility.validateMake(make);
		System.out.println("Manufacturer Name after Validation: |" + makeVal + "|");
		if (makeVal.equals("Unknown")) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_5() {
		// Model Validation -- Best Case Scenario -- Good Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 5 - Product Model Validation - Best Case Scenario ========");
		System.out.println("===== Good Data is entered for the Product Model =========================\n");
		String model = "Xbox One";
		System.out.println("Model Name to be tested: " + model);
		String modelVal = Utility.validateModel(model);
		System.out.println("Model Name after Validation: " + modelVal);
		if (model.equals(modelVal)) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_6() {
		// Model Validation -- Worst Case Scenario -- Bad Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 6 - Product Model Validation - Worst Case Scenario =======");
		System.out.println("===== The Data entered for the Product Model is null =====================\n");
		String model = null;
		System.out.println("Model Name to be tested: " + model);
		String modelVal = Utility.validateModel(model);
		System.out.println("Model Name after Validation: " + modelVal);
		if (modelVal.equals("Unknown")) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_7() {
		// Model Validation -- Odd Scenario -- Data with no size
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 7 - Product Model Validation - Odd Scenario ==============");
		System.out.println("===== The Data entered for the Product Model isn't null but has 0 size ===\n");
		String model = "";
		System.out.println("Model Name to be tested: |" + model + "|"); // Lines added either side to show its size is 0.
		String modelVal = Utility.validateModel(model);
		System.out.println("Model Name after Validation: |" + modelVal + "|");
		if (modelVal.equals("Unknown")) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_8() {
		// Model Validation -- Odd Scenario -- Data with white spaces only
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 8 - Product Model Validation - Odd Scenario ==============");
		System.out.println("===== The Data entered for the Product Model is just white space =========\n");
		String model = "    ";
		System.out.println("Model Name to be tested: |" + model + "|"); // Lines added either side to show its size is 0.
		String modelVal = Utility.validateModel(model);
		System.out.println("Model Name after Validation: |" + modelVal + "|");
		if (modelVal.equals("Unknown")) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_9() {
		// Price Validation -- Best Case Scenario -- Good Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 9 - Product Price Validation - Best Case Scenario ========");
		System.out.println("===== Good Data is entered for the Product Price =========================\n");
		double price = 1.00;
		System.out.println("Price value to be tested: " + String.format("£%.2f", price));
		double priceVal = Utility.validatePrice(price);
		System.out.println("Price value after Validation: " + String.format("£%.2f", priceVal));
		if (price == priceVal) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_10() {
		// Price Validation -- Worst Case Scenario -- Bad Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 10 - Product Price Validation - Worst Case Scenario ======");
		System.out.println("===== The value entered for the Product Price is negative ================\n");
		double price = -1.00;
		System.out.println("Price value to be tested: " + String.format("£%.2f", price));
		double priceVal = Utility.validatePrice(price);
		System.out.println("Price value after Validation: " + String.format("£%.2f", priceVal));
		if (priceVal == 0) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_11() {
		// Price Validation -- Odd Scenario -- Price equals 0
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 11 - Product Price Validation - Odd Scenario =============");
		System.out.println("===== The value entered for the Product Price is 0 =======================\n");
		double price = 0;
		System.out.println("Price value to be tested: " + String.format("£%.2f", price));
		double priceVal = Utility.validatePrice(price);
		System.out.println("Price value after Validation: " + String.format("£%.2f", priceVal));
		if (priceVal == 0) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_12() {
		// Quantity Validation -- Best Case Scenario -- Good Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 12 - Product Quantity Validation - Best Case Scenario ====");
		System.out.println("===== Good Data is entered for the Product's Quantity ====================\n");
		int quantity = 1;
		System.out.println("Quantity value to be tested: " + quantity);
		int quantityVal = Utility.validateQuantity(quantity);
		System.out.println("Quantity value after validation: " + quantityVal);
		if (quantity == quantityVal) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_13() {
		// Quantity Validation -- Worst Case Scenario -- Bad Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 13 - Product Quantity Validation - Worst Case Scenario ===");
		System.out.println("===== The value entered for the Product Quantity is negative =============\n");
		int quantity = -1;
		System.out.println("Quantity value to be tested: " + quantity);
		int quantityVal = Utility.validateQuantity(quantity);
		System.out.println("Quantity value after validation: " + quantityVal);
		if (quantityVal == 0) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_14() {
		// Quantity Validation -- Odd Scenario -- Quantity equals 0
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 14 - Product Quantity Validation - Odd Scenario ==========");
		System.out.println("===== The value entered for the Product Quantity is 0 ====================\n");
		int quantity = 0;
		System.out.println("Quantity value to be tested: " + quantity);
		int quantityVal = Utility.validateQuantity(quantity);
		System.out.println("Quantity value after validation: " + quantityVal);
		if (quantityVal == 0) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_15() {
		// Product Constructor Test -- Best Case Scenario -- Good Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 15 - Product Constructor Testing - Best Case Scenario ====");
		System.out.println("===== Good Data is entered into all the parameters for the Constructor ===\n");
		String make = "Microsoft";
		System.out.println("Make value to be tested in constructor: " + make);
		String model = "Xbox One";
		System.out.println("Model value to be tested in constructor: " + model);
		double price = 449.99;
		System.out.println("Price value to be tested in constructor: " + price);
		Department dept = Department.COMPUTING;
		System.out.println("Department value to be tested in constructor: " + dept);
		Product test = new Product(make, model, price, dept);
		System.out.println("The Created Product's Details:");
		System.out.println("------------------------------");
		System.out.println(test);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}

	public static void TestCase_16() {
		// Product Constructor Test -- Odd Scenario -- Data is valid but isn't great
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 16 - Product Constructor Testing - Odd Scenario ================");
		System.out.println("===== The Data values entered into the parameters aren't great but are valid ===\n");
		String make = "";
		System.out.println("Make value to be tested in constructor: |" + make + "|"); // Lines added on either side to show its size is 0
		String model = "     ";
		System.out.println("Model value to be tested in constructor: |" + model + "|"); // Lines added on either side to show the white spaces
		double price = 0;
		System.out.println("Price value to be tested in constructor: " + price);
		Department dept = Department.OTHER;
		System.out.println("Department value to be tested in constructor: " + dept);
		Product test = new Product(make, model, price, dept);
		System.out.println("The Created Product's Details:");
		System.out.println("------------------------------");
		System.out.println(test);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_17() {
		// Product Constructor Test -- Worst Case Scenario -- Bad Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 17 - Product Constructor Testing - Worst Case Scenario ===");
		System.out.println("===== The Data values entered into the parameters are bad ================\n");
		String make = null;
		System.out.println("Make value to be tested in constructor: " + make);
		String model = null;
		System.out.println("Model value to be tested in constructor: " + model);
		double price = -100;
		System.out.println("Price value to be tested in constructor: " + price);
		Department dept = null;
		System.out.println("Department value to be tested in constructor: " + dept);
		Product test = new Product(make, model, price, dept);
		System.out.println("The Created Product's Details:");
		System.out.println("------------------------------");
		System.out.println(test);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_18() {
		// Department Validation -- Best Case Scenario -- Good Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 18 - Product Department Validation - Best Case Scenario ==");
		System.out.println("===== A non-null value is entered for the Product Department =============\n");
		Department dept = Department.COMPUTING;
		System.out.println("Department value to be tested: " + dept);
		Department deptVal = Utility.validateDepartment(dept);
		System.out.println("Department value after Validation: " + deptVal);
		if (dept.equals(deptVal)) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_19() {
		// Department Validation -- Worst Case Scenario -- Bad Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 19 - Product Department Validation - Worst Case Scenario =");
		System.out.println("===== A null value is entered for the Product Department =================\n");
		Department dept = null;
		System.out.println("Department value to be tested: " + dept);
		Department deptVal = Utility.validateDepartment(dept);
		System.out.println("Department value after Validation: " + deptVal);
		if (deptVal.equals(Department.OTHER)) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_20() {
		// Adding Quantity Test -- Best Case Scenario -- Good Data
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 20 - Adding Quantity to existing Products - Best Case Scenario =====");
		System.out.println("===== Good Data is entered for the amount of Quantity to be added to the Product ===\n");
		Product test = new Product("Microsoft", "Xbox One", 449.99, Department.COMPUTING, 0);
		System.out.println("The Quantity before any is added: " + test.getQuantity());
		int quantity = 1;
		System.out.println("The Quantity to be added: " + quantity);
		test.addToQuantity(quantity);
		System.out.println("The Quantity after the amount is added: " + test.getQuantity());
		if (test.getQuantity() > 0) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_21() {
		// Adding Quantity Test -- Odd Scenario -- Amount to be added is 0
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 21 - Adding Quantity to existing Products - Odd Scenario ===");
		System.out.println("===== The amount of quantity to be added to the Product is 0 ===============\n");
		Product test = new Product("Microsoft", "Xbox One", 449.99, Department.COMPUTING, 10);
		System.out.println("The Quantity before any is added: " + test.getQuantity());
		int quantity = 0;
		System.out.println("The Quantity to be added: " + quantity);
		test.addToQuantity(quantity);
		System.out.println("The Quantity after the amount is added: " + test.getQuantity());
		if (test.getQuantity() == 10) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_22() {
		// Adding Quantity Test -- Worst Case Scenario -- Bad Data
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 22 - Adding Quantity to existing Products - Worst Case Scenario ===");
		System.out.println("===== The amount of quantity to be added to the Product is negative ===============\n");
		Product test = new Product("Microsoft", "Xbox One", 449.99, Department.COMPUTING, 10);
		System.out.println("The Quantity before any is added: " + test.getQuantity());
		int quantity = -25;
		System.out.println("The Quantity to be added: " + quantity);
		test.addToQuantity(quantity);
		System.out.println("The Quantity after the amount is added: " + test.getQuantity());
		if (test.getQuantity() == 10) {
			System.out.println("The test was a success");
		}
		else {
			System.out.println("The test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_23() {
		// Recording Purchases Test -- Best Case Scenario -- There's enough quantity available for a purchase
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 23 - Recording Purchases for Products - Best Case Scenario ========");
		System.out.println("===== There's enough Quantity of the Product to allow for a Purchase ==============\n");
		Product test = new Product("Microsoft", "Xbox One", 449.99, Department.COMPUTING, 1);
		System.out.println("The Product's details before the Purchase:\n" + test);
		boolean expectedResult = true;
		boolean isPurchased = test.recordPurchase();
		System.out.println("The Product's details after the Purchase:\n" + test);
		if (expectedResult == isPurchased) {
			System.out.println("The purchase was made, so the test was a success");
		}
		else {
			System.out.println("The Purchase wasn't made, so the test was a failure");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
	}
	
	public static void TestCase_24() {
		// Recording Purchases Test -- Worst Case Scenario -- There's no Product to purchase
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("===== Test Case 24 - Recording Purchases for Products - Worst Case Scenario =======");
		System.out.println("===== The Quantity of the Product is 0 and so shouldn't allow a Purchase ==========\n");
		Product test = new Product("Microsoft", "Xbox One", 449.99, Department.COMPUTING, 0);
		System.out.println("The Product's details before the Purchase:\n" + test);
		boolean expectedResult = false;
		boolean isPurchased = test.recordPurchase();
		System.out.println("The Product's details after the Purchase:\n" + test);
		if (expectedResult == isPurchased) {
			System.out.println("The test was a success, as no purchase was made.");
		}
		else {
			System.out.println("The test was a failure, as a Purchase was made.");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n\n\n");
		
	}
}
