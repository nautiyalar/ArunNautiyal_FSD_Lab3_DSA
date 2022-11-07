package com.greatlearning.lab3.q1;
import java.io.*;
import java.util.*;

class BinarySearchTree {
 
    // Root of BST
    Node root;
 
    // Constructor
    BinarySearchTree() { root = null; }
    void insert(int key) { root = insertRec(root, key); }
 
    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int data)
    {
 
        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(data);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);
 
        return root;
    }
   
    boolean isPairPresent(Node root, Node temp, int target)
    {
        if (temp == null)
            return false;
 
        return search(root, temp, target - temp.data)
            || isPairPresent(root, temp.left, target)
            || isPairPresent(root, temp.right, target);
    }
 
    boolean search(Node root, Node temp, int k)
    {
 
        if (root == null)
            return false;
 
        Node c = root;
        boolean flag = false;
        while (c != null && flag != true) {
            if (c.data == k && temp != c) {
                flag = true;
                System.out.println("Pair is ( " + temp.data
                                   + " , " + c.data+")");
                return true;
            }
            else if (k < c.data)
                c = c.left;
            else
                c = c.right;
        }
 
        return false;
    }
 
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
               
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(60);
        tree.insert(50);
        tree.insert(70);
       
        boolean test
            = tree.isPairPresent(tree.root, tree.root, 130);
        if (!test)
            System.out.println("Nodes are not found!");
       
        
        
    }
}