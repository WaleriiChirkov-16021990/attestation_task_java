package Model;

import Abstract.Toy;
import Abstract.Toy_store;

public class Store_of_4_toys<T extends Toy_store<Toy>> extends Toy_store {
	
	
	public Store_of_4_toys(String name_toy_1, String name_toy_2, String name_toy_3, String name_toy_4, int price_toy_1, int price_toy_2, int price_toy_3, int price_toy_4, int quantity_toy_1, int quantity_toy_2, int quantity_toy_3, int quantity_toy_4) {
		super(name_toy_1, name_toy_2, name_toy_3, name_toy_4, price_toy_1, price_toy_2, price_toy_3, price_toy_4, quantity_toy_1, quantity_toy_2, quantity_toy_3, quantity_toy_4);
	}
	
	public Store_of_4_toys() {
		super();
	}
	
	@Override
	public int drawing_of_toys() {
		return 0;
	}
}
