package oopintro;

import java.util.Calendar;

public class Time {
    private int hour;
    private int minutes;
    private int seconds;
    private int year;
    private int month;
    private int day;
    
    public Time() {
        Calendar newCalendar = Calendar.getInstance();
        this.hour = newCalendar.get(Calendar.HOUR_OF_DAY);
        this.minutes = newCalendar.get(Calendar.MINUTE);
        this.seconds = newCalendar.get(Calendar.SECOND);
        this.year = newCalendar.get(Calendar.YEAR);
        //adding 1 to the months because the count starts from 0 in Calendar
        //January -> 0; December -> 11
        this.month = newCalendar.get(Calendar.MONTH) + 1;
        this.day = newCalendar.get(Calendar.DAY_OF_MONTH);
    }
    
    public static Time now() {
        return new Time();
    }
    
    public String toString() {
        //"hh:mm:ss dd.MM.YY".
        return String.format("%02d:%02d:%02d %02d.%02d.%02d", this.hour, this.minutes, this.seconds,
                this.day, this.month, (this.year % 1000));
    }
    
    public int getHours() {
        return this.hour;
    }
    
    public int getMinutes() {
        return this.minutes;
    }
    
    public int getSeconds() {
        return this.seconds;
    }
    
    public int getYear() {
        return this.year;
    }
    
    public int getMonth() {
        return this.month;
    }
    
    public int getDay() {
        return this.day;
    }
}
