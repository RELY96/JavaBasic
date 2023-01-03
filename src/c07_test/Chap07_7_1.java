package c07_test;

// ** 정석기초 연습문제 7-1
//=> 섯다카드 20장을 포함하는 섯다카드 한 벌 (SutdaDeck 클래스)을 정의한 것이다.
//섯다카드 20장을 담는 SutdaCard Type 의 배열을 초기화하시오.
//단 섯다카드는 1부터 10까지의 숫자가 적힌 카드가 한 쌍씩 있고,
//숫자가 1, 3, 8 인 경우에는 둘 중의 한 장은 광(Kwang) 이어야 한다.
//( 1,1K,2,2,3,3K,4,4,5,5,6,6,7,7,8,8K,9,9,10,10 )
//즉 SutdaCard의 인스턴스변수 isKwang의 값이 true이어야 한다.

//================================================================//

class SutdaDeck {
	// 배열정의
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];

	// default 생성자로 초기화
	SutdaDeck() {
		for (int i = 0; i < cards.length; i++) {
			int num = i % 10 + 1; // i=0,1,..10...19 / n=1,2,...1,...10
			boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
			cards[i] = new SutdaCard(num, isKwang);
		}
	} // 생성자
	
//----------------------------------------------------------------//

	void shuffle() {
		// 맞교환할 카드 배열의 인덱스
		for (int i = 0; i < cards.length; i++) {
			int j = (int) Math.random() * cards.length; // cards.length 보다 작을 때 까지 랜덤 뽑기

			SutdaCard temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp; // shuffle 섞어주기
		}
	} // shuffle (Math.random 사용)

//----------------------------------------------------------------//	
	
	SutdaCard pick(int i) {
		// index의 유효범위 확인( 0 ~ 19 ) <0 || 19< 면 error (구간 안에서 출력)
		if (i < 0 || i >= CARD_NUM /* 19숫자 대신 카드 배열 크기 정해준 CARD_NUM 이용 */) {
			System.out.println("* index 오류입니다 *");
			return null;
		}
			return cards[i]; // 카드배열 안에서 내가 넣어준 인덱스 i를 return하면 됨
	} // pick overloading

//----------------------------------------------------------------//	
	
	SutdaCard pick () { //인덱스 값을 i를 이용해 찾아내는 것
		int i =(int)(Math.random()*cards.length);
		return pick(i); //i값에 해당되는 걸 return해주는 매소를 가 pick으로 이미 있으니, 그걸 이용
	} // pick (Math.random 사용)
} // SutdaDeck

//----------------------------------------------------------------//

class SutdaCard {
	int num;
	boolean isKwang;

	SutdaCard() {
		this(1, true);
	}

	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	public String toString() { // 인스턴스 저장공간 안에 true이면 k붙여서, 아니면 안 붙여서 toString으로 출력되게
		return num + (isKwang ? "K" : "");
	}
} // SutdaCard

public class Chap07_7_1 {

	public static void main(String[] args) {
		// 7-1 출력
		SutdaDeck deck = new SutdaDeck();
		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + " "); // toString 자동 호출
		} // for
		
//====================================================================================//
		
		// 7-2 섞는 거 추가한 거 출력
		System.out.println("\n* pick(0): "+deck.pick(0)); //매개변수 줘서 랜덤 섞은거 작동
		System.out.println("* pick(): "+deck.pick()); //매개변수 안줘서 랜덤 매서드 작동
		deck.shuffle(); //섞기
		System.out.println("* shuffle 후 출력 *");
		for (int i = 0; i < deck.cards.length; i++) {
			System.out.print(deck.cards[i] + " "); 
		} //for
		System.out.println("\n* after, pick(0) : "+deck.pick(0));
		System.out.println("* after, pick() : "+deck.pick());
	} // main

} // class
