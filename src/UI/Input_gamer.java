package UI;

import Present.Printer_txt;

import java.util.Scanner;

public class Input_gamer {
	private String command;
	private Scanner scanner;
	private String input;
	
	public Input_gamer() {
		this.scanner = new Scanner(System.in);
	}
	
	/**
	 * метод принимает текстовое сообщение для юзера и далее псохраняет ввод пользователя
	 * из консоли.
	 * @param command - текстовое сообщение пользователю
	 */
	public void get_input(String command){
		this.command = command;
		new Printer_txt(this.getCommand()).print();
		this.setInput(this.scanner.nextLine());
	}
	
	/**
	 * метод проверяет , является ли полученна строка = числовым значением, или там присутствуют сторонние символы.
	 * @return true or false
	 */
	public boolean is_number(){
		return this.getInput().matches("^\\d+$");
	}
	
	/**
	 * метод проверяет, является ли введенная строка числом , его числовое значение, дабы не навредить логике
	 * расчетов.
	 * @return true or false
	 */
	public boolean is_number_less_than_100(){
		if (this.is_number()){
			if( Integer.parseInt(this.getInput()) <= 100 && Integer.parseInt(this.getInput()) >= 0){
				return true;
			}
			return false;
		}
		return false;
	}
	
	/**
	 * Ниже геттеры и сеттеры
	 * @return
	 */
	public String getCommand() {
		return command;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
	
	public Scanner getScanner() {
		return scanner;
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public String getInput() {
		return input;
	}
	
	public void setInput(String input) {
		this.input = input;
	}
}
