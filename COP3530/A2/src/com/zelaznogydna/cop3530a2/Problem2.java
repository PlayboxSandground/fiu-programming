/*
 * -----------------------------------------------------------
 * Purpose/Description: Methods on a BSTree.
 * Author’s Panther ID: 6184452
 * Certification:
 *      I hereby certify that this work is my own and none of it
 *      is the work of any other person.
 * -----------------------------------------------------------
 */
// package com.zelaznogydna.cop3530a2;

class BSTNode {
    public int key;
    public BSTNode left;
    public BSTNode right;
    public int size;
    public int N;
}

abstract public class BinarySearchTree {
    public BSTNode root;

    public void insert(int key) { }

    public void delete(int key) { }

    public boolean find(int key) { return true; }

    public int size() {
        return size(root);
    }

    private int size(BSTNode node) {
        if (node == null) return 0;
        else return node.size;
    }

    public int positiveKeySum() {
        return Sum(root);
    }

    private int Sum(BSTNode root) //helper method
    {
        if (root == null || root.key < 0) return 0;
        if ((root.left == null) && (root.right == null)) return 0; //both are null then 0
        return root.key + Sum(root.left) + Sum(root.right); //sum the left and the right node
    }

    private BSTNode deleteMax(BSTNode node) {
        if (node.right == null) return node.left;
        node.right = deleteMax(node.right);
        node.N = size(node.right) + size(node.left) + 1;
        return node;
    }

    public void printTree() {
        printTree(root); //calling the function
    }

    public void printTree(BSTNode node) {
        if (node == null)
            return;
        printTree(node.left); //first left node is printed
        System.out.print(node.key + " "); //then root
        printTree(node.right); // then right node
    }
}

