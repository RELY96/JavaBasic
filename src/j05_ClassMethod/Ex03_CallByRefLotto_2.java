package j05_ClassMethod;

import java.util.Arrays;

public class Ex03_CallByRefLotto_2 {

	public void mySort(int[] arr, char c) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) { // 정렬하는 반복문

				// ** 오름차순 & 내림차순 한번에도 가능
				if ((c == 'A' && arr[i] > arr[j]) || (c == 'D' && arr[i] < arr[j])) { // ㅁ||ㅁ 일때, 치환식 실행
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
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
		Ex03_CallByRefLotto_2 ex03 = new Ex03_CallByRefLotto_2();

		// 2) 오름차순 정렬
		ex03.mySort(lotto, 'A'); 
		System.out.println("** 오름차순 정렬 : " + Arrays.toString(lotto));
																		
		// 3) 내림차순 정렬
		ex03.mySort(lotto, 'D');
		System.out.println("** 내림차순 정렬 : " + Arrays.toString(lotto));

	} // main

} // class
