package j12_Exception;

// try-catch-finally
// finally : 무조건 실행 (break 든 continue든, try블럭을 빠져나올 때는 무조건 finally 블럭을 거쳐야 해서!!)

public class Ex03_finally {

	public static void main(String[] args) {

		int[] price = { 100, 200, 300 }; // 배열 (length 3, index 0~2)

		// 1. 정상 실행 (1회마다 try , finally, for end 모두 찍고 마지막 종료까지)
		for (int i = 0; i < price.length; i++) {
			try {                                  // 반복문 안에서 try-catch 사용
				System.out.printf("* price[%d]=%d \n", i, price[i]);
			} catch (Exception e) {
				System.out.println("* Catch블록 - Exception: " + e.toString());
			} finally {                                             // try 또는 catch 처리 후 무조건 finally 블록 처리
				System.out.println("* finally(무조건 실행), i: " + i);
			} // finally
			System.out.println("* for문_endLine, i: " + i);
		} // for
		
		System.out.println("==============프로그램 정상종료================");
		
//=====================================================================================//
		
		// 2. 오류 (3회 시에 catch -> finally -> for end -> 종료)
		for (int i = 0; i <= price.length; i++) { //length가 3일때도 찍으라니까 length초과 exception
			try {                           
				System.out.printf("* price[%d]=%d \n", i, price[i]);
			} catch (Exception e) {
				System.out.println("* Catch블록 - Exception: " + e.toString());
			} finally {                                        
				System.out.println("* finally(무조건 실행), i: " + i);
			} // finally
			System.out.println("* for문_endLine, i: " + i);
		} // for
		
		System.out.println("==============프로그램 종료================");
		
//=====================================================================================//
		
		// 3. 오류-exception가야 될때 앞에서 continue로 막아주기
		// - continue에서 다음 반복문으로 가야되지만, ★finally 찍고★ 다음 반복문(4)로 가서 for끝나고 바로 프로그램 종료 찍음
		// try 벗어나면서 finally는 무.조.건 찍어야 됨
		for (int i = 0; i <= price.length; i++) { 
			try {
				if(i==3) continue; /*i가 3일때 exception 못가게 하려고 continue;*/
				System.out.printf("* price[%d]=%d \n", i, price[i]);
			} catch (Exception e) {
				System.out.println("* Catch블록 - Exception: " + e.toString());
			} finally {                                        
				System.out.println("* finally(무조건 실행), i: " + i);
			} // finally
			System.out.println("* for문_endLine, i: " + i);
		} // for
		
		System.out.println("==============프로그램 종료================");
		
//=====================================================================================//
		
		// 3. i==2에 break로 반복문 탈출하기
		// - i==2일때 break로 finally갔다가 for 탈출(break)해서 바로 '종료' 띄움
		for (int i = 0; i <= price.length; i++) { 
			try {
				if (i==2) break; /*더이상 하지 않고 반복문 종료*/
				if(i==3) continue; 
				System.out.printf("* price[%d]=%d \n", i, price[i]);
			} catch (Exception e) {
				System.out.println("* Catch블록 - Exception: " + e.toString());
			} finally {                                        
				System.out.println("* finally(무조건 실행), i: " + i);
			} // finally
			System.out.println("* for문_endLine, i: " + i);
		} // for
		
		System.out.println("==============프로그램 종료================");
		
//=====================================================================================//		
		
		// 4. i==1에 return 할때
		// - void return하면 매서드 바로 종료 -> 매서드가 아예 끝나서 다른 건 다 안했는데, try벗어나면서 finally는 무조건 찍고 나감	
		for (int i = 0; i <= price.length; i++) { 
			try {
				if (i==1) return; //void에서 return하면 매서드 바로 종료
				if (i==2) break;
				if(i==3) continue; 
				System.out.printf("* price[%d]=%d \n", i, price[i]);
			} catch (Exception e) {
				System.out.println("* Catch블록 - Exception: " + e.toString());
			} finally {                                        
				System.out.println("* finally(무조건 실행), i: " + i);
			} // finally
			System.out.println("* for문_endLine, i: " + i);
		} // for
		
		System.out.println("==============프로그램 종료================"); //"매서드" 바로 종료 라 얘도 아예 안뜨고 종료함
		
//=====================================================================================//
		
	} // main
} // class
