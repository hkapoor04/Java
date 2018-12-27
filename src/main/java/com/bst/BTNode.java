package com.bst;

/**
 * Created by Harshit on 9/13/2017.
 */
public class BTNode {

    BTNode left, right;
    int data;

    public BTNode(){
        left = null;
        right = null;
        data =0;
    }

    public BTNode(int n){
        left = null;
        right = null;
        data = n;
    }

    /* setting up left node */
    public void setLeftNode(BTNode n){
        left = n;
    }

    /* setting up right node */
    public void setRightNode(BTNode n) {
        right =n;
    }
    /* Function to get left node */
    public BTNode getLeft()
    {
        return left;
    }
    /* Function to get right node */
    public BTNode getRight()
    {
        return right;
    }
    /* Function to set data to node */
    public void setData(int d)
    {
        data = d;
    }
    /* Function to get data from node */
    public int getData()
    {
        return data;
    }


}
