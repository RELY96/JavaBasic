package c03_test;

public class Chap03_3_3 {
	
	// ** 정석 연습문제 3_4

	public static void main(String[] args) {
		int numOfApples=123;
		int sizeOfBucket=10;
		
		// 나눴을 때 나머지가 0이 아니면 +1 해주는 것(나머지가 0보다 크다면 % 후 +1)(바구니 안에 넣는 수가 꼭 10일 수는 없으니까)
		
//		int numOfBucket= (numOfApples%sizeOfBucket > 0)? (numOfApples/sizeOFBucket)+1 : numOfApples/sizeOFBucket;
		int numOfBucket= numOfApples/sizeOfBucket+(numOfApples%sizeOfBucket > 0 ? 1:0);
		System.out.println("  필요한 바구니의 수 : " +numOfBucket);
	} //main

} //class
