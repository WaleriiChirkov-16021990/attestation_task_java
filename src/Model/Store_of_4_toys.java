package Model;

import Abstract.Toy;
import Abstract.Toy_store;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashSet;
import java.util.Random;

public class Store_of_4_toys<T extends Toy_store<Toy>> extends Toy_store {
	
	private HashSet<Integer> chance_drop;
	private Store_of_4_toys(ArrayList<Dictionary<T, ArrayList<Integer>>> db_store) {
		super(db_store);
	}
	
	public Store_of_4_toys() {
		super();
	}
	@Override
	public void generate_chance_drop(Toy toy, int min, int max){
		Dictionary<Toy,ArrayList<Integer>> now = (Dictionary<Toy, ArrayList<Integer>>) this.getInfo_store().get(0);
		int n = now.get(toy).get(2);
		this.chance_drop = new HashSet<Integer>();
		Random rnd = new Random();
		int m = 0;
		while(n > 0){
			m = rnd.nextInt(min,max+1);
			if(!this.chance_drop.contains(m)) {
				this.chance_drop.add(m);
				n -= 1;
			}
		}
	}
	
	@Override
	public int drawing_of_toys() {
		return 0;
	}
	
	public HashSet<Integer> getChance_drop() {
		return chance_drop;
	}
	
	public void setChance_drop(HashSet<Integer> chance_drop) {
		this.chance_drop = chance_drop;
	}
	
	
}
