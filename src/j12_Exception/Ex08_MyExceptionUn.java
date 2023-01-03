package j12_Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

class AgeExceptionUn extends RuntimeException { // AgeException 언체크
	private static final long serialVersionUID = 1L;

	AgeExceptionUn() {
		super("비정상 나이 입력-AgeExceptionUn");
	} // AgeExceptionUn 기본 생성자
} // AgeExceptionUn

//-----------------------------------------------------------------------------------//

public class Ex08_MyExceptionUn {
	public static int uncheckAge() /*throws AgeExceptionUn, InputMismatchException*/ { // main의 try에서 해당 메서드 호출 시 익셉션 처리하도록 떠넘기기(throws 안해도 상관X, 호출한 곳에서 매서드 처리하니까)
		Scanner sc = new Scanner(System.in);

		System.out.println("나이를 입력하세요");
		int age = sc.nextInt();
		sc.close();

		if (age < 1 || age > 150) throw new AgeExceptionUn(); // 나이 비정상이면 익셉션 발생
		else return age;
	} // uncheckAge

//-----------------------------------------------------------------------------------//	

	public static void main(String[] args) {
		// 1. 예외처리 적용하지 않은 경우 - 컴파일오류X, 런타임 오류O
		System.out.println("언체크 익셉션 try-catch 없이" + uncheckAge()); // -> 컴파일 에러 안뜸! But, try-catch 안하니까 런타임 에러남

//-----------------------------------------------------------------------------------//		
		// 2. 예외처리 적용한 경우
		
		try { // 런타임에러 방지위해 try-catch로 unchecked 익셉션 받아주기
			uncheckAge();
		} catch (InputMismatchException e) {
			System.out.println("숫자를 입력하세요" + e.toString());
		} catch (AgeExceptionUn e) {
			System.out.println("올바른 나이를 입력하세요" + e.toString());
		} catch (Exception e) {
			System.out.println("입력 오류" + e.toString());
		} // catch

		System.out.println("프로그램 종료");
	} // main
} // class
