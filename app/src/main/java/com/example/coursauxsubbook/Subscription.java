package com.example.coursauxsubbook;

import java.util.Date;

/**
 * Created by Jerrad on 2018-01-27.
 */

public class Subscription {
    private String name;
    private Date date;
    private Float price;
    private String comment;

    Subscription( String name, Date date, Float price){
        this.name = name;
        this.date = date;
        this.price = price;
    }

    Subscription( String name, Date date, Float price, String comment){
        this.name = name;
        this.date = date;
        this.price = price;
        this.comment = comment;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Float getPrice() {
        return price;
    }

    public String getComment() {
        return comment;
    }
}
