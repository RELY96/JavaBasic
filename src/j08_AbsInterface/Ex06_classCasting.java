package j08_AbsInterface;

// 클래스 간(is관계) Casting

//1. 자동 형변환 (형변환 생략가능/자손 범위가 조상보다 크니까, 자손이 조상의 모든 맴버를 가지고 있으니까 가능!)
//   : 조상 <- 자손(Up_Casting)
//   : Animal <- Mammal <- Cat 형변환

//----------------------------------------------------------//

//2. 명시적 형변환 (형변환 생략 불가능/범위가 작은 조상을 범위가 넓은 후손으로 형변환 하는거기 때문에, 가능한 경우가 따로 있고, 이때 명시적 형변환 해줘야 함)
//   -> Animal을 Cat으로 쓰겠다, Mammal로 쓰겠다 선언해줘야 함 
//   : 자손 <- 조상(Down_Casting)
//   1) 실제적 클래스타입이 변환가능한 경우에만 적용됨(변환불가능한 경우에는 컴파일 오류 없어도 런타임 오류(ClassCastException)발생

//----------------------------------------------------------//

//** 2. 과제 
//Animal => Mammal 포유류  => PetAnimal
//Animal => Reptil 파충류 

//=========================================================//

class Animal2 {
	int legsA = 2;
	String name;

	public Animal2() {
		System.out.println("** Animal 생성자 **");
	}

	public Animal2(String name) {
		this.name = name;
	}

	void breath() {
		System.out.println(name + " 는 숨을 쉽니다 ~~");
	}
} // Animal

class Mammal extends Animal2 {
	String cry;
	int legs = 3;

	public Mammal() {
		System.out.println("** Mammal 생성자 **");
	}

	void crying() {
		System.out.println(super.name + " 은(는) " + cry + " 웁니다 ~~");
	}
} // Mammal

class PetAnimal extends Mammal {
	int legs = 4;

	PetAnimal() {
		System.out.println("~~ PetAnimal 생성 , default 생성자 ~~");
	}

	@Override // Animal
	void breath() {
		super.breath();
		System.out.println("여기는 PetAnimal breath() 입니다 ~~");
	}

	void legsPrint(int legs) {
		System.out.printf("%s의 다리 => (Local):%d, Pet(Global):%d, Mam(Father):%d, Ani(할아버지):%d \n", name, legs,
				this.legs, super.legs, super.legsA);
	}

} // PetAnimal

class Reptile extends Animal2 {
} // Reptile

//=========================================================//

public class Ex06_classCasting {

	public static void main(String[] args) {
		// Test1 PetAnimal 생성
		PetAnimal dog = new PetAnimal();
		
		// **instanceof Test
		if(dog instanceof PetAnimal) {System.out.println("** dog 은 PetAnimal 입니다");}
		if(dog instanceof Mammal) {System.out.println("** dog 은 Mammal 입니다");}
		if(dog instanceof Animal2) {System.out.println("** dog 은 Animal2 입니다");}
		if(dog instanceof Object) {System.out.println("** dog 은 Object 입니다");}
		
//----------------------------------------------------------//

		Animal2 an1 = new PetAnimal(); //Animal2타입으로 PetAnimal();생성(이거 자체가 up-casting, 타입이 Animal2 조상이니까!)
		an1= new Reptile(); //다른 후손인 Reptile로 새로운 인스턴스 넣어줄수 있음 -> 다형성(후손교체)

		/*PetAnimal pa = new Animal();*/ // 오류(조상은 후손으로 down_casting 하는 꼴인데, 자동형변환 안되니까 오류!)
		Animal2 an2 = new Animal2(); //순수한 Animal2 타입
		
		System.out.println("** an1 과 an2 비교 **");
		an1 = dog; // 반대 형변환 가능
		an2 = dog; // ★반대 형변환 불가능 -> 이걸 통해 형변환 발판 마련
		
		/*dog. Animal2~Pet 까지 다 사용가능 Animal2 an1 = new PetAnimal();랑 같음*/ 
		/*an2. an2에 정의된 만큼만 접근 가능(an2는 Animal2만 생성된 거니까!) Animal2 an2 = new Animal2(); , 즉, Animal2 an2 = new PetAnimal();랑 똑같은 거임*/
		
//--------------------------------------------------------------------//
		
		// Test3. Down_Casting -> 명시적 케스팅
		System.out.println("** Down Casting Test **");
		/*an1 = dog;, an2 = dog; 이렇게 사전작업 해주면 반대 명시적 형변환(명시적Down-Casting) 가능*/
		dog= (PetAnimal)an1; //후손 <- 조상 캐스팅하기 /*원래는 컴파일 오류*/
		dog= (PetAnimal)an2; /*원래는 런타임 오류*/
		
		if(an2 instanceof PetAnimal) {
			dog= (PetAnimal)an2;
			System.out.println("an2는 PetAnimal 입니다");
		} else {
			System.out.println("an2는 PetAnimal 이 될 수 없습니다");
		}
		
//===================================================================//
		//** Object getClass 매서드 알아보기
		System.out.println("** dog의 Class Type : **"+dog.getClass().getName());
		System.out.println("** an1의 Class Type : **"+an1.getClass().getName());
		System.out.println("** an2의 Class Type : **"+an2.getClass().getName());
		
//===================================================================//		
		System.out.println("** Program Stop **");
		
	} // main

} // class
