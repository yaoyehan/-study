import java.util.HashSet;
import java.util.Set;
import java.util.zip.Adler32;

public class A1 {
    static void f(int[]arr,int k){
        if(k==4){
            check(arr);
        }
        for (int i = k; i < 4; i++) {
            int t=arr[k];
            arr[k]=arr[i];
            arr[i]=t;
            //移交下一层去确认K+1位
            f(arr,k+1);
            t=arr[k];
            arr[k]=arr[i];
            arr[i]=t;
        }
    }
    static Set<Integer> set=new HashSet<Integer>();
    private static void check(int[] arr) {
        int x=arr[0]*1000+arr[1]*100+arr[2]*10+arr[3];
        boolean flag=true;
        for(int i=2;i<=Math.sqrt(x);i++) {
            if (x % i == 0) {
                flag = false;
                System.out.println(x + "not");
                break;
            }
        }
            if(flag){
                set.add(x);
                System.out.println(x+"true");
            }
    }

    public static void main(String args[]){
        int[] arr={1,4,9,8};
        f(arr,0);
        System.out.println(set.size());
    }
}
