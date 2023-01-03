package j01_basic;

import java.util.Scanner; //java.util.Scanner import함

public class Ex06_Scanner {

	public static void main(String[] args) {
		// 1. 입력받기(입력받는 역할을 하는 건 scanner class임)
		Scanner sc=new Scanner(System.in); //import 필요 + //scanner은 생성할 때 ()에 매개변수 System.in 를 넣어줘야함 
		// System.in 은 옆에 입력창을 띄우는 매개변수를 쓰는 것과 같은 것
		// => String name="홍길동" 과 같은 의미! (Scanner 도 참조자료형, 참조변수)
		
		System.out.println("** 이름을 입력 하세요 !! => ");	
		String name=sc.nextLine(); //콘솔로부터 입력받는 값을 name에 넣기 // => 우측 동작 처리 완료하고 좌측name에 넣어주는 동작 하는 문장
		//sc.nextLine();은 입력 완료가 될 때 까지 대기하고 있음(★Enter_Key 기준), 입력완료된 값을 return함
		
		System.out.println("** 나이를 입력 하세요 !! => ");	
//		int age=Integer.parseInt(sc.nextLine()) ;  // int로 출력하고 싶을 땐 형변환(String 출력도 가능!)
		int age=sc.nextInt();
		// 1-1) 도 윗줄처럼 똑같이 가능! But, nextInt()를 쓰면 Int값만 가져와서 sc에 넣어줌(enterkey값은 가져가지 못하고 남아있음)
		// 1-2) nextLine은 엔터키까지 sc에 넣어줌
		// 2) nextInt 에서 처리되지 못하고 남은 enterkey가 아래 nextLine에서 인식되서 쓰기도 전에 끝나버림!
		
		System.out.println("** 금액을 입력 하세요 !! => "); //Int Int 는 상관없음(아래 Int도 Enter를 안 가져가니까 정상실행됨)
		int price=sc.nextInt();
		
		System.out.println("** 메뉴를 입력 하세요 !! => ");	
		String menu=sc.nextLine(); // 아래문장으로 흘러가버림(nextInt() 가 두고간 Enter_Key 를 인식하기 때문)
		
		// 2. 출력하기 => 모든게 제대로 출력되게 하려면 nextLine()만 쓰는 게 좋음!
		System.out.println(" ** 이름 => "+name);
		System.out.println(" ** 나이 => "+age);
		System.out.println(" ** 금액 => "+price);
		System.out.println(" ** 메뉴 => "+menu);
		sc.close(); //★입출력과 관련된 애들은 자동으로 가비지콜렉터가 안되기 때문에 쓸 일이 없으면 닫아줘야함(close)(쓸 일이 없으면 인위적으로 지워주는 것)
						
	} //main

} //class
