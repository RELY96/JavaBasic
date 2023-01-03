package j14_generic;

// 인터페이스에는 상수만 들어갈 수 있으니까, 인터페이스에 상수 정의 후 열거형으로 가져다 써보기 =/= 상수형 직접 써보기(static방법) 비교

interface ScaleI {
	// public static final String DO = "도"; <- 상수 정의 : public static final(생략해도
	// 적용됨), 대문자, 바로 초기화
	int DO = 0;
	int RE = 1;
	int MI = 2;
	int FA = 3;
	int SOL = 4;
	int RA = 5;
	int SI = 6;
} // interface ScaleI

public class Ex04_InterfaceConst {

	public static void main(String[] args) {
		// ** Interface 에 정의된 상수 직접 사용하기 => switch-case문 활용
		// => key에는 int인 아무 숫자나 들어갈 수 있음
		
		int key = ScaleI.DO; // static 상수값이니까 스태틱방식으로 불러오기
		
		switch (key) { //key가 '상수값' case ㅁ 일때, 실행문 break;
		case 0:
			System.out.println("도 입니다.");
			break;
		case 1:
			System.out.println("레 입니다.");
			break;
		case 2:
			System.out.println("미 입니다.");
			break;
		case 3:
			System.out.println("파 입니다.");
			break;
		case 4:
			System.out.println("솔 입니다.");
			break;
		default:
			System.out.println("몰라");
		} // switch - case문
	} // main
} // class
