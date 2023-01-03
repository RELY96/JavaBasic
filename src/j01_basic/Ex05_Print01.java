package j01_basic;

import java.util.Date; // import 하겠다. package명(java.util) 클래스명(.Date);

public class Ex05_Print01 {

	public static void main(String[] args) {
		// ** Escape 문자 : 역할이 정해져 있는 문자 , escape문자를 출력하고 싶을 땐?
	    // => \n 줄바꿈함, \t 탭간격으로 건너띔, ... "\"뒤에 나오는 문자는 escape문자
		System.out.println("C:\\MTest\\myWork\\Java01\\src\\j01_basic"); // \를 출력하고 싶을 땐 역슬래쉬 연속 두개!(\\), escape \랑 구분됨
		System.out.println(" 'A' , \"A\" "); // 큰 따옴표를 출력하고 싶을 땐 \"ㅁ\" , 역슬래쉬 쌍따옴표
		
		System.out.println("abcd\tefghi\tjk123\n"); // \t와 \n을 출력하고 싶다면? ★?★
		System.out.println("\n");
		System.out.println('\n'); // \n \t 는 캐릭터로도 취급되서 ''해도 오류 안남 -> 줄 바꿈 일어남!
		System.out.println('\''); // ' 하나를 출력하고 싶으면 ' '안에 역슬래쉬와 ' 입력 -> char ' 출력
		System.out.println('A');
		System.out.println('가');
		
		// ** print, println, printf
		System.out.print("print1 => 줄바꿈 안됨");
		System.out.print("print2\t");
		System.out.print("print3\t");
		System.out.println(""); //줄바꿈 됨
		System.out.println("** 줄바꿈 됨 **");
		
		// printf는 , 사용해서 여러 값 출력 가능
		System.out.printf("금액1: %,d원 \n", 1234567); // %다음에 , 해주면 1000 자리마다 , 찍어줌
		System.out.printf("금액2: %9d원 \n", 1234567); // 9자리 기준으로 잡아서 들어감 -> 앞에 빈 2자리는 공백 됨
		System.out.printf("금액2: %-9d원 \n", 1234567); // 9자리 기준 남는 뒷자리 공백
		System.out.printf("금액2: %,09d원 \n", 1234567); // 9자리 기준 남은 앞자리 0으로 채움(,까지 자릿수로 채워서 0이 없음)
		
		System.out.printf("반지름이 %d인 원의 넓이 = %10.2f\n", 10, 10*10*Math.PI); //%ㅁ.2f 는 실수 두 자리까지 표기한다는 뜻 (대문자PI같이 정해져있는 수는 '상수' 라고 함)
		System.out.printf("%s 는 %d학년 %d반, 학점은 %s 입니다.\n", "홍길동", 2,5,'A');
		
		// **날짜출력(Date 클래스 사용(모든 클래스는 Type으로 사용 가능함 -> ))
		// Date의 경우 따로 import 해야 오류 안남 (java.lang을 제외한 것들은 import 필요)
		Date now ; // java.util.date 를 참조함 -> jre 라이브러리 속 java.util.date 에서 불러온 것(import) / 기본으로 import 안해도 되는 건 java.lang(위에 Math.PI 등!)
		// String name; 과 같은 취급
		now = new Date();
		System.out.println(""+now); //t는 날짜, 시간과 관련된 포맷이라는 뜻이다
		System.out.printf("오늘은 %tY년 %tm월 %td일 입니다. \n", now, now, now); //날짜는 %tY(대문자 소문자 구분 주의), %tm, %td 등을 씀
		System.out.printf("오늘은 %1$tY년 %1$tm월 %1$td일 입니다. \n", now); // 1개의 변수 안에서 다 찾아오겠다 -> 1$를 앞에 붙임(매개변수를 1개로 해주겠다는 뜻!)
		System.out.printf("지금은 %1$tH시 %1$tM분 %1$tS초 입니다. \n", now);
		
		//※ 포맷 정보 ※
	    // % : 출력형식을 의미하는 문자열은 반드시 %로 시작,
	    // %d : 정수 , %f 실수, %s 문자 
	    // %,d : 정수에 3자리마다  , 표시 
	    // %t : 날짜 시간을 나타내는 포맷
	    // %n , \n : 줄바꿈
	    // $ 사용하면 매개변수의 갯수를 줄일 수 있음
	    // => %2$d : 2번째 매개변수 정수
		
		// ** 출력 형식
		char c='A' ;
	    c = 'B' ;
	    int finger = 10 ;
	    long big = 100_000_000_000L ;
	    long hex = 0xFFFF_FFFF_FFFF_FFFFL ;
	    int octNum = 010 ; // 8진수 => 8
	    int hexNum = 0x10 ; // 16진수 => 16 
	    int binNum = 0b10 ; // 2진수 => 2
	    
	    System.out.printf("c=%c, %d %n", c, (int)c); // %c는 char 타입으로 출력 %n은 개행
	    System.out.printf("finger=[%5d] %n", finger);
	    System.out.printf("finger=[%-5d] %n", finger);
	    System.out.printf("finger=[%05d] %n", finger);
	    
	    System.out.printf("big=%d %n", big); // %d 10진수 형태로 출력 
	    System.out.printf("hex=%#x %n", hex); // hex를 16진수 형태로 출력해줌 -> %d 10진수로 출력하면 -1이 됨
	    // -> #은 16진수, 8진수의 접두사 (16진수 #x, 8진수 #o)
	    // -> 2진수는 따로 접두사가 없고, integer.tobinary 바꾸는 거 밖에 없음
	    
	    System.out.printf("octNum=%#o, %d %n", octNum, octNum);
	    System.out.printf("hexNum=%#x, %d %n", hexNum, hexNum);
	    System.out.printf("binNum=%s, %d %n", Integer.toBinaryString(binNum), binNum); //%s 형태(2진수 변환해줘야 함), %d 형태로 출력
	    
	    System.out.printf("Float.SIZE=%d %n", Float.SIZE); // float의 사이즈를 10진수 정수 형태로 출력(단위는 bit)
	    
	    // %-ㅁㅁ는 왼쪽 정렬방식(왼쪽부터 채워나감)
	    // 기본 : 문자와 숫자는 우측 맞춤
	    System.out.printf("%3d %10s %8s %-5d %n",1,"jang","장희정",20); // %-5d 는 20
	    System.out.printf("%3d %10s %8s %-5d %n",22,"hee","정효욱",03); // %-5d 는 3(왼쪽 맞춤이라 0생략하고 3맞춤)
	    System.out.printf("%3d %10s %8s %-5d %n",3,"rew97","장정희",20);
	    System.out.printf("%3d %10s %8s %-5d %n",4,"jang","장희정",20);
	    
	    
		
		
		
		
		
		
	} //main

} //class
