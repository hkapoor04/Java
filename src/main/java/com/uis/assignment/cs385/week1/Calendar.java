

package com.uis.assignment.cs385.week1;

public class Calendar {

    //-- variable for Max Events
    private static final int MAXEVENTS = 4;

    //-- variable for Event object
    private Event[] events;

    //-- variable for number of events
    private int numEvents;

    //-- No argument constructor for initializing the variables
    public Calendar() {
        events = new Event[MAXEVENTS];
        numEvents = 0;
    }

    /*
     * This method adds an event to the Event array
     *
     * @param - The Event Object
     *
     * @return - boolean - The result of adding Event object to the array
     */
    public boolean addEvent(Event e) {

        //-- initializing boolean variable to store the result of event addition
        boolean isAddedSuccess = false;

        if (numEvents != MAXEVENTS) { /* check for number of events should not equal to max events to avoid ArrayIndexOutOfBound Exception */
            if (this.events[numEvents] == null) { /*  adding the object at the end of the array at empty index */
                this.events[numEvents] = e;
                numEvents++;
                isAddedSuccess = true; /* On successful addition, making the boolean variable true */
            } else {
                for (int i = 0; i <= numEvents; i++) { /* Iterating through array to find any empty index and adding the object to that index */
                    if (this.events[i] == null) {
                        this.events[i] = e;
                        isAddedSuccess = true; /* On successful addition, making the boolean variable true */
                    }
                }
            }
        }
        return isAddedSuccess;
    }

    /*
     * This method find an event to the Event array
     *
     * @param - The Event Object
     *
     * @return - int - The Event array index in case the object is present, -1 otherwise
     */
    public int findEvent(Event e) {
        int ret = -1;
        for (int i = 0; i < MAXEVENTS; i++) {
            if (this.events[i] != null) {
                if (e.equals(this.events[i])) {
                    ret = i;
                }
            }
        }
        return ret;
    }

    /*
     * This method removes an event to the Event array
     *
     * @param - The Event Object
     *
     * @return - boolean - The result of removing the object from the array
     */

    public boolean removeEvent(Event e) {

        int index = findEvent(e);
        if (index == -1) {
            return false;
        } else {
            this.events[index] = null;
            numEvents--; /* decrementing the number of events on removal of an object from the array */
            return true;
        }

    }

    /*
     * This method prints the contents of Event array
     *
     * @return - void
     */
    public void dump() {
        for (int i = 0; i < MAXEVENTS; i++) {
            if (this.events[i] != null) { /* Printing only the non null elements of the array */
                System.out.println(this.events[i].toString());
            }

        }
    }
}
