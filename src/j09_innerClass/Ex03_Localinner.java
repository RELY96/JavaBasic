package j09_innerClass;

//Local inner class : 이너클래스의 매서드 내부의 클래스

//=> 메서드의 내부에 정의 되는 InnerClass.
//=> 메서드 내에 정의되는 지역변수와 같다 (*메서드내에서만* 사용됨)
//=> static InnerClass는 허용 되지 않음. 단, 상수는 허용

public class Ex03_Localinner {

	int a = 100;
	
	Ex03_Localinner() {System.out.println("* Ex03 기본생성자 *");}
	
	public void innerTest(int n) {
		int b=200; //지역(Local 변수)
		final int C=n; //final 지역변수
		
		// ** Local Inner 클래스 정의(매서드 안)
		class Inner { // 로컬이너클래스는 매서드 내부에서 사용이 되어져야 함! + 생성 또한 매서드 안에서되고 바로 쓰여야 함
			int d=400;
			
			Inner () {System.out.println("* Inner 기본생성자 *");} //클래스니까 당연히 생성자 가질 수 O
			
			public void printData() {
				System.out.printf("*Inner printData: a=%d, b=%d, c=%d, d=%d \n*",a,b,C,d);
			} // Inner class 안 printdata 매서드	
			public int adder() {return d+=123;}
		} //Inner class
		
		// ** Local Inner 클래스 사용하기(매서드 안에서) 
		Inner in = new Inner(); // 생성 또한 매서드 안에서 되고 바로 쓰여야 함		
		in.printData();
		in.adder();
		System.out.println("* innerTest in.adder() : "+in.adder()); //결과값 보여주려고
			
	} //매개변수가 있는 InnerTest 매서드
	
	public static void main(String[] args) {
		// 1) 외부클래스 인스턴스 생성
		Ex03_Localinner ex03 = new Ex03_Localinner();
		// 2) 외부클래스의 매서드(로컬클래스를 품고 있음) 호출
		ex03.innerTest(300); // *매서드 호출 시 Local innerClass 생성됨!
	} // main
} // class
