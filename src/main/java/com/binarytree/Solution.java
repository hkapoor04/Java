package com.binarytree;

import java.util.*;

public class Solution {
    Node root;
    public void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()){

            Node tempNode = queue.peek();

            System.out.println(tempNode.data);

            if(tempNode.leftChild !=null){
                queue.add(tempNode.leftChild);
            }
            if(tempNode.rightChild !=null){
                queue.add(tempNode.rightChild);
            }

        }
    }

    public static void main(String args[]){
        Solution mirrorTree = new Solution();
        mirrorTree.root = new Node(4);
        mirrorTree.root.leftChild = new Node(2);
        mirrorTree.root.rightChild = new Node(5);
        mirrorTree.root.leftChild.leftChild = new Node(1);
        mirrorTree.root.leftChild.rightChild = new Node(3);
        mirrorTree.levelOrder(mirrorTree.root);

    }

}
