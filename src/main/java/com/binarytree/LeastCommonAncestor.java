package com.binarytree;

public class LeastCommonAncestor {

    Node root;
    int n1 = 4, n2 = 7;

    public int FindLCA(Node root){
        if(root == null){
            return 0;
        }

        if(n1<root.data && n2<root.data){
            return FindLCA(root.leftChild);
        }

        if(n1>root.data && n2>root.data){
            return FindLCA(root.rightChild);
        }
        return root.data;
    }


    public static void main (String args[]) {
        LeastCommonAncestor isBst = new LeastCommonAncestor();
        isBst.root = new Node(8);
        isBst.root.leftChild = new Node(6);
        isBst.root.rightChild = new Node(10);
        isBst.root.leftChild.leftChild = new Node(4);
        isBst.root.leftChild.rightChild = new Node(7);
        isBst.root.rightChild.leftChild = new Node(9);
        isBst.root.rightChild.rightChild = new Node(12);
        System.out.println(isBst.FindLCA(isBst.root));

    }
}
