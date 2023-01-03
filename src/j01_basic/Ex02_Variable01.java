package j01_basic;

//1. ** 변수(Variable) 정의
//변수를 정의하는 세 가지 요소 : type, 변수명, value
//=> type 은 불변, value 는 변경가능

//2. ** 상수(Constant) 정의
//=> type 불변, value도 불변
//=> 주로 고정값 에 사용 (pi = 3.141592)
//=> 변수명 전체 대문자로 표기
//=> final 앞에 표시 

//3. ** 기본자료형 => 예약어로 정의된 Type
// => 1) 더이상 쪼개질 수 없음,다른 타입이 섞일 수 없음
// => int,double,boolean,char
// 1) int,double 등 숫자타입들은 종류가 있음
// 정수형 : byte(8bit_1byte), short(16_2byte), int(32), long(64)
// 실수형 : float(32bit_4byte), double(64_8byte)

//4. ** 참조자료형
// => 1) 모든 class는 다 참조자료형이 될 수 있음
// => String

public class Ex02_Variable01 {

	public static void main(String[] args) {
		// ** 상수 는 선언될 때 딱 한번만 값을 부를 수 있음, 대문자 변수명 / 타입앞에 final
		final double PI=3.141592;
		
		// ** 변수
		// ★ String ★
		String job="강사"; //타입 이름 ="값";
		String name; // 미리 선언만도 가능(값 나중에 할당)
		
		// ★ String은 문자'열' 클래스 -> 참조자료형 <- String의 경우 리터럴을 담는 공간을 따로 사용함
		// 1) 리터럴 담는 공간에 "강사" 또는 긴 문장 등 상관없이 담아놓음
		// 2) 리터럴에 있는 홍길동의 주소를 Ram안에 job변수로 전달해줌(참조자료형) -> 참조자료형 초기화말고 선언말 해놓으면 null 값을 가짐
		
		// ★ java에서는 모든 클래스(객체)는 타입이 될 수 있다!!!(대문자 시작하는 클래스가 type되면(EX:String)크기를 알수 없기 때문에 주소를 담아 참조자료형)
		// -> String 변수 값부를 수정하면 재할당해서, 주소값이 바뀜(새로운 공간(번지)을 만들고 새로운 값을 부여함 / 기존 값부는 지워지거나 바뀌지 않음!)
		// -> String은 수정할 수 없는 타입(immutable)
		
		name="엄희정";
		// name=12345; 는 오류(type miss match)
		//name="123.45"; //는 "글씨"니까 글씨 타입으로 가능함 <-""없으면 다 int로 취급
		
		int age=20; //int age; 도 가능(int type은 정수형)
		//age=123.456; 은 오류
		
		double height=170.99; //(double type은 실수형)
		//height="가나다라"; 는 오류(100같은 정수는 실수에 포함되니까 가능!) <- .쓰면 실수로 취급 "."은 상관없음
		
		System.out.println("test1 = >"+(age+height)); //190.99		
		System.out.println("test2 = >"+(age+name)); //20123.45(문자열 더하기)
		
		boolean tf= true; // boolean 타입은 true, false 값 가짐
		//int,boolean,class명,메서드명,클래스 등 예약어는 무조건 변수명으로 쓰면 안됨!!
		// 예약어 : java의 중요한 기본 문법들
		
		char grade='A'; //1) 작은 따옴표, 2) 문자 1개만! 가능
		grade='가'; //한글은 1글자로 봄
		//name="ABCD"; //문자열은 반드시 1) 큰 따옴표, 2) 여러 문자로!(String)
		
		System.out.println("~~직업=> "+job);
		System.out.println("~~이름=> "+name);
		System.out.println("~~나이=> "+age);
		System.out.println("~~신장=> "+height);
		System.out.println("~~진위=> "+tf);
		
		//java의 특징 -> 리터럴 공간이 필요 없어지면 알아서 청소해줌, 용량 신경X (가비지컬렉터)
		
		
		
		
	} //main

} //class

