package Model;

import Abstract.Human;
import Abstract.Toy;
import Present.Printer_txt;
import UI.Input_gamer;

import java.util.ArrayList;
import java.util.Objects;

public class Gamer<T extends Toy>   extends Human {
	private ArrayList<T> won;
	private boolean step;
	
	public Gamer(String name, int luck, int money) {
		super(name, luck, money);
		this.setWon(new ArrayList<T>());
	}
	
	public Gamer() {
		super();
		this.setWon(new ArrayList<T>());
	}
	
	public ArrayList<T> getWon() {
		return won;
	}
	
	public void setWon(ArrayList<T> won) {
		this.won = won;
	}
	
	public void  full_data_user(){
		this.setName(new Input_gamer().get_input("Представьтесь: "));
		this.setMoney(Integer.parseInt(new Input_gamer().get_input("Сколько у вас в кармане наличных?"))); //
		this.setLuck(Integer.parseInt(new Input_gamer().get_input("Оцените вашу удачу по 100 бальной шкале: ")));
		new Printer_txt("Добро пожаловать, Борис!").print();
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
