package j08_AbsInterface;

// ** 추상클래스

// 1) 추상 매서드를 하나라도 가지면 추상매서드로 정의해야함
// 2) 추상클래스의 후손에 추상매서드 구현 의무(override)있음
// 3) 반드시 abstract를 붙여줘야 함

abstract class Animal {
	String kind;

	Animal() { // default생성자 강제로 넣어보기
		// 1) 강제로 넣어도 error는 안나지만, 추상클래스 인스턴스 생성이 가능해지는 것은 아님!!
		System.out.println("* Animal default 생성자");
		// ★추상클래스도 후손이 생성될 때 조상이 생성되며 인스턴스 참조됨(추상클래스의 직접 인스턴스는 안되지만, 간접 조상 인스턴스는 load되서 Animal default 생성자가 출력됨)
	}

	void breath() {// 아무것도 입력하지 않아도, {}body가 있음 <- 추상매서드X!!!, 후손의 구현 의무X
		System.out.println(kind + "는 숨을 쉽니다.");
	}

	// 추상 매서드(abs) : 일반 매서드 형식과 같은데, abstract를 붙여줌(해당 클래스에도 붙여줘야함!)
	abstract void sound();
	
	// 11번 : 각각 후손의 추상 매서드 일원화 시켜서 관리해보기
	abstract void special();
}

//---------------------------------------------------//

class Cat extends Animal { // 후손 클래스가 반드시 조상의 추상매서드를 구현해야 함!!!(ctrl+space 하면 제일 우선순위로뜸(A))
	Cat() { // default 생성자
		kind = "고양이";
		System.out.println("* Cat default 생성자");
	}

	@Override
	void sound() { // 조상의 추상 매서드를 override한 매서드
		System.out.println("미야옹 미야옹 웁니다.");
	}

	void eyeColor() { // 일반 매서드
		System.out.println("눈은 금색입니다.");
	}
//special 추상매서드 일원화 하기-------
	@Override
		void special() {
		System.out.println("눈은 금색입니다.");			
		}
} // Cat

//---------------------------------------------------//

class Dog extends Animal {
	Dog() {
		kind = "강아지";
	}

	@Override
	void sound() {
		System.out.println("멍멍 웁니다.");
	}

	void speed() {
		System.out.println("잘 달립니다.");
	}
//special 추상매서드 일원화 하기-------
	@Override
	void special() {
		System.out.println("잘 달립니다.");
	}
} // Dog

//---------------------------------------------------//

class Eagle extends Animal {
	Eagle() {
		kind = "독수리";
	}

	@Override
	void sound() {
		// System.out.println("까아악하고 웁니다"); -> 만약 추상매서드 구현하고 싶지않을때, 블럭 안 비워놓으면 됨
		// 반드시 추상매서드 작성은 해야하므로!(의무구현)
	}

	void flying() {
		System.out.println("잘 날라다닙니다.");
	}
//special 추상매서드 일원화 하기-------
	@Override
	void special() {
		System.out.println("잘 날라다닙니다.");
	}
}

//---------------------------------------------------//

class Bear { // Animal의 상속이 아니니까, Animal타입으로 인스턴스 생성할 수 X
	void breath() {
		System.out.println(" 곰은 숨을 쉽니다.");
	}

	void sound() {
		System.out.println("곰~곰 곰~~");
	}

	void tree() {
		System.out.println(" 곰은 크지만 나무를 잘 탑니다 ");
	}
} // Bear

//---------------------------------------------------//

