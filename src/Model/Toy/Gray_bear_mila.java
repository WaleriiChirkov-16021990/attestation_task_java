package Model.Toy;

import Abstract.Toy;

public class Gray_bear_mila extends Toy {
	
	public Gray_bear_mila(String name, int popularity, int size, String material) {
		super(name, popularity, size, material);
	}
	
	public Gray_bear_mila() {
		super();
		this.setName("Gray_bear_mila");
		this.setPopularity(10);
		this.setSize(7);
	}
}
