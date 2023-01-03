package j09_innerClass;

//** Outer,Inner 인스턴스 관계 Test

class OuterName {
	private String name; /*얘가 InnerClass의 변수 name2와 이름이 같다면, 얘는 inner클래스 생성자 초기화를 통해 해당변수값 전달불가*/
	private int num=0;
	
	OuterName(String name) { //매개변수 "OUT1" 전달, 매개변수 "OUT2" 전달
		this.name=name;
		System.out.println("** OuterName 초기화 생성자 **");
		}
	
	/*Outer의 매서드*/void whoAreU (){
		num++;
		System.out.printf("** whoAreU : name=%s, num=%d \n",name,num);
	}
	class InName {
		String name2;
		
		InName(String name2) {
			this.name2=name2;
			name=name2; //inner의 name2초기화 시켜주고, 그 초기화값 outer의 name에 넣어주기
			/*만약 Outer와 Inner에 동일한 이름의 맴버변수가 있다면? - this로 Outer에 전달할 수 X
			 * (this인스턴스가 inner가 되기 때문에, 전달받는 변수가 Inner 의 맴버변수가 됨)*/
			
			System.out.println("** InnerName 초기화 생성자 **");
			whoAreU(); //Inner 안에서 Outer매서드를 호출할 수 있음! -> inner 는 outer의 모든 맴버에 접근 가능해서
			} // Inner 초기화 생성자
	} //InName class
} //OuterName class

//===================================================================//

public class Ex02_InstanceTest {

	public static void main(String[] args) {
		// 1) Outer 생성
		OuterName on1 = new OuterName("OUT1"); 
		OuterName on2 = new OuterName("OUT2"); 
		on1.whoAreU(); // OUT1, 1
		on2.whoAreU(); // OUT2, 1
		
//------------------------------------------------------------------//
		
		// 2) Inner 생성(Outer 인스턴스를 통해 생성 사용함)
		OuterName.InName in11 = on1.new InName("OUT1_In1");
	/* 한번에 생성하기 : OuterName.InName test = new OuterName("Test").new InName("test"); */
		
		OuterName.InName in12 = on1.new InName("OUT2_In2,out1에 inner 2번째 인스턴스"); //inner클래스 안에 outer의 매서드 호출있어서, 생성하면 호출도 됨!
		// outer인스턴스는 공유, inner인스턴스는 다른 주소 -> on1.whoAreU();를 부를 수록 inner인스턴스는 따로지만,
		// inner인스턴스 안에있는 outer매서드가 계속 실행되는 거라 num은 같은 주소로 카운팅 됨
		// +name은 마지막에 전달받은 애가 남음
		OuterName.InName in13 = on1.new InName("OUT2_In3,out1에 inner 3번째 인스턴스");
		on1.whoAreU(); // -> 총 1+4 = 5번 호출되서 num=5, name=OUT2_In3
		
//------------------------------------------------------------------//
		// ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ 둘이 같은 논리
		OuterName.InName in21 = on2.new InName("OUT2_In1");
		OuterName.InName in22 = on2.new InName("OUT2_In2");
		on2.whoAreU(); // -> 총 1+3 = 4번 호출, name=OUT2_In2
		
	} //main

} //class

//작업 중 일반클래스끼리만 작업하다보면, 클래스에 전달전달 되는 값이 끊어질 때가 있음 -> 그걸 위해 안에서 영향줄려고(일회성) innerclass 사용하는 경우 있음!
