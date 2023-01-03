package j13_Collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

//HashMap은 Map인턴페이스<KEY,VALUE형태로 되어 있음> 밑에 자손임
// <'키' 'value'> => 둘다 오브젝트, 객체형태만 허용, 오토박싱O(Wrapper클래스)

// Map은 .add 가 아닌 .put으로 객체 넣어줌 형식 > ㅁ.put((),());
// Map.entry<>로 순차처리 가능 -> key를 통해 value를 지우고, 추가하고 할 수 있다 -> key는 늘 유일성이 보장이 되고, 중복되면X!!!

//========================================================================================//

//*** 해싱과 해쉬함수 => 정석 651p (Hash)
// 해싱 => 해시 함수를 이용해서 데이터를 해시 테이블에 저장하고 검색하는 기법 : 데이터를 나누고 쪼개면서 관리하는 기법
// 해쉬함수: 데이터를 작게 쪼개는 함수들

//========================================================================================//

//*** Map ( Key, Value )
//=> HashMap (Key 값의 중복을 허용하지 않고, 순서 유지를 보장받지 못한다.) 해쉬셋
//=> TreeMap (Key 값의 중복을 허용하지 않고, "키값"으로 "오름차순" 정렬이 된다.) 
//=> LinkedHashMap (Key 값의 중복을 허용하지 않고, "입력순서 유지를 보장"받는다.) 입력한대로 순차가 있음 LinkedHashSet

//========================================================================================//

//*** HashMap : Key, Value 정보 지정
//=> key 는 유일, Value 는 중복 허용 
//=> null 값 허용 map.put(null, null) -> Key가 중복되면 안되니까, null키는 한번만 입력가능!
//   또는 map.get(null) 가능 -> 꺼낼 때 get(Key값)으로 꺼냄

//========================================================================================//

public class Ex07_HashMap {

	public static void main(String[] args) {
		// 1. HashkMap
		// 1.1) 정의(HashkMap 키, 밸류 제네릭에 넣어서 생성)
		Map<Integer, String> hm = new HashMap<Integer, String>(); //키:인티저, 밸류:스트링
		
		// 1.2) put (Key 중복X, value 중복O)
		// 컴파일에서는 키 중복체크X, 실행 시 key가 중복으로 들어가지 않는 것뿐!
		// 순서 상관X 출력됨
		hm.put(1, "Python"); //오토박싱 일어남
		hm.put(10, "Spring");
		hm.put(2, "Java");
		hm.put(20, "Spring");
		hm.put(3, "MySql");
		hm.put(30, "Oracle");
		hm.put(new Integer(4), "JDBC");
		hm.put(5, "Servlet");
		hm.put(1, "Jsp"); // ★중복 입력 시 나중값 put이 앞 값을 덮음
		// collection안에 toString 매서드 이미 구현되어 있어서 hm출력만 하면됨!

		// 1.3) 출력
		System.out.println("* HashMap1: "+hm); //key = value 형식으로 출력

		// 1.4) 활용(Key로 접근) - get, remove, size
		System.out.println("* HashMap sixe: "+hm.size());
		System.out.println("* HashMap get(★Key 4): "+hm.get(4)); //-> 꺼내기
		System.out.println("* HashMap remove(★Key 3): "+hm.remove(3)); //제거
		// 키가 3인애가 지워짐 -> 하나씩 앞 당겨지거나 하는 거X!!! => key가 1,2,4,5 가 안에 남음
		// Key가 String 인 경우도 상관없이 가능
		
		System.out.println("* HashMap get(★Key 4): "+hm.get(4)); //꺼내기 -> 키가 4인 JDBC 가 그대로 나옴
		System.out.println("* HashMap2: "+hm); //변화 후 데이터 출력
		
//=========================================================================================//
		// 2. 각종 Map 비교
	    //=> TreeMap (Key 값의 중복을 허용하지 않고, "★키값으로 오름차순 정렬"이 된다.)
	    //=> LinkedHashMap (Key 값의 중복을 허용하지 않고, 입력순서 유지를 보장받는다.)
		
		// 2.1) TreeMap
		Map<Integer, String> tm = new TreeMap<Integer, String>(hm/*hm데이터를 이용해 treemap으로 만듦*/);
		//조상은 HashMap이랑 똑같이 Map이니까 Map으로 타입 설정
		// ※생성자의 매개변수로 위의 HashMap 을 사용하면 일일이 다시 put입력 안하고, 위의 데이터 그대로 사용가능
		System.out.println("* TreeMap1: "+tm); // key값으로 오름차순정렬
		System.out.println("* TreeMap size: "+tm.size());
		
//----------------------------------------------------------------------------------------//
		
		// 2.2) LinkedHashMap
		Map<Integer, String> lm = new LinkedHashMap<Integer, String>(hm);
		
		System.out.println("* LinkedHashMap1: "+lm);
		// 코드로 입력한 순서가 아니라, lm이 hm데이터를 매개변수로 받았기 때문에 hm데이터 순서가 lm에 적용됨
		// 60행에서 매개변수를 통해 전달된 순서가 적용
		
		//※입력순서 확인
		lm=new LinkedHashMap<Integer, String>(); //lm에 재입력
		lm.put(1, "Python"); 
		lm.put(10, "Spring");
		lm.put(2, "Java");
		lm.put(20, "Spring");
		lm.put(3, "MySql");
		lm.put(30, "Oracle");
		lm.put(4, "JDBC");
		lm.put(5, "Servlet");
		lm.put(1, "Jsp");
		System.out.println("* LinkedHashMap2: "+lm); //중복 Key값은 나중값 출력, 코드에 입력된 순서대로 출력됨!
		
//=========================================================================================//
		
	} //main
} //class
