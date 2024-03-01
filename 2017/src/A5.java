import java.util.Scanner;

public class A5 {
    static  int n ,g;
    static int[] a=new int[101];
    static boolean[] f=new boolean[10000];
    static int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        f[0]=true;
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
            if(i==1)g=a[i];
            else g=gcd(a[i],g);
            for (int j = 0; j < 10000-a[i]; j++) {
                if(f[j])f[j+a[i]]=true;
            }
        }
        if(g==1){
            System.out.println("INF");
        }
        int ans=0;
        for (int i = 0; i < 10000; i++) {
            if(!f[i]){
                ans++;
            }
        }
        System.out.println(ans);
    }

}
