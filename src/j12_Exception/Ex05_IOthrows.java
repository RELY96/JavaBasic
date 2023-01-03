package j12_Exception;

import java.io.IOException; // IOException 임포트

// IOException - checked 익셉션, 반드시 처리해야 하는데 처리하기 어려우면 떠넘기기 쓸 수 O
// Exception 따돌리기, 떠넘기기, 위임처리(throws)

// ** Checked Exception 처리
//1) 직접 처리 : 해당 메서드 내에서 try ~ catch 블럭 처리
//2) 위임 처리 : Exception 처리를 상위 메서드로 위임(떠넘기기)

//============================================================================//

public class Ex05_IOthrows {
	//1) 직접 처리
	public static String readString1 () {
		byte[] bf = new byte[100]; //100Byte 담을 수 있는 배열 정의
		
		System.out.println("* 문자열을 입력하세요 *");
		/* System.in.read(bf); <- System.in은 IO / IOException(checked) 인데 try-catch 블럭에 넣어주지 않아서 오류*/
		
		try {
			System.in.read(bf); //try안에 IOException 넣어주기, try문제없이 실행 시(System.in으로 문자열 입력) byte타입의 buffer 읽는 매서드 read 실행됨
		} catch (IOException e) {
			System.out.println("* IOException: "+e.toString());
		}
		return new String(bf); //StringBuffer를 String으로 형변환해서 출력 리턴
	} // readString1

//============================================================================//	
	
	//2) 위임 처리(떠넘기기)
	public static String readString2 () throws IOException { // throws IOException 익셉션 떠넘기겠다 / Exception 하면 main에서도 Exception으로 받아줘야함
		byte[] bf = new byte[100]; //100Byte 담을 수 있는 배열 정의
		
		System.out.println("* 문자열을 입력하세요 *");
		System.in.read(bf); // IOException(checked) 인데 try-catch 블럭에 넣어주지 않아서 오류 -> checked Exception -> 떠넘기면 그대로 작성가능
		// 1. 떠넘겨받은 main매서드에서 반드시 IOException처리 해줘야 함
		//★★ 2. IOException을 떠넘기면 -> main(사용자클래스)에서는 IOException 또는 Exception 으로 처리

		return new String(bf); //StringBuffer를 String으로 형변환해서 출력 리턴
	} // readString2
	
//============================================================================//
	
	public static void main(String[] args) throws Exception { // 3) main도 throws 가능
		// 1) 직접 처리 출력해보기
		System.out.println("* readString1 실행: "+readString1());
		
//----------------------------------------------------------------------------//
		
		// 2) 위임 처리(main에서 넘겨받아 IOException 처리하기)
		/* try {
			System.out.println("* readString2 실행: "+readString2());
		} catch (IOException e) { // 넘겨받는 쪽은 넘기는 쪽보다 최소 같거나 조상이어야 함! (Exception Vs IOException)
			System.out.println("* main에서 Exception이 일어났습니다 *"+e.toString());
		} */
		
//============================================================================//
		
		// 3) main도 throws 가능(JVM으로 떠넘겨서 try-catch 아예 안 만들어줘도 됨 /사용자가 프로그램으로 떠넘기는 것/ )
		// 간단한 테스트용!
		System.out.println("* readString2 실행: "+readString2()); //main throws 하면 컴파일 error 사라짐
	} //main
} //class
