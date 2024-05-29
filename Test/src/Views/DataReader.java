package Views;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataReader {//to read from file and storage  in inventory
	
	public static void readData() {
		File filename = new File("inventoryDatabase.txt");
		Inventory inventory = Inventory.getInventory();

		if (filename.exists()) {
			try {
				Scanner input = new Scanner(filename);
				while (input.hasNext()) {
					String line = input.nextLine();
					String[] part = line.split(",");// to split the line for 3 or 4 part.
					if (part.length == 3) {
						String Type = part[0].trim();
						int quantity = Integer.parseInt(part[1].trim());
						double price = Double.parseDouble(part[2].trim());
						inventory.newItem(Type, quantity, price);// store new item in inventory
					} else if (part.length == 4) {
						String brand = part[0].trim();
						String type = part[1].trim();
						int quantity = Integer.parseInt(part[2].trim());
						double price = Double.parseDouble(part[3].trim());
						inventory.newItem(brand, type, quantity, price);// store new item  with brand in inventory
					}
					break;
				}

			} catch (FileNotFoundException e) {
				System.out.println(e);
			}
		}

		// how to open a file
		// read data from file
		// store the data in the inventory
		/**
		 * name, 123, 232,
		 * 
		 * read line by line data[] = line.split(","); if(item.length == 3){
		 * newItem(data[0],data[1], data[2]); }
		 * 
		 * 
		 */
	}
}