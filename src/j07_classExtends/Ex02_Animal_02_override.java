package j07_classExtends;

//** 메서드 오버라이딩 : 조상의 메서드와 매개변수, 리턴값, 이름 모두 동일한 ★메서드(매개변수가 다르면 메서드 오버로딩) 
// 1) 현재 클래스에 구현된 메서드 호출됨(해당 클래스의 매서드를 지우면, 조상의 매서드가 호출됨)
// 2) 이름은 동일하지만 후손클래스 별로 다양한 기능을 구현할 수 있음★★

// static 매서드의 오버라이딩 : 불가! 오버라이딩 말고 그냥 클래스이름.매서드명(); 으로 바로 불러올 수 있음

class Animala {
	String name;
	static int legs;

	Animala() {
		System.out.println("* Animal Default 생성자 준비 *");
	}

	void breath() { 
		System.out.printf("%s 는 숨을 쉬고, 다리는 %d개 입니다\n", name, legs);
	}

	Animala(String name, int legs) {
		this.name = name;
		Animala.legs = legs;
		System.out.println("* Animal 초기화용 생성자 *");
	}
} // super Animal

//========================================//

final class Mammala extends Animala {
	int legs;

	String cry;

	Mammala() {
		System.out.println("* 포유류 Default 생성자 *");
	}

	final void crying() { //★매서드, 변수에 모두 final붙여서 상수로 만들 수 있는데, 이 경우 오버라이딩 안됨!!!
		System.out.printf("%s 는 %s 소리를 내며 웁니다\n", name, cry);
	}

	Mammala(String name, String cry, int legs) {
		super(name, legs); 
		this.cry = cry; 
		System.out.println("* 포유류 초기화용 생성자 *");
	}
	
	//override static Test=super===============//
	static void staticTest() {
		System.out.println("** Mammal : static Test() **");
	} 	
} // Mammal

//----------------------------------------//

class WildAnimala extends Mammala {
	WildAnimala() {
	}
} // WildAnimal

class PetAnimala extends Mammala {
	int legs;
	PetAnimala() {
		System.out.println("* 애완 Default 생성자 *");
	}
	PetAnimala(String name, String cry, int legs) {
		super(name, cry, legs); 
		System.out.println("* 애완 초기화용 생성자 *");
	}

	void checking() {
		System.out.printf("%s 는 예방접종을 했습니다.\n", name);
	}

	void infoPrint() {
		breath();
		crying(); 
		checking(); 
		super.legs = this.legs; 
	}
	
	//============================//
	void legsPrint (int legs) { 
		System.out.printf("** Local(지역변수)=%d, Global_Pet(전역변수)=%d,Parent_Mammal=%d,Parent_Animal=%d\n",legs,this.legs,super.legs,Animal.legs);
	}
	//============================//
	@Override //crying매서드에 기능 추가해서 오버라이딩 Test
	void crying() { //crying()매서드에 final붙여서 override 적용안됨
		super.crying();
		System.out.println("** 노래도 부를 수 있습니다 **");
	}
	
	//===static의 override Test 적용===//
	// @override 오류!
	static void staticTest() {
		System.out.println("** Mammal : static Test() **");
		//static 맴버들은 클래스 종속이기 때문에, 상속보다 클래스 개념이 우선 적용됨(override적용X)
		// 즉, 조상의 staticTest() 와는 무관한 Petanimal.staticTest()임(오버라이딩 불가)
		
		Mammala.staticTest(); //static은 그냥 이렇게 불러오면 됨
	} 
} // PetAnimal

//출력1==========================================//

public class Ex02_Animal_02_override {

	public static void main(String[] args) {
		PetAnimala cat = new PetAnimala(); 
		cat.name = "고양이";
		cat.legs = 4;
		cat.cry = "미야옹";
		cat.infoPrint();

//출력2==========================================//

		PetAnimala dog = new PetAnimala("캥거루", "띠용띠용", 2);
		
		System.out.println("생성자로 초기화 시 legs값 출력 테스트: "+dog.legs);
		dog.legsPrint(77);		
		cat.infoPrint();
	} // main

} // class

//=============================================//

// 정리 //
// 1. 메서드에 static -> 오버라이딩 불가
// 2. 메서드에 final -> 오버라이딩 불가(final void crying...) : final은 후손에게 동일한 이름, 동일한 매개변수 매서드 작성이 허용되지 않음
// 3-1. class에 final -> final클래스 상속받은 후손들 모두 error : 상속을 허용하지 않음! => 단종 클래스
// 3-2. 단종 클래스의 예:) String