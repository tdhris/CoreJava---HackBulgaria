package oopintro;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestPair {

    @Test
    public void testBasicPairFunctions() {
        String monthName = "January";
        int monthNumber = 1;
        Pair<Integer, String> month = new Pair<>(monthNumber, monthName);
        assertEquals(monthName, month.getSecond());
        assertEquals(monthNumber, (int)month.getFirst());         
    }
    
    @Test
    public void testToStringMethod() {
        Pair<String, String> mouses = new Pair<>("Micky", "Minnie");
        assertEquals("<Micky, Minnie>", mouses.toString());
    }

}
