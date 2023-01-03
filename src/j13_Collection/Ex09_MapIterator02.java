package j13_Collection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

//HashMap 순차처리 하기(Iterator, Entry 이용)

//** HashMap 의 순차처리 ( Iterator , Entry ) 
// 1) 키와 값 같이 읽어 순차처리 -> entry,iterator,entry 화
// 2) 키와 값을 따로 읽어 순차처리

public class Ex09_MapIterator02 {

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
		// => entry 객체를 다시 setmap에 처리해서 key,value 구분할 수 있게 해주기(entry 클래스 이용(Map 안의 이너클래스(이너 인터페이스) Entry))
		
		while(it.hasNext()) {
			Map.Entry<?, ?> e = (Map.Entry<?, ?>)it.next();
			// it.next(); 를 통해 리턴하는 객체(유지오=50)를 Entry 타입으로 다시 형변환 시키는 것 => 선언된 Map.Entry타입 e를 이용해 key,value get 가능(e.getvalue, e.getkey...)
			
			System.out.println("* Entry key: "+e.getKey());
			System.out.println("* Entry value: "+e.getValue());
		}//while

//----------------------------------------------------------------------------------------//		
		
		 // 2) 키와 값 따로 읽어 순차처리 : HashMap -> Set : keySet()(Key값만 읽어주는 매서드-> key만 읽어서 set에 넣어줌)
	     
		 // 2.1) key값 가져오기
		 set = hm.keySet(); //key만 set에 담기
		 System.out.println("* set by hm.keySet(): "+set); // key만 나옴!
		 
		 // 2.1.1) 반복문 적용하기1(Iterator 에 넣어서 순차처리 출력)
		 it = set.iterator(); //key값만 들어있는 set을 Iterator화
		 while(it.hasNext()) {
			 // hm.get(it.next()); // HashMap hm(원본데이터)을 get으로 꺼내는데, get()안 key값이 it.next로 순차처리되면 해당 key에 맞는 value순차출력
			 // => next가 2번 있으니까 두번 넘어감 -> String변수 hmkey대신 선언해서 얘 불러오기
			 
			String hmkey= (String)it.next();
			System.out.println("* keyset key: "+hmkey);
			System.out.println("* keyvalue value: "+hm.get(hmkey));
		 } //while
		 
//----------------------------------------------------------------------------------------	 
		 
		// 2.1.2) 반복문 적용하기2 (for문) => iterator 안하고 이게 더 간단함★★
		System.out.println("* each for문 test *"); 
		for(String k : hm.keySet()) { //hm안 keyset를 순차적으로 꺼내서 k로 전달
			
			System.out.println("* for key: "+k);
			System.out.println("* for key value: "+hm.get(k));
		} //each for문
		 
//===========================================================================================//	
	      
	    // 2.2) value값 가져오기
		//.values(); : Map 의 value 들을 return 하는 메서드
		Collection<Integer> values = hm.values(); //value들 값 가져오기(Collection 안 매서드 values라서 컬렉션 타입(주머니)에 넣기)
		
		// Collection -> Iterator(순차처리 위해서)
		it = values.iterator(); //값들만 있는 values를 이터레이터화해서 it에 넣기
		// 한줄로 만든다면? it = hm.values().iterator();
		
		int sum=0; //value 합계 구해보기
		int count=0; //평균 구해보기 1.count, 2.size
		while(it.hasNext()) {
			count++;
			sum += (Integer)it.next(); //it.next()를 int변환해서 sum 계산해주기
		} //while
		
		System.out.println("* 합계 : "+sum);
		System.out.println("* 평균1 : "+(float)sum/count);
		System.out.println("* 평균2 : "+(float)sum/hm.size());
		System.out.println("* 최고점 : "+Collections.max(values)); // collection가 값들을 다 갖고 있으니, wrapper Collections에서 Max매서드
		System.out.println("* 최저점 : "+Collections.min(values)); // wrapper Collections Min매서드
		
//===========================================================================================//		
		//Properties : <String,String>만 을 담고 쉽게 처리함(시스템 앱에서 많이 이용) =/= <Object,Object>라서 처리시간이 걸리는 Map이랑 다름!
	} // main
} // class

//Map 인터페이스는 내부에 내부인터페이스 Entry를 가지고 있고, 
//Object key, Object value는 Entry 인터페이스에 선언되어 있음.
//그러므로 Map의 key와 value는 각각의 Object 이며 Map.Entry타입으로 저장됨. 
//그래서 Map의 key와 value에 접근 할때는
//=> 먼저 Map의 인스턴스에서 entrySet으로 키와 value를 둘다 가져온다. 
//=> entrySet은 Set타입이므로 Set타입 인스턴스에 저장
//=> Set타입으로 가져온 인스턴스에서 iterator()메소드 호출해서 iterator가져옴
//=> 얻어온 iterator에서 hasNext메소드를 호출하여 HashMap 내부 요소에 접근.
//=> HashMap의 각 key와 value값은 결국 Map.Entry 타입의 배열에 들어있으므로    
//   HashMap에서 각 key와 value값에 접근하기위해서는  
//   Map.Entry 타입 인스턴스에 iterator의 next()메소드로 key와 value값 가져온다.

