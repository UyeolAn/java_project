package co.yedam.variable;

public class VariableExe {
	
	public static void main(String[] args) {
		
		//변수 선언
		//정수형 변수 유형 : byte, short, int, long -> 초기값 : 0
		int num1 = 1; //초기화
		int num2 = 2147483647;
		
		int result = num1 + num2; //초기화
		System.out.println("result : " + result);
		
		byte b1 = 10;
		byte b2 = 20;
		
		int b3 = b1 + b2; //byte 형은 더하는 순간 int 형으로 바뀜
		
		int i1 = 100;
		byte b4 = 10;
		b3 = i1 + b4; //큰 데이터 타입으로 자동형변환이 일어남
		
		//실수형 변수 유형 : float, double -> 초기값 : 0.0
		double dbl1 = 3.14;
		double dbl2 = 20;
		
		//문자열 변수 : String -> 초기값 : null
		String str = "안우열";
		str = "Uyeol, An";
		
		//클래스 변수
		Person person1 = new Person();
		person1.name = "안우열";
		person1.age = 24;
		person1.weight = 70.5;
		person1 = new Person();
		
		System.out.println("이름 : " + person1.name);
		System.out.println("나이 : " + person1.age);
		System.out.println("몸무게 : " + person1.weight);
		
		VariableMethodExe var2 = new VariableMethodExe();
		var2.showInfo();
		var2.helloMsg();
		var2.printNum();
	}
	
}
