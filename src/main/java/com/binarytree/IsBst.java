package com.binarytree;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class IsBst {
    Node root;

    public Boolean bstUtil(){
        return checkBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public  Boolean checkBst(Node bstNode, int min, int max){
        if(bstNode == null){
            return true;
        }

        if (bstNode.data < max || bstNode.data > min)
            return true;
        return (checkBst(bstNode.leftChild,min,bstNode.data)&&checkBst(bstNode.rightChild,bstNode.data+1,max));
    }


    public static void main (String args[]){
        IsBst isBst = new IsBst();
        isBst.root = new Node(10);
        isBst.root.leftChild = new Node(8);
        isBst.root.rightChild = new Node(12);
        isBst.root.leftChild.leftChild = new Node(6);
        isBst.root.leftChild.rightChild = new Node(9);
        isBst.root.rightChild.leftChild = new Node(11);
        isBst.root.rightChild.rightChild = new Node(22);
        System.out.println("isBst*********"+isBst.bstUtil());
    }
}
