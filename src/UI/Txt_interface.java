package UI;

public class Txt_interface {
	private final String greeting = "Добро пожаловать на розыгрыш супер мeга игрууууууууууушек !!";
	private final String rules_info = "Правила розыгрыша просты: необходимо положить на блюдце монетку, подождать пока в него ударит зелёная молния, и возможно в этом блюдце окажется очень мега крутая игрушка, а может и нет. Всё зависит от твоей удачи, дерзай!!! /" +
			"\nГлавное, не забудь, Гарантированно выигрывает каждый 20-й игрок.";
	private final String enter = "Войти в магазин?";
	private final String exit = "Выйти из магазина?";
	private final String yes_no  = "yes/no ? ";
	private final String game = "Попытаться выйграть супер игрушку? ";
	private final String last_exit = "Приходите к нам ещё!";
	private final String now_exit = "Обязательно зайдите до конца недели, у нас сейчас лотерея, вы можете выйграть крутую игрушку! ";
//	private final String I_looked_at_the_prices = "Желаете проверить свою удачу? многим удалось сегодня выйграть призы.";
	private final String menu = "\n1. Положить 1 монету. /" +
										"\n2. Положить 5 монет. /" +
										"\n3. Положить 10 монет.     /" +
										"\n4. Положить другое количество монет: /" +
										"\n5. Уйти";
	private final String pg_close = "Программа завершена (0)";
	
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
	
	public String getNow_exit() {
		return now_exit;
	}
	
//	public String getI_looked_at_the_prices() {
//		return I_looked_at_the_prices;
//	}
	
	public String getMenu() {
		return menu;
	}
}
