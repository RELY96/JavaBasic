package c04_test;

public class Chap04_4_7 {

	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;

		for (int i = 0; i < str.length(); i++) {
			System.out.println("" + str.charAt(i)); // ->char 형태 -> 산술연산시 ascii로 변환 -> int값 미리 빼줘야 함
			System.out.println((int)(str.charAt(i)));

			i = (str.charAt(i)) - '0';
			sum = sum + i;
		}
		System.out.println("sum=" + sum);

	} // main

} // class
