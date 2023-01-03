package j14_generic;

//** enum 매개변수로 전달
//=> 메서드 에 적용
//=> 일반상수를 사용하는 것과 안전성 비교

enum Animal { DOG, CAT, BEAR } //enum상수
enum Person { MAN, WOMAN, CHILD }

public class Ex07_argumentTest {
	// ** 일반상수 정의(맴버상수)
	static final int DOG = 0;
	static final int CAT = 1;
	static final int BEAR = 2;
	
	static final int MAN = 0;
	static final int WOMAN = 1;
	static final int CHILD = 2;

//--------------------------------------------------//	
	
	// ** 상수 활용 위한 테스트용 매서드 만들기(넌 누구니?)
	static void whoAreU1(int p/*매개변수 - 기본자료형 등 일반 Type*/) {
		switch (p) {
		case 0 : System.out.println("MAN 0입니다");
		         break;
		case 1 : System.out.println("WOMAN 1입니다");
		         break;
		case 2 : System.out.println("CHILD 2입니다");
		         break;
		default : System.out.println("입장불가 입니다");
		}
	} //whoAreU1
	// => 매개변수가 int면 모두 통과됨
	// => Person 상수만 통과할 수 있어야 함 (동물X) -> 값 0,1,2 가 같은 일반 상수는 값으로 구분하면 동물도 통과됨
	
//---------------------------------------------------//	
	
	static void whoAreU2(Person p) { //enum의 Person 타입만 매개변수로 지정
		switch (p) {
		case MAN : System.out.println("MAN 0입니다");
		         break;
		case WOMAN : System.out.println("WOMAN 1입니다");
		         break;
		case CHILD : System.out.println("CHILD 2입니다");
		         break;
		default : System.out.println("입장불가 입니다");
		}
	} //whoAreU2
	// => enum은 상수를 Animal, Person 집합으로 나눴기 때문에 0,1,2 값 이 아니라 Person안에 사람만 통과하고, ordinal 값으로 012 구분할 수 있음
	// Type을 Person으로 제한하고, 상수 == 값 취급되니까 안정성 증가
	
//============================================================//	
	
	public static void main(String[] args) {
		// 1. 일반상수 사용
		whoAreU1(MAN);
		whoAreU1(WOMAN);
		whoAreU1(CHILD);
		whoAreU1(CAT); // 동물이라도 int타입에 값이 같으니까 구분 못하고 들어가게 됨(비교 가능한 Type이 없어서 논리적 오류 예방 불가)-> 안정성X
		whoAreU1(DOG);

		// 2. enum상수 사용
		// 2.1. enum Person 직접 사용(static)
		whoAreU2(Person.MAN); //그냥 MAN이 아닌 Person.MAN 으로 펄슨enum 안의 스태틱 상수명 MAN을 불러와야 함
		whoAreU2(Person.WOMAN);
		whoAreU2(Person.CHILD);
	  /*whoAreU2(Person.CAT);, whoAreU2(Animal.DOG); -> 오류! 컴파일 단계에서 거를 수 있음*/
		
		// 2.2 인스턴스 사용
		Person p = Person.MAN;// (new)안쓰는 이유 - 스태틱한 접근방법이 가능하기 때문에!
		whoAreU2(p);
		
		Animal a = Animal.BEAR; // Animal 타입 enum의 BEAR를 a에 저장
	    // whoAreU1(a); -> whoAreU1(a)에도 int가 아니라 들어갈 수 없음

	    // if (a instanceof Person) => 컴파일오류 로 비교 불가 (비교 대상이 interface 일때만 컴파일오류 없이 비교가능 -> 인터페이스는 컴파일오류X, 런타임오류O)
		if (a instanceof Animal) System.out.println(" 동물, 입장불가 ");

	} //main
} //class
