package com.example.coursauxsubbook;

import java.util.Date;

/**
 * Created by Jerrad on 2018-01-27.
 */

/**
 * represents a subscription
 */
public class Subscription {
    private String name;
    private Date date;
    private Float price;
    private String comment;

    /**
     * initializes with name, date, price, and comment
     *
     * @param name - subscription name
     * @param date - subscription date
     * @param price - subscription price
     * @param comment - subscription comment
     */
    Subscription( String name, Date date, Float price, String comment){
        this.name = name;
        this.date = date;
        this.price = price;
        this.comment = comment;
    }

    /**
     * to change the name of the subscription
     *
     * @param name - the new name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * to change the price of the subscription
     *
     * @param price - the new price
     */
    public void setPrice(Float price) {
        this.price = price;
    }

    /**
     * to change the comment on the subscription
     *
     * @param comment - the new comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * returns the name of the subscription
     *
     * @return - subscription name
     */
    public String getName() {
        return name;
    }

    /**
     * returns the date of the subscription
     *
     * @return - date
     */
    public Date getDate() {
        return date;
    }

    /**
     * returns the price of the subscription
     *
     * @return - price
     */
    public Float getPrice() {
        return price;
    }

    /**
     * returns the comment
     *
     * @return - comment
     */
    public String getComment() {
        return comment;
    }
}
