import java.util.PriorityQueue;
import java.util.Scanner;

public class PriorityQueueDemo {
    static class Node implements Comparable<Node> {
        int first, second, th;

        public Node(int first, int second, int th) {
            this.first = first;
            this.second = second;
            this.th = th;
        }

        public int compareTo(Node s2) {
            if (first != s2.first) {
                return first - s2.first;
            }
            return th - s2.th;
        }
    }

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine(); // 去掉读入数字后的回车符
        int cnt = 1;
        PriorityQueue<Node> que = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String op = sc.next();
            if (op.equals("a")) {
                int num = sc.nextInt(), x = sc.nextInt();
                que.offer(new Node(x, num, cnt++));
            } else if (!que.isEmpty()) {
                System.out.println(que.poll().second);
            }
        }
        sc.close();
    }
}
