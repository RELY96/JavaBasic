package z_extra;

import java.util.Scanner;

// https://blog.naver.com/a798019/222811048632

// 1.조상 Health , 자손 SubHealth

// Health
/* String name(이름), char gender(성별), double tall(신장), double weight(체중)
 * Health 생성자 2개(default, 초기화용)*/

// SubHealth
/*double s_weight(표준체중), double fat(비만도), String result(결과값)
 * SubHealth 생성자 2개 (초기화용:s_weight=0.0;, fat=0.0;, result=null;)
 * calculate 비만도계산
 * infoPrint 출력*/

// 표준체중 계산법
// 남성: s_weight = (tall-100)*0.9;
// 여성: s_weight = (tall-100)*0.85;
// 비만도: fat = (weight/s_weight)*100;

// if 90이하 저체중, 91-120 정상, 121-150 중도비만, 150~ 고도비만

// 출력문: ***비만도 체크***
/*성별: 남 or 여
 *신장: 
 *체중:
 *
 *당신은 비만도 ~이고, ~입니다.*/

class Health {
	String name; 
	protected char gender; //수정은 자손클래스에서 하는데, main에서는 getter로 볼수만 있게 protected
	protected double tall;
	protected double weight;
	
	Health (){
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		this.name=sc.nextLine();
		
		System.out.println("성별을 입력하세요 '남' 또는 '여'");
		this.gender=sc.next().charAt(0);
		
		System.out.println("키를 입력하세요");
		this.tall=sc.nextDouble();
		
		System.out.println("체중을 입력하세요");
		this.weight=sc.nextDouble();
		sc.close();
	} //Health 기본 생성자 에서 스캐너 소환
	
//----------------------------------------------//
	
	public char getGender() {
		if (gender=='남' || gender=='여') return gender;
		else return ' ';
	}
	public double getTall() {
		return tall;
	}
	public double getWeight() {
		return weight;
	}
} //Health

//----------------------------------------------//

class SubHealth extends Health {
	double s_weight;
	private double fat;
	private String result;
	
	SubHealth (){
		super(); //조상의 생성자 소환
		// 초기화
		s_weight= 0.0;
		fat=0.0;
		result=null;
	} //SubHealth
	
	public void calculate (){
		if(gender == '남') {
			s_weight =(super.tall-100)*0.9;
		} else if (gender == '여') {
			s_weight =(super.tall-100)*0.85;
		} else System.out.println("성별에 따른 표준체중을 알 수 없습니다");	
		fat = (super.weight/s_weight)*100;
	}// 비만도 계산
	
//------------------------------------------//
	
	public String getResult() {
		calculate ();
		if (fat <= 90) result="저체중";
		else if (fat > 90 && fat <= 120) result="정상";
		else if (fat > 120 && fat <= 150) result="중도비만";
		else result="고도비만";
		
		return super.name+"의 비만도는"+fat+"이고,"+result+"입니다.";
	}
	
	public void infoPrint () {
		System.out.println("* 비만도 체크 *");
		System.out.println("* 이름: "+super.name);
		System.out.println("* 성별: "+getGender());
		System.out.println("* 신장: "+super.tall); // tall 은 protected지만, 자식 infoPrint에서 불러온 걸 메인 info 매서드로 출력가능
		System.out.println("* 체중: "+getWeight());
		
		System.out.println("* 결과: "+result); // private 이라 infoPrint 에서 보이는 게 main에서 info매서드 호출시에도 볼 수 있음
	}
} //SubHealth

public class Test_extend_02 {

	public static void main(String[] args) {
		SubHealth h = new SubHealth(); //기본생성자 실행 시 super()생성자로 가서 Scanner 실행됨
		
		System.out.println("get 이용해 Test");
		System.out.println(h.name);
		System.out.println(h.getGender());
		System.out.println(h.getTall());
		System.out.println(h.getWeight());
		System.out.println(h.getResult()); //private이라 info는 물론, main도 get을 통해 접근 가능! -> ?
		
		System.out.println("출력문 이용해 Test");
		h.infoPrint();
	} //main

} //class