public class Ex01_AbsAnimal {
	public static void main(String[] args) {
		// ** 추상클래스 Animal 생성 : ★1) 추상 클래스는 직접 인스턴스 생성불가(미완성된 매서드가 있는거니까)
		// But, 2) 인스턴스의 타입으로는 정의 가능하고, 후손으로 생성함(좌변)
		// 3) 이 인스턴스의 접근범위는 "조상(타입)에 정의된 만큼"만 가능()

		// Animal animal = new Animal();
		// 추상클래스는 new 해서 인스턴스 생성 불가(직접 인스턴스 생성 불가(우변)->타입으로는 정의가능(좌변))

//---------------------------------------------------------------//
		Animal a1 = new Cat(); // 조상 Animal을 타입으로 지정(가능), 우측 후손들 인스턴스 생성(가능)
		a1.breath(); // 3) a1.은 Animal 타입이니까, Animal에 정의된 맴버들만 불러오기 가능(조상에 정의된 만큼만 사용가능)
		a1.sound(); // ★animal안 sound()는 구현되지 않았는데? But, 실행은 추상클래스 상속 구현클래스 내용이 구현됨(실행된 클래스를 기반으로)
		// => ★다형성 : 다양한 형태로 나타나는 성질
		//special 추상매서드
		a1.special();
		// 후손의 타입 = 조상 생성자 는 추상클래스든, 아니든 허용하지 않음!

		Animal a2 = new Dog();
		a2.breath();
		a2.sound();
		a2.special();

		Animal a3 = new Eagle();
		a3.breath();
		a3.sound();
		a3.special();

//===============================================================//

// 좌변에 조상(타입)이 오고(조상타입은 꼭 추상이 아니어도 가능), 우변에 후손이 생성되는 것 : 똑같은 조상 타입이지만 실제 실행되는 건 각기 다른 후손들 -> 다형성
// 1)이때, 인스턴스의 접근범위는 조상의 정의된 만큼만 가능 2)실행은 후손이 실행됨
// 다형성을 적용한다는 의미 : 1. 우측의 생성자만 교체하면 쉽게 클래스 교체 가능 ★★2.코드 내에서 조상의 정의된 맴버만 사용
		System.out.println("\n Animal : 다형성 적용 Test");
		Animal animal = new Cat(); // 1. 후손들끼리는 쉽게 교체 가능
		animal.breath(); // 2. 매서드명이 동일하면 편리!(추상으로 의무구현해서 동일한 매서드명 되게끔)
		animal.sound(); // => 동일한 매서드명, 매서드명 일원화 가능

//-----------------------------------------------------//
		System.out.println("\n 후손 : 후손들 각각 Test");
		Cat cat = new Cat();
		cat.sound(); // 오버라이드한 추상매서드 호출도 가능
		cat.breath();
		cat.eyeColor(); // 추상클래스가 아닌 후손의 인스턴스 생성하면, 조상포함 후손이 갖고 있는 매서드를 다 쓸 수 있음
		Dog dog = new Dog(); // 이런 건, 각각 고유한 자신(후손)의 인스턴스
		dog.breath(); // 만약, 조상이 중간 조상이라면 그 조상까지(그 조상은 윗조상들을 포함하니까) 사용 가능
		dog.speed();
		dog.sound();
		// 다형성 : 조상의 타입으로 정의하고 후손클래스로 인스턴스 생성
		// 1) 조상에 정의된 맴버만큼 접근 가능!(조상타입으로 접근 제한) // 3) 추상뿐만 아니라 상속관계에서는 다 적용가능
		// 4) 조상타입으로 제한됐는데, 자손출력 가능한 거의 맹점은 오버라이딩임!(추상클래스도 오버라이딩 여부, 일반 클래스도 오버라이딩이냐에 따라
		// 출력 가능)
		Eagle eagle =new Eagle();
		
		// -----------------------------------------------------//
		// **Bear Test : Animal을 상속받지 않은 Bear 클래스는 적용이 X
		// Animal a4=new Bear(); -> 오류!
		Bear bear = new Bear();
		bear.breath();
		bear.sound();
		bear.tree();
		
//===============================================================//		
		// ** 매서드의 매개변수로 다형성 Test
		System.out.println("\n 매서드의 매개변수로 다형성 Test");
		animalUse(animal); // <-animal 타입인 애들 넣어줄 수 있음
		animalUse(cat);
		animalUse(new Eagle());
		// -> 얘네들은 자기한테 제일 잘 맞는 걸 호출하기 때문에 Animal타입이 호출
		
		animalUse(bear); //bear는 애니멀타입이 아니라 허용X -> Object 타입 추가후에는 가능
		// -> 자동적으로 bear는 object타입 호출(주소 프린트됨)
		
		// -----------------------------------------------------//
		
//만약, Animal타입 animal을 object타입으로 호출하고 싶다면? ★클래스 형변환 : (int)처럼 변환★
		animalUse((Object)animal); //But, bear가 animal로 변환될 순 없음(같은 집안 끼리만 가능!) 
		
//===배열 type(Animal[]) 추가 후 Test========================//
		Animal[] ans = {animal, cat, dog, eagle, new Cat()}; //Animal 타입 배열 초기화 <-애니멀 타입의 인스턴스들이 들어갈 수 있음
		animalUse(ans); // -> 10번 호출!(매개변수 ans가 배열 타입이니까, 같은 매개변수 타입 가진 10번 호출)
		
	} // main
	
//=======매서드의 매개변수로 다형성 Test======================//
	public static void animalUse(Animal animal) { //Animal 타입 매개변수 animal 인 animalUse매서드 
		if ( animal instanceof Animal) {
			System.out.println("animal은 Animal class에 속해있다");}
		
		animal.breath(); //Animal타입이라 Animal의 매서드 사용가능
		animal.sound();
	}
// -----------------------------------------------------//	
//매개변수로 오브젝트 타입을 하면 모두 오버로딩 되서, 모든 클래스를 매개변수로 사용 가능+오브젝트에 정의된 맴버들만 사용가능//
	public static void animalUse(Object animal) { //매서드 오버로딩
		// animal.; Object타입에 정의된 매서드만 사용 가능함 
		System.out.println("** 너의 주소 : "+animal);
	}
	
//10번=====Animal 타입을 배열로 해보기===Animal[]========//
	public static void animalUse(Animal[] animal) { //[]each for문 활용한 애니멀타입 배열 추출
		for(Animal an:animal) {
			// an. -> 배열로 바꿔줬으므로(배열을 나타내는 건 an으로 넣어줌) an.해야 호출가능
			an.breath(); // ->배열이 돌면서 차례대로  Animal 타입들 출력됨
			an.sound();
		}
		
// -----------------------------------------------------//
//** 어디 class type에 속해있는지 확인이 필요할 땐? instanceof (인스턴스 확인 연산자)
		//if ( cat instanceof Animal) {
			//System.out.println("cat은 Animal class에 속해있다");}
		//보통 속해있을 경우, animalUse(cat)등의 매서드 작업을 하는 실행문 만들어줌
		// 오류인 경우 컴파일 오류발생 -> 비교대상이 인터페이스가 되면 컴파일 오류가 발생하지 않아서(대신 런타임오류), 구분 위해 필요함!

	} //main
	
	
} // class
