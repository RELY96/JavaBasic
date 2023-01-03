package j12_Exception;

public class Ex01_Basic02 {

	public static void main(String[] args) {
		int x=6, y=3, result=0;
		String s="123000";
		String []names = {"Apple", "Banana", "Green"};

//=======================================================================================//			
 		
		// ** 여러 예외 처리 exception 종류 비교(다중 catch)
		// 1. NumberFormatException
		
		try {
			result = x/y;
			System.out.println("* result: "+result);
			System.out.println("* result 연산: "+(result+=Integer.parseInt(s))); //s가 p가 있기때문에 Int로 형변환 불가 -> number exception
		} catch (ArithmeticException e) {
			System.out.println("* ArithmeticException : "+e.toString());
		} catch (NumberFormatException e) { // NumberFormatException
			System.out.println("* NumberFormatException : "+e.toString());
		} catch (Exception e) {
			System.out.println("* Exception : "+e.toString());
		}  finally {
			System.out.println("fanally(무조건 실행 블록)");
		} System.out.println("정상 종료========================================");
		
//=======================================================================================//	
		
		// 2. ArrayIndexOutOfBoundsException
		
		try {
			result = x/y;
			System.out.println("* result : "+result);
			System.out.println("* result 형변환 연산 : "+(result+=Integer.parseInt(s))); //s가 p가 있기때문에 Int로 형변환 불가 -> number exception
			System.out.println("* result 배열 : "+names[3]); //names 는 0,1,2까지 있는데, [3]은 length를 넘어가서 Exception
		} catch (ArrayIndexOutOfBoundsException e) { //배열 범위 초과 Exception
			System.out.println("* ArrayIndexOutOfBoundsException : "+e.toString());
		} catch (ArithmeticException e) {
			System.out.println("* ArithmeticException : "+e.toString());
		} catch (NumberFormatException e) {
			System.out.println("* NumberFormatException : "+e.toString());
		} catch (Exception e) {
			System.out.println("* Exception : "+e.toString());
		}  finally {
			System.out.println("fanally(무조건 실행 블록)");
		} System.out.println("정상 종료========================================");
		
//=======================================================================================//	
		
		// 3. Exception 지정 안했을 시 
		
		try {
			result = x/y;
			System.out.println("* result : "+result);
			System.out.println("* result 형변환 연산 : "+(result+=Integer.parseInt(s)));
			System.out.println("* result 배열 : "+names[2]);
			
			// 배열크기 음수지정 해서 ArrayIndexOutOfBoundsException 도 아닐 때 -> 해당 사항 없으니 Exception 으로 감 -> 맞는 오류명 출력
			names = new String[-1];
			
		} catch (ArrayIndexOutOfBoundsException e) { //배열 범위 초과 Exception
			System.out.println("* ArrayIndexOutOfBoundsException : "+e.toString());
		} catch (ArithmeticException e) {
			System.out.println("* ArithmeticException : "+e.toString());
		} catch (NumberFormatException e) {
			System.out.println("* NumberFormatException : "+e.toString());
		} catch (Exception e) { // ★★해당 사항 없을 때 여기로 감!
			System.out.println("* Exception : "+e.toString());
		}  finally {
			System.out.println("fanally(무조건 실행 블록)");
		} System.out.println("정상 종료========================================");
		
//=======================================================================================//	
		
		// 4. null값일 때 NullPointerException		
		try {
			result = x/y;
			System.out.println("* result : "+result);
			System.out.println("* result 형변환 연산 : "+(result+=Integer.parseInt(s)));
			System.out.println("* result 배열 : "+names[2]);

			s=null; //String s에 null 줌(값 지정X)
			System.out.println(""+s.length()); // s는 값이 없어서 length가 나올 수x	
			
		} catch (NullPointerException e) {
			System.out.println("* NullPointerException : "+e.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("* ArrayIndexOutOfBoundsException : "+e.toString());
		} catch (ArithmeticException e) {
			System.out.println("* ArithmeticException : "+e.toString());
		} catch (NumberFormatException e) {
			System.out.println("* NumberFormatException : "+e.toString());
		} catch (Exception e) {                                           // ★★해당 사항 없을 때 여기로 감! => 늘 다른 세부 Exception보다 뒤에 와야함
			System.out.println("* Exception : "+e.toString());
		}  finally {
			System.out.println("fanally(무조건 실행 블록)");
		} System.out.println("정상 종료========================================");
		
//=======================================================================================//

//Error : 시스템에서 일어나는 심각한 에러 <-개발자가 대응불가!
		
// Exception : 개발자가 미리 대응할 수 있는 error
// 1. Runtime Exception : 의무가 아님(=unchecked Exception,컴파일러가 체크하지 않는 Exception) / 하위에 앞에서 했던 Exception들이 속해있음
		
// 2. IOException : 외부 데이터를 주고받을 때 일어나는 Exception (In & Out) / 의무(=checked Exception) / try,catch를 반드시 해줘야 함
// DB때는 무조건 try,catch 해야함! (JDBC<자바 데이터베이스를 연결해주는 응용프로그램 인터페이스>)관련 작업 시 무조건 의무 - java application이 다른 것과 data를 in&out 계속 해줘야 하기 때문
		
//=======================================================================================//	
	} //main

} //class
