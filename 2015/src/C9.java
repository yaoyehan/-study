import java.util.*;

public class C9 {
    static int[] op=new int[7];
    static long[][] dp=new long[2][7];
    static long mod=1000000007;
    static boolean[][] conflict=new boolean[7][7];
    static void init(){
        op[1]=4;
        op[4]=1;
        op[2]=5;
        op[5]=2;
        op[3]=6;
        op[6]=3;
    }

    public static void main(String[] args) {
        init();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            conflict[x][y] = true;
            conflict[y][x] = true;
        }
        for (int i = 1; i <=6 ; i++) {
            dp[0][i]=1;
        }
        long ans = 1;
        int cur=0;
        for (int level = 2; level <=n ; level++) {
            cur=1-cur;
            for (int j = 1; j <= 6; j++) {
                dp[cur][j]=0;
                for (int i = 0; i <= 6; i++) {
                    if(conflict[op[j]][i])continue;
                    dp[cur][j]=(dp[cur][j]+dp[1-cur][i])%mod;
                }
            }
        }
        long sum=0;
        for (int i = 1; i <= 6; i++) {
            sum=(sum+dp[cur][i])%mod;
        }
        int p=n;
        long tmp=4;
        while (p!=0){
            if((p&1)==1)
                ans=(ans*tmp)%mod;
            tmp=(tmp*tmp)%mod;
            p>>=1;
        }
        System.out.println((sum*ans)%mod);
    }
}
