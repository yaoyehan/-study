import java.util.Arrays;
import java.util.Scanner;

public class B5 {
    static int z = 0;
    static int count = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int w = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int max = Math.max(m, n);
        int min = Math.min(m, n);
        int a[][] = new int[max / w + 1][6];
        for (int i = 0; i < max / w + 1; i++) {
            count += 1;
            for (int j = 0; j < w; j++) {
                z += 1;
                if (count % 2 != 0)
                    a[i][j] = z;
                if (count % 2 == 0)
                    a[i][w - 1 - j] = z;
            }
        }
        int mx = 0, my = 0;
        int nx = 0, ny = 0;
        int ans = max % w;
        for (int i = 0; i < max / w + 1; i++) {
            for (int j = 0; j < w; j++) {
                if (a[i][j] == m) {
                    mx = i;
                    my = j;
                }
                if (a[i][j] == n) {
                    nx = i;
                    ny = j;
                }
            }
        }
        int max1 = Math.max(mx, nx);
        int min1 = Math.min(mx, nx);
        int max2 = Math.max(my, ny);
        int min2 = Math.min(my, ny);
        System.out.println((max1 - min1) + (max2 - min2));

    }
}