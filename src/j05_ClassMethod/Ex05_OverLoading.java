package j05_ClassMethod;

// 매서드 오버로딩 : 매서드가 넘침(1개의 클래스 안에서 같은 이름의 매서드지만 매개변수가 달라서 다 다른 매서드임)

//** Method OverLoading (메서드 오버로딩)
// 1) 하나의 클래스내에서 메서드 이름의 중복 허용
// 2) 단, 매개변수의 갯수 또는 타입이 반드시 달라야 함
// * 장점: 동일한 기능에 대한 메서드명을 통일 시킬 수 있음* (ex: .찍으면 매서드는 같은데 매개변수 다 다른 모습
//        => 굳이 int sort, char sort 이렇게 여러 개 만들 필요 없이!)

//** 과제
//=> 두수를 입력받아 add 연산 결과를 return 하는 메서드를 만든다. 단, 모든 기본자료형의 인자를 사용할 수 있도록 한다.
//   어떤 형태로 숫자를 입력하든지 연산 결과가 나와야함!
// add1(int, int)  add2(int, double)  add3(double, int)  add4(double,double) -> overload 사용

public class Ex05_OverLoading { // overloading 클래스 만들기

	public static int add(int i, int j) { // 연산결과를 return 하는 거니 연산결과에 따라서 리턴형태는 다르게 해야
		return i + j;
	}
	// => 매개변수명이 다른것은 오버로딩에 해당되지 않음
	// public static int add(int a, int b) {
	// return a+b; } => 반드시 매개변수의 타입 또는 갯수가 달라야 함
	public static double add(int i, double j) {
		return i + j;
	}

	public static double add(double i, int j) {
		return i + j;
	}

	public static double add(double i, double j) {
		return i + j;
	}

	// overloading 장점 활용(static이라 인스턴스 생성 필요X)
	public static void main(String[] args) {
		System.out.println("** int int 연산 : " + add(1, 5));
		System.out.println("** int double 연산 : " + add(1, 4.5));
		System.out.println("** double int 연산 : " + add(4.5, 1));
		System.out.println("** double double 연산 : " + add(4.5, 4.5));
		
		System.out.println("** float stest : " + add(4.5f, 4.5f));
		//float -> double로 되는 건 "자동형변환"이 일어나기 때문에 오류없이 작동(double의 크기가 더 커서)
	}
}
