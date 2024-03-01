import java.util.Scanner;

public class A10 {
    static String s ;
    private static int lcs(String s1, String s2, int length) {
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            if(s1.charAt(i)==s2.charAt(0))dp[0][i]=1;
            else dp[0][i]=(i==0?0:dp[0][i-1]);
        }
        for (int i = 0; i < length; i++) {
            if(s2.charAt(i)==s1.charAt(0))dp[i][0]=1;
            else dp[i][0]=(i==0)?0:dp[i-1][0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = 1; j < length; j++) {
                if(s2.charAt(i)==s1.charAt(j))dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[length-1][length-1];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int length = s.length();
        int l=lcs(s,new StringBuilder(s).reverse().toString(),length);
        System.out.println(length-l);
    }


}
