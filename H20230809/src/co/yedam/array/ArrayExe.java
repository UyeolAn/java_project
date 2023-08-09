package co.yedam.array;

import java.util.Arrays;

public class ArrayExe {
	public static void main(String[] args) {
		
		//배열 연습
		int[] intArr1 = null;
		intArr1 = new int[10];
		intArr1 = new int[] {12, 25, 67, 23};
		
		System.out.println(intArr1[0]);
		
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += intArr1[i];
		}
		
		System.out.println(sum);
		
		
		//랜덤 배열의 합, 평균, 최댓값 구하기
		sum = 0;
		double avg = 0;
		int[] randNumArray = new int[5];
		
		for (int i = 0; i < 5; i++) {
			randNumArray[i] = (int) (Math.random() * 100) + 1;
			sum += randNumArray[i];
		}
		
		avg = (double)sum / randNumArray.length;
		
		System.out.println(Arrays.toString(randNumArray));
		System.out.printf("배열의 합 : %d, 배열의 평균 : %.1f\n", sum, avg);
		
		int max = randNumArray[0];
		for (int i = 1; i < 5; i++) {
			if (randNumArray[i] > max) {
				max = randNumArray[i];
			}
		}
		
		System.out.printf("배열의 최댓값 : %d\n", max);
		
	}
}
