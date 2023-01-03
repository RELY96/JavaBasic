package c09_test;

public class Chap09_9_3 {
	public static int count(String src/*기준*/, String target/*찾을 거*/) {
		int count =0;
		int pos=0; //찾기 시작할 위치
		
		while(true) {
			pos = src.indexOf(target, pos); // src에서 target를 pos의 위치부터 찾는다 + 다음 루프에 pos위치 재조정됨
			
			if (pos != -1) { //찾은 pos위치 인덱스값이 -1이 아니면(=index값이 있으면)
				count++; // 1) 찾은 횟수 +1
				pos+=target.length(); // 2) pos값 증가(/target.length()만큼 - pos를 찾은 단어 이후로 옮기는 것!)
			} // if_1
			else {
				break; //아니면 탈출 -> 음수면 target이 없다는 거니까 탈출
			}
		}   //while 탈출
 		return count; // int count return	
	} //count 매서드
	
	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB","AB"));
		System.out.println(count("12345","AB"));
	} //main
} //class
