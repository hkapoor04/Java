package com.uis.assignment.cs385.week6;

public class SortedLinkedList<T extends Comparable<? super T>> {

    //-- Variable to store the head of type node
    private Node<T> head;

    //-- Variable to store the tail of type node
    private Node<T> tail;

    //-- variable to store the size if list
    private int size;

    //-- variable to store the number of times reverse is called for the list
    private int reverseCounter = 0;

    //-- A no argument constructor to initialize the list with an initial default size of 0
    public SortedLinkedList() {
        clear();
    }

    /*
     * This method clears the data of linked list, by doing below operation
     *  - head is initialized to null
     *  - tail is initialized to null
     *  - the size made 0
     */
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /*
     * This method checks whether the list is empty or not
     *
     * @return boolean - true if size is 0, false other wise
     */
    private boolean isEmpty() {
        //-- returns the result of size being zero or not
        return size == 0;
    }

    /*
     * This method adds the object to an empty list
     *
     * @param - obj of Comparable type
     */
    private void addToEmptyList(Comparable obj) {
        //-- initialize and assign the object as head
        head = new Node<T>(obj);

        //-- assigning the next reference
        head.next = tail;

        //-- incrementing the size of the list
        size += 1;

    }

    /*
     * This method adds a new node to the list
     *
     * @param - obj, the object of type comparable that needs to be added
     */
    public void add(Comparable obj) {
        //-- Checking if the list is empty or not
        if (isEmpty()) {

            //-- calling method to add the new object as head of the list
            addToEmptyList(obj);
        } else {
            Node<T> newNode = new Node<T>(obj);

            //-- Calling method to find the node after/before which the new node would be inserted
            Node<T> nodeToInsert = findNodeToInsert(newNode);
            if (nodeToInsert == null || nodeToInsert.data.compareTo(newNode.data) != 0) {

                //-- calling method to insert the new node
                insertNode(nodeToInsert, newNode);
            } else
                insertNodeWithSameData(nodeToInsert, newNode); //-- calling separate method in case the found node, and the new node has the same value
        }


    }

    /*
     * This method inserts the node where the node to be inserted has the same data as the node found
     *
     * @param - nodeToInsert - The node after/before which the new node would be inserted
     *
     * @param - newNode - The node that needs to be inserted
     */
    private void insertNodeWithSameData(Node<T> nodeToInsert, Node<T> newNode) {

        //-- check if the node is a head, then inserting the new node to the left of it and rearranging the references
        if (nodeToInsert.prev == null && nodeToInsert.next != null) {
            nodeToInsert.next.prev = newNode;
            newNode.prev = nodeToInsert;
            newNode.next = nodeToInsert.next;
            nodeToInsert.next = newNode;
        } else if (tail == null) {
            Node tempNode;
            head.prev = newNode;
            tempNode = head;
            head = newNode;
            head.next = tempNode;
            tail = tempNode;
        } else if (head == null) {
            Node tempNode;
            tail.prev = newNode;
            tempNode = tail;
            head = newNode;
            head.next = tempNode;

        } else if (isEmpty()) {
            head = newNode;
            tail = null;
        } else { //-- otherwise just inserting the new node at the left of node with similar data and rearranging references
            nodeToInsert.prev.next = newNode;
            newNode.prev = nodeToInsert.prev;
            nodeToInsert.prev = newNode;
            newNode.next = nodeToInsert;
        }
        //-- Incrementing the size of node in case of an addition
        size += 1;
    }

    /*
     * This method inserts the new node in the list before/after the said node
     *
     * @param - nodeToInsert - The node in the list before/after the new node would be inserted
     *
     * @param - newNode - The node that needs to be inserted
     */

