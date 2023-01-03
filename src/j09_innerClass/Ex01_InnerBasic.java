package j09_innerClass;

import j07_classExtends.Ex02_Animal;

//** 클래스 맴버 : 맴버(전역)변수, 메서드 : 생성자, main, setter/getter, toString, 일반메서드
// 추가 : 내부(inner) 클래스 : 클래스 내부에 다른 클래스를 정의
// 내부클래스는 외부클래스의 멤버이다!

//** Inner Class 기본형식과 특성

class OuterClass { //외부클래스(일반클래스)
	// 1) 맴버(전역)변수
	int age =100;
	private String name="홍길동";
	static String grade = "A++";
	
	// 2) 생성자, 그외 메서드 : main, setter/getter, toString, 일반메서드 ..
	OuterClass(){
		System.out.println("**OuterClass default 생성자 **");
	}
	
//==================================================================//
	
	/*innerClass와 비교용*/ Ex02_Animal animal;
	// 다른 패키지 public 클래스 자동임포트됨 => 맴버변수로 클래스를 사용 가능하다(has-a의 관계) 
	// => 재사용성이 많을 때, 클래스 단위로 미리 만들어놓고 has관계로 사용 =/= innerClass
	
//-----------------------------------------------------------------//
	
	// 3) 클래스(내부클래스)
	// => 외부(outer) 클래스 의 ★모든맴버(private 포함) 에 접근 가능
	// => 재사용성X, 여기서만(현재 외부클래스) 필요할 경우
	
	/*static : static 내부클래스 -  내부 클래스가 static 변수를 사용하려면, 해당 내부 클래스도 static 이어야함
    단, JavaSE-16 부터는 일반내부 클래스도 static 변수 허용함*/
	class Inner {
		Inner () {System.out.println("**Inner Class default 생성자 **");}
		
		public void printData() {
			System.out.println("**Inner printData에서 outerclass 맴버 접근 - age : "+age); //outer클래스의 변수에 다 접근
			System.out.println("**Inner printData에서 outerclass 맴버 접근 - name : "+name);
			System.out.println("**Inner printData에서 outerclass 맴버 접근 - grade : "+grade/*static변수*/);
			
			/*static String country ="Korea"; InnerClass에서 static 변수쓰려면 해당 InnerClass도 static이어야 함*/
			String country ="Korea";
			
		} // printData 매서드
	} //Inner
} // OuterClass

public class Ex01_InnerBasic {

	public static void main(String[] args) {
		// ** InnerClass Test : ★outerclass 생성을 통해 innerclass 사용할 수 O
		/*1.*/OuterClass out1 = new OuterClass(); /*OuterClass만 생성 -> OuterClass에 있는 것만 접근 가능(이너 접근 불가!)*/
		
		/*InnerClass도 생성을 해야 사용할 수 있음(Inner는 Outer에 종속되있어서)Inner inner1 = new Inner();<-오류*/
		/*2. 맞는 이너클래스 호출방법: */OuterClass.Inner inner1 = out1.new Inner();
		
		inner1.printData(); // innerClass 이제 쓸 수 O
		
		//-----------------------------------------------------//
		
		/*3.InnerClass 빠르게 직접 생성하기: 한줄로 넣어준다 생각하면 됨*/
		OuterClass.Inner inner2= new OuterClass().new Inner();/*outerclass 기본생성자.innerclass 기본생성자*/
		inner2.printData();
		
		//====================================================//
		
	    // ** static 맴버 Test(OuterClass/InnerClass)
		System.out.println("** OuterClass.grade => "+OuterClass.grade); /*static 접근방법*/
	/*System.out.println("** Inner country => "+OuterClass.Inner.country); -> innerClass의 static변수 static한 접근방법*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} //main

} //class
