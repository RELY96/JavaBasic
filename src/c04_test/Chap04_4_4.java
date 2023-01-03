package c04_test;

public class Chap04_4_4 {

	public static void main(String[] args) {
		int sum=0;
		int i=0;
		for(i=1;;) {
			sum+=i;
			i++;
			i=-(i+i);
			if(sum>=100) break;
		}
		System.out.println("i가 몇일때?" +i);
	} //main

} //class
