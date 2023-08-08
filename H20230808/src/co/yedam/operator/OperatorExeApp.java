package co.yedam.operator;

import java.util.Scanner;

public class OperatorExeApp {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int balance = 0; // 10만원 이상 불가, 음수 금액 불가
		boolean run = true;
		
		while (run) {
			
			System.out.println("\n\n메뉴를 선택하세요(1.예금 2.출금 3.잔고 4.종료) : ");
	
			int menu = Integer.parseInt(scan.nextLine());
			
			if (menu == 1) {
				
				System.out.println("입금액을 입력하세요 :");
				int deposit = Integer.parseInt(scan.nextLine());
				if (deposit > 100000 || deposit < 0) {
					System.out.println("입금액을 잘못 입력하셨습니다.");
					continue;
				}
				if ((balance + deposit) > 100000) {
					System.out.println("계좌잔액이 10만원을 넘어서면 안됩니다.");
					continue;
				} 
				balance += deposit;
				System.out.printf("현재 잔액은 %d원 입니다.\n", balance);
				
			} else if (menu == 2) {
				
				System.out.println("출금액을 입력하세요 :");
				int withdraw = Integer.parseInt(scan.nextLine());
				if (withdraw > 100000 || withdraw < 0) {
					System.out.println("출금액을 잘못 입력하셨습니다.");
					continue;
				}
				if ((balance - withdraw) < 0) {
					System.out.println("계좌잔액이 부족합니다.");
					continue;
				} 
				balance -= withdraw;
				System.out.printf("현재 잔액은 %d원 입니다.\n", balance);
				
			} else if (menu == 3) {
				
				System.out.printf("현재 계좌에 남아있는 잔액은 %d원 입니다.\n", balance);
				
			} else if (menu == 4) {
				
				System.out.println("어플리케이션을 종료합니다.");
				run = false;
				
			} else {
				
				System.out.println("번호를 잘못 입력하셨습니다.");
				
			}
			
		}
		
	}
}
