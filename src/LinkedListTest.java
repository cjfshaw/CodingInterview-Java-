import org.junit.Assert;
import org.junit.Test;
import sun.awt.image.ImageWatched;

import static org.junit.Assert.*;

public class LinkedListTest {

    @Test
    public void getFirst() {
        Node a = new Node(null, null, "a");
        Node b = new Node(a, null, "b");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);

        LinkedList testList = new LinkedList(a, c, 3);

        Assert.assertEquals(a, testList.getFirst());
    }

    @Test
    public void getLast() {
        Node a = new Node(null, null, "a");
        Node b = new Node(a, null, "b");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);

        LinkedList testList = new LinkedList(a, c, 3);

        Assert.assertEquals(c, testList.getLast());
    }

    @Test
    public void getSize() {
        Node a = new Node(null, null, "a");
        Node b = new Node(a, null, "b");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);

        LinkedList testList = new LinkedList(a, c, 3);

        Assert.assertEquals(3, testList.getSize());
    }

    @Test
    public void get() {
        Node a = new Node(null, null, "a");
        Node b = new Node(a, null, "b");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);

        LinkedList testList = new LinkedList(a, c, 3);

        Assert.assertEquals(b, testList.get(1));
    }

    @Test
    public void add() {
        Node a = new Node(null, null, "a");
        Node b = new Node(a, null, "b");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);

        LinkedList testList = new LinkedList(a, c, 3);

        Node d = new Node(null, null, "d");

        testList.add(d, 1);

        Assert.assertEquals(4, testList.getSize());
        Assert.assertEquals(d, testList.get(1));
        Assert.assertEquals(a, d.getPrevious());
        Assert.assertEquals(b, d.getNext());
        Assert.assertEquals(4, testList.getSize());

        Node e = new Node(null, null, "e");

        testList.add(e, testList.getSize()-1);

        Assert.assertEquals(e, testList.getLast());
        Assert.assertEquals(5, testList.getSize());
        Assert.assertEquals(c, e.previous);
        Assert.assertEquals(null, e.getNext());

        Node f = new Node(null, null, "f");

        testList.add(f, 0);

        Assert.assertEquals(f, testList.getFirst());
        Assert.assertEquals(6, testList.getSize());
        Assert.assertEquals(null, f.getPrevious());
        Assert.assertEquals(a, f.getNext());
    }

    @Test
    public void append() {
        Node a = new Node(null, null, "a");
        Node b = new Node(a, null, "b");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);

        LinkedList testList = new LinkedList(a, c, 3);

        Node d = new Node(null, null, "d");

        testList.append(d);

        Assert.assertEquals(4, testList.getSize());
        Assert.assertEquals(d, testList.getLast());
        Assert.assertEquals(c, d.getPrevious());
        Assert.assertEquals(null, d.getNext());
    }

    @Test
    public void remove() {
        Node a = new Node(null, null, "a");
        Node b = new Node(a, null, "b");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);
        Node d = new Node(null, null, "d");
        Node e = new Node(null, null, "e");

        LinkedList testList = new LinkedList(a, c, 3);
        testList.append(d);
        testList.append(e);

        testList.remove(0);

        Assert.assertEquals(b, testList.getFirst());
        Assert.assertEquals(4, testList.getSize());
        Assert.assertEquals(null, b.getPrevious());
        Assert.assertEquals(c, b.getNext());

        testList.remove(testList.getSize()-1);

        Assert.assertEquals(d, testList.getLast());
        Assert.assertEquals(3, testList.getSize());
        Assert.assertEquals(c, d.getPrevious());
        Assert.assertEquals(null, d.getNext());

        testList.remove(1);

        Assert.assertEquals(2, testList.getSize());
        Assert.assertEquals(d, b.getNext());
        Assert.assertEquals(b, d.getPrevious());
    }

    @Test
    public void replace() {
        Node a = new Node(null, null, "a");
        Node b = new Node(a, null, "b");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);

        LinkedList testList = new LinkedList(a, c, 3);

        Node d = new Node(null, null, "d");

        testList.replace(d, 1);

        Assert.assertEquals(d, testList.get(1));
        Assert.assertEquals(3, testList.getSize());
        Assert.assertEquals(a, d.getPrevious());
        Assert.assertEquals(c, d.getNext());
    }

    @Test
    public void isListCyclical() {
        Node a = new Node(null, null, "a");
        Node b = new Node(a, null, "b");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);
        Node d = new Node(null, null, "d");
        Node e = new Node(null, null, "e");

        LinkedList testList = new LinkedList(a, c, 3);
        testList.append(d);
        testList.append(e);

        e.setNext(c);

        boolean isCyclical = testList.isListCyclical();

        Assert.assertTrue(isCyclical);
    }

    @Test
    public void removeDuplicates() {
        Node a = new Node(null, null, "a");
        Node b = new Node(a, null, "b");
        Node c = new Node(b, null, "c");
        a.setNext(b);
        b.setNext(c);
        Node d = new Node(null, null, "c");
        Node e = new Node(null, null, "c");

        LinkedList testList = new LinkedList(a, c, 3);

        testList.add(d, 0);
        testList.append(e);

        testList.removeDuplicates();

        Assert.assertEquals(3, testList.getSize());
    }
}