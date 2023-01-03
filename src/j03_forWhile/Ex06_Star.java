package j03_forWhile;

//반복문 사용해 2차원 도형 찍기

public class Ex06_Star {

	public static void main(String[] args) {
		// 1) 반삼각형
		// => * 을 1개 부터 시작해서 갯수를 늘려가면서 9 line 출력
		// => 각 행별로 행번호 갯수만큼 출력하기
		System.out.println("1) 반삼각형 ");

		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 2) 피라미드
		System.out.println("2) 피라미드 ");
		int line = 10;
		// space 그리는 반복문과 별 그리는 반복문 2개 필요
		for (int i = 1; i <= line; i++) {
			// 반복문 1: space
			for (int j = 1; j <= line - i; j++) { // line보다 한개 작을때까지 공백이니까 line 기준으로 공백잡기 -> line-1 보다 1작은 수까지 공백
				System.out.print(" ");
			}
			// 반복문 2: * (앞에서 "공백" 잡아줬으니까 뒷 별 갯수로 따짐 -> 1행 일때1, 2)
			for (int t = 1; t < (i * 2); t++) { // 2*line(i) -1 이 별의 갯수 -> <=2*i-1 -> <2*i
				System.out.print("*");
			}
			System.out.println(); // 별 끝나면 줄 바꿈
		}

		// 3) 다이아몬드
		System.out.println("3) 다이아몬드 ");
		// 상부출력
		for (int i = 1; i <= line; i++) {
			for (int j = 1; j < line - i+1; j++) {    //중간 전까지 공백 -> line -i +1 은 무조건 1부터 시작
				System.out.print(" ");
			}
			for (int t = 1; t < (i * 2); t++) {   //별 개수
				System.out.print("*");
			}
			System.out.println();
		}
		// 하부출력 -> 감소
		for (int i = line-1; i >=1; i--) {
			for (int j = 1; j <= line - i; j++) { 
				System.out.print(" ");
			}
			for (int t = 1; t < (i * 2); t++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// 4) 모래시계
		System.out.println("4) 모래시계 ");
		for (int i = line-1; i >=1; i--) {
			for (int j = 1; j <= line - i-1; j++) { 
				System.out.print(" ");
			}
			for (int t = 1; t <= (i * 2)+1; t++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 1; i <= line; i++) {
			for (int j = 1; j <= line - i; j++) { 
				System.out.print(" ");
			}
			for (int t = 1; t < (i * 2); t++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		

	} // main

} // class
