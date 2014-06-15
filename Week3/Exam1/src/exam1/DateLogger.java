package exam1;

import java.util.Calendar;

public class DateLogger extends Logger {
    protected void print(String message) {
        String now = getDate();
        System.out.println(String.format("| %s | %s", now, message));
    }

    private String getDate() {
        Calendar cal = Calendar.getInstance();
        return String.format("%02d:%02d:%02d %02d.%02d.%04d", cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));
    }
}