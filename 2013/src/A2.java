import java.util.concurrent.CountDownLatch;

public class A2 {
    private int Count;

    public static void main(String[] args) {
        A2 a2 = new A2();
        System.out.println(a2.f(0, 0));
    }

    private  int f(int i, int j) {
        if(i==3&&j==4){
            return 1;
        }
        if(i>3||j>4||i<0||j<0){
            return 0;
        }
        return f(i+1,j)+f(i,j+1)+f(i-1,j)+f(i,j-1);
    }

}
