package z_extra;

public class ArrayBasic {
    public static void main(String[] args) {
        // *** 배열
        // * 배열의 Wrapper 클래스 Arrays 활용 시 배열 쉽게 출력가능(ex: Arrays.toString(ㅁ))

        // 1. 명시적 선언 배열 합계 출력
        int score[] = new int[5];
        score[0] = 40;
        score[1] = 50;
        score[2] = 60;
        score[3] = 70;
        score[4] = 80;

        int sum = 0;
        for (int i = 0; i <= score.length - 1; i++) {
            sum += score[i];
            System.out.printf("%d번째, %d점 \n", i + 1, score[i]);
        }
        System.out.println("총 합계:" + sum);
        //------------------------------------------------------------------------------------//
        // 2. 묵시적 선언 배열 합계 출력
        // 1) eachFor문 사용
        int[] score2 = {40, 50, 60, 70, 80};
        sum = 0;
        for (int s : score2) {
            System.out.println("점수: " + s);
            sum += s;
        }
        System.out.println("합계: " + sum);

        //==============================================================================================//
        // *** 다차원 배열
        // 1. 2차원 배열 묵시적 선언으로 출력
        int[][] mul = {{10, 20, 30}, {60, 50}, {100, 90, 80, 70}}; //[3][3,2,4]
        for (int i = 0; i < mul.length; i++) {
            for (int j = 0; j < mul[i].length; j++) {
                System.out.printf("mul[%d],[%d]=%d", i, j, mul[i][j]);
            }
        }
    } //main
} //class
