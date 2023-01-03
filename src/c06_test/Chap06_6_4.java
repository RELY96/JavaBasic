package c06_test;

// 두 점의 거리를 계산(좌표 필요(숫자 네개[x1,y1]~[x2,y2]))하는 getDistance()를 완성하시오.
// 제곱근 계산은 Math.sqrt(double a)를 사용하면 된다.

//★두 점의 거리를 계산하는 공식 : (x의 차이제곱)+(y값의 차이제곱)의 제곱근(루트) = 두 점의 거리

// (Math.pow(double a, double b) -> 제곱값을 return)

public class Chap06_6_4 {
	
	public static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
		// sqrt안에 (x의 차이제곱)+(y값의 차이제곱) 넣으면 sqrt가 루트 씌운 값 리턴
		
		// Math.pow() 호출하는 것보다 연산식으로 처리하는것이 더 효율적임
	} //getDistance

	public static void main(String[] args) {
		System.out.println("** 두 지점 간 거리 : "+getDistance(10,5,20,5)); // [x1,y1]~[x2,y2]
		System.out.println("** 두 지점 간 거리 : "+getDistance(10,5,20,15)); // 사선으로 되어 있는
	} //main

} //class
