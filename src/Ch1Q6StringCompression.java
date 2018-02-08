public class Ch1Q6StringCompression {
    /*Implement a function to perform basic string compression using the counts of
    repeated characters.
    Example:
    Input: aabcccccaaa
    Output: a2b1c5a3
    If the "compressed" string would not become smaller than the original string
    your function should return the original string.
    You can assume the string only has uppercase and lower case letters (a-z).
     */

    public static String compressString(String inputString) {
        int tmpCount = 1;
        Character tmpChar = ' ';
        StringBuilder builder = new StringBuilder();
        int nonRepeatingCount = 0;

        for(int i=0;i<inputString.length()-1;i++) {
            if(inputString.charAt(i) == inputString.charAt(i+1)) {
                tmpCount++;
                tmpChar = inputString.charAt(i);
            } else if ( inputString.charAt(i) != inputString.charAt(i+1) && tmpCount == 1) {
                nonRepeatingCount++;
                builder.append(inputString.charAt(i));
                builder.append(String.valueOf(tmpCount));
            } else {
                builder.append(tmpChar);
                builder.append(String.valueOf(tmpCount));
                tmpCount=1;
                nonRepeatingCount++;
            }
        }
        builder.append(inputString.charAt(inputString.length()-1));
        builder.append(String.valueOf(tmpCount));
        nonRepeatingCount++;
        if ( nonRepeatingCount == inputString.length()) {
            return inputString;
        } else {
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        String repeatedCharsString = "aabcccccaaabc";
        String noRepeats = "abcdef";
        String outputString = "";

        outputString = compressString(repeatedCharsString);
        System.out.println(outputString);
        outputString = compressString(noRepeats);
        System.out.println(outputString);

    }
}
