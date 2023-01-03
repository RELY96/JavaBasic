package j14_generic;

//** Enum 클래스 header 
// public abstract class Enum<E extends Enum<E>> implements Constable, Comparable<E>, Serializable {
// 계층도 : Object -> Enum<E extends Enum<E>> :추상클래스 -> Direction


//** Enum 클래스 (java.lang.Enum)
//=> 모든 열거형의 조상, 열거형을 지원하는 다양한 메서드 제공
// values(), valueOf(), name(), ordinal() 등

// ordinal() 은 열거형 상수가 정의된 순서를 정수로 반환 (0부터 시작) -> 이값은 내부적 용도이므로 열거형 상수의 값으로 사용하지 않는 것이 좋다

enum Direction {
	EAST, WEST, SOUTH, NORTH
	// 1) 상수명이 값 취급됨과 동시에 특정한 ordinal값도 갖고 있는 상수가 열거된 꼴 -> 사용시 상수의 값이 아닌 상수명 자체로 사용할 수 있음!
	// 2) 상수를 다루는데 좀 더 편리하고, enum에서는 상수 초기화 필수 아님 
} // enum

public class Ex06_enumMethod {

	public static void main(String[] args) {
		// ** 열거형 매서드 사용해보기
		Direction d1 = Direction.EAST; //타입 Direction 의 상수명'='값 d1 선언
		Direction d2 = Direction.valueOf("WEST"); // *상수를 valueof로 문자열 입력해서 가져오는 것도 가능
		
		Direction d3 = Enum.valueOf(Direction.class, "SOUTH"); // *조상 enum 후손 Direction클랴스 중, "SOUTH"의 valueof 가져오기
		Direction d4 = Direction.NORTH;
		
		System.out.printf("d1=%s, d2=%s, d3=%s, d4=%s \n",d1,d2,d3,d4);
		
//================================================================================//
		System.out.println("* 배열처리 *");
		// ** 배열처리로 확인 해보기
		
		// Direction 타입이니까 이 타입으로 배열 만들기 가능!
		Direction []ds = Direction.values(); // Direction.타입의 values를 ds에 배열 형태로 선언
		
		for (Direction d : ds) {
			System.out.printf("%s = %d \n", d.name(), d.ordinal()); //enum의 다양한 매서드들 name, ordinal
		} //for
		
//================================================================================//
		System.out.println("* 열거형 상수간의 비교 *");
	    // ** 열거형 상수간의 비교
	    // => "==" 비교가능 (그러므로 equals() 보다 빠른 성능), == 외 관계연산자는 사용불가능 
	    // => compareTo 는 같으면 0, 왼쪽이 크면 양수, 오른쪽이 크면 음수
	    //    ordinal() 값으로 비교됨
		
		System.out.printf("d1 == d2 : %b \n", d1 == d2);
		System.out.printf("d1 == d3 : %b \n", d1 == d3);
		
		System.out.printf("d1.equals(d2) : %b \n", d1.equals(d2)); //equals 비교
		System.out.printf("d1.equals(d3) : %b \n", d1.equals(d3));
		
		// compareTo 를 ordinal 값으로 비교하게 됨(상수명을 통해 ordinal값을 도출한 거니까!)
		System.out.printf("d1.compareTo(d2) : %d \n", d1.compareTo(d2)); // compareTo 연산 결과는 int
		System.out.printf("d2.compareTo(d1) : %d \n", d2.compareTo(d1));
		
		System.out.printf("d1.compareTo(d3) : %d \n", d1.compareTo(d3)); 
		System.out.printf("d1.compareTo(d4) : %d \n", d1.compareTo(d4));
		
		System.out.printf("d2.compareTo(d3) : %d \n", d2.compareTo(d3)); 
		System.out.printf("d2.compareTo(d4) : %d \n", d2.compareTo(d4));
//================================================================================//
		
		// ** 매개변수(args)로 enum전달 가능(생성자 이용)
		
		
		
	} //main
} //class
