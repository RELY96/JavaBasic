package c04_test;

//Math.random() * (최댓값) + 최솟값; 최솟값 이상 최댓값 이하의 난수 소환

public class Chap04_4_8 {

	public static void main(String[] args) {
		int value = (int)((Math.random() * 6) + 1);
		
		System.out.println("value : "+value);

	} //main

} //class
