package proxy;

public class ProxyHello implements IHello{
    private IHello hello;
    public ProxyHello(IHello hello) {
        super();
        this.hello = hello;
    }
    @Override
    public void sayHello(String str) {
        System.out.println("start"+str);// 添加特定的方法
        hello.sayHello(str);
        System.out.println("end"+str);
    }
}