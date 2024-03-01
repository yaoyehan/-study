public class father {
    
    private String name;
    private String nameStatic;

    father(){
       System.out.println("--父类的无参构造函数--");
    }

    father(String name){
       this.name=name;
       System.out.println("--父类的有参构造函数--"+this.name);
    }

    static{
       System.out.println("--父类的静态代码块--");
    }

    {
       System.out.println("--父类的非静态代码块--");
    }

    protected void speak(int a,int b){
       System.out.println("--父类的方法--");
    }
    protected static void speakStatic(){

       System.out.println("--父类的静态方法--");
    }

    public static void main(String[] args) {
        System.out.println("--父类主程序--");
        father father=new father("父亲的名字");

     }
    
}