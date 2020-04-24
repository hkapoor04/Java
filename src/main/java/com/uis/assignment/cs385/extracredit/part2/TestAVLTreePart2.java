package com.uis.assignment.cs385.extracredit.part2;


public class TestAVLTreePart2 {
    public static void main(String[] args) {
        System.out.println("*************** Testing imbalance in left subtree of node's left child - start ****************");
        AVLTreePart2 avlTree1 =  new AVLTreePart2();
        avlTree1.add(10);
        avlTree1.add(6);
        avlTree1.add(15);
        avlTree1.add(3);
        avlTree1.add(8);
        avlTree1.add(2);
        avlTree1.add(4);
        avlTree1.add(7);
        avlTree1.add(9);
        avlTree1.add(12);
        avlTree1.add(18);
        System.out.println("BST before inserting new node to make it imbalance:  " + avlTree1);
        avlTree1.getHeightDifference(avlTree1.root);

        avlTree1.checkBalanceAndRotate(avlTree1.root, 1);

        System.out.println("BST after balancing:  " + avlTree1);

        System.out.println("Height Difference After Balancing: " + avlTree1.getHeightDifference(avlTree1.root));

        System.out.println("Tree Height After Balancing: " + avlTree1.getHeight(avlTree1.root));

        System.out.println("*************** Testing imbalance in left subtree of node's left child - end ******************");

        System.out.println("-----------------------------------------------------------------------------------------------");

        System.out.println("*************** Testing imbalance in right subtree of node's right child - start ****************");
        AVLTreePart2 avlTree2 =  new AVLTreePart2();
        avlTree2.add(10);
        avlTree2.add(6);
        avlTree2.add(8);
        avlTree2.add(3);
        avlTree2.add(20);
        avlTree2.add(17);
        avlTree2.add(25);
        avlTree2.add(15);
        avlTree2.add(18);
        avlTree2.add(22);
        avlTree2.add(30);
        System.out.println("BST before inserting new node to make it imbalance:  " + avlTree2);
        avlTree2.getHeightDifference(avlTree2.root);

        avlTree2.checkBalanceAndRotate(avlTree2.root, 40);

        System.out.println("BST after balancing:  " + avlTree2);

        System.out.println("Height Difference After Balancing: " + avlTree2.getHeightDifference(avlTree2.root));

        System.out.println("Tree Height After Balancing: " + avlTree2.getHeight(avlTree2.root));

        System.out.println("*************** Testing imbalance in right subtree of node's right child - end ******************");

        System.out.println("-----------------------------------------------------------------------------------------------");

        System.out.println("*************** Testing imbalance in right subtree of node's left child - start ****************");
        AVLTreePart2 avlTree3 =  new AVLTreePart2();
        avlTree3.add(12);
        avlTree3.add(5);
        avlTree3.add(3);
        avlTree3.add(8);
        avlTree3.add(2);
        avlTree3.add(4);
        avlTree3.add(7);
        avlTree3.add(9);
        avlTree3.add(15);
        avlTree3.add(13);
        avlTree3.add(18);
        System.out.println("BST before inserting new node to make it imbalance:  " + avlTree3);
        avlTree3.getHeightDifference(avlTree3.root);

        avlTree3.checkBalanceAndRotate(avlTree3.root, 10);

        System.out.println("BST after balancing:  " + avlTree3);

        System.out.println("Height Difference After Balancing: " + avlTree3.getHeightDifference(avlTree3.root));

        System.out.println("Tree Height After Balancing: " + avlTree3.getHeight(avlTree3.root));

        System.out.println("*************** Testing imbalance in right subtree of node's left child - end ******************");

        System.out.println("-----------------------------------------------------------------------------------------------");

        System.out.println("*************** Testing imbalance in left subtree of node's right child - start ****************");
        AVLTreePart2 avlTree4 =  new AVLTreePart2();
        avlTree4.add(12);
        avlTree4.add(5);
        avlTree4.add(3);
        avlTree4.add(8);
        avlTree4.add(20);
        avlTree4.add(15);
        avlTree4.add(30);
        avlTree4.add(14);
        avlTree4.add(17);
        avlTree4.add(25);
        avlTree4.add(40);
        System.out.println("BST before inserting new node to make it imbalance:  " + avlTree4);
        avlTree4.getHeightDifference(avlTree4.root);

        avlTree4.checkBalanceAndRotate(avlTree4.root, 18);

        System.out.println("BST after balancing:  " + avlTree4);

        System.out.println("Height Difference After Balancing: " + avlTree4.getHeightDifference(avlTree4.root));

        System.out.println("Tree Height After Balancing: " + avlTree4.getHeight(avlTree4.root));

        System.out.println("*************** Testing imbalance in left subtree of node's right child - end ******************");

    }
}
