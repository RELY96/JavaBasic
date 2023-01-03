package j01_basic;

//** 이클립스 단축키 
//자동 import : Ctrl+Shift+O
//Line삭제 : Ctrl + d

//들여쓰기 : Ctrl+A , Ctrl+I 
//=> 한번에 Ctrl+Shift+F

//클래스 Ctrl+클릭 => 클래스 소스보기 
//클래스 Ctrl+T => 클래스 계층도 

//** 클래스 
//=> 클래스명은 파일명과 동일해야함, 파일명 확장자는 반드시 java, 클래스명은 반드시 대문자시작
//=> 맴버(클래스 안에 포함된 애들(시작부터 종료까지))
// 변수:value,(멤버 변수) : 속성
// 메서드 (함수 function , 프로시져 procedure) : 동작(js의 함수와 비슷) (멤버 매서드)
// 변수는 속성, 메서드는 동작

//** 문장(Statement)
//=> 사용자가 컴퓨터에게 작업을 지시하는 단위
//=> 문장의 끝은 항상 세미콜론 (;)
//=> 선언문과 실행문(메소드 안에 작성)
// 선언문은 클래스의 어디에나 올 수 있음, 실행문은 반드시 메서드 내부에만 올 수 있음

//** Java Coding
//=> 대.소 문자구별함

/* 주석(comment)의 종류
  => 한줄 주석 //
 => 여러줄 주석
*/

// 프로젝트 이름과 클래스는 반드시 대문자 시작

/** documentation
  => 선언문 (클래스 또는 메서드의 선언부_Header) 앞에만 사용가능하고 
     JDK에 포함된 javadoc 프로그램이 주석을 추출하여
     소스를 설명하는 HTML 문서를 만들어줌(설명문) 
  => 활용법은 아래 참고 
     https://johngrib.github.io/wiki/java/javadoc/     
*/

//1. java는 타입을 철저하게 따짐 -> println 은 "매개변수:string타입(but, 숫자가 문자뒤에 붙게 되면 문자처럼 취급됨)"
// 1-1) 숫자로 하고 싶으면 ()로 우선순위 설정해주기

public class Ex01_Hello {

	public static void main(String[] args) {
		System.out.println("** Hello Java !!!");
		System.out.println("** 안녕하세요 !!!");
		System.out.println("** 엄희정입니당 !!!");
		System.out.println(" 저는 27세 입니다 ");
// 1.
		System.out.println(" 합계 => "+100+200); //매개변수 타입
		System.out.println(" 합계 => "+(100+200));
	} //main

} //class

