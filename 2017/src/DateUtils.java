import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @auther zzyy
 * @create 2020-07-17 16:42
 */
public class DateUtils
{

    public static void main(String[] args) throws Exception{
        for(int i=0;i<10;i++){
          new Thread(()->{

          },String.valueOf(i)).start();
        }
    }
}