package j08_AbsInterface;

// 다형성 매개변수 활용 예제(7-8)
// 1. 목적 : 제품팔기, 제품 팔 때 계산&포인트 적립 같이 2. 유의 : 제품 마다 각각의 가격과 포인트가 다름 But, 기능 1개로 만들고 제품에 맞춰서 적용되도록 해주기
// 3. 소비자(buyer)의 상태도 고려하기

// 클래스 : 상품(가격, 포인트가 존재(값은 자손에 의해 결정)) , Tv, Computer class(상품 클래스를 상속하고, 각 가격과 포인트가 다 다르니 얘네는 각각 주기), 사는사람 클래스(소지금, 남은 포인트)
// 구현 : 매서드(각 클래스 상품들의 가격과 포인트를 고려하여, 제품에 맞게 buyer의 구매를 계산해주는 매서드)(Buyer class에 만들었다가 main에서 실행)

//**1. 클래스 만들기**//
class Product {
	int price;
	int bonusPoint;

	Product(int price) { // 생성자로 각 물건별 price, bonuspoint 알맞게 초기화 해주기
		this.price = price;
		bonusPoint = (int) (price / 10.0); // 매개변수 price를 이용한 보너스포인트 계산
	}
}

//----------------------------------------------//

class Tv1 extends Product {
	Tv1() { // Tv default 생성자를 통한 조상클래스의 가격 price 100만원
		super(100);
	}

	public String toString() {
		return "Tv";
	}
}

//----------------------------------------------//

class Computer extends Product {
	Computer() { // Tv default 생성자를 통한 조상클래스의 가격 price 100만원
		super(200);
	}

	public String toString() {
		return "Computer";
	}
}

//----------------------------------------------//

//**2. buyer 매서드 만들기**//
class Buyer {
	int money = 1000; // 사는 사람 기본 money 1000만원으로 초기화
	int bonusPoint = 0; // 기본 보너스포인트 0
	
	Product[] cart = new Product[10]; //cart 저장할 product를 배열공간으로 설정
	
	void buy(Product p) { //Product 타입의 p를 매개변수로 설정(매개변수에 tv,computer 올 수 O)
		if(money < p.price) {
			System.out.println("잔액부족");
			return;
		}
		money-=p.price;
		bonusPoint+=p.bonusPoint;
		System.out.println(p+"를 구입하셨습니다");
		
		cart[i++]=p; // 구입한 물품 목록을 하나씩, 배열로 cart에 저장
	}
}
public class Exam_7_8 {

	public static void main(String[] args) {
		// **3. 구현(매개변수에 다양한 자손 활용)**//
		Buyer b =new Buyer(); //Buyer 인스턴스 소환
		
		// buy매서드 작동
		b.buy(new Tv1()); //매개변수에 자손 클래스 주소 넣기
		b.buy(new Computer());
		
		System.out.printf("현재 남은 돈은 %d만원 이고, 남은 포인트는 %d점입니다", b.money, b.bonusPoint);
	}
}
