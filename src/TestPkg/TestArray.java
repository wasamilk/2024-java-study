package TestPkg;

import java.util.Arrays;

public class TestArray extends Test {
    public void test() {
//        this.basic();
        this.sumAndAvgByArr();
        this.maxAndMin();
        this.shuffle();
        this.setRandomValue();
        this.counting();
    }

    /* basic */
    private void basic() {
        System.out.println("\nbasic -------------");
        /* 배열 선언 두가지 방법 */
        int[] scoreA = new int[5];
        int scoreB[] = new int[5];

        int[] zeroArr = new int[0]; // 배열의 길이는 0일수도 있다.

        /* 배열 초기화 */
        int[] initArr1; // 배열(참조변수) 선언
        initArr1 = new int[5]; // 저장공간 생성 dafault value = data type의 기본값
        int[] initArr2 = new int[]{11, 22, 33, 44, 55}; // 생성 시 초기화도 가능
        int[] initArr3 = {11, 22, 33, 44, 55}; // new 연산자 생략 가능


        // 배열.length는 상수다. readOnly
        for (int i = 0; i < scoreA.length; i++) {
            scoreA[i] = i * 10;
            System.out.println("scoreA[" + i + "] - " + scoreA[i]);
        }

        /* 유용한 배열 함수 */
        // 배열 전체값 출력
        System.out.println("scoreA[] - " + Arrays.toString(scoreA));
        // 배열 복사
        int[] originArr = {10, 20, 30};
        int[] copyArr = new int[originArr.length * 2];
        System.arraycopy(originArr, 0, copyArr, 3, originArr.length);
        System.out.println("originArr[] - " + Arrays.toString(originArr));
        System.out.println("copyArr[] - " + Arrays.toString(copyArr));
    }

    /* 총합과 평균 */
    private void sumAndAvgByArr() {
        System.out.println("\nsumAndAvgByArr -------------");
        int sum = 0;
        float avg = 0f;

        int[] score = {100, 88, 100, 100, 90};

        for (int i = 0; i < score.length; i++) {
            sum += score[i];
        }
        avg = sum / (float) score.length;

        System.out.println("sum - " + sum);
        System.out.println("avg - " + avg);
    }

    /* 최대값과 최소값 */
    private void maxAndMin() {
        System.out.println("\nmaxAndMin -------------");
        int[] score = {25, 89, 100, 1, 35, 60, 20};
        int max = score[0];
        int min = score[0];

        for (int i = 0; i < score.length; i++) {
            max = score[i] > max ? score[i] : max;
            min = score[i] < min ? score[i] : min;
        }

        System.out.println("max - " + max);
        System.out.println("min - " + min);
    }

    /* 섞기 */
    private void shuffle() {
        System.out.println("\nshuffle -------------");
        int[] numArr = new int[10];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = i;
        }
        System.out.println("originArr[] - " + Arrays.toString(numArr));

        for (int j = 0; j < 100; j++) {
            int index = (int) (Math.random() * 10);
            int tmp = numArr[0];
            numArr[0] = numArr[index];
            numArr[index] = tmp;
        }
        System.out.println("suffleArr[] - " + Arrays.toString(numArr));
    }

    /* 임의의 값으로 배열 채우기 */
    private void setRandomValue() {
        System.out.println("\nsetRandomValue -------------");
        int[] code = {-4, -1, 3, 2, 1};
        int[] randomArr = new int[10];

        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = code[(int) (Math.random() * code.length)];
        }
        System.out.println("suffleArr[] - " + Arrays.toString(randomArr));
    }

    /* 빈도수 구하기 */
    private void counting() {
        System.out.println("\ncounting -------------");

        int[] randomArr = new int[10];
        int[] countArr = new int[10];
        for (int i = 0; i < randomArr.length; i++) {
            randomArr[i] = (int) (Math.random() * randomArr.length);
        }

        for (int i = 0; i < randomArr.length; i++) {
            countArr[randomArr[i]]++;
        }

        System.out.println("randomArr[] - " + Arrays.toString(randomArr));

        for (int i = 0; i < randomArr.length; i++) {
            System.out.println(i + "의 개수 - " + countArr[i]);
        }
    }
}
