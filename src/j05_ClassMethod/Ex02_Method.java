package j05_ClassMethod;

//Class의 매서드에 대해?
//구조: ★매개변수 -> 매서드{기능, 실행문들} -> 리턴값

//** 맴버 메서드 (Method,답,동작,객체지향,기능들의 해결책) '=' 함수(Function), 프로시져(Procedure,절차지향)

//==================================================================//

//J06_  15,16 p
// 1) 정의 , 실행

// 2) return 값 : return 이 있으면 Type 을 지정(ex:)String), 없으면 무조건 void / 매서드에 type이 오면, 매서드 안에 문장에는 반드시 해당타입의 return이 있어야함 
// 2-1) 메서드 실행결과 "return Type에 해당하는 ★"결과값"을 제공
// 2-2) return 명령어를 void 메서드 에서 사용하면 void메서드 종료
//      (ex: return 10 은 오류, return 단독사용은 괜찮, 바로 종료) -> void 매서드의 return은 늘 끝에와야
// 2-3) void가 아닌데서 return을 단독으로 쓰면 오류 / return에 해당 타입을 꼭 붙여줘야함(ex:String매서드 -> return(String타입))

//-----------------------------------------------------------------//

//3) 매개변수 : 매개변수(Argument, 인자), Parameter
//=> 매개변수는 매서드의 지역변수이며, 모든타입 정의 가능
//★매개변수의 값 전달방법
// CallByValue (기본자료형, String -> 매개변수의 "값" 전달) //String은 예외: String은 주소의 값을 꺼내서 건내주는 것
// CallByReference (참조자료형: 배열, 인스턴스 -> "주소"전달 -> 주소안에서 바뀌면 다 바뀜)
// 매서드가 매개변수가 되는 건 불가


//** 기본자료형 : Primitive Data Type (int,double,boolean...)
//** 참조자료형 : Reference Data Type(클래스타입(String 등), 배열 등) 

//매서드명 : 소문자로 시작

public class Ex02_Method {

	// 1. 메서드 종류별 4종 정의
	// 2. return Test
	// => return 값 활용 (main 에서 Test)
	// => void 메서드 에서 사용 : 메서드 종료

	// 3. 매개변수 전달방법
	// => CallByValue (기본자료형, 매개변수의 "값 전달"됨)
	// => CallByReference (참조자료형, 주소값을 전달 -> 배열, 클래스(인스턴스))

	public int price = 5000; // 전역(맴버)변수

	// ** 매서드 생성 **
	// 1) 매개변수X, return값X
	public void juiceCafe1() {
		System.out.println("** 무슨 쥬스를 원하시나요 ? ");
	}

	// -----------------------------------------------------------------//

	// 2) 매개변수O, return값X
	public void juiceCafe2(String s, int n) { // 매개변수 넣으면서 선언 + "반드시 타입 지정"해야함(매개변수는 지역변수, 매서드 안에서만 사용 가능), n은 잔수
		if (n < 5) {
			System.out.printf("** 주문 오류 : %s, %d잔 \n", s, n); // 주문 오류라 출력 후 메서드 바로 끝냄 -> return
			return; // void니까 매서드 바로 끝남
		}
		System.out.println("** 주문 내용 **"); // 5잔 이상일 때 주문 내용출력 실행
		// -----CallByValue 값 전달하는 거 테스트
		s = "사과"; // <-String s값 변경 -> main에서 오렌지를 s에 전달했지만, 내부에서 s값이 사과로 바뀜
		System.out.printf(" : %s 쥬스, %d 잔 입니다. \n", s, n);
	} // juiceCafe2

	// -----------------------------------------------------------------//

	// 3) 매개변수X, return값O
	public String juiceCafe3() {
		return "쥬스 1잔은 " + price + "입니다."; // 리턴값 String
	}

	// -----------------------------------------------------------------//

	// 4) 매개변수O, return값O
	public int juiceCafe4(int n, String s) {
		System.out.printf(" : %s 쥬스, %d 잔 주문. \n", s, n);
		return n * price; // 리턴값 int(가격이니까 잔수 *위의 전역price)
	}
	
