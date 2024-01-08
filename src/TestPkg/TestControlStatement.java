package TestPkg;

public class TestControlStatement {
    public void enhancedFor() {
        int[] arr = {10, 20, 30,40, 50};

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
        
        // JDK 1.5부터 배열과 컬렉션에 저장된 요소를 아래와 같이 접근 가능
        for(int tmp : arr){
            System.out.print(tmp + "  ");
        }
    }
}
