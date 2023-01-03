package j07_classExtends;

//super()-조상의 생성자,this()-내 클래스의 생성자 구분!

//** 상속 : extends
//=> 기능을 확장해서 업그레이드 버젼 만듦.
//=> 기존(조상) 클래스의 맴버들(필드와 메소드)을 재사용 & 일부변경도 가능 

//** 생성순서
// JVM은 extends 키워드가 있으면 조상생성 후 후손생성
// 이때 기본은 조상의 default 생성자를 실행하고,
// 특별히 후손 생성자에서 조상생성자_super(...)를 호출해 놓으면 그 생성자를 실행함.
// 상속을 허용하는 클래스는 default 생성자를 반드시 작성하는것이 바람직함.

//** 조상 : Super (Parent, Base) class  
// super.  : 조상의 인스턴스를 의미 (조상의 맴버에 접근 가능)
// super() : 조상의 생성자를 의미 (조상의 생성자에 접근 가능).
// this() 처럼 생성자 메서드 내에서 첫줄에 위치해야함.

//=> 생성자메서드_super(), this() 호출은 생성자 내에서만 가능 

//** 후손 : Sub ( Childed, Derived [diráivd] ) class > super class 를 포함

class Car {
	int speed;
	int mileage;
	String color;

	public Car(int speed, int mileage, String color) { // 초기화용 생성자
		super(); // 조상의 생성자 호출/따로 조상X -> object클래스가 조상
		// java는 기본적으로 object class를 상속받아 만들어지게 되어 있음
		this.speed = speed;
		this.mileage = mileage;
		this.color = color;
		System.out.println("** Car 초기화 생성자");
	}

	public Car() { // 기본 생성자
		super();
		System.out.println("** Car Default 생성자");
	}

	public void speedUp() {
		this.speed += 100;
	}

	// --------------------------------------------//
	@Override
	public String toString() {
		return "Car [speed=" + speed + ", mileage=" + mileage + ", color=" + color + "]";
	}
} // Car class

//===========================================================//

class SportsCar extends Car { // SportsCar 가 Car을 조상으로 상속
	int turbo;

	// ** super() : 조상의 생성자를 지정하지 않으면 조상의 default 생성자를 넣어줌->필요한 조상의 생성자 호출가능
	// 단, this() 와 마찬가지로 반드시 첫줄에 작성해야함.

	public SportsCar(int turbo) {
//	super(); // super()를 이용해서 조상의 생성자 호출가능
		super(1, 1, null); // SportsCar(int turbo)만 있어도 조상에 나머지 매개변수 있어서 지정한 매개변수대로 출력
		this.turbo = turbo;
		System.out.println("** SportsCar 맴버만 초기화 생성자");
	}

	public SportsCar() {
		super();
		System.out.println("** SportsCar Default 생성자");
	}

	@Override
	public String toString() {
		return "SportsCar [turbo=" + turbo + ", speed=" + speed + ", mileage=" + mileage + ", color=" + color + "]";
	}
	// @override : 덮어쓰는 거(상속의 관계에서 override 의 기능 : 조상의 매서드를 후손이 가져다 쓰며 다시 재정의 하는 것)
	// 이 override가 없어도 조상의 toString을 사용할 수 있음, 단, 조상도 toString이 없으면 주소값
	// 반환(sportsCar는 toString이 있는게 아니기 때문)
	// override의 조건 : 조상과 매개변수와 리턴이 같아야 함
	// override : 컴파일러에게 전달하는 지시어

	// ======================================================//
	// Car의 기능 + 추가기능 -> 기능 향상
	@Override // ctrl+space 조상의 오버라이드 선택해서 바로 불러올 수 있음
	public void speedUp() { // Car의 매서드 speedUp()
		super.speedUp(); // super. <- 조상의 speedUp()매서드 자동으로 호출
		super.speed += turbo; // 원래 있던 조상의 speedUp에서 turbo까지 추가 부여함
	}

