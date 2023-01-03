package j03_forWhile;

//break; -> 현재 동작중인 반복문을 멈추기, 탈출함

public class Ex03_infinityLoop {

	public static void main(String[] args) {
		
		// 1) for , 항상 참이되서 무한루프
		int count=0;
		System.out.println("** 무한 Loop Test : for **");
		for(;;) {    // 무조건 -> 무한루프 (초기값도 없고 증감식도 없고 조건도 없어서 계속 돌아감)
			count++;
			System.out.println("** count :" +count);
			if(count>100) break; //101일 때 break 걸리게 조건 설정
		}
		
		// 2) while => true일때 무조건 루프니까 while 안 조건에 true 넣어서 무한루프 만들기
		System.out.println("** 무한 Loop Test : while **");
		count=0;
		while(true) {
			count++;
			System.out.println("** count :" +count);
			if(count>100) break;	
		}
		
		// 3) do_while
		System.out.println("** 무한 Loop Test : do-while **");
		count=0;
		do {
			count++;
			System.out.println("** count :" +count);
			if(count>100) break;
		} while(true);
		
		// 4) 조건문 무조건 실행
		if(true) System.out.println("** TRUE **");
	} //main

} //class
