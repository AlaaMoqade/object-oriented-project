package Views;


public class Brand extends Item {
	// brand name of item
	private String name;

	// call item object
	public Brand() {
		super();
		name = "no brand yet";
	}
	/**
	 * to call item object
	 * 
	 * @param brand
	 * @param type
	 */
	public Brand(String brand, String type) {
		super(type);
		this.name = brand;
	}

	/* to bring the brand for each product. */
	public String getBrand() {
		return name;
	}

}