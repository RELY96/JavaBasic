package j09_innerClass;

import java.awt.Button;
import java.awt.event.*;

public class Exam_7_18_2 {

	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new ActionListener() { //조상클래스(){익명클래스}로 이벤트 리스터 재구성하기
			public void actionPerformed(ActionEvent e) {
				System.out.println("액션이벤트 나타나기");
			}
		});

	}

}
