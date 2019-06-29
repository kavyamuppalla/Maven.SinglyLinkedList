package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest() {
        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
        sl.add(1);
        Assert.assertEquals(1,sl.size());
    }

    @Test
    public void removeTest() {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.add(1);
        sl.remove(1);
        Assert.assertEquals(0,sl.size());
    }

    @Test
    public void containsTest() {
        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
        sl.add(1);
        Assert.assertTrue(sl.contains(1));
    }
    @Test
    public void findTest() {

        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
        sl.add(1);
        sl.add(2);
        Assert.assertEquals(0, sl.find(1));
        Assert.assertEquals(1, sl.find(2));
    }
    @Test
    public void sizeTest() {
        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
        sl.add(1);
        sl.add(2);
        Assert.assertEquals(2, sl.size());
    }
    @Test
    public void getTest() {
        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        Assert.assertEquals(3, sl.get(2).intValue());
    }
    @Test
    public void setTest() {
        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        sl.set(2, 9);
        Assert.assertEquals(9, sl.get(2).intValue());
    }
    @Test
    public void copyTest() {

        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
        sl.add(1);
        sl.add(2);
        sl.add(3);
        sl.add(4);
        SinglyLinkedList<Integer> copy = sl.copy();
        Assert.assertNotEquals(sl, copy);
        Assert.assertEquals(sl.size(), copy.size());
        Assert.assertEquals(1, copy.get(0).intValue());
    }
    @Test
    public void sortTest() {

        SinglyLinkedList<Integer> sl = new SinglyLinkedList<Integer>();
        sl.add(9);
        sl.add(2);
        sl.add(5);
        sl.add(0);
        sl.sort();

        Assert.assertEquals(0, sl.get(0).intValue());
        Assert.assertEquals(2, sl.get(1).intValue());
        Assert.assertEquals(5, sl.get(2).intValue());
        Assert.assertEquals(9, sl.get(3).intValue());
    }


}
