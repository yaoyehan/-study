import java.util.Scanner;

public class B2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        scanner.nextLine();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=scanner.nextInt();
        }
        int m=0;
        boolean count=false;
        do{
            for (int i = 0; i < n; i++) {
                if(i==0)
                    a[i]=a[i]/2+a[n-1]/2;
                else a[i]=a[i]/2+a[i-1]/2;
            }
            for (int i = 0; i < n; i++) {
                if(a[i]%2!=0){
                    a[i]=a[i]+1;
                    m=m+1;
                }
            }
            int t=a[0];
            for (int i = 0; i < n; i++) {
                if(a[1]!=t)break;
                else count=true;
            }
        }while (!count);
        System.out.println(m);
    }
}
