import java.util.Scanner;

public class A9 {

    private static int[] a;
    static int k=1;
    static int count=0;
    private static int n;

    static void f(){
        for (int i = 0; i < n; i++){
            if (a[i] == k) {
                if (i == k - 1) {
                    k++;
                    continue;
                } else {
                    int t = a[k - 1];
                    a[k - 1] = a[i];
                    a[i] = t;
                    k++;
                    count += 1;
                    f();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        f();
        System.out.println(count);
    }
}


