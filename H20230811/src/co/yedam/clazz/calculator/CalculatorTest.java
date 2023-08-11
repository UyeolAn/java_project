package co.yedam.clazz.calculator;

public class CalculatorTest {
	
	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		
		//멤버 메서드
		double sumRes = cal.sum(20.3, 40.5);
		double minusRes = cal.minus(40.5, 20.3);
		
		//정적 메서드
		double muntiRes = Calculator.milti(2.3, 4.5);
		
	}
	
}
