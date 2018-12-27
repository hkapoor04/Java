package com.binarytree;

import java.util.Stack;

public class PrintPath {
    Node root;
    int i=12;
    Stack<Integer> st = new Stack<Integer>();
    public Stack<Integer> pathPrint(Node root, Stack<Integer> st){

    if(root == null){
        return null;
    }
    st.push(root.data);

    if(i<=root.data){
        pathPrint(root.leftChild,st);
    }
    if(i>root.data){
        pathPrint(root.rightChild,st);
    }
    else{
        System.out.println("No matching value found");
    }

    return st;
    }


    public static void main (String args[]) {
        PrintPath isBst = new PrintPath();
        isBst.root = new Node(8);
        isBst.root.leftChild = new Node(6);
        isBst.root.rightChild = new Node(10);
        isBst.root.leftChild.leftChild = new Node(4);
        isBst.root.leftChild.rightChild = new Node(7);
        isBst.root.rightChild.leftChild = new Node(9);
        isBst.root.rightChild.rightChild = new Node(12);
        isBst.printStack(isBst.pathPrint(isBst.root,isBst.st));
    }

    public void printStack(Stack<Integer> finalStack){
        finalStack.forEach((s)->System.out.println(s));

    }

}



