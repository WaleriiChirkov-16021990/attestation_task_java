package Model;

import Abstract.Toy;
import Abstract.Toy_store;
import Model.Toy.Big_boss_red_cat;
import Model.Toy.Gray_bear_mila;
import Model.Toy.Losk_black_snake;
import Model.Toy.Yellow_iron_giraffe;
import Present.Printer_txt;
import UI.Txt_interface;

import java.util.*;

public class Store_of_4_toys<T extends Toy> extends Toy_store {
	
	private HashSet<Integer> chance_drop;
	
	public Store_of_4_toys() {
		super();
	}
	
	/**
	 * а вот и описание процедуры розыгрыша, каджый ход уникален, каждая ставка обновляет шансы игрока на выйгрыш.
	 * максимум игрок за раз выигрывает 2 игрушки, а вообще , может и не одной, все зависит от удачи самого игрок,
	 * ставки игрока и шанса установленного магазином
	 * @param gamer игрок и его аура
	 * @param bet ставка игрока
	 * @param step_user номер выйгранный игроком для выйгрыша
	 * @return всё или ничего, игрушка или дырка от бублика.
	 */
	@Override  // розыгрыш
	public LinkedList<T> drawing_of_toys(Gamer gamer, int bet, int step_user) {
		LinkedList<T> temp = new LinkedList<>();
		ArrayList<Integer> cats_big_boss = generate_chance_drop(gamer, new Big_boss_red_cat(), bet);
		ArrayList<Integer> mila_bear = generate_chance_drop(gamer, new Gray_bear_mila(), bet);
		ArrayList<Integer> snake_losk = generate_chance_drop(gamer, new Losk_black_snake(), bet);
		ArrayList<Integer> giraffe_iron = generate_chance_drop(gamer, new Yellow_iron_giraffe(), bet);
		HashSet<Integer> cats = generate_chance_random(cats_big_boss);
		HashSet<Integer> mila = generate_chance_random(mila_bear);
		HashSet<Integer> snake = generate_chance_random(snake_losk);
		HashSet<Integer> giraffe = generate_chance_random(giraffe_iron);
		if (cats.contains(step_user)){
			new Printer_txt(new Txt_interface().getYou_win()).print();
			temp.add((T) this.getBig_boss_red_cat().peekFirst());
			this.drop_toy((T) this.getBig_boss_red_cat().pollFirst());
			this.getInfo_store_cat().set(1, cats_big_boss.get(1) - 1);
		}
		else if (mila.contains(step_user)) {
			new Printer_txt(new Txt_interface().getYou_win()).print();
			temp.add((T) this.getGray_bear_mila().peekFirst());
			this.drop_toy((T) this.getGray_bear_mila().pollFirst());
			this.getInfo_store_mila().set(1, mila_bear.get(1) - 1);
		}
		if (snake.contains(step_user)) {
			new Printer_txt(new Txt_interface().getYou_win()).print();
			temp.add((T) this.getLosk_black_snake().peekFirst());
			this.drop_toy((T) this.getLosk_black_snake().pollFirst());
			this.getInfo_store_snake().set(1, snake_losk.get(1) - 1);
		} else if (giraffe.contains(step_user)) {
			new Printer_txt(new Txt_interface().getYou_win()).print();
			temp.add((T) this.getYellow_iron_giraffe().peekFirst());
			this.drop_toy((T) this.getYellow_iron_giraffe().pollFirst());
			this.getInfo_store_giraffe().set(1, giraffe_iron.get(1) - 1);
		}
		return temp;
	}
	
	/**
	 * генерация иного шанса выпадения, зависящая от ставки и удачи пользователя, но основывающаяся на игзначальном шансе установленным магазином.
	 * @param gamer игрок, для получения его удачи
	 * @param toy - игрушка , для получения шанса установленного магазином
	 * @param bet - ставка игрока, для реализации ее влияния на шанс выпадения.
	 * @return новые "временные" шансы выпадения игрушки (действуют одну ставку).
	 */
	@Override
	public ArrayList<Integer> generate_chance_drop(Gamer gamer, Toy toy, int bet) {
		ArrayList<Integer> temp = this.search_toy_info(toy);
		int pont = 0;
		ArrayList<Integer> new_chance = new ArrayList<>(Arrays.asList(temp.get(0),temp.get(1),temp.get(2)));
		if(gamer.getLuck() == 0 || new_chance.get(2) <= 0){
			new_chance.set(2,0);
		} else if (gamer.getLuck() == 100) {
			new_chance.set(2,75);
		} else {
			pont = (new_chance.get(2) + (gamer.getLuck() + bet / 2) / 10) * 2; //решил пока без логорифмов
			if (pont > 75){
				new_chance.set(2,75);
			} else {
				new_chance.set(2,pont);
			}
		}
		return new_chance;
	}
	
	/**
	 * метод рандомного распределения выйнрышных позиций для определенного типа игрушек, каждый ход новые позиции, их количество определяется
	 * тем самым временным шансом выпадения игрушки, что расчитался выше.
	 * @param data принимает текущие првила выпадения данного типа игрушек
	 * @return рандомно расчетные позиции в диапазоне 100 ячеек, заполненные по шансу выпадения.
	 */
	public HashSet<Integer> generate_chance_random(ArrayList<Integer> data){
		HashSet<Integer> chance_toy = new HashSet<>();
		Random rnd = new Random();
		while (chance_toy.size() <= data.get(2) ){
			int temp = rnd.nextInt(1,101);
			chance_toy.add(temp);
		}
		return chance_toy;
	}
	
	/**
	 * метод наполняет магазин игрушками после пуска, и дает возможность пользователю определить на
	 * старте их цену, и шанс выпадения, количество тоже вводится, но корректируется автоматически после первого изменения числа игушек
	 * до реального значения "со склада".
	 */
	public void generate_toys(){
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

	
	public HashSet<Integer> getChance_drop() {
		return chance_drop;
	}
	
	public void setChance_drop(HashSet<Integer> chance_drop) {
		this.chance_drop = chance_drop;
	}
	
	
}
