package z_extra;

// 최댓값 구하는 식 만들기
// 1. 비교하면서, if 첫 배열이 다음 배열보다 작으면 다음 배열이 max에 들어감

/* !!! 다시 풀기 !!! */

public class Test_05 {

	public static void main(String[] args) {
		int[] array = { 1, 3, 80, 8, 100 };
		int max = array[0];

//---작성-------------------------------------------// 	

		// max = array[max];
		for (int i = 1; i < array.length; i++) { // array의 length까지 비교 돌리기
			if (max < array[i]) {
				max = array[i];
			} // if문 (최댓값 비교해서 산출)
		} // for_i
		System.out.println("max : " + max);
	} // main
} // class
