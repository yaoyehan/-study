public class A3 {
    static int f(String r1,String r2){
        char[] c1=r1.toCharArray();
        char[] c2=r2.toCharArray();
        int [][] a=new int[c1.length+1][c2.length+1];
        int max=0;
        for (int i = 1; i < c1.length; i++) {
            for (int j = 1; j < c2.length; j++) {
                if(c1[i-1]==c2[j-1]){
                    a[i][j]=a[i-1][j-1]+1;
                    if(a[i][j]>max){
                        max=a[i][j];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n=f("deeac","aeac");
        System.out.println(n);
    }
}
