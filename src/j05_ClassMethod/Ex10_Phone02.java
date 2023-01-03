package j05_ClassMethod;

// **추가 실습
// second를 수정불가능(read only)하게 만들고 싶다
// 1) 생성자로만 초기화하고, 2) setter매서드가 아예 없으면 됨 -> setter미생성, getter만 생성

public class Ex10_Phone02 {
	// 1) 맴버변수 정의
	private static String first; 
	private int second;
	private int last;

	// 2) 생성자
	public Ex10_Phone02(int second, int last) {
		this.second = second;
		this.last = last;
	} // 초기화용 생성자
 
	public Ex10_Phone02() {
	} // 기본생성자

	// 3) setter getter
	public static void setFirst(String first) {
		Ex10_Phone02.first = first;
	}

	public static String getFirst() {
		return first;
	}

	//setSecond 매서드 지움//
	
	public int getSecond() {
		return second;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getLast() {
		return last;
	}

	// 4) 매서드정의
	public static void num() {
		System.out.println("" + first);
	} // static 매서드

	// 5) toString
	@Override
	public String toString() {
		return "" + first + "-" + second + "-" + last + "";
	}

	// 메인 실행
	public static void main(String[] args) {
		
		Ex10_Phone02.setFirst("010");

		Ex10_Phone02 p1 = new Ex10_Phone02(3456, 7891);
		System.out.println("p1 toString으로 출력: " + p1);
		System.out.printf("p1의 번호 getter: %s-%d-%d \n", Ex10_Phone02.getFirst(), p1.getSecond(), p1.getLast());

		// ------------------------------------------//

		Ex10_Phone02 p2 = new Ex10_Phone02();
	 // p2.setSecond(8278);
		p2.setLast(1236);
		System.out.println("p2 인스턴스 toString으로 출력: " + p2);
		System.out.println("p2 인스턴스 getter로 출력: " + p2.getSecond());
	}
	// ------------------------------------------//
}
//phone 클래스
