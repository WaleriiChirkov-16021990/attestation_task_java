package Abstract;

import File_writer.Writer;
import Model.Toy.Big_boss_red_cat;
import Model.Toy.Gray_bear_mila;
import Model.Toy.Losk_black_snake;
import Model.Toy.Yellow_iron_giraffe;
import Present.Printer_txt;
import UI.Input_gamer;

import java.util.*;

public abstract class Toy_store<T extends Toy> {
	
	private ArrayList<HashMap<T,ArrayList<Integer>>> info_store; // ArrayList<Integer> = [price,quantity,chance_drop]
	private LinkedList<Toy> big_boss_red_cat;
	private LinkedList<Toy> gray_bear_mila;
	private LinkedList<Toy> losk_black_snake;
	private LinkedList<Toy> yellow_iron_giraffe;
	private LinkedList<Toy> other;
	
	
	public Toy_store(ArrayList<HashMap<T, ArrayList<Integer>>> db_store) {
		this();
		this.info_store = db_store;
	}
	
	public Toy_store() {
		this.big_boss_red_cat = new LinkedList<>();
		this.gray_bear_mila = new LinkedList<>();
		this.losk_black_snake = new LinkedList<>();
		this.yellow_iron_giraffe = new LinkedList<>();
	}
	
	public void add_toy(Toy rt) {
		boolean news = true;
		if(rt instanceof Big_boss_red_cat){
			this.getBig_boss_red_cat().add(rt);
			if (this.getInfo_store().size() > 0) {
				for (HashMap<T, ArrayList<Integer>> VR:
				     this.getInfo_store()) {
					if (VR.keySet().contains(rt)) {
						VR.get(rt).set(1,this.getBig_boss_red_cat().size());
						news = false;
					}
				}
				if (news) {
					this.add_new_toys(rt);
				}
			}
		} else if (rt instanceof Gray_bear_mila) {
			this.getGray_bear_mila().add(rt);
			if (this.getInfo_store().size() > 0) {
				for (HashMap<T, ArrayList<Integer>> VR:
						this.getInfo_store()) {
					if (VR.keySet().contains(rt)) {
						VR.get(rt).set(1,this.getGray_bear_mila().size());
						news = false;
					}
				}
				if (news) {
					this.add_new_toys(rt);
				}
			}
		} else if (rt instanceof Losk_black_snake) {
			this.getLosk_black_snake().add(rt);
			if (this.getInfo_store().size() > 0) {
				for (HashMap<T, ArrayList<Integer>> VR:
						this.getInfo_store()) {
					if (VR.keySet().contains(rt)) {
						VR.get(rt).set(1,this.getLosk_black_snake().size());
						news = false;
					}
				}
				if (news) {
					this.add_new_toys(rt);
				}
			}
		} else if (rt instanceof Yellow_iron_giraffe) {
			this.getYellow_iron_giraffe().add(rt);
			if (this.getInfo_store().size() > 0) {
				for (HashMap<T, ArrayList<Integer>> VR:
						this.getInfo_store()) {
					if (VR.keySet().contains(rt)) {
						VR.get(rt).set(1,this.getYellow_iron_giraffe().size());
						news = false;
					}
				}
				if (news) {
					this.add_new_toys(rt);
				}
			}
		} else {
			this.getOther().add(rt);
			if (this.getInfo_store().size() > 0) {
				for (HashMap<T, ArrayList<Integer>> VR:
						this.getInfo_store()) {
					if (VR.keySet().contains(rt)) {
						VR.get(rt).set(1,this.getOther().size());
						news = false;
					}
				}
				if (news) {
					this.add_new_toys(rt);
				}
			}
		}
	}
	
	
//
//	public void add_mila(Gray_bear_mila rt) {
//		this.gray_bear_mila.add(rt);
//	}
//
//	public void add_snake(Losk_black_snake rt) {
//		this.losk_black_snake.add(rt);
//	}
//
//
//	public void add_giraffe(Yellow_iron_giraffe rt) {
//		this.yellow_ipon_giraffe.add(rt);
//	}
	
	
	public void drop_toy(Toy rt){
		if(rt instanceof Big_boss_red_cat){
			if (this.getBig_boss_red_cat().size() > 0) {
				new Writer<Toy>(this.getBig_boss_red_cat().removeFirst()).write_toy_drop();
			}
		} else if (rt instanceof Gray_bear_mila) {
			if (this.getGray_bear_mila().size() > 0) {
				new Writer<Toy>(this.getGray_bear_mila().removeFirst()).write_toy_drop();
			}
		} else if (rt instanceof Losk_black_snake) {
			if (this.getLosk_black_snake().size() > 0) {
				new Writer<Toy>(this.getLosk_black_snake().removeFirst()).write_toy_drop();
			}
		} else if (rt instanceof Yellow_iron_giraffe) {
			if (this.getYellow_iron_giraffe().size() > 0){
				new Writer<Toy>(this.getYellow_iron_giraffe().removeFirst()).write_toy_drop();
			}
		} else {
			if (this.getOther().size() > 0){
				new Writer<Toy>(this.getOther().removeFirst()).write_toy_drop();
			}
		}
	}
	public ArrayList<HashMap<T, ArrayList<Integer>>> getInfo_store() {
		return info_store;
	}
	
