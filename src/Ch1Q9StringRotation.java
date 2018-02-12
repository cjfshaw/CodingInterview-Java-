import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ch1Q9StringRotation {
    /*Assume you have a method isSubstring which checks if one word is a substring of another.
    Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only
    one call to isSubstring.
    Example: "waterbottle" is a rotation of "erbottlewat."
     */

    public static Map<Character, Integer> sumCharacters(String inputString) {
        Map<Character, Integer> charCount = new HashMap<>();

        for(int i=0; i<inputString.length(); i++) {
            if( charCount.get(inputString.charAt(i))==null ) {
                charCount.put(inputString.charAt(i), 1);
            } else {
                charCount.put(inputString.charAt(i), charCount.get(inputString.charAt(i))+1);
            }
        }
        return charCount;
    }

    public static boolean isSubstring(String string1, String string2) {
        boolean isRotation = false;
        ArrayList<Integer> startingLetterOccurences = new ArrayList<>();
        int sameCount = 0;
        int overflow = 0;
        int overFlowCount = 0;

        if(string1.length() != string2.length()) {
            return false;
        }

        for(int i=0;i<string1.length();i++) {
            if(string1.charAt(0) == string2.charAt(i)) {
                startingLetterOccurences.add(i);
            }
        }

        for(int i=0;i<startingLetterOccurences.size();i++) {
            int startingIndex = startingLetterOccurences.get(i);
            for(int j=0;j<string1.length();j++) {
                if(startingIndex+j == string1.length()) {
                    startingIndex = 0;
                    overflow = 1;
                }
                if(overflow==1) {
                    if (string1.charAt(j) == string2.charAt(startingIndex+overFlowCount)) {
                        sameCount++;
                        overFlowCount++;
                    }
                } else {
                    if (string1.charAt(j) == string2.charAt(startingIndex+j)) {
                        sameCount++;
                    }
                }
            }
        }
        if (sameCount == string1.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String string1 = "waterbottle";
        String string2 = "erbottlewat";
        boolean isRotated = false;

        isRotated = isSubstring(string1, string2);

        System.out.println(isRotated);
    }
}
