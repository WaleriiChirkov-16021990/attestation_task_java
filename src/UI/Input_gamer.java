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
	
	public String get_input(String command){
		this.command = command;
		new Printer_txt(this.getCommand()).print();
		this.setInput(this.getScanner().nextLine());
		return this.getInput();
	}
	
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
