package Abstract;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Objects;

public abstract class Toy_store<T extends Toy> {
	
//	private ArrayList<Dictionary<T,Dictionary<Integer,Integer>>> db_store;
	private String name_toy_1;
	private String name_toy_2;
	private String name_toy_3;
	private String name_toy_4;
	private int price_toy_1;
	private int price_toy_2;
	private int price_toy_3;
	private int price_toy_4;
	private int quantity_toy_1;
	private int quantity_toy_2;
	private int quantity_toy_3;
	private int quantity_toy_4;
	
	public Toy_store(String name_toy_1, String name_toy_2, String name_toy_3, String name_toy_4, int price_toy_1, int price_toy_2, int price_toy_3, int price_toy_4, int quantity_toy_1, int quantity_toy_2, int quantity_toy_3, int quantity_toy_4) {
		this.name_toy_1 = name_toy_1;
		this.name_toy_2 = name_toy_2;
		this.name_toy_3 = name_toy_3;
		this.name_toy_4 = name_toy_4;
		this.price_toy_1 = price_toy_1;
		this.price_toy_2 = price_toy_2;
		this.price_toy_3 = price_toy_3;
		this.price_toy_4 = price_toy_4;
		this.quantity_toy_1 = quantity_toy_1;
		this.quantity_toy_2 = quantity_toy_2;
		this.quantity_toy_3 = quantity_toy_3;
		this.quantity_toy_4 = quantity_toy_4;
//		this.db_store = new ArrayList<>();
	}
	
	public Toy_store() {
	}
	
	@Override
	public String toString() {
		return "Toy_store{" +
				"name_toy_1='" + name_toy_1 + '\'' +
				", name_toy_2='" + name_toy_2 + '\'' +
				", name_toy_3='" + name_toy_3 + '\'' +
				", name_toy_4='" + name_toy_4 + '\'' +
				", price_toy_1=" + price_toy_1 +
				", price_toy_2=" + price_toy_2 +
				", price_toy_3=" + price_toy_3 +
				", price_toy_4=" + price_toy_4 +
				", quantity_toy_1=" + quantity_toy_1 +
				", quantity_toy_2=" + quantity_toy_2 +
				", quantity_toy_3=" + quantity_toy_3 +
				", quantity_toy_4=" + quantity_toy_4 +
				'}';
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Toy_store toy_store)) return false;
		return price_toy_1 == toy_store.price_toy_1 && price_toy_2 == toy_store.price_toy_2 && price_toy_3 == toy_store.price_toy_3 && price_toy_4 == toy_store.price_toy_4 && quantity_toy_1 == toy_store.quantity_toy_1 && quantity_toy_2 == toy_store.quantity_toy_2 && quantity_toy_3 == toy_store.quantity_toy_3 && quantity_toy_4 == toy_store.quantity_toy_4 && Objects.equals(name_toy_1, toy_store.name_toy_1) && Objects.equals(name_toy_2, toy_store.name_toy_2) && Objects.equals(name_toy_3, toy_store.name_toy_3) && Objects.equals(name_toy_4, toy_store.name_toy_4);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name_toy_1, name_toy_2, name_toy_3, name_toy_4, price_toy_1, price_toy_2, price_toy_3, price_toy_4, quantity_toy_1, quantity_toy_2, quantity_toy_3, quantity_toy_4);
	}
	
	public String getName_toy_1() {
		return name_toy_1;
	}
	
	public void setName_toy_1(String name_toy_1) {
		this.name_toy_1 = name_toy_1;
	}
	
	public String getName_toy_2() {
		return name_toy_2;
	}
	
	public void setName_toy_2(String name_toy_2) {
		this.name_toy_2 = name_toy_2;
	}
	
	public String getName_toy_3() {
		return name_toy_3;
	}
	
	public void setName_toy_3(String name_toy_3) {
		this.name_toy_3 = name_toy_3;
	}
	
	public String getName_toy_4() {
		return name_toy_4;
	}
	
	public void setName_toy_4(String name_toy_4) {
		this.name_toy_4 = name_toy_4;
	}
	
	public int getPrice_toy_1() {
		return price_toy_1;
	}
	
	public void setPrice_toy_1(int price_toy_1) {
		this.price_toy_1 = price_toy_1;
	}
	
	public int getPrice_toy_2() {
		return price_toy_2;
	}
	
	public void setPrice_toy_2(int price_toy_2) {
		this.price_toy_2 = price_toy_2;
	}
	
	public int getPrice_toy_3() {
		return price_toy_3;
	}
	
	public void setPrice_toy_3(int price_toy_3) {
		this.price_toy_3 = price_toy_3;
	}
	
	public int getPrice_toy_4() {
		return price_toy_4;
	}
	
	public void setPrice_toy_4(int price_toy_4) {
		this.price_toy_4 = price_toy_4;
	}
	
	public int getQuantity_toy_1() {
		return quantity_toy_1;
	}
	
	public void setQuantity_toy_1(int quantity_toy_1) {
		this.quantity_toy_1 = quantity_toy_1;
	}
	
	public int getQuantity_toy_2() {
		return quantity_toy_2;
	}
	
	public void setQuantity_toy_2(int quantity_toy_2) {
		this.quantity_toy_2 = quantity_toy_2;
	}
	
	public int getQuantity_toy_3() {
		return quantity_toy_3;
	}
	
	public void setQuantity_toy_3(int quantity_toy_3) {
		this.quantity_toy_3 = quantity_toy_3;
	}
	
	public int getQuantity_toy_4() {
		return quantity_toy_4;
	}
	
	public void setQuantity_toy_4(int quantity_toy_4) {
		this.quantity_toy_4 = quantity_toy_4;
	}
	
	public abstract int drawing_of_toys();
}
