package c05_test;

import java.util.Arrays;

//shuffle 

public class Chap05_5_5 {

	public static void main(String[] args) {
		int[] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 }; // 넣을 데이터 값들 1~9까지 묵시적 선언
		int[] ball3 = new int[3]; // 세 자리 넣을 빈 공간

		// 1~9까지 무작위 배열(중복 안 겹치게)
		for (int i = 0; i < ballArr.length; i++) {
			int j = (int) (Math.random() * ballArr.length); // int j 는 1~9중의 랜덤 배열임
			int tmp = 0; // 배열 j를 배열 i와 shuffle 해줌 -> 중복X
			
			

			ballArr[tmp]=ballArr[0];
			ballArr[0]=ballArr[i];
			ballArr[i]=ballArr[tmp];

			
			

		}
		System.out.println(""+Arrays.toString(ballArr));
		
		

//		for(int i=0; i<ball3.length; i++) {
//			System.out.print(ball3[i]);
//		}

	} // main

} // class
