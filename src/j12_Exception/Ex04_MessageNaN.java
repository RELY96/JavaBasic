package j12_Exception;

public class Ex04_MessageNaN {

	public static void main(String[] args) {
		// ** by Zero (0으로 나누기)
		// => 정수형 연산 : ArithmeticException
		// => 실수형 연산 : Exception 일어나지X => Wrapper 클래스 매서드를 활용해야
		
		
		// ** 실수형 연산(오류X, exception 대신 다른걸로 처리)
		try {
			double d1 = 1.5/0.0; /*실수형 0으로 나누기 -> Infinity*/
			double d2 = 1.5%0.0; /*NaN*/			
			System.out.printf("**(정상진행됨) 실수형 연산 : d1=%f, d2=%f \n",d1,d2); //실수형 나눗셈에 대한건 exception 처리가 어려워서, 매서드로 처리해줘야 함!

		} catch (Exception e) {
			System.out.println("* Exception: " +e.toString());
		} finally {
			System.out.println("* finally(무조건 실행)");
		}
		
		System.out.println("*==============종료===============*");
		
//----------------------------------------------------------------------------------//
		
		try {
			double d1 = 1.5/0.0; /*Infinity*/
			double d2 = 1.5%0.0; /*NaN*/
			
			if(Double.isInfinite(d1) || Double.isNaN(d2)) System.out.println("Zero 연산은 허용하지 않습니다");
			//실수형 나눗셈에 대한건 exception 처리가 어려워서, 매서드로 처리해줘야 함! -> 이렇게 될 경우, 연산 허용X 추가
			else System.out.printf("**(정상진행됨) 실수형 연산 : d1=%f, d2=%f \n",d1,d2);
		} catch (Exception e) {
			System.out.println("* Exception: " +e.toString());
		} finally {
			System.out.println("* finally(무조건 실행)");
		}
		
		System.out.println("*==============종료===============*");

//==============================================================================//
		
		// e.printStackTrace : e.toString 을 포함한 순차적인 실행경로 등이 출력되어 예외발생의 원인과 경로 파악에 도움 
		
		// ** 정수형 연산(오류O -> exception) + toString 말고 다른 매서드들 테스트
		try {
			System.out.printf("** Message Test : 정수 0 나누기=%d, \n",(100/0)); //변수 선언없이 바로 정수 연산으로 exception 발생 시키기
		} catch (Exception e) {
			System.out.println("* Exception, toString : " +e.toString());
			System.out.println("* Exception, getMessage : " +e.getMessage());
			System.out.println("* Exception, printStackTrace : "); //printStackTrace()는 void라 매서드 안에 sysout이 이미 있어서 sysout으로 출력하는게 바람직X
			e.printStackTrace(); // main실행 흐름과 다른 별도의 thread
		} finally {
			System.out.println("* finally(무조건 실행)");
		}		
		System.out.println("*==============종료===============*");
	
//==============================================================================//			
		
	} //main
} //class
