package c09_test;

public class Chap09_9_4 {
	static boolean contains (String src, String target) {
		if (src.contains(target)) return true;
		else return false;
	}
	
	public static void main(String[] args) { 
		System.out.println(contains("12345","23")); //static 매서드에 매서드 부르려면 static으로 만들어야
		System.out.println(contains("12345","67"));
	}

}
