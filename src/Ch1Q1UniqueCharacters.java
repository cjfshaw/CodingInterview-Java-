import java.util.*;

public class Ch1Q1UniqueCharacters {
    //Question: Implement an algorithm to determine if a string has all unique characters.
    //Bonus: What if you can't use additional data structures?

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
    
    public static boolean determineUniqueness(Map<Character, Integer> stringMap) {
        boolean isUnique = true;

        Iterator mapIndex = stringMap.entrySet().iterator();

        while(mapIndex.hasNext()) {
            Map.Entry nextPair = (Map.Entry)mapIndex.next();
            String pairAsString = nextPair.toString();
            Character countChar = pairAsString.charAt(2);
            if( countChar != '1' ) {
                isUnique = false;
            }
        }

        return isUnique;
    }

    public static boolean uniqueCharactersNoMaps(String inputString) {
        boolean isUnique = true;

        for( int i=0; i<inputString.length(); i++){
            for( int j=i+1; j<inputString.length(); j++) {
                if( inputString.charAt(i) == inputString.charAt(j)) {
                    isUnique = false;
                    return isUnique;
                }
            }
        }

        return isUnique;
    }
    
    public static void main(String[] args) {
        String uniqueString = "abc123!@#";
        String notUniqueString = "abc123!@##";

        Map<Character, Integer> charMap = sumCharacters(uniqueString);
        boolean isUnique = determineUniqueness(charMap);

        System.out.printf("For the original question: %b\n", isUnique);

        boolean secondIsUnique = uniqueCharactersNoMaps(uniqueString);
        System.out.printf("For the second question with a unique string: %b\n", secondIsUnique);
        secondIsUnique = uniqueCharactersNoMaps(notUniqueString);
        System.out.printf("For the second question with a non unique string: %b\n", secondIsUnique);
    }
}
