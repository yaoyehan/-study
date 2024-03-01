package proxy;

public class Test {
    public static void main(String[] args) {
        IHello hello = new ProxyHello(new Hello());
        hello.sayHello("明天");
    }
}