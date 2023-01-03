package j04_array;

import java.util.Arrays;
import java.util.Random;

//** 과제
//=> Lotto 배열 2개를 준비.
// 당첨번호, MyNumber 
//=> 두배열 모두 Random 으로 초기화
//=> 중복확인, 정렬(직접작성)
//=> 당첨확인 (일치여부만 확인)

//*** Random 클래스 : 생성자가 두개 있는 클래스 (), (long seed)
//=> java.util 에 있으므로 import 필요하고, new 선언후 사용가능함.
//=> Random() : 호출시마다 현재시간을 이용한 종자값이 자동 설정됨 
//=> Random(long seed) : 인자값으로 주어진 종자값이 설정됨(seed는 내가 설정) 
//                       종자값 : 난수 만드는 알고리즘에서 사용되는 값( 종자값이 같으면 같은 난수 얻음 )

//=> Random().nextInt(큰수 - 작은수 + 1) + 작은수 
// Random().nextInt() , Random().nextLong() , Random().nextBoolean()
// Random().nextDouble() ,  Random().nextFloat()

// random 클래스 말고, random매서드는 "무조건 실수" 타입이기 때문에 출력 시 int로 변환

public class Ex04_Lotto03_2 {

	public static void main(String[] args) {
		// 1. Lotto 배열 2개 준비
		int lotto[] =new int[6];
		int myLotto[] =new int[6];

		// 2. 당첨번호 만들기, 중복확인, 오름차순 정렬(직접작성)
		Random rn = new Random(5);
		for (int i=0; i<lotto.length; i++) {
			lotto[i]=rn.nextInt(45)+1; // lotto배열 뽑기
			
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					i--;
					break;
				}
			}
		}
		// 오름차순 정렬
		for (int i=0; i<lotto.length; i++) {
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		System.out.println("** Lotto : " + Arrays.toString(lotto));

		// 3. MyNumber 만들기, 중복확인, 매서드 이용 오름차순 정렬
		rn = new Random(5); //종자값 같게 // Random lo = new Random(5); 해도 난수 알고리즘 5는 똑같기 때문에 window시스템에 따라 똑같이 나옴
		for (int i=0; i<myLotto.length; i++) {
			myLotto[i]=rn.nextInt(45)+1; // myLotto배열 뽑기
			
			for(int j=0; j<i; j++) {     // 중복확인 //i의 시작과 j의 시작이 같아야 하기 때문에 <=로 조건 만들기
				if(myLotto[i]==myLotto[j]) {  // 2) myLotto[i] 와 lotto[i] 같지 않으면 비워놓고 break해서 같게 만들기
					i--;
					break;
				}
			}
		}
		//오름차순 정렬
		Arrays.sort(myLotto);
		System.out.println("** myLotto : " + Arrays.toString(myLotto));

		// 4. 당첨확인
		if (Arrays.equals(lotto, myLotto)) System.out.println("** 당첨 **");
		else System.out.println("** 꽝 **");
		
	} //main

} //class
