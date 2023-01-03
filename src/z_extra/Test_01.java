package z_extra;

// 1) 중첩 for문 이용, 4x +5y =60
// 2) 해 구해서 (x,y) 형태로 출력 O
// 3) 조건 : x와 y는 10이하의 자연수(자연수는 1부터 시작하는 양수)
// => x는 0부터 시작, 10이하 / y 도 0부터 시작, 10이하

// => x가 1~10까지 돌때, if (4x+5y =60) 이면 sysout

public class Test_01 {

	public static void main(String[] args) {
		for(int x=1; x<=10; x++) { //1. x가 1~10까지 돌때
			for(int y=1; y<=10; y++) { //2. x 1당 y 1씩 증가하면서 돌고
				if((4*x+5*y) == 60) { //3. 도는 중에 4x+5y == 60 이면 sysout으로 출력
					System.out.printf("(%d,%d)",x,y);
				} //if문
			} //for y
		} // for x
	} // main
} // class
