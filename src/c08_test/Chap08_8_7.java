package c08_test;

import java.util.InputMismatchException;

// 예외처리해서 숫자 아닌 값 입력 시 다시 입력 하도록
// 1. do-while문 안에 try-catch가 들어가야, 예외처리 catch 후 다시 처음부터 반복

import java.util.Scanner;

public class Chap08_8_7 {

	public static void main(String[] args) {
		// 1~100 사이의 임의 값을 얻어서 answer에 저장한다.
		int answer = (int) (Math.random() * 100) + 1; // 1~100 중 랜덤 출력 값 answer
		int input = 0; // 사용자 입력 저장할 공간
		int count = 0; // 시도횟수
		
		do {
			try {
				count++; //일단 시작하고 보니까 count 첫회차 +1 됨 -> 실패해서 break 안되면 다음 회차
				System.out.print("1과 100 사이의 값을 입력하세요: ");
				input = new Scanner(System.in).nextInt(); //nextInt로 바로 scanner 받기
				//input이 정수가 아닐 때 오류가 나는 거기 때문에, Scanner 입력받는 걸 try안에 넣어서 오류확인 가능 => 굳이 모든 문을 try-catch안에 안 넣고 짧게해도됨!

				if (answer > input) {
					System.out.println("더 큰 수를 입력하세요");
				} else if (answer < input) {
					System.out.println("더 작은 수를 입력하세요");
				} else {
					System.out.println("맞췄습니다");
					System.out.println("시도 횟수"+count+"번 입니다.");
					break;
				}
			} catch (InputMismatchException e) { //**답!!**
				System.out.println("정수를 입력하세요"+e.toString());
			} catch (Exception e) { 
				System.out.println("에러입니다."+e.toString());
			} //catch
		} while (true); //do-while문
		System.out.println("프로그램 정상 종료");
	} //main
} //class
