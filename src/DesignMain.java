import design.adapter.*;
import design.aop.AopBrowser;
import design.decorator.*;
import design.facade.Ftp;
import design.facade.Reader;
import design.facade.SftpClient;
import design.facade.Writer;
import design.observer.Button;
import design.observer.IButtonListener;
import design.proxy.Browser;
import design.proxy.BrowserProxy;
import design.proxy.IBrowser;
import design.singleton.AClazz;
import design.singleton.BClazz;
import design.singleton.SocketClient;
import design.strategy.Base64Strategy;
import design.strategy.Encoder;
import design.strategy.EncodingStrategy;
import design.strategy.NormalStrategy;

import java.util.concurrent.atomic.AtomicLong;

public class DesignMain {
    public static void main(String[] args) {
        testSingleton();
        testAdapter();
        testProxy();
        testDecorator();
        testObserver();
        testFacade();
        testStrategy();
    }

    /*
     * 싱글톤 패턴 테스트
     * */
    private static void testSingleton() {
        System.out.println("\n싱글톤 패턴 테스트 ------ ");
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("Q) 싱글톤 패턴으로 get 한 두 객체는 동일한가? ");
        System.out.println("A) " + aClient.equals(bClient));
    }

    /*
     * 어댑터 패턴 테스트
     * */
    private static void testAdapter() {
        System.out.println("\n어댑터 패턴 테스트 ------ ");
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        // connect(Cleaner);
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);
    }

    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }

    /*
     * 프록시 패턴 테스트
     * */
    private static void testProxy() {
        System.out.println("\n프록시 패턴 테스트 ------ ");
        // 캐시기능 없이 매번 새로 로딩
        IBrowser browserNoCache = new Browser("www.naver.com");
        browserNoCache.show();
        browserNoCache.show();
        browserNoCache.show();

        // 캐시기능으로 로딩
        IBrowser browserWithCache = new BrowserProxy("www.naver.com");
        browserWithCache.show();
        browserWithCache.show();
        browserWithCache.show();

//        testAop();
    }
    public static void testAop(){
        // AtomicLong ??
        //  Thread-safe로 구현되어 멀티쓰레드에서 synchronized 없이 사용할 수 있다.
        //  또한 synchronized 보다 적은 비용으로 동시성을 보장할 수 있습니다.
        //      (참고) https://simgee.tistory.com/37
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );
        aopBrowser.show();
        System.out.println("loading time : " + end.get());
        aopBrowser.show();
        System.out.println("loading time : " + end.get());
    }

    /*
     *  데코레이터 패턴 테스트
     * */
    private static void testDecorator() {
        System.out.println("\n데코레이터 패턴 테스트 ------ ");
        ICar audi = new Audi(1000);
        audi.showPrice();

        // a3
        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();

        // a4
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();

        // a5
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();
    }
    
    /*
     *  옵저버 패턴 테스트
     * */
    private static void testObserver() {
        System.out.println("\n옵저버 패턴 테스트 ------ ");

        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("메세지 전달 - click1");
        button.click("메세지 전달 - click2");
        button.click("메세지 전달 - click3");
    }

    /*
     * 파사드 패턴 테스트
     * */
    private static void testFacade() {
        System.out.println("\n파사드 패턴 테스트 ------ ");

        Ftp ftpClient = new Ftp("www.wb.co.kr", 423, "/home/file");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("test.txt");
        writer.fileConnect();
        writer.fileWrite();

        Reader reader = new Reader("test.txt");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        // 파사드 패턴으로 변경해서 재연결
        System.out.println("-- 파사드 패턴으로 변경해서 재연결");
        SftpClient sftpClient = new SftpClient("www.wb.co.kr", 423, "/home/file", "test.txt");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
    }
    /*
     *  전략 패턴 테스트
     * */
    private static void testStrategy() {
        System.out.println("\n전략 패턴 테스트 ------ ");
        Encoder encoder = new Encoder();

        // base64
        EncodingStrategy base64 = new Base64Strategy();
        // normal
        EncodingStrategy normal = new NormalStrategy();

        String message = "Hello Java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println("base64Result - " + base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println("normalResult - " + normalResult);

    }
}