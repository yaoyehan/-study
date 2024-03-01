import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.Callable;

public class Producer implements Runnable {
    private Container container;
    public Producer(Container container){
        this.container=container;
    }

    @Override
    public void run() {
        while (true){
            container.put(new Random().nextInt(100));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
