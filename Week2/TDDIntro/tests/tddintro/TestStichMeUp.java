package tddintro;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStichMeUp {

    @Test
    public void testJoin() {
        assertEquals("Blah Lala", StichMeUp.join(" ", "Blah", "Lala"));
        assertEquals("Днес видях 5 ходещи медузи", StichMeUp.join(" ", "Днес", "видях", 5, "ходещи", "медузи"));
        assertEquals("1, 2, 3, 4, 5", StichMeUp.join(", ", 1, 2, 3, 4, 5));
    }
}
