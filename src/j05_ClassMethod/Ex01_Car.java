package j05_ClassMethod;

//class 만들 때 main체크X, main없는 클래스(객체){전역 변수(속성)와 전역 메서드(기능)으로 이루어짐(멤버)} / 클래스 안에는 멤버(변수,메서드) "만!" 올 수 있음

public class Ex01_Car {
	// ** 맴버변수, 필드(field) : 속성
	// => 클래스의 전역변수
	// 클래스내에서는 모든 메서드에서 사용가능
	public int speed; // 1. 타입 앞에 public 붙여서 멤버변수(속성,전역)선언 -> 클래스 내부에서는 어디든지 사용 가능!
	public int mileage;
	public String color = "Yellow"; // 변수 선언하며 바로 초기화도 가능, 나중도 가능 But, ★변수 값 변경(기능)은 메서드 안에서만 가능해짐

	// 지역변수에서는 초기화해야 사용가능하지만, ☆전역변수에서는 반드시 초기화하지 않아도 됨!

	// 2. 멤버메서드(== function,Method,procedure) => 동작 또는 기능 구현
	public void speedUp() { // void 자리는 리턴 값의 타입이 오는 자리, 타입 없으면 void로 비워놓으면 됨, speedUp은 함수명 같은 이름(메서드명)!
		speed += 10; // 전역변수 speed 가 +=10;
		System.out.println("** speed :" + speed);
		// ★sysout 등 실행문은 메서드 안에서만 올 수 있음!, 기능(동작)이니까 메서드{}안에만 가능
		
		// ** 지역변수 : 메서드 내부에서 선언해서 사용하는거(메서드 내부에서만 사용 가능), 전역변수와 동일명 가능, ★내부에서는 지역변수가 우선!
		int price=1000;
		String color = "Blue";
		System.out.printf("** price: %d, color: %s" , price, color); //지역 나가면 color는 yellow로 변함
		System.out.println();
	}

	public void speedDown() {
		speed -= 10;
	}

	// toString (메서드명) : '객체의 속성(맴버필드,맴버변수) 의 값'을 / '문자로 제공'하는 역할에 주로 사용됨
	// String (return Type) : 문자열을 반환(return) -> 메서드 처리 결과로 문자열을 제공
	public String toString() { // void자리에 스트링 -> 스트링으로 값 리턴하겠다는 뜻 / toString 은 String으로 출력하는 메서드
		return "[속도:" + speed + ", 주행거리:" + mileage + ", 색상" + color + "]"; // 배열 모습으로 String형식으로 return하기
	}
	
	// 사용자클래스 메서드명은 main으로 정해져 있음 => public static void main {}
	// 메서드명은 내가 임의로 만드는 건데, toString처럼 역할에 따라 정해져있는 메서드명이 있음 ->
	// 이런 메서드명은 메인 클래스 호출 시 생략해도 가능!(그래도 toString으로 출력됨)<-자바object에 자체적으로 있으니까
	// But, toString메서드가 "객체 클래스에 없으면" 메인 클래스에서는 주소값 toString으로 변환되지 않고 주소값 반환됨

} // class
