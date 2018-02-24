public class Node {
    private Node previous;
    private Node next;
    private String value;

    boolean hasNext() {
        if (next != null) {
            return true;
        } else {
            return false;
        }
    }

    boolean hasPrevious() {
        if (previous != null) {
            return true;
        } else {
            return false;
        }
    }

    Node getPrevious() {
        return previous;
    }

    void setPrevious(Node nodeToSet) {
        previous = nodeToSet;
    }

    Node getNext() {
        return next;
    }

    void setNext(Node nodeToSet) {
        next = nodeToSet;
    }

    String getValue() {
        return value;
    }

    void setValue(String newValue) {
        value = newValue;
    }
}
