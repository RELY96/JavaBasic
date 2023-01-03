package c06_test;

// 6-6번 문제
// 두 점의 거리를 계산(좌표 필요(숫자 네개[x1,y1]~[x2,y2]))하는 getDistance()를 완성하시오.
// 제곱근 계산은 Math.sqrt(double a)를 사용하면 된다
//★두 점의 거리를 계산하는 공식 : (x의 차이제곱)+(y값의 차이제곱)의 제곱근(루트) = 두 점의 거리

// 1.(Math.pow(double a, double b) -> 제곱값을 return)
// 2.(Math.sqrt(double a) -> 제곱근 return)

// 작성한 클래스매서드를 Mypoint 클래스의 getDistance() 인스턴스 매서드로 정의하시오.
// (조건)기준위치는 맴버변수로 정의하고 생성자의 매개변수로 전달 받아 초기화


public class Chap06_6_4_02 {
	public static void main(String[] args) {
		Mypoint point = new Mypoint(0,0);
		System.out.println(point.getDistance(20,20));
	} //main
} //class

class Mypoint { // Chap06_6_4_02 클래스 안에 들어가도 빨간불 안뜨는 이유 : inner class(주의!)
	// 파일 주인 class가 아니기 때문에 public 불가!
	// Mypoint 클래스가 컴파일 되어 bin파일로 따로 생겨나게 됨(.java 같은 파일 안에서는 소스코드만 공유하고, 독립적인 클래스로 컴파일 됨)
	int x1;
	int y1;
	
	Mypoint () {
		//★default 생성자 : 다른 생성자를 만들어줄 때는 기본생성자를 기본으로 하나 만들어주는게 좋음
	}

	Mypoint(int x1, int y1) { //생성자 앞에는 리턴값이 아닌 접근제어자만 옴
		this.x1=x1;
		this.y1=y1;
	} //생성자 초기화
	
	public double getDistance(int x2, int y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
	} //getDistance
} //Mypoint class