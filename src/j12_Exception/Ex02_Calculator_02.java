package j12_Exception;

import java.util.Scanner;

//** 과제
//=> 두개의 정수를 입력 받아 4칙연산(+,-,*,/) 결과 출력하기(입력 정수는 1 ~ 99 까지 허용)
// 1) 범위를 벗어난 값을 입력하면 정상 값 입력 할때까지 반복
// 2) 반복문 이용해서 *종료하고 싶을때까지 Test*
// 3) nextLine() 으로 입력 받기

//=====================================================================================================//

// 1. 계산되면 안되는 거 :  값이 정수X(catch -> 다시 입력 반복 while(try-catch)) OR 정수지만 1~99 X (try)(다음 입력 진행X -> 다시 입력 반복)
// 2. 반복문- while(true)
// 3. 종료하고 싶을 때 break -> if(종료한다는 입력 이랑 그 입력이 종료인지 참,거짓 판단 들어가야함) {break;}-반복문 탈출-

public class Ex02_Calculator_02 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // 입력 준비
		int i, j; // sc로 입력받은 값 변수

		while (true) {
			try {
				// 1-1) 첫번째 입력
				System.out.println("* 1~99까지 정수 입력: ");
				i = Integer.parseInt(sc.nextLine()); // 입력 창 띄우고 입력한 걸 i에 넣어줌 (내가 문자를 넣었으면 int변환X -> catch로 감)

				// 1-2) 입력값 판단(1~99)
				
				if (i < 1 || i > 99) {
					System.out.println("* 1~99 사이 정수가 아닙니다 *");
					continue;
				}
			
				// 2-1) 두번째 입력
				System.out.println("* 1~99까지 정수 입력: ");
				j = Integer.parseInt(sc.nextLine());
				
				
				// 1-2) 입력값 판단(1~99)
				if (j < 1 || j > 99) {
					System.out.println("* 1~99 사이 정수가 아닙니다 *");
					continue;
				}
				
				// 3) 모든 조건 통과 시 계산 작동 후 출력
				System.out.println("더하기"+(i+j));
				System.out.println("빼기"+(i-j));
				System.out.println("나누기"+(i/j));
				System.out.println("곱하기"+(i*j));
				
				// 4) 출력 후 계속할지, 종료할지 판단
				System.out.println("종료 하시겠습니까? Y,y : 종료");
				if (sc.nextLine().toUpperCase().equals("Y")) {
					break; // Y누르면 break해서 반복문 탈출
				} //if		
			} catch (Exception e) {
				System.out.println("* 정수를 입력하세요 *"+e.toString()); // catch 나간 후 다시 while문 try 처음부터 시작
			} // catch
		} // while
		sc.close();
		System.out.println("프로그램 종료");
	} // main

} // class
