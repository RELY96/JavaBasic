package j13_Collection;

import java.util.HashMap;
import java.util.TreeMap;

// ** Student Map Test : Student 객체 5개 HashMap에 넣고 출력하기

 class Student {
	private String no;
	private String name;
	private int java;
	private int html;
	private int sum;
	
	Student (String no, String name, int java, int html){
		this.no=no;
		this.name=name;
		this.java=java;
		this.html=html;
		this.sum=java+html;
	} //Student 생성자
	
//-----------------------------------------------------------//
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}
//-----------------------------------------------------------//
	
	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", java=" + java + ", html=" + html + ", sum=" + sum + "]\n";
	} //toString
} // Student Class

//==========================================================//

public class Ex08_MapStudent {

	public static void main(String[] args) {
		// 1. HashMap 정의
		HashMap<String,Student/*key String(no), 밸류 Student*/> sm = new HashMap<String,Student>();
		
		// 2. put
		sm.put("A001", new Student("A001","홍길동",80,90));
		sm.put("A002", new Student("A002","김길동",70,100));
		sm.put("A003", new Student("A003","이길동",85,95));
		sm.put("B001", new Student("B001","오길동",100,60));
		sm.put("B002", new Student("B002","조길동",90,75));

		// 3. 활용(수정★★★, 삭제)
		sm.get("A003"); //A003 꺼내기 -> new Student("A003","이길동",85,95) 에 접근해서 setter,getter 있으면 얘를 수정할 수 있음
		sm.get("A003").setName("김그린"); //A003 객체의 이름 수정
		
		// 지우기
		sm.remove("A002"); //Key를 이용해 삭제

		// 4. 출력
		System.out.println(sm); //toString 출력
		// 순서 상관없이 임의대로 출력됨!
		
		// => 순차처리 지원하지 않아서 이 방식으로는 정렬불가 => Iterator 사용(key,value를 어떻게 꺼낼지가 관건)
//==========================================================//
		
		TreeMap<String,Student/*key String(no), 밸류 Student*/> tm = new TreeMap<String,Student>(sm);
		System.out.println(tm); // -> 키로 오름차순 정렬 방식
		
		
		

	} //main
} //class
