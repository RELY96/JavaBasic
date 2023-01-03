package j12_Exception;

public class Ex01_Basic {

	public static void main(String[] args) {
		int x=6, y=3, result=0;
		String s="123000";
		String []names = {"Apple", "Banana", "Green"};
		
		// ** 비교
		// 1. Exception 처리 안한 경우
		// => Exception이 발생된 위치에서 비정상종료(더이상 실행되지X)
		
		// 1-1) 정상진행
		result = x/y;
		System.out.println("**Exception발생 없는 정상적 진행 result: "+result);
		System.out.println("정상 종료입니다");
		
		// 1-2) Exception 처리 안한 오류 -> 비정상 종료
		// result = x/0;
		// System.out.println("**Exception 처리X result: "+result); //비정상 종료되서 나오지X (java.lang.ArithmeticException: / by zero)

//=======================================================================================//
		
		// 2. Exception 처리 한 경우(try,catch / finally)
		// => Exception이 발생되어도 Exception부드럽게 처리 후 정상진행 가능
		
		try {
			result = x/0; //똑같은 오류지만 예외처리기에 의해 catch블럭 처리하고 끝남
			System.out.println("* result: "+result);
		} catch (Exception e/*발생된 exception 전달받음*/) {
			System.out.println("**Exception 처리O result: "+e.toString()); // Exception e(전달된 exception값) 에러메세지 띄우기 위한 매서드
		}
		finally {
			System.out.println("fanally(무조건 실행 블록)");
		}
		System.out.println("정상 종료입니다");

//=======================================================================================//
		// **catch 블럭을 여러개 넣을 수 있음 -> 발생되는 exception별로 따로따로 출력(exception을 종류별로)
		
		try {
			result = x/0;
			System.out.println("* result: "+result);
		} catch (ArithmeticException e) {
			System.out.println("* ArithmeticException : "+e.toString()); // ArithmeticException에 해당되는 exception이 일어나면 이 catch로 감, 아닐 경우 다른 catch로 감
		} catch (Exception e) {
			System.out.println("**Exception : "+e.toString());
		} finally {
			System.out.println("fanally(무조건 실행 블록)");
		}
		System.out.println("정상 종료입니다");
		
//=======================================================================================//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} //main

} //class
