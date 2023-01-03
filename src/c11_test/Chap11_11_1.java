package c11_test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Stack;
import java.util.TreeSet;

// 11장 연습문제 1번

public class Chap11_11_1 {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(3);
		list.add(6);
		list.add(2);
		list.add(2);
		list.add(2);
		list.add(7);
		// ArrayList 3,6,2,2,2,7 넣어줌(중복허용,순서대로)
		System.out.println("* list: "+list);
		
		HashSet set = new HashSet(list); // list를 HashSet에 set에 넣어주기(중복허용X) 3,6,2,7
		System.out.println("* set: "+set);
		
		TreeSet tset = new TreeSet(set); // set을 TreeSet에 넣어주기(오름차순 정렬) 2,3,6,7
		System.out.println("* tset: "+tset);
		
		LinkedHashSet lset = new LinkedHashSet(set); // 입력된 순서대로 출력
		System.out.println("* lset: "+lset);
		
		Stack stack = new Stack(); // stack 구조(감자칩통) 만들고, 
		stack.addAll(tset); //tset을 stack 구조에 모두 넣어주기(collection의 후손 tset추가) -> 2먼저 담기고 7까지
		
		while(!stack.empty()/*stack이 다 "비워지지 않았다면" 반복문 돌리기ㅣ*/) { // 출력 시 제일 나중 담긴 7먼저 출력
			System.out.println(stack.pop()); //stack의 반복문 꺼내는 매서드는 get이 아닌 뽑아올리는 pop
		} //while
	} //main
} //class

// ※Tree로 오름차순 한 걸 stack에 넣고 stack출력하면 내림차순 한 효과!
