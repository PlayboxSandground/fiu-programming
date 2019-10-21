/*************************************************************
 * Purpose/Description: Assignment 1
 * Author’s Panther ID: 6184452
 * Certification:
 * I hereby certify that this work is my own and none of it is the work of any other person.
 * **************************************************************/


/*
*
* Problem 3:
-	Implement a sublinear running time complexity recursive function in Java
public static long exponentiation(long x, int n) to calculate xn.
Note: In your function you can use only the basic arithmetic operators (+, -, *, %, and /).
-	What is the running time complexity of your function? Justify.
-	Give a number of multiplications used by your function to calculate x63.
Important Notes:
	For the item (a):
-	you must add the main method in your program in order to test your implementation.
-	there are no data errors that need to be checked as all the data will be assumed correct.
-	your function you can use only the basic arithmetic operators (+, -, *, %, and /).
-	Your program MUST be submitted only in source code form (.java file).
-	A program that does not compile or does not run loses all correctness points
* */


package com.zelaznogydna;

public class Main3 {

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.println("2^(" + i + ")= " + exp(2, i));
        }

        System.out.println("b) What is the running time complexity of your function? Justify");
        System.out.println("b) O(logN) because every call divides input size by 2.\n");

        System.out.println("c) Give a number of multiplications used by your function to calculate x63.");
        System.out.println("c) 2^(63)= " + exp(2, 63));
        System.out.println("\n The number of multiplications is --> 18");


    }
    public static long exp(long base, int power) {
        long aux;
        if (power == 0)
            return 1;
        aux = exp(base, power / 2);
        if (power % 2 == 0) {
            return aux * aux;
        } else {
            return base * aux * aux;
        }
    }
}
