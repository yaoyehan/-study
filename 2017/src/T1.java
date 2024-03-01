import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @auther zzyy
 * @create 2020-06-28 10:07
 */
public class T1 {


     static  boolean isStop = true;

    public static void main(String[] args)
    {
        new Thread(() -> {
            while(isStop){
                System.out.println("-------hello interrupt");
            }
        },"t1").start();

//暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        isStop = false;
    }
}