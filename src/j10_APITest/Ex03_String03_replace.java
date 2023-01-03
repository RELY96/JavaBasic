package j10_APITest;

import java.util.Arrays;

// 문자를 변경하는 메서드

// String 의 매서드 
//1) 문자열 변경: toLowerCase, toUpperCase, replace, split
//2) Type 변경: int to String, String to int

public class Ex03_String03_replace {

	public static void main(String[] args) {
		// 1) 문자열 변경
		String name = "홍길동";
		String city = "~~~~~SeoulKorea~~eee";
		String country = "     !I!Love!Korea!     ";
		
//------------------------------------------------------------------------//
		
		// 1) 문자열 변경
		System.out.printf("* toLowerCase => %s,%s \n", city.toLowerCase(), name.toLowerCase()); // 소문자로 바꿔라 -> 바꿔서 리턴, 값이 바뀌는 건 X																						
		System.out.printf("* toUpperCase => %s,%s \n", country.toUpperCase(), name.toUpperCase()); // 대문자로 바꾸기
		System.out.printf("* value 확인: %s,%s, %s \n", city, name, country);

		System.out.printf("* replace => %s,%s, %s \n", country.replace("Korea", "대한민국"), city.replace("e", "Apple"),
				name.replace("홍", "김")); // ★js와 다르게, 맨 처음 발견한 문자만 replace하지 않고, 해당 문자 모두 replace / 없으면 replace 안함
		
		//----------------------------------------------------------------------//
		
		// 2) split : 인자로 전달된 기호를 기준으로 "잘라", 배열에 담아줌
		// 2-1)
		String[]ss = country.split("!"); //!를 기준으로 데이터 잘라 배열 ss에 담아줌
		System.out.println("split 1 => "+Arrays.toString(ss)); //Arrays 활용해 배열 출력
		
		// 2-2)
		// 양 옆에 space 제거 후 잘라보기(trim 적용 후 split)
		ss= country.trim().split("!");
		System.out.println("trim, split 2 => "+Arrays.toString(ss));
		
//========================================================================================//
		
		// 3) 형변환
		// 3-1) String <-> int, double, float (Wrapper Class 이용)
		String num1 = "12345";
		String num2 = "100";
		System.out.println("* Test1 문자열연산: "+num1+num2);
		System.out.println("* Test2 산술연산(int): "+(Integer.parseInt(num1)+Integer.parseInt(num2))); //Integer로 형변환 후 연산해야 함
		// -> num1,num2가 integer로 바뀐 건 아님!!! 산술연산이 가능하게만 제공받은 것
		
		// float, double 연습
		num1="123.456";
		num2="200.300"; //f가 안 붙어있는 Str을 double,float로 형변환 -> 원 Str 형태에 f가 있든 없든, float로 형변환 가능함

		System.out.println("* Test3 산술연산(double,float): "+(Double.parseDouble(num1)+Float.parseFloat(num2))); //String -> double 형변환 연산(+가 붙어서 이건 오류안나고 산술연산됨)
		System.out.printf("* Test4 Str->float 변환 적용 확인(O), double=%f, float=%f \n",Double.parseDouble(num1),Float.parseFloat(num2)); //String -> double 형변환 연산
		
		//---------------------------------------------------------------------------------------------------------------------------//
		
		// 3-2) int, double...(숫자) -> String
		int i=10, j=20;
		// num1 =i+j; ->Type mismatch Error
		num1 = i+j+""; // 1) 문자가 뒤에 나와서, 산술연산 후 문자화 됨
		num2 =""+i+j; // 2) 문자가 먼저 나와서 문자열 연산 됨 (i+j)로 우선순위 정해주면 산술연산 후 ""문자화 됨
		System.out.println("i+j+\"\" : "+num1);
		System.out.println("\"\"+i+j : "+num2);
		
		//==========================================================================================//
		
		// 4) valueOf() : 기본 자료형을 문자열로 바꿔주는 것(모든 기본자료형 적용 가능) - 관계식의 결과를 String으로 받아야할 때 사용
		/* Ex:) String num3 = String.valueOf((i>j));, boolean 타입으로 결과 산출 등 할 때 사용*/
		// 형식 > static String valueOf(boolean b) : 모든 기본 자료형 적용 가능(boolean, char, float, int, long ..)
		
		double d = 1234.5678;
		/* num1 = d; 타입 미스매치 오류 -> 이럴 때 String으로 타입 맞춰주기 위해 valueOf 사용*/
		num1=String.valueOf(d); // 기본타입을 valueOf에 넣어주면 String 타입 return
		System.out.println("valueOf num1: "+num1); // num1에 넣어줬으니 값이 바뀜
		
		/*num2 = true; -> String 타입 = boolean값, 타입 미스매치 오류*/
		num2 ="true"; //수정1)
		num2=String.valueOf(true); //수정2) true를 String 타입으로 해줘서 타입 맞음, String 타입 return
		System.out.println("valueOf num2: "+num2); // num2에 넣어줬으니 값이 바뀜
		
		//==========================================================================================//
		
		// 5) 비교 : compareTo : "사전" 순서로 비교 - 사전에 나오는 순
	    //    같으면 0, 이전이면 음수, 이후면 양수 return (사전보다 앞에나오냐 뒤에 나오냐) + 다른 글자 갯수를 표시
		//    비교되는 원래 String의 위치(abc)가 기준! another 이 이후면 음수, another이 이전이면 양수
		//    https://mine-it-record.tistory.com/133
		
		name="abc";
		System.out.println("* 비교1 abc : "+name.compareTo(/*another String*/"abc")); //abc abc 같으니까 0리턴
		System.out.println("* 비교2 ab : "+name.compareTo("ab")); //사전 순서 ab보다 abc가 뒤(양수), 다른 글자 c 1개 :+1
		System.out.println("* 비교3 a : "+name.compareTo("a")); //+2 (양수, b,c 두글자 다름2)
		System.out.println("* 비교4 bc : "+name.compareTo("bc")); //-1
		System.out.println("* 비교5 c : "+name.compareTo("c")); //-2 // 첫 c부터 abc랑 아예 다른 문자이기 때문에, a와c의 아스키값 차이를 return
		System.out.println("* 비교6 abcabc : "+name.compareTo("abcabc")); // -3
		System.out.println("* 비교7 abcabcd : "+name.compareTo("abcabcd")); // -4
		// * 문자열의 순서가 일치 : 다른 글자 갯수 표시(abc vs ab 등)
		System.out.println("* 비교7 love : "+name.compareTo("love")); // * 순서대로 비교하다가, 완전 다른 문자가 시작되면, 달라진 첫글자 알파벳의 차이(순서차이)를 return
		// => if에 적용 시 주의
		// if(name.compareTo(num2)==0) {}
		
		//==========================================================================================//
		
		// 6) 포함확인 .contains("") -> 포함하고 있는지 boolean값 나옴(대,소문자 주의!)
		System.out.println("** 포함확인1: "+country.contains("Korea")); //T
		System.out.println("** 포함확인2: "+country.contains("korea")); //F
	} // main
} // class
