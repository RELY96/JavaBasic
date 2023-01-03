package j04_array;

import java.util.Arrays;

// Type별 배열정의 후 출력(묵시적 정의와 eachFor문 활용)
// => float , char, String
// => data 갯수는 5개

public class Ex02_ArrayType {

	public static void main(String[] args) {
		float weight[] = { 1.1f, 1.2f, 1.3f, 1.4f, 1.5f };
		for (float f : weight) {
//			System.out.printf("float : %f /n", f);
			System.out.print(f+" ");	
		}
		System.out.println();

		char c[] = { 'a', 'b', 'c', 'd', 'e' };
		for (char cc : c) {
//			System.out.printf("char : %c \n", cc);
			System.out.print(cc+" ");
		}
		System.out.println();

		String s[] = { "AA", "BB", "CC", "DD", "EE" };
		for (String ss : s) {
//			System.out.printf("String : %s \n", ss);
			System.out.print(ss+" ");
		}
		System.out.println();
		
		
		System.out.println("배열의 래퍼클래스 Arrays");
		//** 배열의 Wrapper Class : Arrays(모든 타입의 배열을 '간단하게' String형태로 리턴해줌)
		System.out.println("float : " +Arrays.toString(weight)); //float[]을 String형태로 만들어 출력해줌
		System.out.println("char : " +Arrays.toString(c)); //char[]을 String형태로 출력
		System.out.println("char : " +Arrays.toString(s)); //매개변수에 object로 할 수 있음 : ★Object는 모든 클래스의 조상임
		//(매개변수 object)사용하면 모든 클래스 넣을 수 있음 

	} // main

} // class
