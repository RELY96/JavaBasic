package j07_classExtends;

import java.util.Arrays;

// 종속 한번 더 연습

public class Ex03_Father_main_args {

	// 1. 맴버변수 정리
	static String country = "Korea";
	String name;
	private int money;// 재산 int private

//------------------------------------//

	// 2. 생성자(default, 초기화용) 만들기
	Ex03_Father_main_args() {
		System.out.println("class father default constructor");
	}

	Ex03_Father_main_args(String name, int money) {
		this.name = name;
		this.money = money;

		System.out.println("class father 초기화 constructor");
	}

//------------------------------------//

	// 3. 매서드 만들기(bank에 final, private,static 다 붙여봤었음!)
	public void bank(int money) { // 재정관리(저축) 매서드 만들기
		this.money += money; // money 저축
		System.out.println("Father money : " + this.money);
	}

	public void info() { // 출력하는 toString 매서드 만들기
		System.out.printf("* Father: country=%s,name=%s,money=%d\n", country, name, money);
		// 아버지의 기본 정보 출력
	}

// 2. main 매서드 오버로딩 test ===================================//
// 허용은 되지만, ★바람직하지는 않음!!!
//	public static void main(String name, int money) {
//		System.out.printf("* main오버로딩 Test %s:돈:%d\n", name, money);
//	}

//============================================================//

	public static void main(String[] args) {
		// 1. main은 클래스를 주 실행하는 실행자기 때문에, 실행시작부터 끝까지 메모리에 남아있는 static이어야 함+연산의 결과를 제공한다거나
		// 하는 역할이 아니고, 실행하는 역할이기 때문에 리턴은 void여야함+public
		// main의 매개변수를 String[]타입의 배열로 만들어놓은것(메인에 값을 전달하고 싶을때 사용하라고 존재,main에 매개변수가 올수도
		// 있음)+arg는 범위 미정

		// ** main 매개변수 Test(args 활용) : 실행 시 전달 - argument 띄어쓰기로 구분//
		System.out.println("main parameter args 확인 : " + Arrays.toString(args));// string타입 배열 args 출력

		// ★★ main에 매개 변수 배열형태로 전달하는 법 : Run Configurations 눌러서 argument, 띄어쓰기로 구분해서 넣기

// ★3. main매서드 오버로딩 호출해보기(Data 테스트용으로 parameter 전달받아 많이 사용)
//		main("main오버로딩Test",12345);
		
//복습=========================================================//		
		Ex03_Father_main_args father1 = new Ex03_Father_main_args("홍길동", 10000);
		father1.bank(5000); // bank 매서드로 money값 바뀜
		father1.info(); // 아빠 정보 출력

//새 인스턴스 생성(인스턴스 주소가 다르니 값이 father1과 다름)-------------//

		Ex03_Father_main_args father2 = new Ex03_Father_main_args("김길동", 5000);
		country = "대한민국";
		// static변수 바로 접근해서 수정 가능 -> 클래스에 있는 딱 하나의 static값이 "대한민국"으로 바뀜
		father2.bank(-10000);
		father2.info();

		// -----------------------------------//
		// static 대한민국으로 바꾼 후 출력
		father1.info();
		father2.info();

	}// main

}// class
