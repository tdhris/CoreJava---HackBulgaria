package oopintro;


public class Pair<F, S> {
    private F first;
    private S second;
    
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }
    
    public F getFirst() {
        return this.first;
    }
    
    public S getSecond() {
        return this.second;
    }
    
    public boolean equals(Pair<F, S> other) {
        return this.first.equals(other.first) && this.second.equals(other.second);
    }
    
    public String toString() {
        return String.format("<%s, %s>", this.first.toString(), this.second.toString());
    }
}
