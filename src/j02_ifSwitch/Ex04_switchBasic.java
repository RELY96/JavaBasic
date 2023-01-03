package j02_ifSwitch;

// ** switch - case - break 문 (direct분기 - 컴퓨터 작동을 좀 더 효율적으로 할 수 있음)
// 1. => switch(key) 문 인자(매개변수)의 Type은 int, char, String 만 가능★
// 2. => break : 무조건 탈출 (없으면 아래로 계속 default 까지 진행)
// 3. => case 블럭에 구문이 없어도 됨 (아래 구문으로 진행됨) (조건만 있고 구문이 없으면 그냥 아래로 진행)
// 4. => case 블럭에는 "복합구문에도 {중괄호}" 사용하지 않음 
// 5. => case 값으로 변수 사용은 불가(오직 리터럴!) 그러나 ★변수를 사용하지 않은 수식은 허용★

public class Ex04_switchBasic {

	public static void main(String[] args) {
		// ** int
		int i = 3;
		switch (i) {
		case 1 : System.out.println("1 입력");       // 매개변수가 1 이면 : 실행문
		         break;
		case 2 : System.out.println("2 입력");
		case 3 : System.out.println("3 입력");                             
		case 4 :                                   // 실행문 없어도 오류X -> 아래로 넘어감
		case 5 : System.out.println("5 입력");
//		         break;                            // break안하면 계속 밑으로 내려가면서 실행함 -> case3에 갔다가 -> 4(없음) -> 5 -> default 로 내려가서 3,5,default출력  
		default : System.out.println("default 는 생략 가능");                        //case에 해당이 아무것도 안되면, default break 해당X	
		} ;
		
		if (i==1) System.out.println("1 입력");
		else if (i==2) System.out.println("2 입력");
		else if (i==3) System.out.println("3 입력");
		else System.out.println("default 는 생략 가능");
		// => 이런 경우 switch case가 if보다 효율적!

		// ** char
		char code='K';
		switch(code) {
		case 'A' : System.out.println("** 예술가 **");                         //case type과 변수code 타입 형식이 같아야 한다(' ')
		           break;
		case 'P' : System.out.println("** 운동선수 **"); 
		case 'D' : System.out.println("** 개발자 **");
		default : 
		}
		
		// ** String
		String color = "red";
		switch(color) {
		case "red" : System.out.println("** 빨강 **");
		             break;
		case "orange" : System.out.println("** 주황 **");
        break;
		case "yellow" : System.out.println("** 노랑 **");
        break;
		case "green" : System.out.println("** 초록 **");
        break;
		default : System.out.println("** White **");
		}

		
		// ※ double , float 타입은 사용 불가능!
//		double dd = 2.2;
//		switch(dd) {                             // ->switch 매개변수에 double type은 안됨
//		case 1. : System.out.println("1 입력"); 
//                   break;
//		}
		
		// ** ★★switch, if문 등 제어문들 간에는 중첩 가능★★
		// ** char 중첩문 (code='A'인 경우 i가 짝수이면 i를 10배로 변경 후 출력하기)
		i = 4;
//		char code='A';
		switch(code) {
		case 'A' : System.out.println("** 예술가 **"); // ->case A는 안 묶어주지만, if문은 중괄호로 묶어주기
		           if (i%2==0) {
		        	   i*=10;
		        	   System.out.println(" i = "+i);
		           }
		           break;
		case 'P' : System.out.println("** 운동선수 **"); 
		case 'D' : System.out.println("** 개발자 **");
		default : 
		}
		
		// ** String 중첩문
		// i가 홀수일때만 color 출력하기
		i = 3;
//		String color = "red";
		if( i%2==1 ) {
			switch(color) {
			case "red" : System.out.println("** 빨강 **");
			             break;
			case "orange" : System.out.println("** 주황 **");
	        break;
			case "yellow" : System.out.println("** 노랑 **");
	        break;
			case "green" : System.out.println("** 초록 **");
	        break;
			default : System.out.println("** White **");
			} //switch
		} //if
		
		System.out.println("** color => "+color);
		// "red"를 if문 안에 넣게 되면, 지역변수라서 +color는 오류가 됨
		// => java는 언제든 변수 선언 가능하지만, 지역변수라면 지역단위로 변수 범위가 정해진다
		// => 지역변수 vs 전역변수
		
	} //main

} //class