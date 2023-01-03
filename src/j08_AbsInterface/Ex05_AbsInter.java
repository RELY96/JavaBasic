package j08_AbsInterface;

//** 추상클래스 와 interface 활용 

//=> 일반적인 경우 : 실무에서는 interface 가 많이 사용(다중구현 장점),  
//=> API 의 계층도(라이브러리)에서는 추상클래스도 많이 이용 

//** 과제
//=> 게시판을 종류별로 10개 이상 만든다고 가정.
//=> 기본 기능 (interface) : insert, update, delete, listPrint, detail, replyInsert -> 추상매서드 interface로
//=> 게시판 종류별로 구획: 일반게시판(i,u,d,l,detail,r), QnA(i,r,l), 공지사항(i,l,detail) : irl은 "모든 게시판"에 다 들어가야 하니까 중간 추상클래스에서 빼서 얘네만 구현의무주기!
//   각 게시판마다 공통점만 빼서 구현의무 줄여줘서 편.리 하게! 

//=> 모든 게시판을 interface 구현해야하면 게시판 종류에 따라 필요없는 나머지 매서드도 계속 오버라이딩 해야함!(단점)
//=> ★이런 경우 중간에 interface 를 구현해놓은 추상클래스를 미리 작성 -> 구현의무에서 벗어나서 필요한 메서드만 구현하면 되서 편리

//----------------------------------------------------------------//

//** 추상메서드만 넣은 Board interface
interface Board {
	void insert();
	void update();
	void delete();
	void listPrint();
	void detail();
	void replyInsert();
}

//----------------------------------------------------------------//

//**전부 구현 의무를 피하기 위해 중간에 구현해놓은 추상클래스 미리 작성(완충 역할)
abstract class BoardA implements Board { // 추상클래스는 추상매서드를 가질 수 있기 때문에, 구현 의무도 X, 구현 안해도 오류 X => 선택적 구현(오버라이딩) 가능
	// 의무구현 매서드는 추상매서드로 두고, 선택적 구현매서드들을 추상클래스에 미리 구현해놓음 -> ★실제 구현 클래스들의 의무구현 수가 줄어듬
	@Override
	public void update() {};
	@Override
	public void delete() {};
	@Override
	public void detail() {};
}

//----------------------------------------------------------------//

//** interface , 상속 활용 QnA 만들기
class QnABoard extends/*extends로 추상클래스 상속받기*/ BoardA {
	//BoardA에서 빈 구현된 나머지도 상속 받으면서, QnABoard에서 실제 필요한 매서드+공통적인 매서드 선택적으로 선택해서 실제 구현할 수 있음!
	@Override
	public void insert() {System.out.println("** QnA Insert **");}
	@Override
	public void listPrint() {System.out.println("** QnA listPrint **");}
	@Override
	public void replyInsert() {System.out.println("** QnA replyInsert **");}
}

//----------------------------------------------------------------//

//** interface , 상속 활용 공지사항 만들기
class MyBoard extends BoardA {
	@Override
	public void insert() {System.out.println("** 공지사항 Insert **");}
	@Override
	public void replyInsert() {System.out.println("** 공지사항 replyInsert **");}
	@Override
	public void listPrint() {System.out.println("** 공지사항 listPrint **");}
}

//===============================================================//

public class Ex05_AbsInter {

	public static void main(String[] args) {
		Board qna = new QnABoard(); //Board 타입이니까 QnABoard();뿐만 아니라 Board의 후손들은 모두 올 수 있음!(범위는 Board 만큼)
		qna.detail(); //BoardA를 상속받아 불러오기 가능, but,구현된게 없어서 따로 뜨진X
		qna.insert();
		qna.listPrint();
		qna.replyInsert();
		
		// BoardA ba = new MyBoard(); //BoardA는 interface를 implements하고, 얘를 다른 애들이 상속 안받으면, 상속 안받은 다른 애들은 BoardA랑 관련이 없음!
	} // main

} // class
