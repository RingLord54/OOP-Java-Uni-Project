package part01;

import java.util.Scanner;

/**
 * The purpose of this class is to provide extra functionality to the other classes
 * and application, in part01, without taking up space within the classes themselves.
 * These extra functions can be things like validating data or sorting data.
 * 
 * @author Andrew Moneypenny
 *
 */

public class Utility {
	
	private static Scanner input = new Scanner(System.in);
	
	
	
	/**
	 * This method is designed to validate the data entered for the Product make,
	 * this is to ensure that the data entered isn't null and is suitable for 
	 * object creation. Also, if there are errors, then a default value will be 
	 * assigned.
	 * 
	 * @param make - the Product manufacturer
	 * @return makeVal - the Product manufacturer (validated)
	 */
	public static String validateMake(String make) {
		String makeVal = "";
		if (make != null && make.length() != 0) {
			make = make.trim(); 
			// Will check to make sure the value isn't just white spaces
			if (make.length() != 0) {
				makeVal = make;
				makeVal = makeVal.trim(); // Will remove leading and trailing white spaces
			}
			else {
				makeVal = "Unknown";
			}
		}
		else {
			makeVal = "Unknown"; // default value assigned if make == null
		}
		return makeVal;
	}
	
	
	
	/**
	 * This method is designed to validate the data entered for the Product model,
	 * this is to ensure that the data entered isn't null and is suitable for
	 * object creation. Also, if there are errors, then a default value will be
	 * assigned.
	 * 
	 * @param model - the Product model
	 * @return modelVal - the Product model (validated)
	 */
	public static String validateModel(String model) {
		String modelVal = "";
		if (model != null && model.length() != 0) {
			model = model.trim();
			if (model.length() != 0) {
				modelVal = model;
				modelVal = modelVal.trim(); // Will remove leading and trailing white spaces
			}
			else {
				modelVal = "Unknown";
			}
		}
		else {
			modelVal = "Unknown"; // default value assigned if make == null
		}
		return modelVal;
	}
	
	
	
	/**
	 * This method is designed to validate data entered for the Product price,
	 * this is to ensure that the data entered isn't a negative number and also
	 * doesn't equal zero, making it suitable for object creation. However, if 
	 * there is a problem with the data, then it will be assigned a default value
	 * 
	 * @param price - the Product price in £
	 * @return priceVal - the Product price in £ (validated)
	 */
	public static double validatePrice(double price) {
		double priceVal = 0.0;
		if (price >= 0) {
			priceVal = price;
		}
		return priceVal;
	}
	
	
	
	/**
	 * This method is designed to validate data entered for the Product quantity,
	 * this is to ensure that the data entered isn't a negative number and also
	 * doesn't equal zero, making it suitable for object creation. However, if 
	 * there is a problem with the data, then it will be assigned a default value
	 * 
	 * @param quantity - defines amount of a Product available
	 * @return quantityVal - defines amount of a Product available (validated)
	 */
	public static int validateQuantity(int quantity) {
		int quantityVal = 0;
		if (quantity >= 0) {
			quantityVal = quantity;
		}
		return quantityVal;
	}
	
	
	
	/**
	 * This method is designed to validate data entered for the Product Department,
	 * this is to ensure that the data entered isn't null and so is suitable for
	 * object creation. However, if the data entered is null, then the returned data
	 * will be a default value
	 * 
	 * @param dept - associated Product department
	 * @return deptVal - associated Product department (validated)
	 */
	public static Department validateDepartment(Department dept) {
		Department deptVal = Department.OTHER;
		if (dept != null) {
			deptVal = dept;
			return deptVal;
		}
		return deptVal;
	}
	
	
	
	/**
	 * This method is designed to validate data entered for the Warehouse Owner,
	 * this is to ensure that the data entered isn't null and is suitable for
	 * object creation. However, if the data is null, then it will be assigned
	 * a default value
	 * 
	 * @param name - The Warehouse Owner
	 * @return nameVal - The Warehouse Owner (validated)
	 */
	public static String validateName(String name) {
		String nameVal = "";
		if (name != null && name.length() != 0) {
			name = name.trim();
			if (name.length() != 0) {
				nameVal = name;
				nameVal = nameVal.trim();
			}
			else {
				nameVal = "Unknown";
			}
		}
		else {
			nameVal = "Unknown";
		}
		return nameVal;
	}
	
	
	
	/**
	 * This method is designed to return the correct Department enum value based
	 * on the String value entered. If the String value entered isn't one of the main
	 * Department types, then it'll be assigned the value of "Other"
	 * 
	 * @param dept - associated Product department
	 * @return department - the correct associated Product department
	 */
	public static Department getDepartmentType(String dept) {
		Department department = null;
		switch(dept) {
		case "electrical":
		case "Electrical": department = Department.ELECTRICAL; break;
		case "photographic":
		case "Photographic": department = Department.PHOTOGRAPHIC; break;
		case "computing":
		case "Computing": department = Department.COMPUTING; break;
		case "books":
		case "Books": department = Department.BOOKS; break;
		case "music":
		case "Music": department = Department.MUSIC; break;
		case "fashion":
		case "Fashion": department = Department.FASHION; break;
		case "other":
		case "Other": department = Department.OTHER; break;
		default: department = Department.OTHER; break;
		}
		return department;
	}
	
	
	
	/**
	 * This method is designed to allow the user to make a selection and then
	 * have that selection be validated to ensure it is an integer, and if it is
	 * it's then returned. The purpose of this is that it allows this validation to
	 * occur without having to clutter up other methods with this code and also
	 * means that other menu classes don't have to be created unnecessarily.
	 * 
	 * @return value - the selection made by the User
	 */
	public static int validateValue() {
		int value;
		do {
			try {
				System.out.print("Enter Selection (Enter \"0\" to Exit): ");
				value = input.nextInt();
				break;
			}
			catch(Exception ex) {
				System.out.println("Invalid menu option - try again!");
				input.nextLine();
			}
		} while (true);
		return value;
	}
	
	
	
	/**
	 * This method is designed to order all of the Product object instances within
	 * the Warehouse object instance in decreasing amount of purchases. This is done
	 * using a simple Insert Algorithm
	 * 
	 * @param value - the value to be inserted into the Array
	 * @param data - The Array containing the soon to be sorted data
	 * @param count - The position of the data
	 */
	public static void InsertSort(Product value, Product[] data, int count) {
		if (data != null) {
			if (count != data.length) {
				if (count == 0) {
					data[0] = value;
					return;
				}
				
				int index, position;
				for (index = 0; index < count; index++) {
					if (data[index].getPurchases() < value.getPurchases()) {
						break;
					}
				}
				position = index;
				
				for (index = count; index > position; index--) {
					data[index] = data[index-1];
				}
				data[position] = value;
			}
			return;
		}
		System.out.println("Sorry, there was no array to sort");
	}

}
