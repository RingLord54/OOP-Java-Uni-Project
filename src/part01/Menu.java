package part01;

import java.util.Scanner;

/**
 * An object class to describe a simple text-based Menu
 * 
 * @author Andrew Moneypenny
 *
 */

public class Menu {
	private String title;
	private String[] items;
	private Scanner input;

	
	/**
	 * This method is designed to be the constructor class for the Menu,
	 * taking in a String value for title and an Array for the list of options
	 * it will then create a basic text-based menu instance off of these.
	 * 
	 * @param title - The title for the text-based Menu
	 * @param options - The list of options to be displayed to the User
	 */
	public Menu(String title, String[] options) {
		this.title = title;
		this.items = options;
		input = new Scanner(System.in);
	}

	
	/**
	 * This method is designed to present the Menu in a more user-friendly
	 * manner. It does this by printing the title, followed by the options
	 * displayed in a list format
	 */
	private void display() {
		System.out.println(title);
		for (int i = 0; i < title.length(); i++) {
			System.out.print("+");
		}
		System.out.println();
		for (int opt = 1; opt <= items.length; opt++) {
			System.out.println(opt + ". " + items[opt - 1]);
		}
		System.out.println();
	}

	
	/**
	 * This method is designed to return the number value of the Menu selection
	 * made by the User, making sure that it's also a number and not any other 
	 * data-type.
	 * 
	 * @return value - The Menu selection made by the user
	 */
	public int getUserChoice() {
		int value = 0;
		display();
		do {
			try {
				System.out.print("Enter Selection: ");
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

}
