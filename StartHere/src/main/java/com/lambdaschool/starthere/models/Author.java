package com.lambdaschool.starthere.models;

import javax.persistence.*;

@Entity
@Table(name = "authors")
public class Author extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long authorid;

    private String lastnamel;

    private String firstname;

    public Author() {
    }

    public Author(long authorid, String lastnamel, String firstname) {
        this.authorid = authorid;
        this.lastnamel = lastnamel;
        this.firstname = firstname;
    }

    public long getAuthorid() {
        return authorid;
    }

    public void setAuthorid(long authorid) {
        this.authorid = authorid;
    }

    public String getLastnamel() {
        return lastnamel;
    }

    public void setLastnamel(String lastnamel) {
        this.lastnamel = lastnamel;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
