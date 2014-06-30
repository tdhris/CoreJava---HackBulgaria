package com.hackbulgaria.files1;

public class DayGreeter {
    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY;
    }
    
    public String greetMe(Day day) {
        String greeting;
        switch(day) {
            case MONDAY:
                greeting = "I hate you! Go away!";
                break;
            case TUESDAY:
                greeting = "Don't like you.";
                break;
            case WEDNESDAY:
                greeting = "Meh. Hello.";
                break;
            case THURSDAY:
                greeting = "Hi :)";
                break;
            case FRIDAY:
                greeting = "Heelloo, darling ;)";
                break;
            case SATURDAY:
                greeting = "Hello. Will you marry me?";
                break;
            case SUNDAY:
                greeting = "Hi. I love you.";
                break;
            default:
                greeting = "Huh?";
                break;
        }    
        return greeting;
    }
}
