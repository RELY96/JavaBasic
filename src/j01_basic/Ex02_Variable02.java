package j01_basic;

//** 기본자료형의 종류 와 Wrapper Class , 치환 **

//** 1. 용어정리
//=> 1-1) identifier: 직접 작명하는 식별자 (프로젝트, 클래스, 메서드, 변수, 상수 등의 이름) - 인식할 수 있는 명칭을 지어주는 것

//** 1-2) identifier 작명의 *일반적 규칙*
//=> 예약어는 쓸 수 없음!!
//=> project, class 명은 대문자로 시작.
//=> 상수명은 전체 대문자로 작성. 
//=> 위 외는 모두 소문자로 시작. ( 합성어 사용: setName(낙타표기법(camel표기법), 띄어쓰기도 금지) ) 
//=> 한글: 허용은 되지만 권장하지 않음
//=> 연산자(+,-,*,/,%) 는 식별자에 포함할 수 없음
//=> ★한번 선언된 변수명은 재선언 할수 없음(let 변수명 처럼 재선언 불가 / 동일한 identifier 를 중복 선언할 수 없음 )

//=> 2) modifier: 특징을 제한하는 한정자 (public, static..등 예약어의 일종)
// ex:) main 앞에서는 한정자(예약어)~ 가 와야하고, class앞에는 ~가 와야하고..

//=> 3) literal: 변수 우측의 값(Value)

//=> 변수명 의 규칙 (ppt J03_01 , 8p)

public class Ex02_Variable02 {

	public static void main(String[] args) {
		
		// ** 정수형(java type)
		// => byte(8bit_1byte), short(16_2byte), int(32), long(64)
		byte b=10; //"선언과 동시"에 값 할당 : '초기화'
		short s=123;
		
		int i; //선언 한다
		i=1234567890; //값을 할당한다
		
		// java는 숫자를 쓰면 무조건 int라고 취급해버림
		// int를 초과하는 정수 literal을 표현 못함
		// => long type을 쓰기 위해서는 숫자끝에 L or l 써줘야 long으로 인식함
		long l=1234567890123L;
		
		
		// ** 실수형(java type)
		// => float(32bit_4byte), double(64_8byte)
		double d = 123.456;
		// 실수를 표기하면 무조건 double로 취급함(실수literal의 default double)
		float f = 123.456f; // 그냥 123.456; 하면 double로 취급되서 8byte를 4byte에 담는꼴 -> error
        //f or F 붙이면 float 취급됨
		
		// ** Wrapper class : 기본 자료형을 지원해주는 클래스(모든 기본자료형에 있음)
		// => 기본자료형의 범위를 알 수 있음!!
	    //    해당 클래스명은 기본 자료형의 첫글자를 대문자로 하면됨
		
		System.out.println("** 정수형의 Literal 범위 **"); //첫글자 대문자 type 쓰고 . 찍으면 선택 가능
		System.out.println("** byte => " +Byte.MIN_VALUE+"~"+Byte.MAX_VALUE); //이 클래스 안에 정의되어 있는 상수를 불러올 수 있음
		System.out.println("** short => " +Short.MIN_VALUE+"~"+Short.MAX_VALUE);
		System.out.println("** int => " +Integer.MIN_VALUE+"~"+Integer.MAX_VALUE);
		System.out.println("** long => " +Long.MIN_VALUE+"~"+Long.MAX_VALUE);
		
		//정수형의 printf
		System.out.printf("** long_f => %d ~ %d\n" , Long.MIN_VALUE, Long.MAX_VALUE); //printf 포맷이 있는 출력문 -> "" 하고 , 후 값을 넣어주면 됨 -> printf 는 ln과 다르게 줄 바꿈이 없음 -> 개행(\n)필요
		System.out.printf("testtest\n");
		// %d 는 , 뒤에 정수가 올거라는 뜻 printf 에서 씀
		// \n 은 문자열 안에서 특수한 동작을 하므로, 이런 문자들을 escape 문자라고 함
		
		//실수형의 printf
		System.out.println("** 실수형의 Literal 범위 **");
		System.out.printf("** float => %f ~ %f \n", Float.MIN_VALUE, Float.MAX_VALUE );
		System.out.printf("** double => %f ~ %f \n", Double.MIN_VALUE, Double.MAX_VALUE );
		// %f 는 , 뒤에 실수가 올 것이다
		
		//** boolean
		boolean bool; // true(1) or false(0) 값 -> 사이즈 가장 적게 차지 => 관계식에 자주 씀
		bool = b > s; // false(0) 관계식 : true or false 둘중 하나 결과만 나옴		
		System.out.printf("** boolean Test => %b \n ",bool ); //%d와 bool 타입 안 맞아서 뒷자리 오류남
		
		// ** char
	    // => 한글, 영문 모두 '한글자', 2byte
	    // => 2byte int Type 으로도 사용가능
	    // => ASCII Code (American Standard Code for Information Interchange)
		char aa='A', bb='B', cc='C';
		cc='가'; //글자수 한글자 이상은 불가
		String ss="한 글자 이상 가능";
		
		System.out.println("** String+char => "+ss+cc); //문자열 연산 가능
		System.out.println("** char+char1 => "+aa+bb+cc); //문자열 연산 가능(문자열 연산 시 -는 오류)
		System.out.println("** char+char2 => "+(aa+bb+cc)); //우선순위 적용 -> 산술연산 됨(본인들끼리 연산하면 2byte int type으로도 사용가능해서 int연산됨)
		
		// System.out.printf("** aa=%d, bb=%d, cc=%d \n", aa, bb, cc); //type이 char라서 %d가 안됨 -> error
		System.out.printf("** aa=%d, bb=%d, cc=%d \n", (int)aa, (int)bb, (int)cc); //(int)앞에 붙여줘서 char를 int 타입으로 쓸 수 있음 => 형변환(typecasting)
        // (int)ss => Error(String 은 %d int type으로 변경할 수 없어서)
		
		System.out.printf("** aa=%s, bb=%s, cc=%s \n", aa, bb, cc); //글자로 출력하고 싶으면 %s
		
		// ** 치환
	    // => 값의 맞교환 (cup1 의 값과 cup2의 값을 교환)
	    // => box 내에 여러값이 들어있는데 그중 어떤값이 cup1 , cup2 의 값이 될지 모른다고 가정
	    // => 중간 보관을 위한 같은 타입의 임시 변수가 필요함
	    // => "=" 동일성을 의미하는것이 아니고 대입연산자
		String cup1="콜라";
		String cup2="사이다";
		
		String temp=cup1;      // 임시변수 temp 선언
		cup1=cup2;
		cup2=temp;             // 치환
		System.out.printf("cup1=%s, cup2=%s \n", cup1, cup2);
		
		
	} //main

} //class

