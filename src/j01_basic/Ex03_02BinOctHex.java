package j01_basic;

// ** 2진수(Binary number), 8진수 , 16진수 표기
// => 2진수 : 0b 로시작 -> 표현 : 0b1111(0b 뒤에는 0 또는 1만)
// => 8진수 : 0  Octal Number -> 표현 : 0
// => 16진수: 0x Hexadecimal Number -> 표현 : 0x

public class Ex03_02BinOctHex {

	public static void main(String[] args) {
		int bin=0b1111; // 10진수로 하면 1+2+4+8 = 15 , 15를 2진수 표기 -> 0b1111
		int oct= 017; // 10진수로 하면 8+7=15 (10의 자리 1은 8임)
		int hex=0xf; // 9, 10_A, 11_B, 12_C, 13_D,14_E,15_F, 16=>10
		// 10진수로 하면 15 (10의 자리 1은 16)
		
		System.out.println("** Binary => " +bin);
		System.out.println("** Octal => " +oct);
		System.out.println("** Hexadecimal => " +hex);
		
		// 1. 진법에 맞게 출력하기(integer를 2,8,16 진법으로 출력하기 -> integer의 wrapper class의 도움 받으면 됨)
		System.out.println("** Binary => " +Integer.toBinaryString(bin));
		System.out.println("** Octal => " +Integer.toOctalString(oct));
		System.out.println("** Hexadecimal => " +Integer.toHexString(hex));
		
		// => 똑같은 숫자기 때문에 일반적인 연산과 같이 처리됨
		// 문자열에 연결되면 문자로 취급됨('='int to String)
		System.out.println("** int to String1 => "+bin+oct+hex); // 문자열 연산
		System.out.println("** int to String2 => "+(bin+oct+hex)); // (우선순위) 인트 연산
		System.out.println("** int to String2 => "+bin+oct+hex+""); // 은 int 형태인 앞에서 세개 연산 먼저 진행(45) 후 ""문자열 연산되서 45가 나옴
		System.out.println("** int to String2 => "+""+bin+oct+hex); // ""문자열 결합 먼저 이루어지고 뒤 연산 나오기 때문에 151515임
		
//=================================================================================
		
		// *String을 숫자로 해야하는 경우(String to int)(wrapper class 활용, (int)처럼 java가 기본적으로 지원해주는 형변환은 아니고, wrapper class 기능을 활용한 형변환 *이것이 객체지향...!!!*)
		String s = "12345";
		System.out.println("** String to int1 => "+(s+100)); // 우선순위해도 string이 문자라 문자열 결합 됨 > 12345100
		System.out.println("** String to int2 => "+(Integer.parseInt(s)+100)); //string을 integer 클래스로 바꿔줌
		
//		s="가나다라";
		System.out.println("** String to int3 => "+(Integer.parseInt(s)+100)); //글자 '문자열'은 integer로 바꿀 수 없음 -> NumberFormat Exception 오류
		
//---------------------------------------------------------------------------
		
		// * String to double(string을 실수형 변환)
		s="123.4567";
		System.out.println("** String to double1 => "+(Double.parseDouble(s)+100));
		
		s="abcd.4567";
		System.out.println("** String to double2 => "+(Double.parseDouble(s)+100)); //글씨형이니까 format 오류뜸
		
	} //main

} //class
