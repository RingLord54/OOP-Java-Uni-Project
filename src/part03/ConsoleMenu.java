package part03;

import console.Console;
import java.awt.Font;
import java.awt.Color;

/**
 * An object class to describe a simple text-based Menu, 
 * using the Console Class.
 * 
 * @author Andrew Moneypenny
 * 
 */

public class ConsoleMenu extends Console {

	private String title;
	private String items[];
	private static Console con;
	
	
	/**
	 * This method is designed to be the constructor class for the ConsoleMenu,
	 * taking in a String value for title and an Array for the list of options
	 * it will then create a basic text-based menu instance off of these while
	 * also utilising the Console Class from which it extends.
	 * 
	 * @param title - The title for the text-based Menu
	 * @param items - The list of options to be displayed to the User
	 */
	public ConsoleMenu(String title, String[] items) {
		super(true);
		con = new Console(true);
		this.title = title;
		this.items = items;
		con.setSize(1000, 1000);                          // Sets the width and height of the console window to 1000
		con.setVisible(true);                             // Allows the Console window to be visible
		con.setFont(new Font("Courier", Font.BOLD, 18));  // Sets the font family of all the text to Courier, makes it bold and gives it a size of 18pt
		con.setColour(Color.GREEN);                       // Sets the text colour to green
		con.setBgColour(Color.BLACK);                     // Sets the Console background colour to black
	}

	
	/**
	 * This method is designed to present the Menu in a more user-friendly
	 * manner. It does this by printing the title, followed by the options
	 * displayed in a list format
	 */
	private void display() {
		con.println(title);
		for (int i = 0; i < title.length(); i++) {
			con.print("+");
		}
		con.println();
		for (int opt = 1; opt <= items.length; opt++) {
			con.println(opt + ". " + items[opt - 1]);
		}
		con.println();
	}
	
	
	/**
	 * This method is designed to return the number value of the Menu selection
	 * made by the User, making sure that it's also a number and not any other 
	 * data-type.
	 * 
	 * @return value - The Menu selection made by the user
	 */
	public int getUserChoice() {
		String temp = "0";
		display();
		do {
			con.print("Enter Selection: ");
			temp = con.readLn();
		} while (Integer.parseInt(temp) > items.length && Integer.parseInt(temp) < 0);
		int value = Integer.parseInt(temp);
		return value;
	}
	
	
	/**
	 * Will allow the WarehouseApp to utilise the same Console Object
	 * Instance outside of the menu class
	 * 
	 * @return con - The Console Object Instance
	 */
	public Console getConsole() {
		return this.con;
	}
	
}