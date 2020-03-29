package com.uis.assignment.cs385.week6;

public class ListTest {

    public static void main(String[] args) {
        SortedLinkedList<Character> sll = new SortedLinkedList<Character>();

        sll.add('e');
        sll.add('c');
        sll.add('b');
        System.out.println(sll);

        sll.reverse();
        System.out.println(sll);

        sll.add('f');
        System.out.println(sll);

        sll.reverse();
        System.out.println(sll);

        sll.add('f');
        sll.add('a');
        System.out.println(sll);

        System.out.println(sll.get(4));

        System.out.println(sll.contains('d'));
        System.out.println(sll.contains('f'));

        sll.remove(2);
        sll.remove(2);
        sll.remove(2);
        System.out.println(sll.getSize());

        sll.remove(2);
        System.out.println(sll);

        sll.clear();

        try {
            sll.remove(0);
        } catch(EmptyCollectionException e) {
            System.out.println("Exception caught: " + e.toString());
        }

        try {
            sll.get(1);
        }catch(IndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.toString());
        }

        sll.add('b');
        sll.reverse();
        System.out.println(sll);
        sll.add('a');

        System.out.println(sll);

        try {
            sll.remove(1);
        }catch(IndexOutOfBoundsException e) {
            System.out.println("Exception caught: " + e.toString());
        }
        sll.reverse();
        System.out.println(sll);
    }

}
