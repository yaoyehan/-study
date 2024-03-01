import java.math.BigDecimal;
import java.math.BigInteger;

public class B4菲波那切数列 {
    public static void main(String[] args) {
        BigInteger a=BigInteger.ONE;
        BigInteger b=BigInteger.ONE;
        for (int i = 3; i < 500; i++) {
            BigInteger t=b;
            b=a.add(b);
            a=t;
        }
        BigDecimal bigDecimal = new BigDecimal(a, 110).divide(new BigDecimal(b,110), BigDecimal.ROUND_HALF_DOWN);
        System.out.println(bigDecimal.toPlainString().substring(0,103));
    }
}
