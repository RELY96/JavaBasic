package j03_forWhile;

//Random 범위 넘으면 재입력까지 반복하고 메달 결과 내는 연습문제

import java.util.Random;
import java.util.Scanner;

public class Ex04_RandomGame {

	public static void main(String[] args) {
		// 1) Random Number 구하기
		Random rn = new Random();
		int r = rn.nextInt(10) + 1;

		Scanner sc = new Scanner(System.in);
		int input;
		
        //do-while로
		do {
			// 2) myNumber 구하기(범위 넘으면 계속 입력)
			System.out.println(" 1~10까지의 정수를 입력하세요 ");
			input = sc.nextInt();

			if (input >= 1 && input <= 10) {
				sc.close();
				break;
				}
			else System.out.printf("입력값: %d : 1~10까지 재입력 하세요", input);
		} while (true);
		
		// 방법1) while로
//		while (true) {
//			System.out.println(" 1~10까지의 정수를 입력하세요 ");
//			
//			if (input >= 1 && input <= 10) {
//				sc.close();
//				break;
//				}
//			else System.out.println("재입력 하세요");
//		}
		
		//===============================================//
		// 방법2) 좀 더 심플하게 하려면? -> do-while : 한번은 입력을 받고 조건if(input >= 1 && input <= 10) 실행
		// : while(true)에 true대신 계속 돌아가는 1미만, 10초과 조건 넣어주면 계속 돌아감!!★★
		do {
			System.out.println(" 1~10까지의 정수를 입력하세요 ");
			input = sc.nextInt(); 
			// count 하나를 지정해서 count가 2가 되면 잘못 입력 나오게 만들 수도 있음
		} while (input <1 || input>10); //오류 조건을 반복문의 조건으로 이용★

		//===============================================//
		// 3) 결과처리
		int abs = Math.abs(input - r);
		
		System.out.printf("랜덤값: %d 입력값:%d 차:%d \n", r, input, abs);
		switch (abs) {
		case 0:
			System.out.println("금메달");
			break;
		case 1:
			System.out.println("은메달");
			break;
		case 2:
			System.out.println("동메달");
			break;
		default:
			System.out.println("꽝");
		}

	} // main

} // class
