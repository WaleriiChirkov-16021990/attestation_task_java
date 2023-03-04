package Model;

import Abstract.Toy;
import Model.Toy.Big_boss_red_cat;
import Model.Toy.Gray_bear_mila;
import Model.Toy.Losk_black_snake;
import Model.Toy.Yellow_iron_giraffe;
import Present.Printer_txt;
import UI.Input_gamer;
import UI.Txt_interface;

import java.util.Dictionary;

public class Application {
	private Gamer<Toy> user;
	private Store_of_4_toys my_store;
	private Input_gamer enter_gamer;
	
	public Application() {
		this.user = new Gamer<>();
		this.my_store = new Store_of_4_toys<>();
		this.enter_gamer = new Input_gamer();
	}
	
	public Gamer<Toy> getUser() {
		return user;
	}
	
	public void setUser(Gamer<Toy> user) {
		this.user = user;
	}
	
	public Store_of_4_toys getMy_store() {
		return my_store;
	}
	
	public void setMy_store(Store_of_4_toys my_store) {
		this.my_store = my_store;
	}
	
	public Input_gamer getEnter_gamer() {
		return enter_gamer;
	}
	
	public void setEnter_gamer(Input_gamer enter_gamer) {
		this.enter_gamer = enter_gamer;
	}
	
	public void run_() {
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
		this.getMy_store().add_new_toys(cat1);
		this.getMy_store().add_toy(cat2);
		this.getMy_store().add_toy(cat3);
		this.getMy_store().add_new_toys(mila1);
		this.getMy_store().add_toy(mila2);
		this.getMy_store().add_toy(mila3);
		this.getMy_store().add_new_toys(snake1);
		this.getMy_store().add_toy(snake2);
		this.getMy_store().add_toy(snake3);
		this.getMy_store().add_toy(snake4);
		this.getMy_store().add_toy(snake5);
		this.getMy_store().add_new_toys(giraffe1);
		this.getMy_store().add_toy(giraffe2);
		System.out.println(this.getMy_store().getInfo_store());
		String x = null;
		this.getUser().full_data_user();
		new Printer_txt(new Txt_interface().getEnter()).print();
		if (this.getEnter_gamer().get_input(new Txt_interface().getYes_no()).toLowerCase().equals("yes")) {
			new Printer_txt(new Txt_interface().getGame()).print();
			if (this.getEnter_gamer().get_input(new Txt_interface().getYes_no()).toLowerCase().equals("yes")) {
				new Printer_txt(new Txt_interface().getGreeting()).print();
				new Printer_txt(new Txt_interface().getRules_info()).print();
				while (true) {
					x = this.getEnter_gamer().get_input(new Txt_interface().getMenu());
					if (x.toLowerCase().equals("1")) {
						this.getUser().setStep(this.getUser().play(1));
						if (this.getUser().isStep()) {
//							this.getMy_store().generate_chance_drop();
						}
					} else if (x.toLowerCase().equals("2")) {
						
					} else if (x.toLowerCase().equals("3")) {
						
					} else {
						
					}
				}
				
			} else {
				new Printer_txt(new Txt_interface().getNow_exit()).print();
				new Printer_txt(new Txt_interface().getPg_close()).print();
			}
		}
	}
}
