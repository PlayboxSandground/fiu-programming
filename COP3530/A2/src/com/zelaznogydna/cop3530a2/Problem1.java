/*
 * -----------------------------------------------------------
 * Purpose/Description: Finding the difference between sets.
 * Author’s Panther ID: 6184452
 * Certification:
 *      I hereby certify that this work is my own and none of it
 *      is the work of any other person.
 * -----------------------------------------------------------
 */
// package com.zelaznogydna.cop3530a2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Problem1 {
    public static <AnyType extends Comparable<? super AnyType>> void difference(List<AnyType> L1, List<AnyType> L2, List<AnyType> Difference) {
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        AnyType itemL1 = null, itemL2 = null;
        if (iterL1.hasNext() && iterL2.hasNext()) {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }
        int size = Math.max(L1.size(), L2.size());
        Difference = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (itemL1 == itemL2) {
                itemL1 = iterL1.next();
                itemL2 = iterL2.next();
            } else if (itemL1.compareTo(itemL2) > 0) {
                Difference.add(itemL2);
                itemL2 = iterL2.next();
            } else if (i == size - 1) {
                Difference.add(itemL1);
                Difference.add(itemL2);
            } else {
                Difference.add(itemL1);
                itemL1 = iterL1.next();
            }
        }
        System.out.println(Difference);
    }

    public static void main(String args[]) {
        MyList<Integer> myList = new MyList<>();
        myList.myPush(10);
        Integer temp = myList.myPop();
        System.out.println(temp);
        myList.myInject(20);
    }

    public static class MyList<E> //generic class
    {
        private LinkedList<E> list;
        MyList() {
            list = new LinkedList<>();
        }
        void myPush(E x) {
            list.addFirst(x);
        }
        E myPop() {
            return list.getFirst();
        }
        void myInject(E x) {
            list.addLast(x);
        }
    }
}

