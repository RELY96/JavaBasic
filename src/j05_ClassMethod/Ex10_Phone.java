package j05_ClassMethod;

//getter setter 매서드 연습

//** static Test : Phone 클래스 정의
//맴버변수 3개 (static 1개, non_static 2개)
//메서드 2개 (static 1개, non_static 1개) 
//맴버변수 3개를 생성자로 초기화한다

public class Ex10_Phone { //public이라 프로젝트 내 어디서든 해당 클래스 접근가능
	// 1) 맴버변수 정의
	private static String first;
    // private static final String first="010"; // 010 아예 수정 못하게 하려면 상수로 설정 즉시 초기화!
	private int second;
	private int last;

	// ** 상수로 정의하면 초기화로 바꿀 수 X / 상수는 바로 초기화 해줘야함, 인스턴스별로 관리할 필요 없으니까 static붙임
    // ex: public static final String first ="011";
	// ** final 같은 상수들은 어차피 1번만 사용되고 변하지 않으니까 꼭 앞에 static붙여서 메모리 낭비 방지!

	// 2) 생성자
	public Ex10_Phone(int second, int last) { // 초기화용 생성자
		this.second = second;
		this.last = last;
	} 
	public Ex10_Phone() { // 기본생성자
		} 

	// 3) setter getter
	public static void setFirst(String first) {Ex10_Phone.first = first;}
	public static String getFirst() {return first;}

	public void setSecond(int second) {this.second = second;}
	public int getSecond() {return second;}

	public void setLast(int last) {this.last = last;}
	public int getLast() {return last;}

	// 4) toString
	@Override
	public String toString() {
		return "" + first + "-" + second + "-" + last + "";
	}

	// 5) 메인 실행
	public static void main(String[] args) {
		
		Ex10_Phone.setFirst("010"); //private static변수 010으로 초기화(static 메인 매서드 안에 static매서드 넣으니까 인스턴스 생성필요X)

		Ex10_Phone p1 = new Ex10_Phone(3456, 7891);
		System.out.println("p1 toString로 출력: " + p1);
//		p1.setSecond(8278); set으로 second자리 초기화 하면 밑 print는 8278 나옴
		System.out.printf("p1 getter로 출력: %s-%d-%d \n", Ex10_Phone.getFirst(), p1.getSecond(), p1.getLast());

//		System.out.printf("p1의 번호 getter: %s-%d-%d \n",p1.getFirst(),p1.getSecond(),p1.getLast());
		                                              //*getfirst는 static매서드라 인스턴스 생성된 p1사용보다 바로 클래스명.매서드로 불러와도 상관X? 
		// ------------------------------------------//
		// ** first 번호 수정 테스트
		Ex10_Phone.setFirst("011"); //★p2 인스턴스부터 static first 011로 변함

		Ex10_Phone p2 = new Ex10_Phone();
		// 처음에 default생성자 초기화 안하고, set이용해 처음 초기화
		p2.setSecond(8278); // set초기화 안하면 second,last는 int의 default 0으로 나옴
		p2.setLast(1236);
		System.out.println("p2(new) toString로 출력: " + p2);
		System.out.println("p2(new) getter로 출력: " + p2.getSecond());
	} //main
}
//phone 클래스
