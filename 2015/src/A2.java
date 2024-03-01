public class A2 {
    static int []arr={1,2,3,4,5,6,7,8,9};
    private static int a;
    private static int b;
    private static int c;

    public static void main(String[] args) {
        f(0);
    }
    static void f(int k){
        if(k==9){
            a=arr[0]*100+arr[1]*10+arr[2];
            b=arr[3]*100+arr[4]*10+arr[5];
            c=arr[6]*100+arr[7]*10+arr[8];
            if(2*a==b&&a+b==c){
                System.out.println("a="+a+"b="+b+"c="+c);
            }
        }
        for (int i = k; i < arr.length; i++) {
            int t=arr[i];
            arr[i]=arr[k];
            arr[k]=t;
            //移交下一层去确认K+1位
            f(k+1);
            t=arr[i];
            arr[i]=arr[k];
            arr[k]=t;
        }
    }
}
