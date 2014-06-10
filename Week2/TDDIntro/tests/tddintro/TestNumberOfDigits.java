package tddintro;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNumberOfDigits {

    @Test
    public void testGetNumberOfDigits() {
        assertEquals(2, NumberOfDigits.getNumberOfDigits(12));
        assertEquals(10, NumberOfDigits.getNumberOfDigits(1234567891));
        assertEquals(1, NumberOfDigits.getNumberOfDigits(1));
        assertEquals(1, NumberOfDigits.getNumberOfDigits(0));
        assertEquals(10, NumberOfDigits.getNumberOfDigits(-1234567891));
    }

}
