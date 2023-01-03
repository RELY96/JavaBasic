package j07_classExtends;

//** Java 의 상속의 특징 1) 계층적인 다중 상속은 가능하고 제한이 없음 2) But, 다중 상속은 안된다(부모는 무조건 1개!)

//** 메서드 오버라이딩 : 조상의 메서드와 매개변수, 리턴값, 이름 모두 동일한 ★메서드(매개변수가 다르면 메서드 오버로딩) 
// 1) 현재 클래스에 구현된 메서드 호출됨(해당 클래스의 매서드를 지우면, 조상의 매서드가 호출됨)
// 2) 이름은 동일하지만 후손클래스 별로 다양한 기능을 구현할 수 있음★★

//===============================================================//
//** Animal 예제 Animal => Mammal (String cry,crying) , Reptile (swimming) / Mammal => WildAnimal (allPrint) , PetAnimal (infoPrint())
// 진행순서 - 1. 클래스 정리 2-1. 각 조상별 변수, 매서드 부여 + 마지막 자손으로 한번에 출력하는 매서드 작성 -> 첫번째 출력
// 2-2.만약,legs라는 똑같은 이름이 모든 변수에 있을때도 출력해봄!
// 3-1. 자손 인스턴스 생성시 매개변수를 이용하여 조상의 변수들 모두 초기화해서 다시 출력해보기 -> dog출력
// 3-2. 자손부터 조상으로 타고 올라가기!(초기화용 생성자 중요)
//===============================================================//

class Animal {
	String name; // 1. 모든 동물들은 다 공통적으로 이름이 있으니 추가
	static int legs; // 2. 모든 동물들은 다리가 있다

	Animal() {
		System.out.println("* Animal Default 생성자 준비 *");
	}

	void breath() { // 모든 동물들은 숨쉬니까 void 숨쉬는 거 반환
		System.out.printf("%s 는 숨을 쉬고, 다리는 %d개 입니다\n", name, legs);
		// name %s, 다리수 int %d
	}

	Animal(String name, int legs) { // 조상으로 세 특징 다 전달해주기 3step(마지막 조상 해당 되는 거 this로 넣기)
		this.name = name;
		Animal.legs = legs;
		System.out.println("* Animal 초기화용 생성자 *");
	}
} // super Animal

//========================================//

class Mammal extends Animal {
	int legs;

	String cry; // 울음소리 cry 맴버변수 정의

	Mammal() {
		System.out.println("* 포유류 Default 생성자 *");
	}

	void crying() { // 포유류는 우니까 crying매서드 생성
		System.out.printf("%s 는 %s 소리를 내며 웁니다\n", name, cry);
	}

	Mammal(String name, String cry, int legs) {
		super(name, legs); // 조상으로 세 특징 다 전달해주기 2step
		this.cry = cry; // 매개변수 cry(=자손에서 올라온 매개변수 cry)
		System.out.println("* 포유류 초기화용 생성자 *");
	}
} // Mammal

//----------------------------------------//

class WildAnimal extends Mammal { // wild animal이 포유류, 파충류 모두에 있어도 다중 상속은 불가함!
	WildAnimal() {
	}
} // WildAnimal

class PetAnimal extends Mammal {
	int legs; // 예시:) 이름 같은 변수들이 모든 조상과 후손에 있을 때, main PetAnimal의 cat.leg는 PetAnimal에 저장됨(가장
				// 가까운 곳!)
	// 조상의 legs 프린트하는 거는 int default값 0이 나옴(PetAnimal의 legs를 조상에 전달해주지 않았기 때문에)
	// 만약, 이 legs를 super에 전달하고 싶다면? super.legs=this.legs 넣어주기

	PetAnimal() {
		System.out.println("* 애완 Default 생성자 *");
	}

	PetAnimal(String name, String cry, int legs) { // 초기화용 생성자 만들기
		super(name, cry, legs); // 조상으로 세 특징 다 전달해주기 1step(legs의 경우 animal로 전달되고, 내 legs값은 할당되지X)
		System.out.println("* 애완 초기화용 생성자 *");
	}

