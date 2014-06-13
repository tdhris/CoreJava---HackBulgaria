package oopintro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class testUniqueStack {
    private StackImpl stack;

    @Before
    public void setUp() throws Exception {
        this.stack = UniqueStack.createUniqueStack();
    }

    @Test
    public void testEmptyStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testAddElements() {
        stack.add(1);
        stack.add(2);
        stack.add(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.size());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.isEmpty());
    }

    public void testClearStack() {
        stack.add(1);
        stack.add(2);
        assertEquals(2, stack.size());
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    public void testCannotAddDuplicateElements() {
        assertTrue(stack.isEmpty());
        stack.add(1);
        assertEquals(1, stack.size());
        stack.add(1);
        assertEquals(1, stack.size());
        stack.add(2);
        assertEquals(2, stack.size());
    }
}
