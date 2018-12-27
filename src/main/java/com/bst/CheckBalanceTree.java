package com.bst;

/**
 * Created by Harshit on 9/24/2017.
 */
public class CheckBalanceTree {

    BTNode root;

    private int Height(BTNode node){
        if(node ==null){
            return 0;
        }

        return 1 + Math.max(Height(node.left),Height(node.right));
    }

    private Boolean CheckForBalance(BTNode node){
        if(node ==null){
            return true;
        }

        int lh = Height(node.left);
        int rh = Height(node.right);

        if(Math.abs(lh-rh)<=1){
            return true;
        }

        return false;
    }

    private  Boolean CheckForBalance(){
       return CheckForBalance(root);
    }

    public static void main(String args []){

        CheckBalanceTree checkBalanceTree = new CheckBalanceTree();
        checkBalanceTree.root = new BTNode(1);
        checkBalanceTree.root.left = new BTNode(2);
        checkBalanceTree.root.right = new BTNode(3);
        checkBalanceTree.root.left.left = new BTNode(4);
        checkBalanceTree.root.right.right = new BTNode(5);
        checkBalanceTree.root.left.left.left = new BTNode(8);

        if (checkBalanceTree.CheckForBalance()){
            System.out.println("Tree is Balanced");
        }
    }
}
