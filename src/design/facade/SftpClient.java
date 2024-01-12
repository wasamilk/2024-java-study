package design.facade;

public class SftpClient {
    private Ftp ftpProtocol;
    private Reader fileReader;
    private Writer fileWriter;

    public SftpClient(String host, int port, String path, String fileName) {
        this.ftpProtocol = new Ftp(host, port, path);
        this.fileReader = new Reader(fileName);
        this.fileWriter = new Writer(fileName);
    }

    public void connect() {
        this.ftpProtocol.connect();
        this.ftpProtocol.moveDirectory();
        this.fileReader.fileConnect();
        this.fileWriter.fileConnect();

    }

    public void write() {
        this.fileWriter.fileWrite();
    }

    public void read() {
        this.fileReader.fileRead();
    }

    public void disConnect() {
        this.fileReader.fileDisconnect();
        this.fileWriter.fileDisconnect();
        this.ftpProtocol.disConnect();
    }
}
