package j05_ClassMethod;

//팩토리얼 연산 시 매서드 재귀적 호출 많이씀

//** 재귀적 호출 ( Recursive Call )
//=> 메서드가 메서드 내부에서 자신을 호출
//=> Factorial 연산에 주로 이용됨 
//=> 5! = 5*4*3*2*1
// n! = n*(n-1)*(n-1-1)*(n-1-1-1)...*1

public class Ex04_Factorial {
	// 팩토리얼 연산 만들어 보기
	public static int factorial(int n) {
		if (n == 1)
			return 1; // 1까지 곱하면 끝나는 거(n==1 이면 1만 return 끝)
		return n * factorial(n - 1); // 매서드 내부에서 계속 자기 자신을 호출

		// 5!=>5*fa(4) -> 4*fa(3) -> 3*fa(2) -> 2*fa(1)
		//     fa(4)return 하려고 봤더니 factorial(n-1)을 다시 처리해야함 -> 안으로 안으로 반복(1이 될때까지)
		// 결과값 출력은 <- 방향으로 진행 : factorial(n)은 따로 눈에 보이는 것처럼 연산되는 모습이 아니라 그안에 계속 과정을 담고 있는거라 생략된 것처럼 보이는 거
		
		// 재귀 호출은 '나'니까 static이랑 관계 없음
		
	} // factorial

	public static void main(String[] args) {
		//static : main에서 인스턴스 생성없이 factorial()사용하려면 fa매서드에 static붙여줘야 함
		
		// ** Recursive_Call Test
		System.out.println("** 10! : "+factorial(10));
		System.out.println("** 5! : "+factorial(5));
	}

}
