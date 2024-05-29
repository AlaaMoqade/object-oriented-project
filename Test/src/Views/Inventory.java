package Views;

import java.util.ArrayList;



public class Inventory {
	static Inventory inventory = new Inventory("");
	private ArrayList<Item> items = new ArrayList<>();
	private String category;

	private Inventory(String category) {
		this.category = category;
	}

	public static Inventory getInventory() {
		return inventory;
	}

	/**
	 * to add new item in inventory list when it does not exists
	 * 
	 * @param type     // type of item
	 * @param quantity // quantity of item
	 * @param price    // price of item
	 */
	public void newItem(String type, int quantity, double price) {
		int index = findItem(type, true);
		if (index == -1)
			items.add(new Item(type).setQuantity(quantity).setPrice(price));
		else
			System.out.println("cannot add new item!!" + "of" + type);
	}

	/**
	 * to add new item in the inventory list when it does not exists
	 * 
	 * @param brand
	 * @param type
	 * @param quantity
	 * @param price
	 */
	public void newItem(String brand, String type, int quantity, double price) {
		if (findItem(type, true, brand) == -1)
			items.add(new Brand(brand, type).setQuantity(quantity).setPrice(price));
		else
			System.out.println("canot add new brand!!" + "of" + type);
	}

	/**
	 * change the quantity of item when it exists
	 * 
	 * @param type
	 * @param quantity
	 */

	public void setQuantity(String type, int quantity) {
		int index = findItem(type, false);
		if (index != -1) {
			items.get(index).setQuantity(quantity);
		} else {
			System.out.println("item not exists!!" + "of" + type);
		}
	}

	/**
	 * change the quantity of brand when it exists
	 * 
	 * @param brand
	 * @param type
	 * @param quantity
	 */

	public void setQuantity(String brand, String type, int quantity) {
		int index = findItem(type, false, brand);
		if (index != -1)
			items.get(index).setQuantity(quantity);
		else
			System.out.println("item not exists!!" + "of" + type);
	}

	/**
	 * method to change price of item when it exists
	 * 
	 * @param type
	 * @param price
	 */

	public void setPrice(String type, double price) {
		int index = findItem(type, false);
		if (index != -1)
			items.get(index).setPrice(price);
		else
			System.out.println("item not exists!!" + "of" + type);
	}

	/**
	 * method to change price of brand when it exists
	 * 
	 * @param brand
	 * @param type
	 * @param price
	 */

	public void setPrice(String brand, String type, double price) {
		int index = findItem(type, false, brand);
		if (index != -1)
			items.get(index).setPrice(price);
		else
			System.out.println("item not exists!!" + "of" + type);
	}

	/**
	 * method to get quantity value of item when it exists
	 * 
	 * @param type
	 * @return
	 */

	public int getQuantity(String type) {
		int index = findItem(type, false);
		if (index != -1)
			return items.get(index).getQuantity();
		else
			return -1;
	}

	/**
	 * method to get quantity value of brand when it exists
	 * 
	 * @param brand
	 * @param type
	 * @return
	 */

	public int getQuantity(String brand, String type) {
		int index = findItem(type, false, brand);
		if (index != -1)
			return items.get(index).getQuantity();
		else
			return 0;
	}

	/**
	 * method to get price value of item when it exists
	 * 
	 * @param type
	 * @return
	 */

	public double getPrice(String type) {
		int index = findItem(type, false);
		if (index != -1)
			return items.get(index).getPrice();
		else

			return Double.NaN;
	}

	/**
	 * method to get price value of brand when it exists
	 * 
	 * @param brand
	 * @param type
	 * @return
	 */

	public double getPrice(String brand, String type) {
		int index = findItem(type, false, brand);
		if (index != -1)
			return items.get(index).getPrice();
		else
			return Double.NaN;
	}

	/**
	 * //method to update item quantity when quantity increasing
	 * 
	 * @param type
	 * @param qtyIncrease
	 */

	public void update(String type, int qtyIncrease) {
		int index = findItem(type, false);
		if (index != -1)
			items.get(index).update(qtyIncrease);
	}

	/**
	 * // method to update brand quantity when quantity increasing
	 * 
	 * @param brand
	 * @param type
	 * @param qtyIncrease
	 */

	public void update(String brand, String type, int qtyIncrease) {// method to update brand quantity
		int index = findItem(type, false, brand);
		if (index != -1)
			items.get(index).update(qtyIncrease);
	}

	/**
	 * //method to update item price
	 * 
	 * @param type
	 * @param adjustmentFactor
	 */

	public void update(String type, double adjustmentFactor) {
		int index = findItem(type, false);
		if (index != -1)
			items.get(index).update(adjustmentFactor);

	}

	/**
	 * method to update brand price
	 * 
	 * @param brand
	 * @param type
	 * @param adjustmentFactor
	 */

	public void update(String brand, String type, double adjustmentFactor) {
		int index = findItem(type, false, brand);
		if (index != -1)
			items.get(index).update(adjustmentFactor);

	}

	/**
	 * method to find if item when the input type is equal to type in array list.
	 * 
	 * @param type
	 * @param warningIfFound
	 * @return
	 */

	public int findItem(String type, boolean warningIfFound) {
		int index = -1;
		int itemsFound = 0;
		for (int i = 0; i < items.size(); i++) {
			if (type.equals(items.get(i).getType())) {
				index = i;
				itemsFound++;
			}
		}

		if (itemsFound == 0 && !warningIfFound) {
			System.out.println("cannot find" + " " + type);
		} else if (itemsFound != 0 && warningIfFound) {
			System.out.println(type + " " + "already exists");
		}

		if (itemsFound == 1)
			return index;
		else
			return -1;
	}

	/**
	 * method to find if brand when the input brand is equal to brand in array list.
	 * 
	 * @param type
	 * @param warningIfFound
	 * @param brand
	 * @return
	 */

	public int findItem(String type, boolean warningIfFound, String brand) {
		int index = -1;
		int itemsFound = 0;
		for (int i = 0; i < items.size(); i++) {
			if (type.equals(items.get(i).getType()) && items.get(i) instanceof Brand
					&& brand.equals(((Brand) items.get(i)).getBrand())) {
				index = i;
				itemsFound++;
			}
		}

		if (itemsFound == 0 && !warningIfFound) {
			System.out.println("cannot find" + " " + type);
		} else if (itemsFound != 0 && warningIfFound) {
			System.out.println(type + " " + " already exists");
		} else {
			System.out.println("find more one brand of " + brand + " " + type);
		}

		if (itemsFound == 1)
			return index;
		else
			return -1;
	}

	/**
	 * method to print stock report and total value of stock price
	 */

	public String stockReport() {

		double total1 = 0;
		double total2 = 0;
		for (int i = 0; i < items.size(); i++) {
			if (items.get(i) instanceof Brand) {
				System.out.println(((Brand) items.get(i)).getBrand() + " " + (items.get(i).getType()) + " - in stock: "
						+ items.get(i).getQuantity() + ",price : $" + items.get(i).getPrice());
				total1 = total1 + items.get(i).getPrice();
			} else if (items.get(i) instanceof Item) {
				System.out.println(items.get(i).getType() + " "
						+ ("- in stock :" + items.get(i).getQuantity() + ",price : $" + items.get(i).getPrice()));
				total2 = total2 + items.get(i).getPrice();
			}
		}

		double totalValue = total1 + total2;
		System.out.println("Total value : $" + totalValue);
		return "";
	}

	public void deleteItem(int itemIndex) {
		this.items.remove(itemIndex);
	}
	
	public Item getItem(int itemIndex){
		return items.get(itemIndex);
	}

}
