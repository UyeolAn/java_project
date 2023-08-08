package co.yedam.variable;

import java.util.Scanner;

public class VariableScannerExe {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		while (true) {
			System.out.println("정수값을 입력하세요(종료:quit) : ");
			String inputData = scan.nextLine();
			int intData = Integer.parseInt(inputData);
			
			if (inputData.equals("quit")) {
				break;
			} else if (intData > 100 || intData < 0) {
				continue;
			}
			
			sum += intData;
		}
		
		System.out.printf("입력된 값들의 합계는 %d 입니다.\n", sum);
		System.out.println("end of progam.");
		
	}
}
