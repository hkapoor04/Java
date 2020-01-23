package com.uis.assignment.cs385.week1;

public class Calendar {

    private static final int MAXEVENTS = 4;

    private Event[] events;

    private int numEvents;

    public Calendar() {
        events = new Event[MAXEVENTS];
        numEvents = 0;
    }

    public boolean addEvent(Event e) {

        boolean isAddedSuccess = false;

        if (numEvents != MAXEVENTS) {

            if (events[numEvents] == null) {
                events[numEvents] = e;
                numEvents++;
                isAddedSuccess = true;
            } else {
                for (int i = 0; i <= numEvents; i++) {
                    if (events[i] == null) {
                        events[i] = e;
                        isAddedSuccess = true;
                    }
                }

            }

        }
        return isAddedSuccess;
    }

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

    public boolean removeEvent(Event e) {

        int index = findEvent(e);
        if (index == -1) {
            return false;
        } else {
            this.events[index] = null;
            numEvents--;
            return true;
        }

    }

    public void dump() {
        for (int i = 0; i < MAXEVENTS; i++) {

            if (this.events[i] != null) {
                System.out.println(this.events[i].toString());
            }

        }
    }
}
