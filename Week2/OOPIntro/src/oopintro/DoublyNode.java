package oopintro;

public class DoublyNode {
    private int value;
    private DoublyNode next;
    private DoublyNode previous;
    
    DoublyNode() {
        this.value = 0;
        this.next = null;
        this.previous = null;
    }
    
    DoublyNode(int value) {
        this.value = value;
        this.next = null;
        this.previous = null;
    }
    
    DoublyNode(int value, DoublyNode prev) {
        this.value = value;
        this.previous = prev;
    }
    
    public int getValue() {
        return this.value;
    }
    
    public void setValue(int newValue) {
        this.value = newValue;
    }
    
    public DoublyNode getNext() {
        return this.next;
    }
    
    public void setNext(DoublyNode newNext) {
        this.next = newNext;
    }
    
    public DoublyNode getPrevious() {
        return this.previous;
    }
    
    public void setPrevious(DoublyNode newPrev) {
        this.previous = newPrev;
    }
}
