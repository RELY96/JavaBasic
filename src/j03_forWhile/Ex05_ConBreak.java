package j03_forWhile;

//** Continue 
//=> Continue 문 이하의 구문을 실행하지 않고 다음 반복문 진행이 계속되는 것(continue 이하 구문 실행X 반복)

//** Break
//=> 반복문 탈출

//** Label
//=> continue, break 가 적용될 반복문을 지정할 수 있도록 해줌 => 위치를 표시함
//  반드시 ":" 표시,
// 반드시 반복문 바로 위에 위치함.
// -> Lable 다음에 반복문 외의 문장이 오면 break, continue 에서 인식안됨 오류
// ★중첩문 안에도 Label 사용 가능

//** 과제
//=> 5층건물에 각 층마다 7개의 방이 있고 이것을 [층,호실] 출력하기 
//=> 4층 4호 는 창고이기 때문에 출력하지 않는다.

public class Ex05_ConBreak {

	public static void main(String[] args) {
		// 1) 모든 방 출력하기 => [1,1] [1,2] [1,3] ... [7,7]
		int i, j;
		for (i = 1; i <= 5; i++) {
			for (j = 1; j <= 7; j++) {
				System.out.printf("[%d, %d]", i, j);
			}
			System.out.println();
		}
		
		System.out.println("4,4 빼고 출력");
		// 2) 4층 4호만 출력 말기
		for (i = 1; i <= 5; i++) {
			for (j = 1; j <= 7; j++) {
				if (i==4 && j==4) continue; //4,4일때 continue이하(출력부분)하지말고 다음 반복으로 넘어가라 [4,5]부터 다시 출력
				System.out.printf("[%d, %d]", j, i);
			}
			System.out.println();
		}
		
		// 3) 4층은 3호 까지만 있음
		System.out.println("4층은 3호까지 있음");
		for (i = 1; i <= 5; i++) {
			for (j = 1; j <= 7; j++) {
				if (i==4 && j==4) break; //4층 4를 만났을 때 반복문 바로 탈출 -> 줄바꿈 실행 후 i반복문으로 감 -> i++로 증가해서 다시 실행 
				System.out.printf("[%d호 %d층]", j, i); //[ ]안쓰면 숫자가 붙어서 이상하게 보임
			}
			System.out.println();
		}
		
		// 4) Lebel_continue 적용
	    // => continue, break 를 원하는 반복문 에 적용
	    // => 원하는 반복문 위에 Labeling,(내가 원하는 이름) 사용 후 :로 표시   
		System.out.println("label continue 적용해서 반복문 전체 멈추기");
		apple:             //Labeling 뒤에는 반드시 반복문이 나와야 함!
		for (i = 1; i <= 5; i++) {
			for (j = 1; j <= 7; j++) {
				if (i==4 && j==4) continue apple; // [4,4]부터 apple 반복문i 를 생략 -> 4,4부터 4층 전체 안찍음!
				System.out.printf("[%d, %d]", i, j);
			} //for_j
			System.out.println(); 
		} //for_i
		
		// 5) Lebel_break 적용
		System.out.println("label break 적용해서 반복문 전체 멈추기");
		apple:             //Labeling 뒤에는 반드시 반복문이 나와야 함!
		for (i = 1; i <= 5; i++) {
			for (j = 1; j <= 7; j++) {
				if (i==4 && j==4) break apple; //break apple -> apple 반복문(i)를 아예 탈출해서 아예 그 뒤 반복문은 안 찍히고 멈춤
				System.out.printf("[%d, %d]", i, j);
			} //for_j
			System.out.println(); 
		} //for_i
		
		
		
		
	} // main

} // class
