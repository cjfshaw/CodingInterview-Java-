import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class Ch1Q2PermutationTest {
    @Test
    public void compareMaps() {
        String originalString = "abc";
        String permutationString = "cba";
        String nonPermutationString = "cbaa";

        Map<Character, Integer> originalMap = Ch1Q2Permutation.countCharacters(originalString);
        Map<Character, Integer> permutationMap = Ch1Q2Permutation.countCharacters(permutationString);
        Map<Character, Integer> nonPermutationMap = Ch1Q2Permutation.countCharacters(nonPermutationString);

        Assert.assertTrue("originalMap and permutationMap must be equal.", Ch1Q2Permutation.compareMaps(originalMap, permutationMap));
        Assert.assertFalse("originalMap and nonPermutationMap must not be equal.", Ch1Q2Permutation.compareMaps(originalMap, nonPermutationMap));
    }
}