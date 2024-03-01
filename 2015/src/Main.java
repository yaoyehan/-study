import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s1 = scanner.nextLine();
        if (s.equals(s1)) {
            throw new MyException("字符串相同，请重新输入");
        }
        byte[] bytes = s.getBytes();
        byte[] bytes1 = s1.getBytes();
        int sum = 0;
        int sum1 = 0;
        for (int i = 0; i < bytes.length; i++) {
            sum += bytes[i];
        }
        for (int i = 0; i < bytes1.length; i++) {
            sum1 += bytes1[i];
        }
        int max = Math.max(sum, sum1);
        int min = Math.min(sum, sum1);
        if (max % min != 0) {
            throw new MyException("第一条字符串所有字符所转的ascii码和与第二条字符串所有字符所转的ascii码和不能整除");
        } else {
            System.out.println("第一条字符串所有字符所转的ascii码和与第二条字符串所有字符所转的ascii码和整除为" + max / min);
        }
    }
}