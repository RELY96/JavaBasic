package j14_generic;

//** enum 의 내부
//=> enum은 class, interface와 동급의 형식을 가지는 단위임.
//=> 실상은 class 이지만, enum만을 위한 문법적 형식을 가지고 있기 때문에 클래스와 구분하기 위해서 enum이라는 키워드를 사용함 => 컴파일된 코드는 ~.class 임
// (class, abstract class, interface, enum 모두 ~.class )

//================================================================//

//=> "enum Fruit" 코드의 내부는 다음과 같다.
// APPLE, PEACH, BANANA 의 각각 인스턴스가 만들어지는 꼴

// class Fruits {
// public static final Fruit APPLE  = new Fruit();
// public static final Fruit BANANA = new Fruit();
// public static final Fruit ORANGE  = new Fruit();
// public static final Fruit PEACH  = new Fruit();
// private Fruit () {} -> 기본생성자
//              }

//===============================================================//

//** enum의 생성자, 변수, 메서드 : 생성자의 접근 제어자가 private(Fruits 외부에서는 enum생성자 사용불가)
//   : 클래스 Fruits를 인스턴스로 만들수 없도록 하여 "다른 용도로 사용하는 것을 금지"
//   => 생성자 오버로딩 처럼 생성자의 매개변수 사용은 허용, 생성자는 1개만 허용됨 ( Fruit.APPLE 사용시 1개의 생성자가 자동호출됨 )
//      - 디폴트 생성자, 초기화용 생성자 여러 개가 있다해도 하나만 자동선택되서 사용되어짐
//   => 생성자 안 변수, 메서드 정의 가능

//===============================================================//

enum Fruits { 
	
	// 매개변수가 있는 생성자 전달하려면 상수명도 전달받을 수 있는 매개변수 자리 있어야 함
	APPLE("Green"), BANANA("Yellow"), ORANGE("Red"), PEACH("Pink"); //()안에 매개변수 로 연결될 "color"인자 넣어야 함
	String color;
	
	// 1) default 생성자
    //	private Fruits () {
    //		System.out.println("Call default 생성자"+this/*각 상수들 출력*/);
		// ★내부적으로 newFruits(); 생성자가 상수 수만큼 있어서, 기본생성자 출력문이 각 생성자따라 모두 출력된 것
    //	}
	
	// 2) 생성자 오버로딩(허용은 되지만, 생성자는 딱 1개만 넣어야됨)
	// 매개변수가 있는 생성자, 변수 활용
	private Fruits (String color) {
		this.color=color;
		System.out.printf("Call 초기화용 생성자(매개변수O), 과일명 %s = 색 %s \n",this,this.color);
	}
	
	// 3) 매서드 추가(getColor)
	public void setColor(String color) { this.color = color; }
	
	String getColor() { return this.color; }
} //Fruit

//===============================================================//

enum Company { ORACLE, NAVER, APPLE } // Company

//===============================================================//

public class Ex08_enumConstructor {

	public static void main(String[] args) {
		// 1) default 생성자 Test
		System.out.printf("main에서 생성자 부르기(default,초기화용) : %s, %s, %s, %s \n ",Fruits.APPLE,Fruits.BANANA, Fruits.ORANGE, Fruits.PEACH);
		// 2) 초기화용 생성자 부르기 => 58행 식으로 생성자 1개 결정해서 자동 실행됨
		
		// 3) getColor 매서드 사용
		Fruits f = Fruits.ORANGE;
		switch(f) {
		case APPLE: System.out.println("사과이고, 색은"+Fruits.APPLE.color+"입니다.");
		            break;
		case ORANGE: System.out.println("오렌지이고, 색은"+Fruits.ORANGE.getColor()+"입니다.");
		            break;
		case BANANA: System.out.println("바나나이고, 색은"+Fruits.BANANA.color+"입니다.");
		            break;
		case PEACH: System.out.println("복숭아이고, 색은"+Fruits.PEACH.getColor()+"입니다.");
		            break;
		} //switch
		
//----------------------------------------------------------------------------------------------//		
		
		// ** 번외
		Fruits.APPLE.setColor("빨강");
		System.out.println("setColor로 다른 클래스에서 Color 수정1-APPLE: "+Fruits.APPLE.getColor());
		System.out.println("setColor로 다른 클래스에서 Color 수정2-APPLE: "+Fruits.APPLE.color);
		// APPLE은 Fruits 타입의 상수 인스턴스 -> Fruits.APPLE.매서드 로 호출
		
//==============================================================================================//
		
		// ** 안전한 코딩을 위한 enum의 비교(Company enum)
		// 열거형의 타입 비교(컴파일 단계에서 값,타입 동시 확인, 오류 걸러내서 안전한 코딩 가능)
	    //  => 서로 다른 상수 그룹에 대한 비교를 컴파일 시점에서 차단시켜줌
		
		/* if (Fruits.APPLE == Company.APPLE) -> enum이 다르기 때문에 컴파일오류*/
		/* if (Fruits.APPLE != Company.APPLE) -> 비교 자체가 안되는 분류기 때문에 !=도 아니고, 아예 컴파일 오류임 */
		
		Company c = Company.APPLE; // Company 타입의 APPLE을 c에 저장
		
		switch(c) {
		case APPLE: System.out.println(c+" 연봉 1억");
		            break;
		case ORACLE: System.out.println(c+" 연봉 2억");
		            break;
		case NAVER: System.out.println(c+" 연봉 3억");
		            break;
		} //switch
		
//==============================================================================================//
		
		
	} //main
} //class
