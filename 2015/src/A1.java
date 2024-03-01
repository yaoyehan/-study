import java.util.Calendar;

public class A1 {
    public static void main(String[] args) {
        Calendar calendar=Calendar.getInstance();
        calendar.set(2014,11,9);
        calendar.add(Calendar.DATE,1000);
        System.out.println(calendar.getTime().toLocaleString());
    }
}
