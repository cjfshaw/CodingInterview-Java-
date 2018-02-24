import java.util.HashMap;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    Node getFirst() {
        return first;
    }

    Node getLast() {
        return last;
    }

    int getSize() {
        return size;
    }

    Node get(int index) {
        if(index >=size) {
            return null;
        } else {
            Node currentNode = first;
            for(int i=0;i<index;i++) {
                if (currentNode.hasNext() == true) {
                    currentNode = currentNode.getNext();
                }
            }
            return currentNode;
        }
    }

    void add(Node nodeToAdd, int index) {
        //this will make the node at space index equal to node to add
        //if there is already a node there, it will be pushed back
        Node nodeAtIndex = get(index);
        nodeAtIndex.getPrevious().setNext(nodeToAdd);
        nodeToAdd.setPrevious(nodeAtIndex.getPrevious());
        nodeToAdd.setNext(nodeAtIndex);
        nodeAtIndex.setPrevious(nodeToAdd);
        size++;
    }

    void append(Node nodeToAdd) {
        nodeToAdd.setPrevious(last);
        nodeToAdd.setNext(null);
        last.setNext(nodeToAdd);
        size++;
    }

    void remove(int index) {
        Node nodeToRemove = get(index);
        nodeToRemove.getPrevious().setNext(nodeToRemove.getNext());
        nodeToRemove.getNext().setPrevious(nodeToRemove.getPrevious());
        size--;
    }

    void replace(Node nodeToAdd, int index) {
        Node nodeToReplace = get(index);
        nodeToAdd.setPrevious(nodeToReplace.getPrevious());
        nodeToAdd.setNext(nodeToReplace.getNext());
        nodeToReplace.getPrevious().setNext(nodeToAdd);
        nodeToReplace.getNext().setPrevious(nodeToAdd);
    }

    boolean isListCyclical() {
        if( first.getPrevious() == null && last.getNext() == null) {
            return false;
        }

        Node currentNode = first;
        HashMap<Node, Integer> nodeCounter = new HashMap<>();

        while(currentNode.hasNext()) {
            if(nodeCounter.get(currentNode) == null) {
                nodeCounter.put(currentNode, 1);
            } else {
                nodeCounter.put(currentNode, nodeCounter.get(currentNode)+1);
            }

            if(nodeCounter.get(currentNode) > 1) {
                return true;
            }

            currentNode = currentNode.getNext();
        }

        return false;
    }

    void removeDuplicates() {
        Node currentNode = first;

        HashMap<Node, Integer> nodeCounter = new HashMap<>();
        int listIterator = 0;

        while(currentNode.hasNext()) {
            if(nodeCounter.get(currentNode) == null) {
                nodeCounter.put(currentNode, 1);
            } else {
                nodeCounter.put(currentNode, nodeCounter.get(currentNode)+1);
            }

            if( nodeCounter.get(currentNode) > 1) {
                remove(listIterator);
            }

            listIterator++;
            currentNode = currentNode.getNext();
        }
    }
}
