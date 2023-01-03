package z_extra;

// https://blog.naver.com/tahiti8505/222782990975
// 부모 클래스 - Card, 자손 클래스 - CreditCard, BusCard

class Card {
	String name; // 사용자
	int money; // 사용한 누적금액
	int limit; // 제한금액
	boolean flag; // 제한금액 여부
	
// 1. Card 제한금액 X -> String name 생성자
// 1)pay 입력 시, 제한 X -> money+=money; 로 값 누적해주고 사용금액 SYSOUT	
	
// 2. Card 제한금액 O -> String name, int limit 생성자 + 초기회 시 flag값은 true로
// 1) void pay(int money) 입력 시, 제한 있으면서 넘으면 결제불가하게 alert() 띄우고 매서드 종료
// 3. toString으로 사용금액과 제한금액 띄워주기	
	
	Card () {
	} // 기본 생성자
	
	Card (String name) {
		this(name,0);
		flag=false; //제한금액 없음
	} //초기화용 생성자
	
	Card (String name, int limit) {
		this.name=name;
		this.limit=limit;
		this.money=0; //초기화
		this.flag= true; //제한금액 있음
	} //초기화용 생성자
	
	void alert() {
		System.out.println("제한금액을 초과하여 사용할 수 없습니다.");
	} //alert

	void pay(int money) { // money만큼 결제
		if(this.flag && this.money+money > limit ) { //flag가 true고 money+입력money가 limit를 넘었을 때,
			alert(); //경고창 띄우고 
			return; //매서드 끝내기
		} 
		this.money+=money; //사용금액 누적 저장
		System.out.println(name+"님, 현재까지 사용한 금액은"+this.money+"원 입니다.");
	} // pay 매서드 사용해서 매개변수로 money 금액 넣어줘서, 누적할 수 있게
	
	@Override
	public String toString() {
		String print = this.name+"님 현재까지 사용 금액은"+this.money+"원 입니다. 제한금액";
		//String으로 출력문 작성한 걸 변수 처리해서 if에 따라 나올 수 있게 만들기
		if(this.flag/*제한이 있다면*/) print+=" 있음:"+this.limit+"원";
		//print문 뒤에 추가해주기
		else print+=" 없음";	
		return print;
	} // toString
} // Card

//-------------------------------------------------------------//

class CreditCard extends Card {
	int count;
	
	CreditCard (){
	}
	
	CreditCard (String name, int limit){
		super(name,limit);
		this.count=0; // int count 스타트 지점 잡아주기
	}
	
	@Override
	void alert() {
		super.alert(); //여기서 alert 매서드 호출되면 조상거 띄우고 + count++ sysout까지 호출
		this.count++;
		System.out.println("총"+this.count+"회 경고");
	}
	
	// ** toString은 내가 오버라이딩 안해도, 호출하면 조상에 있는게 자동 호출되서 오버라이딩X
} // CreditCard

//-------------------------------------------------------------//

class BusCard extends Card {
	int age;
	
	BusCard () {
	}
	
	BusCard (String name, int age) { //제한없는
		this(name,age,0); //★아래 오버로딩 매개변수가 3개 있기 때문에, this()로 묶어주기
		this.flag=false;
	} //Card를 상속받아서 Card의 맴버들 쓸 수 있는 것
	
	BusCard (String name, int limit, int age) { //제한있는
		super(name,limit);
		if (age <0 || age>200) this.age=20; 
		this.age=age; //BusCard 매개변수 age 판단해서 초기화하는 생성자
	}
	
	int check () {
		int buspay; //age를 통해 계산될 버스요금 주소부 마련
		
		if(age >=1 && age <=12) buspay=0;
		else if(age >=13 && age <=19) buspay=1000;
		else if (age >=20 && age <=65) buspay=2000;
		else buspay=0;		
		return buspay;
	} //check
	
	void pay() {
		this.pay(this.check()); //BusCard 클래스에서 사용될 pay매서드(오버라이딩 아님! 오버로드!)
		// BusCard class 의 pay매서드 실행 시 해당 클래스의 check 매서드 실행 되서 buspay 계산
	} //pay
} // BusCard

//============================================================//

public class Test_extend_01 {

	public static void main(String[] args) {
		Card c1 = new Card("홍길동"); //제한X
		Card c2 = new Card("홍길동",10000); //제한O
		
		c1.pay(5000);
		System.out.println(c1);
		
		c2.pay(2000);
		c2.pay(7000);
		c2.pay(1000);
		c2.pay(100);
		System.out.println(c2);
		
//======================================
		
		 CreditCard cc = new CreditCard("홍길동",10000);
		 cc.pay(10100);
		 cc.pay(5000);
		 cc.pay(5000);
		 cc.pay(100);
		 cc.pay(3000);
		 System.out.println(cc);
		 
//======================================		 
		 
		 BusCard bc1 = new BusCard("홍길동",30);
		 BusCard bc2 = new BusCard("김길동", 10000, 13);
		 
		 bc1.pay(10000);
		 bc1.pay(1000);
		 System.out.println(bc1);
		 
		 bc2.pay(); //pay매서드 안에서 checked 매서드도 실행되는 것!
		 bc2.pay();
		 bc2.pay();
		 bc2.pay();
		 bc2.pay();
		 bc2.pay();
		 bc2.pay();
		 System.out.println(bc2);
	} //main
} //class
