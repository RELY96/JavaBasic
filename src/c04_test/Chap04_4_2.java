package c04_test;

public class Chap04_4_2 {

	public static void main(String[] args) {
		int sum=0;
		int i=0;
		
		// 총합 구하기
		for(i=1; i<=20; i++) {
			if( i%2!=0 && i%3!=0) {
				sum+=i;
			} 
		}
		System.out.println("i의 총합은"+sum);
		// 2468101214161820 1 5 7 11 13 17 19
		// 369121518
		
	} //main

} //class
