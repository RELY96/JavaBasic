package c07_test;

// 이벤트 핸들러 익명 클래스로 바꾸기
// 1. 익명클래스가 될 자손과, 조상 찾기
// 2. 익명클래스가 될 자손 위치에 조상명을 넣고 이름 바꾸기 -> 뒤 매서드 작성, ; 붙여주기

import java.awt.Frame;
import java.awt.event.*;
/* 단, 패키지 중 한 두개만 사용할 거면 *로 안 바꾸고 / 다른 클래스들 사용 시 *이용하는 게 좋음! */
/* 임포트의 "클래스명 자리"만 *로 대체 가능 */

public class Chap07_7_9 {

	public static void main(String[] args) {
		Frame f = new Frame(); // new Frame 생성한 거
		f.addWindowListener(new WindowAdapter () { // 바로 닫아버리기(익명클래스 연습용)
			@Override                              // 추상클래스 조상 속 "추상 매서드를 익명클래스 안에서 오버라이드"
			public void windowClosing(WindowEvent e) {
				e.getWindow().setVisible(false);
				e.getWindow().dispose();
				System.exit(0);
			} // windowClosing 매서드
		}); // WindowAdapter 속 익명클래스
	} //main
} //class
