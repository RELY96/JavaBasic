package j12_Exception;

import java.util.InputMismatchException;
import java.util.Scanner;

// 입력한 나이 체크 익셉션 만들기(음수 또는 200살 넘어가면 오류!)

//** AgeException 만들기1(Checked)
//1. 나이의 값이 범위를 벗어나면 Exception 발생
//2. 예외처리를 강제함(Exception을 상속) -> try ~ catch 처리하지 않으면 컴파일 오류 발생 

class AgeException extends Exception {
	private static final long serialVersionUID = 1L; //** 익셉션 상속을 받았기 때문에 내부적으로 처리하는 객체 직렬화를 일어나게 하기 위해 의무적으로 상수값 넣어줘야 함!
	
	AgeException () {
		super("나이가 범위를 벗어남"); // 조상(Exception)의 생성자 호출해서 입력하고 싶은 메세지 넣어주기 '=' Exception("범위를 벗어남");
	} //AgeException 생성자
} //AgeException

// ★AgeException 클래스 만든 이유? Exception 클래스 아래 다른 세부Exception 클래스들 상속이 되어 있어, Java프로그램 내에서 실행 시켜주기 때문
// 없는 익셉션을 만들어 불러 일으켜야 하니까, Exception안에 새로은 세부 AgeException을 만들어 준것뿐!

// 1. AgeException 클래스 만든 후 2. 매서드로 익셉션 발생 조건 만들어주고 3. main에서 떠넘겨받아 처리

//------------------------------------------------------------------------------------------//

public class Ex08_MyExceptionChecked {
	
	// 1. 나이 입력받는 매서드 만들기(나이 입력받아 리턴하는 매서드 -> int)
	public static int readAge() throws AgeException, InputMismatchException { //다중 떠넘기기 가능
		Scanner sc = new Scanner(System.in);
		
		System.out.println("* 나이를 입력하세요 *");
		int age= sc.nextInt(); //Int 니까 문자입력 시 input mismatch가 일어남=/=Integer변환으로 받으면 NumberFormat Exception 일어남! 
		sc.close();
		
		if (age < 1 || age > 200) { // age 오류 조건 -> age가 오류면 AgeException을 일으킨다
			throw new AgeException(); //익셉션 발생 -> but, try-catch 필요하니 매서드를 호출하는 애한테 맡기게 throws하기!
		} else return age; // 정상 나이면 나이 리턴	
	} //readAge
	
//------------------------------------------------------------------------------------------//		

	public static void main(String[] args) {
		try { //readAge() 호출할 메인에서 체크익셉션 처리해주기
			readAge();
		} catch (AgeException e) { // AgeException 또는 Exception 둘다 가능!
			System.out.println("* 입력한 나이가 비정상 입니다.*"+e.toString());
		} catch (InputMismatchException e) { // AgeException 또는 Exception 둘다 가능!
			System.out.println("* 숫자를 입력하세요 *"+e.toString());
		} catch (Exception e) { // AgeException 또는 Exception 둘다 가능!
			System.out.println("* 그냥 Exception *"+e.toString());
		} //catch
		
		 /*System.out.println("* main에서 실행 Age: *"+readAge());*/
		
		System.out.println("프로그램 종료");
	} //main
} //class
