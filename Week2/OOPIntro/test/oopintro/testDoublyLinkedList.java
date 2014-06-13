package oopintro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testDoublyLinkedList {
    private DoublyLinkedList list;
    
    @Before
    public void setUp() {
        this.list = new DoublyLinkedList();
    }

    @Test
    public void testAddEnd() {
        this.list.addEnd(1);
        this.list.addEnd(2);
        this.list.addEnd(3);
        this.list.addEnd(4);
        this.list.addEnd(5);
        assertEquals(3, this.list.getValue(2));
        assertEquals(2, this.list.getValue(1));
        assertEquals(4, this.list.getValue(3));
        assertEquals(1, this.list.getFirst());
        assertEquals(5, this.list.getLast());
    }
    
    @Test
    public void testAddFront() {
        //5 4 3 2 1
        this.list.addFront(1);
        this.list.addFront(2);
        this.list.addFront(3);
        this.list.addFront(4);
        this.list.addFront(5);
        assertEquals(3, this.list.getValue(2));
        assertEquals(4, this.list.getValue(1));
        assertEquals(2, this.list.getValue(3));
        assertEquals(5, this.list.getFirst());
        assertEquals(1, this.list.getLast());
    }
    
    @Test
    public void testAddAt() {
        //1 3 2
        this.list.addFront(1);
        this.list.addEnd(2);
        this.list.addAt(1, 3);
        assertEquals(1, this.list.getFirst());
        assertEquals(2, this.list.getLast());
        assertEquals(3, this.list.getValue(1));
    }
    
    @Test
    public void testRemove() {
        //1 3 2
        this.list.addFront(1);
        this.list.addEnd(2);
        this.list.addAt(1, 3);
        assertEquals(1, this.list.getFirst());
        assertEquals(2, this.list.getLast());
        assertEquals(3, this.list.getValue(1));
        
        this.list.remove(0);
        assertEquals(3, this.list.getFirst());
        this.list.remove(1);
        assertEquals(3, this.list.getLast());
        this.list.remove(0);
        assertEquals(0, this.list.size());
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testInvalidIndexThrowsException() {
        this.list.getValue(10);
        this.list.getValue(-4);
        this.list.remove(10);
    }

}
