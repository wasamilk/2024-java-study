package design.facade;

public class Reader {
    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect(){
        String msg = String.format("Reader %s 로 연결", fileName);
        System.out.println(msg);
    }

    public void fileRead(){
        String msg = String.format("Reader %s 의 내용을 Read", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect(){
        String msg = String.format("Reader %s 의 연결을 종료", fileName);
        System.out.println(msg);
    }
}