	// => up하면서 down도 할 수 있는 신기능 추가
	// ※응용:매개변수 speed를 SportsCar의 speed, Car의 speed에 모두 적용한다.
	public void speedDown(int speed) {
		super.speed -= speed; //Car의 speed
		this.speed-=speed; //SportsCar의 speed
		System.out.println("** 매개변수 speed : "+speed);
		System.out.println("** Car speed : "+super.speed);
		System.out.println("** SportsCar speed : "+this.speed);
	}
	
	// ======================================================//

// ** 조상의 맴버를 초기화하는 후손 생성자
	public SportsCar(int speed, int mileage, String color, int turbo) {
		// this.speed = speed; // sportsCar의 맴버변수로 speed가 없기 때문에 조상에서 찾음 -> 오류는 아니지만
		// 바람직하지 않음

		super(speed, mileage, color);
		// 후손이 ★조상의 생성자를 불러서★ 조상의 맴버를 모두 초기화 하는 용도로 사용
		System.out.println("** 조상의 맴버와 현재 맴버 초기화");

		super.speed = speed; // ★this대신 super.으로 조상을 불러야 바람직함!!
		super.mileage = mileage; // 또는 super(speed, mileage, color); 이 제일 바람직
		super.color = color;
	}
} // SportsCar class

//== 클래스의 관계 : 상속 관계는 is의 관계라고 함, main class에서 다른 class 선언해서 사용하는 건 has의 관계 라고 함 ==//
//※상속을 이용 : 조상의 맴버와 현재 맴버 몽땅 초기화 가능

public class Ex01_CarTest {

	public static void main(String[] args) {
		// 1) Car 인스턴스 생성(조상)
		Car c1 = new Car(100, 10000, "white");
		c1.speedUp(); //speedDown을 쓸 수 X(undefined error)
		System.out.println("** Car c1 : " + c1);

		// 2) SportsCar 인스턴스 생성(후손)
		SportsCar sc1 = new SportsCar(500); // 후손 생성하려면, 후손 생성 전 시점에 조상 생성함
		// -> 뭔가 super로 지정을 해놓으면, 해당되는 조상의 생성자를 호출함/지정해놓지 않으면 기본적으로 default생성자 호출
		System.out.println("** SportsCar sc1 : " + sc1.toString()); // turbo초기화 되서 turbo만 나오고 나머진 초기화되지 않은 0, default값
																	// 출력
		// Car Default 생성자 먼저 출력된 이유: 후손 생성 시 1차로 조상을 생성함(조상 생성(조상의 기본 생성자) 먼저 -> 후손(자기)
		// 생성)
		// <- 조상이 먼저 생성되야 후손이 조상을 받아 쓸 수 있으니까!!!

		sc1.color = "Red"; // 조상의 변수에 접근해서 color red로 출력(별개의 인스턴스라 c1의 값은 변하지X, 상관X)
		System.out.println("** SportsCar sc1 : " + sc1.toString());

		// 3) 조상도 초기화, 나도 초기화 몽땅 초기화
		SportsCar sc2 = new SportsCar(300, 3000, "Blue", 9000);
		sc2.speedUp(); //override한 sportsCar의 speedUp
		sc2.speedDown(50); //추가기능 speedDown
		System.out.println("** sportsCar sc2: " + sc2);

	} // main

} // class

//==================================================//

// ** 메서드 오버라이딩  Overriding : 조상과 완전 동일한 이름, 매개변수, return Type 을 가진 메서드 작성허용
//    - 매서드 재작성 -> 우선 호출됨
//    - 조상 메서드 호출시 -> super 로 접근 (메서드 오버로드와 구별할 것!!)

//==================================================//
//super랑 this랑 구별!, 같은 이름인 경우 가까운 것부터 적용되기 때문에, 나=this. 조상=super.으로 접근해라
