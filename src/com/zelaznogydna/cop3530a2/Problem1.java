/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zelaznogydna;


 /**************************************************************
 Purpose/Description:  method in Java to sort a stack of n integer numbers, s, in increasing order.
 Author’s Panther ID: 5636019
 Certification: Dianet Cruz 
 I hereby certify that this work is my own and none of it is the work of
 any other person.
**************************************************************/

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class Problem1 {

 
    public static Stack<Integer> sort(Stack<Integer> s) {
        
        Stack<Integer> stack = new Stack<>();
      
        while (!s.isEmpty()) {
          
            int n = s.pop();
       
            while (!stack.isEmpty() && (stack.peek() > n)) {
                
                s.push(stack.pop());
                
            }
            stack.push(n);
          
        }
        return stack;

    }
    
    public static void main(String[] args) {
       
        Stack<Integer> s = new Stack<>();
       
        s.push(4);
        s.push(0);
        s.push(10);
        s.push(8);
        s.push(12);
        s.push(6);
        s.push(14);
    
       
        s = Problem1.sort(s);
     
        while (!s.isEmpty()) {
            
            System.out.println(s.pop());
          
        }
    }
        /**
         * Part B- TIME COMPLEXITY.
         * I believe the time complexity for my program is O(n^2) because it is evident
         * it contains two while loops.
         */
    
        
    }
    
