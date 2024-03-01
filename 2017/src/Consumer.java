import java.util.concurrent.Callable;

public class Consumer implements Runnable {
    public Container container;
    public Consumer(Container container){
        this.container=container;
    }

    @Override
    public void run() {
        while (true){
            container.get();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
