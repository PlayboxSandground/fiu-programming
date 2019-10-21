/*************************************************************
 * Purpose/Description: Assignment 1
 * Author’s Panther ID: 6184452
 * Certification:
 * I hereby certify that this work is my own and none of it is the work of any other person.
 * **************************************************************/



/*
*
*
* Problem 2:
Write a program in Java to implement a recursive search function
int terSearch(int A[], int l, int r, int x)
that returns the location of x in a given sorted array of n integers A if x is present, otherwise -1.
The terSearch search function, unlike the binary search, must consider two dividing points
int d1 = l + (r - l)/3
int d2 = d1 + (r - l)/3
For the first call of your recursive search function terSearch you must consider l = 0 and r = A.length - 1.
Important Notes:
- For this problem you must add the main method in your program in order to test your implementation.
- There are no data errors that need to be checked as all the data will be assumed correct.
- Your program MUST be submitted only in source code form (.java file).
- A program that does not compile or does not run loses all correctness points.

* */
package com.zelaznogydna;

public class Main2 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

        for (int x :
                arr) {
            System.out.print(x + ", ");
        }

        int a = terSearch(arr, 0, arr.length - 1, 30);
        System.out.println("\nYour number is at index: " + a);

    }

    public static int terSearch(int[] A, int l, int r, int x) {

        if (r >= l)
        {
            /*calculate mid1 value */
            int mid1 = l + (r - l)/3;
            /*calculate mid2 value */
            int mid2 = mid1 + (r - l)/3;

            /*If x is present at the mid1 it will return mid1 */
            if (A[mid1] == x) return mid1;

            /*If x is present at the mid2 it will return mid2 */
            if (A[mid2] == x) return mid2;

            //If x is present in left one-third
            if (x < A[mid1]) return terSearch(A, l, mid1-1, x);

            // If x is present in right one-third
            if (x > A[mid2] ) return terSearch(A, mid2+1, r, x);

            // If x is present in middle one-third
            return terSearch(A, mid1+1, mid2-1, x);
        }
        return -1;
    }
}
