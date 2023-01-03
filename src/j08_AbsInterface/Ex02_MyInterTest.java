package j08_AbsInterface;

// Ex02 인터페이스 구현하는 클래스
class MyChild1 implements Ex02_MyInterface { // 인터페이스 추상매서드를 다~ 구현해야 하기 때문에, 상속이 아니라 임플먼트 로 관계함

// 오버라이딩 범위 : 조상의 접근범위보다 같거나 넓어야함(조상이 public인데 후손 오버라이딩이 default인 경우는 안됨 -> 가져다쓸수 없으니까+조상이 후손에 포함되는데 범위가 더 넓을수X)
	MyChild1() { //오버라이딩 범위 확인
		System.out.println("*MyChild1 default 생성자*");
	}

	@Override
	public String getName() {
		return NAME; // return타입이 있어서 자동적으로 return까지 나옴, interface의 상수 NAME return
	}

	@Override
	public int getNum() {
		return NUM;
	}

	@Override
	public void setNum() {
	} // NUM은 상수라 set 못함, 아무것도 안넣고 구현하기

	void child1() {
		System.out.println("* Child1 method Test *");
	}
} // MyChild1

//--------------------------------------------------------------------------------------------//

class MyChild2 implements Ex02_MyInterface { // 두번째 인터페이스 구현 클래스
	String name = "홍길동"; // 얘는 상수x, 모두 대문자가 아니니까 상수랑 아예 다른 변수
	int num;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getNum() {
		return NUM * num;
	}

	@Override
	public void setNum() {
		num = 100;
	}

	void child2() {
		System.out.println("* Child2 method Test *");
	}
} // MyChild2

public class Ex02_MyInterTest {

	public static void main(String[] args) {
		// ※ 인터페이스 직접 생성 Test
		// 1. 인터페이스는 추상클래스처럼 직접생성 불가
		// 2. But, 타입으로 정의 가능 > 타입 인터페이스 = new 구현클래스
		// 3. 사용범위는 인터페이스에 정의된 만큼만!
		Ex02_MyInterface inter1 = new MyChild1();
		System.out.printf("*main에서 inter1 출력| NAME=%s, NUM=%d \n", inter1.getName(), inter1.getNum());

		Ex02_MyInterface inter2 = new MyChild2();
		// 1) mychild2 확인 위해 set한번 해주고 호출 테스트
		inter2.setNum();
		System.out.printf("*main에서 inter2 출력| NAME=%s, NUM=%d \n", inter2.getName(), inter2.getNum());

		MyChild1 child1 = new MyChild1(); // 일반 클래스는 위와 다르게 MyChild1 클래스 맴버 모두에 접근 가능하고,다 쓸 수 있음
		child1.child1();

		// --------------------------------------------------------------//

		// ※ interface에 정의된 상수 의 (직접)사용 가능여부
		// -> child1,2 등 인스턴스 들을 통해서 접근가능 -> But, static(interface이름)으로 직접 접근하는게 더 바람직!
		System.out.printf("*main에서 interface의 상수 | NAME=%s, NUM=%d \n", child1.NAME/* 경고 */,
				Ex02_MyInterface.NUM/* 바람직 */);
		// Ex02_MyInterface.NUM - 정의된 상수를 사용할 때는 인터페이스 이름으로 직접 접근

		// ※ 서로 관련없는 <클래스-클래스> 인터페이스 이용해 엮어주기(Interface의 특징)
		// -> 같은 계층구조로 묶이니 다형성 적용가능하게 됨!!

		inter1 = inter2; // inter2를 inter1과 같은 주소로 만들어줌 (inter1의 주소가 inter2가 됨)
		System.out.printf("*main에서 intter1= inter2| NAME=%s, NUM=%d \n", inter1.getName()/* inter2와 같은 결과가 나옴 */,inter2.getNum());

		inter1 = child1; // 얘네들 관계는, 같은 인터페이스를 공유하고 있기 때문에(같은 계보 안) -> 다형성 적용가능 / interface타입 = child1클래스 생성(자동형변환, 다형성 적용가능)
		System.out.printf("*main에서 inter1 = child1| NAME=%s, NUM=%d \n", child1.getName(),inter1.getNum()/* child1과 같은 결과 하지만 범위가 interface로 제한되는 건 여전 */);
		

	} // main

} // class
