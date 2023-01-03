package j10_APITest;

import java.util.Calendar;

//** Person
//=> 주민등록번호,  이름을 전달받으면
//=> 주민등록번호를 이용해서, age, 성별을 set 하고
//=> info 출력하기 
// 주민번호 : 012345-78910111213

//1. 맴버필드(private) : idNo(String), name(String), age(int), gender(char) // age는 -다음자리
//2. 생성자 2개
//    * default
//    * 주민등록번호,이름을 매개변수로 전달받아 초기화 -> 나이 계산, 성별도 찾아서 set(초기화)
//3. setter/getter
//    *이름만 수정 가능(이름은 setter,getter 모두), 
//     모든필드를 사용가능(getter) (그러나 주민번호는 뒷자리는 * 로 표시-> replace)

// ★!!!문제 제대로 보기!!!★

//----------------------------------------------------------------//

//=> infoPrint()
//=> toString 은 오버라이딩

//** info
//이름 : 000
//번호 : 090909-*******
//나이 : 20세
//성별 : "남" 또는 "여"

public class Ex05_Person {

	private String idNo;
	private String name;
	private int age;
	private char gender;

	public Ex05_Person() {
		System.out.println("기본 생성자");
	} // 기본 생성자

	public Ex05_Person (String idNo, String name){ 
		this.idNo=idNo;
		this.name=name;	
		this.gender=idNo.charAt(idNo.indexOf("-")+1);  // 7 넣어주는 건 바람직X, 기호 이용해서 넣어주기! => ("-")뒤 첫번째 자리 charAt 뽑기
		
		// ** 성별
		
		// 나이 계산 : 1)현재(올해) - 2)태어난 해 + 1
		// 1) 올해(시스템데이터에서 가져오기) :  Date(지원하지 않음) / Calendar(많이 사용)
		Calendar now = Calendar.getInstance(); // getInstance -> Calendar 클래스의 Instance를 받아 사용할 수 있음
		int year = now.get(Calendar.YEAR); // 또는 int year = Calendar.getInstance().get(Calendar.YEAR); 로 써도 됨(인스턴스 생성 시 바로 쓴거!)
		
	    // 3) 현재(올해) - 태어난 해(앞에서 1900,2000계산해줌) + 1
		age= year - Integer.parseInt(idNo.substring(0,2)); /*번호 앞 두자리 뽑기*/
		
		// 2) 태어난 해 : idNo 의 앞 두자리 필요 + 뒤첫자리(1900년대/2000년대 확인 위해) 필요 (1,2 -> +1900 /3,4 -> +2000)
		// 올해에서 1900,2000빼고, 태어난 해 두자리 또 빼는 등 따로 해도 됨 -=1900, -=2000;
		if(gender =='1'||gender =='2') age-=1900;
		else age-=2000;
		
		// 올해 - (번호 앞 두자리+2000 or 1900) => 올해 - 번호 앞 두자리 - 2000 or 1900(if문)
		
	} // 초기화 생성자
//name setter getter-------------------------------------------//

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

//다른 것들 getter-----------------------------------------------//

	public String getIdNo() {
		if (idNo != null)
			return idNo.substring(0, idNo.indexOf("-")) + "-*******"; // if로 null값 막기
		// 0~"-"전까지 substring으로 출력하고 뒤에 "-*******" 붙이기
		else
			return null;
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		if (gender == '1' || gender == '3')
			return '남';
		else if (gender == '2' || gender == '4')
			return '여';
		else
			return ' '; // char Type 은 ''빈 문자 허용하지 않음 => ' ' 으로 공백처리
	}

//=====================================================//
	// 출력
	@Override
	public String toString() { // toString은 개발자용 원시 data값 그대로 출력
		return "Ex05_Person [idNo=" + idNo + ", name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	public void infoPrint() { // info 출력용 매서드 따로 작성
		System.out.println("*info Print: ");
		System.out.println("* 주민번호 " + getIdNo());
		System.out.println("* 이름 " + getName());
		System.out.println("* 나이 " + getAge());
		System.out.println("* 성별 " + getGender());
	}
} // Ex05_Person class
