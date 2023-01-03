package j09_innerClass;

// 예제 7_17
// 인스턴스 클래스 익명클래스로 변환하기

public class Exam_7_17 {

	Object iv = new Object() {
		void method() {
		}
	}; // method매서드를 가진 Object의 익명클래스

//-------------------------------------------------------------//

	static Object cv = new Object() {
		void method() {
		}
	};

//-------------------------------------------------------------//

	void myMethod() {
		Object lv = new Object() { // 로컬클래스 이자 익명 클래스
			void method() {
			} //
		};
	} // myMethod
} // class
