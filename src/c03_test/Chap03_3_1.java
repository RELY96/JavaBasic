package c03_test;

public class Chap03_3_1 {

	public static void main(String[] args) {
		int x =2;
		int y =5;
		char c= 'A'; //65 
		
		System.out.println(y>=5|| x<0 && x>2); // true ( ||보다 && 먼저 연산!)
		
		System.out.println(y +=10 - x++); // y=15, x=2(후 증가) => 13
		System.out.println(x+=2); // x=5 (3+2) 
		System.out.println(!('A' <=c && c<= 'Z')); // !(true) => false
		System.out.println('C'-c); // 2
		System.out.println('5'-'0'); // 5
		System.out.println(c+1); // c+1 = 66
		System.out.println(++c); // c= 66 char B
		System.out.println(c++); // c=66 char B 후 +1 
		System.out.println(c); // c= 67 char C  

	} //main

} //class
