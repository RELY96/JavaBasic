package j08_AbsInterface;

//** 캡슐화(Encapsulation) : 단위기능을 모듈화해서 캡슐속에 집어넣는 것 
//1. 은닉 (보호) : 접근 제어자를 이용
//=> 외부로부터 데이터를 보호하고, 내부적으로만 사용되는 부분은 감추어 준다 
//=> 접근 제어자 : private < default <  protected < public

//2. 단위 기능 모듈화
//=> 세분화 되어있는 모듈을 하나의 기능으로 처리할 수 있도록 묶어준다.
//=> 종합 감기약 처럼 
//=> 세분화 되어있는 모듈을 사용하면서 호출 순서에 따른 오류 등
// 발생가능한 논리적 오류를 예방하고, 생산성 및 유지보수 에 유리 

//-------------------------------------------------------//

//** 실습
// - 감기 증상 : 두통, 콧물, 몸살

class HeadacheCap {
	void take() {
		System.out.println("** 두통 해결 **");
	} // 증상 잡기
} // HeadacheCap

class SinivelCap { 
	void take() {
		System.out.println("** 콧물 해결 **");
	}
} // SinivelCap

class BodyPainCap { 
	void take() {
		System.out.println("** 몸살 해결 **");
	}
} // BodyPainCap

//----------------캡슐화가 안 되어있는 경우--------------------//
// ** 환자발생1. BadCase Encapsulation
// => 증상별 복용순서에 따라 복용
// => 세분화 되어있는 모듈을 직접 사용하는 경우

//======================================================//

class ColdPatient {
	void takeHead(HeadacheCap hcap) {hcap.take();}

	void takeSinivel(SinivelCap scap) {scap.take();}

	void takeBody(BodyPainCap bcap) {bcap.take();}
} // ColdPatient

//======================================================//
//----------------캡슐화 적용한 굿 케이스---------------------//
class TotalCap { //인스턴스를 클래스 안 맴버변수로 정의 가능 -> 정의해놓고 쓰기 가능
	HeadacheCap hcap = new HeadacheCap();
	SinivelCap scap = new SinivelCap();
	BodyPainCap bcap = new BodyPainCap();
	// 인스턴스의 전역변수 선언은 String name = "홍길동"; 와 같은 것
	
	// -> 복용순서대로 인스턴스를 미리 선언하고, 매서드를 미리 순서대로 작성해놓음(캡슐화)
	void take()
	{
		hcap.take();
		scap.take();
		bcap.take();
	} //take 매서드
} //TotalCap class

//----↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓----//

class NewPatient {
	void takeTotal(TotalCap tc/*TotalCap 변수 tc선언*/) {tc.take();/*tc의 take매서드 실행*/}
} // <- 순서대로 실행됨!

//======================================================//

public class Ex09_Encapsulation {

	public static void main(String[] args) {
// 환자발생1. BadCase Encapsulation
// => 인스턴스 생성 후 메서드 호출 : 단점 : 메서드 호출 순서 등 오류 발생 가능(순서대로가 아닌 제각각 호출->오류발생가능)
// => 컴파일오류, 런타임오류, 논리적오류(Logical Error) 의 확률이 높아짐    
		ColdPatient cp = new ColdPatient();
		cp.takeBody(new BodyPainCap());
		cp.takeHead(new HeadacheCap());
		cp.takeSinivel(new SinivelCap());
		
//======================================================//		
// 환자발생2. GoodCase Encapsulation
		
NewPatient np = new NewPatient();
np.takeTotal(new TotalCap()); // -> 실행하면 순서대로 실행됨		
// 모듈화 : 단위기능으로 최소한으로 쪼개서 최소한의 기능을 작성
// 모듈화 시 순서를 지정해놓는 "캡슐화"를 하면 좋음!
	} // main
} // class
