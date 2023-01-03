package c06_test;

public class Chap06_6_18 {
	public static boolean isNumber(String str) {
		if (str == null || str.equals("")) 
			return false; //만약, str 값이 null 이거나 ""빈 문자열 이라면 false값 반환 *1차 거름망*
		
		for (int i = 0; i < str.length(); i++) { // str의 길이만큼 charAt 으로 '문자' '순서대로' 얻기
			char cc= str.charAt(i); // 순서대로 얻는 문자(i)가 다 int이면 true, 아니면 false (equals)

			if (cc < '0' || cc > '9') //char의 int 형태는 0~9까지 밖에 나올 수 없다, 그 범위를 벗어나면 그땐 String꼴임 -> false
				return false; // *2차 거름망*
				
		} // for_i
		return true; //거름망 다 거치면 숫자형태만 남은 건 다 true★★★
	} // isNumber Method

	public static void main(String[] args) {
		String str = "123";
		System.out.println(str + "는 숫자입니까?" + isNumber(str));

		str = "1234o";
		System.out.println(str + "는 숫자입니까?" + isNumber(str));

	} // main

} // class
