package com.binarytree;

import java.util.LinkedList;
import java.util.Queue;


// TODO:This Program needs attention

public class LevelWithMinSum {
    Node root;

    Queue<Integer> queue = new LinkedList<Integer>();

    public Queue<Integer> calculateSum(Node lRoot,Node rRoot, Queue<Integer> q ){
        if(root == null){
            return null;
        }

        //queue.add(root.data);
        while(!queue.isEmpty()){
            if(lRoot.leftChild !=null && rRoot.rightChild !=null){
                queue.add(root.leftChild.data + root.rightChild.data);
            }
        }
        return calculateSum(root.leftChild,root.rightChild,queue);
    }

    public Queue<Integer> calculateSum(Node root){

        return calculateSum(root.leftChild,root.rightChild,queue);
    }



    public static void main (String args[]) {
        LevelWithMinSum isBst = new LevelWithMinSum();
        isBst.root = new Node(8);
        isBst.root.leftChild = new Node(6);
        isBst.root.rightChild = new Node(10);
        isBst.root.leftChild.leftChild = new Node(4);
        isBst.root.leftChild.rightChild = new Node(7);
        isBst.root.rightChild.leftChild = new Node(9);
        isBst.root.rightChild.rightChild = new Node(12);
        isBst.calculateSum(isBst.root);
        isBst.calculateSum(isBst.root).forEach((t)->System.out.println(t));

    }
}
