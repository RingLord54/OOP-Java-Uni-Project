package part03;

import java.util.ArrayList;
import console.Console;
import part01.Product;

/**
 * The purpose of this class is to provide extra functionality to the part03 classes
 * and application only, without taking up space within their code itself. These extra 
 * functions involve converting data or sorting data.
 * 
 * @author Andrew Moneypenny
 *
 */

public class UtilityDetail {
	
	/**
	 * This method is designed to add the contents of an ArrayList of type Product
	 * to an ArrayList of type ProductDetail
	 * 
	 * @param data - The ArrayList of type Product
	 * @return temp - The ArrayList of type ProductDetail
	 */
	public static ArrayList<ProductDetail> convertToProductDetail(ArrayList<Product> data){
		ArrayList<ProductDetail> temp = new ArrayList<ProductDetail>();
		for (Product pro : data) {
			temp.add((ProductDetail) pro);
		}
		return temp;
		
	}
	
	
	
	/**
	 * This method is designed to order all of the Product object instances within
	 * the Warehouse object instance in decreasing amount of purchases. This is done
	 * using a simple Insert Algorithm. This is specially designed to work with the Console
	 * class
	 * 
	 * @param value - the value to be inserted into the Array
	 * @param data - The Array containing the soon to be sorted data
	 * @param count - The position of the data
	 */
	public static void InsertSort(Product value, Product[] data, int count, Console console) {
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
		console.println("Sorry, there was no array to sort");
	}

}
