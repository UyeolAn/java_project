package co.yedam.variable;

public class VariableMethodExe {
	
	int num = 100;
	
	public void showInfo() {
		int num = 100 + this.num;
		System.out.println("num : " + num);
	}
	
	public void helloMsg() {
		int num = 200 + this.num;
		System.out.println("num : " + num);
	}
	
	public void printNum() {
		System.out.println("num : " + num);
	}
	
}
