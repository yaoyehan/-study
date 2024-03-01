import javax.naming.Name;

public class Son extends father {
    private String name;

    static {

        System.out.println("--子类的静态代码块--");
    }

    {
        System.out.println("--子类的非静态代码块--");
    }

    Son() {
        System.out.println("--子类的无参构造函数--");
    }

    Son(String name) {
        this();
        this.name = name;
        System.out.println("--子类的有参构造函数--" + this.name);
    }

    @Override
    protected void speak(int a,int b) {
        System.out.println("--子类Override了父类的方法--");
    }



    public static void main(String[] args) {
        System.out.println("--子类主程序--");
        Son son = new Son("儿子的名字");



    }
}