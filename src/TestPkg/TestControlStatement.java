package TestPkg;

public class TestControlStatement {
    public void testFor() {
        System.out.println(" --- testFor() --- ");

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
        System.out.println(" --- testWhile() --- ");

        int i = 0;
        while (i < 10) {
            System.out.println("while " + i);
            i++;
        }

        System.out.println();

    }
}
