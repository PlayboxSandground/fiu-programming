
 /**************************************************************
 Purpose/Description: ******
 Author’s Panther ID: 5636019
 Certification: Dianet Cruz 
 I hereby certify that this work is my own and none of it is the work of
 any other person.
**************************************************************/

package com.zelaznogydna;
import java.util.*;

public class Problem3 {

    static class BinarySearchTreeNode {

        int key;
        BinarySearchTreeNode left;
        BinarySearchTreeNode right;
    }

    static class BinarySearchTree {

      
        private BinarySearchTreeNode root;

        
        void insert(int key) {
        }

       
        void delete(int key) {
        }

        boolean find(int key) {
            return false;
        }


        public int positiveKeySum() {
            
            Queue<BinarySearchTreeNode> nodes = new ArrayDeque<>();
           
            int sum = 0;
          
            nodes.add(root);
        
            while (!nodes.isEmpty()) {
                
                BinarySearchTreeNode node = nodes.poll();
                
                sum += node.key;
                if (node.right != null) {
                    nodes.add(node.right);
                  
                }
                if (node.left != null) {
                    nodes.add(node.left);
                   
                }

            }
           
            return sum;
        }
        
        public void deleteMax() {
           
            Queue<BinarySearchTreeNode> nodes = new ArrayDeque<>();
           
            int max = Integer.MIN_VALUE;
            
            nodes.add(root);
            while (!nodes.isEmpty()) {
               
                BinarySearchTreeNode node = nodes.poll();
                
                if (max < node.key) {
                    
                    max = node.key;
                }
               
                if (node.right != null) {
                   
                    nodes.add(node.right);
                }
                
                if (node.left != null) {
                   
                    nodes.add(node.left);
                }

            }
             
            System.out.println("The maximum element is: " + max);
             
            delete(max);
        }

      
        void printTree() {
            
            Queue<BinarySearchTreeNode> nodes = new ArrayDeque<>();
            PriorityQueue<Integer> ordered = new PriorityQueue<>();
            
            nodes.add(root);
            while (!nodes.isEmpty()) {
               
            BinarySearchTreeNode node = nodes.poll();
               
                ordered.add(node.key);

                if (node.right != null) {
                    nodes.add(node.right);
                }
                 if (node.left != null) {
                    nodes.add(node.left);
                }
            }
            while (!ordered.isEmpty()) {
                System.out.print(ordered.poll() + " ");
            }
            System.out.println();
        }
     
        void printPostOrder() {
            postOrderSearch(root);
        }

        private void postOrderSearch(BinarySearchTreeNode node) {
            if (node == null) {
                return;
            }
            postOrderSearch(node.left);
            postOrderSearch(node.right);
            System.out.print(node.key + " ");
        }

    }
    

    }

