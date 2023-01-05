package z_extra;

import java.util.Arrays;
import java.util.Random;

public class ArraySort02 {
    // *** 오름차순, 내림차순 정렬 매서드 만들기
    // 1) 로또 중복 검사 매서드
    public void myMul(int[] arr) {
        Random rn = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rn.nextInt(45) + 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    --i;
                    break;
                }
            }
        }
        System.out.println("중복 검사 후 로또: " + Arrays.toString(arr));
    } //Mul

    // 2) 오름, 내림 한번에 작성한 매서드
    public void mySort(int[] arr, String sort) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (("asc".equals(sort) && arr[i] > arr[j]) || ("desc".equals(sort) && arr[i] > arr[j])) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    } //Sort

    public static void main(String[] args) {
        int[] lotto = new int[6];

        ArraySort02 lotto2 = new ArraySort02();
        // 1. 중복 제거 후 로또 출력 매서드
        lotto2.myMul(lotto);
        // 2. 오름차순 정렬 매서드 실행
        lotto2.mySort(lotto, "asc");
        System.out.println("오름차순: " + Arrays.toString(lotto));
        // 3. 내림차순 정렬 매서드 실행
        lotto2.mySort(lotto, "desc");
        System.out.println("내림차순: " + Arrays.toString(lotto));
        //============================================================================================//
        // *** 팩토리얼 연산(매서드의 재귀 호출)
        System.out.println("팩토리얼 연산 출력"+factorial(5));
    } //main
//------------------------------------------------------------------------------------------------//
    public static int factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }
} //class
