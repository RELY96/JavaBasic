package j04_array;

// 다차원 배열
// 1. 2차원 배열(1차원이 두개 모이면 2차원)
// 2. 3차원 배열(1차원이 세개 모이면 3차원) ... 2차원 이상은 거의 안쓰임

public class Ex03_MultiArray {

	public static void main(String[] args) {
		// 1. 2차원 배열의 명시적 선언
		int[][] mul = new int[2][3]; // 2,3의 사이즈 지정 -> 2*3짜리 사이즈 배열
		// => mul = {{10,20,30} , {11,22,33}}꼴 <-배열안에 배열 두개[2] 각각 안에 배열3개씩[3]
		mul[0][0] = 10; // 0에서 0 -> 10으로 초기화
		mul[0][1] = 20;
		mul[0][2] = 30;

		mul[1][0] = 11;
		mul[1][1] = 22;
		mul[1][2] = 33;
		// int의 초기값은 0므로, mul[1][2]값 초기화를 안했을 경우엔 자동적으로 0이 됨
		mul[0][0] = mul[1][1] + mul[1][2]; // [1][2]초기화 안하면 22, 초기화하면 55

		// => 출력
		System.out.println("2차원 배열의 명시적 선언");
		for (int i = 0; i < mul.length; i++) {
			for (int j = 0; j < mul[i].length; j++) { //mul[i]의 length이면 -> mul[1]의 배열[0,1,2]와 mul[2]의 배열[0,1,2] 6개 모두 출력됨! 
				System.out.printf("mul[%d,%d] = %d \n", i, j, mul[i][j]);
			}
		}
		
		//==================================================================//
		
		// 2. 2차원 배열의 묵시적 선언
		int[][] mul2 = { { 100, 101, 102 }, { 111, 222 }, { 555 } };
		// => 명시적으로 내부배열 크기가 정의되어 있지 않으면 묵시적 선언은 각각의 크기를 가짐(가지고 있는 만큼만 크기를 가짐)
		
		// => 출력
		System.out.println("2차원 배열의 묵시적 선언");
		for (int i = 0; i < mul2.length; i++) {
			for (int j = 0; j < mul2[i].length; j++) {   //i[배열]에 해당되는 크기만큼 j를 찍으라 했기 때문에, j는 알아서 mul2[i].length 만큼 찍힘 
				System.out.printf("mul2[%d,%d] = %d \n", i, j, mul2[i][j]);
			}
		}
	} // main

} // class
