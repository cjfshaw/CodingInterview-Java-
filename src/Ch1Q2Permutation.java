import java.util.HashMap;
import java.util.Map;

public class Ch1Q2Permutation {
    //Question: Given two string, write a permutation to determine if one is a permutation of the other.

    public static Map<Character, Integer> countCharacters(String inputString) {
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

    public static boolean compareMaps(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if ( !map1.keySet().equals(map2.keySet()) ) {
            return false;
        } else {
            Object[] keyArray = map1.keySet().toArray();
            for (int i = 0; i < map1.keySet().size(); i++) {
                if ( !map1.get(keyArray[i]).equals(map2.get(keyArray[i])) ) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String string1 = "abc";
        String string2 = "cba";

        Map<Character, Integer> map1 = countCharacters(string1);
        Map<Character, Integer> map2 = countCharacters(string2);

        boolean isPermutation = compareMaps(map1, map2);
        System.out.print(isPermutation);
    }
}
