package c06_test;

public class Chap06_6_16 {

	public static void change(String str) { // 메서드
		str += "456";
	}

	public static void main(String[] args) { // 메인 메서드
		String str = "ABC123";
		System.out.println(str); // ABC123
		change(str); // ABC123+=456
		System.out.println("After change : " + str); //ABC123 (위에 지역 String str이 그대로 나옴(매개변수 기본자료형만 전딜 -> 값이 변한게X))

	} // main
		// 결과예측 :

} // class