	void checking() {
		System.out.printf("%s 는 예방접종을 했습니다.\n", name);
	}

	void infoPrint() { // 조상의 매서드까지 다 나오도록 프린트하는 매서드
		breath(); // super.Animal
		crying(); // super.Mammal
		checking(); // this

		super.legs = this.legs; // Mammal에 PetAnimal의 legs전달(만약 animals로 전달하고 싶으면, 아버지 Mammal에서 전달해줘야함)
	}
	
	//============================//
	void legsPrint (int legs) { //legs다 출력해보는 프린트
		System.out.printf("** Local(지역변수)=%d, Global_Pet(전역변수)=%d,Parent_Mammal=%d,Parent_Animal=%d\n",legs,this.legs,super.legs,Animal.legs);
	}
} // PetAnimal

//====================================================//
class Reptile extends Animal {
	Reptile() {
	}
}

//출력1==========================================//

public class Ex02_Animal {

	public static void main(String[] args) {
		PetAnimal cat = new PetAnimal(); // 출력을 위해 자손 PetAnimal 인스턴스 생성
		// main 실행 시, 조상 부터 쭉 실행됨(후손을 인스턴스로 생성, 실행하기 위해 조상 먼저 생성되야 하니까!)
        // 인스턴스 생성 시 매개변수X -> default 생성자 출력
		
		cat.name = "고양이";
		cat.legs = 4;
		cat.cry = "미야옹";
		cat.infoPrint();

//출력2==========================================//

		PetAnimal dog = new PetAnimal("캥거루", "띠용띠용", 2); // cat말고 dog 생성해서 새로운 방식으로 출력(자손,조상들의 "초기화생성자"가 호출됨!!)
		dog.infoPrint(); // 자손의 매개변수를 조상에 타고 올라가게 설정 -> 자손에서 조상의 infoPrint 되게 출력
		//자손을 통해 변수들 초기화(매개변수) -> 초기화용 생성자 출력
		
		System.out.println("생성자로 초기화 시 legs값 출력 테스트: "+dog.legs);
		dog.legsPrint(77); //legs Test Local로 넣어준 local값
	    // ★생성자로 초기화 시, animal로 매개변수 legs를 올려준거기 때문에, 포유류와 애완legs는 legs값 할당된 상태X-> int default값 0
		
		cat.infoPrint(); //*static으로 바꿔서 최종적으로 바뀐 값 2가 나옴(static특성)
		
		//===================================================================//
		
		// **object class(모든 클래스의 최상위 조상) 부르기 Test
		// 1) 클래스 계층도 확인-클래스를 클릭한 후 ctrl+t 누르면 됨.
		// 2) 클래스 소스코드보기 : 클래스명을 ctrl+click -> source code
		Object obj=new Object();
		System.out.println("\n** Object Test1 : "+obj.toString());//주소값 출력
		System.out.println("\n** Object Test2 : "+obj); //obj.하면 object에 속한 매서드들 확인 가능
	} // main

} // class
//==================정리=========================//

// 조상도 맴버변수, this도 맴버변수 갖고 있을 경우 : 내 맴버변수가 우선함!
// 1) 조상의 맴버변수까지 함께 출력하는 법(조상 매서드 자손에서 한번에 출력하도록 매서드 작성)
// 2) 자손의 맴버변수 조상으로 올리는 법(조상에 있는 변수부터 하나씩 추가해서 자손으로 내려오는 초기화용 생성자/super.와 this.의 적절한 사용->결국, 조상부터 자손으로 하나씩 내려오는 꼴이 됨)
// 3) 조상의 맴버변수값을 초기화 하는법(출력할 자손 인스턴스 생성 -> ★초기화 생성자★ 사용)

// 사용처 -> 대부분의 웹페이지,앱 등을 만들때는 자손의 특징들을 뽑아 모아서 조상을 만드는 방식으로 진행, 그때 활용!! => 공통 모듈 구현