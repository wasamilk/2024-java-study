package TestPkg;

import java.util.Scanner;

public class TestPrint extends Test {

    public void test() {
        this.basic();
    }

    private void basic() {
        System.out.println("\nbasic -------------");

        /* 출력 테스트 */
        int num1 = 10;
        System.out.printf("num1 : %d\n", num1);
        System.out.printf("num1 : %d%n", num1); // OS마다 줄바꿈이 다를 수 있으므로 %n 사용이 안전
        System.out.println("num1 : " + num1);

        System.out.println("num1 : " + num1);
        System.out.printf("num1 : %d", num1);

        /* 입력 테스트 */
        // 최신 방법은 Console
        System.out.println("\n\n --- 입력 테스트 --- ");
        System.out.println("숫자 입력 : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("입력한 숫자(String) : " + input);
        System.out.println("입력한 숫자(int) : " + Integer.parseInt(input));
        System.out.println("입력한 숫자(float) : " + Float.parseFloat(input));
    }


}