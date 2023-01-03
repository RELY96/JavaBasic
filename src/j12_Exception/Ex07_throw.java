package j12_Exception;

// (throw)예외 생성,따돌리기 / 떠넘기기(throws)

//** 예외생성
// 1. throw : 예외(Exception) 생성하기 (발생)
// 2. throws: 예외(Exception) 전달하기 (떠넘기기)

// - extends Exception => Checked Exception 
// - extends RuntimeException => UnChecked 예외 (예외처리를 강제하지 않음)

// Exception 생성 시 checked 익셉션으로 생성 vs unchecked exception 으로 생성

//===================================================================//

public class Ex07_throw {

	public static void main(String[] args) {
		//※1) Exception 생성하기 형식 > throw new Exception(); [새로운 익셉션 생성하겠다- Exception 안에는 체크, 언체크 둘다 있어서 Exception:체크 속성임]
		try {
			throw new Exception("* throw Test Message *"); // try에서 익셉션 뉴 해서 이 시점에서 익셉션이 일어나게 만듦(catch로)
			// 생성자에 메시지 부여 가능!
			// throw new ClassNotFoundException("* throw ClassNotFoundException *");
		} catch (Exception e) {
			System.out.println("Exception: "+e.toString());
		}
		// Exception은 체크 익셉션이니까, try-catch문 "없이" <throw new Exception();>만 하면 컴파일 오류!		
		
//---------------------------------------------------------------------------------------------------//	
		
		//※2) unchecked Exception 생성 형식 > throw new RuntimeException();
		//throw new RuntimeException(); // RuntimeException은 언체크 익셉션 -> 컴파일에러X, But, try-catch로 안 받아줘서 무조건 생성된 익셉션 런타임 오류!
		
//---------------------------------------------------------------------------------------------------//	
		
		//※3) MyException : 특정상황을 Exception 으로 정의(내가 만든 익셉션)
		// - 1. 인스턴스로 익셉션 생성&정의 / 2. 일회적으로 사용한다면 인스턴스 정의 없이 가능
		try {
			Exception myE = new Exception("* 의도적 마이 익셉션 *"); //1. 인스턴스를 익셉션으로 정의 방법
			throw myE; //1-2. 익셉션 인스턴스 생성 -> 익셉션 발생!
			// 1-3. 한줄로 익셉션 발생 throw new Exception("* 의도적 익셉션 생성 *")
		} catch (Exception e) {
			System.out.println("Exception: "+e.toString());
		}
		System.out.println("* 프로그램 종료 *");
	} // main
} // class
