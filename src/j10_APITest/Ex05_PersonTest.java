package j10_APITest;

public class Ex05_PersonTest {

	public static void main(String[] args) {
		Ex05_Person person = new Ex05_Person("960624-2018472", "엄희정");

//-----------------------------------------------------------------------//
		person.infoPrint();

		System.out.println("person toString" + person); // toString 출력

//=======================================================================//
		System.out.println("==========================================");
		// ** Person Type 의 배열에 5명을 채우고, age가 많은 순서로 출력하기 : age순 descending 내림차순

		// 1. person type 배열 정의 / 2. 5명으로 초기화
		Ex05_Person person2[] = { new Ex05_Person("960624-2018472", "엄희정"), new Ex05_Person("080624-3019287", "김길동"),
				new Ex05_Person("200624-4019287", "홍길동"), new Ex05_Person("940624-1019287", "엄정환"),
				new Ex05_Person("670724-2019287", "김희정") };

//-----------------------------------------------------------------------//

		// 3. 정렬(내림차순) > ★static 매서드로 만들고 main에서 출력하는 방법도 있음 '매서드 형식 > static void pSort(Ex05_Person[] ars){내림차순 알고리즘(ars.length;)}'★
		for (int i = 0; i < person2.length; i++) {
			for (int j = i + 1; j < person2.length; j++) {
				if (person2[i].getAge() < person2[j].getAge()) { //i자리 의 다음 것부터 비교 (get을 통해 볼 수 있으니까 getAge() 꼭 붙여줘야!)
					Ex05_Person tmp = person2[i]; // 타입을 Ex05_Person 로 할 것 (person2[]를 담는 tmp니까!)
					person2[i] = person2[j]; // 맞바꾸는 건 전체 주소 new Person[i] , [j]임
					person2[j] = tmp;
				} // if
			} // for_j
			// 4. 출력
			person2[i].infoPrint();
		} // for_i
		
//each for문--------------------------------------------------------------//
		System.out.println("==========================================");
		
		for(Ex05_Person p : person2) {
			p.infoPrint(); // 내림차순 정렬 후 차례대로 밖에서 출력되게 each for문으로 할 수 있음
		}
	} // main
} // class
