package j08_AbsInterface;

//** interface 3 : static, default 메서드 (구현부가 있는 메서드, Java8 부터 추가됨)
//** static(오버라이딩 적용불가<-각기 다른 매서드가 생성되는거임), default(오버라이딩 의무 없지만, 필요하다면 오버라이딩 구현 가능)
//=> 반드시 바디를 구현 해야함
//=> 구현클래스의 오버라이딩 의무 없음

interface NewInter { //interface에 static, default 매서드 넣으면 반드시 구현부를 넣어야되고, 해당 매서드는 후손들한테 구현 의무X
	void test(); //public abstract 생략
	
	/* static void staticTest(); -> static 구현부가 없어서 오류! */
	static void staticTest() { //static은 일반 클래스에서도 당연히 오버라이딩 안됨 -> interface도 마찬가지!
		System.out.println("** interface의 staticTest 매서드 **");
	}
	
	default void defaultTest() { //default는 interface에서만 허용됨(default 붙이는 거는 interface매서드 에만 허용)
		//1) 후손에 오버라이딩 의무 X,필요 시 가능함 
		System.out.println("** interface의 defaultTest 매서드 **");
	}
} //NewInter

//-----------------------------------------------------------------------------------//

class NewTest implements NewInter { //interface의 추상매서드 test()에 대한 구현 의무만 있음
	
	@Override
	public void test() {
		System.out.println("** NewTest의 test 매서드 오버라이딩(구현) **");
	}
	
	//============================================//
	
	//** default 매서드 오버라이딩(default매서드는 강제는 아니지만 필요하면 override 할수 있음)
	@Override
		public void defaultTest() {
			NewInter.super.defaultTest(); //1)
			// => 조상이 interface일 경우에 접근하는 방법 : ★형식 > 인터페이스명.super.defaultTest (단, 조상 interface에 있던 default없이 생성됨)
			System.out.println("** NewTest에서 defaultTest 매서드 오버라이드 **");
			// => 1) 로 인해 조상 defaultTest도 찍고, 내 sysout도 찍음 
		}
	
	//============================================//
	
	//** static 매서드 : 클래스 or interface에 종속되는 특징 때문에 static해서 똑같은 매서드를 만들면, 그 클래스에 해당되는 각각 다른 매서드가 생성된 꼴이다(오버라이딩 아닌 각각 생성!)
	// 클래스,인터페이스 종속일 땐 동일 메서드명 허용(static 또는 인스턴스 매서드 모두 가능!) But, 조상이 클래스인 경우에는 인스턴스 매서드 불가능
	
	static void staticTest() { 
		System.out.println("** NewTest의 staticTest 매서드 **");
	}
//	void staticTest() {  1번
//		System.out.println("** NewTest의 staticTest 매서드 : 동일한 이름의 인스턴스 매서드 허용**");
//	}	
} // NewTest

public class Ex04_StaticDefault {

	public static void main(String[] args) {
		// 1) NewTest 클래스 인스턴스 만들기
		NewTest n1 = new NewTest();
		
		n1.test(); //NewTest에서 추상매서드 test 구현한거라 NewTest 소속
		n1.defaultTest(); //NewInter 소속(★인스턴스로 접근)
		
		/*n1.*/ // staticTest는 static 매서드기 때문에, ★static으로 접근해야함(인스턴스 후 n1.해도 보이지 않음!)
		/*static한 접근 : */ NewInter.staticTest();
		NewTest.staticTest(); /* NewInter.staticTest(); 랑은 아예 다른 매서드! */
		n1.staticTest(); //1번
		
		// 2) NewTest클래스 Interface 타입으로 생성
		NewInter n2 = new NewTest(); // 1)인터페이스에 정의된 범위만큼만 접근 가능 NewTest의 staticTest()매서드는 접근 불가
		n2.defaultTest();
		n2.test();
	} //main

} //class
