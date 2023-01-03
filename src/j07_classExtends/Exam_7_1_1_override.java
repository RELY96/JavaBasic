package j07_classExtends;

class Point {
	int x=1;
	int y=1;
	String getLocation() {
		return "x:"+x+"y:"+y;
	}
}

class Point3D extends Point {
	int z=10;
	
	@Override
	String getLocation() {
		return "x:"+x+"y:"+y+"z:"+z;
	}
}



public class Exam_7_1_1_override {

	public static void main(String[] args) {
		Point3D p= new Point3D();
		System.out.println("Point3D :"+p.getLocation()); //getLocation매서드가 오버라이딩 되어 xyz return나옴
		
		Point p1 = new Point();
		System.out.println("Point 의 x,y를 Point3D에서 출력"+p1.getLocation());
	}

}
