public class A2 {
    static int ans;
    static void f (int n ,int step){
        if(n<0)
            return;
        if(n==0&&step%2==0){
            ans++;
        }
        f(n-1,step+1);
        f(n-2,step+1);
    }

    public static void main(String[] args) {
        f(39,0);
        System.out.println(ans);

    }
}
