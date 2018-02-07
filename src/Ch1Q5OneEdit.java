import javax.sound.midi.SysexMessage;

public class Ch1Q5OneEdit {
    /*There are three types of edits that can be performed on strings: insert a character,
    remove a character, or replace a character. Given two strings, write a function to check
    if they are one edit (or zero) away.
    Example:
    pale, ple   -> true
    pale, pales -> true
    pale, bale  -> true
    pale, bake  -> false
     */

    public static boolean areStringsSame(String string1, String string2) {
        for ( int i=0;i<string1.length(); i++) {
            if (string1.charAt(i) != string2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkForInsert(String baseString, String stringToCompare) {
        int diffCount = 0;
        int diffIndex = 0;

        if ( stringToCompare.length() == baseString.length() + 1) {
            for( int i=0;i<baseString.length();i++) {
                if(baseString.charAt(i) != stringToCompare.charAt(i)) {
                    diffCount++;
                    diffIndex = i;
                    break;
                }
            }
            if(diffCount==1){
                for(int i = diffIndex; i<baseString.length();i++) {
                    if(baseString.charAt(i) != stringToCompare.charAt(i+1)) {
                        return false;
                    }
                }
            }

        } else {
            return false;
        }
        return true;
    }

    public static boolean checkForRemoval(String baseString, String stringToCompare) {
        int diffCount = 0;
        int diffIndex = 0;

        if( baseString.length() == stringToCompare.length()+1) {
            for( int i=0;i<stringToCompare.length();i++) {
                if( baseString.charAt(i) != stringToCompare.charAt(i)) {
                    diffCount++;
                    diffIndex=i;
                    break;
                }
            }
            if ( diffCount == 1) {
                for(int i=diffIndex;i<stringToCompare.length();i++) {
                    if(baseString.charAt(i+1) != stringToCompare.charAt(i)) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public static boolean checkForReplace(String baseString, String stringToCompare) {
        int diffCount = 0;

        if ( baseString.length() != stringToCompare.length()) {
            return false;
        } else {
            for (int i=0;i<baseString.length();i++) {
                if ( baseString.charAt(i) != stringToCompare.charAt(i)) {
                    diffCount++;
                }
            }
        }

        if (diffCount > 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String baseString = "pale";
        String insertString = "palse"; //spale-true, pales-true,paless-false,palse-true
        String removeString = "pa"; //ale-true, pal-true, pa-false, ple-true
        String replaceString = "balk";//bale-true, palt-true, pole-true, balk-false
        String sameString = "pale";//pale-true

        boolean isInsert = checkForInsert(baseString, insertString);
        System.out.printf("Insert Check: %b\n", isInsert);

        boolean isRemoved = checkForRemoval(baseString, removeString);
        System.out.printf("Remove Check: %b\n", isRemoved);

        boolean isOneReplace = checkForReplace(baseString, replaceString);
        System.out.printf("Replace check: %b\n", isOneReplace);

        boolean isSame = areStringsSame(baseString, sameString);
        System.out.printf("Same check: %b\n", isSame);
    }
}
