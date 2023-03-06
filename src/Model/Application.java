package Model;

import Abstract.Toy;
import Model.Toy.Big_boss_red_cat;
import Model.Toy.Gray_bear_mila;
import Model.Toy.Losk_black_snake;
import Model.Toy.Yellow_iron_giraffe;
import Present.Printer_toy;
import Present.Printer_txt;
import UI.Input_gamer;
import UI.Txt_interface;

public class Application {
	private Gamer<Toy> user;
	private Store_of_4_toys<Toy> my_store;
	private Input_gamer enter_gamer;
	
	public Application() {
		this.user = new Gamer<Toy>();
		this.my_store = new Store_of_4_toys<Toy>();
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
	
	/**
	 * Запуск приложения...
	 * Во время игры, будут отображаться ArrayListы информации о текущих игрушках, имитируя как бы экран игрового автомата?!
	 * [цена за 1 игрушку, реальный остаток игрушек в магазине, шанс выпадения игрушки, установленный магазином( без доп расчетов удачи)]
	 *
	 * таких окон будет 4 ряда по 3 цифры
	 *
	 * последовательность отображения:
	 * Big_boss_red_cat
	 * Gray_bear_mila
	 * Losk_black_snake
	 * Yellow_iron_giraffe
	 */
	public void run_() {
		this.getMy_store().generate_toys();
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
					// данныу выводы информации , иммитируют экран игрового автомата.
					new Printer_txt(new Txt_interface().getTablo()).print();
					new Printer_txt(this.getMy_store().getInfo_store_cat().toString()).print();
					new Printer_txt(this.getMy_store().getInfo_store_mila().toString()).print();
					new Printer_txt(this.getMy_store().getInfo_store_snake().toString()).print();
					new Printer_txt(this.getMy_store().getInfo_store_giraffe().toString()).print();
					this.getEnter_gamer().get_input(new Txt_interface().getMenu());
					if (this.getEnter_gamer().getInput().equals("1")) {
						this.getUser().setStep(this.getUser().play(1));
						if (this.getUser().isStep()) {
							this.getEnter_gamer().get_input(new Txt_interface().getYou_enter());
							if (this.getEnter_gamer().is_number_less_than_100()){
								this.getUser().getWon().addAll(this.getMy_store().drawing_of_toys(this.getUser(),1,Integer.parseInt(this.getEnter_gamer().getInput())));
							} else {
								new Printer_txt(new Txt_interface().getUoy_looser()).print();
							}
						} else {
							this.offer_credit();
						}
					} else if (this.getEnter_gamer().getInput().equals("2")) {
						this.getUser().setStep(this.getUser().play(5));
						if (this.getUser().isStep()) {
							this.getEnter_gamer().get_input(new Txt_interface().getYou_enter());
							if (this.getEnter_gamer().is_number_less_than_100()){
								this.getUser().getWon().addAll(this.getMy_store().drawing_of_toys(this.getUser(),5,Integer.parseInt(this.getEnter_gamer().getInput())));
							} else {
								new Printer_txt(new Txt_interface().getUoy_looser()).print();
							}
						} else {
							this.offer_credit();
						}
					} else if (this.getEnter_gamer().getInput().equals("3")) {
						this.getUser().setStep(this.getUser().play(10));
						if (this.getUser().isStep()) {
							this.getEnter_gamer().get_input(new Txt_interface().getYou_enter());
							if (this.getEnter_gamer().is_number_less_than_100()){
								this.getUser().getWon().addAll(this.getMy_store().drawing_of_toys(this.getUser(),10,Integer.parseInt(this.getEnter_gamer().getInput())));
							} else {
								new Printer_txt(new Txt_interface().getUoy_looser()).print();
							}
						} else {
							this.offer_credit();
						}
					} else if (this.getEnter_gamer().getInput().equals("4")){
						this.getEnter_gamer().get_input(new Txt_interface().getYou_bet_money());
						if(this.getEnter_gamer().is_number()){
							this.getUser().setStep(this.getUser().play(Integer.parseInt(this.getEnter_gamer().getInput())));
							if (this.getUser().isStep()) {
								this.getEnter_gamer().get_input(new Txt_interface().getYou_enter());
								if (this.getEnter_gamer().is_number_less_than_100()){
									this.getUser().getWon().addAll(this.getMy_store().drawing_of_toys(this.getUser(),Integer.parseInt(this.getEnter_gamer().getInput()),Integer.parseInt(this.getEnter_gamer().getInput())));
								} else {
									new Printer_txt(new Txt_interface().getUoy_looser()).print();
								}
							} else {
								this.offer_credit();
							}
						} else {
							new Printer_txt("Вы ввели не число!");
						}
					} else if (this.getEnter_gamer().getInput().equals("5")) {
						while (true){
							this.getEnter_gamer().get_input(new Txt_interface().getChange_chance());
							if (this.getEnter_gamer().getInput().equals("1")) {
								this.getMy_store().edit_toy_chance(new Big_boss_red_cat());
							} else if (this.getEnter_gamer().getInput().equals("2")) {
								this.getMy_store().edit_toy_chance(new Gray_bear_mila());
							} else if (this.getEnter_gamer().getInput().equals("3")) {
								this.getMy_store().edit_toy_chance(new Losk_black_snake());
							} else if (this.getEnter_gamer().getInput().equals("4")) {
								this.getMy_store().edit_toy_chance(new Yellow_iron_giraffe());
							} else if (this.getEnter_gamer().getInput().equals("5")) {
								break;
							} else {
								new Printer_txt(new Txt_interface().getError_input()).print();
							}
						}
					} else if (this.getEnter_gamer().getInput().equals("6")) {
						if (this.getUser().getWon().size() > 0){
							new Printer_toy<Toy>(this.getUser().getWon()).printe_linked();
						} else {
							new Printer_txt(new Txt_interface().getNo_toys()).print();
						}
					} else if (this.getEnter_gamer().getInput().equals("7")) {
						new Printer_toy<Toy>(this.getMy_store().getBig_boss_red_cat()).printe_linked();
						new Printer_toy<Toy>(this.getMy_store().getGray_bear_mila()).printe_linked();
						new Printer_toy<Toy>(this.getMy_store().getLosk_black_snake()).printe_linked();
						new Printer_toy<Toy>(this.getMy_store().getYellow_iron_giraffe()).printe_linked();
					} else if (this.getEnter_gamer().getInput().equals("8")) {
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
		} else {
			new Printer_txt(new Txt_interface().getNow_exit()).print();
			new Printer_txt(new Txt_interface().getPg_close()).print();
		}
	}
	
	private void offer_credit(){
		new Printer_txt(new Txt_interface().getCurrent_money() + this.getUser().getMoney()).print();
		new Printer_txt(new Txt_interface().getYou_loose()).print();
		this.getEnter_gamer().get_input(new Txt_interface().getYes_no());
		if (this.getEnter_gamer().getInput().equals("y") || this.getEnter_gamer().getInput().equals("yes")){
			this.getEnter_gamer().get_input(new Txt_interface().getCredit());
			if (this.getEnter_gamer().is_number()){
				this.getUser().setMoney(Integer.parseInt(this.getEnter_gamer().getInput()));
			}
			else {
				new Printer_txt(new Txt_interface().getNo_credit()).print();
			}
		}
	}
}
