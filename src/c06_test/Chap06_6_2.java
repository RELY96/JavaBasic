package c06_test;

//** 정석기초 연습문제 6_2
//=> 다음과 같은 실행결과를 얻도록 Student 클래스에 생성자와 info() 메서드 를 추가하시오.
// info() 메서드 : toString 메서드 참고
//=> ("홍길동",1,1,100,60,76) -> 이름, 반, 번호, java점수, html점수, js점수

// +합계, 평균 출력 : 출력문에 그대로 계산 넣으면 됨

public class Chap06_6_2 {

	public static void main(String[] args) {
		Student s = new Student("홍길동", 1, 1, 100, 60, 76); // Student 클래스 인스턴스 생성 => Student class 안에 생성자 생성 가능

		String str = s.info();
		System.out.println(str); // 변수가 갖는 값을 보기좋게 출력하려고 toString 사용

		System.out.println("** toString Test : \n" + s); // toString 이 없으면 주소 출력

		// ----------------------------------------------//

		Student s2 = new Student("김길동", 1, 2, 100, 60, 76); //새 인스턴스 생성

		System.out.println(""+s2); //주소값 출력
		
		//=================================//
		
		// ** 반 별 통계뽑기 => 배열 적용하면 편함 
		// 배열 정의
		Student []ss= {s,s2,new Student("박길동",1,4,100,60,76)}; //s는 Student 타입이라고 볼 수 있음(★모든 클래스는 타입이 될수 있음!)
        // 배열 정의할 때 바로 new해서 새 인스턴스 생성할수도 있음, But, direct로 생성한 인스턴스는 이름이 없음(Ram에 메모리 저장된 구조는 s,s2이랑 똑같음)
		
		int jTotal=0, hTotal=0, jsTotal=0; //합계 구하려고!
		for (int i=0; i<ss.length; i++) {
			// 1) 모든 학생의 과목별 합계 출력하기
			jTotal += ss[i].javaScore;   //s에 접근하려면, s는 ss[]의 i번째니까 ss[i]. 하면 s안에 맴버들에 다 접근 가능
			hTotal += ss[i].htmlScore;
			jsTotal += ss[i].jsScore;
		}
		System.out.println("** 자바 토탈 : "+jTotal);
		System.out.println("** html 토탈 : "+hTotal);
		System.out.println("** js 토탈 : "+jsTotal);
		
	} // main

} // class

class Student { // 생성자와 info 추가
	// 1) 맴버변수 정의
	String name;
	int classNum;
	int number;
	int javaScore;
	int htmlScore;
	int jsScore;

	// 2) 매서드 정의(변수를 초기화하는 생성자)

	Student(String s, int a, int b, int c, int d, int e) { // 이 매개변수 안 지역변수명은 초기화하려는 변수명이랑 똑같이 하는게 더 좋음
		this.name = s;
		this.classNum = a;
		this.number = b;
		this.javaScore = c;
		this.htmlScore = d;
		this.jsScore = e;
	}

	// 3) 출력 매서드 info() 만들기(String타입 리턴) info매서드 : 개인정보와 합계, 평균 출력되는 매서드
	public String info() {
		return "이름 : " + name + "\n반 : " + classNum + "\n번호 : " + number + "\nJAVA점수 : " + javaScore + "\nhtml점수 : "
				+ htmlScore + "\n" + "js점수 : " + jsScore + "\n합계 : " + (javaScore + htmlScore + jsScore) + "\n평균 : "
				+ (float) ((javaScore + htmlScore + jsScore) / 3) + "";
	}

} // Student class
