package c06_test;

import java.util.Arrays;

public class Chap06_17 {
	// shuffle 메서드 작성
	public static int[] shuffle(int[] arr) { // int[]타입으로 반환, 매개변수 arr
		for (int i = 0; i < arr.length; i++) { // 매개변수 arr의 길이만큼 뽑아서 셔플
			int n = (int) (Math.random() * arr.length);
			int temp = arr[0];
			arr[0] = arr[n];
			arr[n] = temp;
		}
		return arr; // int[]타입인 arr(셔플된) 값 리턴
	}

	public static void main(String[] args) {
		int[] original = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // 배열 묵시적 선언
		System.out.println(Arrays.toString(original));

		int[] result = shuffle(original); // shuffle 매서드 안 original -> int[]arr 로 전달 -> 리턴된 값 int[] result에 넣어주기
		System.out.println(Arrays.toString(result)); // result 출력

	}

}
