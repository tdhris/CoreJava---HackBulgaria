package oopintro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testMatrix {
    private Matrix matrix;
    
    @Before
    public void setUp() {
        this.matrix = new Matrix(3, 3);
    }

    @Test
    public void test() {
        int k = 123;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.matrix.set(i, j, k);
                k++;
            }
        }
        
        //123, 124, 125
        //126, 127, 128
        //129, 130, 131
        BinarizationFilter filter = new BinarizationFilter();
        this.matrix.operate(filter);
        assertEquals(0, this.matrix.at(0, 0));
        assertEquals(0, this.matrix.at(0, 1));
        assertEquals(0, this.matrix.at(0, 2));
        assertEquals(0, this.matrix.at(1, 0));
        assertEquals(0, this.matrix.at(1, 1));
        assertEquals(255, this.matrix.at(1, 2));
        assertEquals(255, this.matrix.at(2, 0));
        assertEquals(255, this.matrix.at(2, 1));
        assertEquals(255, this.matrix.at(2, 2));
    }
    
    @Test
    public void testString() {
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.matrix.set(i, j, k);
                k++;
            }
        }
        
        String matrix = this.matrix.toString();
        String result = new String("123\n456\n789\n");
        assertEquals(result, matrix);
    }

}
