package j04_array;

import java.util.Arrays;

//5장 예제 10, 139p shuffle (배열 활용 섞기)

// => 1) 길이가 10인 배열 정의하고, 0~9로 초기화해라
// => random 을 이용해서 2) 배열의 임의의 위치에 있는 배열의 값과, 배열의 첫번째 데이터[0]의 값을 교환하는 일을 100번 반복해서 배열을 뒤섞이게 함

public class  Ex05_shuffle {

	public static void main(String[] args) {
		// 1) 배열 정의 & 초기화
		int[] numArr = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println("numArr : " + Arrays.toString(numArr)); // 배열 형태로 찍어보기

		// 2)0~9중 누가 걸릴지 모르지만(random), 나오는 0~9 사이의 수를 무조건 [0]첫번째 데이터와 교환
		// 3) 섞기 100번(for 100번)
		for (int i = 0; i < 100; i++) {
			int n = (int) (Math.random() * 10); // random 배열의 임의의 위치, random 매서드는 실수라 0~1사이만 뽑음(배열의 범위 = *의 길이)
			int temp = numArr[0]; // 맞바꾸기 위한 temp 변수 소환
			numArr[0]=numArr[n];   // n번째와 첫번째[0] 스와핑
			numArr[n]=temp;        // 스와핑 for 100번
		}
		
		System.out.println("numArr2(shuffle) : "+Arrays.toString(numArr)); //답!
        // 연습문제 5 풀어보기! => 
	} // main

} // class
