package com.binarytree;

public class isBalancedTree {

    Node root;

    public int checkTreeBalance(Node balanceNode){
        if(balanceNode == null){
            return 1;
        }
        int lh = checkTreeBalance(balanceNode.leftChild);
        int rh = checkTreeBalance(balanceNode.rightChild);
        if ((Math.abs(lh-rh)<=1)){
            return 1;
        }else
            return 0;
    }


    public static void main (String args[]){
        isBalancedTree isBst = new isBalancedTree();
        isBst.root = new Node(10);
        isBst.root.leftChild = new Node(5);
        isBst.root.rightChild = new Node(15);
       /* isBst.root.leftChild.leftChild = new Node(6);
        isBst.root.leftChild.rightChild = new Node(9);*/
        isBst.root.rightChild.leftChild = new Node(14);
        isBst.root.rightChild.rightChild = new Node(22);
        isBst.root.rightChild.leftChild.leftChild = new Node(13);
        isBst.root.rightChild.rightChild.rightChild = new Node(16);
        int returnValue = isBst.checkTreeBalance(isBst.root);

        if(returnValue ==1){
            System.out.println("Tree is Balanced");
        }
        //System.out.println("isBst*********"+isBst.bstUtil());
    }
}