	public void setInfo_store(ArrayList<HashMap<T, ArrayList<Integer>>> info_store) {
		this.info_store = info_store;
	}
	
	
	public HashMap search_toy(Toy toy){
		HashMap toy1 = null;
		for (HashMap e:
		     this.getInfo_store()) {
			if (e.keySet().contains(toy)){
				toy1 = e;
				break;
			}
		}
		return toy1;
	}
	
	public void add_new_toys(Toy toy){
		ArrayList<Integer> temp = new ArrayList<>();
		Input_gamer input_gamer = new Input_gamer();
		new Printer_txt("Введите новую цену для этих игрушек").print();
		int price = input_gamer.getScanner().nextInt();
		temp.add(0,price);
//		new Printer_txt("Введите оставшееся количество игрушек").print();
//		int quantity = input_gamer.getScanner().nextInt();
		temp.add(1,1);
		new Printer_txt("Введите новую вероятность выпадения этих игрушек (1-100)").print();
		int chance = input_gamer.getScanner().nextInt();
		temp.add(1,chance);
		HashMap<T,ArrayList<Integer>> D_temp = new HashMap<T, ArrayList<Integer>>();
		D_temp.put((T) toy,temp);
		this.getInfo_store().add(0,D_temp);
	}
	public void edit_toy_price(Toy toy){
		HashMap<Toy,ArrayList<Integer>> search = search_toy(toy);
		if(search != null){
			Input_gamer input_gamer = new Input_gamer();
			new Printer_txt("Введите новую цену для этих игрушек").print();
			int price = input_gamer.getScanner().nextInt();
			search.get(toy).set(0, price);
		} else {
			new Printer_txt("Такой позиции нет!").print();
		}
	}
	public void edit_toy_quantity(Toy toy){
		HashMap<Toy,ArrayList<Integer>> search = search_toy(toy);
		if(search != null){
			Input_gamer input_gamer = new Input_gamer();
			new Printer_txt("Введите оставшееся количество игрушек").print();
			int quantity = input_gamer.getScanner().nextInt();
			search.get(toy).set(1, quantity);
		} else {
			new Printer_txt("Такой позиции нет!").print();
		}
	}
	public void edit_toy_chance(Toy toy){
		HashMap<Toy,ArrayList<Integer>> search = search_toy(toy);
		if(search != null){
			Input_gamer input_gamer = new Input_gamer();
			new Printer_txt("Введите новую вероятность выпадения этих игрушек").print();
			int chance = input_gamer.getScanner().nextInt();
			search.get(toy).set(2, chance);
		} else {
			new Printer_txt("Такой позиции нет!").print();
		}
	}
	
	
	public abstract int drawing_of_toys(); // реализуем в каждом магазине магазине
	public abstract void generate_chance_drop(Toy toy, int min, int max); // и это
	
	public LinkedList<Toy> getBig_boss_red_cat() {
		return big_boss_red_cat;
	}
	
	public void setBig_boss_red_cat(LinkedList<Toy> big_boss_red_cat) {
		this.big_boss_red_cat = big_boss_red_cat;
	}
	
	public LinkedList<Toy> getGray_bear_mila() {
		return gray_bear_mila;
	}
	
	public void setGray_bear_mila(LinkedList<Toy> gray_bear_mila) {
		this.gray_bear_mila = gray_bear_mila;
	}
	
	public LinkedList<Toy> getLosk_black_snake() {
		return losk_black_snake;
	}
	
	public void setLosk_black_snake(LinkedList<Toy> losk_black_snake) {
		this.losk_black_snake = losk_black_snake;
	}
	
	public LinkedList<Toy> getYellow_iron_giraffe() {
		return yellow_iron_giraffe;
	}
	
	public void setYellow_iron_giraffe(LinkedList<Toy> yellow_iron_giraffe) {
		this.yellow_iron_giraffe = yellow_iron_giraffe;
	}
	
	public LinkedList<Toy> getOther() {
		return other;
	}
	
	public void setOther(LinkedList<Toy> other) {
		this.other = other;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Toy_store<?> toy_store)) return false;
		return Objects.equals(getInfo_store(), toy_store.getInfo_store()) && Objects.equals(getBig_boss_red_cat(), toy_store.getBig_boss_red_cat()) && Objects.equals(getGray_bear_mila(), toy_store.getGray_bear_mila()) && Objects.equals(getLosk_black_snake(), toy_store.getLosk_black_snake()) && Objects.equals(getYellow_iron_giraffe(), toy_store.getYellow_iron_giraffe()) && Objects.equals(getOther(), toy_store.getOther());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getInfo_store(), getBig_boss_red_cat(), getGray_bear_mila(), getLosk_black_snake(), getYellow_iron_giraffe(), getOther());
	}
	
	@Override
	public String toString() {
		return "Toy_store{" +
				"info_store=" + info_store +
				", big_boss_red_cat=" + big_boss_red_cat +
				", gray_bear_mila=" + gray_bear_mila +
				", losk_black_snake=" + losk_black_snake +
				", yellow_iron_giraffe=" + yellow_iron_giraffe +
				", other=" + other +
				'}';
	}
}
