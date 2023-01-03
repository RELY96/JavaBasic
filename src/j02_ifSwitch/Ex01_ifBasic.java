package j02_ifSwitch;

public class Ex01_ifBasic {

	public static void main(String[] args) {
		System.out.println("** 삼항식 결과 **");
		// ** 삼항식 -> if
		// => a,b 중 큰수 출력하기
		int a=10, b=3;
//		int max=(a>b) ? a : b;
		int max;
		
		//★if문 형식
		//if(조건문) 실행문 > 모든 조건문은 "관계식"이다(결과는 boolean값)
		//else 실행문
		
		if(a > b) max=a;
		else max=b;	
		System.out.println("a,b중 큰 수는 ? " +max);
		
		//boolean타입으로 if문 활용해서 true, false 값 내기
		boolean bool=(a>b)? true : false;
		if (a>b) bool=true;
		else bool=false;
		System.out.println("a가 b보다 큰가 ? " +bool);
		
		// 캐릭터 타입으로 if문 내보기
		char cc = ( a > b )? 'T' : 'F';
		if ( a > b ) cc='T';
		else cc='F';
		System.out.println("a가 b보다 큰가 ? " +cc);
		
		System.out.println("** 삼항식 결과 printf로 출력 **");
		System.out.printf("max=%d, bool=%b, cc=%c \n", max, bool, cc);
		
		
		//======= ★여러 문장이 오는 복합문(compound statement) ======//
		
		//중괄호로 문장들 그룹핑
		String ss= (a < b) ? "참" : "거짓";
		if(a != b) {
			ss="다르다";
			cc='T'; // 다르니? 라고 물었으니 다른게 맞으니 'T' -> 조건문이 뭐라고 물어봤느냐에 따라 답이 달라짐
			bool=true; // "
		} else {
			ss="같다";
			cc='F';
			bool=false;
		} //else 는 생략가능		
		System.out.printf("max=%d, bool=%b, cc=%c, ss=%s \n", max, bool, cc, ss);
		
		//======= ★else 생략 예제 ======//
		//a+b 가 100보다 작을 때만 "당첨"출력 하기
		if( a+b < 100 ) System.out.println(" ** 당첨 ** ");
		
		//===== ★ 연산자들 간의 우선순위 =====//
		// 1) 단항(+-) 과 +*/-% 산술연산자들
		// 2) 관계식(> < >= <= == !=) 과 논리식(&& ||)
		
		
	} //main

} //class
