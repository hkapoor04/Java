package com.uis.assignment.cs385.extracredit.part1;

public class AVLTreePart1 {

    //-- variable to store the root of type Node
    public Node root;

    private int size;

    public boolean add(int newItem) {

        //-- declaring a parent node
        Node parent = null;
        //-- check if the BST is empty
        if (isEmpty()) {
            //-- if true then the new item is assigned to the root
            root = new Node(newItem);
        } else {

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

    /*
     * This method does the right rotation of the content of the BST
     *
     * @param - Node, the
     *
     * @return - Node, the root node of the AVL tree
     */
    private Node rightRotation(Node currentNode) {

        root = currentNode.left; //-- the left node becomes the new parent node
        Node middleNode = root.right; //-- variable to store right node of left child

        root.right = currentNode; //-- the current node becomes the right node of new parent node
        currentNode.left = middleNode; //-- the right node of left child becomes left node

        currentNode.height = Math.max(getHeight(currentNode.left), getHeight(currentNode.right)) + 1; //-- re-adjusting the height of AVL tree after rotation
        root.height = Math.max(getHeight(root.left), getHeight(root.right)); //-- re-adjusting the height of new parent node after rotation

        return root;
    }

    /*
     * This method does the left rotation of the content of the BST
     *
     * @return - Node, the root node of the AVL tree
     */
    private Node leftRotation(Node currentNode) {

        root = currentNode.right; //-- the right node becomes the new parent node
        Node middleNode = root.left; //-- variable to store left node of right child

        root.left = currentNode; //-- the current node becomes the left node of new parent node
        currentNode.right = middleNode; //-- the left node of right child becomes right node

        currentNode.height = Math.max(getHeight(currentNode.left), getHeight(currentNode.right)) + 1; //-- re-adjusting the height of AVL tree after rotation
        root.height = Math.max(getHeight(root.left), getHeight(root.right)); //-- re-adjusting the height of new parent node after rotation

        return root;
    }

    /*
     * This method adds the new element to BST, checks for balance and balances it if the tree is out of balance
     *
     * @param Node - the node of BST
     *
     * @param newItem - the data to be added
     *
     * @return - Node, the root node of the AVL tree
     */
    public Node checkBalanceAndRotate(Node parent, int newItem) {

        add(newItem);

        parent.height = Math.max(getHeight(parent.left), getHeight(parent.right));

        int heightDifference = getHeightDifference(parent);

        //-- If the node becomes unbalanced, then there are four cases

        //-- case when imbalance occurs in left subtree of node's left child
        if (heightDifference > 1 && newItem < parent.left.data) {
            return rightRotation(parent);
        }

        //-- case when imbalance occurs in right subtree of node's right child
        if (heightDifference < -1 && newItem > parent.right.data) {
            return leftRotation(parent);
        }

        //-- case when imbalance occurs in right subtree of node's left child
        if (heightDifference > 1 && newItem > parent.left.data) {
            parent.left = leftRotation(parent.left);
            return rightRotation(parent);
        }

        //-- case when imbalance occurs in left subtree of node's right child
        if (heightDifference < -1 && newItem < parent.right.data) {
            parent.right = rightRotation(parent.right);
            return leftRotation(parent);
        }
        return parent;
    }

    /*
     * This method finds the difference between the heights of left and right tree
     *
     * @param Node - the node of BST
     *
     * @return - int, the difference in heights of left and right trees
     */
    public int getHeightDifference(Node parent) {
        if (parent == null) {
            return 0;
        } else
            return getHeight(parent.left) - getHeight(parent.right);
    }

    /*
     * This method finds the height of BST
     *
     * @param Node - the node of BST
     *
     * @return - int, the heights of BST
     */
    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right)); //-- returning the maximum of height between left and right tree
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
    public class Node {

        //-- variable to store data of a node of int type
        int data;

        //-- variable to store the reference of left node
        private Node left;

        //-- variable to store the reference of right node
        private Node right;

        //-- variable to store the height of BST
        private int height;

        //-- The constructor that initializes the node and assigns data to it
        public Node(int data) {
            this.data = data;
        }

    }
}
