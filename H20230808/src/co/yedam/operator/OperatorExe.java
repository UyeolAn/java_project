package co.yedam.operator;

public class OperatorExe {
	public static void main(String[] args) {
		
		int x, y;
		y = x = 2;
		
		//대입 후에 증감 연산자 적용
		int result = x++ + 10;
		System.out.println(result);
		System.out.println("x : " + x);
		
		//증감 연산자 적용 후 대입
		result = ++y + 10;
		System.out.println(result);
		
		//삼항 연산자
		String str = "";
		
		if (x >= 10) {
			str = "x는 10이상입니다.";
		} else {
			str = "x는 10미만입니다.";
		}
		str = (x >= 10) ? "x는 10이상입니다." : "x는 10미만입니다.";
		
		System.out.println(str);
		
	}
}
