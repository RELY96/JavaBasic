package j10_APITest;

import java.util.StringTokenizer;
//** StringTokenizer : 문자열을 토큰으로 구분(사용하려면 인스턴스 필요) // split - 인자를 기준으로 "잘라" 담아주는 것
// token의 "순차적 처리"를 지원 -> while문 쓰기 좋음
// hasMoreTokens() / nextToken()

// split(매서드) =/= Tokenizer(클래스) 안 hasMoreTokens() / nextToken() 매서드


public class Ex04_Tokenizer {

	public static void main(String[] args) {

		StringTokenizer st = new StringTokenizer("AM:11:40:12", ":"); // StringTockenizer인스턴스 생성 + ★token화 하려는 대상을 매개
																		// 변수로 넣어줄 수 있음
		// 형식 > StringTokenizer("ㅁ","구분자"); - 구분자 별로 하나씩 쪼개서 토큰화 해줌

		while (st.hasMoreTokens()) { /* st가 token을 많이 갖고 있으면(token을 더 갖고 있으면(boolean값)) while이용해서 하나씩 출력 */
			System.out.println(st.nextToken()); /* token이 있으면 확인하면서 nextToken을 return함 */
		} // while

//--------------------------------------------------------------------------------------------//

		// 1) 둘 이상의 구분자도 사용 가능 2) 공백도 구분자에 포함 가능
		st = new StringTokenizer("1 2+3 4-5*6/7", "+-*/ "); // '+-*/ ' 모두 구분자로 처리(둘 이상)
		
		while (st.hasMoreTokens()) { 
			System.out.println(st.nextToken()); 
		} // while
		
//--------------------------------------------------------------------------------------------//
		// Token 순차처리 원리 : 
		// 순차처리된 token들에 현재 Token 앞 cursor기준으로 hasmoreToken 처리 -> cursor뒤 Token(현재 토큰)있는지 확인
		// => next Token 출력(cursor next 현재 Token), 또 커서를 기준으로 hasmoreToken 불리안 값 확인 -> next로 넘어가는 과정 순차적으로 반복!
	} // main
} // class
