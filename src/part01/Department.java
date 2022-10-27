package part01;

/**
 * This enum contains all of the values for the different Departments that'
 * a Product object can belong to.
 * 
 * @author Andrew Moneypenny
 *
 */

public enum Department {
	
	ELECTRICAL("Electrical"),
	PHOTOGRAPHIC("Photographic"),
	COMPUTING("Computing"),
	BOOKS("Books"),
	MUSIC("Music"),
	FASHION("Fashion"),
	OTHER("Other");
	
	private String department;
	
	
	/**
	 * This method is designed to act as a constructor for Department values
	 * 
	 * @param data - the Department value
	 */
	private Department(String data) {
		this.department = data;
	}
	
	
	/**
	 * This method is designed to return the String value of the Department
	 * 
	 * @return department - Returns the String value associated with the Department value
	 */
	public String getDepartment() {
		return this.department;
	}
	
	
	/**
	 * This method is designed to allow quick access to the getDepartment() method
	 * 
	 * @return getDepartment()
	 */
	public String toString() {
		return getDepartment();
	}

}
