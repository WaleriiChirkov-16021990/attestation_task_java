package File_writer;

import Present.Printer_txt;
import org.json.simple.JSONObject;
import  java.io.File;


import Abstract.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * класс для записи выйгранной игрушка в файл json
 * @param <T> ограничение наследниками Toy class
 */
public class Writer<T extends Toy> {
	
	private T toy;
	private Path path;
	
	public Writer(T toy) {
		this.toy = toy;
		this.path = Path.of("src\\File\\Data.json");
	}
	
	public Writer() {
		this.path = Path.of("src\\File\\Data.json");
	}
	
	public T getToy() {
		return toy;
	}
	
	public void setToy(T toy) {
		this.toy = toy;
	}
	
	/**
	 * метод записи в файл
	 */
	public void write_toy_drop(){
		JSONObject object = new JSONObject();
		object.put("Toy",this.getToy().toString());
		File f = new File(this.getPath().toString());
		if(f.exists() &&  !f.isDirectory()){
			try (FileWriter fileWriter = new FileWriter(this.getPath().toString(), true)) {
				fileWriter.write(object.toJSONString());
				fileWriter.write("\n");
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			new Printer_txt("Игрушка: " + this.getToy().getName() + " - записана в файл").print();
		} else {
			new Printer_txt("Файла не существует, проверьте папку \\src\\File\\Data.json");
		}
	}
	
	public Path getPath() {
		return path;
	}
	
}
