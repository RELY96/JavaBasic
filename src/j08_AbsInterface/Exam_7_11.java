package j08_AbsInterface;

//default매서드, static매서드 예제

interface MyInterface {
	default void method1() { /*default매서드*/System.out.println("method1() in MyInterface");} 
	default void method2() { /*default매서드*/System.out.println("method2() in MyInterface");}
    static void staticMethod() { /*static 매서드*/System.out.println("staticMethod() in MyInterface");}
} //MyInterface
//---------------------------------------------------------------//

interface MyInterface2 {
	default void method1() { /*default매서드*/System.out.println("method1() in MyInterface2");}
	static void staticMethod() { /*static 매서드*/System.out.println("staticMethod() in MyInterface2");}
} //MyInterface2
//---------------------------------------------------------------//

class Parent3 {
	public void method2() {System.out.println("method2() in Parent3");}
} //Parent3 (interface랑 관계X, Child3의 부모)

//---------------------------------------------------------------//

class Child3 extends Parent3 implements MyInterface, MyInterface2 {
	public void method1() {System.out.println("method1() in Child3");}
 } //Child3 (부모, 인터페이스 각자 상속중) -> 다 갖고 있음

//---------------------------------------------------------------//


public class Exam_7_11 {

	public static void main(String[] args) {
		Child3 c=new Child3(); /*Child3 주소 Child3 객체 인스턴스 c 생성 -> 다 포함하고 있으니까 다 부를 수 있음*/
		c.method1(); //child3 // Method1이라는 같은 이름 중 Child3꺼 부르기 가능( MyInterface, Child3 둘다 같은 명 있는데, '나'가 가까우니까)
		c.method2(); //Parent3 (디폴트 매서드와 조상클래스의 매서드 같은 이름 충돌 -> 조상 상속)
		
		/*static은 각각 생김*/
		MyInterface.staticMethod(); //스태틱한 호출방법 -> MyInterface의 static 매서드 소환
		MyInterface2.staticMethod(); // 이름은 같아도, static이라 위랑 다른 저장공간, 다른 매서드임!
	}

}
