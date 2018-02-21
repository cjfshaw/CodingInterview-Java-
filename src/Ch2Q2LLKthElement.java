import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class Ch2Q2LLKthElement {
    /*Implement an algorithm to find the kth to last element of a singly linked list.
    Example: List = a,b,c,d,e,f    k = 2
    Answer: e
    */

    public static Object getKthToLastElement(LinkedList inputList, int index) {
        //Note: This algorithm assumes that I can get the size of the list
        //It also assume I can't just do get(size-index)
        Object kthElement = 0;

        for(int i=0;i<inputList.size(); i++) {
            if(i == inputList.size() - index) {
                kthElement = inputList.get(i);
            }
        }

        return kthElement;
    }

    public static void main(String[] args) {
        LinkedList testList = new LinkedList();
        testList.add("a");
        testList.add("b");
        testList.add("c");
        testList.add("d");
        testList.add("e");
        testList.add("f");

        Object k = getKthToLastElement(testList, 2);

        System.out.println(k);
    }
}
