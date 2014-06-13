package oopintro;

public class StackImpl implements Stack {
    protected Node last;
    protected int size;
    
    StackImpl() {
        this.last = null;
        this.size = 0;
    }

    @Override
    public void add(Object newItem) {
        Node oldLast = this.last;
        this.size++;
        this.last = new Node(newItem, oldLast);
    }

    @Override
    public Object pop() {
        if (!this.isEmpty()) {
            Node oldLast = this.last;
            this.last = oldLast.getPrevious();
            this.size--;
            return oldLast.getValue();
        }
        
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.last = null;
    }

    @Override
    public boolean isEmpty() {
        return this.last == null;
    }
}
