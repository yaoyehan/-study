import java.util.Scanner;

public class A9 {
private static int n;
private static long s;
private static long a;
private static long b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextLong();
        a = scanner.nextLong();
        b = scanner.nextLong();
        int t=n*(n-1)/2;
        int[] dp = new int[t + 1];
        dp[0]=1;
        for (int i = 1; i <= n-1; i++) {
            for (int j = i*(i+1)/2; j >=i ; j--) {
                dp[j]=(dp[j]+dp[j-i])%100000007;
            }
        }
        long ans=0;
        for (int i = 0; i <=t ; i++) {
            if((s-i*a+(t-i)*b)%n==0){
                ans=(ans+dp[i])%100000007;
            }
        }System.out.println(ans);
    }
}
