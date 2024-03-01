import java.util.Calendar;

public class B3 {
    public static void main(String[] args) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR,2020);
        calendar2.set(Calendar.YEAR,1921);
        calendar1.set(Calendar.MONTH,7);
        calendar2.set(Calendar.MONTH,7);
        calendar1.set(Calendar.DAY_OF_MONTH,1);
        calendar2.set(Calendar.DAY_OF_MONTH,23);
        long i = calendar1.getTime().getTime()-calendar2.getTime().getTime();
        System.out.println(i/60000);
    }
}
