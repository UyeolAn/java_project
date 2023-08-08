package co.yedam.variable;

import java.io.IOException;

public class VariableIOExe {
	public static void main(String[] args) {
		
		String name = "안우열";
		int age = 24;
		double weight = 70.5;
		
		System.out.println("이름은 " + name + ", 나이는 " + age + "살, 몸무게는 " + weight + " 입니다");
		System.out.printf("이름은 %s, 나이는 %d살, 뭄무게는 %.1f 입니다\n", name, age, weight);
		
		try {
			System.out.println("값을 입력하세요 : ");
			while (true) {
				int inputData = System.in.read();
				
				if (inputData == 113) {
					break;
				} else if (inputData == 10 || inputData == 13) {
					continue;
				} 
				
				System.out.printf("입력된 코드값은 '%d'입니다.\n", inputData);
				System.out.println("값을 입력하세요 : ");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("end of program.");
		
	}
}
