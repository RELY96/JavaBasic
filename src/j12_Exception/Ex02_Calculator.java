package j12_Exception;

import java.util.Scanner;

//** 실습
//=> 두개의 정수를 입력 받아 4칙연산(+,-,*,/) 결과 출력하기(입력 정수는 1 ~ 99 까지 허용)
// 1) 범위를 벗어난 값을 입력하면 정상 값 입력 할때까지 반복(ex: 정수가 아닐 때, 정수지만 1~99 아닐때)
// 2) 반복문 이용해서 *종료하고 싶을때까지 Test* / do while break; "종료"입력
// 3) nextLine() 으로 입력 받기

//** Scanner 사용시 주의 사항
//=> nextInt() , nextLine() 사용시 주의
// nextInt()는 개행문자 (\n) 가 뒤에 붙고, 숫자만 받아 처리한다. 
// 그래서 nextInt() 만 계속되면 문제가 없는데, 
// 뒤이어서 nextLine() 이 오면 앞 nextInt() 의 남겨진 enter 를 한줄로 인식 받아 버린다

//=====================================================================================================//

/* Scanner sc = new Scanner(System.in); int one,two; scanner 불러오기
 * 1) try-catch : 받은 scanner값이 int가 아니면 예외처리 catch되게 -> catch문구 뜬 후 다시 재입력 뜨게(while문 안에 try-catch) -> try안에는 정수만 오게 됨
 * 2-1) try 안 1~99 판단하고 결과 값 내는 if문 작성
 * 2-2) 정수1 입력받기 2-3) 정수 1이 1~99가 아니면 continue;로 진행 끊고 반복문 다시 처음부터 2-4) 정수1이 1~99면 계산식 출력
 * 3) 정수2 도 1과 동일
 * 
 * 4) 결과값 낸 후 종료할지 묻기(if(sc.nextLine())) / 즉시 sc.nextLine()으로 입력하고, Y or y로 비교할 수 있음 
 * 4-1) Y or y 입력하면 break; -> 반복문 바로 탈출!
 * 
 * 5) Y or y 입력 안하면 while문 다시 반복됨
 * 
 * ★★★ catch가 나온 후에 종료되는게 아니라, 다시 입력해야 하기 때문에 반복문 while안에 try-catch가 와야 하는 거임! */

//=====================================================================================================//

public class Ex02_Calculator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int one, two;

		System.out.println("* 계산기 프로그램 *");

//---------------------------------------------------------------------------------------------//	
		
		while (true) {
			try {
				System.out.println("정수 1 입력: "); // 정수 입력하는게 try를 통해 '정수'인지 확인해야함
				one = Integer.parseInt(sc.nextLine());

				// Tip: 첫번째 입력이 범위 초과하면 아예 안 받고 다시 입력하도록 처음부터 1~99 조건 설정!
				if (one < 1 || one > 99) {
					System.out.println("1: 1~99까지의 정수 中 입력하시오");
					continue; /*아래로 안가고 다시 catch 지난 후 while 첫 시작으로*/
				} //if_1
				
//---------------------------------------------------------------------------------------------//
				
				System.out.println("정수 2 입력: ");
				two = Integer.parseInt(sc.nextLine());
				
				if (two < 1 || two > 99) {
					System.out.println("1: 1~99까지의 정수 中 입력하시오");
					continue; /*아래로 안가고 다시 catch 지난 후 while 첫 시작으로*/
				} //if_2
				
//---------------------------------------------------------------------------------------------//
				
				// 1,2 지났으면 결과 출력
				System.out.println("ADD"+(one + two));
				System.out.println("MIN"+(one - two));
				System.out.println("MUL"+(one / two));
				System.out.println("MAL"+(one * two));

//---------------------------------------------------------------------------------------------//				
				
				// 계속 돌다가 내가 원할 때 종료하는 입력 만들기
				System.out.println("종료 하시겠습니까? (Y, y :종료)");
				if (sc.nextLine().toUpperCase().equals("Y"))
					break; //입력 받은 값(if 조건안에 입력문 다시 넣어줘서 바로 입력 가능)이 "Y"와 같으면 break로 프로그램 종료
			} // try
			
//---------------------------------------------------------------------------------------------//
			
			catch (NumberFormatException e) { // NumberFormatException(숫자가 아닌 정수 입력)
				System.out.println("정확하게 숫자만 입력하세요" + e.toString());
			} catch (Exception e) {
				System.out.println("Exception: " + e.toString());
			} // catch
		} // while
		sc.close(); //반복문 안에 닫아주면 안되고, 반복문 바깥에 sc닫아줘야 함
		System.out.println("* 프로그램 종료 *");
	} // main
	
} // class

// 반복문 안에 try-catch 오거나 try-catch 안에 반복문이 오거나 다 가능! (중첩구문 가능)
