package oopintro;

public class Car {
    protected String engine;
    
    public Car() {
        this.engine = "Generic Engine";
    }
    
    public Car(String engine) {
        this.setEngine(engine);
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
    
    public String toString() {
        return "Generic Car";
    }
}
