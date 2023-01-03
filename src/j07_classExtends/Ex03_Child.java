package j07_classExtends;

//** static import
// static import문 사용하면 static맴버 호출 시 클래스 이름 생략가능
import static j07_classExtends.Animal.color; 
//-----------------------------------------------------//

public class Ex03_Child extends Ex03_Father_main_args {
	// child가 father class 상속 -> 다 상속받아서 main에서 바로 father접근해서 실행 가능함

	String name; // child 이름
	int money;

	Ex03_Child() { // child default 생성자
		System.out.println("class child default constructor");
	}

	Ex03_Child(String fatherName, int fatherMoney, String myName, int myMoney) { // child 초기화용 생성자(father까지 초기화하는 생성자)
		super(fatherName, fatherMoney); // super로 초기화용 매개변수 전달
		this.name = myName; // 내 초기화용 매개변수 나한테 전달
		this.money = myMoney;

		System.out.println("class child 초기화 constructor");
	}

	// -----------------------------------------------------------//
	// final 붙여서 father 오버라이딩 금지 상태일때,
//	@Override //ctrl+space
//	public void bank(int money) {
//     // super.bank(money); 아버지껀 건들지 말고 내 재산만 불려주기
//		
//		this.money+=money*0.8;
//		money*=0.2;
//		super.bank(money); //아버지한테 용돈주기!(추가 기능)/private이라 super.money로 접근불가->super.bank()로 해줘야함
//		// (안에 수식넣으면 오류, 앞에서 수식해주면 됨)
//	}

	// 오버로딩은 상관없음!---------------------------------------------//
	public void bank(int money, int i) {
		this.money += money * 0.8;
		money *= 0.2;
		super.bank(money);
		// overloading하면 super.에 접근 가능하니까, super에 private해주는 게 좋음
	}
	// -----------------------------------------------------------//
	
	// super bank 에 static을 한다면? 같은 이름의 static매서드는 father bank따로, child bank 따로 각자 다른 값이 생성 -> 오버라이딩이 아님!
	// => 단, static매서드 안에서 인스턴스 this.super. 등은 허용X
//	public static void bank(int money) {}
	// -----------------------------------------------------------//
	@Override // 나만 출력위해 info(); 오버라이드
	public void info() {
		super.info(); // 조상까지 출력하려면 super.으로 꼭 불러줘야 출력됨!
		System.out.printf("* Child: country=%s,name=%s,money=%d\n", country, name, money);
	}
	// -----------------------------------------------------------//

	public static void main(String[] args) {
		Ex03_Child c1 = new Ex03_Child();

		c1.name = "홍길동";// 부모 클래스의 변수에 직접 값 지정(단, private은 직접 건들수 없음/protected면 가능)
		c1.bank(10000); // 자녀클래스에서 bank를 거쳐서 용돈 2:8로 나뉘어서 초기화됨
		c1.info();
		// "대한민국"은 이미 다른 클래스 main에서 실행 끝난거기 때문에, "대한민국"값은 이미 사라짐
		// 이 클래스에서 실행하면 default "Korea"가 나옴

		// -----------------------------------------------------------//
		Ex03_Child c2 = new Ex03_Child("홍길동", 100000, "김길동 헉!", 50000);
		c2.info(); // bank안 거쳐서 초기화X
		c2.bank(10000); // bank 걸기
		c2.info(); // bank로 초기에서 2:8씩 추가됨(-하면 다같이 -됨), father랑 child분리하려면 bank 매서드에 final붙이기
		
		// -----------------------------------------------------------//
		//★ ** static import Test
		System.out.println("** Animal class의 static import테스트: "+Animal.color); // 기존 static변수를 인스턴스에 불러오던 방법
		System.out.println("** Animal class의 static import테스트: "+color); // static import함
		
	} // main

} // class
