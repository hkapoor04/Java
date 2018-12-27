package com.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HasPathSum {
    Node root;
    int i=12;
    Stack<Integer> st = new Stack<Integer>();
    public List<String> binaryTreePaths(Node root) {
        List<String> pathList = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        getTreePaths(root, sb, pathList);
        return pathList;
    }

    public void getTreePaths(Node root, StringBuffer sb, List<String> pathList){

        if(root == null) return;

        if(root.leftChild == null && root.rightChild== null){
            sb.append(root.data + "");
            //sb = new StringBuffer();
        }
        if (root.leftChild !=null) {
            sb.append(root.data + "->");
            getTreePaths(root.leftChild, sb, pathList);
            sb = new StringBuffer();
        }
        if(root.rightChild !=null) {
            getTreePaths(root.rightChild, sb, pathList);
            sb.append(root.data + "->");
        }
            pathList.add(sb.toString());


    }


    public static void main (String args[]) {
        HasPathSum isBst = new HasPathSum();
        isBst.root = new Node(1);
        isBst.root.leftChild = new Node(2);
        isBst.root.rightChild = new Node(3);
        isBst.root.leftChild.rightChild = new Node(5);
        isBst.binaryTreePaths(isBst.root);

    }


}
