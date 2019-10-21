/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zelaznogydna;

/**
 *
 * @author Dianet Cruz
 */
 /**************************************************************
 Purpose/Description:  method in Java to sort a stack of n integer numbers, s, in increasing order.
 Author’s Panther ID: 5636019
 Certification: Dianet Cruz 
 I hereby certify that this work is my own and none of it is the work of
 any other person.
**************************************************************/

public class Problem2 {

    public static class MyList<T> {
   
        private Node<T> front;
        
        private Node<T> back;
       

        public void myPush(T type) {
           
            if (front == null && back == null) {
                
                front = back = new Node(type, null);
                
            }
            
            else 
            
            {
                
                Node node = new Node(type, front);
               
                front = node;
            }
        }

        public T myPop() {
         
            if (front != null) {
              
                Node temp = front;
               
                front = front.getNext();
               
                return (T) temp.getData();
                
            }
            return null;
            
        }

        public void myInject(T type) {
                      
            if (front == null && back == null) {
               
                front = back = new Node(type, null);
                
            } else {
                
                Node node = new Node(type, null);
             
                back.setNext(node);
                
                back = node;
               

            }

        }

        public void print() {
          
            Node node = front;
            
            while (node != null) {
              
                System.out.println(node.getData());
              
                node = node.getNext();
               
            }

        }
    }

    public static void main(String[] args) {

        MyList<Integer> myList = new MyList<>();
        
        myList.myPush(5); 

        myList.myPush(8); 

        myList.myInject(9); 
       
        System.out.println("First List:");
        
        myList.print(); 

        myList.myPop(); 
        
        System.out.println("Removing the iteam in the front using myPop() Method:");

        myList.print(); 

    }
    
}

class Node<T> {

    T data;

    Node next;

    public Node(T data, Node next) {

        super();

        this.data = data;

        this.next = next;

    }

    public T getData() {

        return data;

    }

    public void setData(T data) {

        this.data = data;

    }

    public Node getNext() {

        return next;

    }

    public void setNext(Node next) {

        this.next = next;

    }

}

