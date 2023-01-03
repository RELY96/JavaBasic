package j03_forWhile;

//** 반복문의 중첩
//1) if 와의 중첩

//2) for , for 중첩
//=> 자전거를 1번 돌릴때마다 , 줄넘기를 10번 한다.
//=> 자전거 5회 돌릴때 까지 매번 과정의 횟수를 출력한다.
// 자전거 1 : 줄넘기 1,2,3,4,5,6,7,...10
// 자전거 2 : 줄넘기 1,2,3,4,5,6,7,...10
// [1,1] [1,2] [1,3] [1,4]......[1,10]
// [2,1] [2,2] [2,3] [2,4]......
//=> 전체 줄넘기 횟수 출력하기

public class Ex02_MultiLoop {

	public static void main(String[] args) {
		
		//1) if 와의 중첩
		//=> 자전거를 10바퀴를 돌리면 0.2Kg 감량 (if) => i를 10번 돌렸을 때 마다 계산해주기
		// 만약 자전거를 200바퀴를 돌렸을 때의 감량 출력하기 (for)
		double result=0;                               // 0.2kg이 실수니까 실수타입
		for (int i=1; i<=200; i++) {
			if( i%10 == 0 ) result+=0.2;                         //if i%10 == 0 이면 10번씩 돌리는 조건	
		} //정확하게 숫자를 카운트(200번 돌렸을 때 )하는 거니까 for문 사용
		System.out.println(" ** result(총감량) => "+(int)result);
		// 실수는 그 수랑 '가장 가까운 수'를 표현하는 것 <- 자릿수가 많을 수 있음
		
//		for (int i=100; i>=1; i--) {
//			result+=i;
//		}
		
		//======================================//
		
		//2) for , for 중첩 (이차원 배열에 적용되는 for for중첩)
		//=> 전체 줄넘기 횟수 출력하기
		int count =0; //전체 줄넘기 횟수 출력하기 위한 초기값
		
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=10; j++) {
				System.out.printf("[%d, %d] ", i, j );
				count++; // j돌고 i다 돈 만큼의 j 루프 => count++로 +1씩 줄넘기량 증가 //★★★
			} // j에 대한 for문
			System.out.println(""); //-> j끝나면 줄바꿈
		} //i에 대한 for문
		System.out.println(" ** count(총줄넘기량) => "+count);
		
		//======================================//
		
		// ** 연습
		// => 1~100까지의 정수중 3의 배수의 합 구하기
		int sum=0;
		for (int a=1; a<=100; a++) {
			if( a%3 ==0 ) sum+=a;
		}
		System.out.println("sum : " +sum);
		
		
		// => 다른 방법 : a가 3씩 증가한다면? a가 3부터 시작하고, a+=3;
		sum=0;
		for (int a=3; a<=100; ) {
			sum+=a;
			a+=3;
		}
		System.out.println("sum : " +sum);
		
	} //main

} //class
