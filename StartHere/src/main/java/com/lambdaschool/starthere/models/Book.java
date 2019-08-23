package com.lambdaschool.starthere.models;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookid;

    private String booktittle;

    private String isdn;

    private int copy;


    public Book() {
    }

    public Book(long bookid, String booktittle, String isdn, int copy) {
        this.bookid = bookid;
        this.booktittle = booktittle;
        this.isdn = isdn;
        this.copy = copy;
    }

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public String getBooktittle() {
        return booktittle;
    }

    public void setBooktittle(String booktittle) {
        this.booktittle = booktittle;
    }

    public String getIsdn() {
        return isdn;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }

    public int getCopy() {
        return copy;
    }

    public void setCopy(int copy) {
        this.copy = copy;
    }
}
