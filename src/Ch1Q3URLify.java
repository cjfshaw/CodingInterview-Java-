import com.sun.xml.internal.ws.util.StringUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Ch1Q3URLify {
    //Write a method to replace all spaces in a string with '%20'. You may assume
    //that the string has sufficient space at the end to hold all the characters,
    //and that you are given the "true" length of the string.

    //Note: If implementing in Java please use a character array so that you can
    //perform this operation in place.

    //Input:Mr John Smith     ", 13
    //Output:Mr%20John%20Smith

    public static ArrayList<String> getSubstrings(String inputString, int stringLength) {
        StringBuilder tmpString = new StringBuilder();
        ArrayList<String> subStringArrayList = new ArrayList<String>();
        int count = 0;

        for( int i=0; i<=stringLength; i++) {
            if ( inputString.charAt(i) != ' ') {
                tmpString.append(inputString.charAt(i));
            } else {
                subStringArrayList.add(tmpString.toString());
                tmpString.setLength(0);
            }
        }
        return subStringArrayList;
    }

    public static String buildURLFromArrayList(ArrayList<String> stringArrayList) {
        String urlString = "";
        StringBuilder tmpString = new StringBuilder();

        for ( int i=0; i<stringArrayList.size(); i++) {
            tmpString.append(stringArrayList.get(i));
            if ( i < stringArrayList.size()-1) {
                tmpString.append("%20");
            }
        }
        urlString = tmpString.toString();
        return urlString;
    }

    public static String stringToURL(String inputString) {
        int charactersFound = 0;
        String urlString = "";
        StringBuilder tmpString = new StringBuilder();

        for( int i=0; i<inputString.length(); i++) {
            if( inputString.charAt(i) != ' ') {
                tmpString.append(inputString.charAt(i));
            } else if (tmpString.length() < inputString.length()-1) {
                tmpString.append('%');
                tmpString.append('2');
                tmpString.append('0');
            }
        }

        urlString = tmpString.toString();

        return urlString;
    }

    public static char[] shiftCharArray(char[] charArray, int index, int amountToShift) {
        for (int i=0; i<charArray.length-index-1; i++) {
            charArray[charArray.length-i-1] = charArray[charArray.length-i-amountToShift];
        }
        charArray[index + 1] = charArray[index];
        return charArray;
    }

    public static char[] charArrayURL(String inputString) {
        char[] charArray = inputString.toCharArray();

        for(int i=0; i<charArray.length-1;i++) {
            if (charArray[i] == ' ') {
                charArray = shiftCharArray(charArray, i, 3);
                charArray[i] = '%';
                charArray[i+1] = '2';
                charArray[i+2] = '0';
                i=i+2;
            }
        }

        return charArray;
    }

    public static void main(String[] args) {
        String inputString = "Mr John Smith     ";
        int trueLength = 13;

        ArrayList<String> substrings = getSubstrings(inputString, trueLength);

        String outputString = "";
        outputString = buildURLFromArrayList(substrings);
        System.out.println(outputString);

        String secondURL = "";
        secondURL = stringToURL(inputString);
        System.out.println(secondURL);

        char[] charArray = new char[inputString.length()];
        charArray = charArrayURL(inputString);
        System.out.println(charArray);
    }
}
