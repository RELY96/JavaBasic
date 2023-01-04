package z_extra;

public class LoopStarBasic {
    public static void main(String[] args) {
        // *** 2차원 별찍기
        // ※ 1. 반삼각형(9줄)
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // ※ 2. 피라미드(15줄)
        // 1) 위에서 아래로, 열에서 행으로, 세로로
        // 2) line-행 까지 공백(시작 위치까지 잡힘)
        // 3) 별 갯수 : 행*2-1 (1행일때 1개, 2행일때3개...)
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 15 - i; j++) {
                System.out.print(" ");
            }
            for (int s = 1; s <= (2 * i) - 1; s++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // ※ 2-2. 역피라미드(감소)
        for (int i = 15; i >= 1; i--) {
            for (int j = 1; j <= 15 - i; j++) {
                System.out.print(" ");
            }
            for (int s = 1; s <= (2 * i) - 1; s++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // ※ 3. 다이아몬드
        // 1) 상부출력 피라미드와 같음
        // 2) 하부출력 피라미드 역으로 -> 감소
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 15 - i; j++) {
                System.out.print(" ");
            }
            for (int s = 1; s <= (2 * i) - 1; s++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 15 - 1; i >= 1; i--) {
            for (int j = 1; j <= 15 - i; j++) {
                System.out.print(" ");
            }
            for (int s = 1; s <= (2 * i) - 1; s++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // ※ 4. 모래시계
        // 1) 다이아몬드 반대로
        for (int i = 15; i >= 1; i--) {
            for (int j = 1; j <= 15 - i; j++) {
                System.out.print(" ");
            }
            for (int s = 1; s <= (2 * i) - 1; s++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 15 - i; j++) {
                System.out.print(" ");
            }
            for (int s = 2; s <= (2 * i) - 1; s++) {
                System.out.print("*");
            }
            System.out.println();
        }
        // * line변수 이용하면 확장형 가능
    } //main
} //class
