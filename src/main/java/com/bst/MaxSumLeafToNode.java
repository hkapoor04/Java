package com.bst;

/**
 * Created by Harshit on 9/15/2017.
 */
public class MaxSumLeafToNode {

    BTNode root;
    Maximum max = new Maximum();
    BTNode target_leaf = null;

    void getTargetLeaf (BTNode node,int sum,Maximum obj){
        if(node == null){
            return ;
        }
         sum = sum + node.data;
        if(node.left ==null && node.right ==null) {
            if (sum > obj.max_no) {
                obj.max_no = sum;
                target_leaf =node;
            }
        }

        getTargetLeaf(node.left,sum,obj);
        getTargetLeaf(node.right,sum,obj);


    }

    int FindMaxSum(){

        if (root ==null){
            return 0;
        }

        getTargetLeaf(root,0,max);

        return max.max_no;
    }


    public static void main (String args []){

        MaxSumLeafToNode  maxSumLeafToNode = new MaxSumLeafToNode();
        maxSumLeafToNode.root = new BTNode(4);
        maxSumLeafToNode.root.left = new BTNode(5);
        maxSumLeafToNode.root.right = new BTNode(8);
        maxSumLeafToNode.root.left.left = new BTNode(333);
        maxSumLeafToNode.root.left.right =  new BTNode(0);
        maxSumLeafToNode.root.right.right = new BTNode(10);

        int sum = maxSumLeafToNode.FindMaxSum();

        System.out.println(sum);


    }
}
