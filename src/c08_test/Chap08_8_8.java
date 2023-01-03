package c08_test;

// 실행결과 적기 (new throw로 익셉션 발생 시키고, throw e로 나를 호출하는 매서드에서 바로 exception e 매개변수로 가는 것 주의)

public class Chap08_8_8 {

	public static void main(String[] args) {
		try {
			method1(); // 4. throw e -> catch블록으로 바로 감
			System.out.println(6);
		} catch (Exception e) { // *3) 7출력
			System.out.println(7);
		} // catch
	} // main

//------------------------------------------------------//		

	static void method1() throws Exception {
		try {
			method2(); // 1. NullPointerException 익셉션 발생
			System.out.println(1);
		} catch (NullPointerException e) { // 2. NullPointerException catch 실행
			System.out.println(2); // *1) 2 출력
			throw e; // 3. method1() 호출한 상위 매서드에서 Exception e 로 감(catch로 감)
		} catch (Exception e) {
			System.out.println(3);
			throw e;
		} finally { // *2) method1 빠져나가기 전, try-catch 나갔으니 finally 들렀다감 4출력
			System.out.println(4);
		} //finally
		System.out.println(5);
	} // method1

//------------------------------------------------------//	

	static void method2() {
		throw new NullPointerException(); // 1. NullPointerException 익셉션 발생
	} // method2

} // class

//======================================================//

/* *1) 2
 * *2) 4
 * *3) 7 */
