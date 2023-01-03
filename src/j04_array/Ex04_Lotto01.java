package j04_array;

import java.util.Arrays;
import java.util.Random;

public class Ex04_Lotto01 {

	// ** Lotto 번호 생성기 만들기
	// => int 를 6개 담을 수 있는 배열 생성 : lotto
	// => Random 으로 1~45 범위의 숫자를 생성해서 배열 초기화 하기
	// (추가: 단, 로또 번호는 중복 허용하지 않음)
	// => 출력

	// ※Random 범위는 % 연산을 활용한 것!(범위니까 그 범위를 넘을 수 없이 다시 돌아옴) (45)+1 => 0~44 +1 => 0~45
	// ※서치 알고리즘과 정렬 알고리즘!!!★★★

	public static void main(String[] args) {
		// 1) 배열 정의(담을 공간 만들어 놓기)
		int lotto[] = new int[6]; // 크기는 정해져있지만(6개) data는 아직 정해지지X -> 명시적

		// 2) Random 으로 배열 초기화(*숫자 중복 허용하지 않음) -> random이 6번 다 채울때까지 반복문
		Random rn = new Random();
		for (int i = 0; i < lotto.length; i++) { // 로또 크기에 따른 확장성 때문에 조건은 lotto.length;
			lotto[i] = rn.nextInt(45) + 1; // lotto[배열]에 넣기 = 랜덤 num 뽑기

			// 3) 중복 확인 (★search 알고리즘[동일한 값이 있나 확인하는 것])
			// 1) 0번부터 나-1까지(j<i) 차례대로 비교
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) { // 지금 나온 값 lotto[i]랑 lotto[j]랑 순차적으로 비교
					--i;
					break; // 똑같으면 빼고, 자리 안넘어가고 그 자리에 멈춰있게 + 그 반복문 탈출해서 그 자리에서 다시 random 배열 뽑기
				} // if
			} // for_j
		} // for_i

		// 4) 최댓값, 최솟값 출력 -> 과거 최댓값이랑 현재값 비교하며 바꾸기
		int max = lotto[0], min = lotto[0];
		for (int i = 1; i < lotto.length; i++) {
			// => 최댓값 찾기
			if (max < lotto[i]) max=lotto[i];

			// => 최솟값 찾기
			if (min > lotto[i]) min=lotto[i];
		} // for

		// 5) 오름차순 정렬
		// => Lotto02 에 있음

		// 5) 출력하기
		System.out.println("** Lotto => " + Arrays.toString(lotto)); // arrays로 배열 쉽게 출력
		System.out.printf("** Lotto 최댓값 :%d , 최솟값 :%d ", max, min);
		
	} // main

} // class
