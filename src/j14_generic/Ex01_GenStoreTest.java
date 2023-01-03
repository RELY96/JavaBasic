package j14_generic;

//------------------------------------------------------------
//** Generic
//=> 컬렉션(Collection:자료구조) 을 보강해준 기능
//=> 컴파일 단계에서 객체의 자료형을 선언(정의) 해주면
// 다른 타입의 자료가 저장될수 없도록 해주는기능

//** Generic 클래스 정의
//=> 클래스 이름 옆에 <> 사이에 알파벳 1글자를 사용하여 
// Generic Type 명을 선언해줌 
// ex : <T> 처럼 "<" 와 ">" 사이에 선언 
//=> 대문자로 T, E 등을 많이 사용 
// Type 의미로 "T" 를 주로 사용
//=> Generic 타입으로 클래스를 사용한다는 의미 
//=> 제네릭으로 기본 자료형(int, float, double....)은 사용할 수 없지만
// 기본자료형의 wrapper 클래스를 이용할 수있다. 
//=> 실행 Test : Ex01_GenStoreTest.java

//** Generic 타입제한 (Wildcards_와일드카드타입 이용으로)
//=> <?>
// Unbounded Wildcards (제한없음_모든 클래스나 인터페이스 타입 가능)
//=> <? extends ...>
// Upper Bounded Wildcards (상위클래스 제한_같거나 하위 타입 가능)
//=> <? super ...>
// Lower Bounded Wildcards (하위클래스 제한_ 같거나 상위타입 가능)
//------------------------------------------------------------

import a_javaTest.Student;
import j13_Collection.Ex04_HashSet;
import j13_Collection.Ex05_SetLotto;

// ** 1. 기존 방식의 범용적 코드 만들기
// Object data = new String("Test"); => 모든 클래스는 Object의 후손이므로 우측에 사용되어 대입될 수 있다.
// 즉, 모든 클래스는 아래 setter의 매개변수가 될 수 있다
class Store {
	private Object data; //오브젝트 타입 데이터 선언
	public void setData(Object data) { // setter 데이터(오브젝트 타입)
		this.data=data;
	}
	public Object getData() { // getter 
		return data;
	}
} //Store => main에서 사용 비교

//=========================================================//

//** 2. Generic 방식 - 클래스 변수의 타입을 T(임의의 알파벳)로 표현 해놓고, 실행코드(main)에서 결정해서 사용 
//   => 결정된 타입 외에는 사용불가(Exception)

class StoreG<T> { // 해당 클래스에는 T라는 제네릭을 사용하고 있다고 클래스 header부분에 알려줘야 함
	private T data; //타입지정 Object 대신 제네릭 T 넣기 
	public void setData(T data) { 
		this.data=data;
	}
	public T getData() { 
		return data;
	}
} //StoreG

//=========================================================//

public class Ex01_GenStoreTest {

	public static void main(String[] args) {
		//** 1. 기존방식
		
		Store s1 = new Store();
		s1.setData("짜장면"); //Object니까 어떤 객체든 넣어보기
		s1.setData(12345); //int -> Integer
		s1.setData(new Ex05_SetLotto()); //class 객체도 Object 자손이니까 들어갈 수 있음!
		s1.setData(123.456); //double -> Double (최종 담긴 데이터)
		// 모든 기본 자료형은 해당되는 Wrapper 클래스로 자동 형변환이 되어짐
		
		// String s = (String)s1.getData(); //getData()타입은 Object로 되어 있으니까, Object타입 리턴 후 String타입 s에 스트링 형변환 저장
		// => Double은 String으로 형변환 될 수 없어서 형변환 불가, 런타임 오류남! 
		// System.out.println("* 기존방식(Object)Test: "+s); //오류
		// => 문제점 : Object 안에 어떤 타입이 들어올 지 모름 -> 형변환 등 사용 불가능한 타입이 들어왔을 때, 기존 방법은 런타임 오류가 날 수 있음!
		
//-------------------------------------------------------------------------------------------------------------------//
		
		// ** 기존방식 단점 정리 - 
	    // 1) 컴파일 오류는 없으나 런타임 오류 가능성 매우 높음
	    // 2) 어떤 타입으로든 대입이 가능하기 때문에 오류 발생확률이 매우 높음 -> Object 에는 어떠한 Type의 클래스 인스턴스도 들어갈 수 있음
	    // -> Compile Time 에는 실제 들어있는 값과 무관하게 형변환하여도 오류가 발생하지 않음 
	    // 3) 그러나 어떤 경우, 스트링은 Integer화 될수없기 때문에 런타임오류발생 : ClassCastException
	    // ★★ 이러한 상황을 방지하기 위해 사용시에 Type을 결정(제네릭을 이용해, 사용시에 <String>으로 쓴다고 결정 등)하여, Compile Time에 오류를 알 수 있도록 하기 위한 방법이 Generic 
		
//===================================================================================================================//
		
		// ** 2. Generic 방법
		/*StoreG sg = new StoreG();
		sg.setData("nonGeneric 처럼 작동"); //=>노란 경고 나옴
		sg.setData(12345);
		sg.setData(new Ex05_SetLotto());*/
		// => 생성 시 Generic Type 생략가능(노란경고)하지만, Generic이 적용안됨(기존방식처럼 작동중이었음(=Object 타입))
		
		//--------------------------------------------------------------------//
		
		// 2.1) T:String
		// ** 생성
		StoreG<String> sg1 = new StoreG<String>(); //제네릭 스트링 지정, 스트링 외엔 컴파일 오류!, 타입 제한
		sg1.setData("nonGeneric 처럼 작동"); 
		/*sg1.setData(12345); => String타입 외 컴파일 오류*/
		System.out.println("* 제네릭방식 Test1: "+sg1.getData());
		//--------------------------------------------------------------------//
		
		// 2.2) T:Integer
		// ** 생성
		StoreG<Integer> sg2 = new StoreG<Integer>();
		/*sg2.setData("12345"); -> 컴파일 오류*/
		sg2.setData(12345);
		System.out.println("* 제네릭방식 Test2: "+sg2.getData());
		
//===================================================================================================================//	
		
		// 다른 클래스 객체 넣어보기
		StoreG<Ex04_HashSet> sg3 = new StoreG<Ex04_HashSet>(); //타입을 HashSet 클래스로 정의
		sg3.setData(new Ex04_HashSet()); // "new Ex04_HashSet() 인스턴스 생성"과 동시에 setData로 해쉬셋안 맴버변수에 접근해서 set할 수 있게 만들기
		// => 접근 가능한 맴버변수가 있으면 접근해서 set 가능하다!
		System.out.println("* 제네릭방식 Test3: "+sg3.getData());
		
//===================================================================================================================//	
		StoreG<Student> sg4 = new StoreG<Student>(); //타입을 HashSet 클래스로 정의
		sg4.setData(new Student("001", "김길동", 65, 80));
		/*sg4.setData("S001","엄희정",80,90)
		sg4.setData(12345); -> Student 생성자 해당안되는 setData 타입은 오류*/
		
		System.out.println("* 제네릭 Student-No: "+sg4.getData().getNo());
		System.out.println("* 제네릭 Student-이름: "+sg4.getData().getName());
		System.out.println("* 제네릭 Student-자바: "+sg4.getData().java);
		System.out.println("* 제네릭 Student-html: "+sg4.getData().html);
		sg4.getData().infoPrint();
	} //main
} //class
