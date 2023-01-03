package j06_packageTest;

import j05_ClassMethod.Ex10_Phone; //import 자동으로

//** Access Modifier (접근한정자_제어자)
// 1) private : 해당 클래스내부 에서만
// 2) default : 같은 Package 내
// 3) protected : package + 자손
// 4) public : 프로젝트내의 모든 Class 접근 가능
// ★  단, 다른 package 에서는 import 해야함!

public class Ex01_accessTest {

	public static void main(String[] args) {
		// 1) public import Test
		System.out.println("** Phone.first : " + Ex10_Phone.getFirst());
		// -> 다른 패키지 public연결하면 import자동으로 됨
		System.out.println("** Phone.first : " + j05_ClassMethod.Ex10_Phone.getFirst());
		// -> import없이 하려면 이렇게 직접 패키지명 넣어야
		
		// ** public 클래스 안 맴버수준 접근범위 : private, default는 접근 불가
		// * public 클래스 안 private 맴버는 접근불가 -> set get 매서드 사용해서 접근해야 함
		
		Ex10_Phone ex10 = new Ex10_Phone(); //public class 인스턴스 생성
		// System.out.println("ex10.first : "+ex10.first);
		//first가 private or default 일때, 바로 접근 오류!
		
		//만약, Ex10_Phone class 안 "기본"생성자가 public이 아니고 default라면 Ex10_Phone class 인스턴스 생성 불가 

//--------------------------------------------------------//

		// 2) default import Test
//		Member member = new Member();
		// -> default는 다른 패키지는 X니까 import 안됨
		// -> class수준에서 허용이 안되기 때문에, 해당 클래스 내 맴버 수준에 public이 있다해도 불러올 수 X

	} // main

} // class
