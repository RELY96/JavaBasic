package j10_APITest;

import java.util.Calendar;

//** Person - 주민등록번호,  이름을 전달받으면 주민등록번호를 이용해서, age, 성별을 set 하고 info 출력

//조건 1) 맴버필드(private) : idNo(String), name(String), age(int), gender(char)
//    2) 생성자 2개 (default, 주민등록번호,이름을 매개변수로 전달받아 초기화 -> 나이 계산, 성별도 찾아서 set(초기화))
//    3) setter/getter : 이름만 수정 가능, 모든 필드를 사용 가능(주민번호 뒷자리는 * 로 표시)
//    4) infoPrint() 출력문
//    5) toString 은 오버라이딩

//=================================================================//

// ** 만드는 과정
// 1. Person 클래스 안 맴버변수 private으로 4개 정의 idNo(String), name(String), age(int), gender(char)

// 2. 생성자 2개(default, 초기화용)
// 2-1. 초기화 시 -> 매개변수1 주민등록번호를 전달받은 걸 이용해서 age, gender 계산 해서 변수 초기화 해주기
// 2-2. age 초기화 : 올해(Calendar 클래스 이용) - 주민번호 맨 앞 두자리 - (gender가 1or2면)1900, (3or4면) 2000 계산
// 2-3. gender 주민번호 "-"의 뒷자리 출력한 거

// 3. 이름만 수정 가능, 나머지는 보게만 가능 = 이름(setter,getter), 나머지(getter)
// 3-1. 주민번호는 뒷자리 ******로 표시해서 보이게 (getter 표시 형식 조작) : "-"전까지 substring으로 그대로 추출 + "-*******" 붙여주기
// 3-2. gender는 char를 기반으로 getter 시 '남', '여'로 보여줘야 하기 때문에 getter에서 if문 사용해서 1,3이면 char '남', 2,4면 char'여' 설정

// 4. 출력문 작성되어 있는 infoPrint()매서드 만들기

//=================================================================//

public class Exam_Person {
	// 1. 맴버변수 4개 선언
	private String idNo;
	private String name;
	private int age;
	private char gender;

	// =================================================================//
	// 2. 생성자 2개
	Exam_Person() {
		System.out.println("기본 생성자");
	}

	Exam_Person(String idNo, String name) {
		this.idNo=idNo; // 주민번호 매개변수로 초기화
		this.name=name; // 이름 매개변수로 초기화
		
		// 2-3. gender (이걸 먼저해야 age에서 1900,2000 구분 가능!)
		gender = idNo.charAt(idNo.indexOf("-")+1); //charAt 안에 숫자가 들어가야 하니까, indexOf 로 - 뒷자리 문자의 숫자 뽑기 => charAt으로 해당 char 뽑아짐!
		
		// 2-2. age 계산해서 초기화
		int year = Calendar.getInstance().get(Calendar.YEAR); // 올해 얻기
		age = year - Integer.parseInt(idNo.substring(0, 2)); // 올해 - (idNo에서 앞 두자리 추출한 거 int로 변환)
		
		// 2-2-1. gender가 1or2면 age -= 1900 / 3or4면 age-=2000;
		if (gender=='1' || gender=='2' ) age -= 1899; // +1한것!
		else if (gender=='3' || gender=='4' ) age -= 1999;
		else System.out.println("나이가 잘못 됐습니다");
	}

	// 3. =================================================================//
	public void setName(String name) {
		this.name = name; //setName 매서드 이용하면 이름만 바꾸기 가능함!
	}
	public String getName() {
		return name;
	}
	// =================================================================//
	public String getIdNo() {
		return idNo.substring(0,idNo.indexOf("-"))+"-*******"; //idNo - 뒤에 *표시 출력
	}
	
	public char getGender() { //getter로 보여줄 때, gender에 따라 '남' or '여'로 출력
		if (gender=='1' || gender=='3' ) return '남';
		else if (gender=='2' || gender=='4' ) return '여';
		else return ' '; 
	}
	
	public int getAge() {
		return age;
	}
	// =================================================================//
	@Override
	public String toString() {
		return "Exam_Person [idNo=" + idNo + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	// 4. =================================================================//
	
	public void infoPrint() {
		System.out.println("* Person의 정보 *");
		System.out.println("* 이름: "+getName());
		System.out.println("* 주민번호: "+getIdNo());
		System.out.println("* 나이: "+getAge());
		System.out.println("* 성별: "+getGender());
	} // infoPrint
} //class
