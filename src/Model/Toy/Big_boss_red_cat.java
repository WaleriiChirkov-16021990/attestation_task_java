package Model.Toy;

import Abstract.Toy;

public class Big_boss_red_cat extends Toy {

	
	
	
	public Big_boss_red_cat(String name, int popularity, int size, String material) {
		super(name, popularity, size, material);
	}
	
	public Big_boss_red_cat() {
		super();
		this.setName("Big_boss_red_cat");
		this.setPopularity(6);
		this.setSize(5);
	}
}
