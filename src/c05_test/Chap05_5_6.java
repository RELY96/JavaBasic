package c05_test;

//** 정석기초 연습문제 5-6
//단어의 글자위치를 섞어서 보여주고 원래의 단어를 맞추는 예제이다.
//실행결과와 같이 동작하도록 예제의 빈 곳을 채우시오.

//shuffle

import java.util.Scanner;

public class Chap05_5_6 {

	public static void main(String[] args) {
		String[] words = { "television", "computer", "mouse", "phone" }; // 2차원 배열

		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < words.length; i++) {
			char[] question = words[i].toCharArray(); // String을 char[] 로 변환 -> 임의로 배열 섞고 question에 담아주는 것

			// ★char[] question에 담긴 문자의 위치를 임의로 변경(섞기)
			for (int j = 0; j < question.length; j++) { // question(배열 안 배열) 길이까지 돌려줌
				int idx = (int) (Math.random() * question.length); // 랜덤으로 인덱스 뽑고 * question length만큼 곱하기(배열의 범위 = *의
																	// 길이)
				char temp = question[i]; // 임시변수 선언해서 치환★ , 꼭 i 아니고 [0], [n] 등도 됨!
				question[i] = question[idx];
				question[idx] = temp;
			}

			System.out.printf("Q%d. %s의 정답을 입력하세요>", i + 1, new String(question)); // new String(question)은
																					// ★char[]을 String으로 해준 것
			String answer = scanner.nextLine();

			if (words[i].equals(answer.trim())) // String은 == 말고 무조건 equals비교 써야함(words[i]는 주소값, 참조형변수이기 때문)
				// "★words[i]는 섞이기 전의 거"기 때문에 그거랑 비교해서 if,else 결과 나옴
				System.out.printf("맞았습니다.%n%n");
			else
				System.out.printf("틀렸습니다.%n%n");
		}
		scanner.close();

	} // main

} // class
