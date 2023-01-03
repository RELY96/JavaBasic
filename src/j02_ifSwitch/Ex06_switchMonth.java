package j02_ifSwitch;

import java.util.Scanner;

//ctrl + shift + f => 자동정렬!

//** 실습 : 
//1. 월을 입력 받아서 
//2. 몇일까지 인지,  
// => 1,3,5,7,8,10,12월 => ?월은 31일 까지 입니다. +2
// => 4,6,9,11 월 => ?월은 30일 까지 입니다.
// => 2 월 => ?월은 29일 까지 입니다.
//3. 무슨 계절인지 출력 하기
//  => 3~5:봄 , 6~8:여름, 9~11:가을, 12~2:겨울

//** switch case 구문으로 작성

public class Ex06_switchMonth {

	public static void main(String[] args) {

		// 1) 달 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.println(" ** 달을 입력하세요 ");
		int month = sc.nextInt();
		sc.close();

//		int day1 = 31, day2 = 30;
//		if (month >= 3 && month <= 5) {
//			switch (month) {
//			case 4:
//				System.out.printf(" %d월은 %d일 까지이며 ", month, day2);
//				break;
//			default:
//				System.out.printf(" %d월은 %d일 까지이며 ", month, day1);
//			}
//			System.out.println("봄 입니다");
//		} else if (month >= 6 && month <= 8) {
//			switch (month) {
//			case 6:
//				System.out.printf(" %d월은 %d일 까지이며 ", month, day2);
//				break;
//			default:
//				System.out.printf(" %d월은 %d일 까지이며 ", month, day1);
//			}
//			System.out.println("여름 입니다");
//		} else if (month >= 9 && month <= 11) {
//			switch (month) {
//			case 10:
//				System.out.printf(" %d월은 %d일 까지이며 ", month, day1);
//				break;
//			default:
//				System.out.printf(" %d월은 %d일 까지이며 ", month, day2);
//			}
//			System.out.println("가을 입니다");
//		} else if (month <= 2 || month == 12) {
//			switch (month) {
//			case 2:
//				System.out.printf(" %d월은 %d일 까지이며 ", month, 29);
//				break;
//			case 11:
//				System.out.printf(" %d월은 %d일 까지이며 ", month, day2);
//				break;
//			default:
//				System.out.printf(" %d월은 %d일 까지이며 ", month, day1);
//			}
//			System.out.println("겨울 입니다");
//		} else {
//			System.out.println("오류 입니다");
//		}

		// ======★switch활용한 간단식!==========//
		// 여러 case 결과 지정가능(최신버전)
		String s1, s2;
		switch (month) {
		case 1, 3, 5, 7, 8, 10, 12: s1 = "31";
			break;
		case 11, 9, 6, 4: s1 = "30";
			break;
		case 2: s1 = "29";
			break;
		default: s1 = "Error";
		}
		switch (month) {
		case 12, 1, 2: s2 = "겨울";
			break;
		case 3, 4, 5: s2 = "봄";
			break;
		case 6, 7, 8: s2 = "여름";
			break;
		case 9, 10, 11: s2 = "가을";
			break;
		default: s2 = "Error";
		}
		System.out.printf("%d월은 %s까지 있고, %s 입니다. \n ", month, s1, s2);

	} // main

} // class
