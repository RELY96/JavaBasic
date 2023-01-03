package j09_innerClass;

import java.awt.Button;
import java.awt.event.*;

class EventHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("액션이벤트 나타나기");
	}
}

//---------------------------------------------------------//

public class Exam_7_18 {

	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new EventHandler());
	} //main
} //class
