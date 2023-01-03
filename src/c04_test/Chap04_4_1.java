package c04_test;

public class Chap04_4_1 {

	public static void main(String[] args) {
		char ch = '8';
		if (ch >= '0' && ch <= '9') {
			System.out.println("true");
		}
		// ----------------------------------
//		char A = 'A';
//		char z = 'z';
//		System.out.println("" + (int) A);
//		System.out.println("" + (int) z);
		ch = 'H';
		if ((int) ch >= 65 && (int) ch <= 122) {
			System.out.println("ch는 영문자(대소문자), true");
		}
		// ----------------------------------
		int year = 36;
		if (year % 400 == 0) {
			System.out.println("true");
		} else if (year % 4 == 0 && year % 100 != 0) {
			System.out.println("true");
		}
		// ----------------------------------
		boolean powerOn = false;
		if (powerOn == false) {
			System.out.println("true");
		}
		// ----------------------------------
		String str ="yes";
		if (str =="yes") {
			System.out.println("true");
		}

	} // main

} // class
