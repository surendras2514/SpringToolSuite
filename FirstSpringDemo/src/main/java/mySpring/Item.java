package mySpring;

public class Item {
	private String itemName;
	private double price;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", price=" + price + "]";
	}

}
