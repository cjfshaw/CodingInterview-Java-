import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Ch2Q5SummedListsTest {

    @Test
    public void getNumber() {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(7);
        input.add(1);
        input.add(6);

        int number = Ch2Q5SummedLists.getNumber(input);

        Assert.assertEquals(617, number);
    }

    @Test
    public void convertIntToArrayList() {
        int number = 912;

        ArrayList<Integer> output = Ch2Q5SummedLists.convertIntToArrayList(number);

        Assert.assertEquals(2, output.get(0).intValue());
        Assert.assertEquals(1, output.get(1).intValue());
        Assert.assertEquals(9, output.get(2).intValue());
    }

    @Test
    public void summedList() {
        ArrayList<Integer> input1 = new ArrayList<>();
        input1.add(7);
        input1.add(1);
        input1.add(6);

        ArrayList<Integer> input2 = new ArrayList<>();
        input2.add(5);
        input2.add(9);
        input2.add(2);

        ArrayList<Integer> result = Ch2Q5SummedLists.summedList(input1, input2);

        Assert.assertEquals(2, result.get(0).intValue());
        Assert.assertEquals(1, result.get(1).intValue());
        Assert.assertEquals(9, result.get(2).intValue());
    }
}