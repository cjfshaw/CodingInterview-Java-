import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class Ch2Q4partitionTest {
    @Test
    public void getLesserList() {
        Node a = new Node(null, null, "z");
        Node b = new Node(a, null, "j");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);
        Node d = new Node(c, null, "d");
        Node e = new Node(d, null, "e");
        d.setNext(e);
        LinkedList testList = new LinkedList(a, c, 3);
        testList.append(d);
        testList.append(e);

        ArrayList<Node> lesserList = Ch2Q4partition.getLesserList(testList, "j");

        for(int i=0; i<lesserList.size();i++) {
            if (lesserList.get(i).getValue().compareTo("j")<0) {
                boolean isLessThanJ = false;
                Assert.assertFalse(isLessThanJ);
            }
        }
    }

    @Test
    public void getGreaterList() {
        Node a = new Node(null, null, "z");
        Node b = new Node(a, null, "j");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);
        Node d = new Node(c, null, "d");
        Node e = new Node(d, null, "e");
        d.setNext(e);
        LinkedList testList = new LinkedList(a, c, 3);
        testList.append(d);
        testList.append(e);

        ArrayList<Node> greaterList = Ch2Q4partition.getGreaterList(testList, "j");

        for(int i=0; i<greaterList.size();i++) {
            if (greaterList.get(i).getValue().compareTo("j")>=0) {
                boolean isGreaterThanJ = true;
                Assert.assertTrue(isGreaterThanJ);
            }
        }
    }

    @Test
    public void partitionAroundX() {
        Node a = new Node(null, null, "z");
        Node b = new Node(a, null, "j");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);
        Node d = new Node(c, null, "d");
        Node e = new Node(d, null, "e");
        d.setNext(e);
        LinkedList testList = new LinkedList(a, c, 3);
        testList.append(d);
        testList.append(e);

        ArrayList<Node> lesserList = Ch2Q4partition.getLesserList(testList, "j");
        ArrayList<Node> greaterList = Ch2Q4partition.getGreaterList(testList, "j");

        LinkedList partitionedList = Ch2Q4partition.partitionAroundX(lesserList, greaterList);

        Assert.assertEquals("c", partitionedList.get(0).getValue());
        Assert.assertEquals("d", partitionedList.get(1).getValue());
        Assert.assertEquals("e", partitionedList.get(2).getValue());
        Assert.assertEquals("z", partitionedList.get(3).getValue());
        Assert.assertEquals("j", partitionedList.get(4).getValue());
    }
}