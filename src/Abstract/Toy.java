package Abstract;

import java.util.Objects;

public abstract class Toy extends Toy_store<Toy> {
	private static int ID = 0;
	private int ID_toy;
	private String name;
	private int popularity;
	private int size;
	private int price;
	
	
	public Toy(String name, int popularity, int size, int price) {
		this.ID_toy = this.ID + 1;
		this.name = name;
		this.popularity = popularity;
		this.size = size;
		this.price = price;
		this.ID += 1;
	}
	
	public Toy() {
		this.ID_toy = this.ID + 1;
		this.ID += 1;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPopularity() {
		return popularity;
	}
	
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getID_toy() {
		return ID_toy;
	}
	
	public void setID_toy(int ID_toy) {
		this.ID_toy = ID_toy;
	}
	
	@Override
	public String toString() {
		return "Toy{" +
				"name='" + name + '\'' +
				", popularity=" + popularity +
				", size=" + size +
				", price=" + price +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Toy toy)) return false;
		return getPopularity() == toy.getPopularity() && getSize() == toy.getSize() && getPrice() == toy.getPrice() && Objects.equals(getName(), toy.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), getPopularity(), getSize(), getPrice());
	}
}
