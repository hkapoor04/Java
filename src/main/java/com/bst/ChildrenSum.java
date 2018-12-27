package com.bst;

/**
 * Created by Harshit on 9/17/2017.
 */
public class ChildrenSum {

    BTNode root;

    private int getChildsum(BTNode node) {

        int left_data = 0, right_data = 0;

        if (node == null || (node.left == null && node.right == null)) {
            return 1;
        } else {

            if (node.left != null) {
                left_data = node.left.data;
            }

            if (node.right != null) {
                right_data = node.right.data;
            }

            if ((node.data == left_data + right_data) && getChildsum(node.left)!= 0 && getChildsum(node.right) != 0) {
                return 1;

            } else
                return 0;

        }
    }

    private int getChildsum(){

        return getChildsum(root);
    }


    public static void main (String args []){
        ChildrenSum childrenSum = new ChildrenSum();
        childrenSum.root = new BTNode(10);
        childrenSum.root.left = new BTNode(8);
        childrenSum.root.right =  new BTNode(2);
        childrenSum.root.left.left = new BTNode(3);
        childrenSum.root.left.right = new BTNode(5);
        childrenSum.root.right.left = new BTNode(2);

        if (childrenSum.getChildsum() != 0){

            System.out.println("Tree has Children Sum");
        }



    }
}