    private void insertNode(Node<T> nodeToInsert, Node<T> newNode) {

        //-- a node defined for temporary storage of any node
        Node tempNode;

        //-- the condition where a new node is to be inserted before the head, and the references are rearranged
        if (head != null && nodeToInsert == null) {
            head.prev = newNode;
            tempNode = head;
            head = newNode;
            head.next = tempNode;
            if (size <= 1) { // -- condition where the list has just one node
                tail = tempNode;
                tail.next = null;
            }
        } else if (head != null && nodeToInsert.next == null) { //-- the condition where a new node is inserted after the tail, and the references are rearranged
            newNode.prev = nodeToInsert;
            nodeToInsert.next = newNode;
            tail = newNode;
        } else if (head == null) {
            if ((tail.data.compareTo(newNode.data) > 0 && reverseCounter % 2 == 0) || (tail.data.compareTo(newNode.data) < 0 && reverseCounter % 2 != 0)) {
                head = newNode;
                head.next = tail;
                tail.prev = head;
            } else if ((tail.data.compareTo(newNode.data) > 0 && reverseCounter % 2 != 0) || (tail.data.compareTo(newNode.data) < 0 && reverseCounter % 2 == 0)) {
                head = tail;
                tail = newNode;
                tail.prev = head;
                head.next = tail;
            }
        } else if (tail == null) {
            if ((head.data.compareTo(newNode.data) < 0 && reverseCounter % 2 == 0) || (head.data.compareTo(newNode.data) > 0 && reverseCounter % 2 != 0)) {
                tail = newNode;
                head.next = tail;
                tail.prev = head;
            } else if ((head.data.compareTo(newNode.data) < 0 && reverseCounter % 2 != 0) || (head.data.compareTo(newNode.data) > 0 && reverseCounter % 2 == 0)) {
                tail = head;
                head = newNode;
                tail.prev = head;
                head.next = tail;
            }

        } else { // -- otherwise inserting the node anywhere between head and tail and rearranging the references
            Node prevNode, nextNode;
            prevNode = nodeToInsert;
            nextNode = nodeToInsert.next;
            prevNode.next = newNode;
            newNode.prev = prevNode;
            newNode.next = nextNode;
            nextNode.prev = newNode;
        }
        this.size++;
    }

    /*
     * This method validates the index of any particular object in the list
     *
     * @param - index - the index of a particular node
     *
     * @param - lowerBound - the lower bound of the list size
     *
     * @param - upperBound - the upper bound of the list size
     *
     * @throw - IndexOutOfBoundsException if the index is outside the size of list
     */
    private void validateIndex(int index, int lowerBound, int upperBound) {
        if (index < lowerBound || index > upperBound) {
            throw new IndexOutOfBoundsException(String.format("The Index must be between %d and %d", lowerBound, upperBound));
        }
    }

    /*
     * This method overrides the default toString method to print the content of the list
     *
     * @return - String, the string representation of the node values
     */
    @Override
    public String toString() {

        //-- declaring new StringBuffer type object
        StringBuffer sb = new StringBuffer();
        sb.append("(");
        if (!isEmpty()) {
            //-- variable to store head of the list
            Node<T> temp = head;

            if (temp != null) {

                //-- iterating through the list till the tail is reached
                while (temp.next != null) {

                    //-- appending the data of each node into the string buffer
                    sb.append(temp.data.toString());

                    //-- appending , between each node's value
                    sb.append(", ");
                    temp = temp.next;
                }
            } else {
                temp = tail;
            }
            sb.append(temp.data.toString());
        }
        sb.append(")");
        return sb.toString();
    }

    /*
     * This method gets the node at a particular index
     *
     * @param - index - the index to get the node
     *
     * @return - Node object of type comparable
     */
    public Comparable get(int index) {

        //-- validations for the index position
        if (size > 0) {
            validateIndex(index, 0, size - 1);
        } else {
            throw new IndexOutOfBoundsException("The Collection is empty");
        }
        return getNode(index).data;
    }

