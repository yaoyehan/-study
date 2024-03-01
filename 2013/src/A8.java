import java.awt.print.Printable;
import java.util.Scanner;
public class A8 {
    static int ans;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr={1,2,3};
        f(arr,0);
    }
    //确认某一排列的第k位
    private static void f(int[] arr,int k) {
        if(k==3){
            /*if(check(arr))ans++;*/
            print(arr);
        }
        for (int i = k; i < arr.length; i++) {
            int t=arr[i];
             arr[i]=arr[k];
            arr[k]=t;
            //移交下一层去确认K+1位
            f(arr,k+1);
            t=arr[i];
            arr[i]=arr[k];
            arr[k]=t;
        }
    }

    private static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static boolean check(int[] arr){
        return true;
    }
}
