import java.util.HashMap;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    public LinkedList(Node first, Node last, int size) {
        this.first = first;
        this.last = last;
        this.size = size;
    }

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

    void add(Node nodeToAdd, int index) {//add try catch around adding at index >= size
        //this will make the node at space index equal to node to add
        //if there is already a node there, it will be pushed back
        if(index == 0) {
            nodeToAdd.setPrevious(null);
            nodeToAdd.setNext(first);
            first.setPrevious(nodeToAdd);
            first = nodeToAdd;
        } else if(index == size-1) {
            nodeToAdd.setNext(null);
            nodeToAdd.setPrevious(last);
            last.setNext(nodeToAdd);
            last=nodeToAdd;
        } else {
            Node nodeAtIndex = get(index);
            nodeAtIndex.getPrevious().setNext(nodeToAdd);
            nodeToAdd.setPrevious(nodeAtIndex.getPrevious());
            nodeToAdd.setNext(nodeAtIndex);
            nodeAtIndex.setPrevious(nodeToAdd);
        }
        size++;
    }

    void append(Node nodeToAdd) {
        if(size == 0) {
            first = nodeToAdd;
            last = nodeToAdd;
            nodeToAdd.setPrevious(null);
            nodeToAdd.setNext(null);
            size++;
        } else if (size == 1) {
            first.setNext(nodeToAdd);
            last = nodeToAdd;
            nodeToAdd.setPrevious(first);
            nodeToAdd.setNext(null);
            size++;
        } else {
            nodeToAdd.setPrevious(last);
            nodeToAdd.setNext(null);
            last.setNext(nodeToAdd);
            last = nodeToAdd;
            size++;
        }
    }

    void remove(int index) {//add try catch at removing from empty list
        if(index==0) {
            first=first.getNext();
            first.setPrevious(null);
        } else if (index == size-1) {
            last=last.getPrevious();
            last.setNext(null);
        } else {
            Node nodeToRemove = get(index);
            nodeToRemove.getPrevious().setNext(nodeToRemove.getNext());
            nodeToRemove.getNext().setPrevious(nodeToRemove.getPrevious());
        }
        size--;
    }

    void replace(Node nodeToAdd, int index) {//add try catch at replacing from nonexistent entry (empty, index >=size)
        if(index == 0) {
            nodeToAdd.setNext(first.getNext());
            first.getNext().setPrevious(nodeToAdd);
            first = nodeToAdd;
            nodeToAdd.setPrevious(null);
        } else if (index == size-1) {
            nodeToAdd.setPrevious(last.getPrevious());
            last.getPrevious().setNext(nodeToAdd);
            last=nodeToAdd;
            nodeToAdd.setNext(null);
        } else {
            Node nodeToReplace = get(index);
            nodeToAdd.setPrevious(nodeToReplace.getPrevious());
            nodeToAdd.setNext(nodeToReplace.getNext());
            nodeToReplace.getPrevious().setNext(nodeToAdd);
            nodeToReplace.getNext().setPrevious(nodeToAdd);
        }
    }

    void printListvalues() {
        Node currentNode = first;
        for(int i=0;i<size;i++) {
            System.out.print(currentNode.getValue() + " ");
            currentNode=currentNode.getNext();
        }
        System.out.println();
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

        HashMap<String, Integer> nodeCounter = new HashMap<>();
        int listIterator = 0;

        while(currentNode.hasNext()) {
            if(nodeCounter.get(currentNode.getValue()) == null) {
                nodeCounter.put(currentNode.getValue(), 1);
            } else {
                nodeCounter.put(currentNode.getValue(), nodeCounter.get(currentNode.getValue())+1);
            }

            if( nodeCounter.get(currentNode.getValue()) > 1) {
                remove(listIterator);
            }

            listIterator++;
            currentNode = currentNode.getNext();
        }

        if(nodeCounter.get(last.getValue()) > 1) {
            remove(size-1);
        }
    }

    Node kthToLast(int index) {
        return get(getSize()-index);
    }

    boolean isPalindrome() {
        int j = size -1;
        for(int i=0;i<size;i++) {
            if(size%2 == 0 && i > size/2) {
                return true;
            } else if (size%2 == 1 && i == size/2+1) {
                return true;
            }
            if(get(i).getValue() != get(j).getValue()) {
                return false;
            }
            j--;
        }
        return true;
    }
}
