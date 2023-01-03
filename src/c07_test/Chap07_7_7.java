package c07_test;

class Outer1 {
	static class Inner1 {
		int iv =200; //static 내부 클래스의 인스턴스
	} //Inner
} //Outer

public class Chap07_7_7 {

	public static void main(String[] args) {
		// Outer클래스 속 static Inner class static하게 접근

		Outer1.Inner1 in = new Outer1.Inner1(); // 스태틱 내부 클래스 바로 인스턴스 생성
		System.out.println(""+in.iv); //"스태틱" 내부 클래스 속 인스턴스 맴버는 Outer1의 인스턴스를 먼저 생성하지 않아도 됨
		
		// => static : 저장공간에 static이 남아있기 때문에, 굳이 outer먼저 생성 안하고 스태틱한 방법으로 inner 생성 후, inner에 접근 할 수 O
	} //main
} //class
