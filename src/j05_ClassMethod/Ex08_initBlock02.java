package j05_ClassMethod;

import java.util.Arrays;

// 15번 예제
// 배열 arr초기화 : 1~10 사이의 임의의 수를 저장(Math.random())이용

//** 수행순서
//=> 프로그램 로딩-> 클래스초기화블럭 -> main 메서드실행 -> 인스턴스 생성 (new) -> 인스턴스초기화 블럭 -> 생성자 실행
//그러므로 인스턴스 초기화 블럭은 인스턴스 생성시마다 실행 됨 

public class Ex08_initBlock02 {
	static int[] arr = new int[10]; // 배열
	String color;
	double num;

	{
		color = "white";
		num = (Math.random() * 10 + 1);
	}

	static {
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random()*10+1);			
		} //for

	} // static 초기화 블럭

	public static void main(String[] args) {
		System.out.println("** main start **"); // <실행1>

		// 1) main 실행하면 바로 static 블럭 실행됨(다 계산 해놓고)
		System.out.println("arr : " + Arrays.toString(arr));
		//static블럭 계산값을 sysout으로 print했으니까 main start 뒤에 보이는 것 <실행2>

		Ex08_initBlock02 test1 = new Ex08_initBlock02(); // 인스턴스 생성 -> 인스턴스 블록 실행
		System.out.println("main color1 : " + test1.color); //실행<3>
		System.out.println("main num1 : " + test1.num);
		// 인스턴스 블록은 인스턴스가 생성될 때마다 실행됨(실행된 상태), 그 후 sysoutprint로 출력되어 보이는 거임
		
		
	} // main

} // class
