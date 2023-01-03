package c08_test;

public class Chap08_8_4 {
	static void method(boolean b) {
		try {
			System.out.println(1);
			if(b) throw new ArithmeticException(); //참이면 예외 생성한다는 뜻!! 참이면!!
			System.out.println(2);
		} catch (RuntimeException r) {
			System.out.println(3);
			return; // void의 return은 매서드 바로 끝냄
		} catch (Exception e) {
			System.out.println(4);
			return;
		} finally {
			System.out.println(5);
		} //fially
		System.out.println(6);
	} //method
	
//========================================================//	

	public static void main(String[] args) {
		method(true);
		method(false);
	} //main
} //class


// 실행 결과 :
/*
 * 1
 * 3
 * 5 
 * -> true (if (true)일 때 예외 생성 이니까 예외로 갔다가 return 바로 끝냄)
 *
 * 1
 * 2
 * 5
 * 6
 * -> false*/
