package oopintro;

public class Audi extends Car {
    public Audi() {
        this.engine = "Audi Generic Engine";
    }
    
    public Audi(String engine) {
        super(engine);
    }
    
    @Override
    public String toString() {
        return "Audi@1f52ac3";
    }
}
