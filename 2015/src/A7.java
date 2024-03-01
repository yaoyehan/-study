import java.util.Arrays;

public class A7 {
    static int a[]={0,0,0,0,0,0,0,1,1,1,1,1};
    static int ans=0;
    static boolean[] vis=new boolean[12];
    static int[] path=new int[12];
    static void f(int k,int path[]){
        if(k==12) {
            if (check(path)) {
                ans++;
            }
        }
        for (int i = 0; i < 12; i++) {
            if(i>0&&a[i]==a[i-1]&&!vis[i-1])//现在准备选取的元素和上一个元素相同，但是上一个元素还没被使用
                continue;
            if(!vis[i]){//没有被用过的元素可以被抓到path里面
                vis[i]=true;//标记为已访问
                path[k]=a[i];//将a[i]填入到path[k]中
                f(k+1,path);//递归
                vis[i]=false;
        }
            }
        }

    private static boolean check(int []path) {
        int[][] g = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if(path[i*4+j]==1)g[i][j]=1;
                else g[i][j]=0;
            }
        }
        int count=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if(g[i][j]==1){
                    dfs(g,i,j);
                    count++;
            }
        }
    }
        return count==1;
}

    private static void dfs(int[][] g, int i, int j) {
        g[i][j]=0;
        if(i-1>=0&&g[i-1][j]==1)dfs(g,i-1,j);
        if(i+1<=2&&g[i+1][j]==1)dfs(g,i+1,j);
        if(j-1>=0&&g[i][j-1]==1)dfs(g,i,j-1);
        if(j+1<=3&&g[i][j+1]==1)dfs(g,i,j+1);
    }


    public static void main(String[] args) {
        f(0,path);
        System.out.println(ans);
    }
}