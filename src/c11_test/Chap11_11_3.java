package c11_test;

class Student {
	String name;
	int ban;
	int no;
	int kor,eng,math;
	
	Student(String name, int ban,int no, int kor, int eng, int math){
		this.name=name;
		this.ban=ban;
		this.no=no;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	
	int getTotal() {
		return kor+eng+math;
	}
	
	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5)/10f;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", ban=" + ban + ", no=" + no + ", kor=" + kor + ", eng=" + eng + ", math="
				+ math + ", getTotal="+getTotal()+", getAverage="+getAverage()+"]";
	}
} //Student
// => Comparable

public class Chap11_11_3 {

	public static void main(String[] args) {
		
		

	} //main
} //class
