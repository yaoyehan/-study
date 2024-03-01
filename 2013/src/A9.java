import com.sun.xml.internal.fastinfoset.util.CharArrayString;

import java.util.Scanner;

public class A9 {
    static int[][] g;
    static int[][]vis;
    static int n;
    static int m;
    static int total;
    private static int ans=Integer.MAX_VALUE;
    static void dfs(int i,int j,int steps,int sum){
        if(i<0||j<0||i>=n||j>=m||vis[i][j]==1)return;//走出边界或该点已走过，非法路径
        if(sum==total/2){
            ans=Math.min(ans,steps);
            return;
        }else if(sum>=total/2)return;
        vis[i][j]=1;
        dfs(i-1,j,steps+1,sum+g[i][j]);
        dfs(i+1,j,steps+1,sum+g[i][j]);
        dfs(i,j-1,steps+1,sum+g[i][j]);
        dfs(i,j+1,steps+1,sum+g[i][j]);
        vis[i][j]=0;
    }
    public static void main(String[] args) {
        //完成输入
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        g=new int[n][m];
        vis=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j]=scanner.nextInt();
                total+=g[i][j];
            }
        }
        dfs(0,0,0,0);
        System.out.println(ans);
    }
}
