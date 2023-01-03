package c04_test;

//for문을 while문으로 변경하기 ?★?

public class Chap04_4_5 {

	public static void main(String[] args) {
//		for (int i = 0; i <= 10; i++) {
//			for (int j = 0; j <= i; j++) {
//				System.out.print("*");
//				System.out.println();
//			}
//		}

// ========================================//
		int j = 0;
		int i = 0;
		while (i <= 10) {
			while (j <= i) {
				System.out.print("*");
				System.out.println();
				j++;
			}
			i++;
		}

	} // main

} // class
