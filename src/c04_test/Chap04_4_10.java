package c04_test;

import java.util.Random;
import java.util.Scanner;

public class Chap04_4_10 {

	public static void main(String[] args) {
		Random rn = new Random();
		int answer = rn.nextInt(100) + 1;
		int input = 0;
		int count = 0;

		Scanner s = new Scanner(System.in);

		do {
			count++;
			System.out.print("1과 100사이의 값을 입력하세요 : ");
			input = s.nextInt();

			if (answer == input) {
				break;
			} else if (answer > input) {
				System.out.println("더 큰수를 입력하세요");
			} else {
				System.out.println("더 작은수를 입력하세요");
			}
		} while (true);
		System.out.printf("당신의 시도횟수 %d번, 값 %d 을 맞췄습니다", count, answer);
	} // main

} // class
