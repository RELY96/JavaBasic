package j14_generic;

//** Generic Class Test 
//** FruitBox 만들기
//=> Apple, Banana 등 모든 과일을 담을수 있는 FruitBox class(FruitBox는 제너릭) 를 만들어 보세요.
//   (자율적으로 해보시면 됩니다)
// 1. 조건: 과일만 담을 수 있음 (과일이 객체(클래스))
// 2. 해당 과일클래스가 '과일' 인걸 구분할 수 있어야 함 -> 과일 클래스를 만들어서 과일클래스를 상속

class Fruit {
	@Override
	public String toString() {
		return "I am Fruit";
	}
} // Fruit

class Apple extends Fruit {
	@Override
	public String toString() {
		return "나는 사과";
	}
} // Apple

class Banana extends Fruit {
	@Override
	public String toString() {
		return "나는 바나나";
	}
} // Banana

class Orange extends Fruit {
	Orange() {
		System.out.println("나는 오렌지");
	}
	
	@Override
	public String toString() {
		return "나는"+color+"오렌지";
	}
//---------------------------------------------//
	private String color;
	Orange(String color){
		this.color=color;
	} // 여러 오렌지 클래스 생성자
} // Orange

class Tomato {
	public String toString() {return "나는 토마토";}
} // Tomato

//=======================================================================//
// 과일들만 담을 수 있는 FruitBox 만들기
// => Generic으로 Fruit 의 후손들만 담을 수 있는 배열 만들기 -> <>제너릭에서 타입을 제한하라
// + set,print 출력

class FruitBox<T extends Fruit> { //프룻 후손만 들어갈 수 있게 만듦(Box니까 제네릭을 배열 형태로 만듦!)
	private T[] farr;   //제너릭 타입 배열 정의(farr에 클래스 과일들을 담을 것)
	
	public void setFarr(T[] farr) {
		this.farr=farr;
	} //setFarr
	
	public void fruitPrint() {
		for(T f/*T타입 f에 넣어주기*/:farr/*farr배열에서 과일들 꺼내서*/) {
			// T는 fruit포함 fruit의 후손들만 올 수 있음(앞에서 <제한>해줘서!)
			
			System.out.println(f); // 넣어준 과일들 배열 따라 꺼내기 -> Apple의 toString 출력	
		} //for
	} //print()

} // FruitBox

//=================================================================//

public class Ex03_GenFruitBox {

	public static void main(String[] args) {
		System.out.println("** FruitBox 출력 **");
		FruitBox<Fruit /*과일들만 다 들어가게 하려면 제너릭을 Fruit로 정의*/> f1 = new FruitBox<>();
		
		Fruit[] fa = {new Apple(), new Banana(), new Orange(), new Fruit()}; //Fruit타입의 배열 다른 fruit클래스들 넣어주기(fruit포함), tomato는 제한되서 못 들어감!	
		f1.setFarr(fa); //f1에 fa배열 set해주기
		f1.fruitPrint();// 출력
		
//================================================================================================//
		System.out.println("** 오렌지만 배열 넣기 **");
		FruitBox<Orange> f2 = new FruitBox<>(); //오렌지만 담는 제너릭
		
		Orange[] oa = {new Orange("Red"), new Orange("Orange"), new Orange("Yellow")};	// 오렌지를 초기화용 생성자 이용해서 다른 색깔 인스턴스 배열 생성
		f2.setFarr(oa);
		f2.fruitPrint();
		
//================================================================================================//
		// Tomato 오류 확인
		/*FruitBox<Tomato> f3 = new FruitBox<>(); -> Fruit이랑 상관없는 Tomato는 <>에서 제외되서 들어갈 수 없음!*/
	} // main
} // class
