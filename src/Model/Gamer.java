package Model;

import Abstract.Human;
import Abstract.Toy;
import Present.Printer_txt;
import UI.Input_gamer;

import java.util.LinkedList;
import java.util.Objects;

/**
 * класс игроков
 * @param <T> игроки связаны(ограничены) наследниками(игрушками) класса Toy
 */
public class Gamer<T extends Toy>   extends Human {
	private LinkedList<T> won;
	private boolean step;
	
	public Gamer(String name, int luck, int money) {
		super(name, luck, money);
		this.setWon(new LinkedList<T>());
	}
	
	public Gamer() {
		super();
		this.setWon(new LinkedList<>());
	}
	
	public LinkedList<T> getWon() {
		return won;
	}
	
	public void setWon(LinkedList<T> won) {
		this.won = won;
	}
	
	/**
	 * метод заполнения данных игрока, прием данным осществляется вводом в консоль.
	 */
	public void  full_data_user(){
		Input_gamer i_am_new_user = new Input_gamer();
		while (true){
			i_am_new_user.get_input("Представьтесь: ");
			this.setName(i_am_new_user.getInput());
			i_am_new_user.get_input("Сколько у вас в кармане наличных?");
			if(i_am_new_user.is_number()){
				this.setMoney(Integer.parseInt(i_am_new_user.getInput())); //
			} else {
				new Printer_txt("У вас не может быть столько денег =) введите число, например: 1000 ").print();
				continue;
			}
			i_am_new_user.get_input("Оцените вашу удачу по 100 бальной шкале: ");
			if (i_am_new_user.is_number_less_than_100()){
				this.setLuck(Integer.parseInt(i_am_new_user.getInput()));
			} else {
				new Printer_txt("В мире не бывает таких неудачников, попробуйте еще раз !").print();
				continue;
			}
			break;
		}
		new Printer_txt("Добро пожаловать, " + this.getName() + " !").print();
	}
	
	@Override
	public boolean play(int bet) {
		if(this.getMoney() > bet){
			this.setMoney(this.getMoney() - bet);
			return true;
		} else {
			new Printer_txt("У вас не достаточно денег для дальнейшей игры").print();
		}
		return false;
	}
	
	public boolean isStep() {
		return step;
	}
	
	public void setStep(boolean step) {
		this.step = step;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Gamer<?> gamer)) return false;
		if (!super.equals(o)) return false;
		return isStep() == gamer.isStep() && Objects.equals(getWon(), gamer.getWon());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), getWon(), isStep());
	}
	
	@Override
	public String toString() {
		return "Gamer{" +
				"won=" + won +
				", step=" + step +
				'}';
	}
}
