public class B1 {
    static int n;
    static int pf=1;
    static int d;
    static int l;
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            n=pf+n;
            pow();
        }
        d=n+2;
        System.out.println(d);
    }
    static void pow(){
        pf=pf*2;
    }
}
