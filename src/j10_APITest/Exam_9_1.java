package j10_APITest;

public class Exam_9_1 {

	public static void main(String[] args) {
		Value v1= new Value(10); // 매개변수 int 에 10 넣어서 맴버 value 초기화
		Value v2= new Value(10); // 두번 생성되서 생성될때마다 주소값이 다름
		
		if (v1.equals(v2)) System.out.println("같습니다"); // equals 오버라이딩으로 매개변수 '값'오버라이딩 안해줌 -> 주소값 출력 => 다름!!
		else System.out.println("다릅니다");
	} //main
} //class

class Value {
	int value;
	
	Value(int value) { //초기화용 생성자
		this.value=value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Value)) return false; 

		Value v = (Value)obj; // 2.
		return this.value == v.value; //3. boolean 값이니까 ==로 true, false 확인!

		// 1) 참조변수 형변환 전에는 반드시 instanceOf 로 확인 후 형변환 (obj가 Value에 들어가는 경우에만 형변환 하도록)
		// 2) obj타입이 타입 Value와 다르기 때문에 오버라이딩 안하면 다른 값(주소)이 나올 수밖에!
		
		// equals 매서드 오버라이딩 =>
		// 1. instanceOf로 형변환 가능한지 확인
		// 2. Value 타입으로 obj를 형변환 해서 주소 맞게 맞춰주기
		// 3. 변환한 obj를 value에 넣어줌 -> 그럼, equals 비교 시 true가 나옴!
	}
} //Value 클래스

//equals 오버라이딩------------------------------//

