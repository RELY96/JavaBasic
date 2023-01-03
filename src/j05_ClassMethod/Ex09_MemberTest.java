package j05_ClassMethod;

// ** public(접근 제어자) : 접근 범위를 제한
// 1) public > 범위 제일 넓음(프로젝트 전체)
// 2) protected > 상속과 관련되서 나중에 배움(상속+default)
// 3) default > 아무것도 입력X(패키지 범위)
// 4) private > 제일 좁은 범위(현재 해당 클래스 내)

// id,name,age 등은 중요한 정보기 때문에, 해당 class밖에서 열람하는 걸 제한할 예정 -> private

//---------------------------------------------------------//

class Member { // default 범위(같은 패키지 안), 메인보다 범위가 좁아야 해서 메인은 public이고, main안 클래스는 default임
	// 클래스 파일명과 이름 같지 않아도됨 =/= main

	// ** 접근제어로 Data 보호
	// : private : 해당 클래스만 접근 가능
	// : 메서드를 통해 접근하도록 함
	// : 클래스 외부에서는 매서드를 통해 접근해야 함
	// ★ > 설정자(mutator-private 변수에 값을 넣어주는 역할)매서드 / 접근자(accessor-값을 보여주는 역할)매서드
	private String id; // 1) private : class 해당 외부에서는 아예 접근 못함
	private String name; // 2) 외부에서 접근이 불가능하니, ★메서드를 통해서 접근해야함!
	private int age;

//========================================================//

	// ** 설정자(mutator) 와 접근자(accessor)
	// > 설정자: 맴버변수, write/ main에서 부르기 > setXXX() / 매서드 형식 > setid() {}
	// > 접근자: 맴버변수, read/ getXXX() / getid() {}

	// ※메서드를 통해 접근하므로 변수값에 대한 Control 이 가능!
	// -> 필요에 따라서 setter , getter 를 적절하게 작성해서 외부에서의 접근 조정

//---------------------------------------------------------//
	// class만들 때 기본적으로 만드는 매서드들

	// 1. ** 생성자(우클, source, generate > 자동 생성)
	public Member() { // default 생성자
	}

	public Member(String id, String name, int age) { // 초기화용 생성자
		this.id = id;
		this.name = name;
		this.age = age;
	} //실행시, 인스턴스 생성 시 초기화된(매개변수 내용)들이 setter를 통해 다시 초기화하는 과정 거친 것

	// 2. setter / getter //private변수를 만들면, 이거에 접근하는 setter getter를 퍼블릭 매서드로 만듦ㅇ
	// 2-1) > 형식 : set+변수명의 첫글자대문자로(낙타표기)
	public void setId(String id) { // set하려면 매개변수에 id 받아야 함 + this.id=id 넣어줘야
		if (id.contains("불량"))
			return; // id가 불량데이터를 포함하고 있다면 바로 끝냄 -> 예방가능
		this.id = id;
	}

	// 2-2) > 형식 : get+변수명의 첫글자대문자로(낙타표기)
	public String getId() { // 외부에서 id를 볼 수 있도록 리턴해줘야 하니까 리턴 타입이 변수랑 똑같아야함
//		if (!(id.contains("A")))
//			return "보지마"; // 등급이 A가 아닌 사람이 열람 예방 가능
		return this.id; // 전역변수 id리턴 한다는 뜻
	}
	// -------------------------------------//

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	// 3. toString(우클, source, generate > 자동 생성)
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
} // Student

public class Ex09_MemberTest {// 클래스 파일명과 꼭 이름 같아야 함

	public static void main(String[] args) {
		// ** Member class 사용해보기

		// ** 생성자로 초기화 한거
		Member m1 = new Member("아이디", "홍길동", 20);
		System.out.println("** m1 : " + m1);

//=================================================//

		// ** setter, getter를 통한 접근과 초기화
		m1.setName("김길동"); // setter로 접근해 네임 수정 (홍길동 -> 김길동)
//		System.out.println("** m1.name : "+m1.name); //private이라 오류!
		System.out.println("** m1.name : " + m1.getName());
		System.out.println("** m1 name setter로 초기화" + m1);
		// 2번 초기화
		
		// -------------------------------------//

		// ** setter로 초기화
		// 1번 초기화(맨 처음 set으로 초기화한거(인스턴스 생성자 초기화는 이뤄지지X 상태))
		Member m2 = new Member();
		m2.setId("apple");
		m2.setName("스티브");
		m2.setAge(100);
		System.out.println("** m2 전부 setter로 초기화" + m2);

		// ** m1과 m2의 나이 합계 출력하기
		System.out.println("** m1,m2 age 합계 : " + (m1.getAge() + m2.getAge()));

	} // main

} // class
