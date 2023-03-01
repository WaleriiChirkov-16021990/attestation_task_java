package Abstract;

import java.util.Objects;

public abstract class Toy {
	private String name;
	private int popularity;
	private int size;
	private int price;
	private String material;
	
	
	public Toy(String name, int popularity, int size, int price, String material) {
		this.name = name;
		this.popularity = popularity;
		this.size = size;
		this.price = price;
		this.material = material;
	}
	
	public Toy() {
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
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	@Override
	public String toString() {
		return "Toy{" +
				"name='" + name + '\'' +
				", popularity=" + popularity +
				", size=" + size +
				", price=" + price +
				", material='" + material + '\'' +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Toy toy)) return false;
		return getPopularity() == toy.getPopularity() && getSize() == toy.getSize() && getPrice() == toy.getPrice() && Objects.equals(getName(), toy.getName()) && Objects.equals(getMaterial(), toy.getMaterial());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), getPopularity(), getSize(), getPrice(), getMaterial());
	}
}
