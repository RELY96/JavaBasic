package c04_test;

//두 개의 주사위를 던졌을 때, 눈의 합이 6이 되는 모든 경우의 수

public class Chap04_4_6 {

	public static void main(String[] args) {
		int dice1 = (int)(Math.random() * 6) + 1;
		int dice2 = (int)(Math.random() * 6) + 1;

		if (dice1 + dice2 == 6) {
			System.out.printf("[%d, %d] ", dice1, dice2);
			System.out.println();
		}

	} // main
} // class
