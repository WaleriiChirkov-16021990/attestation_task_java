package Abstract;

import File_writer.Writer;
import Model.Gamer;
import Model.Toy.Big_boss_red_cat;
import Model.Toy.Gray_bear_mila;
import Model.Toy.Losk_black_snake;
import Model.Toy.Yellow_iron_giraffe;
import Present.Printer_txt;
import UI.Input_gamer;

import java.util.*;

/**
 * абстракция магазина для данной задачи
 * @param <T> ограничение наследниками класса Toy
 */
public abstract class Toy_store<T extends Toy> {
	
	private ArrayList<Integer> info_store_cat; // ArrayList<Integer> = [price,quantity,chance_drop]
	private ArrayList<Integer> info_store_mila; // ArrayList<Integer> = [price,quantity,chance_drop]
	private ArrayList<Integer> info_store_snake; // ArrayList<Integer> = [price,quantity,chance_drop]
	private ArrayList<Integer> info_store_giraffe; // ArrayList<Integer> = [price,quantity,chance_drop]
	private LinkedList<T> big_boss_red_cat;
	private LinkedList<T> gray_bear_mila;
	private LinkedList<T> losk_black_snake;
	private LinkedList<T> yellow_iron_giraffe;
	private LinkedList<T> other;
	
	
	public Toy_store() {
		this.info_store_cat = new ArrayList<>(Arrays.asList(0,0,0));
		this.info_store_mila = new ArrayList<>(Arrays.asList(0,0,0));
		this.info_store_snake = new ArrayList<>(Arrays.asList(0,0,0));
		this.info_store_giraffe = new ArrayList<>(Arrays.asList(0,0,0));
		this.big_boss_red_cat = new LinkedList<>();
		this.gray_bear_mila = new LinkedList<>();
		this.losk_black_snake = new LinkedList<>();
		this.yellow_iron_giraffe = new LinkedList<>();
		this.other = new LinkedList<>();
	}
	
	public void add_toy(T rt) {
//		boolean news = true;
		if(rt instanceof Big_boss_red_cat){
			this.getBig_boss_red_cat().add(rt);
			this.info_store_cat.set(1,this.getBig_boss_red_cat().size());
		} else if (rt instanceof Gray_bear_mila) {
			this.getGray_bear_mila().add(rt);
			this.info_store_mila.set(1,this.getGray_bear_mila().size());
		} else if (rt instanceof Losk_black_snake) {
			this.getLosk_black_snake().add(rt);
			this.info_store_snake.set(1, this.getLosk_black_snake().size());
		} else if (rt instanceof Yellow_iron_giraffe) {
			this.getYellow_iron_giraffe().add(rt);
			this.info_store_giraffe.set(1, this.getYellow_iron_giraffe().size());
		} else {
			this.getOther().add(rt);
		}
	}
	
	
	public void drop_toy(T rt){
		if(rt instanceof Big_boss_red_cat){
			if (this.getBig_boss_red_cat().size() > 0) {
				new Writer<Toy>(rt).write_toy_drop();
			}
		} else if (rt instanceof Gray_bear_mila) {
			if (this.getGray_bear_mila().size() > 0) {
				new Writer<Toy>(rt).write_toy_drop();
			}
		} else if (rt instanceof Losk_black_snake) {
			if (this.getLosk_black_snake().size() > 0) {
				new Writer<Toy>(rt).write_toy_drop();
//				this.getLosk_black_snake().removeFirst()
			}
		} else if (rt instanceof Yellow_iron_giraffe) {
			if (this.getYellow_iron_giraffe().size() > 0){
				new Writer<Toy>(rt).write_toy_drop();
			}
		} else {
			if (this.getOther().size() > 0){
				new Writer<Toy>(rt).write_toy_drop();
			}
		}
	}
	
	
	public ArrayList<Integer> search_toy_info(T toy){
		ArrayList<Integer> toy1 = new ArrayList<>();
		if (toy instanceof Big_boss_red_cat){
			toy1 = this.info_store_cat;
		} else if (toy instanceof Gray_bear_mila){
			toy1 = this.info_store_mila;
		} else if(toy instanceof Losk_black_snake){
			toy1 = this.info_store_snake;
		} else if (toy instanceof Yellow_iron_giraffe){
			toy1 = this.info_store_giraffe;
		}
		return toy1;
	}
	
