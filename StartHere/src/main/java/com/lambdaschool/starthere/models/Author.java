package com.lambdaschool.starthere.models;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String lastname;


    private String firstname;

    public Author() {
    }

    public Author(long authorid, String lastname, String firstname) {
        this.authorid = authorid;
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
