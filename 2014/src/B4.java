import java.util.Scanner;
public class B4 {
    static int [][] data;
    private static int n;
    private static int m;
    private static int k;
    private static int Mod=1000000007;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        data=new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j]=sc.nextInt();
            }
        }
        for (int i = 0; i < 51; i++) {
            for (int j = 0; j < 51; j++) {
                for (int l = 0; l < 14; l++) {
                    for (int o = 0; o < 14; o++) {
                        cache[i][j][l][o]=-1;
                    }
                }
            }
        }
        long ans=dfs(0,0,-1,0);
        System.out.println(ans);
    }
    //记忆数组
    static long cache[][][][] =new long[51][51][14][14];
    private static long dfs(int x, int y, int max, int cnt) {
        if(cache[x][y][max+1][cnt]!=-1)
            return cache[x][y][max+1][cnt];
        if(x==n||y==m||cnt>k)return 0;
        int cur=data[x][y];
        int ans=0;
        if(x==n-1&&y==m-1){
            if(cnt==k||(cnt==k-1&&cur>max)){
                return 1;
            }
            return ans;
        }
        if(cur>max){
            ans+=dfs(x,y+1,cur,cnt+1);
            ans+=dfs(x+1,y,cur,cnt+1);
        }//不拿或者拿不了时
        ans+=dfs(x,y+1,max,cnt);
        ans+=dfs(x+1,y,max,cnt);
        cache[x][y][max+1][cnt]=ans%Mod;
        return ans%Mod;
    }
}