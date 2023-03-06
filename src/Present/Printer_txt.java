package Present;

/**
 * класс печати информации в консоль
 */
public class Printer_txt {
	private String text;
	
	/**
	 * конструктор при создании экземпляра принимает строку, для дальнейшего ее отображения в консоли или просто хранении.
	 * @param text
	 */
	public Printer_txt(String text) {
		this.text = text;
	}
	
	/**
	 * метод вывода полученной ранее информации в консоль
	 */
	public void print(){
		System.out.println(this.text);
	}
}
