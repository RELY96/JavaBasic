package c09_test;

// 1. String str 에 있는 글자들을 하나씩 추출해서(for) String delCh에 있는 글자들과 비교(해당 글자가 있는지) -> 없다면 indexOf가 -1이 나올거임
// 2. indexOf 가 -1 이면 추출해서 보여줘도 괜찮은 글자 -> append를 사용해 StringBuffer 타입에 넣어준다 <= 사전에 StringBuffer 생성이 필요함!
// 3. return 타입 String으로 보여주기 위해 SB타입을 String으로 변경해서 출력

// ** 원리 : 원래 문자에서 하나씩 빼서, 뺄 문자랑 비교 / 뺄 문자에 없다면 완성될 문자공간에 한개씩 추가

//===================================================================================//

public class Chap09_9_5_02 {
	public static String delChar (String str, String delCh) { //delChar 매서드
		 StringBuffer sb = new StringBuffer(str.length()); // str.length()만큼 저장공간을 갖는 SB 공간 생성
		 
		 for (int i=0; i<str.length(); i++) { //하나씩 추출할 반복문(문자 1개니까 char로 받기)
			 
			 char cc = str.charAt(i); //★비교할 값은 str의 i번째 문자 charAt
			 if(delCh.indexOf(cc)<0) sb.append(cc); 
		 } //for
		return sb.toString();
	} // delChar

	public static void main(String[] args) {
		System.out.println("*가!나&다~라^마" + "->" + delChar("*가!나&다~라^마", "*!()@$%^&~")); // 가나다라마
		System.out.println("*가\t나 다 라    마*" + "->" + delChar("*가\t나 다 라    마*", " \t")); // *가나다라마*
	} // main
} // class
