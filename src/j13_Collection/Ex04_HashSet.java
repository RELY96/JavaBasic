package j13_Collection;

import java.util.HashSet;
import java.util.Iterator;

//** Set : ppt 30 p : 원소의 중복을 허용하지 않고, 순서가 없음
//=> HashSet, TreeSet, LinkedHashSet

//** HashSet
//=> HashSet은 해쉬 테이블에 원소를 저장하기 때문에 성능면에서 가장 우수, But, 원소들의 순서가 일정하지 않음!!

//** Iterator 클래스 를 이용한 처리 (출력 등..) ** set은 순차가 없어서, 반복문을 적용할 수 X -> iterator로 감싸줘서 순차처리 가능하게 만들기(List는 순차가 있어서 반복문 그냥 사용가능!)
//=> 배열 -> Set -> Iterator 해서 순차 처리 적용하기

public class Ex04_HashSet {

	public static void main(String[] args) {
		// HashSet
		// => 순서 없고, 중복 불가
		// => 동일성 Test
		// 제네릭을 적용하지 않거나, Object Type 인경우
		// 값은 같지만 Type 이 다른 경우는 다른 데이터로 취급!! : "123" 과 123 은 둘다 들어감

		// 1.1)Object
		// 1. 정의(Object에는 모든 객체가 들어갈 수 있으니 다른 타입 객체 넣어보기)
		Object[] ob = { "가", "나", "123", new Integer(123), "가", "나", "다"};
		
		HashSet<Object> oset = new HashSet<>(); //Object 배열 담을 HashSet 공간 생성
		// 제네릭 타입<ㅁ>으로 어떤 타입을 담을지 정할 수 있음
		// <Object> 로 하면 다른 클래스 타입들도 다 올 수 있음, <>생략하면 다 default 는 Object
//---------------------------------------------------------------------------------------//

		for(Object o:ob) { //오브젝트 배열 안에 있는 애들 하나씩 꺼내서 oset에 넣어주기
			if(!(oset.add(o))) System.out.println("* 중복자료(add실패): "+o);
			// 1) HashSet 공간 oset에 o 하나씩 담기(추가)
			// 2) .add(o) return은 boolean -> add 성공하면 true, add 실패하면 false return => if문으로 담겼는지 확인 가능!
		} //for
		System.out.println("* oset: "+oset); //완성된 oset 출력(중복자료 제외하고 다 담김) => 순서가 일정하지 않아서 배열 순서와 다름:주머니에 들어간거
		
//======================================================================================//
		
		// 1.2)String
		HashSet<String> set = new HashSet<String>(); //HashSet에 add 할때는 스트링 타입만 들어가게 설정됨
		// toString 매서드 오버라이딩 되어있는 상태 -> set만 해도 출력됨!
		
		// 2. String 타입만 .add Test
		set.add("육회비빔밥");
		set.add("짬뽕");
		set.add("123");
		set.add("육회비빔밥");
		set.add("쌀통닭");
		set.add("볶음밥");
		/*set.add(new Integer(123)); -> String아닌 다른 타입 컴파일 에러!
		set.add(123);*/
		
		// 3. 출력
		System.out.println("* set: "+set); //중복 제외하고 순서상관X 출력
		
		// 4. 활용
		// 4-1) 크기확인(size)
		System.out.println("* set.size: "+set.size()); //size 4
		
		System.out.println("* 삭제 Test *");
		
		// 4-2) 삭제(삭제순서를 알려면 순차처리 해줘야하니까, 반복처리로 순서부여 필요)
	    // ** Iterator 를 이용한  순차처리
		// 반복처리가 필요하면, 이터레이터 타입으로 처리해서 이터레이터의 반복처리 매서드 사용할 수 있음(hasNext이용)
	    // => 순차적으로 비교하면서 원하는 값 찾기, 삭제하기 
		
	    // =>  iset 의 remove 는 set 에 반영됨
		Iterator<String> iset = set.iterator();
		
		while(iset.hasNext()) { // 뒤 데이터가 있으면 반복
			if(iset.next().contains("3")) iset.remove(); //다음 데이터가 3을 포함하면 지워짐 -> iset의 원본인 set("123")이 지워지는 거임!
			// ★★반복문 내부에서 이터레이터로 감싸지 않은 원본 데이터 set으로 접근하면 오류!
		} // while(iterator로 감싼 set을 반복처리)
		System.out.println("* iset: "+iset); //set이라는 데이터를 "이터레이터 형태로 감싸"서 처리하는거라, 원래 데이터 set에 활용이 반영되는 것! => iset은 감싼주소가 나옴
		System.out.println("* set: "+set);
		System.out.println("* set.size: "+set.size());
		
//=================================================================================================//
	    // ** Iterator 인스턴스 재사용
	    // Iterator 는 한번 사용을 마치면 자료를 포인트하는 커서가 끝에 가 있어, hasNext()가 false 를 return함
	    // => 다시 사용하려면 Iterator를 재할당해야 한다.
		iset=set.iterator(); //iset에 이터레이터 재할당! -> 재할당 후 커서가 
		while(iset.hasNext()) {
			String menu = iset.next();
			if(menu.contains("밥")) System.out.println("* Iterator 인스턴스 재사용: "+menu
					/*iset.next 또하면 next가 두번이라 두번 넘어가기 때문에 출력은 건너띄워서 됨. menu변수를 활용해 next 1번만 쓰도록 조정*/);
		} //while
		
		
//=================================================================================================//		
		// ** 반복문 사용예(반복문 안에서 set 사용불가와 관련)
		for(int i=0; i<3; i++) {
			set.add(String.valueOf(i)); // i를 String으로 리턴해주는 식 => set.add("0"), set.add("1")...
			// set.add 해주는 거랑 똑같은 거 -> 반복문 사용가능
		}
		System.out.println("* set: "+set);
		System.out.println("* set.size: "+set.size());
		// =/= 반복문을 이용해서 set에 담긴 데이터를 '차례대로' 꺼낼 수 없어서 set을 반복문에 쓸 수 없는 거! -> set은 순차라는 게 없기 때문에
		// => iterator 사용
	} // main
} // class

//=================================================================================================//

//** set을 이용하면 중복처리 알고리즘 말고도 쉽게 중복자료 걸러내기 가능!
