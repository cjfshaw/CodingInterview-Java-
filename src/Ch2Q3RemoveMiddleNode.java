import java.util.LinkedList;

public class Ch2Q3RemoveMiddleNode {
    /*
    Implement an algorithm to delete a node in the middle (i.e. any node
    that is not the first or last node in a list, not necessarily the middle
    node) of a singly linked list. Given only access to that node.
    Example:
    Input (starting list):
    a,b,c,d,e,f
    Output (ending list): (no return, affect change on the list itself)
    a,b,d,e,f
     */

    public static boolean removeNode (LinkedList startingList, int index) {
        /*Note returning in removeNode because I don't have my own Linkedlist class
        and can not add a method to Java's. Logic should be the same except I'm
        returning instead of operating on the original list.

        It appears that you can't access nodes through java's implementation of
        a linked list, so I'll write comments with pseudocode. In general it appears
        as though answering questions in this chapter is pretty worthless and instead
        you should just write an implementation of linked list and make sure you've
        got these questions answered as a part of it.
        */

        if(index == 0 || index == startingList.size()) {
            return false;
        } else {
            /*
            Node previousNode = startingList.get(index).previous();
            Node nextNode = startingList.get(index).next();
            previousNode.Next = nextNode;
            nextNode.Prev = previousNode;
            return true;
             */
        }

        return true;
    }
}
