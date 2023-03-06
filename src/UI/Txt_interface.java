package UI;

/**
 * Данный класс создан для облегчения редактирования текстовых команд пользователю, так как уже подгоняет курс по БД MYSQL, иногда можно встретить
 * "магический" текст в коде, но я старался весь вынести сюда.
 */
public class Txt_interface {
	private final String greeting = "Добро пожаловать на розыгрыш супер мeга игрууууууууууушек !!";
	private final String rules_info = "Правила розыгрыша просты: необходимо положить на блюдце монетку, подождать пока в него ударит зелёная молния, и возможно в этом блюдце окажется очень мега крутая игрушка, или сразу несколько игрушек, а может и ни одной. Всё зависит от твоей удачи, дерзай!!!";
	private final String enter = "Войти в магазин?";
	private final String you_enter = "Бросайте кость, от 1 до 100 включительно...";
	private final String exit = "Выйти из магазина?";
	private final String yes_no  = "y/n ? ";
	private final String current_money = "Текущий баланс: ";
	private final String no_credit = "Мы выдаем кредит только в местной валюте!";
	private final String no_toys = "Вы пока не выйграли ни одной игрушки!";
	
	private final String tablo = "Tablo info of toys: ";
	private final String game = "Попытаться выйграть супер игрушку? ";
	private final String last_exit = "Приходите к нам ещё!";
	private final String now_exit = "Обязательно зайдите до конца недели, у нас сейчас лотерея, вы можете выйграть крутую игрушку! ";
	private final String menu =         "\n1. Положить 1 монету. /" +
										"\n2. Положить 5 монет. /" +
										"\n3. Положить 10 монет.     /" +
										"\n4. Положить другое количество монет: /" +
										"\n5. Изменить вероятность выпадения игрушек/" +
										"\n6. Посмотреть Выйгранные игрушки /" +
										"\n7. Посмотреть на разыгрываемые игрушки /" +
										"\n8. Уйти";
	
	private final String change_chance =    "\n1. Изменить вероятность для Big_boss_red_cat /" +
											"\n2. Gray_bear_mila/" +
											"\n3. Losk_black_snake/" +
											"\n4. Yellow_iron_giraffe/" +
											"\n5. Exit";
	private final String pg_close = "Программа завершена (0)";
	private final String you_bet_money  = "Введите целое число, сколько денег вы готовы поставить ? ";
	
	private final String you_win = "\nУрааа, вам улыбнулась удача! " +
									"\nЗабирайте ваш выйгрыш: ";
	
	private final String credit  = "Вам одобрен кредит на любую сумму под 60 %, сколько желаете взять ?";
	
	private final String you_loose = "Кажется у вас закончились монеты, приходите завтра или можем оформить кредит?";
	
	private final String uoy_looser =   "Попытка не прошла, а деньги списались, вводите числа из диапазона!";
	private final String error_input  = "Нет такого пункта";
	
	public String getTablo() {
		return tablo;
	}
	
	public String getCurrent_money() {
		return current_money;
	}
	
	public String getNo_credit() {
		return no_credit;
	}
	
	public String getCredit() {
		return credit;
	}
	
	public String getYou_bet_money() {
		return you_bet_money;
	}
	
	public String getUoy_looser() {
		return uoy_looser;
	}
	
	public String getChange_chance() {
		return change_chance;
	}
	
	public String getError_input() {
		return error_input;
	}
	
	public String getPg_close() {
		return pg_close;
	}
	
	public String getExit() {
		return exit;
	}
	
	public String getLast_exit() {
		return last_exit;
	}
	
	public String getYes_no() {
		return yes_no;
	}
	
	public String getEnter() {
		return enter;
	}
	
	public String getGreeting() {
		return greeting;
	}
	
	public String getRules_info() {
		return rules_info;
	}
	
	public String getGame() {
		return game;
	}
	
	public String getNo_toys() {
		return no_toys;
	}
	
	public String getNow_exit() {
		return now_exit;
	}
	
	public String getYou_enter() {
		return you_enter;
	}
	
	public String getYou_win() {
		return you_win;
	}
	
	public String getYou_loose() {
		return you_loose;
	}
	
	public String getMenu() {
		return menu;
	}
}
