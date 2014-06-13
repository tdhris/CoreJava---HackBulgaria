package oopintro;

public class NonDuplicateStack extends StackImpl {

    @Override
    public void add(Object newItem) {
        if (!this.itemAlreadyIn(newItem)) {
            Node oldLast = this.last;
            this.last = new Node(newItem, oldLast);
            this.size++;
        }
    }

    private boolean itemAlreadyIn(Object item) {
        Node current = this.last;
        while (current != null) {
            if (current.getValue().equals(item)) {
                return true;
            }
            current = current.getPrevious();
        }
        
        return false;
    }
}
