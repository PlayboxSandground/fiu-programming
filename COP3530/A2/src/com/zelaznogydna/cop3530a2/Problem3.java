/*
 * -----------------------------------------------------------
 * Purpose/Description: Sorting a stack in ascending order
 * Author’s Panther ID: 6184452
 * Certification:
 *      I hereby certify that this work is my own and none of it
 *      is the work of any other person.
 * -----------------------------------------------------------
 */
// package com.zelaznogydna.cop3530a2;

import java.util.Stack;

/**
 * The complexity for this algorithm is O(N*logN), after I implemented a very non-efficient O(n^2) solution;
 * I found this optimized solution online and modified it in order to sort
 */
public class Problem3{
    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return stack;
        }
        int pivot = stack.pop();
        // Partitioning...
        Stack<Integer> left  = new Stack<Integer>();
        Stack<Integer> right = new Stack<Integer>();
        while(!stack.isEmpty()) {
            int element = stack.pop();
            if (element < pivot) {
                left.push(element);
            } else {
                right.push(element);
            }
        }
        sortStack(left);
        sortStack(right);

        // Merging...
        Stack<Integer> temp = new Stack<Integer>();
        while(!right.isEmpty()) {
            temp.push(right.pop());
        }
        temp.push(pivot);
        while(!left.isEmpty()) {
            temp.push(left.pop());
        }
        while(!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        return stack;
    }
}




