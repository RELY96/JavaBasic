package j13_Collection;

import java.util.Enumeration;
import java.util.Properties;

//Properties : <String,String>만 을 담고 쉽게 처리함(시스템 앱에서 많이 이용) =/= <Object,Object>라서 처리시간이 걸리는 Map이랑 다름!

//=> Properties는 HashMap의 구버전인 Hashtable을 상속받아 구현한 것, Hashtable은 키와 값을 (Object, Object)의 형태로 저장하는데 비해 
// ★ Properties는 (String, String)형태로 저장하는 "보다 단순화된 컬렉션 클래스" 

// Properties SourceCode header => public class Properties extends Hashtable<Object,Object> {...

//=> 주로 애플리케이션의 환경설정과 관련된 속성을 저장하는데 사용되며 데이터를 파일로부터 읽고 쓰는 편리한 기능을 제공. 
//   그래서 간단한 입출력은 Properties를 활용하면 몇 줄의 코드로 쉽게 해결할 수 있다!!!

public class Ex10_Properties {

	public static void main(String[] args) {
		
	    // ** 정의 & Data 입력
	    // => 동일Key 허용되지않고, 입력시에는 나중값이 적용됨
		Properties pp = new Properties(); //어차피 스트링이라 <>필요없음
		pp.setProperty("insert", "MemberInsert.java"); //Properties는 set으로 데이터 넣음
		// insert 요청이 들어오면, MemberInsert.java 가 처리한다 등 활용가능
		
		pp.setProperty("update", "MemberUpdate.java");
		pp.setProperty("delete", "MemberDelete.java");
		pp.setProperty("list", "MemberList.java");
		pp.setProperty("detail", "MemberDetail.java");
		pp.setProperty("list", "MemberPrint.java");
		// pp.setProperty("test", 12345); -> String아니니까 컴파일 오류!
		
		System.out.println("* PP: "+pp); //toString으로 출력됨(key 중복은 허용하지 않음, 나중값 적용)
		
//----------------------------------------------------------------------------------------------//
		
		// Properties의 순차처리 방식 : Enumeration(순차처리용 매서드 갖고 있음) + .propertyNames();(Enumeration타입)
		Enumeration<?> ep = pp.propertyNames(); //Enumeration은 프로퍼티즈처럼 타입이 정해진게 아니라 제너릭<?>넣음
		// .propertyNames(); Properties의 Key 값들만 returns
		
		while(ep.hasMoreElements()) { // '=' 이터레이터의 hasNext();와 같음
			
			String eKey = (String)ep.nextElement(); //next값을 담을 eKey 정의		
			System.out.printf("* key=%s, getProperty=%s get=%s \n",eKey, pp.getProperty(eKey/*key넣어서 맞는 밸류값 출력*/), pp.get(eKey));
			
			// Properties도 Map처럼 순서 상관없이 맘대로 담김 -> Enumeration<?> ep에 pp의 key값을 담을 때도 무작위로 재정렬
		} //while
	} //main
} //class

//=============================================================================================//

//※Properties는 정렬과는 상관없이, direct로 빠르게 해당되는 데이터 찾으려고 할 때 많이 사용함!!