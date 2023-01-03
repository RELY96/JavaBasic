package j13_Collection;

import java.util.HashSet;

//** 대량 연산 매소드(set의 집합 연산) : set1과 set2의 합집합, 교집합..

public class Ex06_SetUnion {

	public static void main(String[] args) {
		// 1. Set 을 2개 정의
		HashSet<String> set1 = new HashSet<String>();
		set1.add("Red");
	    set1.add("Blue");
	    set1.add("Green");
	    set1.add("Pink");
	    set1.add("Black");
	    System.out.println("* set1: "+set1);
	    
	    
	    HashSet<String> set2 = new HashSet<String>();
		set2.add("Seoul");
	    set2.add("Busan");
	    set2.add("Green"); //set1 과 set2 의 Green은 똑같음
	    set2.add("Paris");
	    set2.add("Korea");
	    System.out.println("* set2: "+set2);

		// 2. 대량 연산 테스트 addAll-합집합(집합 합하기!), retainAll-교집합, containsAll-부분집합, removeAll-차집합
	    // 2-1) 합집합
	    set1.addAll(set2); //set1에 합집합(set1에 set2가 합쳐진거)
	    System.out.println("* set1 합집합: "+set1); //합쳐지면서 중복은 안 들어가고 출력됨(HashSet이라서 중복X, 순서X)
	    
	    // 2-2) 교집합
	    set1.retainAll(set2); //set1에 교집합(늘어난 set1과 set2 중 교집합만 set1으로)
	    System.out.println("* set1 교집합: "+set1);
	    
	    // 2-3) 부분집합
	    // set2가 set1의 부분집합인지 확인하기
	    System.out.println("* 부분집합 확인: "+set1.containsAll(set2)); //set1이 set2를 포함하고 있는지? set1 > set2 는 부분집합이면 true
	    
	    // 2-4) 차집합
	    set1.add("Red");
	    set1.add("Blue");
	    set1.removeAll(set2); //set1에서 set2를 모두 뺀 것 -> set1의 남은 것들이 나옴(차집합)
	    System.out.println("* set1 차집합: "+set1);
	} //main
} //class
