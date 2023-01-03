package c05_test;

//2차원 배열

public class Chap05_5_4 {

	public static void main(String[] args) {
		int[][] arr = { { 5, 5, 5, 5, 5 }, { 10, 10, 10, 10, 10 }, { 20, 20, 20, 20, 20 }, { 30, 30, 30, 30, 30 } };
		//[4][5]인 꼴
		// 1) for(i 4)돌리기 안에
		// 2) for(j 5)돌리고 그 안에서 total, 평균 구하기 j가 끝나는 조건은 [i]의 length;만큼이면 확장 가능

		int total=0;
		float average =0;
		
		int i=0,j=0;
		
		for (i=0; i<arr.length; i++) {      //[]첫번째 돌리기
			for(j=0; j<arr[i].length; j++) { //[][]<-두번째 돌리기(크기는 각 첫번째 [i]의 크기 만큼)
				total+=arr[i][j]; //arr[][]하면 해당 값 출력 됨	
			}
		}
		average= (float)total/(i*j); //★ total 과 i*j 연산은 int로 이루어지기 때문에 16밖에 나올 수 없음 -> total을 float로 바꿔 연산해주면 해결!
		
		System.out.println("total : "+total);
		System.out.println("average : "+average);
		
	} // main

} // class
