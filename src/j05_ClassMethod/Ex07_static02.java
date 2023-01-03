package j05_ClassMethod;

//** 4칙연산 계산기
public class Ex07_static02 {

	int result;
	static int total = 0; // static맴버변수 : 모든 인스턴스가 공유하는 값(수정도 모두 적용)(ex:학원명, 회사명 같은거)

	// **static 매서드
	public static int add(int i, int j) {
//		result= i+j; //static매서드 안에 인스턴스변수는 인스턴스 없이는 접근 불가라 오류
		total += (i + j);
		return i + j;
	}

	public static int min(int i, int j) {
		total += (i - j); // total 누적
		return i - j;
	}

	// ---------------------------------------------------------------//

	// **인스턴스 매서드
	public int mul(int i, int j) {
		result = i * j; // 인스턴스 매서드 안에 인스턴스 변수 사용 가능
		total += result; // static변수도 사용 가능
		return i * j;
	}

	public int div(int i, int j) {
		result = i / j;
		total += result;
		return i / j;
	}

	// ---------------------------------------------------------------//

	public void instanceAll(int i, int j) {
		// 이때 (int i, int j) 는 지역변수임
		System.out.println("** instance all add : " + add(i, j));
		System.out.println("** instance all min : " + min(i, j));
		System.out.println("** instance all mul : " + mul(i, j)); // static과 다르게 인스턴스에도 접근 가능해서, ex07매개변수와 인스턴스 생성 필요X
		System.out.println("** instance all div : " + div(i, j));
	}
	// ---------------------------------------------------------------//

	public static void staticAll(int i, int j, Ex07_static02 ex07) {
		System.out.println("** static all add : " + add(i, j));
		System.out.println("** static all min : " + min(i, j));
		System.out.println("** static all mul : " + ex07.mul(i, j));
		System.out.println("** static all div : " + ex07.div(i, j));
	}

	// =============================================================//

	public static void main(String[] args) {
		// 1) static 매서드
		System.out.println("** add : " + add(10, 20));
		System.out.println("** min : " + min(10, 20));

		// 2) 인스턴스 매서드(== non_static)
		Ex07_static02 ex07 = new Ex07_static02();
		System.out.println("** mul : " + ex07.mul(10, 20));
		System.out.println("** div : " + ex07.div(10, 20));

		// ---------------------------------------------------------------//

		System.out.printf("** result = %d, total = %d \n", ex07.result, total); // 0,220
		// result는 인스턴스니까 인스턴스 생성 후 출력, total은 스태틱이니까 그냥 출력
		// result는 최종 div값만 가지고 있지만, total은 static이라 값이 계속 누적된 값을 갖게 됨

		// ---------------------------------------------------------------//

		// 3) ALL test
		Ex07_static02 all = new Ex07_static02(); // all테스트 위해 새로운 인스턴스 생성(ex07과는 다른 주소)
		staticAll(100, 30, all);
		all.instanceAll(100, 30);
		System.out.printf("** result = %d, total = %d \n", all.result, total); // 3, 6626
		// 최종적으로 들어가는 result값만 반환, total은 위의 다른 주소 인스턴스의 total에다가 staticAll, instanceAll
		// 다 더하게 됨
		// => total은 클래스 종속 변수니까(클래스 단위의 static공간에 하나의 값만 가질 수 있음)

		// => 위 78행을 다시 출력해보면?
		System.out.printf("** result = %d, total = %d \n", ex07.result, total);
		// 0, 6626(total은 클래스변수라 다같이 공유하니까 다른 인스턴스라도 최종 total계산값 나옴)

	} // main

} // class
