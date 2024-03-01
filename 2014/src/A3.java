import javax.swing.*;
import java.util.Arrays;

public class A3 {
    static int []a={2,4,5,6,7,9,10,11,12};
    static void f(int k){
        if(k==9){
            check();
            return;
        }
        for (int i = k; i < 9; i++) {
            int t=a[i];
            a[i]=a[k];
            a[k]=t;
            f(k+1);
            int tt=a[i];
            a[i]=a[k];
            a[k]=tt;
        }
    }

    private static void check() {
        int r1=1+a[8]+a[7]+a[6];
        int r2=1+a[0]+a[2]+a[3];
        int r3=a[3]+a[4]+a[5]+a[6];
        int r4=a[1]+a[0]+a[8]+8;
        int r5=8+3+a[7]+a[5];
        int r6=3+a[1]+a[2]+a[4];
        if(r1==r2&&r2==r3&&r3==r4&&r4==r5&&r5==r6){
            System.out.println(a[7]);
        }
    }

    public static void main(String[] args) {
        f(0);
    }
}
