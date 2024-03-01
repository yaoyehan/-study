public class A6 {
    static int ans=0;
    static int[] a = new int[10];
    static int count=0;
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            a[i]=i;
        }
        f(0);
        System.out.println(ans);
    }

    private static void f(int k) {
        if(k==10){
/*            count=0;
            for (int i = 0; i < 10; i++) {
                if(i==0){
                    if(a[i]<a[i+1]&&a[i]<a[i+2]){
                        count++;
                    }
                }
                if(i<=2&&i>0){
                    if(a[i]<a[i+2]&&a[i]<a[i+3]){
                        count++;
                    }
                }
                if(i<=5&&i>2){
                    if(a[i]<a[i+3]&&a[i]<a[i+4]){
                        count++;
                    }
                }
            }
            if(count==6)*/
                ans++;
            /*else return;*/
        }
        for (int i = k; i < a.length; i++) {
            int t=a[i];
            a[i]=a[k];
            a[k]=t;
            if(k==1&&a[1]<a[0]||
               k==2&&a[2]<a[0]||
               k==3&&a[3]<a[1]||
               k==4&&(a[4]<a[1]||a[4]<a[2])||
               k==5&&a[5]<a[2]||
               k==6&&a[6]<a[3]||
               k==7&&(a[7]<a[3]||a[7]<a[4])||
               k==8&&(a[8]<a[4]||a[8]<a[5])||
               k==9&&(a[9]<a[5])){
                t=a[i];
                a[i]=a[k];
                a[k]=t;
                continue;
            }
            f(k+1);
            t=a[i];
            a[i]=a[k];
            a[k]=t;
        }
    }
}
