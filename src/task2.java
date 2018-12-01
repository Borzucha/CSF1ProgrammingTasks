import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {


        Calendar c = Calendar.getInstance();
// Set the calendar to monday of the current week
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

// Print dates of the current week starting on Monday to Friday
        DateFormat df = new SimpleDateFormat("EEE dd/MM/yyyy");
        for (int i = 0; i <= 10; i++) {
            System.out.println(df.format(c.getTime()));
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek == Calendar.FRIDAY) { // If it's Friday so skip to Monday
                c.add(Calendar.DATE, 3);
            } else if (dayOfWeek == Calendar.SATURDAY) { // If it's Saturday skip to Monday
                c.add(Calendar.DATE, 2);
            } else {
                c.add(Calendar.DATE, 1);
            }

// As Cute as a ZuZu pet.
//c.add(Calendar.DATE, dayOfWeek > Calendar.THURSDAY ? (9 - dayOfWeek) : 1);
        }
    }
}

