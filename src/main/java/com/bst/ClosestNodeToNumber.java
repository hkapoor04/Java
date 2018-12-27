package com.bst;

/**
 * Created by Harshit on 9/14/2017.
 */
public class ClosestNodeToNumber {

    BTNode root;
    BTNode Target_Node = null;

    Minimum min = new Minimum();


    public ClosestNodeToNumber() {
        root = null;
    }

    public  void search(int val)
    {
         search(root, val,min);
    }

     void search(BTNode node, int val,Minimum min_obj)
    {
        if (node == null){
            return ;
        }
        if (val == node.data) {
                Target_Node = node;

            }
        if (Math.abs(val - node.data) < min_obj.min_num)
            {

                min_obj.min_num = Math.abs(val - node.data);

                Target_Node = node;

            }
        if(node.data > val) {
            search(node.left, val, min_obj);
        }
         else if(node.data < val) {
            search(node.right, val, min_obj);
        }

    }


    public static void main (String args[]){

        ClosestNodeToNumber closestNodeToNumber = new ClosestNodeToNumber();

        closestNodeToNumber.root = new BTNode(4);
        closestNodeToNumber.root.left = new BTNode(2);
        closestNodeToNumber.root.right = new BTNode(6);
        closestNodeToNumber.root.left.left = new BTNode(1);
        closestNodeToNumber.root.left.right = new BTNode(10);
        closestNodeToNumber.root.right.left = new BTNode(8);
        closestNodeToNumber.root.right.right = new BTNode(15);

        closestNodeToNumber.search(7);

        System.out.println(closestNodeToNumber.Target_Node.data);




    }
}
