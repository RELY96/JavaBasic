package j08_AbsInterface;

// 인터페이스

//** interface 1 : 상수, 추상메서드
// - static, default 메서드 (구현부가 있는 메서드, Java8 부터 추가됨)
// 인터페이스는 생성자 자체가 허용되지 X (추상 매서드만 가능하니까!)
// 인터페이스는 다중 구현 가능 =/= 클래스 상속(다중상속불가)
// 인터페이스 "끼리는" 상속 가능

public interface Ex02_MyInterface { //컴파일 다른 java클래스랑 같이 .class로 됨, 확장자명도 java

	// 인터페이스 구성요소 : 1. 상수 1)그냥 맴버변수를 정의하면 public static final 이 자동으로 생략된 취급을 받음
	public static final int NUM = 123; // 상수 정의, 상수명은 다 대문자
	String NAME = "Green"; // public static final 자동 생략 취급 -> 기울기

	// 인터페이스 구성요소 : 2. 추상매서드 -> 오버라이딩 필수니까 private은 절대 불가함(public만 가능함)
	public abstract int getNum(); // 만약 다 생략 -> 자동적으로 public
	abstract void setNum(); // public만 생략되도 접근범위 -> 자동적으로 public
	String getName(); // 위와 마찬가지로 public abstract 자동 생략취급
}
