import java.math.BigInteger;

public class A3 {
    public static void main(String[] args) {
        BigInteger x=BigInteger.valueOf(2).pow(11213).subtract(BigInteger.ONE);
        String s=x.toString();
        System.out.println(s.length());
        String substring = s.substring(s.length() - 100);
        System.out.println(substring.length()+" "+substring);
    }
}
