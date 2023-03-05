package Model.Toy;

import Abstract.Toy;

public class Yellow_iron_giraffe extends Toy {
	
	public Yellow_iron_giraffe() {
		super();
		this.setName("Yellow_iron_giraffe");
	}
	
	public Yellow_iron_giraffe(String name, int popularity, int size, int price, String material) {
		super(name, popularity, size, price, material);
	}
}
