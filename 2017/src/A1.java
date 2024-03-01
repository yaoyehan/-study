import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class A1 {

    static String []data=new String[10];
    static int ans;
    static int[][] vis=new int[10][10];

    public A1() {

    }

    static boolean solve(int i,int j){
        if(i<0||i>9||j<0||j>9){
            return true;
        }
        if(vis[i][j]==-1){
            return false;
        }
        vis[i][j]=-1;
        switch (data[i].charAt(j)){
            case 'U':
                return solve(i-1,j);
            case 'D':
                return solve(i+1,j);
            case 'R':
                return solve(i,j+1);
            case 'L':
                return solve(i,j-1);
            default:return false;
        }
    }
    private static void clear(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                vis[i][j]=0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
