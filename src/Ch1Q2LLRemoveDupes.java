import java.util.LinkedList;

public class Ch1Q2LLRemoveDupes {
    /*Write code to remove duplicates from an unsorted linked list.
    FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed.
     */

    public static void removeDupesWithBuffer(LinkedList<String> inputList) {
        for( int i=0; i<inputList.size(); i++) {
            for(int j=i+1; j<inputList.size(); j++) {
                if(inputList.get(i).equals(inputList.get(j))) {
                    inputList.remove(j);
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();

        linkedList.add("v");
        linkedList.add("a");
        linkedList.add("a");
        linkedList.add("v");
        linkedList.add("h");
        linkedList.add("v");
        linkedList.add("i");
        linkedList.add("i");

        System.out.println(linkedList);

        removeDupesWithBuffer(linkedList);

        System.out.println(linkedList);
    }
}
