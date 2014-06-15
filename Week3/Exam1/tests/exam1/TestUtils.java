package exam1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

public class TestUtils {
    List<Integer> myList;

    @Before
    public void setUp() throws Exception {
        myList = new ArrayList<>();
    }

    @Test
    public void testSort() {
        ArrayList<Integer> n = new ArrayList<>(Arrays.asList(9, 6, 8, 3, 5, 14, 87));
        myList.addAll(n);
        List<Integer> test = ExamUtils.sort(n);
        Collections.sort(n);
        assertEquals(n, test);
    }
    
    @Test
    public void testSortWithVector() {
        Vector<Integer> n = new Vector<>(Arrays.asList(9, 6, 8, 3, 5, 14, 87));
        myList.addAll(n);
        List<Integer> test = ExamUtils.sort(n);
        Collections.sort(n);
        assertEquals(n, test);
    }
    
    
    @Test
    public void testSortWithStack() {
        Stack<Integer> n = new Stack<Integer>();
        List<Integer> t = Arrays.asList(9, 6, 8, 3, 5, 14, 87);
        n.addAll(t);
        myList.addAll(n);
        List<Integer> test = ExamUtils.sort(n);
        Collections.sort(n);
        assertEquals(n, test);
    }
    
    @Test
    public void testSortWithLinkedList() {
        LinkedList<Integer> n = new LinkedList<Integer>(Arrays.asList(9, 6, 8, 3, 5, 14, 87));
        myList.addAll(n);
        List<Integer> test = ExamUtils.sort(n);
        Collections.sort(n);
        assertEquals(n, test);
    }
    
    @Test
    public void testReverseWithArrayList() {
        ArrayList<Integer> n = new ArrayList<>(Arrays.asList(9, 6, 8, 3, 5, 14, 87));
        myList.addAll(n);
        List<Integer> test = ExamUtils.reverse(n);
        Collections.reverse(n);
        assertEquals(n, test);
    }
    
    @Test
    public void testReverseWithVector() {
        Vector<Integer> n = new Vector<>(Arrays.asList(9, 6, 8, 3, 5, 14, 87));
        myList.addAll(n);
        List<Integer> test = ExamUtils.reverse(n);
        
        assertEquals(n.get(n.size()-1), test.get(0));
        assertEquals(n.get(0), test.get(test.size() - 1));
        assertEquals(n.get(n.size()-2), test.get(1));
        
        Collections.reverse(n);
        assertEquals(n, test);
    }
    
    @Test
    public void testIsMonotonous() {
        assertTrue(ExamUtils.isMonotonous(Arrays.asList(1,2,3,4,5,6)));
        assertTrue(ExamUtils.isMonotonous(Arrays.asList(6,5,4,3,2,1,1,1)));
        assertFalse(ExamUtils.isMonotonous(Arrays.asList(1,2,1,4,5,4)));
        assertFalse(ExamUtils.isMonotonous(Arrays.asList(100,2,1,4,50,4)));
        assertTrue(ExamUtils.isMonotonous(Arrays.asList(0,0,0,0,0,0)));
    }

}
