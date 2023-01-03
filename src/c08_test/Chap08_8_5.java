package c08_test;

// 코드 수행 시 실행결과 적기

public class Chap08_8_5 {

	public static void main(String[] args) {
		try {
			method1();
		} catch (Exception e) {
			System.out.println(5);
		} //catch
	} //main
	
//---------------------------------------------------//	
	
	static void method1() {
		try {
			method2(); 
			System.out.println(1);
		} catch (ArithmeticException e) {
			System.out.println(2);
		} finally {
			System.out.println(3);
		} //finally
		System.out.println(4);
	} //method1
	
//---------------------------------------------------//		
	
	static void method2() {
		throw new NullPointerException(); // exception 던지기 -> method1 에서 처리해줘야 함
	} //method2
	
} //class

//===================================================//

/* 1. method2에서 method1로 떠넘기며 try를 빠져 나올 때 finally 거치고 감
 * 3

 * 2. 떠넘겨 받은 method1에서 NullPointerException(); 예외처리 해주므로 catch로 감
 * 5*/
 