package j04_array;

public class Ex01_ArrayBasic {

	// 배열 사용하려면 : 선언하고 사용해야 함
	// 동일 타입에서 배열처리 가능

	// ** 배열 : 동일성격의 동일Type 의 자료를 하나의 묶음으로 처리
	// 장점 => 일괄처리 (반복문적용)
	// 특징 => 동일 타입 이어야 함 / 모든 자료형(기본자료형, 참조자료형)에 적용가능

	// 배열 사용 방법
	// => 선언 후 사용 : 명시적선언, 묵시적선언
	// => 크기(length), 인덱스(0 부터 length-1)

	// 1. 명시적 선언 (★new 연산자 이용해서 객체 생성하듯이 정확하게 생성) => 크기를 반드시 지정해야 함

	public static void main(String[] args) {
		// ** 과제
		// => 5명 성적 처리

		System.out.println("명시적 선언");
		// 명시적 선언(new 연산자 이용)
//		int[] score = new int[5];                     //int타입의 배열로써 score = new int [반드시 크기 지정];
		// -> int타입의 배열이 만들어짐(4byte짜리 5개 공간 확보해서 공간의 이름(변수명) score)

		// 1) []위치 변수명 뒤에도 가능 -> int score[] =new int[5];
		// 2) 선언만 하고 나중에 초기화도 가능
		int score[]; // score를 int type의 배열로 사용하겠다
		score = new int[5]; // 초기화시, [크기]를 크기가 정해진 변수(초기화된 변수)로도 설정 가능 (ex:int len =5; [len])

		// 2. 배열 변수 초기화하기
		score[0] = 10;
		score[1] = 11;
		score[2] = 12;
		score[3] = 13;
		score[4] = 14;
//		score[5]=15; // 이럴경우 런타임 오류 발생(공간을 5로 잡아주지 않아서 공간이 모자람)

		System.out.println("명시적 선언 배열 사용");
		// 3. 초기화 후 사용하기
		// 1) 합계 출력
		int sum = score[0] + score[1] + score[2] + score[3] + score[4];
		System.out.println("**score의 크기 : " + score.length); // length 사용
		System.out.println("**sum1 : " + sum);

		// ★★ 2) 학생들 점수 출력, 합계 출력(반복문 사용, 배열 일괄처리)
		sum = 0;
		for (int i = 0; i < score.length; i++) {
			sum += score[i]; // 합계 계산
			System.out.printf("%d번 , %d점 \n", i + 1, score[i]);
		}
		System.out.println("**sum2 : " + sum);

		//=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*//
		
		// 묵시적 선언(선언과 동시에 초기화 하는 것/new연산자 사용X)
		System.out.println("묵시적 선언과 eachFor문");
		int score2[] = { 50, 60, 70, 80, 90 }; // 배열 초기화는 중괄호, {}안에 숫자 넣어서 배열 할당하기
		
		// 배열을 간단하게 처리할 수 있는 쉬운 for문 -> eachFor
	    // 6. eachFor (쉬운, 간편한 for 구문)
	    // for each 문 : JDK5.0 부터 지원되는 향상된 for 문 
	    // for (변수타입 변수명 : 배열이름 ) { 실행부  }
	    // => 배열의 요소의 갯수(배열의 크기) 만큼 반복 하며
	    //    배열  score 가 가지고 있는 값을 순차적으로  변수(s) 에 전달 
	    // => 주의사항★
	    //    배열의 값만 ★순차적으로 사용가능!! read만 가능, write 불가능 <-배열 안 값을 수정 불가하다는 뜻
	    //    (순차처리, readOnly)
		System.out.println("묵시적 선언과 eachFor문 배열 사용");
		sum=0;
		for(int s:score2) { //int s선언:배열변수 => score2 배열에 들어있는 값들을 반복문 돌리면서 s에 순차적으로 전달(s의 타입은 score의 타입에 맞춰줘야 함)
			System.out.printf("점수 = %d점 \n", s); //이 문은 인덱스는 없기 때문에 i를 가져올 순 없음
			sum+=s;
		}
		System.out.println("**sum3 : " + sum);
		
		//-----------------------------------------------//
		
		System.out.println("묵시적 선언과 일반 for문 사용");
		sum = 0;
		for (int i = 0; i < score2.length; i++) {
			sum += score2[i]; // 합계 계산
			System.out.printf("%d번 , %d점 \n", i + 1, score2[i]);
		}
		System.out.println("**sum2 : " + sum);
		
		
		
		
		
		
		
		
		
		
		
		
		

	} // main

} // class
