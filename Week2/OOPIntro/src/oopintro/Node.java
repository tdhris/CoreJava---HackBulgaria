package oopintro;

public class Node {
    private Object value;
    private Node previous;
    
    Node(Object item) {
        this.value = item;
        this.previous = null;
    }
    
    Node(Object item, Node prev) {
        this.value = item;
        this.previous = prev;
    }
    
    public Object getValue() {
        return this.value;
    }
    
    public Node getPrevious() {
        return this.previous;
    }
    
    public void setPrevious(Node prev) {
        this.previous = prev;
    }
}