	// ====================================================//
	// 5) 참조자료형 매서드 Test
	// 매개변수O, return값O 경우
	public int carTest(Ex01_Car car, int speed) { //Ex01_Car car : 참조자료형 매개변수 -> 주소값 그대로 -> 호출 시 new해서 인스턴스 새로 만들어줘야함
		//인스턴스 안 만들어주면 호출할 수 없으니 해당 매개변수에 null 밖에 없음
		System.out.println("** car111 : "+car);
		
		car.color ="Pink";
		car.speed =speed; 
		System.out.println("** car222 : "+car); //변경 후
		
		System.out.println("** car.color : "+car.color);
		return car.speed+speed; //변경 후 5000+5000되니까 10000이 출력됨
	}
	

	// -----------------------------------------------------------------//

	// ====================================================//
	// ★매서드명이 같아도 매개변수가 다르면? 상관없음!
	public void juiceCafe1(int n) {
		System.out.println("** 매서드명 테스트_매개변수 int n 있음 : " + n);
	}

	// ====================================================//

	public static void main(String[] args) {
		// ** 매서드 호출
		Ex02_Method cafe = new Ex02_Method(); // 1)인스턴스 생성 => cafe.하면 매개변수 있는지 없는지 확인 가능
		String kind = "오렌지"; // 매서드 사용하기 위한 멤버변수 선언

		cafe.juiceCafe1(); // 2)매서드 호출
		cafe.juiceCafe1(123); // ★이름은 같아도 매개변수가 다른 매서드명 호출 => int매개변수를 1개 가진 juiceCafe1 매서드를 찾아 호출

		cafe.juiceCafe2(kind, 7); // kind매개변수, 7(잔)
		cafe.juiceCafe2("Banana", 3); // 이렇게 직접 타입에 맞는 매개변수 써넣어도 상관X, 3잔이니까 <5라서 return만나면 매서드 종료
		System.out.println("** main CallByValue_Test_kind: " + kind); // kind는 오렌지 찍지만, cafe.juiceCafe2는 사과찍음

		System.out.println(" main에서 cafe3 호출 : " + cafe.juiceCafe3()); // String 리턴하는 거니까 출력문 작성
		System.out.println(" main에서 cafe4 호출 : " + cafe.juiceCafe4(20, "딸기")); // 매개변수의 수와 타입, "순서"는 딱 맞아야함!
		// juiceCafe4 실행되고(안에sysout 실행)값을 리턴해서 sysout cafe4 호출
		
		// ====================================================//
		
		// ** 참조자료형 Test
		Ex01_Car myCar=new Ex01_Car(); //인스턴스 만들기, myCar의 주소 100번지
		
		//변경 전 호출
//		System.out.println(" main에서 Before Color : " + myCar.color()); //yellow
//		System.out.println(" main에서 Call carTest : " + cafe.carTest(myCar, 5000)); //매개변수 5000 return값
//		System.out.println(" main에서 After Color : " + myCar.color()); //yellow
		
		//변경 후 호출
		System.out.println(" main에서 Before car : " + myCar); //myCar전달, toString 생략 최초 100번지 갖는 비포형태
		System.out.println(" main에서 Call carTest : " + cafe.carTest(myCar, 5000));  //myCar의 "주소" 전달(똑같은 100번지 매서드로 이동)
		//매개변수 값 변경 -> 매서드 안에서 변경 시 똑같이 변경됨
		System.out.println(" main에서 After car : " + myCar); //매서드 100번지 지난 다음의 myCar 찍는 거 : 바뀐 상태로 찍게 됨 (5000(5000더 안 넣어 줬으니까),pink)
		
		// ====================================================//
		
		// ★인스턴스 생성 따로 하지 않고, 매개변수 위치에서 바로 new 인스턴스 생성 가능
		System.out.println("main에서 Call carTest2 :"+cafe.carTest(new Ex01_Car(), 5000)); //단, 인스턴스 이름이 없으니 일회성임
		
	} // main

} // class
