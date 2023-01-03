package z_extra;

//balance(base)가 0, Scanner 입력값이 예금액, 출금액, 잔고 계산

// ★★!!!switch문 이용해서 다시 풀기!!!★★

import java.util.Scanner;

public class Test_03 {

	public static void main(String[] args) {
		boolean run = true;
		int balance = 0;
		
		/*int count=0;*/
		
		Scanner scanner = new Scanner(System.in); //scanner 입력 받는 인스턴스 생성
		
		while(run) { //true로 무한반복
			
			System.out.println("-------------------------");
			System.out.println("1.예금, 2.출금, 3.잔고, 4.종료");
			System.out.println("-------------------------");
			
			System.out.println("선택 > ");
			int select = scanner.nextInt();
	
			int deposit = 0; int withdraw=0;
			
			// 1) 예금 입력
			if (select == 1) {
				deposit = scanner.nextInt(); // 예금
				System.out.println("예금액 > "+deposit);
			}
			
			
			//--------------------------------------------------------------//
			
			// 2) 출금 입력
			if(select == 2) {
				withdraw = scanner.nextInt(); // 출금
				System.out.println("출금액 > "+withdraw);
			}
			
			//--------------------------------------------------------------//
			
			// 3) 잔고 계산
			if(select == 3) {
				System.out.println("잔고 > "+((balance+deposit)-withdraw));
			}
			
			//--------------------------------------------------------------//
			
			// 4) 4번째 종료
			if(select ==4) {
				System.out.println("프로그램 종료");
				break;
			}
				
		} //while
	} //main
} //class
