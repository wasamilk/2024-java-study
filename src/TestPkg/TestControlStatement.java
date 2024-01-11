package TestPkg;

public class TestControlStatement extends Test {
    public void test() {
        this.testFor();
        this.testWhile();
    }

    public void testFor() {
        System.out.println("\ntestFor -------------");

        int[] arr = {10, 20, 30, 40, 50};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();

        // JDK 1.5부터 배열과 컬렉션에 저장된 요소를 아래와 같이 접근 가능
        for (int tmp : arr) {
            System.out.print(tmp + "  ");
        }
        System.out.println();
    }

    public void testWhile() {
        System.out.println("\ntestWhile -------------");

        int i = 0;
        while (i < 10) {
            System.out.println("while " + i);
            i++;
        }
        System.out.println();
    }
}
