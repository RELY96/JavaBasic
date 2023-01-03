package j08_AbsInterface;

// 형변환 목적 : 다룰 수 있는 맴버 갯수 조절
// 형변환 유의사항 : 실제 객체(생성된 인스턴스,번짓수)가 뭔지/null값은 아닌지 

class Car {
	String color;
	int door;

	void drive() { // 운전하는 기능
		System.out.println("drive, Brrrr~");
	}

	void stop() { // 멈추는 기능
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car { // 소방차
	void water() { // 물을 뿌리는 기능
		System.out.println("water!!!");
	}
}

public class Exam_7_7 {

	public static void main(String[] args) {
		Car car = null; // 1.Car타입 car라는 저장공간(null,비어있음 생성)
		FireEngine fe = new FireEngine(); //2. FireEngine클래스 인스턴스 fe생성 -> 부모를 포함한 저장공간 갖음
		
		FireEngine fe2 = null; //4. fe2라는 FireEngine 타입 저장공간을 새로 생성, 하지만 null로 비어있음
		
		fe.water(); //*fe에 속한 water 호출 가능
		
		car = fe; //3. Car car = new FireEngine(); 랑 같은거임! 그 말은, null로 비어있던 car공간이 fe와 같은 주소를 같게됨
		//+car는 Car 타입이었기 때문에 fe와 같은 공간을 갖지만 범위는 Car까지라서 car.water()는 불가 => 이 경우, '자동형변환'인거임(지금까지 조상타입=자손생성이 다 자동 형변환(up))
		
		// fe2 = car; //5. Car car(저장번지 fe와 같음) 는 FireEngine fe2 = Car car 와 같음! 
		// +후손타입 = 조상생성 은 불가하므로 형변환 해서 맴버의 갯수를 늘려줘야 water까지 쓸 수 있음.
		// => 그래서 car를 FireEngine로 강제 형변환 해주기
		
		fe2 = (FireEngine)car; //6. fe2의 저장공간이 car,fe와 같아졌고,FireEngine 타입이라 5개 다 접근가능
		
		fe.water();// 이제 fe2.water()사용 가능 /*car.water()는 사용불가*/
		
		//===정리=============//
		/*셋 다 같은 주소번지를 갖고 있지만, 타입이 달라서 water쓸 수 있냐 여부가 다름 -> 형변환을 해주는 이유 : 사용하는 맴버 갯수를 조정하기 위해!*/
		/*fe.water 가능 FireEngine 타입*/
		/*car.water 불가 Car 타입(으로 fe를 형변환 해준 꼴)*/
		/*fe2.water 가능 FireEngine타입(으로 형변환 해준거)*/

	} // main

} // class
