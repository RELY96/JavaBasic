package j08_AbsInterface;

// 멀티 인터페이스 테스트(다중상속, 인터페이스 끼리 상속)

//** interface 2.
//1) 인터페이스와 인터페이스 관계
//=> 인터페이스 간의 상속(extends) 가능.
//=> 다중상속(부모 여러개 허용), 계층적 상속 모두 가능 

//2) 클래스 와 인터페이스 관계
//=> 다중 구현(implements) 가능
//=> 클래스가 클래스를 상속(extends) 받으면서 동시에 인터페이스를 구현(implements, 다중구현도 포함) 하는것 가능 
//** 그러므로 자바는 다중상속이 안되는점을 극복 가능

interface Inter1 {
	float PI=3.1415f; //public static final 생략
	
	int getA(); //추상매서드, public abstract 생략
}

interface Inter2 {
	int getB(); //추상매서드, public abstract 생략
}

interface Inter3 extends Inter1, Inter2{ // 인터페이스 끼리 다중상속받고 있는 인터페이스 ->getA,getB 매서드 다 같고 있음
	float getC(); //추상매서드, public abstract 생략 (조상 인터페이스+내꺼 C)
} //PI,geta,b,c

//인터페이스 다중 구현 ==============================================//

// class MultiInter implements Inter1,Inter2,Inter3 { /*인터페이스 "다중"구현하는 클래스*/ }
// * But, 위도 되지만, inter3이  inter1,2 다 상속받아서 implements는 Inter3 만 해줘도 됨 ↓
class MultiInter implements Inter3 {
	
	int a=123; int b=100; //class에서 구현할 용도로 설정한 변수값
	
	
	@Override
	public int getA() {return a;}
	@Override
	public int getB() {return b;}
	@Override
	public float getC() {return (a+b)*PI;}
} //inter3을 통해 다중구현한 MultiInter class

//클래스의 동시 상속(extends)+구현(implements) ======================//
class Add {
	int addNum(int a, int b) {return a+b;}
} //Add

class MultiExtIm extends Add implements Inter3 { //상속도 받고, 동시에 인터페이스 구현도 하는 클래스 (extends, interface 순서 변경 안됨)
	
	int a=80; int b=120;
	//MultiExtIm 은 MultiInter와 아무관계도 아니니까 int 전역변수 설정 따로 해준거임
	
	@Override
	public int getA() {return a;}
	@Override
	public int getB() {return b;}
	@Override
	public float getC() {return /*상속도 받아서 (a+b)를 addNum 매서드로 변경*/addNum(a,b)*PI;}	
} //MultiExtIm

//=======================================================================================//

public class Ex03_MultiTest {

	public static void main(String[] args) {
		// Test1
		MultiInter m1 =new MultiInter(); // MultiInter 클래스 인스턴스 m1 생성
		System.out.printf("*m1 : getA=%d getB=%d getC=%f \n",m1.getA(),m1.getB(),m1.getC()); //m1 인스턴스 안에 interface123의 매서드들 호출가능
		
		//=============================================================//
		
		// => 다형성 적용해서 Test1-1☆
		Inter3 inter3 = new MultiInter();
		System.out.printf("*m1 : getA=%d getB=%d getC=%f \n",inter3.getA(),inter3.getB(),inter3.getC()); //Inter3범위까지 적용되서 OK!
		
		/*Inter3 클래스 교체(다형성)도 가능!*/ Inter3 inter3Change = new MultiExtIm();
		System.out.printf("*inter3Change : getA=%d getB=%d getC=%f \n",inter3Change.getA(),inter3Change.getB(),inter3Change.getC()); 
		
		
		Inter2 inter2 = new MultiInter(); // Inter2타입으로 생성 / Inter2 안에는 getB()만 있어서, getA, getC 는 접근불가
		Inter1 inter1 = new MultiInter(); // Inter1 안에는 getA()만 있어서, getB, getC 는 접근불가
		
		//=============================================================//
		
		// Test2
		MultiExtIm m2 = new MultiExtIm();
		System.out.printf("*m2 : getA=%d getB=%d getC=%f \n",m2.getA(),m2.getB(),m2.getC()); //m2 도 m1처럼 interface123의 매서드들 호출 가능
		
		//=============================================================//

		// Test3 :instanceof 적용해서 다형성 Test : m1,m2 다 inter3을 통해 1,2를 상속받고, 구현하고 있으므로 다 속해있다 true 나옴
		if(m1 instanceof Inter1 ) System.out.println("m1은 Inter1 입니다(구현하고 있습니다)");
		else System.out.println("m1은 Inter1 이 아닙니다");

		//------------------------------------------------------------//
		
		if(m1 instanceof Inter2 ) System.out.println("m1은 Inter2 입니다(구현하고 있습니다)");
		else System.out.println("m1은 Inter2 이 아닙니다");
		if(m1 instanceof Inter3 ) System.out.println("m1은 Inter3 입니다(구현하고 있습니다)");
		else System.out.println("m1은 Inter3 이 아닙니다");
		
		//------------------------------------------------------------//
		
		if(m2 instanceof Inter1 ) System.out.println("m2은 Inter1 입니다(구현하고 있습니다)");
		else System.out.println("m2은 Inter1 이 아닙니다");

		//==============Interface와 무관한 add클래스 Test===(instanceof 로 확인)====//
		/* 비교대상이 interface인 경우에는 컴파일 오류 안남! -> 그래서 instanceof로 확인이 필요한 것*/
		Add add = new Add();
		
		if( add instanceof Inter3 ) System.out.println("add은 Inter3 입니다(구현하고 있습니다)");
		else System.out.println("add은 Inter3 이 아닙니다"); //false가 나와야 하는데 컴파일 오류는 안남
		/*Inter3 add2 = new Add(); -> 오류!*/
		
		//------------------------------------------------------------//
		
		//Add를 상속하는 m2 비교(클래스-클래스 간)-----------------------------------------//
		if ( m2 instanceof Add ) System.out.println("m2은 Add의 인스턴스 입니다");
		else System.out.println("m2은 Add의 인스턴스가 아닙니다");
		
		//Add과 무관한 m1 비교(클래스-클래스 간)-----------------------------------------//
		//if ( m1 instanceof Add ) System.out.println("m1은 Add의 인스턴스 입니다"); //인터페이스가 아닌, 클래스-클래스간 instanceof는 컴파일 오류 뜸!
		//else System.out.println("m1은 Add의 인스턴스가 아닙니다");
		
		
		
		
		
	} //main

} //class
