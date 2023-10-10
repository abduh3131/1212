
public class Product {


	private String name;
	private double price;
	private int UPC;

	Product (int code, String name, double price) {
		this.UPC=code;
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUPC() {
		return UPC;
	}

	public void setUPC(int uPC) {
		UPC = uPC;
	}
}
