package j10_APITest;

public class Exam_PersonTest {

	public static void main(String[] args) {
		Exam_Person person = new Exam_Person("960624-2476819","엄희정");
		
		person.infoPrint(); //매서드 안에 출력문 있으니까 sysout 해줄 필요X	
		System.out.println("toString 출력: "+person); 
		
//-----------------------------------------------------------------------//
		
		person.setName("엄정환"); //setName으로 이름 바꾸기
		person.infoPrint();
		
	} //main
} //class
