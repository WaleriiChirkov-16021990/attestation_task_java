package Model.Toy;

import Abstract.Toy;

public class Losk_black_snake extends Toy {
	
	public Losk_black_snake(String name, int popularity, int size, String material) {
		super(name, popularity, size, material);
	}
	
	public Losk_black_snake() {
		super();
		this.setName("Losk_black_snake");
		this.setPopularity(4);
		this.setSize(9);
	}
	
}
