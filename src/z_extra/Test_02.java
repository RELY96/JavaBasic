package z_extra;

// for문 이용해서 별 삼각형 출력 코드 작성

public class Test_02 {

	public static void main(String[] args) {
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*"); //i가 1일때 * j갯수 1(i<=j니까 1까지만 * 찍음)
			} //for_j
			System.out.println(" "); // 나머지는 다 공백
		} //for_i
	} //main
} //class
