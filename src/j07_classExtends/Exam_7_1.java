package j07_classExtends;

// 조상 클래스 TV와 자손 클래스 smartTV 만들기
// 1. 자손 클래스 생성하면 조상클래스도 생성됨
// 2. 자손 클래스는 조상클래스의 맴버를 다 쓸 수 있다(생성자, 초기화용 제외)
// 3. main에서 실행시, 자손클래스.을 통해 조상클래스의 맴버들을 할당하거나 사용할 수 있다

class Tv {
	boolean power; //맴버변수 power true,false
	int channel; //채널 번호

	void power() { //power매서드(on/off전환)
		power = !power;
	}

	void channelUp() {
		++channel;
	}

	void channelDown() {
		--channel;
	}
}

class SmartTv extends Tv { //그냥 Tv기능에 SmartTv 기능 추가(자막)
	boolean caption; //캡션(자막)상태 on/off
	
	void displayCaption(String text) { //자막 추가 기능 매서드
		if(caption) { 
			System.out.println(text); //caption이 true(on) -> "text" String 출력문 리턴
		}
	}

}

public class Exam_7_1 {
	//실행

	public static void main(String[] args) {

		SmartTv stv= new SmartTv(); // 스마트티비 인스턴스 생성 시, 조상 인스턴스도 자동으로 생성
		stv.channel=10; //stv.만 해도 해당 클래스와 조상클래스의 맴버들이 나옴!
		stv.channelUp(); //channelUp
		System.out.println(stv.channel); //chnnel번호 출력

		stv.displayCaption("Hello, world"); //caption true,on하기 전이라 ""뜨지 않음
		
		stv.caption=true; // 자막 on
		stv.displayCaption("Hello,world");
		
	} // main

} // class
