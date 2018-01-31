import org.junit.Test;
import org.junit.Assert;
import java.util.Map;

public class Ch1Q1UniqueCharactersTests {
    @Test
    public void sumCharactersTest() {
        String testString = "aabcc1223!!!!!@##";
        Map<Character, Integer> sumCharactersOutputMap = Ch1Q1UniqueCharacters.sumCharacters(testString);


        Assert.assertEquals( "Value of map[a] must be 2.", (Integer)2, sumCharactersOutputMap.get('a'));
        Assert.assertEquals( "Value of map[b] must be 1.", (Integer)1, sumCharactersOutputMap.get('b'));
        Assert.assertEquals( "Value of map[c] must be 2.", (Integer)2, sumCharactersOutputMap.get('c'));
        Assert.assertEquals( "Value of map[1] must be 1.", (Integer)1, sumCharactersOutputMap.get('1'));
        Assert.assertEquals( "Value of map[2] must be 2.", (Integer)2, sumCharactersOutputMap.get('2'));
        Assert.assertEquals( "Value of map[3] must be 1.", (Integer)1, sumCharactersOutputMap.get('3'));
        Assert.assertEquals( "Value of map[!] must be 5.", (Integer)5, sumCharactersOutputMap.get('!'));
        Assert.assertEquals( "Value of map[@] must be 1.", (Integer)1, sumCharactersOutputMap.get('@'));
        Assert.assertEquals( "Value of map[#] must be 2.", (Integer)2, sumCharactersOutputMap.get('#'));
        Assert.assertEquals( "Value of map[z] must be null.", null, sumCharactersOutputMap.get('z'));
    }

    @Test
    public void determineUniquenessTest() {
        String nonUniqueString = "abc123!!23";
        String uniqueString = "abc123!@#";

        Map<Character, Integer> nonUniqueSumCharactersOutputMap = Ch1Q1UniqueCharacters.sumCharacters(nonUniqueString);
        Map<Character, Integer> uniqueSumCharactersOutputMap = Ch1Q1UniqueCharacters.sumCharacters(uniqueString);

        Boolean nonUniqueResult = Ch1Q1UniqueCharacters.determineUniqueness(nonUniqueSumCharactersOutputMap);
        Boolean uniqueResult = Ch1Q1UniqueCharacters.determineUniqueness(uniqueSumCharactersOutputMap);

        Assert.assertFalse("Result of nonUniqueString must be false.", nonUniqueResult);
        Assert.assertTrue( "Result of uniqueString must be true.", uniqueResult);
    }

    @Test
    public void uniqueCharactersNoMapsTest() {
        String nonUniqueString = "abc123!!23";
        String uniqueString = "abc123!@#";

        Boolean nonUniqueResult = Ch1Q1UniqueCharacters.uniqueCharactersNoMaps(nonUniqueString);
        Boolean uniqueResult = Ch1Q1UniqueCharacters.uniqueCharactersNoMaps(uniqueString);

        Assert.assertFalse("Result of nonUniqueString must be false.", nonUniqueResult);
        Assert.assertTrue( "Result of uniqueString must be true.", uniqueResult);
    }

}