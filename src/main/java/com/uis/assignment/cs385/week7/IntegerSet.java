package com.uis.assignment.cs385.week7;


public class IntegerSet {

    //-- variable to store the root of type Node
    private Node root;

    //-- variable to store the size of BST of type int
    private int size;

    public boolean add(int newItem) {
        //-- check if the BST is empty
        if (isEmpty()) {
            //-- if true then the new item is assigned to the root
            root = new Node(newItem);
        } else {
            //-- declaring a parent node
            Node parent = null;
            //-- declaring a temp node and assigning as root
            Node temp = root;

            //-- start iterating until a leaf is reached
            while (temp != null) {
                //-- the parent node is assigned as root for each individual sub tree
                parent = temp;

                //-- check for new inserted data item to be less than root node data
                if (newItem < temp.data) {
                    temp = temp.left; //-- assigning temp with the reference of left node
                } else if (newItem > temp.data) { //-- check for new inserted data item to be greater than root node data
                    temp = temp.right; //-- assigning temp with the reference of right node
                } else {
                    return false; //-- returning false in case of duplicate data
                }
            }

            if (newItem < parent.data) { //-- check for new data to be less than parent node's data
                parent.left = new Node(newItem); //-- assigning new data item as left child
            } else {
                parent.right = new Node(newItem); //-- assigning new data item as right child
            }
        }
        size += 1; //-- incrementing the list size with each addition
        return true;
    }

    public boolean contains(int itemToFind) {
        return searchItem(root, itemToFind);
    }

    /*
     * This method searches an item in the current BST
     *
     * param Node - The current node to traverse
     * @param itemToFind - The item needs to be looked upon
     * @return - boolean, the result of item found/not found
     */
    private boolean searchItem(Node current, int itemToFind) {
        if (current == null) {
            return false;
        }
        //-- check for item found in root
        if (itemToFind == current.data) {
            return true;
        }
        if (itemToFind < current.data) { //-- checking if item is less than root data
            return searchItem(current.left, itemToFind); //-- traversing the left side of BST
        } else {
            return searchItem(current.right, itemToFind); //-- traversing the right side of BST otherwise
        }
    }

    /*
     * This method finds the union of two BSTs
     *
     * @return - IntegerSet, the new BST object with union of two BSTs
     */
    public IntegerSet union(IntegerSet other) {
        //-- creating new object of type IntegerSet to store the resulting BST
        IntegerSet integerSet = new IntegerSet();
        //-- calling inOrder Traversal for caller object
        inOrderTraverse(this.root, integerSet);
        //-- calling inOrder Traversal for parameter object
        inOrderTraverse(other.root, integerSet);
        return integerSet;
    }

    /*
     * This method finds the intersection of two BSTs
     *
     * @return - IntegerSet, the new BST object with intersection of two BSTs
     */
    public IntegerSet intersection(IntegerSet other) {
        //-- creating new object of type IntegerSet to store the resulting BST
        IntegerSet integerSet = new IntegerSet();
        //-- calling inOrder Traversal for parameter object
        inOrderTraverseIntersection(other.root, integerSet);
        return integerSet;
    }

    public int magnitude() {
        return size;
    }

    /*
     * This method prints the content of the BST
     *
     * @return - String, the string representation of the node values
     */
    public String toString() {
        //-- declaring new StringBuffer type object
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        //-- doing an inOrder Traversal for reaching each node
        inOrderTraverseToString(root, sb);
        sb.append("]");
        return sb.toString();
    }

    /*
     * This method does the inOrder Traversal of Binary Search Tree(BST) and creates String representation
     *
     * @param Node - The current node to traverse
     * @param - StringBuffer - The StringBuffer object
     */
    private void inOrderTraverseToString(Node current, StringBuffer sb) {
        if (current != null) {
            //-- recursively calling the method to traverse the left nodes first
            inOrderTraverseToString(current.left, sb);

            if (current.left != null) {
                //-- appending comma between each element of the left nodes
                sb.append(", ");
            }
            //-- appending the data of current node to the StringBuffer object
            sb.append(current.data);

            if (current.right != null) {
                //-- appending comma between each element of the left nodes
                sb.append(", ");
            }
            //-- recursively calling the method to traverse the right nodes next
            inOrderTraverseToString(current.right, sb);

        }
    }

    /*
     * This method does the inOrder Traversal of Binary Search Tree(BST) and creates a BST with all unique elements between two BSTs
     *
     * @param Node - The current node to traverse
     * @param - IntegerSet - The new BST object that is populated with unique elements
     */
    private void inOrderTraverse(Node current, IntegerSet integerSet) {
        if (current != null) {
            //-- adding data to the new object
            integerSet.add(current.data);

            //-- recursively calling the method to traverse the left nodes first
            inOrderTraverse(current.left, integerSet);

            //-- recursively calling the method to traverse the right nodes next
            inOrderTraverse(current.right, integerSet);
        }
    }

    /*
     * This method does the inOrder Traversal of Binary Search Tree(BST) and creates a BST with only common elements
     *
     * @param Node - The current node to traverse
     * @param - IntegerSet - The new BST object that is populated with common elements
     */
    private void inOrderTraverseIntersection(Node current, IntegerSet integerSet) {
        //-- condition to check if the caller object contains any of the data of the parameter object
        if (current != null && this.contains(current.data)) {
            //-- adding data to the new object
            integerSet.add(current.data);

            //-- recursively calling the method to traverse the left nodes first
            inOrderTraverseIntersection(current.left, integerSet);

            //-- recursively calling the method to traverse the right nodes next
            inOrderTraverseIntersection(current.right, integerSet);
        }
    }

    /*
     * This method checks whether the list is empty or not
     *
     * @return boolean - true if size is 0, false other wise
     */
    public boolean isEmpty() {
        //-- returns the result of size being zero or not
        return size == 0;
    }

    /*
     * Declaring class Node
     */
    private class Node {

        //-- variable to store data of a node of int type
        int data;

        //-- variable to store the reference of left node
        private Node left;

        //-- variable to store the reference of right node
        private Node right;

        //-- The constructor that initializes the node and assigns data to it
        public Node(int data) {
            this.data = data;
        }

    }
}
