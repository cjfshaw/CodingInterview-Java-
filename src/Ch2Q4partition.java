import java.util.ArrayList;
import java.util.HashMap;

public class Ch2Q4partition {
    static ArrayList<Node> getLesserList(LinkedList inputList, String partitionValue) {
        ArrayList<Node> lesserList = new ArrayList<>();

        for(int i=0; i<inputList.getSize();i++) {
            int stringComparison = inputList.get(i).getValue().compareTo(partitionValue);
            if( stringComparison < 0) {
                lesserList.add(inputList.get(i));
            }
        }
        return lesserList;
    }

    static ArrayList<Node> getGreaterList(LinkedList inputList, String partitionValue) {
        ArrayList<Node> greaterList = new ArrayList<>();

        for(int i=0; i<inputList.getSize();i++) {
            int stringComparison = inputList.get(i).getValue().compareTo(partitionValue);
            if( stringComparison >= 0) {
                greaterList.add(inputList.get(i));
            }
        }
        return greaterList;
    }


    static LinkedList partitionAroundX(ArrayList<Node> lesserList, ArrayList<Node> greaterList) {
        LinkedList partitionedList = new LinkedList(null, null, 0);

        for(int i=0;i<lesserList.size();i++) {
            partitionedList.append(lesserList.get(i));
        }

        for(int i=0;i<greaterList.size();i++) {
            partitionedList.append(greaterList.get(i));
        }
        return partitionedList;
    }
}
