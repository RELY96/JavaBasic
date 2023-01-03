package j01_basic;

public class Ex04_Oper01 {
	
//연산자(Operator)는 특정한 연산을 나타내는 기호
//피연산자(Operand)는 연산의 대상
//연산자의 우선순위 => ppt J03_02 , 23p

	public static void main(String[] args) {
		
		// **사칙연산
		int a=10, b=3;
		System.out.println("** 사칙연산 **");
		System.out.println(" a + b = " +(a+b)); //13
		System.out.println(" a + b = " +(a-b)); //7
		System.out.println(" a + b = " +(a*b)); //30
		System.out.println(" a + b = " +(a/b)); //3
		System.out.println(" a + b = " +(a%b)); //1
		
		// **대입연산(연산결과를 대입해주는 거) a=a+b => a+=b
		System.out.println("** 대입연산 **");
		System.out.println(" a += b => " +(a+=b)); // 13, a= 13
		System.out.println(" a -= b => " +(a-=b)); // 10, a= 13-3
		System.out.println(" a *= b => " +(a*=b)); // 30, a= 10*3
		System.out.println(" a /= b => " +(a/=b)); // 10, a= 30/3
		System.out.println(" a %= b => " +(a%=b)); // 1, a= 10%3
		
		// **단항연산(전에 증가 or 후에 증가?)
		// => 1씩 증감(전,후)
		a=10; b=10;
		System.out.println("** 단항연산 **");
		System.out.println(" ++a => " +(++a)); // 11로증가(+1)된 후 a값 출력 은 11, a -> 11로 값이 바뀜
		System.out.println(" b++ => " +(b++)); // b값 출력 후 증가 b -> 10, 후 b+1 11로 증가
		System.out.println(" --a => " +(--a)); // 10으로 -1 된 후 a값 출력 a -> 10
		System.out.println(" b-- => " +(b--)); // b값 11로 출력 후 -1 되서 b가 10으로 감소
		
		// **관계연산
		// => 모든 관계연산의 결과는 boolean Type : true / false
		a=10; b=3;
		System.out.println("** 관계연산 **");
		System.out.println(" a==b => " +(a==b)); // false
		System.out.println(" a!=b => " +(a!=b)); // true
		System.out.println(" a>b => " +(a>b)); // true
		System.out.println(" a>=b => " +(a>=b)); //true
		System.out.println(" a<b => " +(a<b)); //false
		System.out.println(" a<=b => " +(a<=b)); //false
		
		// **삼항식
	    // => (조건) ? 참 : 거짓 (String 포함, 모든 기본자료형에 적용 가능!)
		
	    // => a,b 중 큰값 출력하기 는? a>b 이면 a출력, 아니면 b출력하는 식 -> 
		int max = (a>b) ? a : b;
		
		// => true false 값으로 반환하기
		boolean bool = (a>b) ? true : false;
		
		// => char 값으로 반환하기
		char cc = (a>b) ? 'T' : 'F';
		
		// => String 값으로 반환하기
		String ss = (a>b) ? "참" : "거짓";
		
		System.out.println("** 삼항식 **");
		System.out.printf("max=%d, bool=%b, cc=%s, ss=%s \n", max, bool, cc, ss);
				
		// **논리(집합) 연산
		// => AND && , OR || , NOT !
		System.out.println("** 논리(집합) 연산 **");
		
		// 1) a,b 모두 짝수이면 true => a가 짝수인지확인 && b가 짝수인지확인
		bool= (a%2==0) && (b%2==0);
		System.out.println("** && => "+bool); // false
						
		// 2) a,b 중 하나만 짝수이면 true		
		bool= (a%2==0) || (b%2==0);
		System.out.println("** || => "+bool); //true
		
		// 3) 부정, NOT
		System.out.println("** NOT => "+!bool); //위 bool 이 true라 !true 해서 false 나옴
		
	} //main

} //class
