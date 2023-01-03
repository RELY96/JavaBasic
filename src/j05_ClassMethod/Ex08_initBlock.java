package j05_ClassMethod;

// 1. 초기화 블럭(클래스에 초기화 블럭 만들어서 초기화 할 수있음)

//** 맴버 변수 초기화
//=> 선언과 동시에 초기화 (간단한 경우): 명시적 초기화(explicit initialization) 
//=> 초기화블럭 또는 생성자(복잡한 경우) 

//** 수행순서
// 프로그램 로딩-> 클래스(static)초기화블럭 저장->
// -> main 메서드실행 -> 인스턴스 생성 (new) -> 인스턴스초기화 블럭완성 -> 디폴트생성자 생성 -> 생성자 실행
// 그러므로 인스턴스 초기화 블럭은 인스턴스 생성시마다 실행 됨

// ※우선순서※
// 1. static
// 2. 인스턴스(new로 인해 생성되서)
// 3. 생성자(new 뒤 생성자 생성으로 인해 실행되서)

public class Ex08_initBlock {
	// ** 초기화블럭
	// => 초기화 하는데 코드가 필요한 경우 작성 가능 : 실행문 작성 가능

	{ // 매서드, 생성자 아무것도 없이 걍 블럭으로 묶기만 한 블럭도 맴버로 클래스안에 올 수 있음
		// <- 변수 초기화 등에 사용(초기화 하는데 코드가 필요한 경우) <= {}안에 실행문이 옴
		System.out.println("** 실행문 작성 Test : 실행문은 class에 직접 작성 불가능, 블럭안에는 작성 가능");
		System.out.println("** 인스턴스 (변수)초기화 블럭 **");
		System.out.println("형식 > {   }");
		// <실행3>
	}

	static { // static변수 초기화 블럭 <실행1>
		System.out.println("** static (변수)초기화 블럭 **");
		System.out.println("형식 > {   }");
	}

	// -------------------------------------------------//

	// ** 생성자 초기화(★인스턴스보다 뒤에 실행)
	Ex08_initBlock() { // <실행4>
		System.out.println("**default 생성자**");
	}

	// ================================================//

	public static void main(String[] args) { // <실행2>
		System.out.println("** main Start **");

		System.out.println("** new ex08_1 인스턴스 생성 **"); // 실행2까지 해당
		Ex08_initBlock ex08_1 = new Ex08_initBlock(); // 인스턴스 생성, 생성자 default로 제공됨
		// ★new할 때 인스턴스 블럭{}으로 이동해서 인스턴스 블럭 출력
		// new하면서 인스턴스 공간 만들고, 해당 클래스에서 초기화 해야할 게 있으면 저장공간에 비치해놓음
		// 그 뒤(new 다음) Ex08_initBlock();생성자 와서 default 생성자 생성됨

		System.out.println("** new ex08_2 인스턴스 생성 **");
		Ex08_initBlock ex08_2 = new Ex08_initBlock();
		// 또 new할 때 인스턴스 블럭{}으로 이동해서 인스턴스 블럭 또 출력

		// ★ new할 때 마다 새로운 Ram에 새로운 공간 생성됨! -> 변수초기화 먼저 비치하고, 그 뒤 생성자 생성

	} // main

} // class
