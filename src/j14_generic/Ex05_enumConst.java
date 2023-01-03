package j14_generic;

//enum - 상수를 편리하게 묶어 사용하게 해주는 역할

//** 열거형(enum) 상수 사용
//=> 정의 : 열거형은 "서로 연관된 상수들의 집합"(클래스는 아니지만, 클래스 레벨쯤)

//** 열거형의 특징★
// 1) 상수의 사용을 편리하게 지원
// 2) 의미가 있는 단어를 상수로 사용하기 편리
// 3) 값과 타입을 동시에 확인하기 때문에 안전한 코딩 가능
//     => 열거형의 이름 자체(ScaleE)가 타입이 되고, 그 타입의 값(상수명)이 열거되는 상수명이 되는 것
// 4) 열거형 내부에 "생성자, 필드(맴버변수), 메소드"를 가질 수 있어서 단순히 상수가 아니라 더 많은 역할이 가능!!! -> 그래서 클래스랑 비슷

//------------------------------------------------------------------------------------//

enum ScaleE { // ScaleE 가 상수 열거형으로 정의된 상태
	DO, RE, MI, FA, SOL, RA, SI, DO2, RE2; //1. 상수 열거니까 상수명 선언
} //class 수준의 enum

//------------------------------------------------------------------------------------//

public class Ex05_enumConst {

	public static void main(String[] args) {
		// ** Interface 에 내가 사용할 상수들 정의해놓고, enum으로 상수들 묶어 사용
		// * Key를 ScaleE 타입으로 정의 가능함
		ScaleE key = ScaleE.DO;
		// enum ScaleE 타입 key선언 후 ScaleE에서 상수 중 한개 갖고오기
		
		System.out.println("* key: "+key);
		/* key = "123"; 등은 당연히 key 상수명이 아니니까 컴파일 오류!	
		key = null; -> NullPointerException
		=> enum의 장점 : 정의된 값 만 사용가능 */
		
		
		switch (key) { //case별로 선언된 상수에 따라 switch문 사용 가능 => 상수값을 이용하는게 아니라 "상수명"을 이용하는 것임!!!
		case DO:
			System.out.println("도 입니다.");
			break;
		case RE:
			System.out.println("레 입니다.");
			break;
		case MI:
			System.out.println("미 입니다.");
			break;
		case FA:
			System.out.println("파 입니다.");
			break;
		case SOL:
			System.out.println("솔 입니다.");
			break;
		default:
			System.out.println("몰라");
		} // switch - case문
		
//------------------------------------------------------------------------------------//		
		
		
		
	} //main
} //class
