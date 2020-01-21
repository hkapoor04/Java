package com.uis.assignment.cs385.week1;

import java.util.Objects;

public class Event {

    //-- variable for Date object
    private Date date;

    //-- variable for start
    private int start;

    //-- variable for end
    private int end;

    //-- variable for description
    private String description;

    /*
     * Constructor for creating Event with given date, start, end and description.
     * It also checks for start and end to be between 0-12, start must be lesser than end
     * and day must be between 1-31
     *
     * @param - date
     *
     * @param - start
     *
     * @param - end
     *
     * @param - description
     *
     * @throws - IllegalArgumentException
     */

    public Event(Date date, int start, int end, String description) throws IllegalArgumentException {

        if (start > 0 && start < 23) {
            this.start = start;
        } else
            throw new IllegalArgumentException();

        if (end > 0 && end < 23) {
            this.end = end;
        } else
            throw new IllegalArgumentException();
        if (start > end) {
            throw new IllegalArgumentException();
        }

        this.date = date;

        this.description = description;

    }

    //-- accessor method for date
    public Date getDate() {
        return date;
    }

    //-- accessor method for start
    public int getStart() {
        return start;
    }

    //-- accessor method for end
    public int getEnd() {
        return end;
    }

    //-- accessor method for description
    public String getDescription() {
        return description;
    }

    //-- mutator method for description
    public void setDescription(String description) {
        this.description = description;
    }

    //-- This method returns the string version of event in month/day/year start--end: description format
    @Override
    public String toString() {
        return date.getMonth() + "/" + date.getDay() + "/" + date.getYear() + " " + start + "--" + end + ":" + description;
    }

    /*
     * This method checks for the equality of start, date, end, date and description for the two objects
     *
     * @param - obj, the Object type
     *
     * @returns - boolean
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Event)) return false;
        Event event = (Event) obj;
        return getStart() == event.getStart() &&
                getEnd() == event.getEnd() &&
                Objects.equals(getDate(), event.getDate()) &&
                Objects.equals(getDescription(), event.getDescription());
    }

}
