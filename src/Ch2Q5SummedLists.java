import java.util.ArrayList;

public class Ch2Q5SummedLists {
    /*You have two numbers represented by linked lists, where each node contains a single digit.
    The digits are stored in reverse order, such that the 1s digit is at the head of the list.
    Write a function that adds the two numbers and returns their sum as a linked list.
    Example:
    Input: (7,1,6) + (5,9,2) -> 617 + 295
    Output: (2,1,9) -> 912
     */

    public static Integer getNumber(ArrayList<Integer> input) {
        Integer tempNum = 0;
        StringBuilder tempString = new StringBuilder();

        for(int i=input.size()-1;i>=0; i--) {
            tempNum = input.get(i);
            tempString.append(tempNum.toString());
        }

        String numberAsString = tempString.toString();
        int number = Integer.parseInt(numberAsString);

        return number;
    }

    public static ArrayList<Integer> convertIntToArrayList(Integer input) {
        String inputAsString = input.toString();
        ArrayList<Integer> output = new ArrayList<>();

        for(int i=inputAsString.length()-1; i>=0;i--) {
            output.add(Integer.parseInt(String.valueOf(inputAsString.charAt(i))));
        }

        return output;
    }

    public static ArrayList<Integer> summedList(ArrayList<Integer> input1, ArrayList<Integer> input2) {
        Integer input1AsNum = Ch2Q5SummedLists.getNumber(input1);
        Integer input2AsNum = Ch2Q5SummedLists.getNumber(input2);

        Integer sum = input1AsNum + input2AsNum;

        ArrayList<Integer> result = Ch2Q5SummedLists.convertIntToArrayList(sum);

        return result;
    }
}
