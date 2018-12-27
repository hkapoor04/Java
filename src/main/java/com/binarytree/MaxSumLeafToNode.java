package com.binarytree;

public class MaxSumLeafToNode {
    Node root;
    int min = Integer.MIN_VALUE;

    public void findMaxSum(Node node, int sum) {
        if (node == null) {
            return;
        }
        sum = sum + node.getData();
        if (node.leftChild == null && node.rightChild == null) {
            if (sum > min) {
                min = sum;
            }
        }
        findMaxSum(node.leftChild, sum);
        findMaxSum(node.rightChild, sum);
    }
    public static void main(String args[]) {
        MaxSumLeafToNode maxSumLeafToNode = new MaxSumLeafToNode();
        maxSumLeafToNode.root = new Node(10);
        maxSumLeafToNode.root.leftChild = new Node(8);
        maxSumLeafToNode.root.leftChild.leftChild = new Node(11);
        maxSumLeafToNode.root.leftChild.rightChild = new Node(15);
        maxSumLeafToNode.root.rightChild = new Node(12);
        maxSumLeafToNode.findMaxSum(maxSumLeafToNode.root, 0);
        System.out.println(maxSumLeafToNode.min);
    }
}
