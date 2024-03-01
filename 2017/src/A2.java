import java.util.concurrent.CountDownLatch;

public class A2 {
    static int ans;
    static int [][]dire={{1,0},{-1,0},{0,1},{0,-1}};
    static int [][] vis=new int[7][7];
    static void dfs(int x,int y){
        if(x==0||x==6||y==0||y==6){
            ans++;
            return;
        }
        vis[x][y]=1;
        vis[6-x][6-y]=1;
        for (int k = 0; k < 4; k++) {
            int nx = x + dire[k][0];
            int ny = y + dire[k][1];
            if (0 == vis[nx][ny]) {
                dfs(nx, ny);
            }
        }
            vis[x][y]=0;
            vis[6-x][6-y]=0;
    }


    public static void main(String[] args) {
        dfs(3,3);
        System.out.println(ans/4);
    }
}
