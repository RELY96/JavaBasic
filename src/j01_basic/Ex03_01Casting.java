package j01_basic;

//** Type Casting (형변환)
//1. 자동 (프로모션 promotion , 확대 형변환)
// => 큰 자료형에 작은 자료형을 대입하면 : 자동으로 이루어짐

//2. 강제 (디모션 demotion, 축소 형변환) type이 다르거나 왼편 크기가 오른편보다 작을 때
// => 작은 자료형에 큰 자료형을 대입 : 자동으로 이루어지지 않음
// => 자료의 Type이 다른경우
// => 명시적 형변환


public class Ex03_01Casting {

	public static void main(String[] args) {
		
		//1. 자동 (프로모션 promotion , 확대 형변환)
		double d =123.456; // 8byte
		int i=123456; //4byte
		
		d=i; //d 에 i 넣기 -> 자동으로 promotion 이루어짐
		System.out.println("** After Promotion i => " +i);
		System.out.println("** After Promotion d => " +d); // i로 달라짐(실수형이니까 .0붙어서 출력)
		
		
		//2. 강제 (디모션 demotion, 축소 형변환)
		// 1) 타입이 똑같지만 받는 쪽 크기가 작은 경우
		
		
		//★ 2) 자료의 Type이 다른 경우(ex: char 를 int 타입으로)
		// 2-1) type 다르고 크기 다른 경우 
		char c='C'; //2byte
		System.out.println("** char c => "+c+" , "+(int)c); //다른 타입인 c를 int로 정수형 강제 변환
		i=c+1; // c가 char type 이니까 c+1 문자열 연산되도 i에 들어가지 못함, but! char 가 숫자랑 연산을 하게 되면 산술연산이 자동 적용됨
		System.out.println("** i => " +i+ " , " +c); // 산술연산 적용된 68, 그냥 문자c
		System.out.println("** i => " +i+ " , " +(char)i+" , c="+c); // int 형태인 i를 char로 형변환 -> 68이니까 d가 나옴!
		
		// 2-1) type 다르고 크기 같은 경우(ex; int, float)
		float f=456.78f; //4byte
		int n=100; //4byte
		
//		n=f; //n에다 f넣기 error:Type mismatch <- demotion 필요함
		n=(int)f;// (n=f는 f실수가 n에 가면 절삭되야 하니까 들어갈 수 없음 -> 강제형변환)
		System.out.println("** int n => "+n);
		
		f=n; //f에다 n넣기 no error -> promotion이 일어난 것! -> 부동소수점에 의해 실수float가 int보다 숫자를 더 크게 표현할 수 있어서 f=n으로 해도 error가 안남
		System.out.println("** int f => "+f);
		
		//★★ 3) 정수형 연산 ★★
	    // => 4byte 이하 type 의 "정수형 연산"의 경우 무조건 그 결과는 int (4byte) 로 처리 -> 오류가 생길 수 있음
		short s1=10, s2=20, s3=0;
//		s3=s1+s2; // 연산결과(s1+s2)는 자동으로 int처리되서 short s3 안에 int 넣을 수 없는 Type mismatch 오류남! => 형변환 필요함(우변의 연산 결과를 short로 형변환 해주면 해결)
		s3=(short)(s1+s2);
		
		
		// ※숫자와 관련해서 알아둬야 할 사항	
	    //1. by 0(나누기 0) ERROR , 오버플로우(Overflow)/언더플로우(Underflow)
		
	    //1-1) 정수형 연산에서 0 나누기
	    // => 컴파일에서는 오류 없음
	    //    실행(런타임)시에는 오류 : java.lang.ArithmeticException: / by zero
		n=11;
//		System.out.println("** 정수형 by 0 , 나누기 => "+(n/0));
//		System.out.println("** 정수형 by 0 , 나머지 => "+(n%0));
			      
	    //1-2) 실수형 연산에서 0 나누기
	    // => 컴파일, 런타임(Exception) 오류 없음
		//           연산결과는 infinity(무한수)와 나머지 NaN값 나옴
		f=123.567f;
		System.out.println("** 실수형 by 0 , 나누기 => "+(f/0));
		System.out.println("** 실수형 by 0 , 나머지 => "+(f%0));
		// 오버플로우 : Infinity(기계가 표현할 수 있는 최댓값의 한계를 넘어버림)
		// 언더플로우 : NaN(숫자를 표현할 수 없을 정도로 작아지면, 기계가 표현할 수 있는 최솟값의 한계를 넘어버림)
	      	 
	    //1-3) 정수형 연산의 오버플로우(Overflow) / 언더플로우(Underflow)
		short sMax=Short.MAX_VALUE; //max +1 이면 overflow
		short sMin=Short.MIN_VALUE; //min -1 이면 underflow
		
	      // => 오버플로우(Overflow) Test : 최소값과 동일  
	      System.out.println("**i: sMax="+sMax+", sMax+1="+(sMax+1)); // (sMax+1)은 ()로 해서 정상적 int 연산 -> overflow 일어나지X
	      System.out.println("**s: sMax="+sMax+", sMax+1="+(short)(sMax+1)); //(short)해야 overflow 일어남 -> 정수형의 overflow는 최솟값과 동일함!!!★
	      // 2byte : 1111 1111 1111 1111 + 1 => 1 0000 0000 0000 0000 에서 short(16자리)니까 맨앞 1이 잘려서 최솟값이 됨
	      
	      // => 언더플로우(Underflow) Test : 최대값과 동일 
	      System.out.println("**i: sMin="+sMin+", sMin-1="+(sMin-1)); // 정상적 int 연산      
	      System.out.println("**s: sMin="+sMin+", sMin-1="+(short)(sMin-1)); // 정수형의 overflow는 최댓값과 동일함!!!★
	      // 0000 0000 0000 0000  -1 => 1111 1111 1111 1111 (최솟값에서 -1 하면 다시 최댓값 1111 1111 1111 1111) 로 돌아감
	      
	} //main

} //class
