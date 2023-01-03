package c07_test;

class Product {
	int price;
	int bonusPoint;
	
	Product(int price) {//초기화용 생성자
		this.price=price;
		bonusPoint=(int)(price/10.0);
	}
}

class Tv1 extends Product {
//	Tv1(){
//		//default 생성자
//	}
	
	Tv1(int price) { // 초기화용 생성자
		super(price);
	}
	
	public String toString() {
		return "Tv";
	}
}

public class Chap07_7_3 {

	public static void main(String[] args) {
		Tv1 t=new Tv1(5000);
		
		System.out.println("** 매개변수와 Tv1 초기화용 생성자 사용해서 super(price)를 초기화"+t);
		System.out.println("** 자손 인스턴스를 통해 조상의 맴버 호출"+t.price+t.bonusPoint);
	
	}//main

}//class
