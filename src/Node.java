public class Node {
    public Node previous;
    public Node next;
    public String value;

    public Node() {
    }

    public Node(Node inputPrevious, Node inputNext, String inputValue){
        previous = inputPrevious;
        next = inputNext;
        value = inputValue;
    }

    public boolean hasNext() {
        if (next != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasPrevious() {
        if (previous != null) {
            return true;
        } else {
            return false;
        }
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node nodeToSet) {
        previous = nodeToSet;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node nodeToSet) {
        next = nodeToSet;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String newValue) {
        value = newValue;
    }
}
