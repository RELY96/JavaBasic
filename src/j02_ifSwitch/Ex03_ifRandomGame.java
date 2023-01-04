package j02_ifSwitch;

import java.util.Random;
import java.util.Scanner;

// 난수 if문을 활용한 랜덤게임 만들기 (내가 입력한 숫자가 random숫자랑 일치하면 '당첨')

//** 숫자 맞추기 게임 (Random 클래스 , 확률 1/10)
//=> 1~10 범위에서 숫자 하나를 입력받아
//=> 입력 숫자가 이 범위를 벗어나면 " 잘못 입력 했습니다. " 
// 다시 1~10 범위의 숫자를 입력 하세요   
//=> Random 함수의 결과와 일치하면 금메달
//=> 차이가 1 이면 은메달, 차이가 2면 동메달, 아니면 꽝

public class Ex03_ifRandomGame {
	
	public static void main(String[] args) {
		// 1) Random Number 구하기 (Random class 생성)
		Random rn = new Random(); //ctrl shift o -> 자동 import 됨
		int r = rn.nextInt(10)+1; //nextInt(bound매개변수) -> 들어가는 숫자의 범위 지정 가능 : ★(10)+1; => (최댓값)+최솟값
		
		// 2) MyNumber 입력받기
		Scanner sc = new Scanner(System.in);

		System.out.println(" ** 1~ 10까지의 정수를 입력하세요 ");
		int num=sc.nextInt(); //parseInt도 가능
		sc.close();
		
		// 2-1) 입력값에 대한 범위 확인
		if ( !( num >= 1 && num <= 10 ) ) { // 또는 (num < 1 || num > 10) 도 가능
			System.out.println("잘못 입력 했습니다. 다시 하세요"); // 다시 하는 거 말고 걍 끝내보면? -> Java는 return '타입'을 꼭 명시해야함 /js랑은 다름
			return; // ★★'return값이 없는' 매서드(void 매서드)에서 return을 단독으로 쓰면 -> "매서드 종료"됨 -> 밑에 문장 실행X!!!
		}
		
		// 3) 결과처리
		// => 절댓값 처리해주는 Math클래스의 매서드를 활용하면 좀 더 편리! : Math.abs
		System.out.printf(" 랜덤값 : %d , 입력값 : %d => " , r, num);
		if ( num == r ) System.out.println(" 금메달 ");
        else if ( num-r == 1 || num-r == -1 ) System.out.println(" 은메달 "); //num 이 큰지 r이 큰지 모르니까 차이가 1 or -1 일때로 || 만들기
        else if( num-r == 2 || num-r == -2) System.out.println(" 동메달 ");
		else System.out.println(" 꽝 ");
		
		// 비교1 (Math.abs)로 절댓값 처리
		System.out.printf(" 랜덤값 : %d , 입력값 : %d => " , r, num);
		if ( num == r ) System.out.println(" 금메달 ");
		else if( Math.abs(num-r) ==1 ) System.out.println(" 은메달 "); //num-r의 절댓값이 1이면
		else if( Math.abs(num-r) ==2 ) System.out.println(" 동메달 ");
		else System.out.println(" 꽝 ");
	
	} //main

} //class