    /*
     * This method finds the node at a particular index
     *
     * @param - index to find the particular node
     */
    private Node<T> getNode(int index) {

        //-- Finding if the index is in first half of the list or the second half
        Node<T> temp = (index <= size / 2) ? head : tail;

        //-- Finding the node when the index is in first half
        if (temp == head) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else { //-- Finding the node when the index is in second half
            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    /*
     * This method removes the node from a particular index
     *
     * @param - index to remove the node
     */
    public Comparable remove(int index) {
        //-- empty check for list
        if (isEmpty()) {
            throw new EmptyCollectionException("Cannot remove from empty collection");
        }

        //-- validations for the index position
        if (size > 0) {
            validateIndex(index, 0, size - 1);
        } else {
            validateIndex(index, 0, 0);
        }
        if (index == 0) {
            return removeFirst(); //-- removing the first node
        } else if (index == size - 1) {
            return removeLast(); //-- removing the last node
        } else { //-- remove node from the middle and rearranging references
            Node<T> nodeToRemove = getNode(index);
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
            nodeToRemove.next = null;
            nodeToRemove.prev = null;
            size -= 1; //-- reducing the list size on node removal
            return nodeToRemove.data;
        }
    }

    /*
     * This method removes the last node of the list
     */
    private Comparable removeLast() {

        Node<T> temp = tail;
        //-- empty check for list
        if (isEmpty()) {
            throw new EmptyCollectionException("Cannot remove from empty collection");
        }

        if (size == 1) { //-- check if the list has only one node
            clear();
        } else if (size == 2) { //-- check if the list just has head and tail
            head.next = null; //-- assigning tail reference to null
            tail = null; //-- assigning tail to null
            size -= 1; //-- decrementing the size of list on removal of node
        } else { //-- rearranging the references on removing the last node
            tail = tail.prev; //-- assigning head reference to null
            size -= 1; //-- decrementing the size of list on removal of node
        }
        return temp.data;
    }

    /*
     * This method removes the first node of the list
     */
    private Comparable removeFirst() {

        Node<T> temp = head;
        //-- empty check for list
        if (isEmpty()) {
            throw new EmptyCollectionException("Cannot remove from empty collection");
        }
        if (size == 1) { //-- check if the list has only one node
            clear();
        } else if (size == 2) { //-- check if the list just has head and tail
            tail.prev = null; //-- assigning head reference to null
            head = null; //-- assigning head to null
            size -= 1;  //-- decrementing the size of list on removal of node
        } else { //-- rearranging the references on removing the last node
            head = head.next;
            head.prev.next = null;
            head.prev = null; //-- setting the previous reference to null
            size -= 1;  //-- decrementing the size of list on removal of node
        }
        return temp.data;
    }

    /*
     * Declaring class Node of generic type
     */
    private class Node<T> {

        //-- variable to store data of a node which is of type Comparable
        Comparable data;

        //-- variable to store the reference of next node
        Node<T> next;

        //-- variable to store the reference of previous node
        Node<T> prev;

        //-- The constructor that initializes the node and assigns data to it
        public Node(Comparable data) {
            this.data = data;
        }
    }

    /*
     * This method checks if the list contains a particular node of data
     *
     * @param - data of type comparable which needs to be looked upon in the list
     *
     * @return - boolean, the result of node found/not found
     */

    public boolean contains(Comparable data) {
        Node curNode = head;

        //-- declaring a boolean variable and initializing it to false
        boolean isContains = false;

        while (curNode != null) {

            //-- comparing the data with data of each node in the list
            if (data.compareTo(curNode.data) == 0) {
                isContains = true;
                break; //-- breaking out of loop in case the data is found
            }
            curNode = curNode.next;
        }
        return isContains;
    }

    /*
     * This method finds the node in the list after/before which the new node would be inserted
     *
     * @param - newNode of type node which needs to be inserted
     *
     * @return - Node, the node in the list where the current node would be inserted
     */
    private Node findNodeToInsert(Node newNode) {

        //-- variable to hold head/tail whichever is not null
        Node<T> curNode = head != null ? head : tail;

        //-- Check to find if the list is in ascending order
        if (reverseCounter % 2 == 0 && newNode.data.compareTo(curNode.data) < 0) {
            return null;
        }

        //-- Check to find if the list is in descending order
        if (reverseCounter % 2 != 0 && newNode.data.compareTo(curNode.data) > 0) {
            return null;
        }

        //-- traversing through the list to find the node where the new node will be inserted
        while (curNode.next != null) {
            if (newNode.data.compareTo(curNode.data) == 0) { //-- check if the node data to insert already exist at some other node
                return curNode;
            } else if (newNode.data.compareTo(curNode.data) > 0 && newNode.data.compareTo(curNode.next.data) < 0) { //-- Find the node where the new node will be inserted for list sorted in ascending order
                return curNode;
            } else if (reverseCounter % 2 != 0 && newNode.data.compareTo(curNode.data) < 0 && newNode.data.compareTo(curNode.next.data) > 0) //-- Find the node where the new node will be inserted for list sorted in descending order
                return curNode.next;

            curNode = curNode.next;
        }
        return curNode;
    }

    /*
     * This method gets the size of the list
     *
     * @return - The size of list
     */
    public int getSize() {
        return this.size;
    }

    /*
     * This method reverses the sort order of list
     */
    public void reverse() {
        Node<T> temp = null;

        if (head != null) {
            tail = head; //-- assigning the tail node to head node
        }

        //-- variable to store the head
        Node<T> curNode = head;

        //-- counter to store the number of times reverse is called on the list
        reverseCounter += 1;
        while (curNode != null) { //-- traversing through the list from head and rearranging the references
            temp = curNode.prev;
            curNode.prev = curNode.next; //-- assigning the reference to previous node as the reference for next node
            curNode.next = temp;
            curNode = curNode.prev;
        }
        if (temp != null) { //-- reversing the head and tail nodes
            head = temp.prev;
        }
        if (size == 1 && head == null) { //-- reversing the head and tail nodes in case list has only tail node
            head = tail; //-- assigning the tail node to head for list with only tail node
            tail = null; //-- assigning tail node to null value for list with only tail node
        } else if (size == 1 && tail.data == head.data) { //-- reversing the head and tail nodes in case list has only head node
            tail = head; //-- assigning the head node to tail for list with only head node
            head = null; //-- assigning head node to null value for list with only head node
        }
    }
}
