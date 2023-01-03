package j09_innerClass;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* import java.awt.event.* -> import 시에 클래스명 대신 * 사용가능(범용선택자와 같은 것!) */
import javax.swing.JFrame;

// 순수 UI로 사용되는 JAVA : JFrame 해보기(익명클래스에서 활용)
// EventListener 활용 

// ** 과제 : 이벤트 리스너 활용해 종료버튼 만들기

public class Ex05_Anony_JFrame extends JFrame { //자바가 기본적으로 제공해주는 UI를 상속 받아 쓰는 게 편함

	private static final long serialVersionUID = 1L; /* 객체 직렬화가 일어남 */

	public static void main(String[] args) {
		
		// ** UI 준비
		Ex05_Anony_JFrame ex05 = new Ex05_Anony_JFrame();
		Button /*하나의 객체로 이미 만들어져 있음Button*/ btn = new Button("Stop"); /*Button은 awt 임포트 필요*/
		
		ex05.setSize(300, 300); // 사이즈 값 주기
		ex05.add(btn); // add로 버튼 추가
		ex05.setVisible(true); // 화면 로드 하면 뜨게(boolean 값이니까 true하면 뜸)
		// 실행 시 stop이라는 버튼(300x300)생성됨
		
//==========================================================================//
		
		// ** 1) 이벤트 리스너에 Inner 클래스(=>익명클래스) 적용(ActionListener 인터페이스가 이미 있음)
		ActionListener ac = new ActionListener() { //인터페이스 클래스를 내부클래스로 만들어 구현까지 즉시, 일회성으로 해주기
			
			// ActionListener 안에 추상 매서드 오버라이딩
			@Override
			public void actionPerformed(ActionEvent e) {
				// ** Button btn 에서 발생된 이벤트인지 확인 후, 맞다면 종료
				if(e.getActionCommand().equals("Stop")/*e가 갖고 있는 액션 커맨드가 Stop  이라면(String은 주소니까 equals로 비교하기!!!)*/) System.exit(0); // 종료 문
			} //actionPerformed 매서드 만들어놓기
		}; // 문장의 끝에 ; 찍기
		btn.addActionListener(ac); //만든 매서드ac를 btn에 적용
		
//==========================================================================//
		// ** 1-2)
		btn.addActionListener(ac/*이 자리에다가 직접 코딩 할수도 있음*/);
		/*매개변수의 위치에 익명클래스 직접 작성 => 많이 사용됨!*/
		btn.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Stop")) System.exit(0);} 
		}); // 매개변수 끝에는 ; 필요 없음
	} //main
} //class
