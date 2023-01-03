package j02_ifSwitch;

import java.util.Random;
import java.util.Scanner;

public class Ex05_switchRandomGame {

	public static void main(String[] args) {
		Random rn = new Random();
		int r=rn.nextInt(10)+1;
		
		Scanner sc = new Scanner(System.in);	
		System.out.println(" ** 1~ 10까지의 정수를 입력하세요 ");
		int num=sc.nextInt();
		sc.close();
		
		System.out.printf(" 랜덤값 : %d , 입력값 : %d " , r, num);
		
		if ( num < 1 || num > 10) { 
			System.out.println("잘못 입력 했습니다. 다시 하세요"); 
			return; 
		}
		
		// int abs = Math.abs(num-r) 해서 switch 조건으로 넣어줘도 컴퓨터 계산량이 줄어서 좋음(단, 여러번 활용할 경우에만!)
		switch ( Math.abs(num-r) ) {
		case 0 : System.out.println(" 금메달 ");
			     break;
		case 1 : System.out.println(" 은메달 ");
				 break;
		case 2 : System.out.println(" 동메달 ");
				 break;
		default : System.out.println(" 꽝 ");
		}	
		
	} //main

} //class
