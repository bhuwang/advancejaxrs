/**
 * 
 */
package com.bhuwan.advancejaxrs.model;

/**
 * @author bhuwan
 *
 */
public class MyDate {

    private int date;
    private int month;
    private int year;

    /**
     * @return the date
     */
    public int getDate() {
        return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month
     *            the month to set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year
     *            the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MyDate [date=" + date + ", month=" + month + ", year=" + year + "]";
    }
}
