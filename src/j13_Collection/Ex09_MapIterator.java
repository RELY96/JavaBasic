package j13_Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//HashMap 순차처리 하기(Iterator, Entry 이용)

//** HashMap 의 순차처리 ( Iterator , Entry ) 
// 1) 키와 값 같이 읽어 순차처리
// 2) 키와 값을 따로 읽어 순차처리

public class Ex09_MapIterator {

	public static void main(String[] args) {

		// 1. <이름, 점수> 형태의 Map만들기
		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		hm.put("구준표", 80);
		hm.put("홍길동1", 90);
		hm.put("금잔디", 70);
		hm.put("유지오", 50);
		hm.put("홍길동2", 85);
		hm.put("구영표", 60);
		
		System.out.println("* hm: "+hm); // 순서 상관X
		
		// 2. 반복문으로 처리하려면 순차처리가 가능하게 전처리를 해줘야함
		
	    // 1) 키와 값 같이 읽어 순차처리 
	    // => HashMap -> Set : entrySet() : map data를 set처럼 만들어줌(key와 value를 묶어서 하나의 entry로 만들고, set에 넣어주는 것)
	    //    키와 값 을 같이 읽어  하나의 데이터(entry) 로 Set에 저장 => 그 후 iterator로 처리 가능!
		
//----------------------------------------------------------------------------------------//
	      
	    // ** <?> : 모든 자료형, 내부적으로는 Object -> 아무 데이터 넣기가 쉬워짐!
	    // <? super 객체형 > => 명시된 객체형의 조상 객체
	    // <? extends 객체형 > => 명시된 객체형과, 객체형을 상속한 자손 객체
		Set<?> set = hm.entrySet();
		System.out.println("* set by hm.entrySet(): "+set); //hm을 entry로 묶어 set에 넣어준 set
		// set안에 데이터가 key,value로 나뉘지 않고 (유지오=50)이 한 덩어리! => hm데이터 대로 나옴
		
		// 2)
		// set을 Iterator로 적용 가능 => set의 Data를 읽어왔을 뿐
		Iterator<?> it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println("while 안: "+it.next()); //entry별로 순서대로 찍힘
		}//while
		
		
		// => 단점: key와 value가 한 덩어리라 목적에 따라 나눠 정렬할 수 없음 => key값, value값 인지할 수 있어야 함!
		// => entry 객체를 다시 setmap에 처리해서 key,value 구분할 수 있게 해주기(entry 클래스 이용(Map 안의 이너클래스(이너 인터페이스) Entry))
		Map.Entry<?, ?> e = (Map.Entry<?, ?>)it.next();
		
		// it.next(); 를 통해 리턴하는 객체(유지오=50)를 Entry 타입으로 다시 형변환 시키는 것 => 선언된 Map.Entry타입 e를 이용해 key,value get 가능(e.getvalue, e.getkey...)
		System.out.println("* Entry key: "+e.getKey());
		System.out.println("* Entry value: "+e.getValue());
		
		
		
		
		
		
		
		
		
		
//----------------------------------------------------------------------------------------//
		
		
		
		
		
	
	} // main
} // class
