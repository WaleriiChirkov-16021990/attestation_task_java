package File_writer;

import Present.Printer_txt;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import Abstract.Toy;

import java.io.FileWriter;
import java.io.IOException;

public class Writer<T extends Toy> {
	
	private T toy;
	
	public Writer(T toy) {
		this.toy = toy;
	}
	
	public Writer() {
	}
	
	public T getToy() {
		return toy;
	}
	
	public void setToy(T toy) {
		this.toy = toy;
	}
	
	public void write_toy_drop(){
		JSONObject object = new JSONObject();
		object.put("Toy",this.getToy().toString() + "\n");
		try (FileWriter fileWriter = new FileWriter("/File/Data.json")) {
			fileWriter.write(object.toJSONString());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		new Printer_txt("Игрушка: " + this.getToy().getName() + " - записана в файл").print();
	}
}
