package j10_APITest;

// equals 오버라이딩 해서 값만 추출 /  equals 를 주소가 아닌 값을 비교하는 매서드로 오버라이딩 한 것 => 같다 고 나오게!

class Person {
	long id;
	
	Person(long id) { //초기화용 생성자
		this.id=id;
	}
	
	public boolean equals(Object obj) {
		// 1. instanceof 로 obj가 Person에 속해 있다면 형변환 -> value값 넣어주고 return
		if (obj instanceof Person) {
			Person per = (Person)obj;
			return id == per.id;
			// return id == ((Person) obj).id; -> 이렇게 per 형변환 안하고 바로 해도 됨!
		} 
		// 2. else 면 false return
		else return false;
	} //equals 오버라이딩
} // Person

public class Exam_9_2 {

	public static void main(String[] args) {
		Person p1 = new Person(80110811111222l); 
		Person p2 = new Person(80110811111222l);
		
		if(p1.equals(p2)) System.out.println("같습니다");
		else System.out.println("다릅니다");
	} //main

} //class
