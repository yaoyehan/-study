import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.TreeSet;

public class Container {
    public static Deque<Integer> deque=new ArrayDeque<Integer>();
    int capacity=10;
    public synchronized void get(){
        if(deque.size()>0){
            deque.poll();
            notifyAll();
            System.out.println("消费者消费消息");
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("消费者处于等待状态");
        }
    }
    public synchronized void put(int val){
        if(deque.size()< capacity){
            deque.push(val);
            notifyAll();
            System.out.println("生产者生产消息");
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("生产者处于生产状态");
        }
    }

}
