package design.facade;

public class Writer {
    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect(){
        String msg = String.format("Writer %s 로 연결", fileName);
        System.out.println(msg);
    }

    public void fileWrite(){
        String msg = String.format("Writer %s 로 내용을 Write", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect(){
        String msg = String.format("Writer %s 의 연결을 종료", fileName);
        System.out.println(msg);
    }
}
