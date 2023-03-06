package Model.Toy;

import Abstract.Toy;

public class Yellow_iron_giraffe extends Toy {
	
	public Yellow_iron_giraffe() {
		super();
		this.setName("Yellow_iron_giraffe");
		this.setPopularity(8);
		this.setSize(10);
	}
	
	public Yellow_iron_giraffe(String name, int popularity, int size) {
		super(name, popularity, size);
	}
}
