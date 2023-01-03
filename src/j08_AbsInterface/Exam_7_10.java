package j08_AbsInterface;

abstract class Unit { //조상 추상 클래스
	int x,y;
	abstract void move (int x, int y); //추상 매서드 : 모든 후손의 이 갖고 있으면서, 각 후손마다 각자의 특징을 지니면서 실행되야 하니까(오버라이딩)
	void stop() {/*현재 위치에 정지*/}
}

class Marine extends Unit {
	
	@Override
	void move (int x, int y) {
		System.out.printf("Marine x : %d , y : %d", x,y);
	}
	void stimPack (){/*마린 만의 기능*/}
}

class Tank extends Unit {
	
	@Override
	void move (int x, int y) {
		System.out.printf("Tank x : %d , y : %d", x,y);
	}
	void changeMode (){/*탱크만의 기능*/}
	
}

class Dropship extends Unit {
	
	@Override
	void move (int x, int y) {
		System.out.printf("Dropship x : %d , y : %d", x,y);
	}
	void load (){/*드롭쉽만의 기능*/}
	void unload (){/*드롭쉽만의 기능*/}
	
}

public class Exam_7_10 {

	public static void main(String[] args) {
		// Unit 클래스의 자손들을 배열로 만들어서 다 실행해보기
		// Unit []group = new Unit[3]; //배열 인스턴스 생성(명시적)
		
		Unit []group = {new Marine(), new Tank(), new Dropship()}; // 묵시적 배열 생성(배열 안에 후손들 인스턴스 생성한 것)
		
		for (int i=0; i<group.length; i++) {
			group[i].move(100, 200); // group[i]해당되는 배열에 맞춰서 move 매서드(매개변수 int) 실행됨
		}
	} //main

} //class
