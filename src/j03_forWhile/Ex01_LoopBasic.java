package j03_forWhile;

//** 반복문 의 3요소 : 반복자의 초기값, 조건식(true or false-관계식), 증감식
// => for : for(초기값; 조건식; 증감식) {실행문Loop}
// => while, do while : 초기값(before while_Loop), 
//                      조건식(true or false => while 조건문(조건이 true인 동안 실행되어 지는 것)), 
//                      증감식(in while_Loop)

//** 반복자(iterator => 반복문에서 횟수를 count 하는 변수)

public class Ex01_LoopBasic {

	public static void main(String[] args) {
		//1. 1부터 100까지의 합 출력 => 1+2+3...+100
		
		// for문(중첩합 예시)
		int result = 0;
		int i=0;
		
		for (i=1; i<=100; i++) {
			result += i; // result=result+i
		} // for문
		System.out.println("** result :" +result);
		System.out.println("** after i :" +i); // -> i가 101이 됐을 때 조건에 맞지 않아서 아래로 그냥 내려옴 -> after i 값이 101이 된것
		
		// while문 => while(조건) {실행}
		result=0; // 초기화 다시 0으로 필수
		i=1;
		
		while (i<=100) {
			result += i;
			i++;
		}
		System.out.println("** while_result :" +result);
		System.out.println("** after i :" +i);
		
		// do_while
		result=0;
		i=0;
		do {
			result+=i;
			i++;
		} while (i<=100); // 0부터 시작했으니까 99까지 99번 돌기해야함, 1부터 시작했을때는 <=100[do while문이 끝났으니까 끝에;]
		System.out.println("** do_while_result :" +result);
		System.out.println("** after i :" +i);
		
		// ★while 과 do_while 차이점★
		// while : 조건 확인 후 실행 => i가 101일 경우 실행되지 않고 초기화한 result값 바로 출력
		// do-while : 조건을 실행하고 난 후 확인 => 최소 1번은 무조건 실행!!! i가 101일 경우 result는 조건에 안맞지만 1번은 돌려서 result:101값이 나옴
		// -> do while 쓰는 경우 : 
			
	} //main

} //class
