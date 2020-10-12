package com.uis.assignment.cs385.week7;

public class TestIntegerSet {

    public static void main(String[] args) {

        System.out.println("*************** Testing add with unique values - start ****************");
        IntegerSet integerSet1 =  new IntegerSet();
        integerSet1.add(50);
        integerSet1.add(25);
        integerSet1.add(75);
        integerSet1.add(15);
        integerSet1.add(45);
        integerSet1.add(85);

        System.out.println(integerSet1);

        System.out.println("*************** Testing add with unique values - end ******************");

        System.out.println("-----------------------------------------------------------------------");

        System.out.println("*************** Testing add with duplicate values - start *************");
        IntegerSet integerSet2 =  new IntegerSet();
        integerSet2.add(50);
        integerSet2.add(25);
        integerSet2.add(85);
        integerSet2.add(15);
        integerSet2.add(45);
        integerSet2.add(85);

        System.out.println(integerSet2);

        System.out.println("*************** Testing add with duplicate values - end ***************");

        System.out.println("-----------------------------------------------------------------------");

        System.out.println("********************** Testing contains - start ***********************");
        IntegerSet integerSet3 =  new IntegerSet();
        integerSet3.add(50);
        integerSet3.add(25);
        integerSet3.add(85);
        integerSet3.add(15);
        integerSet3.add(45);
        integerSet3.add(85);

        System.out.println(integerSet3);
        System.out.println("Check for 25 : " + integerSet3.contains(25));
        System.out.println("Check for 20 : " + integerSet3.contains(20));


        System.out.println("********************** Testing contains - end *************************");

        System.out.println("-----------------------------------------------------------------------");

        System.out.println("********************** Testing union - start **************************");
        IntegerSet integerSet4 =  new IntegerSet();
        integerSet4.add(50);
        integerSet4.add(25);
        integerSet4.add(85);
        integerSet4.add(15);
        integerSet4.add(45);
        integerSet4.add(85);

        IntegerSet integerSet5 =  new IntegerSet();
        integerSet5.add(50);
        integerSet5.add(25);
        integerSet5.add(85);
        integerSet5.add(5);
        integerSet5.add(10);
        integerSet5.add(100);

        System.out.println("First BST: " + integerSet4);

        System.out.println("Second BST: " + integerSet5);

        System.out.println("First ∪ Second: " + integerSet4.union(integerSet5));

        System.out.println("********************** Testing union - end ****************************");

        System.out.println("-----------------------------------------------------------------------");



        System.out.println("********************** Testing intersection - start *******************");
        IntegerSet integerSet6 =  new IntegerSet();
        integerSet6.add(1);
        integerSet6.add(2);
        integerSet6.add(3);
        integerSet6.add(4);
        integerSet6.add(5);
        integerSet6.add(6);

        IntegerSet integerSet7 =  new IntegerSet();
        integerSet7.add(3);
        integerSet7.add(4);
        integerSet7.add(5);
        integerSet7.add(6);
        integerSet7.add(7);
        integerSet7.add(8);
        integerSet7.add(8);
        System.out.println("First BST: " + integerSet6);

        System.out.println("Second BST: " + integerSet7);

        System.out.println("First ∩ Second: "+integerSet6.intersection(integerSet7));

        System.out.println("********************** Testing intersection - end *********************");

        System.out.println("-----------------------------------------------------------------------");


    }

}
