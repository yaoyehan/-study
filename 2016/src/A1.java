public class A1 {
    private static int[][] a;
    private static int vis[];
    private static int ans;
    public static void main(String[] args) {
        a=new int[5][6];
        vis=new int [10];
        init();
        f(1,2);
        System.out.println(ans);
    }
    static boolean check(int i, int j){
        for (int x = i-1; x <= i+1; x++) {
            for (int y = j-1; y <= j+1; y++) {
                if(Math.abs(a[x][y]-a[i][j])==1){
                    return false;
                }
            }

        }
        return true;
    }
    static void f(int x,int y) {
        if (x == 3 && y == 4) {
            ans++;
            return;
        }
        //从0~9中抓取一个
        for (int i = 0; i < 10; i++) {
            if (vis[i] == 0) {
                //i没被用过
                a[x][y] = i;
                if (!check(x, y)) {
                    a[x][y] = -10;
                    continue;
                }
                vis[i] = 1;//标记为已访问
                if (y == 4) {
                    f(x + 1, 1);
                } else f(x, y + 1);
                //回溯
                vis[i] = 0;
                a[x][y] = -10;
            }
        }
    }
        static void init(){
            for (int i = 0; i <5; i++) {
                for (int j = 0; j < 6; j++) {
                    a[i][j]=-10;
                }
            }
            for (int i = 0; i < 10; i++) {
                vis[i]=0;
            }
        }
}

