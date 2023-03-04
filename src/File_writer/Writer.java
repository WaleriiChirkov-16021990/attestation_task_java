package File_writer;

import Abstract.Toy;

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
	
	}
}
