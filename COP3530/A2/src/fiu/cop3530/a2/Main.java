/**************************************************************
 Purpose/Description: <a brief description of the program>
 Author’s Panther ID: 6184452
 Certification:
 I hereby certify that this work is my own and none of it is the work of
 any other person.
 **************************************************************/

package fiu.cop3530.a2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        int a = 0;

        System.out.println("[--------------]\nCOP3530 - Antonio Bajuelos\nPID6184452's Assignment 2\n[--------------]\n");

        ArrayList<Integer> L1 = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 6, 9));
        ArrayList<Integer> L2 = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 7, 9, 10, 11));
        ArrayList<Integer> Difference = new ArrayList<Integer>();

        difference(L2, L1, Difference);
    }

    public static <AnyType extends Comparable<? super AnyType>> void difference(List<AnyType> L1, List<AnyType> L2, List<AnyType> Difference) {
        ListIterator<AnyType> iterL1 = L1.listIterator();
        ListIterator<AnyType> iterL2 = L2.listIterator();
        AnyType itemL1 = null;
        AnyType itemL2 = null;

        if (iterL1.hasNext() && iterL2.hasNext()) {
            itemL1 = iterL1.next();
            itemL2 = iterL2.next();
        }

        int iterations = 0;
        while (iterL1.hasNext()) {
            System.out.println("iteration: " + iterations++);
            if (iterL2.hasNext()) {
                if (itemL2.compareTo(itemL1) > 0) {
                    Difference.add(itemL1);
                    itemL1 = iterL1.next();
                } else if (itemL2.compareTo(itemL1) < 0)
                    itemL2 = iterL2.next();
                else {
                    itemL2 = iterL2.next();
                    itemL1 = iterL1.next();
                }
            } else {
                Difference.add(itemL1);
                itemL1 = iterL1.next();
            }
        }
        System.out.println(Difference);
    }
}



