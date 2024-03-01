import java.math.BigInteger;
import java.util.Scanner;

public class A8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n,m,p;
        n = scanner.nextLong();
        m = scanner.nextLong();
        p = scanner.nextLong();
        BigInteger bigP = BigInteger.valueOf(p);
        //由Sn=f(n+2)-1,可知当m>n+2时，对f(m)取模后得到原数
        if(m>=n+2){
            BigInteger ans=fib(n+2,bigP);
            System.out.println(ans.mod(bigP).longValue()-1);
        } else {
            BigInteger fibm=fib(m);
            BigInteger ans=fib(n+2,fibm);
            System.out.println(ans.mod(fibm).mod(bigP).longValue()-1);
        }
    }

    private static BigInteger fib(long m) {
        BigInteger[][] ans=mPow(m-2);
        return ans[0][0].add(ans[1][0]);
    }

    private static BigInteger fib(long m, BigInteger mod) {
        BigInteger[][] ans=mPow(m-2,mod);
        return ans[0][0].add(ans[1][0]);
    }

    private static BigInteger[][] mPow(long n) {
        BigInteger[][] a={
                {
                    BigInteger.ONE,BigInteger.ONE
                },
                {
                    BigInteger.ONE,BigInteger.ZERO
                }
        };
        BigInteger[][] ans={
                {
                    BigInteger.ONE,BigInteger.ONE
                },
                {
                    BigInteger.ZERO,BigInteger.ZERO
                }
        };
        while (n!=0){
            if((n&1)==1){
                //用t1,t2保存ans[0][0]和[1][0]变化前的数值
                BigInteger t1=ans[0][0];
                BigInteger t2=ans[1][0];
                ans[0][0]=ans[0][0].multiply(a[0][0]).add(ans[0][1].multiply(a[1][0]));
                ans[0][1]=t1.multiply(a[0][1]).add(ans[0][1].multiply(a[1][1]));
                ans[1][0]=ans[1][0].multiply(a[0][0]).add(ans[1][1].multiply(a[1][0]));
                ans[1][1]=t2.multiply(a[0][1]).add(ans[1][1].multiply(a[1][1]));
            }
            //将平方次数转化为二进制，如10为0101遇到1就用ans矩阵*a矩阵，遇到0则a矩阵平方
            BigInteger t1=a[0][0];
            BigInteger t2=a[1][0];
            BigInteger t3=a[0][1];
            a[0][0]=a[0][0].multiply(a[0][0]).add(a[0][1].multiply(a[1][0]));
            a[0][1]=t1.multiply(a[0][1]).add(a[0][1].multiply(a[1][1]));
            a[1][0]=a[1][0].multiply(t1).add(a[1][1].multiply(a[1][0]));
            a[1][1]=t2.multiply(t3).add(a[1][1].multiply(a[1][1]));
            //转化为二进制，并向左推进一位
            n>>=1;
        }
        return ans;
    }

    private static BigInteger[][] mPow(long n, BigInteger mod) {
        BigInteger[][] a={
                {
                        BigInteger.ONE,BigInteger.ONE
                },
                {
                        BigInteger.ONE,BigInteger.ZERO
                }
        };
        BigInteger[][] ans={
                {
                        BigInteger.ONE,BigInteger.ONE
                },
                {
                        BigInteger.ZERO,BigInteger.ZERO
                }
        };
        while (n!=0){
            if((n&1)==1){
                //用t1,t2保存ans[0][0]和[1][0]变化前的数值
                BigInteger t1=ans[0][0];
                BigInteger t2=ans[1][0];
                //在每次计算后的值取模，防止数字过大，最后还要在结果上取模
                ans[0][0]=ans[0][0].multiply(a[0][0]).add(ans[0][1].multiply(a[1][0])).mod(mod);
                ans[0][1]=t1.multiply(a[0][1]).add(ans[0][1].multiply(a[1][1])).mod(mod);
                ans[1][0]=ans[1][0].multiply(a[0][0]).add(ans[1][1].multiply(a[1][0])).mod(mod);
                ans[1][1]=t2.multiply(a[0][1]).add(ans[1][1].multiply(a[1][1])).mod(mod);
            }
            //将平方次数转化为二进制，如10为0101遇到1就用ans矩阵*a矩阵，遇到0则a矩阵平方
            BigInteger t1=a[0][0];
            BigInteger t2=a[1][0];
            BigInteger t3=a[0][1];
            a[0][0]=a[0][0].multiply(a[0][0]).add(a[0][1].multiply(a[1][0])).mod(mod);
            a[0][1]=t1.multiply(a[0][1]).add(a[0][1].multiply(a[1][1])).mod(mod);
            a[1][0]=a[1][0].multiply(t1).add(a[1][1].multiply(a[1][0])).mod(mod);
            a[1][1]=t2.multiply(t3).add(a[1][1].multiply(a[1][1])).mod(mod);
            //转化为二进制，并向左推进一位
            n>>=1;
        }
        return ans;
    }
}


