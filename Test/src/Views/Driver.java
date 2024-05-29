package Views;



public class Driver {

	public static void main(String[] args) {
		Inventory inventory = Inventory.getInventory();
		inventory.newItem("bread", 15, 9.99);
		inventory.newItem("al-jebrini", "milk", 2, 2.00);
		inventory.newItem("eggs", 3, 1.50);
		inventory.newItem("bread", 2, 1.25); // warning: in stock
		inventory.stockReport();
		inventory.update("al-jebrini", "milk", .25); // raise price 25%
		inventory.update("eggs", -1); // lower quantity by 1
		inventory.update("juice", 3); // warning: not stocked
		inventory.newItem("juneidi", "milk", 4, 1.95);
		inventory.stockReport();
		inventory.setPrice("cola", 10); // warning: not stocked
		inventory.setQuantity("al-jebrini", "milk", 3);
		inventory.setPrice("eggs", 2.00);
		System.out.println("milk quantity: " + inventory.getQuantity("alsafi",
		"milk")); // not stocked
		System.out.println("milk quantity: " + inventory.getQuantity("milk"));// ambiguity
		System.out.println("eggs price: " + inventory.getPrice("eggs"));
		System.out.println("milk price: " + inventory.getPrice("milk")); //ambiguity
		System.out.println((new Item("cola").setPrice(5)).compareTo(new
		Item("milk").setPrice(8)));

	}
}
