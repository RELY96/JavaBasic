package j12_Exception;

//** UnChecked Exception throws Test  
//=> RunTimeException 하위 계층들 : UnChecked Exception 
//=> java 의 컴파일러가 Exception 처리 확인하지 않음
// 즉, 반드시 try ~ catch 구문 을 적용하지 않아도 됨.
// 그러나 필요시엔 throws 로 처리 가능  
//=> 주로 프로그래머의 실수로 발생 가능한 오류들

// RunTimeException을 call한 메서드에서도 Exception 처리가 의무조항은 아님. 다만, 필요하다면 throws 할 수 O
// 즉, 반드시 try ~ catch 구문 구현 하지 않아도 컴파일 오류 없음

public class Ex06_unThrows { //의무조항은 아니라 오류는 안나지만, throws도 할 수 O
	public static void intByZero() throws ArithmeticException  {
	      int i=10/0;
	   }
	   public static void arrayIndex() throws ArrayIndexOutOfBoundsException  {
	      int[] a = new int[3];
	      a[3] = 100;
	   }
	   
//---------------------------------------------------------------------------------//
	   
	   // ** 의무조항은 아니지만 "계속 상위의 메서드로 throws" 할 수 있음
	   // public static void callTest() {   // => 오류 없음
	   public static void callTest() throws ArrayIndexOutOfBoundsException {
		  intByZero(); //이미 떠넘긴 걸 받는 쪽에서 꼭 처리해줄 필요X -> 더 상위의 매서드로 throws 할 수 O
	      arrayIndex();
	   }
	   
//---------------------------------------------------------------------------------//	   
	   
	   public static void nullPointer() throws NullPointerException {
	      String s = null;
	      int l = s.length(); // NullPointerException 처리 안해주고 throws한거
	   }
	   
//---------------------------------------------------------------------------------//		   
	   
	   public static void classCast() throws ClassCastException {
	      Object o = new int[5]; //int타입의 데이터를 담을수있는 배열[5] / Object가 조상
	      String s = (String)o; // Object 조상을 후손 String으로 down-casting -> 런타임 에러(주소값 맞춰주지 않았으니까) => throws 해버림!
	   }
	   
//=======================checked 익셉션=============================================//	     
	   
	   // ** ClassNotFoundException -> Checked Exception (클래스를 찾기 힘들 떄 나는 익셉션)
	   public static void classNotFound() throws ClassNotFoundException {
		   
	   // ** 이름이 Class 라는 클래스 : JVM에서 동작할 클래스들의 정보를 묘사하는 일종의 메타 클래스(Meta-Class)(클래스 관리하는 클래스)
	   //    클래스의 이름, 멤버 필드와 메소드, 클래스 종류 등의 정보
	   // => forName() 메소드에 의해 반환된 Class 클래스의 인스턴스에는 "클래스명"의 정보가 담겨 있음.
	      Class<?> c = Class.forName("j12_Exception.Ex05_IOthrows");
	      System.out.println(" Class 찾기: "+c.getName()); //찾아낸 클래스의 이름 print -> 클래스가 없으면 ClassNotFoundException
	   }

	public static void main(String[] args) {
		//---------------------------------------------------------------------------------//
		// 1) unChecked Method Call
		callTest(); // 떠넘기기만 해놓고, Exception 처리 안해줬으니까 처음부터 실행X
		nullPointer();
		classCast();
		
		// exception 떠넘기기 의무X, 컴파일오류X-> BUT, exception 처리 안해줬으니까 callTest();부터 비정상 종료됨 => try-catch 블록으로 처리해주면 해결!
		// System.out.println("* 정상종료 *");
		
		//---------------------------------------------------------------------------------//
		
		// 2) Checked Method Call
		// classNotFound(); //처리 안해주면 컴파일 오류 
		
		try { //처리해주기
			classNotFound(); //처음에 exception이 나오면 바로 catch로 가서 exception처리됨, 처음이 try면 try출력 후 다음것도 출력할 수 있음!
			callTest();
		} catch (ClassNotFoundException e) {
			System.out.println("* main ClassNotFoundException: "+e.toString());
		} catch (Exception e) {
			System.out.println("* main callTest exception: "+e.toString());
		} 
		System.out.println("* 정상종료 *");
	} //main
} //class
