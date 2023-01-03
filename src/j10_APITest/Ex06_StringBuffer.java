package j10_APITest;

// String =/= String Buffer =/= String Builder

//==================================================================================================//

//** String, StringBuffer, StringBuilder 차이 및 장단점 - https://ifuwanna.tistory.com/221

//* String - 불변(immutable) 속성을 가짐 > 문자열의 연산(입력,수정,삭제 등) 이 빈번한 경우 힙(Heap)메모리에 많은 가비지(Garbage)가 생성되므로 ★비효율적
//=> equals 메서드를 오버라이딩 해서 문자열의 내용을 비교할수 있도록 했음 -> equals 매서드 오버라이딩 하면 문자열의 '값'도 읽을 수 있게 됨
//=> 동기화 키워드를 지원하여 멀티쓰레드 환경에서 안전(thread-safe)

//* StringBuffer / StringBuilder(정석 ch9, 477~ ) > 내부적으로 buffer(공간)를 가지고 있으므로 가변성(mutable) 을 가짐
//=> 인스턴스 생성 시 buffer 사이즈 지정 가능 (편집할 문자를 고려하여 충분히 잡는게 좋음)
//=> 한 공간 안에 문자를 편집하러 접근해야 하기 때문에 아래 매서드를 통해 편집함
//=> .append() .delete() 등을 이용하여 동일 객체내에서 문자열 변경가능 > 문자열의 연산(입력,수정,삭제 등)이 빈번한 경우 String 보다 적합

//---------------------------------------------------------------------------------------------------//

//=> StringBuffer(동기화X) vs StringBuilder(동기화O) 차이점
// - StringBuffer : 동기화 키워드를 지원하여 "멀티쓰레드 환경에서 안전(thread-safe)"
// - StringBuilder: 동기화를 지원하지 않으므로 멀티쓰레드 환경에서 적합하지 않지만 "단일쓰레드에서의 성능은 StringBuffer보다 좋음"

// Builder 는 thread Safe기능이 없으니까, 좀더 단순해서 단일 쓰레드 성능은 Builder가 더 좋은 것!
// 쓰레드 : main에서의 실행 흐름(여러개의 실행 흐름이 동시에 운영되는 것처럼 보이게 하는 것 - 여러개 실행흐름이 일하면 서로 흐름 중간에 간섭해서 data가 망가질 수 있다 <= 망가지지 않게 도움:thread safe!)

//==================================================================================================//

//=> equals 메서드 오버라이딩 하지 않았기 때문에 내용을 비교하지 않으므로 '==' 과 동일결과(String에서의 equals 비교는 주소가 아닌 값 비교)
//=> toString 은 오버라이딩 되어 있어서 담고있는 문자열을 String으로 반환 한다(StringBuffer,StringBuilder 를 toString으로 하면 string처럼 값 비교 할 수 있음)

//** StringBuffer클래스 특징
//=> 문자열처리 속도높고, 중간에 변경가능함

//** StringBuffer클래스  메서드  (정석 480 ~ 481 p) 
//=> String 클래스와 유사한 메서드를 많이 가지고 있으며, 저장된 내용을 변경 할 수있는 insert, replace, delete 등을 추가로 제공한다. 

//=========================자주 쓰이는 매서드================================//

//=> append : 문자열로 이어줌
//=> deleteCharAt(10) : 지정된 위치의 '한 문자' 제거  
//=> delete(3,6) : 3<= , <6 사이의 문자 제거
//=> insert(int pos, "abc") : pos 위치에 문자열 "abc" 삽입
//    단, pos 는 0 부터 시작.               
//=> replace(int s, int e, "END")
//      s <= ~ < e 구간의 문자열을 "END" 로 변경함.
//=> capacity() : StringBuffer 인스턴스의 buffer 크기
//=> length() : buffer에 담긴 문자열의 길이

//==================================================================================================//
public class Ex06_StringBuffer {

	
	public static void main(String[] args) {
		// ** String Buffer 기본 특징
		StringBuffer sb1 = new StringBuffer("abc"); // abc에 해당하는 buffer 공간이 만들어진 후 abc값 들어가있음
		// sb1,sb2 는 다른 인스턴스라 다른 주소O
		StringBuffer sb2 = new StringBuffer("abc");

		// 1) 주소 비교 -> 둘다 각각 다른 인스턴스라 false, 주소 다름!
		System.out.println("sb1 == sb2 : " + (sb1 == sb2));
		System.out.println("sb1 equals sb2 : " + (sb1.equals(sb2)));

		// 2) String과 StringBuffer 비교
		/* String s1 =b1; <-type mismatch error */
		String s1 = sb1.toString(); // StringBuffer를 String type으로 형변화 해서 오류X
		String s2 = sb2.toString(); // String s1,s2 정의

		System.out.println("s1 == s2 : " + (s1 == s2)); // 처음 전달받은 "주소는 각각 다른 주소" F
		System.out.println("s1 equals s2 : " + (s1.equals(s2))); // String은 equals에서 갖고 있는 값을 비교하게 되므로 값은 같다고 나옴 T

		// 3) StringBuffer 매서드
		System.out.println("** 스트링버퍼 매서드 테스트");
		s1 = "우리나라";
		s2 = "대한민국";

		sb1.append(s1); // sb1번에 s1 어펜드 //sb1이 toString으로 오버라이딩 돼있는 상태
		sb1.append(s2);
		sb1.append(sb2); // sb1번에 스트링버퍼 sb2 어펜드
		System.out.println("* After append sb1: " + sb1);

//Append===========================================================================================//

		StringBuffer sb3 = new StringBuffer("03");
		sb3.append(100); // StringBuffer sb3에 int 데이터 append
		sb3.append(200).append(300).append(400.567); // StringBuffer append overloading 계속 나열 가능
		System.out.println("* After append sb3: " + sb3); // 문자열 연산 값 나옴!

//Insert===========================================================================================//
		
		System.out.println("* insert sb3: " + sb3.insert(0, "abcd")); //"abcd"가 sb3의 제일 앞(0)번째부터 채워져서 ""출력됨

//replace(시작위치,마지막위치+1,변경값) : .부터 끝까지를 END로 변경==========================================//
		
		System.out.println("* replace sb3: " + sb3.replace(sb3.lastIndexOf(".") ,sb3.length()/*끝까지*/,"END"));
		
//delete==========================================================================================//		
		
		System.out.println("* delete sb3: " + sb3.deleteCharAt(5)); //1) 1개 지우기 - index가 5인 char 1개가 delete 됨
		System.out.println("* delete sb3: " + sb3.delete(0,3)); //2) 구간 지우기(0부터 3이전 까지)

//capacity 용량 할당 확인============================================================================//
		
		System.out.println("* capacity sb3: " + sb3.capacity()); //capacity 용량 38 단위는 byte (인스턴스의 용량)
		// StringBuffer 인스턴스 생성 시 기본 용량은 16byte(16자의 문자열을 담을 수 있는 빌더), append로 38까지 자동 늘어난 것!
		// StringBuffer(int capacity) 오버로딩 사용해서, 생성 시에 용량을 조정할 수도 있음! /*StringBuffer sb = new StringBuffer(10);*/

	} // main
} // class
