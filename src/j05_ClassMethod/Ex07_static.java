package j05_ClassMethod;

//** static (클래스종속) == 클래스변수(모든 인스턴스가 공유) , 클래스메서드

//** non_static (인스턴스종속) == 인스턴스변수(인스턴스별로 관리) , 인스턴스메서드 <-인스턴스를 생성하지X 쓰지 못함

//** 사용(호출) 규칙
//=> 인스턴스 메서드 : static, 인스턴스 모두 인스턴스없이 호출가능 
//=> static 메서드 : static 만!! 인스턴스없이 호출가능, 인스턴스 변수는 인스턴스 생성해줘야 함

    //=============================================================//

//** 4칙연산 계산기
public class Ex07_static {

	// **static 매서드
	public static int add(int i, int j) { // 자주 사용될 때, 인스턴스없이 바로 사용 위해 static추가
		return i + j;
	}

	public static int min(int i, int j) {
		return i - j;
	}

	// **인스턴스 매서드
	public int mul(int i, int j) {
		return i * j;
	}

	public int div(int i, int j) {
		return i / j;
	}

	// ** static 매서드, 인스턴스 매서드 모두 call할 수 있는 매서드(인스턴스 매서드는 static, 인스턴스매서드에 모두 접근
	// 가능)
	// 안에서 한번에 다 연산하고 출력까지 하는 거 만들기(리턴필요X)
	public void instanceAll(int i, int j) {
		// 이때 (int i, int j) 는 지역변수임
		System.out.println("** instance all add : " + add(i, j));
		System.out.println("** instance all min : " + min(i, j));
		System.out.println("** instance all mul : " + mul(i, j)); // static과 다르게 인스턴스에도 접근 가능해서, ex07매개변수와 인스턴스 생성 필요X
		System.out.println("** instance all div : " + div(i, j));
	}
	// ---------------------------------------------------------------//

	// ** static 매서드, 인스턴스 매서드 모두 call할 수 있는 매서드(static 매서드는 static, 인스턴스 매서드에는 접근
	// 불가(스태틱이 메모리에 더 오래 남아있는 동안 인스턴스 매서드는 남아 있는지 불확실하기 때문에))
	// static 매서드로 작성하는 경우(매개변수(지역변수)에 인스턴스가 추가로 필요함)
	public static void staticAll(int i, int j, Ex07_static ex07) {
		System.out.println("** static all add : " + add(i, j));
		System.out.println("** static all min : " + min(i, j));
		System.out.println("** static all mul : " + ex07.mul(i, j));
		System.out.println("** static all div : " + ex07.div(i, j));
	}

	// =============================================================//

	public static void main(String[] args) {
		// 1) static 매서드 : static매서드 안에서 그냥 쓰면 됨
		System.out.println("** add : " + add(10, 20));
		System.out.println("** min : " + min(10, 20));

		// 2) 인스턴스 매서드(== non_static) : static안에서는 인스턴스가 필요
		Ex07_static ex07 = new Ex07_static(); // 인스턴스 생성(default 생성자)
		System.out.println("** mul : " + ex07.mul(10, 20));
		System.out.println("** div : " + ex07.div(10, 20));

		// ---------------------------------------------------------------//

		// 3) ALL test
		staticAll(100, 30, ex07); // staticAll 인스턴스 생성없이 실행
		// 클래스매서드(스태틱매서드) 라서 인스턴스 생성없이 실행 가능하지만, 매개변수에서는 인스턴스 생성해서 사용해야 하는 상황

		ex07.instanceAll(100, 30); // 인스턴스All 매서드는 인스턴스 생성 후 실행 해야함
		// 인스턴스매서드는 인스턴스가 있어야 접근가능(ex07앞에서 인스턴스 생성된 상태라 생성 생략한거)
		// 인스턴스 매서드 안에서는 스태틱, 인스턴스 생성없이 모두 호출가능해서 매개변수에 ex07이 없는 거

	} // main

} // class
