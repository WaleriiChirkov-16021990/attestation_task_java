package Model;

import Abstract.Toy;
import Abstract.Toy_store;
import Model.Toy.Big_boss_red_cat;
import Model.Toy.Gray_bear_mila;
import Model.Toy.Losk_black_snake;
import Model.Toy.Yellow_iron_giraffe;

import java.util.*;

public class Store_of_4_toys<T extends Toy> extends Toy_store {
	
	private HashSet<Integer> chance_drop;
	
	public Store_of_4_toys() {
		super();
	}
	
	@Override
	public int drawing_of_toys() {
		return 0;
	}
	
	public void generate_toy(){
		Big_boss_red_cat cat1 = new Big_boss_red_cat();
		Big_boss_red_cat cat2 = new Big_boss_red_cat();
		Big_boss_red_cat cat3 = new Big_boss_red_cat();
		Gray_bear_mila mila1 = new Gray_bear_mila();
		Gray_bear_mila mila2 = new Gray_bear_mila();
		Gray_bear_mila mila3 = new Gray_bear_mila();
		Losk_black_snake snake1 = new Losk_black_snake();
		Losk_black_snake snake2 = new Losk_black_snake();
		Losk_black_snake snake3 = new Losk_black_snake();
		Losk_black_snake snake4 = new Losk_black_snake();
		Losk_black_snake snake5 = new Losk_black_snake();
		Yellow_iron_giraffe giraffe1 = new Yellow_iron_giraffe();
		Yellow_iron_giraffe giraffe2 = new Yellow_iron_giraffe();
		this.add_toy(cat1);
		this.edit_toy_price(cat1);
		this.edit_toy_quantity(cat2);
		this.edit_toy_chance(cat1);
		this.add_toy(cat2);
		this.add_toy(cat3);
		this.add_toy(mila1);
		this.edit_toy_price(mila1);
		this.edit_toy_quantity(mila2);
		this.edit_toy_chance(mila3);
		this.add_toy(mila2);
		this.add_toy(mila3);
		this.add_toy(snake1);
		this.edit_toy_price(snake1);
		this.edit_toy_quantity(snake2);
		this.edit_toy_chance(snake5);
		this.add_toy(snake2);
		this.add_toy(snake3);
		this.add_toy(snake4);
		this.add_toy(snake5);
		this.add_toy(giraffe1);
		this.edit_toy_price(giraffe1);
		this.edit_toy_quantity(giraffe1);
		this.edit_toy_chance(giraffe2);
		this.add_toy(giraffe2);
	}
	
	@Override
	public void generate_chance_drop(Toy toy, int min, int max) {
	
	}
	
	public HashSet<Integer> getChance_drop() {
		return chance_drop;
	}
	
	public void setChance_drop(HashSet<Integer> chance_drop) {
		this.chance_drop = chance_drop;
	}
	
	
}
