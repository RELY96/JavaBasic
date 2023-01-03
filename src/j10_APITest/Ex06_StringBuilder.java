package j10_APITest;

//** StringBuilder : StringBuffer 와 동일하나 동기화 키워드를 지원하지 않으므로 "thread-safe"X, But 단일쓰레드에서의 성능은 StringBuffer 보다 뛰어남


public class Ex06_StringBuilder {

	public static void main(String[] args) {
		
		StringBuilder sb =new StringBuilder("가나다");
		sb.append(123).append("ABCD").append(false);
		
//--------------------------------------------------------//
		
		System.out.println("* Before sb: "+sb);
		System.out.println("* Before sb.toString: "+sb.toString());
		
		//1. Insert//
		sb.insert(1, true); //1자리에 true 넣기
		sb.insert(sb.length(), "END"); //sb마지막 뒤부터 "END"출력
		System.out.println("After sb: "+sb);
		
		//** 나머지 매서드 String Buffer 와 동일 **//
	} //main
} //class
