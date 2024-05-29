package Views;

import java.util.List;
import java.util.Locale.Category;



public class Item  implements Comparable<Item> {
	private String type;// type of item
	private int quantity;// quantity of item
	private double price;// price of item
	

	public Item() {
		type = "no type yet";
	}

	public Item(String type) {
		this.type = type;
	}
	

	/**
	 * method to return set quantity type of item.
	 * 
	 * @param quantity
	 * @return
	 */
	public Item setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * method to return set price type of item.
	 * 
	 * @param price
	 * @return
	 */

	public Item setPrice(double price) {
		this.price = price;
		return this;
	}

	/**
	 * method to get type of item
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * method to get quantity of item
	 * 
	 * @return
	 */

	public int getQuantity() {
		return quantity;
	}

	/**
	 * method to get price of item
	 * 
	 * @return
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * method to return update qtyIncrease kind of item
	 * 
	 * @param qtyIncrease
	 * @return
	 */

	public Item update(int qtyIncrease) {
		this.quantity += qtyIncrease;
		return this;
	}

	/**
	 * method to return update adjustmentFactor kind of item
	 * 
	 * @param adjustmentFactor
	 * @return
	 */

	public Item update(double adjustmentFactor) {
		adjustmentFactor =this.price  * (1 + adjustmentFactor);
		return this;
	}
	/**
	 * method to find the value of tow price
	 */
	@Override
	public int compareTo(Item o) {
		if (this.price > o.price) {
			return (int) (price - o.price);
		}
		return (int) (price - o.price);
	}
}

