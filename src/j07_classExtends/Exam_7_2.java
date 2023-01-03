package j07_classExtends;

class Parent {
	int x=10;
}

class Child extends Parent {
	int x=20;
	
	void method() {
		System.out.println("x: "+x); //가장 가까운 나 child의 x
		System.out.println("this.x: "+this.x); //child의 x
		System.out.println("super.x: "+super.x); //조상의 x
	}
}

public class Exam_7_2 {
	

	
	public static void main(String[] args) {
		Child c =new Child();
		c.method();
	} //main

} //class
