package com.binarytree;

public class MirrorTree {

    Node root;

    public void Mirror(Node mirrorNode){
        if(mirrorNode == null){
            return;
        }
        Mirror(mirrorNode.leftChild);
        Mirror(mirrorNode.rightChild);
    }

    public static void main(String args[]){
        MirrorTree mirrorTree = new MirrorTree();
        mirrorTree.root = new Node(4);
        mirrorTree.root.leftChild = new Node(2);
        mirrorTree.root.rightChild = new Node(5);
        mirrorTree.root.leftChild.leftChild = new Node(1);
        mirrorTree.root.leftChild.rightChild = new Node(3);
        mirrorTree.Mirror(mirrorTree.root);
    }
}
