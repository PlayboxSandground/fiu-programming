package com.zelaznogydna.cop3530a2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Stack;

public class BST<AnyType extends Comparable<AnyType>> implements Iterable<AnyType> {
    static class MyComp1 implements Comparator<Integer> {
        public int compare(Integer x, Integer y) {
            return y - x;
        }
    }

    public static void main(String[] args) {

    }

    private Node<AnyType> root;
    private Comparator<AnyType> comparator;

    private BST() {
        root = null;
        comparator = null;
    }

    public BST(Comparator<AnyType> comp) {
        root = null;
        comparator = comp;
    }

    private int compare(AnyType x, AnyType y) {
        if (comparator == null) return x.compareTo(y);
        else
            return comparator.compare(x, y);
    }

    /*****************************************************
     *
     *            INSERT
     *
     ******************************************************/
    public void insert(AnyType key) {
        root = insert(root, key);
    }

    private Node<AnyType> insert(Node<AnyType> p, AnyType toInsert) {
        if (p == null)
            return new Node<AnyType>(toInsert);

        if (compare(toInsert, p.key) == 0)
            return p;

        if (compare(toInsert, p.key) < 0)
            p.left = insert(p.left, toInsert);
        else
            p.right = insert(p.right, toInsert);

        return p;
    }

    /*****************************************************
     *
     *            SEARCH
     *
     ******************************************************/
    public boolean search(AnyType toSearch) {
        return search(root, toSearch);
    }

    private boolean search(Node<AnyType> p, AnyType toSearch) {
        if (p == null)
            return false;
        else if (compare(toSearch, p.key) == 0)
            return true;
        else if (compare(toSearch, p.key) < 0)
            return search(p.left, toSearch);
        else
            return search(p.right, toSearch);
    }

    /*****************************************************
     *
     *            DELETE
     *
     ******************************************************/

    public void delete(AnyType toDelete) {
        root = delete(root, toDelete);
    }

    private Node<AnyType> delete(Node<AnyType> p, AnyType toDelete) {
        if (p == null) throw new RuntimeException("cannot delete.");
        else if (compare(toDelete, p.key) < 0)
            p.left = delete(p.left, toDelete);
        else if (compare(toDelete, p.key) > 0)
            p.right = delete(p.right, toDelete);
        else {
            if (p.left == null) return p.right;
            else if (p.right == null) return p.left;
            else {
                // get key from the rightmost node in the left subtree
                p.key = retrieveData(p.left);
                // delete the rightmost node in the left subtree
                p.left = delete(p.left, p.key);
            }
        }
        return p;
    }

    private AnyType retrieveData(Node<AnyType> p) {
        while (p.right != null) p = p.right;

        return p.key;
    }

    /*************************************************
     *
     *            toString
     *
     **************************************************/

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (AnyType key : this) sb.append(key.toString());

        return sb.toString();
    }

    /*************************************************
     *
     *            TRAVERSAL
     *
     **************************************************/

    public void preOrderTraversal() {
        preOrderHelper(root);
    }

    private void preOrderHelper(Node r) {
        if (r != null) {
            System.out.print(r + " ");
            preOrderHelper(r.left);
            preOrderHelper(r.right);
        }
    }

    public void inOrderTraversal() {
        inOrderHelper(root);
    }

    private void inOrderHelper(Node r) {
        if (r != null) {
            inOrderHelper(r.left);
            System.out.print(r + " ");
            inOrderHelper(r.right);
        }
    }

    /*************************************************
     *
     *            CLONE
     *
     **************************************************/

    public BST<AnyType> clone() {
        BST<AnyType> twin = null;

        if (comparator == null)
            twin = new BST<AnyType>();
        else
            twin = new BST<AnyType>(comparator);

        twin.root = cloneHelper(root);
        return twin;
    }

    private Node<AnyType> cloneHelper(Node<AnyType> p) {
        if (p == null)
            return null;
        else
            return new Node<AnyType>(p.key, cloneHelper(p.left), cloneHelper(p.right));
    }

    /*************************************************
     *
     *            MISC
     *
     **************************************************/

    public int height() {
        return height(root);
    }

    private int height(Node<AnyType> p) {
        if (p == null) return -1;
        else
            return 1 + Math.max(height(p.left), height(p.right));
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node<AnyType> p) {
        if (p == null) return 0;
        else if (p.left == null && p.right == null) return 1;
        else
            return countLeaves(p.left) + countLeaves(p.right);
    }


    //This method restores a BST given preorder and inorder traversals
    public void restore(AnyType[] pre, AnyType[] in) {
        root = restore(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private Node<AnyType> restore(AnyType[] pre, int preL, int preR, AnyType[] in, int inL, int inR) {
        if (preL <= preR) {
            int count = 0;
            //find the root in the inorder array
            while (pre[preL] != in[inL + count]) count++;

            Node<AnyType> tmp = new Node<AnyType>(pre[preL]);
            tmp.left = restore(pre, preL + 1, preL + count, in, inL, inL + count - 1);
            tmp.right = restore(pre, preL + count + 1, preR, in, inL + count + 1, inR);
            return tmp;
        } else
            return null;
    }


    //The width of a binary tree is the maximum number of elements on one level of the tree.
    public int width() {
        int max = 0;
        for (int k = 0; k <= height(); k++) {
            int tmp = width(root, k);
            if (tmp > max) max = tmp;
        }
        return max;
    }

    //returns the number of node on a given level
    public int width(Node<AnyType> p, int depth) {
        if (p == null) return 0;
        else if (depth == 0) return 1;
        else
            return width(p.left, depth - 1) + width(p.right, depth - 1);
    }

    //The diameter of a tree is the number of nodes
    //on the longest path between two leaves in the tree.
    public int diameter() {
        return diameter(root);
    }

    private int diameter(Node<AnyType> p) {
        if (p == null) return 0;

        //the path goes through the root
        int len1 = height(p.left) + height(p.right) + 3;

        //the path does not pass the root
        int len2 = Math.max(diameter(p.left), diameter(p.right));

        return Math.max(len1, len2);
    }


    /*****************************************************
     *
     *            TREE ITERATOR
     *
     ******************************************************/

    public Iterator<AnyType> iterator() {
        return new MyIterator();
    }

    //pre-order
    private class MyIterator implements Iterator<AnyType> {
        Stack<Node<AnyType>> stk = new Stack<Node<AnyType>>();

        public MyIterator() {
            if (root != null) stk.push(root);
        }

        public boolean hasNext() {
            return !stk.isEmpty();
        }
        public AnyType next() {
            Node<AnyType> cur = stk.peek();
            if (cur.left != null) {
                stk.push(cur.left);
            } else {
                Node<AnyType> tmp = stk.pop();
                while (tmp.right == null) {
                    if (stk.isEmpty()) return cur.key;
                    tmp = stk.pop();
                }
                stk.push(tmp.right);
            }

            return cur.key;
        }//end of next()
        public void remove() {
        }
    }//end of MyIterator

    /*****************************************************
     *
     *            the Node class
     *
     ******************************************************/
    private class Node<T> {
        private T key;
        private Node<T> left, right;

        public Node(T key, Node<T> l, Node<T> r) {
            left = l;
            right = r;
            this.key = key;
        }

        public Node(T key) {
            this(key, null, null);
        }

        public String toString() {
            return key.toString();
        }
    } //end of Node
}//end of BST

