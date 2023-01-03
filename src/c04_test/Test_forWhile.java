package c04_test;

public class Test_forWhile {

	public static void main(String[] args) {
		// 1. 20~58 까지 뽑기
		int i = 0;

		for (i = 19; i < 58;) {
			i++;
			System.out.println("" + i);
		}

		for (i = 20; i < 59;) {
			System.out.println("" + i);
			i++;
		}

		// 2. 30~-19 누적합 구하기
		for (i = 31; i > -19;) {
			i--;
			System.out.println("" + i);
		}

		for (i = 30; i < -18;) {
			System.out.println("" + i);
			i--;
		}

	} // main

} // class
