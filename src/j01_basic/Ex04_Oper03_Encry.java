package j01_basic;

public class Ex04_Oper03_Encry {
	// ★암호화/복호화 해보기 (암호화하면 다시 원래 자리로 돌아갈 수 있는지?)
	
	//** XOR 연산자를 사용한 암호화(Encryption)/복호화(Decryption) 예제 
	//=> XOR : 같으면 0 , 다르면1	
	

	public static void main(String[] args) {
		// ※ 암호화, 복호화는 옛날 방식(요즘은 새로운 password 발급 방식 사용)
		int p=1234567, t=0; //완성된 결과물을 담기위해 t 필요
		int e=0x1A253B65; // 16진수 -> 어떤걸 해도 상관 없는데, ^16진수로 암호화된 결과물에 다시 ^16진수 하면 복호화됨
		System.out.println("** 암호화 전 password => " +p);
		
		// ** 암호화(Encryption) //t에 완성된 결과물 담아야 함, 암호화된 결과물을 다이제스트라고 함(이 경우엔 t)
		t=p^e;
		System.out.println("** 암호화 된 password => " +t);
		
		// ** 복호화(Decryption) <- 복호화 하고나면 원상복구 되어져야 함 
		t=t^e; // t에 ^e한번 더 적용하면 t가 원래 값(p)으로 원상복구 되어야 함
		System.out.println("** 복호화 된 password => " +t);
		
		
	} //main

} //class
