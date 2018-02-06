import java.util.*;

public class Ch1Q4Palindrome {
    /*Given a string, write a function to determine if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards. A permutation
    is a rearrangement of the letters.
    Example:
    Input:  Tact Coa
    Output: True (Permutations: "taco cat", "atco cta", etc)
    BONUS: List the possible permutations.*/

    public static Map<Character, Integer> countCharacters(String inputString){
        Map<Character, Integer> characterMap = new HashMap<>();

        for( int i=0; i<inputString.length(); i++) {
            if( characterMap.get(inputString.charAt(i)) == null ) {
                characterMap.put(inputString.charAt(i), 1);
            } else {
                characterMap.put(inputString.charAt(i), characterMap.get(inputString.charAt(i))+1);
            }
        }

        return characterMap;
    }

    public static boolean getPalindromeViability(Map<Character, Integer> characterMap) {
        int oddCount = 0;

        Iterator mapIterator = characterMap.entrySet().iterator();

        while( mapIterator.hasNext()) {
            Map.Entry keyValuePair = (Map.Entry)mapIterator.next();
            if( (Integer)keyValuePair.getValue()%2!=0) {
                oddCount++;
            }
            mapIterator.remove();
        }

        if( oddCount <= 1 ) {
            return true;
        } else {
            return false;
        }
    }

    public static Character identifyOddCountCharacter(Map<Character, Integer> characterMap) {
        Iterator mapIterator = characterMap.entrySet().iterator();
        Character oddChar = ' ';

        while(mapIterator.hasNext()) {
            Map.Entry keyValuePair = (Map.Entry)mapIterator.next();
            if( (Integer)keyValuePair.getValue()%2!=0 ) {
                oddChar = (Character)keyValuePair.getKey();
            }
        }
        return oddChar;
    }

    public static Map<Character, Integer> getPairMap(Map<Character, Integer> characterMap) {
        Iterator mapIterator = characterMap.entrySet().iterator();
        Map<Character, Integer> pairsMap = new HashMap<>();

        while(mapIterator.hasNext()) {
            Map.Entry keyValuePair = (Map.Entry)mapIterator.next();
            if( (Integer)keyValuePair.getValue()%2==0 ) {
                pairsMap.put((Character)keyValuePair.getKey(), (Integer)keyValuePair.getValue());
            }
        }

        return pairsMap;
    }

    public static ArrayList<String> buildPalindromeList(Map<Character, Integer> characterMap, String inputString) {
        String trimmedString = inputString.replaceAll("\\s", ""); //trim whitespace from middle of string
        ArrayList<String> palindromes = new ArrayList<String>();
        int stringLength = trimmedString.length();
        Character oddChar = identifyOddCountCharacter(characterMap);
        Map<Character, Integer> pairsMap = getPairMap(characterMap);



        return palindromes;
    }

    public static void main(String[] args) {

    }
}
