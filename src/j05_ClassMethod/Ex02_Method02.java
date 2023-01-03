package j05_ClassMethod;

public class Ex02_Method02 {

	int price = 5000;

	// ** 매서드 생성 **
	// 1) 매개변수X, return값X
	public void juiceCafe1() {
		System.out.println("** 무슨 쥬스를 원하시나요 ? ");
	}

	// -----------------------------------------------------------------//

	// 2) 매개변수O, return값X
	public void juiceCafe2(String s, int n) { 
		if (n < 5) {
			System.out.printf("** 주문 오류 : %s, %d잔 \n", s, n); 
			return;
		}
		System.out.println("** 주문 내용 **"); 
		// -----CallByValue 값 전달하는 거 테스트
		s = "사과"; 
		System.out.printf(" : %s 쥬스, %d 잔 입니다. \n", s, n);
	} // juiceCafe2

	// -----------------------------------------------------------------//

	// 3) 매개변수X, return값O
	public String juiceCafe3() {
		return "쥬스 1잔은 " + price + "입니다."; 
	}

	// -----------------------------------------------------------------//

	// 4) 매개변수O, return값O
	public int juiceCafe4(int n, String s) {
		System.out.printf(" : %s 쥬스, %d 잔 주문. \n", s, n);
		return n * price; 
	}
	
	// ====================================================//
	// 5) 참조자료형 매서드 Test
	// 매개변수O, return값O 경우
	public int carTest(Ex01_Car car, int speed) { 
		
		System.out.println("** car111 : "+car);
		
		car.color ="Pink";
		car.speed =speed; 
		System.out.println("** car222 : "+car);
		
		System.out.println("** car.color : "+car.color);
		return car.speed+speed;
	}
	

	// -----------------------------------------------------------------//

	// ====================================================//
	// ★매서드명이 같아도 매개변수가 다르면? 상관없음!
	public void juiceCafe1(int n) {
		System.out.println("** 매서드명 테스트_매개변수 int n 있음 : " + n);
		System.out.println("매서드 재귀 호출 테스트 :");
		juiceCafe1(); //1. ★재귀적 호출(나 매서드에서 '나' 매서드를 호출하는 것!)
		//4. non-static 메서드에서는 static, non_static 멤버 모두 인스턴스 없이 접근 가능함!!! => 그래서 매서드끼리 서로 호출가능 한 것
	}

	// ====================================================//

	public static void main(String[] args) { //2. static이 붙어있는 매서드는 static이 안붙은 매서드를 그냥 호출 못함 : 그래서 인스턴스 생성 하는 것 <-static없던 매서드를 static으로 정의하면 static 매서드에 호출가능
		// 3. static 매서드에서 non_static 맴버 사용하려면 인스턴스 생성 해야함(같은 클래스일 경우, 다른 클래스면 당연히 인스턴스 생성 해줘야함)
		// ex) price=10000;은 오류, 인스턴스 생성 후 cafe.price=10000;으로 매서드 꼭 써줘야 함
		Ex02_Method02 cafe = new Ex02_Method02(); 
		String kind = "오렌지"; 

		cafe.juiceCafe1(); 
		cafe.juiceCafe1(123);

		cafe.juiceCafe2(kind, 7); 
		cafe.juiceCafe2("Banana", 3); 
		System.out.println("** main CallByValue_Test_kind: " + kind); 

		System.out.println(" main에서 cafe3 호출 : " + cafe.juiceCafe3()); 
		System.out.println(" main에서 cafe4 호출 : " + cafe.juiceCafe4(20, "딸기")); 
		
		// ====================================================//
		
		// ** 참조자료형 Test
		Ex01_Car myCar=new Ex01_Car();
		
		//변경 후 호출
		System.out.println(" main에서 Before car : " + myCar); 
		System.out.println(" main에서 Call carTest : " + cafe.carTest(myCar, 5000));

		System.out.println(" main에서 After car : " + myCar);
		
		// ====================================================//
		
		System.out.println("main에서 Call carTest2 :"+cafe.carTest(new Ex01_Car(), 5000));
		
	} // main

} // class