	public void edit_toy_price(T toy){
		ArrayList<Integer> search = search_toy_info(toy);
		if(search != null){
			Input_gamer input_gamer = new Input_gamer();
			int price = 0;
			while (true){
				new Printer_txt("Введите новую цену для игрушек: " + toy.getName()).print();
				input_gamer.get_input("(введите целую цифру)");
				if (input_gamer.is_number()){
					price = Integer.parseInt(input_gamer.getInput());
					break;
				} else {
					new Printer_txt("Вы ввели неизвестную неизвестную цену =) ").print();
				}
			}
			search.set(0, price);
		} else {
			new Printer_txt("Такой позиции нет!").print();
		}
	}
	public void edit_toy_quantity(T toy){
		ArrayList<Integer> search = search_toy_info(toy);
		if(search != null){
			Input_gamer input_gamer = new Input_gamer();
			int quantity = 0;
			while (true){
				new Printer_txt("Введите оставшееся количество игрушек: " + toy.getName()).print();
				input_gamer.get_input("(введите целую цифру)");
				if (input_gamer.is_number()) {
					quantity = Integer.parseInt(input_gamer.getInput());
					break;
				}
				else {
					new Printer_txt("Вы ввели неизвестное количество =) ").print();
				}
			}
			search.set(1, quantity);
		} else {
			new Printer_txt("Такой позиции нет!").print();
		}
	}
	public void edit_toy_chance(T toy){
		ArrayList<Integer> search = search_toy_info(toy);
		if(search != null) {
			Input_gamer input_gamer = new Input_gamer();
			int chance = 0;
			while (true){
				new Printer_txt("Введите новую вероятность выпадения этих игрушек: " + toy.getName()).print();
				input_gamer.get_input("(введите целую цифру)");
				if (input_gamer.is_number_less_than_100()) {
					chance = Integer.parseInt(input_gamer.getInput());
					break;
				} else {
					new Printer_txt("Вы ввели неизвестную вероятность =) ").print();
				}
			}
			search.set(2, chance);
		} else {
			new Printer_txt("Такой позиции нет!").print();
		}
	}
	
	
	public abstract LinkedList<T> drawing_of_toys(Gamer<T> gamer, int bet, int user_step); // реализуем в каждом магазине магазине
	public abstract ArrayList<Integer> generate_chance_drop(Gamer<T> gamer, Toy toy, int bet); // и это
	
	public LinkedList<T> getBig_boss_red_cat() {
		return big_boss_red_cat;
	}
	
	public void setBig_boss_red_cat(LinkedList<T> big_boss_red_cat) {
		this.big_boss_red_cat = big_boss_red_cat;
	}
	
	public LinkedList<T> getGray_bear_mila() {
		return gray_bear_mila;
	}
	
	public void setGray_bear_mila(LinkedList<T> gray_bear_mila) {
		this.gray_bear_mila = gray_bear_mila;
	}
	
	public LinkedList<T> getLosk_black_snake() {
		return losk_black_snake;
	}
	
	public void setLosk_black_snake(LinkedList<T> losk_black_snake) {
		this.losk_black_snake = losk_black_snake;
	}
	
	public LinkedList<T> getYellow_iron_giraffe() {
		return yellow_iron_giraffe;
	}
	
	public void setYellow_iron_giraffe(LinkedList<T> yellow_iron_giraffe) {
		this.yellow_iron_giraffe = yellow_iron_giraffe;
	}
	
	public LinkedList<T> getOther() {
		return other;
	}
	
	public void setOther(LinkedList<T> other) {
		this.other = other;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Toy_store<?> toy_store)) return false;
		return Objects.equals(getInfo_store_cat(), toy_store.getInfo_store_cat()) && Objects.equals(getInfo_store_mila(), toy_store.getInfo_store_mila()) && Objects.equals(getInfo_store_snake(), toy_store.getInfo_store_snake()) && Objects.equals(getInfo_store_giraffe(), toy_store.getInfo_store_giraffe()) && Objects.equals(getBig_boss_red_cat(), toy_store.getBig_boss_red_cat()) && Objects.equals(getGray_bear_mila(), toy_store.getGray_bear_mila()) && Objects.equals(getLosk_black_snake(), toy_store.getLosk_black_snake()) && Objects.equals(getYellow_iron_giraffe(), toy_store.getYellow_iron_giraffe()) && Objects.equals(getOther(), toy_store.getOther());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getInfo_store_cat(), getInfo_store_mila(), getInfo_store_snake(), getInfo_store_giraffe(), getBig_boss_red_cat(), getGray_bear_mila(), getLosk_black_snake(), getYellow_iron_giraffe(), getOther());
	}
	
	@Override
	public String toString() {
		return "Toy_store{" +
				"info_store_cat=" + info_store_cat +
				", info_store_mila=" + info_store_mila +
				", info_store_snake=" + info_store_snake +
				", info_store_giraffe=" + info_store_giraffe +
				", big_boss_red_cat=" + big_boss_red_cat +
				", gray_bear_mila=" + gray_bear_mila +
				", losk_black_snake=" + losk_black_snake +
				", yellow_iron_giraffe=" + yellow_iron_giraffe +
				", other=" + other +
				'}';
	}
	
	public ArrayList<Integer> getInfo_store_cat() {
		return info_store_cat;
	}
	
	public void setInfo_store_cat(ArrayList<Integer> info_store_cat) {
		this.info_store_cat = info_store_cat;
	}
	
	public ArrayList<Integer> getInfo_store_mila() {
		return info_store_mila;
	}
	
	public void setInfo_store_mila(ArrayList<Integer> info_store_mila) {
		this.info_store_mila = info_store_mila;
	}
	
	public ArrayList<Integer> getInfo_store_snake() {
		return info_store_snake;
	}
	
	public void setInfo_store_snake(ArrayList<Integer> info_store_snake) {
		this.info_store_snake = info_store_snake;
	}
	
	public ArrayList<Integer> getInfo_store_giraffe() {
		return info_store_giraffe;
	}
	
	public void setInfo_store_giraffe(ArrayList<Integer> info_store_giraffe) {
		this.info_store_giraffe = info_store_giraffe;
	}
}
