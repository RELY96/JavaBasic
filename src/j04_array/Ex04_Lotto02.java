package j04_array;

import java.util.Arrays;
import java.util.Random;

public class Ex04_Lotto02 {

	// ** Lotto 번호 생성기 만들기2(오름차순 정렬)
	// 정렬 알고리즘 : 순차정렬 (Sequence Sort)

	// => 정렬 알고리즘에서 가장 간단하고 기본이 되는 알고리즘으로
	// 배열의 처음과 끝을 탐색하면서 "차순대로 정렬"하는 가장 기초적인 정렬 알고리즘(차례대로 비교)
	// ** 정렬 알고리즘 : 삽입(insert)정렬, 합병(Merge)정렬, 퀵(Quick)정렬...
	// => https://blog.naver.com/tepet/221690306235

	public static void main(String[] args) {

		int lotto[] = new int[6];

		Random rn = new Random();
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rn.nextInt(45) + 1;

			for (int j = 0; j < i; j++) { // 초기값 : j=0(나온값 배열0부터 시작), 조건 : 나보다 작을때(지금까지 나온 값들) j<i
				if (lotto[i] == lotto[j]) {
					--i; // i증가하면 숫자 안 만들어진 상태기 때문에 증가 안되게 i--; 해서 i를 다시 그 자리부터 뽑기
					break; // 바로 i뽑으로 for i문으로 가기(for j문 break 탈출해서)
				}
			}
		}
//========================================================================//

		// ★최댓, 최솟값 출력
		int max = lotto[0], min = lotto[0];
		for (int i = 1; i < lotto.length; i++) {
			if (max < lotto[i])
				max = lotto[i];
			if (min > lotto[i])
				min = lotto[i];
		}
		System.out.println("** Lotto 정렬 전=> " + Arrays.toString(lotto));
		System.out.printf("** Lotto 최댓값 :%d , 최솟값 :%d \n", max, min);

//========================================================================//

		// ★★★오름차순 정렬 반복문 2개
		// 1) 차례대로 비교 반복문
		// 2) 비교 결과에 따라 위치 정하는 반복문(작은수가 그 배열 자리에 오게 맞바꾸기) '='min과 비슷
		for (int i = 0; i < lotto.length; i++) { // 비교 '되는' 대상이 변하는 반복문(i배열 위치의 값)
			for (int j = i + 1; j < lotto.length; j++) { // 나 다음부터기 때문에 j=i+1 ,j는 lotto.length끝까지
				if (lotto[i] > lotto[j]) { // i랑 j랑 비교 -> lotto[i]보다 j가 더 작으면
					int tmp = lotto[i]; // 바꾸기
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				} // if
			} // for_j
		} // for_i
		System.out.println("** Lotto 올림차순 => " + Arrays.toString(lotto));

//========================================================================//

		// ★★★내림차순 정렬 반복문 '='max와 비슷
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[i] < lotto[j]) {
					int tmp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = tmp;
				} // if
			} // for_j
		} // for_i
		System.out.println("** Lotto 내림차순 => " + Arrays.toString(lotto));

//========================================================================//

		// ** Wrapper Class => toString(), sort(), equals() ....
		int[] myLotto = { 24, 8, 34, 1, 37, 3 };

		Arrays.sort(myLotto); // sort 매서드 default로 오름차순 정렬 -> 내림차순 : sort로 해서 뒤부터 출력하면 됨
		System.out.println("** Lotto 올림차순 => " + Arrays.toString(myLotto)); // 오름차순 정렬 후 배열형식으로 출력

		if (Arrays.equals(lotto, myLotto))
			System.out.println("** 당첨 **"); // equals 매서드(매개변수1,매개변수2) 두 매개변수 == 같으면?
		else
			System.out.println("** 꽝 **");

	} // main

} // class
