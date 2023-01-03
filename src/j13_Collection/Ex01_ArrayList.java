package j13_Collection;

import java.util.ArrayList; //ArrayList 임포트
import j10_APITest.Ex05_Person; //다른 패키지에 다른 클래스 임포트

//** Collection 계층도
//Collection(인터페이스) -> List(인터페이스) -> ArrayList(클래스)

// ArrayList<E> : List 인터페이스 구현 클래스 만들기
// ArrayList 내장클래스 : new로 클래스 객체화(인스턴스 생성)

//** ArrayList<E> 의 저장용량  
//   => 데이터가 증가하면 메서드 호출하지 않아도 저장용량은 자동증가 함
//   => 필요시엔 미리 설정가능
//1) 생성자 
//   => 초기값 지정 가능 :  new ArrayList<>(100) ;
//2) 메서드 이용
//   => public void ensureCapacity(int minCapacity) : ArrayList 에 정의됨
// ★★ ArrayList 생성 시 충분한 공간 할당하는 게 바람직함!!

public class Ex01_ArrayList {

	public static void main(String[] args) {
		// 1-1. 배열처럼 ArrayList도 정의(크기 정해지지X) =/= 배열:정의할 때 크기가 정해져있음
		ArrayList list = new ArrayList();
		
//------------------------------------------------------------------------------------------------------------//
		
		// 1-2. ArrayList 정의 시 저장용량 설정
	    // ** 저장용량
	    // 1) 필요시에 자동으로 늘려줌(비효율적 : 큰 공간 할당하고 기존 값들을 이동)
	    // 2) 생성시에 할당가능 : 생성자 매개변수로 지정
		// 3) ensureCapacity 매서드로 용량변경 가능
		
		// 사이즈는 리스트의 요소의 수, 용량은 잠재적으로 list 내부구조를 재할당 없이 수용할 수 있는 요소의 수
		System.out.println("* size 00(add 안한 초기 사이즈): "+list.size());
		
		// ** ensure 용량지정
		list.ensureCapacity(20); //용량 20으로 지정
		System.out.println("* size 01(용량지정 후): "+list.size());
		// size는 add 안한 상태니까 다 0임!
	
//------------------------------------------------------------------------------------------------------------//		
		
		// 2. 초기화(ArrayList 클래스 안 add매서드 꺼내기+매서드 안 매개변수(Object) 넣기 -> 매개변수 타입에 따라 알아서 오토박스 처리됨(ex: == new Integer(100))) + <>해야 옳은 형식!
		// 매개변수가 기본자료형 => Wrapper클래스로 자동형변환(오토박싱)	
		list.add(100); // -> 오브젝트 타입
		list.add(new Integer(200));
		list.add(100);
		list.add("홍길동");
		list.add(300);
		list.add(400);
		list.add(500);

		// 3. 사용 - get,set(수정),remove 매서드 활용
		int sum=(int)list.get(0/*0번*/)+(int)list.get(1/*1번*/); //(int)오브젝트 타입 해줘서 연산 가능한 것
		System.out.println("* sum: "+sum); //100+200 = 300
		System.out.println("* size1: "+list.size()); //배열의 크기도 알 수 있다(size,길이가 아닌 크기)
		
		// 수정
		list.set(0/*수정될 인덱스*/, sum/*수정할 값*/); // 리턴 타입-오브젝트 => 0번 100이 300으로
		
		// 끼워넣기
		list.add(2/*list인덱스 추가할 자리*/,888/*추가할값*/);  //차례대로 쌓기만안하고 중간에 넣을 수도 있음, 2가 888 하고 그 밑이 하나씩 밀림
		
		// 삭제
		list.remove(4); //list 4번 인덱스 지우기, 4번 (밀린)홍길동 지워짐
		
//------------------------------------------------------------------------------------------------------------//
		
		// 4. 출력( for문 or eachfor문 사용 )
		for(Object o/*매개변수 인덱스 타입이 Object니까*/:list) {
			System.out.print(o+" ");
		}
		System.out.println(""); //하나 꺼내고 줄바꿈
		
//------------------------------------------------------------------------------------------------------------//
		
		// 5. Person추가(매개변수 자리에 객체(Object) 넣을 수 있으니까, 다른 클래스(객체) 추가해보기)
		list.add(1, new Ex05_Person("990909-2940572","엄희정")); //1 자리에 person객체 끼워넣기
		
		// 5-1. 출력
		for(Object o:list) {
			System.out.print(o+" "); //person의 toString 호출된 것 = +Person;
		}
		System.out.println("");
	} //main
} //class

/*************************************************************************************************************************/

// 1. ArrayList 클래스는 순차적인 구조를 지님 1. ArrayList 클래스 new로 생성
// 2. ArrayList는 자료(데이터)를 담을 수 있는 클래스
// 3. ArrayList 각각에는 '객체(Object)'를 담을 수 있음(주로 다른 클래스를 담는 다던가, 그래서 매개변수가 Object인 것)
// 4. 객체를 담거나(추가), 끼워넣거나, 삭제하거나, 변경하거나, 볼 수 있음 ->  add,get,set(수정),remove 매서드 등...

// 5. ArrayList의 크기는 무한정하지 않기 때문에, StringBuffer 처럼 생성 시 기본크기 할당+크기지정 가능
// 5-1. 공간 늘리는 법 -> 새로운 ArrayList(2배 정도 크기의)를 new 생성 후, 기존 list의 주소를 새 list의 주소로 옮김(매번 옮겨줘야해서 ★비효율적)
// => 5-2. 데이터의 변동성이 적은, 순차적인 자료를 처리하는데 유리함















