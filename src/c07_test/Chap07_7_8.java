package c07_test;

class Outer5 {
	int value = 10;
	
	class Inner {
		int value=20;
		void method1() {
			int value=30;
			
			System.out.println("30 : "+value); //method의 value(method 안에 있기 때문에 그냥 value)
			System.out.println("20 : "+this.value); //inner(this)의 변수value
			System.out.println("10 : "+Outer5.this.value); //Outer5의 this(Outer)의 변수 value
		}
	} //Outer
} // Inner


public class Chap07_7_8 {
	
	public static void main(String[] args) {
		Outer5 out = new Outer5(); //외부클래스 인스턴스 생성
		Outer5.Inner inner = out. new Inner(); //이너클래스 인스턴스 생성
		
		Outer5.Inner inner2 = new Outer5().new Inner();
		
//----------------------------------------------------------------------------------//
		
		inner.method1(); //inner인스턴스의 메서드 출력해서 sysout나오게 하기 => 출력
		inner2.method1(); //간략 방법으로 inner2 출력
	} //main

} //class
