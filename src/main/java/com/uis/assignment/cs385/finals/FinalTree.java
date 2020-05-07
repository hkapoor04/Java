package com.uis.assignment.cs385.finals;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class FinalTree<E extends Comparable<? super E>> {

    private Node<E> root;
    private int size;

    public FinalTree() {
        root = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E newItem) {
        if (isEmpty()) {
            root = new Node<E>(newItem);
        } else {
            Node<E> parent = null;
            Node<E> temp = root;
            int result = 0;
            while (temp != null) {
                parent = temp;
                result = newItem.compareTo(temp.data);
                if (result < 0) {
                    temp = temp.left;
                } else if (result > 0) {
                    temp = temp.right;
                } else {
                    return;
                }
            }
            if (result < 0) {
                parent.left = new Node<E>(newItem);
            } else if (result > 0) {
                parent.right = new Node<E>(newItem);
            }
        }
        size += 1;
    }

    /***** STUDENT CODE HERE *********************************************/

    public LinkedList<E> getCrown(E dataToGetCrownOf) {
        LinkedList<E> result = new LinkedList<E>();
        /*** You may add code here ******/

        /*********************************/

        Node<E> node = findNode(root, dataToGetCrownOf); //-- calling method to find the node corresponding to data

        if (node != null) { //-- check if data node exists
            if (node.left != null && node.right != null) {
                findLeafNode(node, result); //-- calling method to find the leaf node of the data node
            }
        } else {
            throw new NoSuchElementException(); //-- else throwing exception
        }
        return result;
    }

    /*
     * This method finds the node corresponding to the data
     *
     * @param - Node, the root node
     *
     * @param - key, the data whose node needs to be determined
     *
     * @return - the node corresponding to the data
     */
    private Node<E> findNode(Node<E> root, E key) {
        //-- checking if the node data is equal to the data
        if (root == null || key.compareTo(root.data) == 0)
            return root;
        if (key.compareTo(root.data) > 0) {
            return findNode(root.right, key); //-- recursion call to check if data/node exists on the right side of tree
        }
        return findNode(root.left, key); //-- recursion call to check if data/node exists on the right side of tree
    }

    /*
     * This method finds the leaf node corresponding to the data node
     *
     * @param - Node, the root node
     *
     * @param - LinkedList - the list for adding the
     *
     */
    private void findLeafNode(Node<E> node, LinkedList<E> result) {
        if (node.left == null && node.right == null) {
            result.add(node.data); //-- adding the data at leaf node to the list
        }
        if (node.left != null) {
            findLeafNode(node.left, result); //-- recursion call to left sub tree to find the leaf node
        }
        if (node.right != null) {
            findLeafNode(node.right, result); //-- recursion call to right sub tree to find the leaf node
        }
    }

    /*******************************************************************/

    class Node<T> {
        Node<T> left;
        Node<T> right;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        String test1 = "NMQGHADTSRPO";
        FinalTree<String> ft1 = new FinalTree<>();
        for (Character c : test1.toCharArray()) {
            ft1.add(c.toString());
        }

        System.out.println("N Crown: " + ft1.getCrown("N")); // Should print [D, H, O, R]
        System.out.println("R Crown: " + ft1.getCrown("R")); // Should print []

        FinalTree<Integer> ft2 = new FinalTree<>();
        Integer arr[] = new Integer[] { 500, 250, 750, 125, 375, 625, 850, 62, 187, 312, 437, 550, 650, 775, 900, 58,
                77, 343, 575, 770, 975, 93, 765, 773 };
        for (Integer i : arr) {
            ft2.add(i);
        }
        System.out.println("125 Crown: " + ft2.getCrown(125)); // Should print [58, 93, 187]
        System.out.println("750 Crown: " + ft2.getCrown(750)); // Should print [575, 650, 765, 773, 975]

        FinalTree<String> ft3 = new FinalTree<>();
        try {
            ft3.getCrown("G");
            System.out.println("You should raise an exception if the element is not found");
        } catch (NoSuchElementException e) {
            System.out.println("You raised a NoSuchElementException.");
        }

        FinalTree<Integer> ft4 = new FinalTree<>();
        Integer arr1[] = new Integer[] { 50, 75, 65, 85, 80, 25, 30 };
        for (Integer i : arr1) {
            ft4.add(i);
        }
        System.out.println("50 Crown: " + ft4.getCrown(50)); // Should print [30, 65, 80]
        System.out.println("75 Crown: " + ft4.getCrown(75)); // Should print [65, 80]

        FinalTree<Integer> ft5 = new FinalTree<>();
        Integer arr2[] = new Integer[] {50};
        for (Integer i : arr2) {
            ft5.add(i);
        }
        System.out.println("50 Crown: " + ft5.getCrown(50)); // Should print []

    }
}
