package com.uis.assignment.cs385.week1;

public class Date implements Comparable<Date> {

    //-- variable for year
    private int year;

    //-- variable for month
    private int month;

    //-- variable for day
    private int day;

    /*
     * Constructor for creating Date with given year, month and day.
     * It also checks for year to be between 2020-2030, month must be between 1-12
     * and day must be between 1-31
     *
     * @param - year
     *
     * @param - month
     *
     * @param - day
     *
     * @throws - IllegalArgumentException
     */
    public Date(int year, int month, int day) throws IllegalArgumentException {

        if (year >= 2020 && year <= 2030) {
            this.year = year;
        } else
            throw new IllegalArgumentException();
        if (month >= 1 && month <= 12) {
            this.month = month;
        } else
            throw new IllegalArgumentException();
        if (day >= 1 && day <= 31) {
            this.day = day;
        } else
            throw new IllegalArgumentException();
    }

    //-- accessor method for year
    public int getYear() {
        return year;
    }

    //-- accessor method for month
    public int getMonth() {
        return month;
    }

    //-- accessor method for day
    public int getDay() {
        return day;
    }

    //-- This method returns the string version of date in month/day/year format
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /*
     * This method checks for the equality of year, month and for the two objects
     *
     * @param - obj, the Object type
     *
     * @throw - IllegalArgumentException if obj is not an instance of Date
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Date)) throw new IllegalArgumentException();
        Date otherDate = (Date) obj;
        return getYear() == otherDate.getYear() &&
                getMonth() == otherDate.getMonth() &&
                getDay() == otherDate.getDay();
    }


    /* This method compares the two Date objects.
     *
     * @return:  -1, 0 or 1 based on either the two dates are less than, greater that or equal
     *
     */

    @Override
    public int compareTo(Date otherDate) {
        if (this.year != otherDate.year) {
            return (this.year < otherDate.year) ? -1 : (this.year > otherDate.year) ? 1 : 0;
        }
        if (this.month != otherDate.month) {
            return (this.month < otherDate.month) ? -1 : (this.month > otherDate.month) ? 1 : 0;
        } else
            return (this.day < otherDate.day) ? -1 : (this.day > otherDate.day) ? 1 : 0;

    }
}
