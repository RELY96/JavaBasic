package j14_generic;

import a_javaTest.Person;

//배열 출력해주는 클래스 만들기(어떤 타입을 배열에 넣든 출력)

//    0) 배열정의, setter/getter, arrayPrint()
// => 1) 실행 시에 "원하는 타입을 결정 & 출력" generic
// => 2) 배열 타입 Generic

class GenArray<T> {
	private T[] arr; //배열은 어떤 타입(T)의 배열이다 -> 정의 => 타입 대신 T[] 타입인거! 
	public void setArr (T[] arr) {this.arr=arr;} //setArr
	public T[] getArr () {return this.arr;}
	
    public void arrayPrint() { //출력 매서드니까 return타입은 보이드
    	
		for(T a : arr) { // 들어가는 T타입이 이미 배열타입이라 T a : arr, T[](X)
			System.out.print(a+" ");
		} //eachfor문으로 배열 쉽게 출력
		
		System.out.println(""); //반복문 끝난 후 줄바꿈
	
    } //arrayPrint 매서드
    // 0) 배열정의, setter/getter, arrayPrint()
    
    // ** 이 배열의 "마지막 자료 출력"하는 매서드
    public T/*return 타입 타입T(T[])*/ getLast() {
    	return arr[arr.length-1]; //마지막은 arr의 length-1  
    } //getLast

} //GenArray

public class Ex02_GenArray {

	public static void main(String[] args) {
		// 1) String 배열 생성
		GenArray<String> ga1 = new GenArray<String>(); //1. String타입으로 쓸 배열 ga1 인스턴스 생성
		
		String[] ss = {"가","나","DA","RA","마","바"}; //2. ga1에 넣을 String타입 배열 만들기
		
		ga1.setArr(ss); //3. ga1에 String ss 배열 넣기(list put해주듯이 set으로 넣어준거 생각하면됨!)
		
		ga1.arrayPrint(); //4. 출력
		System.out.println("last: "+ga1.getLast());
		
//-----------------------------------------------------------------------------------------------//
		
		// 2) Integer
		GenArray<Integer> ga2 = new GenArray<Integer>();
		Integer[] in = {1,2,3,4,5}; //ga2에 넣으려면 소문자int가 아닌 Integer로 해야함
		
		ga2.setArr(in);
		
		ga2.arrayPrint(); 
		System.out.println("last: "+ga2.getLast());
		
//--------------------------------------------------------------------
		
		// 3) Double
		GenArray<Double> ga3 = new GenArray<Double>();
		Double[] dd = {123.456,289.23,31.9,405.78,556.234};
		
		ga3.setArr(dd);
		
		ga3.arrayPrint(); 
		System.out.println("last: "+ga3.getLast());
		
//--------------------------------------------------------------------		
		
		// 4) Character(char)
		GenArray<Character> ga4 = new GenArray<Character>();
		Character[] cc = {'가','나','A','B','C'};
		
		ga4.setArr(cc);
		
		ga4.arrayPrint(); 
		System.out.println("last: "+ga4.getLast());

//--------------------------------------------------------------------		
		
		// 5) Person
		GenArray<Person> ga5 = new GenArray<Person>();
		Person[] pp = {new Person("001","김길동"), new Person("002","엄희정"), new Person("003","홍길동")};
		
		ga5.setArr(pp);
		ga5.arrayPrint(); // Person 의 경우, new 인스턴스 들의 주소값이 들어있어서, 차례대로 꺼내면 toString이 print됨!
		System.out.println("last: "+ga5.getLast());
//--------------------------------------------------------------------
	} //main
} //class
