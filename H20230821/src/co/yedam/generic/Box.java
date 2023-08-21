package co.yedam.generic;

public class Box<T> {

	T obj;
	
	T get() {
		return this.obj;
	}
	
	void set(T obj) {
		this.obj = obj;
	}
	
}
