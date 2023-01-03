package c09_test;

// !!! 불필요한 글자 제거 알고리즘에 참고 !!!

//** 정석기초 연습9-5
//=> 다음과 같이 정의된 메서드를 작성하고 테스트하시오.

  /* 메서드명: delChar
     기   능: 주어진 문자열에서 금지된 문자들을 제거하여 반환한다.
     반환타입: String
     매개변수: String src - 변환할 문자열 
             String delCh - 제거할 문자들로 구성된 문자열
     => [힌트] StringBuffer, String, charAt(int i), indexOf(int ch) 를 사용하라 */

//-------------------------------------------------------------------------//

// StringBuffer 안에서 append 해서 뒤로 계속 추가해주면 됨
// src안 delch에 있는 문자가 있으면 제거해줌(하나씩 하나씩 비교 /delch에서 하나씩 뽑는 거 : src에서 하나씩 뽑아, delch에 없으면 indexof가 -1이 아닌 양수
// -> StringBuffer에 append로 하나씩 담는거/)

// 한글자씩 꺼내는 거-charAt -> src에서 글자를 하나씩 꺼내는 용도
// index 0부터 차례대로 꺼낸 문자가 양수(indexof)이면 append로 넣어줌(반복문 사용)

//-------------------------------------------------------------------------//

public class Chap09_9_5 {
	public static String delChar (String src/*변환할 문자*/, String delCh/*금지문자*/) {

		StringBuffer sb = new StringBuffer(src.length()); //★StringBuffer size를 src의 length();만큼 미리 준비(append로 추출값 담을 공간)
		
		for (int i=0; i<src.length(); i++) { //반복문으로 하나씩 꺼내서 넣어주기
			// 1) src의 char를 하나씩, 차례대로 꺼내어 금지어인지 확인
			char c = src.charAt(i); //i가 하나씩 증가하며 src에서 한 글자씩 꺼내짐 -> if로 가능, 불가능 비교 위해 char 타입 c라는 새로운 변수 만듦
			if (delCh.indexOf(c)/*delCh안에 뽑은 c가 몇번째 있는지*/ < 0 /*없다->괜찮음*/) sb.append(c); /*StringBuffer 안에 괜찮은 거 넣어줌*/
		} //for
		return sb.toString(); //sb가 buffer니까 string 타입으로 반환하기 위해서 toString을 return 값으로
	} // delChar 매서드

//========================================================================//	
	
	public static void main(String[] args) {

		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()")); //12345 - 특수문자 제거
		System.out.println("(1 2 3 4\t5)"+ " -> "+delChar("(1 2 3 4\t5)", " \t")); //(12345) - 공백,\t 제거

	} // main

} // class
