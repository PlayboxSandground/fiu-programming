/*************************************************************
 * Purpose/Description: Assignment 1
 * Author’s Panther ID: 6184452
 * Certification:
 * I hereby certify that this work is my own and none of it is the work of any other person.
 * **************************************************************/



/*
*
*
* Problem 1: Write a linear running time complexity program in Java to find all the dominant elements in the given array of integers.
An element is a dominant element if is greater than all the elements to its right side. The rightmost element in the array is always a dominant element.
For example, in the array {16, 17, 4, 3, 5, 2}, dominant elements are 17, 5 and 2. Important Notes:
* • You must add the main method in your program in order to test your implementation.
* • There are no data errors that need to be checked as all the data will be assumed correct.
* • You can use the array of the previous example to test your program, however, I suggest that you also use other input arrays to validate the correctness and efficiency of your solution.
* • Your program MUST be submitted only in source code form (.java file).
* • A program that does not compile or does not run loses all correctness points.
* */
package com.zelaznogydna;

public class Main {

    public static void main(String[] args) {
        printDominantItems(new int[]{16, 17, 4, 3, 5, 2});
    }

    public static void printDominantItems(int[] col) {
        int n = col.length;
        int[] domItems = new int[n];
        int domItemsLength = 0;
        int maxRight;
        maxRight = col[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                domItems[n - 1 - domItemsLength] = col[i];
                domItemsLength++;
            } else {
                if (col[i] <= maxRight) {
                    continue;
                }
                domItems[n - 1 - domItemsLength] = col[i];
                domItemsLength++;
                maxRight = col[i];
            }
        }
        System.out.print("Dominant items: ");
        for (int i = n - domItemsLength; i < n; i++) {
            System.out.print(domItems[i] + " ");
        }
        System.out.println();
    }
}
