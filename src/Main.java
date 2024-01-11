import TestPkg.TestArray;
import TestPkg.TestControlStatement;
import TestPkg.TestPrint;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world main~~!\n");

//        TestPrint print = new TestPrint();
//        print.test();

//        TestControlStatement control = new TestControlStatement();
//        control.test();

        TestArray testArray = new TestArray();
        testArray.test();

    }
}