package oopintro;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class testStackImpl {
    private StackImpl stack;
    
    @Before
    public void setUp() throws Exception {
        this.stack = new StackImpl();
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

}
