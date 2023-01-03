package j13_Collection;

//** ArrayList 와 LinkedTest 비교

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// <> : 정확하게 타입을 정해서 쓰고 싶을 때 타입을 정해주는 거 - 제너릭

public class Ex03_ArrayLinkedTest {
	   // ArrayList, LinkedList 비교(메인에서 두개 다 실행테스트)
	
	   // 순차처리 add
	   public static long add1(List<String> list) {  //<String>"만" 담을 수 있는 list
	      long start = System.currentTimeMillis(); // 현재 시스템 시간을 밀리세컨드(ms) 단위로 전달
	      // return 값은 long Type 
	      for (int i = 0; i < 1000000; i++)
	         list.add(i + "");
	      long end = System.currentTimeMillis();
	      return end - start;
	   }
	   // 비순차처리 add : 중간에 넣기
	   public static long add2(List<String> list) {
	      long start = System.currentTimeMillis();
	      for (int i = 0; i < 10000; i++)
	         list.add(500, "X");
	      long end = System.currentTimeMillis();
	      return end - start;
	   }
	   // 순차처리 remove : 뒤에서부터 삭제 (뒤부터 순차삭제)
	   public static long remove1(List<String> list) {
	      long start = System.currentTimeMillis();
	      for (int i = list.size()-1; i >= 0; i--)
	         list.remove(i);
	      long end = System.currentTimeMillis();
	      return end - start;
	   }
	   // 중간에서 remove : 앞에서부터 삭제 (앞부터 지워지면 그 뒤가 0번째로 계속 이동해야해서 중간 삭제)  
	   public static long remove2(List<String> list) {
	      long start = System.currentTimeMillis();
	      for (int i = 0; i < 10000; i++)
	         list.remove(i);
	      long end = System.currentTimeMillis();
	      return end - start;
	   }

	public static void main(String[] args) {
	      // 추가할 데이터의 개수를 고려하여 충분히 잡아야한다
	      // ArrayList<String> al = new ArrayList<>(2000000); //크기 이백만개
	      ArrayList<String> al = new ArrayList<>(100); //크기가 작으면 자동으로 용량 늘리는 시간이 있어서 더 오래 걸림
	      LinkedList<String> ll = new LinkedList<>();

	      System.out.println("= 순차적으로 추가하기 =");
	      System.out.println("ArrayList :" + add1(al)); // 승
	      System.out.println("LinkedList :" + add1(ll));
	      System.out.println();
	      
	      System.out.println("= 중간에 추가하기 =");
	      System.out.println("ArrayList :" + add2(al));
	      System.out.println("LinkedList :" + add2(ll)); // 승
	      System.out.println();
	
	      System.out.println("= 앞에서부터 삭제하기(비순차) =");
	      // => 0~10000까지만 삭제
	      System.out.println("ArrayList :" + remove2(al));
	      System.out.println("LinkedList :" + remove2(ll)); //승
	      System.out.println();
	      
	      System.out.println("= 뒤에서부터 삭제하기(순차) =");
	      // => 뒤에서부터 0까지 모두 삭제: remove2를 먼저 실행해야함
	      System.out.println("ArrayList :" + remove1(al)); // 승
	      System.out.println("LinkedList :" + remove1(ll));
	      System.out.println("** Program Stop **");
	      System.out.println();
	} //main
} //class
