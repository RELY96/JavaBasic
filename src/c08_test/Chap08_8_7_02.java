package c08_test;

import java.util.InputMismatchException;

// 예외처리해서 숫자 아닌 값 입력 시 다시 입력 하도록
// 1. do-while문 안에 try-catch가 들어가야, 예외처리 catch 후 다시 처음부터 반복

import java.util.Scanner;

public class Chap08_8_7_02 {

	public static void main(String[] args) {
		int answer = (int) (Math.random() * 10) + 1;
		int input = 0;
		int count = 0;

		do {
			count++;
			System.out.print("1과 100 사이의 값을 입력하세요: ");

			try {
				input = new Scanner(System.in).nextInt();
			} catch (InputMismatchException e) {
				System.out.println("정수를 입력하세요" + e.toString());
				continue; //★반복문 아래 실행 안하고 다음 반복문으로 넘어가게!
			} catch (Exception e) {
				System.out.println("에러입니다." + e.toString());
				continue;
			}
			if (answer > input) {
				System.out.println("더 큰 수를 입력하세요");
			} else if (answer < input) {
				System.out.println("더 작은 수를 입력하세요");
			} else {
				System.out.println("맞췄습니다");
				System.out.println("시도 횟수" + count + "번 입니다.");
				break;
			}
		} while (true); // do-while문
	} // main
}// class

//close 하기 위해서는 Scanner를 인스턴스로 전역으로 해줘서 close로 닫아주는 게 바람직
