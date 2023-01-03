package j13_Collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

// set 이용해서 Lotto 간단하게 중복처리하기

//** HashSet 을 이용한 로또번호 생성하기
//=> 중복자료가 허용안되는 Set 의 특징을 이용하여 로또 번호 생성하기
//=> Random 또는 Math 로 1 ~ 45 범위내의 정수를 중복되지 않도록 
// 6개를 추출후 출력하기
//=> 오름차순으로 출력하기  

public class Ex05_SetLotto {

	public static void main(String[] args) {
		// 1. 이전 Lotto 배열 정의 대신 set 정의
		// => Random 또는 Math 로 1 ~ 45 범위 내의 정수가 6개 채워지도록(size로 확인)
		// 제너릭은 기본자료형 int,char 등 담을 수 없음, 객체만 담을 수 있음: Integer 등 / But, 123 등을 그냥 담으면 오토박싱되서 들어갈 수 있는 것 
		// 1-1) set정의
		HashSet<Integer> set = new HashSet<Integer>();
		
//----------------------------------------------------------------------------------------------------------------//

		// 2. 번호생성
		Random rn = new Random();
		
		while(set.size() < 6) {
			set.add(rn.nextInt(45)+1);
		} //while => 사이즈가 아무것도 없는 0부터 시작하기 때문에, 1개 만들고 나면 1이 됨 / <6 까지 해야 6번 돌아서 사이즈 6이 나옴

//----------------------------------------------------------------------------------------------------------------//		
		
		// 3. 출력
		System.out.println("* set 로또번호: "+set);
		System.out.println("* set 사이즈: "+set.size());
		
//----------------------------------------------------------------------------------------------------------------//		
		
		// 4. 오름차순 출력 (배열같은 경우 Arrays.sort로 가능함 => set을 배열로 만들어주면 sort로 출력 가능해짐!)
		// 4.1. Arrays 로 변환
		Object[] oset = set.toArray(); // set을 배열화해서 오브젝트 타입의 배열 oset에 할당
		// 4.2. 오름차순 정렬 매서드 sort
		Arrays.sort(oset);
//----------------------------------------------------------------------------------------------------------------//
		System.out.println("* 오름차순 Lotto: "+Arrays.toString(oset));
		System.out.println("* set은 원본 그대로 유지(배열 oset이 아니라): "+set);
		
//----------------------------------------------------------------------------------------------------------------//
		// 4.2. Collections (collection 타입의 Wrapper 클래스) : Collection 과 관련된 편리한 메서드를 제공
	    // * interface Collection 과 구별
	    // * interface Collector 의 구현클래스 Collectors 와 구별
		
	    // 형식 > Collections.sort(List<T> list(매개변수로 List 타입이 필요)) : 

	    // ** 오름차순 출력
	    // => Set -> 순차구조 (Iterator , List)
	    // => Set -> List(★얘 사용!★)
	    //    LinkedList 의 생성자 중에 set을 매개변수로 사용하면 이 set 을 list 생성해주는 생성자가 있음!
		
		List<Integer> list = new LinkedList<Integer>(set); // Integer만 들어갈 LinkedList정의 (생성자 인자로 set 넣어줘서 set list 생성!)
		// Collections 매서드 이용한 list 정렬
		Collections.sort(list);
		System.out.println("* Collections.sort: "+list);
		
//----------------------------------------------------------------------------------------------------------------//		
	} //main
} //class
