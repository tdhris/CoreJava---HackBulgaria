package oopintro;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class TestTime {
    private Time now;

    @Before
    public void setUp() throws Exception {
        now = new Time();
    }

    @Test
    public void testTimeIsCorrect() {
        Calendar realNow = Calendar.getInstance();
        int year = realNow.get(Calendar.YEAR);
        //adding 1 to the months because the count starts from 0 in Calendar
        //January -> 0; December -> 11
        int month = realNow.get(Calendar.MONTH) + 1;
        int day = realNow.get(Calendar.DAY_OF_MONTH);
        int hour = realNow.get(Calendar.HOUR_OF_DAY);
        int minutes = realNow.get(Calendar.MINUTE);
        
        assertEquals(year, now.getYear());
        assertEquals(month, now.getMonth());
        assertEquals(day, now.getDay());
        assertEquals(hour, now.getHours());
        assertEquals(minutes, now.getMinutes());
    }
    
    @Test
    public void testToStringFormatter() {
        //"hh:mm:ss dd.MM.YY"
        assertTrue(now.toString().matches("^([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9]) (0[1-9]|[12][0-9]|3[0-2])\\.(0[1-9]|1[0-2])\\.(13|14|15)$"));
    }

}
