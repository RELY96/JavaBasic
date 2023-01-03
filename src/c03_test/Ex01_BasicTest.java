package c03_test;

import java.util.Scanner;

public class Ex01_BasicTest {
	
	//** ★복습 과제
	//=> 이름과 나이를 입력하면 평생먹은 밥값 계산 후 출력하기
	//   한끼니당 5000 원으로
	//=> 예) 나이: 20살 -> 20 * 365 * 3 * 5000
	
	//ctrl shift o 는 자동 import

	public static void main(String[] args) {
		// 1) 입력받기
		Scanner sc=new Scanner(System.in); //system.in 출력창 불러오는 Scanner 클래스 변수 sc설정
		
		System.out.println("이름을 입력하세요");
		String name=sc.nextLine();          //이름 변수 설정(String 타입)
		
		System.out.println("나이를 입력하세요");		
		int age=Integer.parseInt(sc.nextLine()); //또는 끝이니까 nextInt 로 써도 됨 //나이 변수 설정(int 타입) <-Integer로 형변환 또는 nextInt사용 
		sc.close(); // 닫는 거 잊지 말기!!!
		
		// 2) 밥값 계산하기
		int result=age*365*3*5000; //밥값 계산 결과 변수로 만들어서 printf를 통해 쉽게 뽑기
					
		// 3) 출력하기
		System.out.println("이름 : " +name);
		System.out.println("나이 : " +age);
		System.out.printf("내가 먹은 밥값 : %,d 원 \n" , result);
		
	} //main

} //class
