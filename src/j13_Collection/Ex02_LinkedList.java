package j13_Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import j10_APITest.Ex05_Person;

// ** Collection 계층도
// Collection(인터페이스) -> List(인터페이스),Deque(인터페이스) -> LinkedList(클래스-다중 상속)
// => 다형성 적용 가능 '조상 = new 자손들'이 가능하다는 말!! (List list2 = new LinkedList();) 

//=============================================================================//

public class Ex02_LinkedList {

	public static void main(String[] args) {
		// 1. 정의
		LinkedList list = new LinkedList(); // LinkedList 생성(불러오기)	
		// 다형성 적용 - 
		List list2 = new LinkedList(); //ArrayList();도 됨

//-----------------------------------------------------------------------------------//		
		
		// 2. 초기화
		// => add (기본자료형은 Wrapper로 자동 형변환됨)
		list.add("Java"); //String타입 매개변수 넣기
		list.add("Html");
		list.add("Css3");
		list.add("MySql");
		list.add("Oracle");
		list.add("Servlet");
		list.add("JSP");
		list.add("Java");
		list.add("Spring");
		
//-----------------------------------------------------------------------------------//
		
		// 3. 사용 - get,set(수정),remove 매서드 활용
		list.remove(1); //1번 지우기
		list.set(2, "홍길동"); //2번을 "홍길동"으로 수정
		list.set(5, 12345);
		list.add(1,new Ex05_Person("990909-2940572","엄희정")); //1번에 끼워넣기
		
		// 4. 출력
		for (Object o: list) {
			System.out.println(o);
		} //for

//=============================================================================================//		
		
		// 5. 배열 -> List (Iterator 객체로 변환 가능해짐)
		// Iterator : 순차처리를 지원하는 클래스
		String[] city = {"성남","용인","서울","부산"}; //String 타입의 배열 city(length 4)
		
		list2 = Arrays.asList(city); // 1. 어떤 타입이든 간 배열을 집어 넣어주면 배열을 List로 만들어줌! 만들어놓고 안쓴 LinkedList(); list2에 city 리스트화 넣기
		// List list3 = Arrays.asList(city); 로 List 타입 변수에 즉시 넣어주기도 가능*
		
		
		// List 타입으로 바꿔줬으니까 list2에 add 사용해보기
		// list2.add("Test");
		// 원본 배열 데이터 city[]는 변경불가함(원본이 List가 아니었으니까) -> 오류! / 변환한 경우에는 원본 변경X, 오직 사용목적(readOnly)
	
		
		Iterator icity = list2.iterator();  // 2. List를 iterator 타입으로 변환해서(객체) 리턴 시켜주기 한게 변수 icity
	    // ** Iterator : 순차처리를 편리하게 지원해주는 클래스
	    // => hasNext(), next() 메서드 이용해서 순차처리 출력가능
		
		while(icity.hasNext()) { // icity가 다음 원소를 갖고 있으면
			System.out.println(icity.next()); // icity가 다음 원소 출력
		} //while
	} //main
} //class

// ※LinkedList 는 ArrayList 의 단점(하나씩 이동하는 비효율성)을 보완!!

// LinkedList Queue, List 인터페이스 다중 상속 받고 있음 ->
// LinkedList 모든 데이터가 각각 다음 데이터를 가리키고 있음(열차칸 처럼 - 중간에 투입해서 a-b 사이를 연결)
// 1) a-b 사이에 새로운 데이터 c 끼워넣기 : a-c-b 로 c를 연결만 시킴
// 2) c-d-e 에서 d 삭제 : 연결된 d를 끊고 c-e를 연결
//★ => LinkedList는 배열을 list로 해서 왔다갔다 할 수 O

// 단, ArrayList 순차처리에서는 매우 유리

//==========================================================================================================================//

//ppt 12 ~ 17
//** List 인터페이스 (ppt 18, 23)
//=> List의 특징 : 순서가 있으며 중복된 원소를 가질 수 있다.
//=> 구현 클래스 : ArrayList, LinkedList

//** LinkedList<E>  
//=> ArrayList 및 배열의 단점을 보완하여 고안됨.   
//=> 장점 
// 1) 저장공간을 늘리는 과정이 간단.
// 2) 자료 입력 & 삭제 과정이 단순.
//=> 단점 : 순차처리의 access time 이 느리다.
//=> 빈번하게 삽입과 삭제가 일어나는 경우에 사용 

//** ArrayList<E> 
//=> 순서를 유지하며 중복을 허용하는 자료구조  
//=> 배열(Array)의 향상된 버전 또는 가변 크기의 배열이라고 생각하면 된다. 
//=> 장점 : 자료구조가 간단하며 사용이 쉽고 순차처리의 access time이 가장 빠르다.
//=> 단점
//1) 크기 변경시 새로운 배열을 생성 후 기존 자료를 옮겨야 하므로 비효율적
//2) 비순차적인 자료의 추가,수정,삭제시에 복사 및 이동 때문에 비효율적
//=> 크기가 일정하고 비순차적인 자료 수정이 발생하지 않는 경우 유리. 

//---------------------------------
// ** source Code class header 참고(계층도)
// public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, java.io.Serializable {}
// public class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, java.io.Serializable {}













