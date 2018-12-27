package com.binarytree;

public class MinimumNode {

    private Node root;

    public int findMinimum(Node minimumNode) {
        if (minimumNode == null)
            return 0;
        if (minimumNode.getLeftChild() == null) {
            return minimumNode.getData();
        } else
            return findMinimum(minimumNode.getLeftChild());
    }

    public static void main(String args[]) {
        MinimumNode minimumNode = new MinimumNode();
        minimumNode.root = new Node(10);
        minimumNode.root.leftChild = new Node(8);
        minimumNode.root.rightChild = new Node(12);
        int minimumValue = minimumNode.findMinimum(minimumNode.root);
        System.out.println(minimumValue);
    }
}
