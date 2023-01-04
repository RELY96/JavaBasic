package z_extra;

import java.util.Arrays;
import java.util.Random;

public class ArraySort {
    public static void main(String[] args) {
        // * Arrays(배열 Wrapper Class) 자주 쓰는 매서드 : toString(), sort(), equals(ㅁ,ㅁ)...
        int[] lotto = new int[6];
        Random rn = new Random();
        for (int i = 0; i < lotto.length; i++) {
            lotto[i] = rn.nextInt(45) + 1;
            for (int j = 0; j < i; j++) {
                if (lotto[i] == lotto[j]) {
                    --i;
                    break;
                }
            }
        }
        // ※ 1. 오름차순 정렬(==min), 더 작은 수가 배열 자리에 오게 바꾸기
        for (int i = 0; i < lotto.length; i++) {
            for (int j = i + 1; j < lotto.length; j++) {
                if (lotto[i] > lotto[j]) {
                    int tmp = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = tmp;
                }
            }
        }
        System.out.println("오름차순 정렬: " + Arrays.toString(lotto));
        // ※ sort 매서드 이용 정렬
        Arrays.sort(lotto);
        System.out.println("오름차순 정렬: " + Arrays.toString(lotto));

        // ※ 2. 내림차순 정렬(==max)
        for (int i = 0; i < lotto.length; i++) {
            for (int j = i + 1; j < lotto.length; j++) {
                if (lotto[i] < lotto[j]) {
                    int tmp = lotto[i];
                    lotto[i] = lotto[j];
                    lotto[j] = tmp;
                }
            }
        }
        System.out.println("내림차순 정렬: " + Arrays.toString(lotto));
        //========================================================================================//
        // *** shuffle
        // 1. 랜덤 배열 섞기(100번) - [0]과 100번 섞기
        // 1) 배열 정의, 초기화(0~9)
        int[] shuffle = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 2) 배열 100번 섞기(random매서드는 실수라 int형변환)
        for (int i = 0; i < 100; i++) { //섞는 수 일뿐
            int num = (int) (Math.random() * 10); //num은 배열 위치
            int temp = shuffle[0];
            shuffle[0] = shuffle[num];
            shuffle[num] = temp;
        }
        System.out.println("배열: "+Arrays.toString(shuffle));
    } //main
} //class
