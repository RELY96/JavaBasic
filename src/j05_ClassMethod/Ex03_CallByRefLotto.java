package j05_ClassMethod;

import java.util.Arrays;

// 배열과 인스턴스 활용한 Lotto 만들기(배열 매개변수:참조자료형)

//** CallByReference (매개변수 참조자료형, 주소전달) 

//** 과제 
//=> Ex04_Lotto02.java 의 "Sort 부분을 메서드로 만들기"
//=> 메서드명 : mySort
//            -> 매개변수 (배열, char_Asccending(오름)/Descending(내림))
//            -> 전달된 배열을 오름차순 또는 내림차순으로 정렬   

public class Ex03_CallByRefLotto {

	public void mySort(int[] arr, char c) { // 배열 전달하면 그 배열만 정렬해서 그대로 보여주면됨(주소전달이니까)(void) / char c는 A or D 들어가려고
		for (int i = 0; i < arr.length; i++) { // 정렬하는 반복문
			for (int j = i + 1; j < arr.length; j++) {

				// ** 오름차순인 경우 -> char c로 알 수 있음
				if (c == 'A') { // ->c가 'A'이면 오름차순이다, else이면 내림차순이다
					if (arr[i] > arr[j]) { // 오름차순 조건이면 치환
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
				;
				// ** 내림차순인 경우
				if (c == 'D') {
					if (arr[i] < arr[j]) {
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
				;
			} // for_j
		} // for_i
	} // mySort 매서드

	public static void main(String[] args) {
		// 1) 매개변수로 사용할 배열생성
		int[] lotto = { 7, 22, 44, 3, 25, 10 };
		System.out.println("** 정렬 전 : " + Arrays.toString(lotto));

		// ★매서드 사용하기 위해 인스턴스 생성★
		Ex03_CallByRefLotto ex03 = new Ex03_CallByRefLotto();

		// 2) 오름차순 정렬
		ex03.mySort(lotto, 'A'); // 매서드 int []arr 매개변수에 lotto 매개변수 넣어줌
		System.out.println("** 오름차순 정렬 : " + Arrays.toString(lotto)); // 1차로 오름차순 정렬되서 int[]lotto 배열은 오름차순으로 주소 속 오리지날
																		// 값이 변경됨
		// 3) 내림차순 정렬
		ex03.mySort(lotto, 'D');
		System.out.println("** 내림차순 정렬 : " + Arrays.toString(lotto)); // 내림차순으로 주소 속 오리지날 값이 변경됨

	} // main

} // class
