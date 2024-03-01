import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A10 {
    private static int n;
    private static List<Node>[] g;
    private static long max=-1;
    private static int pnt=-1;
    static long dis2money(long dis){
        return 11*dis+dis*(dis-1)/2;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
         n = sc.nextInt();
         g=new List[n+1];
        for (int i = 0; i <=n ; i++) {
            g[i]=new ArrayList<Node>();
        }
        for (int i = 0; i < n-1; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            long c=sc.nextInt();
            g[a].add(new Node(b,c));
            g[b].add(new Node(a,c));
        }
        //以1为根找出端点
        dfs(1,1,0);
        dfs(pnt,pnt,0);
        System.out.println(dis2money(max));
    }

    /**
     *
     * @param from 来自上一个点，from是编号
     * @param num 当前的点
     * @param dis 历史上积累的距离
     */
    private static void dfs(int from,int num,long dis) {
        boolean isLeaf=true;
        List<Node> neighbors=g[num];
        for (int i = 0; i <neighbors.size() ; i++) {
            Node neighbor = neighbors.get(i);
            if(neighbor.num==from)continue;
            isLeaf=false;
            dfs(num,neighbor.num,dis+neighbor.dis);
        }
        if(isLeaf&&dis>max)//是叶子节点
        {
            max=dis;
            pnt=num;
        }
    }

    static class Node{
        int num;
        long dis;

        public Node(int num, long dis) {
            this.num = num;
            this.dis = dis;
        }
    }
}
