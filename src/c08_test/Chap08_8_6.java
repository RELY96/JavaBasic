package c08_test;

//System.exit(0) => finally 도 거치지 않고 프로그램 종료!!!

public class Chap08_8_6 {
	static void method (boolean b) {
		try {
			System.out.println(1);
			if(b) System.exit(0);
			System.out.println(2);
		} catch (RuntimeException r) {
			System.out.println(3);
			return;
		} catch (Exception e) {
			System.out.println(4);
			return;
		} finally {
			System.out.println(5);
		} //try-catch-finally문
		System.out.println(6);
	} //method
	
//-------------------------------------------------//
	
	public static void main(String[] args) {
		method(true);
		method(false);
	} //main
} //class

//-------------------------------------------------//

/*
 * 1
 * -> true : if b가 true면 시스템 종료!(finally도 안 거치고 바로 종료하니 1만 남음)
** 매서드 종료가 아닌 "프로그램 종료"라 다음 false 매서드도 실행 안하고 아예 종료!*/

