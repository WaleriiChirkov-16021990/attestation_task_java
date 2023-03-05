package Model.Toy;

import Abstract.Toy;

public class Gray_bear_mila extends Toy {
	
	public Gray_bear_mila(String name, int popularity, int size, int price, String material) {
		super(name, popularity, size, price, material);
	}
	
	public Gray_bear_mila() {
		super();
		this.setName("Gray_bear_mila");
	}
}
