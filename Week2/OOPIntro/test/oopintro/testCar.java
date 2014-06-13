package oopintro;

import static org.junit.Assert.*;
import org.junit.Test;

public class testCar {
    private Car myCar;

    @Test
    public void test() {
        myCar = new Car();
        assertEquals("Generic Car", myCar.toString());
    }
    
    @Test
    public void testGettersNSetters(){
        myCar = new Car("Lala");
        assertEquals("Lala", myCar.getEngine());
        myCar.setEngine("Baba");
        assertEquals("Baba", myCar.getEngine());
        
    }
    
    @Test
    public void testAudi() {
        myCar = new Audi();
        assertEquals("Audi Generic Engine", myCar.getEngine());
        assertEquals("Audi@1f52ac3", myCar.toString());
    }
    
    @Test
    public void testFord() {
        myCar = new Ford();
        assertEquals("Ford Engine", myCar.getEngine());
        assertEquals("My Brand New Ford", myCar.toString());
    }
    
    @Test
    public void testPorsche() {
        myCar = new Porsche();
        assertEquals("Porsche Engine", myCar.getEngine());
        assertEquals("My Brand New Porsche", myCar.toString());
    }
    
    @Test
    public void testBMW() {
        myCar = new BMW();
        assertEquals("BMW Engine", myCar.getEngine());
        assertEquals("My Brand New BMW", myCar.toString());
    }

}
