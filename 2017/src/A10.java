import java.util.Arrays;
import java.util.Scanner;

public class A10 {
    private static int n;
    private static int ans;
    private static int N=10000;
    private static int[]X=new int[N<<1];
    private static Line[] lines;


    private static class Line implements Comparable<Line>{
        int x1,x2,h,f;//左右坐标，纵坐标高度，f=1为入边，f=-1为出边

        public Line(int x1, int x2, int h, int f) {
            this.x1 = x1;
            this.x2 = x2;
            this.h = h;
            this.f = f;
        }

        @Override
        public int compareTo(Line o) {
            if(h<o.h) return -1;
            else if(h>o.h) return 1;
            else return 0;
        }
    }
    private static class SegTree{
        int pl,pr,cnt,len;//左端点编号，右端点编号，被覆盖的次数，两个端点被覆盖的长度
        SegTree lson,rson;
    }
    private static void updateLength(SegTree pTree,int tl,int tr){
        if(pTree.cnt>0){
            pTree.len=X[tr]-X[tl-1];
        }else if(tl==tr){
            pTree.len=0;
        }else {//负数
            pTree.len=pTree.lson.len+pTree.rson.len;
        }
    }
    private static void update(SegTree tree,int pl,int pr,int value){
        int tl=tree.pl;
        int tr=tree.pr;
        if(pl<=tl&&pr>=tr){
            tree.cnt+=value;
            updateLength(tree,tl,tr);
            return;
        }
        int m=(tl+tr)>>1;
        if(pl<=m)update(tree.lson,pl,pr,value);
        if(pr>m)update(tree.rson,pl,pr,value);
        updateLength(tree,tl,tr);
    }
    private static SegTree buildTree(int pl,int pr){
        SegTree segTree = new SegTree();
        segTree.pl=pl;
        segTree.pr=pr;
        if(pl==pr)return segTree;
        int mid=((pl+pr)>>1);
        segTree.lson=buildTree(pl,mid);
        segTree.rson=buildTree(mid+1,pr);
        return segTree;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int index=0;
        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int y2 = scanner.nextInt();
            X[index]=x1;
            lines[index]=new Line(x1,x2,y1,1);//高度1
            index++;
            X[index]=x2;
            lines[index]=new Line(x1,x2,y2,-1);//高度2
            index++;
        }
        Arrays.sort(X);//所有横坐标排序
        Arrays.sort(lines);//扫描线排序，从高到低
        //离散化横坐标
        int X_end=unique(X);//去重返回值是一个迭代器，它指向的是去重后容器中不重复序列的最后一个元素
        //PR=X_end
        //初始化线段树
        SegTree root = buildTree(1, X_end);
        for (int i = 0; i < index; i++) {
            int pl = Arrays.binarySearch(X, 0,X_end+1,lines[i].x1);
            int pr = Arrays.binarySearch(X, 0,X_end+1,lines[i].x2);
            update(root,pl+1,pr,lines[i].f);
            ans+=root.len*(lines[i+1].h-lines[i].h);//宽度*高度
        }
        System.out.println(ans);
    }

    private static int unique(int[] x) {
        int index=0;
        for (int i = 0; i < x.length; i++) {
            if(x[i]==x[index])continue;
            else {
                index++;
                x[index]=x[i];
            }
        }
        return 0;
    }
}
