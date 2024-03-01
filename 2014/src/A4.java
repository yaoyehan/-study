import javax.swing.*;
import java.util.HashSet;

public class A4 {
    static int[]a={1,2,3,4,5,6,7,8,9};
    static int ans;
    static void f(int k){
        if(k==9){
            for (int i = 1; i <=8; i++) {
                int x1=a2i(0,i);
                int x2=a2i(i,9);
                if(check(x1,x2))
                ans++;
            }
        }
        for (int i = k; i <=8; i++) { int t=a[i];a[i]=a[k];a[k]=t;f(k+1);t=a[i];a[i]=a[k];a[k]=t; }

    }

    private static int a2i(int i,int j) {
        int ans=0;
        int p=1;
        for (int k = j-1; k >=i; k--) {
            ans+=a[k]*p;
            p=p*10;
        }
        return ans;
    }

    private static boolean check(int x1,int x2) {
        int x=x1*x2;
        String xs =x+"";
        if(xs.length()!=9||xs.contains("0"))
            return false;
        HashSet<Object> objects = new HashSet<>();
        for (int i = 0; i < xs.length(); i++) {
            objects.add(xs.charAt(i));
        }
        if(objects.size()==9){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        f(0);
        System.out.println(ans/2);
    }
}
