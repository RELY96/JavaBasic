package c07_test;

class Outer {
	class Inner {
		int iv =100; // ** 이너클래스 안의 변수 iv 출력하기
	}
}

public class Chap07_7_6 {

	public static void main(String[] args) {
		Outer out = new Outer(); //Outer 클래스 인스턴스 생성
		Outer.Inner inner = out.new Inner(); //이너클래스 인스턴스 생성
		
		System.out.println("Inner 클래스 iv: "+inner.iv);
		
//간단 방법---------------------------------------------------------//
		
		Outer.Inner inner2 = new Outer().new Inner(); //한번에 생성
		
		System.out.println("Inner 클래스 iv: "+inner2.iv);
	} //main
} //class
