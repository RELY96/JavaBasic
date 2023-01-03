package j04_array;

import java.util.Arrays;
import java.util.Random;

//** 과제
//=> Lotto 배열 2개를 준비.
// 당첨번호, MyNumber 
//=> 두배열 모두 Random 으로 초기화
//=> 중복확인, 정렬(직접작성)
//=> 당첨확인 (일치여부만 확인)

//=> 무조건 당첨되게 만들기 (두번째 Random 뽑을 때 i기준을 <=j 로 하고, !=면 myLotto가 생성되지 않게 설정)

public class Ex04_Lotto03 {

	public static void main(String[] args) {
		// 1. Lotto 배열 2개 준비
		int lotto[] =new int[6];
		int myLotto[] =new int[6];

		// 2. 당첨번호 만들기, 중복확인, 오름차순 정렬(직접작성)
		Random rn = new Random();
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
		Random lo = new Random();
		for (int i=0; i<myLotto.length; i++) {
			myLotto[i]=lo.nextInt(45)+1; // myLotto배열 뽑기
			
			for(int j=0; j<i+1; j++) {     // 중복확인 //i의 시작과 j의 시작이 같아야 하기 때문에 <=로 조건 만들기
				if(myLotto[i]!=lotto[i]) {  // 2) myLotto[i] 와 lotto[i] 같지 않으면 비워놓고 break해서 같게 만들기
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
