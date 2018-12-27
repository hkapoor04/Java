package com.bst;

/**
 * Created by Harshit on 9/17/2017.
 */
public class MaxHeightOfTree {

    BTNode root;


    private int getMaximumHeight(BTNode node) {

        if (node == null) {
            return 0;
        } else {
            int lLength = getMaximumHeight(node.left);

            int rLength = getMaximumHeight(node.right);

            if(lLength > rLength){
                return (lLength +1);
            }
            else{
                return (rLength +1);
            }

        }
    }

    public int getMaximumHeight(){
        return getMaximumHeight(root);
    }


    public static void main (String args []){

        MaxHeightOfTree maxHeightOfTree = new MaxHeightOfTree();

        maxHeightOfTree.root = new BTNode(1);
        maxHeightOfTree.root.left = new BTNode(2);
        maxHeightOfTree.root.right = new BTNode(3);
        maxHeightOfTree.root.left.left = new BTNode(4);
        maxHeightOfTree.root.left.right = new BTNode(5);

        System.out.println ( maxHeightOfTree.getMaximumHeight());
    }
}
