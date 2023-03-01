package Model;

import Abstract.Human;
import Present.Printer_txt;

public class Gamer extends Human {
	
	public Gamer(String name, int luck, int money) {
		super(name, luck, money);
	}
	
	public Gamer() {
		super();
	}
	
	@Override
	public int play(int bet) {
		if(this.getMoney() > bet){
			this.setMoney(this.getMoney() - bet);
			return bet;
		} else {
			new Printer_txt("У вас не достаточно денег для дальнейшей игры").print();
		}
		return 0;
	}
}
