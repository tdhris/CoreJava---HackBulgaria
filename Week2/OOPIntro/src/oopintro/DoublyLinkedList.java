package oopintro;

public class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;
    private int size;

    DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addEnd(int value) {
        DoublyNode newNode = new DoublyNode(value);

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        }

        else {
            newNode.setPrevious(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }

        this.size++;
    }

    public void addFront(int value) {
        DoublyNode newNode = new DoublyNode(value);

        if (this.size == 0) {
            this.head = newNode;
            this.tail = newNode;
        }

        else {
            newNode.setNext(this.head);
            this.head.setPrevious(newNode);
            this.head = newNode;
        }

        this.size++;
    }

    public void addAt(int index, int value) {
        DoublyNode newNode = new DoublyNode(value);
        DoublyNode oldNode = this.get(index);
        DoublyNode oldPrev = oldNode.getPrevious();
        newNode.setNext(oldNode);
        newNode.setPrevious(oldPrev);
        oldNode.setPrevious(newNode);
        oldPrev.setNext(newNode);
        this.size++;
    }

    public void remove(int index) {
        DoublyNode toRemove = this.get(index);
        DoublyNode prev = toRemove.getPrevious();
        DoublyNode next = toRemove.getNext();
        if (prev != null) {
            prev.setNext(next);
        }

        if (next != null) {
            next.setPrevious(prev);
        }
        
        if (index == 0) {
            this.head = next;
        }
        
        if (index == this.size - 1) {
            this.tail = prev;
        }

        this.size--;
    }

    public int size() {
        return this.size;
    }

    public int getFirst() {
        return this.head.getValue();
    }

    public int getLast() {
        return this.tail.getValue();
    }

    private DoublyNode get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
        }

        if (index == 0) {
            return this.head;
        }

        if (index == this.size - 1) {
            return this.tail;
        }

        else {
            int i = 0;
            DoublyNode current = this.head;
            while (current != null) {
                if (i == index) {
                    break;
                }
                current = current.getNext();
                i++;
            }
            return current;
        }
    }

    public int getValue(int index) {
        return this.get(index).getValue();
    }
}