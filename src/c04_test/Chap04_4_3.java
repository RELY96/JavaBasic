package c04_test;

public class Chap04_4_3 {

	public static void main(String[] args) {
		// 1~10 까지 누적합 구하기
		int sum=0;
		int i=0;
		for (i=1; i<=10; i++) {
			sum+=i;
		}
		System.out.println("1~10까지의 누적합 : " +sum);
	} //main

} //class
