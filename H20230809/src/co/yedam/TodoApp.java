package co.yedam;

public class TodoApp {
	public static void main(String[] args) {
		//등록/완료/조회(날짜)/미완료/

		//1.등록 : '1 할일 0810' 형식으로 입력받아서 저장하고 done 은 false 로 지정함
		
		//2.완료 : '1 2 4'와 같이 여러 번호을 입력하면 해당 번호의 할일들의 done 을 true 로 바꿔줌
		//		  순번을 '1 5 2 4'와 같이 무작위 순서로 입력하면 정렬해서 출력해야함
		
		//3.조회 : 날짜(0810)를 입력받아서 해당 날짜의 할일들을 조회함
		
		//4.미완료 : done 이 false 인 할일 목록을 출력함	
	}
	
	public static void sortSample() {
		int[] intAry = {45, 23, 90, 77, 12};
		
		for (int i = 0; i < intAry.length - 1; i++) {
			for (int j = 0; j < intAry.length - 1; j++) {
				if (intAry[i] > intAry[i + 1]) {
					int tmp = intAry[i];
					intAry[i] = intAry[i+1];
					intAry[i+1] = tmp;
				}
			}
		}
	}
}
