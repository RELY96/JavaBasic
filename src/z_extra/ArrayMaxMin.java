package z_extra;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class ArrayMaxMin {
    public static void main(String[] args) {
        // Lotto
        // Lotto 번호 뽑기(중복허용X), 최댓값, 최솟값 출력

        // 1) lotto 번호 담을 공간 마련
        int[] lotto = new int[6];
        // ※ 1. 중복검사
        // 2) 랜덤 번호 뽑아 배열 채우기(중복X)
        Random rn = new Random();
        // 2.1) i번째 로또 뽑기(for)
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = rn.nextInt(45) + 1;
            // 2.2) i번째 전의 로또들과 비교(for)해서 같으면 i--로 초기화, break로 i다시 시작
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    --i;
                    break;
                }
            }
        }
        // ※ 2. 최대 최소
        // 3) 최대, 최솟값 찾기
        // 3.1) 최초의 최대, 최소 설정
        int max = lotto[0], min = lotto[0];
        // 3.2) 현재의 값이랑 최대, 최소 비교
        // 3.3)(최대)현재 값 > 현재 최대 면 현재최대=현재값 으로
        for (int i = 1; i < lotto.length; i++) {
            if (lotto[i] > max) max = lotto[i];
            if (lotto[i] < min) min = lotto[i];
        }
        // 4) 출력
        System.out.println("로또 결과: " + Arrays.toString(lotto));
        System.out.printf("최대: %d, 최소: %d", max, min);
    } //main
} //class
