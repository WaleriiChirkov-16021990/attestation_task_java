package Model;

import Abstract.Toy;
import Present.Printer_txt;
import UI.Input_gamer;
import UI.Txt_interface;

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
		this.getMy_store().generate_toy();
		System.out.println(this.getMy_store().getInfo_store_cat());
		System.out.println(this.getMy_store().getInfo_store_mila());
		System.out.println(this.getMy_store().getInfo_store_snake());
		System.out.println(this.getMy_store().getInfo_store_giraffe());
		String x = null;
		this.getUser().full_data_user();
		new Printer_txt(new Txt_interface().getEnter()).print();
		this.getEnter_gamer().get_input(new Txt_interface().getYes_no());
		if (this.getEnter_gamer().getInput().equals("y")) {
			new Printer_txt(new Txt_interface().getGame()).print();
			this.getEnter_gamer().get_input(new Txt_interface().getYes_no());
			if (this.getEnter_gamer().getInput().equals("y")) {
				new Printer_txt(new Txt_interface().getGreeting()).print();
				new Printer_txt(new Txt_interface().getRules_info()).print();
				while (true) {
					this.getEnter_gamer().get_input(new Txt_interface().getMenu());
					x = this.getEnter_gamer().getInput();
					if (x.equals("1")) {
						this.getUser().setStep(this.getUser().play(1));
						if (this.getUser().isStep()) {
//							this.getMy_store().generate_chance_drop();
						}
					} else if (x.equals("2")) {
						
					} else if (x.equals("3")) {
						
					} else if (x.equals("4")){
						
					} else if (x.equals("5")) {
					
					} else if (x.equals("6")) {
					
					} else if (x.equals("7")) {
					
					} else if (x.equals("8")) {
						new Printer_txt(new Txt_interface().getPg_close()).print();
						break;
					} else {
						new Printer_txt(new Txt_interface().getError_input()).print();
					}
				}
				
			} else {
				new Printer_txt(new Txt_interface().getNow_exit()).print();
				new Printer_txt(new Txt_interface().getPg_close()).print();
			}
		}
	}
}
